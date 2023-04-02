package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.word.Word
import com.meamoria.lexurgy.sc.Matrix

class MultiConditionalEmitter(
    val elements: List<ConditionalEmitter>,
) : ConditionalEmitter {
    override fun result(
        matcher: SimpleMatcher,
        original: Phrase
    ): UnboundResult =
        UnboundResult { bindings ->
            var currentPhrase = original
            var currentEmitsSyllableBreaks = emptyList<PhraseIndex>()
            var currentSyllableFeatureChanges = emptyMap<PhraseIndex, Matrix>()
            for (element in elements) {
                val result = element.result(matcher, currentPhrase).bind(bindings)
                currentPhrase = result.phrase
                currentEmitsSyllableBreaks = result.emitsSyllableBreaks
                currentSyllableFeatureChanges = result.syllableFeatureChanges
            }
            ChangeResult(
                currentPhrase,
                currentEmitsSyllableBreaks,
                currentSyllableFeatureChanges
            )
        }

    override fun result(
        matcher: SimpleMatcher,
        original: Word,
    ): UnboundResult =
        result(matcher, Phrase(original))
}