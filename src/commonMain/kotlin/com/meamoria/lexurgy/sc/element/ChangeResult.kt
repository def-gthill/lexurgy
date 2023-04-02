package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.Matrix

/**
 * The result of a sound change at a specific spot in a word.
 * @property phrase The that needs to be substituted into the word.
 * @property emitsSyllableBreaks Relative indices into `phrase`
 * where syllable breaks have been explicitly emitted (rather than
 * just being recovered from the original word).
 * @property syllableFeatureChanges Syllable features that have
 * been explicitly set at each index (rather than just being
 * recovered from the original word).
 */
data class ChangeResult(
    val phrase: Phrase,
    val emitsSyllableBreaks: List<PhraseIndex>,
    val syllableFeatureChanges: Map<PhraseIndex, Matrix>,
) {
    val emitsSyllableBreakBefore: Boolean = emitsSyllableBreaks.firstOrNull() == phrase.firstIndex
    val emitsSyllableBreakAfter: Boolean = emitsSyllableBreaks.lastOrNull() == phrase.lastIndex
}

fun List<ChangeResult>.sequenceEmitsSyllableBreaks(): List<PhraseIndex> {
    val allBreaks = mutableListOf<PhraseIndex>()
    var start = PhraseIndex(0, 0)

    for (result in this) {
        allBreaks += result.emitsSyllableBreaks.map { breakIndex ->
            start + breakIndex
        }
        start += result.phrase.lastIndex
    }

    return allBreaks
}

fun List<ChangeResult>.sequenceSyllableFeatureChanges(): Map<PhraseIndex, Matrix> {
    val allChanges = mutableMapOf<PhraseIndex, Matrix>()
    var start = PhraseIndex(0, 0)

    for (result in this) {
        allChanges += result.syllableFeatureChanges.mapKeys { (index, _) ->
            start + index
        }
        start += result.phrase.lastIndex
    }

    return allChanges
}