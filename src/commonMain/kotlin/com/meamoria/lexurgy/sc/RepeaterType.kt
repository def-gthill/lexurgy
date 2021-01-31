package com.meamoria.lexurgy.sc

enum class RepeaterType(val minReps: Int, val maxReps: Int?, val string: String) {
    ONE_OR_MORE(1, null, "+"),
    ZERO_OR_MORE(0, null, "*"),
    ZERO_OR_ONE(0, 1, "?")
}