package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.LscUserError
import com.meamoria.lexurgy.Word

class Bindings(
    val features: Map<Feature, SimpleValue> = emptyMap(),
    val captures: Map<Int, Word> = emptyMap(),
) {
    fun bindFeature(feature: Feature, value: SimpleValue): Bindings =
        Bindings(
            features + (feature to value),
            captures,
        )

    fun bindCapture(number: Int, value: Word): Bindings =
        Bindings(
            features,
            captures + (number to value),
        )

    /**
     * Returns a ``Bindings`` that combines the bindings
     * from this and other
     */
    fun combine(other: Bindings): Bindings = Bindings(
        features + other.features,
        captures + other.captures,
    )

    override fun toString(): String = "$captures; $features"
}

class LscUnboundCapture(number: Int) : LscUserError("Capture variable $number referenced before being bound")

class LscReboundCapture(number: Int) : LscUserError(
    "Capture variable $number is bound more than once; replace the second with a capture reference (\"${'$'}$number\")"
)
