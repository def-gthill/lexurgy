package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

/**
 * A matcher that looks for text equal to the output of the specified
 * emitter
 */
class EmitterMatcher(
    val emitter: IndependentEmitter,
    val isReversed: Boolean = false,
) : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val emitterResult = emitter.result()
        val resultPhrase = emitterResult.bind(bindings).phrase.fullyReversedIf(isReversed)
        val matchEnd = phrase.matchSubPhrase(start, resultPhrase) ?: return emptyList()
        return listOf(PhraseMatchEnd(matchEnd, bindings))
    }

    override fun reversed(): Matcher = EmitterMatcher(emitter, !isReversed)
}