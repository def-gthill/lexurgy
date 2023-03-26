package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings
import com.meamoria.lexurgy.sc.PhraseMatchEnd
import com.meamoria.lexurgy.sc.SimpleMatcher

class NegatedMatcher(val matcher: Matcher) : SimpleMatcher() {
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
                listOf(PhraseMatchEnd(start.copy(segmentIndex = index + 1), bindings))
            else -> emptyList()
        }
    }

    override fun reversed(): Matcher = NegatedMatcher(matcher.reversed())

    override fun toString(): String = "!$matcher"
}
