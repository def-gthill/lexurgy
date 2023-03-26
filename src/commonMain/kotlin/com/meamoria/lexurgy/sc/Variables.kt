package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.LscUserError
import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.sc.element.Matcher

class Bindings(
    val features: Map<Feature, SimpleValue> = emptyMap(),
    val captures: Map<Int, Capture> = emptyMap(),
) {
    fun bindFeature(feature: Feature, value: SimpleValue): Bindings =
        Bindings(
            features + (feature to value),
            captures,
        )

    fun bindCapture(number: Int, value: Capture): Bindings =
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

data class Capture(val matcher: Matcher, val matchedPhrase: Phrase)

class LscUnboundCapture(number: Int) : LscUserError("Capture variable $number referenced before being bound")

class LscReboundCapture(number: Int) : LscUserError(
    "Capture variable $number is bound more than once; replace the second with a capture reference (\"${'$'}$number\")"
)
