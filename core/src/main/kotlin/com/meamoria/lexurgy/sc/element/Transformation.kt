package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.Declarations
import com.meamoria.lexurgy.sc.Matrix

/**
 * An instruction to replace a part of a phrase with new sounds.
 * @param order: The precedence order of the transformation - lower numbers are applied first.
 * @param start: The first index of the original phrase that needs to be replaced.
 * @param end: The first index of the original phrase after the end of section to be replaced.
 * @param result: The new phrase to insert.
 * @param subs: Sub-transformations, if any.
 * @param removesSyllableBreaks: List of syllable break indices that were explicitly
 * matched and need to be suppressed in the output.
 */
data class Transformation(
    val order: Int,
    val start: PhraseIndex,
    val end: PhraseIndex,
    val result: Phrase,
    val subs: List<Transformation> = emptyList(),
    val removesSyllableBreaks: List<PhraseIndex> = emptyList(),
    val syllableFeatureChanges: Map<PhraseIndex, Matrix> = emptyMap(),
) {
    val removesSyllableBreakBefore: Boolean = removesSyllableBreaks.firstOrNull() == start
    val removesSyllableBreakAfter: Boolean = removesSyllableBreaks.lastOrNull() == end

    val elementalSubs: List<Transformation>
        get() = if (subs.isEmpty()) listOf(this) else subs.flatMap { it.elementalSubs }

    /**
     * The result of the transformation, applying explicit changes
     * (e.g. syllable feature changes)
     */
    fun finalResult(declarations: Declarations): Phrase =
        with(declarations) {
            result.updateSyllableModifiers(syllableFeatureChanges)
        }
}

/**
 * An instruction to replace a part of a phrase with new sounds
 * @param order: The precedence order of the transformation - lower numbers are applied first.
 * @param start: The first index of the original phrase that needs to be replaced.
 * @param end: The first index of the original phrase after the end of section to be replaced.
 * @param result: The new phrase to insert, or the error that happened while trying to produce it.
 * @param subs: Sub-transformations, if any.
 * @param removesSyllableBreaks: List of syllable break indices that were explicitly
 * matched and need to be suppressed in the output.
 */
data class TransformationCatching(
    val order: Int,
    val start: PhraseIndex,
    val end: PhraseIndex,
    val result: Result<ChangeResult>,
    val subs: List<TransformationCatching> = emptyList(),
    val removesSyllableBreaks: List<PhraseIndex> = emptyList(),
) {

    fun throwing(): Transformation {
        val boundResult = result.getOrThrow()
        return Transformation(
            order,
            start,
            end,
            boundResult.phrase,
            subs.map { it.throwing() },
            removesSyllableBreaks,
            boundResult.syllableFeatureChanges,
        )
    }
}
