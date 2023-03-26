package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
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
        result.updateSyllableModifiers(syllableFeatureChanges) { existing, new ->
            with(declarations) {
                existing.toMatrix().update(new).toModifiers()
            }
        }
}