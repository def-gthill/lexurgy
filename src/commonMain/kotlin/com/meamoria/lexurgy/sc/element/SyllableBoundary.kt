package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.word.StandardWord
import com.meamoria.lexurgy.sc.Bindings

object SyllableBoundaryMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        if (phrase.hasSyllableBoundaryAt(start)) {
            listOf(
                PhraseMatchEnd(start, bindings, listOf(start))
            )
        } else {
            emptyList()
        }

    override fun length(bindings: Bindings): Int = 0

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

object NegatedSyllableBoundaryMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        if (phrase.hasSyllableBoundaryAt(start)) {
            emptyList()
        } else {
            listOf(
                PhraseMatchEnd(start, bindings, listOf(start))
            )
        }

    override fun length(bindings: Bindings): Int = 0

    override fun reversed(): Matcher = this

    override fun toString(): String = "!."
}

private fun Phrase.hasSyllableBoundaryAt(phraseIndex: PhraseIndex): Boolean {
    val word = this[phraseIndex.wordIndex]
    val index = phraseIndex.segmentIndex
    return word.isSyllabified() &&
            (index == 0 || index == word.length || index in word.syllableBreaks)
}
