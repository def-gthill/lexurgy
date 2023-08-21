package com.meamoria.lexurgy.api.sc.v1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed interface Scv1Response

@Serializable
data class Scv1SuccessResponse(
    val ruleNames: List<String>,
    val outputWords: List<String>,
    val intermediateWords: Map<String, List<String>> = emptyMap(),
    val traces: Map<String, List<TraceStep>> = emptyMap(),
    val errors: List<RuleFailure> = emptyList(),
) : Scv1Response

@Serializable
data class RuleFailure(
    val message: String,
    val rule: String? = null,
    val originalWord: String? = null,
    val currentWord: String? = null,
)

@Serializable
data class TraceStep(
    val rule: String,
    val output: String,
)

@Serializable
sealed interface Scv1ErrorResponse : Scv1Response

@Serializable
@SerialName("parseError")
data class Scv1ParseErrorResponse(
    val message: String,
    val lineNumber: Int,
    val columnNumber: Int,
) : Scv1ErrorResponse

@Serializable
@SerialName("invalidExpression")
data class Scv1InvalidExpressionResponse(
    val message: String?,
    val rule: String,
    val expression: String,
    val expressionNumber: Int,
) : Scv1ErrorResponse

@Serializable
@SerialName("analysisError")
data class Scv1AnalysisErrorResponse(
    val message: String
) : Scv1ErrorResponse
