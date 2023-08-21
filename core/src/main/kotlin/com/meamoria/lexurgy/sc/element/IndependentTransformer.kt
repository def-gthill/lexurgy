package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

class IndependentTransformer(
    val matcher: Matcher,
    val emitter: IndependentEmitter,
) : Transformer {
    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> =
        matcher.claim(phrase, start, bindings).map { claimEnd ->
            val unboundResult = UnboundResult { bindings ->
                val result = emitter.result().bind(bindings)
                val resultPhrase = phrase.slice(start, claimEnd.index).recoverStructure(
                    result.phrase,
                    exceptSyllableBreaks = claimEnd.matchedSyllableBreaks.map {
                        it - start
                    }
                )
                ChangeResult(
                    resultPhrase,
                    result.emitsSyllableBreaks,
                    result.syllableFeatureChanges,
                )
            }

            UnboundTransformation(
                order,
                start,
                claimEnd.index,
                unboundResult,
                claimEnd.returnBindings,
                removesSyllableBreaks = claimEnd.matchedSyllableBreaks,
            )
        }

    override fun toString(): String = "$matcher => $emitter"
}