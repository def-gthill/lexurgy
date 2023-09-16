package com.meamoria.lexurgy.api.sc.v1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed interface Response

@Serializable
data class SuccessResponse(
    val ruleNames: List<String>,
    val outputWords: List<String>,
    val intermediateWords: Map<String, List<String>> = emptyMap(),
    val traces: Map<String, List<TraceStep>> = emptyMap(),
    val errors: List<RuleFailure> = emptyList(),
) : Response

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
sealed interface ErrorResponse : Response

@Serializable
@SerialName("parseError")
data class ParseErrorResponse(
    val message: String,
    val lineNumber: Int,
    val columnNumber: Int,
) : ErrorResponse

@Serializable
@SerialName("invalidExpression")
data class InvalidExpressionResponse(
    val message: String?,
    val rule: String,
    val expression: String,
    val expressionNumber: Int,
) : ErrorResponse

@Serializable
@SerialName("analysisError")
data class AnalysisErrorResponse(
    val message: String
) : ErrorResponse

@Serializable
@SerialName("timeout")
data class TimeoutResponse(
    val message: String
) : ErrorResponse
