package com.meamoria.lexurgy.api.sc.v1

import com.meamoria.lexurgy.LscUserError
import com.meamoria.lexurgy.sc.LscInvalidRuleExpression
import com.meamoria.lexurgy.sc.LscNotParsable
import com.meamoria.lexurgy.sc.LscRuleNotApplicable
import com.meamoria.lexurgy.sc.SoundChanger

fun runScv1(request: Request): Response {
    val soundChanger = try {
        SoundChanger.fromLsc(request.changes)
    } catch (e: LscNotParsable) {
        return ParseErrorResponse(e.customMessage, e.line, e.column)
    } catch (e: LscInvalidRuleExpression) {
        return InvalidExpressionResponse(e.reason.message, e.rule, e.expression, e.expressionNumber)
    } catch (e: LscUserError) {
        return AnalysisErrorResponse(e.message ?: "An unknown error occurred")
    }

    return runScv1Using(soundChanger, request)
}

private fun runScv1Using(soundChanger: SoundChanger, request: Request): Response {
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
            timeoutSeconds = System.getenv("TIMEOUT")?.toDouble() ?: 0.5,
        )
    return SuccessResponse(
        ruleNames = soundChanger.ruleNames,
        outputWords = result.outputWords,
        intermediateWords = result.intermediateWords,
        traces = traces,
        errors = result.ruleFailures
    )
}

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
