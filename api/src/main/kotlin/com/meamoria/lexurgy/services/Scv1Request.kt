package com.meamoria.lexurgy.services

import kotlinx.serialization.Serializable

@Serializable
data class Scv1Request(
    val changes: String,
    val inputWords: List<String>,
    val traceWords: List<String> = emptyList(),
    val startAt: String? = null,
    val stopBefore: String? = null,
)
