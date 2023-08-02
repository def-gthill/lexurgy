package com.meamoria.lexurgy.sc.element

/**
 * An emitter that conjures part of a word out of nothing.
 * This means it doesn't need information from a connected
 * ``Matcher`` about what it matched.
 */
interface IndependentEmitter : Emitter {
    fun result(): UnboundResult

    override fun isConditional(): Boolean = false

    override fun isIndependent(): Boolean = true
}