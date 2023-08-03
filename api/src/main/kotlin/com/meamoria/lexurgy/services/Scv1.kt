package com.meamoria.lexurgy.services

import com.meamoria.lexurgy.LscUserError
import com.meamoria.lexurgy.sc.LscInvalidRuleExpression
import com.meamoria.lexurgy.sc.LscNotParsable
import com.meamoria.lexurgy.sc.LscRuleNotApplicable
import com.meamoria.lexurgy.sc.SoundChanger

fun runScv1(request: Scv1Request): Scv1Response {
    val soundChanger = try {
        SoundChanger.fromLsc(request.changes)
    } catch (e: LscNotParsable) {
        return Scv1ParseErrorResponse(e.customMessage, e.line, e.column)
    } catch (e: LscInvalidRuleExpression) {
        return Scv1InvalidExpressionResponse(e.reason.message, e.rule, e.expression, e.expressionNumber)
    } catch (e: LscUserError) {
        return Scv1AnalysisErrorResponse(e.message ?: "An unknown error occurred")
    }

    return runScv1Using(soundChanger, request)
}

private fun runScv1Using(soundChanger: SoundChanger, request: Scv1Request): Scv1Response {
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
            trace = ::trace,
            timeoutSeconds = System.getenv("TIMEOUT")?.toDouble() ?: 0.5,
        )
    return Scv1SuccessResponse(
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

fun runScv1Validate(request: Scv1ValidateRequest): Scv1ValidateResponse {
    val soundChanger = try {
        SoundChanger.fromLsc(request.changes)
    } catch (e: LscNotParsable) {
        return Scv1ValidateParseErrorResponse(e.customMessage, e.line, e.column)
    } catch (e: LscInvalidRuleExpression) {
        return Scv1ValidateInvalidExpressionResponse(e.reason.message, e.rule, e.expression, e.expressionNumber)
    } catch (e: LscUserError) {
        return Scv1ValidateAnalysisErrorResponse(e.message ?: "An unknown error occurred")
    }

    return Scv1ValidateSuccessResponse(soundChanger.ruleNames)
}
