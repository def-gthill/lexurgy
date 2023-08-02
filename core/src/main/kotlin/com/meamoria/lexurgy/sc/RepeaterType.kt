package com.meamoria.lexurgy.sc

sealed interface RepeaterType {
    val minReps: Int

    val maxReps: Int?

    val string: String
}

data class FlexibleRepeaterType(
    override val minReps: Int,
    override val maxReps: Int?,
) : RepeaterType {
    override val string: String =
        "*(${if (minReps > 0) minReps else ""}-${maxReps ?: ""})"
}

enum class StandardRepeaterType(
    override val minReps: Int,
    override val maxReps: Int?,
    override val string: String
) : RepeaterType {
    ONE_OR_MORE(1, null, "+"),
    ZERO_OR_MORE(0, null, "*"),
    ZERO_OR_ONE(0, 1, "?")
}