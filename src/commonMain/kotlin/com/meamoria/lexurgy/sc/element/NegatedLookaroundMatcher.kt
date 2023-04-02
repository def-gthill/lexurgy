package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

/**
 * A matcher that checks that its inner matcher *doesn't* match, but
 * doesn't consume any segments. Unlike a normal `NegatedMatcher`, it
 * can negate any element.
 */
class NegatedLookaroundMatcher(val matcher: Matcher) : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val word = phrase[start.wordIndex]
        val index = start.segmentIndex
        return when {
            index >= word.length -> emptyList()
            matcher.claim(phrase, start, bindings).isEmpty() ->
                listOf(PhraseMatchEnd(start, bindings))

            else -> emptyList()
        }
    }

    override fun length(bindings: Bindings): Int = 0

    override fun reversed(): Matcher = NegatedLookaroundMatcher(matcher.reversed())

    override fun toString(): String = "!$matcher"
}