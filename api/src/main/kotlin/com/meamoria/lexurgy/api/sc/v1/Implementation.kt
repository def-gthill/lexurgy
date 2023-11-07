package com.meamoria.lexurgy.api.sc.v1

import com.meamoria.lexurgy.LscUserError
import com.meamoria.lexurgy.UserError
import com.meamoria.lexurgy.sc.*
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import kotlin.concurrent.schedule

fun runScv1(
    request: Request,
    timeoutSettings: TimeoutSettings,
): Response {
    val soundChanger = try {
        SoundChanger.fromLsc(request.changes)
    } catch (e: LscNotParsable) {
        return ParseErrorResponse(e.customMessage, e.line, e.column)
    } catch (e: LscInvalidRuleExpression) {
        return InvalidExpressionResponse(e.reason.message, e.rule, e.expression, e.expressionNumber)
    } catch (e: LscUserError) {
        return AnalysisErrorResponse(e.message ?: "An unknown error occurred")
    }

    return if (request.allowPolling) {
        val job = SoundChangerJob(
            soundChanger,
            request,
            timeoutSettings,
        )
        val result = job.start()
        if (result == null) {
            val jobId = UUID.randomUUID()
            soundChangerJobs[jobId] = job
            RunningInBackgroundResponse("/scv1/poll/${jobId}")
        } else {
            result
        }
    } else {
        try {
            runScv1Using(
                soundChanger,
                request,
                singleStepTimeoutSeconds = timeoutSettings.singleStepTimeoutSeconds,
                totalTimeoutSeconds = timeoutSettings.requestTimeoutSeconds,
            )
        } catch (e: UserError) {
            RuntimeErrorResponse(e.message ?: "An unknown error occurred")
        } catch (e: RunTimedOut) {
            TimeoutResponse(e.message ?: "Run timed out")
        }
    }
}

fun pollScv1(jobId: String): PollResponse {
    val uuid = UUID.fromString(jobId)
    val job = soundChangerJobs[uuid] ?: return ExpiredResponse
    if (job.result != null) {
        timer.schedule(60000) {
            soundChangerJobs.remove(uuid)
        }
    }
    return when (val result = job.result) {
        null -> WorkingResponse
        is SuccessResponse -> DoneResponse(result)
        is ErrorResponse -> DoneWithErrorResponse(result)
        else -> throw AssertionError("Can't start polling within polling")
    }
}

private val soundChangerJobs: MutableMap<UUID, SoundChangerJob> = ConcurrentHashMap()

private val timer = Timer(true)

private class SoundChangerJob(
    val soundChanger: SoundChanger,
    val request: Request,
    val timeoutSettings: TimeoutSettings,
) {
    @Volatile
    private var _result: Response? = null

    fun start(): Response? {
        val latch = CountDownLatch(1)
        val thread = Thread {
            _result = try {
                runScv1Using(
                    soundChanger,
                    request,
                    singleStepTimeoutSeconds = timeoutSettings.singleStepTimeoutSeconds,
                    totalTimeoutSeconds = timeoutSettings.totalTimeoutSeconds,
                )
            } catch (e: UserError) {
                RuntimeErrorResponse(e.message ?: "An unknown error occurred")
            } catch (e: RunTimedOut) {
                TimeoutResponse(e.message ?: "Run timed out")
            }
            latch.countDown()
        }
        thread.start()

        timer.schedule((timeoutSettings.requestTimeoutSeconds * 1000).toLong()) {
            latch.countDown()
        }
        latch.await()
        return _result
    }

    val result
        get() = _result
}

private fun runScv1Using(
    soundChanger: SoundChanger,
    request: Request,
    singleStepTimeoutSeconds: Double,
    totalTimeoutSeconds: Double? = null,
): SuccessResponse {
    val traces = mutableMapOf<String, MutableList<TraceStep>>()

    fun trace(traceInfo: SoundChanger.TraceInfo) {
        traces
            .getOrPut(traceInfo.originalWord) { mutableListOf() }
            .add(TraceStep(traceInfo.ruleName, traceInfo.wordAfterChange))
    }

    val result = soundChanger
        .changeWithIntermediatesAndIndividualErrors(
            words = request.inputWords,
            startAt = request.startAt,
            stopBefore = request.stopBefore,
            debugWords = request.traceWords,
            debug = { },
            trace = ::trace,
            singleStepTimeoutSeconds = singleStepTimeoutSeconds,
            totalTimeoutSeconds = totalTimeoutSeconds,
        )
    return SuccessResponse(
        ruleNames = soundChanger.ruleNames,
        outputWords = result.outputWords,
        intermediateWords = result.intermediateWords,
        traces = traces,
        errors = result.ruleFailures
    )
}

data class TimeoutSettings(
    val singleStepTimeoutSeconds: Double,
    val requestTimeoutSeconds: Double,
    val totalTimeoutSeconds: Double,
)

private typealias ScResult = Map<String?, List<Result<String>>>

private val ScResult.outputWords: List<String>
    get() = getValue(null).map { it.getOrElse { "ERROR" } }

private val ScResult.intermediateWords: Map<String, List<String>>
    get() =
        this
            .filterKeys { it != null }
            .map { (stage, words) ->
                stage as String to words.map { it.getOrElse { "ERROR" } }
            }
            .toMap()

private val ScResult.ruleFailures: List<RuleFailure>
    get() =
        this
            .getValue(null)
            .mapNotNull {
                it.exceptionOrNull()?.let { e ->
                    when (e) {
                        is LscRuleNotApplicable ->
                            RuleFailure(
                                e.reason.message ?: "",
                                e.rule,
                                e.originalWord,
                                e.currentWord,
                            )

                        else ->
                            RuleFailure(
                                e.message ?: "Something went horribly wrong"
                            )
                    }
                }
            }

fun runScv1Validate(request: ValidateRequest): ValidateResponse {
    val soundChanger = try {
        SoundChanger.fromLsc(request.changes)
    } catch (e: LscNotParsable) {
        return ValidateParseErrorResponse(e.customMessage, e.line, e.column)
    } catch (e: LscInvalidRuleExpression) {
        return ValidateInvalidExpressionResponse(e.reason.message, e.rule, e.expression, e.expressionNumber)
    } catch (e: LscUserError) {
        return ValidateAnalysisErrorResponse(e.message ?: "An unknown error occurred")
    }

    return ValidateSuccessResponse(soundChanger.ruleNames)
}
