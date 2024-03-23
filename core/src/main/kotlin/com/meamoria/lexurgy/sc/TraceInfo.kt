package com.meamoria.lexurgy.sc

data class TraceInfo(
    val ruleName: String,
    val originalWord: String,
    val wordBeforeChange: String,
    val wordAfterChange: String,
)