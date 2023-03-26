package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings
import com.meamoria.lexurgy.sc.Emitter
import com.meamoria.lexurgy.sc.PhraseMatchEnd
import com.meamoria.lexurgy.sc.Transformer

interface Matcher {
    fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean = false,
    ): List<PhraseMatchEnd>

    fun reversed(): Matcher

    /**
     * Makes a transformer that matches using this `Matcher` and uses the specified
     * `Emitter` to produce the result.
     * @param filtered: Whether the transformer is in a filtered rule
     */
    fun transformerTo(
        result: Emitter,
        filtered: Boolean,
    ): Transformer

    /**
     * Checks whether this matcher prefers to treat emitters as
     * independent (rather than conditional) if both interpretations
     * are possible.
     */
    fun prefersIndependentEmitters(): Boolean

    /**
     * Checks whether this matcher prefers to treat sequence emitters
     * as independent (rather than conditional) if both interpretations
     * are possible.
     */
    fun prefersIndependentSequenceEmitters(): Boolean

    fun <T> List<T>.checkTooManyOptions(): List<T> =
        com.meamoria.lexurgy.sc.checkTooManyOptions(this@Matcher, this)
}