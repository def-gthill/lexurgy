package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.LscUserError
import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

class NegatedMatcher(val matcher: Matcher) : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        if (matcher.length(bindings) != 1) {
            throw MultipleSegmentNegation(matcher)
        }
        val word = phrase[start.wordIndex]
        val index = start.segmentIndex
        return when {
            index >= word.length -> emptyList()
            matcher.claim(phrase, start, bindings).isEmpty() ->
                listOf(PhraseMatchEnd(start.copy(segmentIndex = index + 1), bindings))

            else -> emptyList()
        }
    }

    override fun reversed(): Matcher = NegatedMatcher(matcher.reversed())

    override fun toString(): String = "!$matcher"
}

class MultipleSegmentNegation(val matcher: Matcher) :
    LscUserError(
        "Can't negate \"$matcher\" because it doesn't necessarily match a single segment. " +
                "Specify the allowed length of matches using e.g. ([]*)&!($matcher)"
    )
