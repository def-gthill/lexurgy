package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Word

class Bindings {
    val features: MutableMap<Feature, SimpleValue> = mutableMapOf()
    val captures: MutableMap<Int, Word<PhonS>> = mutableMapOf()

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

class LscUnboundCapture(number: Int) : Exception("Capture variable $number referenced before being bound")