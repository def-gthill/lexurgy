package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.StandardWord
import com.meamoria.lexurgy.sc.Bindings

object SyllableBoundaryMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val word = phrase[start.wordIndex]
        val index = start.segmentIndex
        return if (word.isSyllabified()) {
            if (index == 0 || index == word.length || index in word.syllableBreaks) {
                listOf(
                    PhraseMatchEnd(start, bindings, listOf(start))
                )
            } else emptyList()
        } else emptyList()
    }

    override fun reversed(): Matcher = this

    override fun toString(): String = "."
}

object SyllableBoundaryEmitter : IndependentEmitter {
    override fun result(): UnboundResult =
        UnboundResult {
            ChangeResult(
                Phrase(StandardWord.SYLLABLE_BREAK_ONLY),
                listOf(PhraseIndex(0, 0)),
                emptyMap(),
            )
        }

    override fun toString(): String = "."
}