package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

/**
 * A matcher that doesn't match anything
 */
object NeverMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> = emptyList()

    override fun length(bindings: Bindings): Int? = null

    override fun reversed(): Matcher = this

    override fun toString(): String = "N/A"
}

/**
 * An emitter corresponding to a `NeverMatcher`, used by
 * the "unchanged" keyword. Since the `NeverMatcher` never
 * matches, `result` is never called.
 */
object NeverEmitter : IndependentEmitter {
    override fun result(): UnboundResult = throw AssertionError("A never-emitter can't emit")

    override fun toString(): String = "N/A"
}