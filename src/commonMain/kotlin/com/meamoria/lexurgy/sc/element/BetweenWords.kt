package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.word.StandardWord
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

    override fun length(bindings: Bindings): Int = 0

    override fun reversed(): Matcher = this

    override fun toString(): String = "$$"
}

object BetweenWordsEmitter : IndependentEmitter {
    override fun result(): UnboundResult =
        UnboundResult.fromPhrase(Phrase(StandardWord.EMPTY, StandardWord.EMPTY))
}