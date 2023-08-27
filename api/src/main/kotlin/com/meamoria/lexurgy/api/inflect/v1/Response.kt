package com.meamoria.lexurgy.api.inflect.v1

import kotlinx.serialization.Serializable

sealed interface Response

@Serializable
data class SuccessResponse(
    val inflectedForms: List<String>
) : Response

@Serializable
data class ErrorResponse(val message: String) : Response
