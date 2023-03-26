package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

data class PhraseMatchEnd(
    val index: PhraseIndex,
    val returnBindings: Bindings,
    val matchedSyllableBreaks: List<PhraseIndex> = emptyList(),
    val isPartial: Boolean = false,
) : WithBindings<PhraseMatchEnd> {

    override fun replaceBindings(bindings: Bindings) =
        copy(returnBindings = bindings)

    override fun updateBindings(bindings: Bindings) =
        copy(returnBindings = returnBindings.combine(bindings))

    fun precededBy(previous: PhraseMatchEnd): PhraseMatchEnd =
        copy(
            matchedSyllableBreaks =
            (previous.matchedSyllableBreaks + matchedSyllableBreaks).distinct()
        )

    fun partial(): PhraseMatchEnd = copy(isPartial = true)
}