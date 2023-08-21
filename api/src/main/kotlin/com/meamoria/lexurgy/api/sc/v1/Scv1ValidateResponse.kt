package com.meamoria.lexurgy.api.sc.v1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed interface Scv1ValidateResponse

@Serializable
data class Scv1ValidateSuccessResponse(
    val ruleNames: List<String>
) : Scv1ValidateResponse

@Serializable
sealed interface Scv1ValidateErrorResponse : Scv1ValidateResponse

@Serializable
@SerialName("parseError")
data class Scv1ValidateParseErrorResponse(
    val message: String,
    val lineNumber: Int,
    val columnNumber: Int,
) : Scv1ValidateErrorResponse

@Serializable
@SerialName("invalidExpression")
data class Scv1ValidateInvalidExpressionResponse(
    val message: String?,
    val rule: String,
    val expression: String,
    val expressionNumber: Int,
) : Scv1ValidateErrorResponse

@Serializable
@SerialName("analysisError")
data class Scv1ValidateAnalysisErrorResponse(
    val message: String
) : Scv1ValidateErrorResponse
