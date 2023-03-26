package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

object WordStartMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        if (start.segmentIndex == 0) {
            listOf(PhraseMatchEnd(start, bindings))
        } else emptyList()

    override fun reversed(): Matcher = WordEndMatcher

    override fun toString(): String = "$"
}

object WordEndMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        if (start.segmentIndex == phrase[start.wordIndex].length) {
            listOf(PhraseMatchEnd(start, bindings))
        } else emptyList()

    override fun reversed(): Matcher = WordStartMatcher

    override fun toString(): String = "$"
}