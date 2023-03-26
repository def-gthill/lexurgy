package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.StandardWord
import com.meamoria.lexurgy.sc.Bindings

object BetweenWordsMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val (startWord, startIndex) = start
        return if (startWord < phrase.size - 1 && startIndex == phrase[startWord].length) {
            listOf(PhraseMatchEnd(PhraseIndex(startWord + 1, 0), bindings))
        } else emptyList()
    }

    override fun reversed(): Matcher = this

    override fun toString(): String = "$$"
}

object BetweenWordsEmitter : IndependentEmitter {
    override fun result(): UnboundResult =
        UnboundResult.fromPhrase(Phrase(StandardWord.EMPTY, StandardWord.EMPTY))
}