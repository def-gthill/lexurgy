package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.LscUserError
import com.meamoria.lexurgy.Word

class Bindings {
    val features: MutableMap<Feature, SimpleValue> = mutableMapOf()
    val captures: MutableMap<Int, Word> = mutableMapOf()

    fun copy(): Bindings = Bindings().also {
        it.features += this.features
        it.captures += this.captures
    }

    /**
     * Import bindings from ``other``, preserving this object's content
     */
    fun combine(other: Bindings) {
        features += other.features
        captures += other.captures
    }
}

class LscUnboundCapture(number: Int) : LscUserError("Capture variable $number referenced before being bound")

class LscReboundCapture(number: Int) : LscUserError(
    "Capture variable $number is bound more than once; replace the second with a capture reference (\"${'$'}$number\")"
)
