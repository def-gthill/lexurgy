package com.meamoria.lexurgy.sc

class Bindings {
    val features: MutableMap<Feature, SimpleValue> = mutableMapOf()

    fun copy(): Bindings = Bindings().also {
        it.features += this.features
    }

    /**
     * Import bindings from ``other``, preserving this object's content
     */
    fun combine(other: Bindings) {
        features += other.features
    }
}