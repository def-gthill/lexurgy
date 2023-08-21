package com.meamoria.lexurgy.api.inflect.v1

import kotlinx.serialization.Serializable

@Serializable
data class Request(
    val rules: String,
    val stemsAndCategories: List<StemAndCategories>
)

@Serializable
data class StemAndCategories(
    val stem: String,
    val categories: List<String>
)
