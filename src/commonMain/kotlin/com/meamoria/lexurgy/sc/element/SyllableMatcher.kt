package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings
import com.meamoria.lexurgy.sc.LscIllegalStructureInFilteredRuleInput

object SyllableMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val word = phrase[start.wordIndex]
        if (!word.isSyllabified()) return emptyList()
        if (word.isEmpty()) return emptyList()

        val index = start.segmentIndex
        val syllableIndex = word.syllableBreaks.indexOf(index)
        return listOfNotNull(
            when {
                // Match the entire word if it's only one syllable and we're at the beginning
                index == 0 && word.numSyllables == 1 -> word.length
                // Match up to the first syllable break if we're at the beginning
                index == 0 -> word.syllableBreaks[0]
                // Fail to match if we're in the middle of a syllable
                syllableIndex < 0 -> null
                // Match up to the end of the word if we're at the last syllable break
                syllableIndex + 1 == word.syllableBreaks.size -> word.length
                // Otherwise, we're at the start of a mid-word syllable; match up to the next syllable break
                else -> word.syllableBreaks[syllableIndex + 1]
            }
        ).map { PhraseMatchEnd(start.copy(segmentIndex = it), bindings) }
    }

    override fun reversed(): Matcher = this

    override fun checkValidInFilterIfEmitterIs(result: Emitter) =
        throw LscIllegalStructureInFilteredRuleInput(
            "a syllable element",
            "<syl>",
        )

    override fun toString(): String = "<syl>"
}