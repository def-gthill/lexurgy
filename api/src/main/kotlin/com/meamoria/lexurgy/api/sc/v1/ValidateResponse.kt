package com.meamoria.lexurgy.api.sc.v1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed interface ValidateResponse

@Serializable
data class ValidateSuccessResponse(
    val ruleNames: List<String>
) : ValidateResponse

@Serializable
sealed interface ValidateErrorResponse : ValidateResponse

@Serializable
@SerialName("parseError")
data class ValidateParseErrorResponse(
    val message: String,
    val lineNumber: Int,
    val columnNumber: Int,
) : ValidateErrorResponse

@Serializable
@SerialName("invalidExpression")
data class ValidateInvalidExpressionResponse(
    val message: String?,
    val rule: String,
    val expression: String,
    val expressionNumber: Int,
) : ValidateErrorResponse

@Serializable
@SerialName("analysisError")
data class ValidateAnalysisErrorResponse(
    val message: String
) : ValidateErrorResponse
