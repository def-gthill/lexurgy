package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

class IndependentSequenceTransformer(
    val matcher: Matcher,
    val emitter: SequenceEmitter,
) : Transformer {
    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> =
        matcher.claim(phrase, start, bindings).map { claimEnd ->
            val transformationBits = emitter.resultBits(
                order, start, claimEnd
            )

            val unboundResult = UnboundResult { bindings ->
                val results = transformationBits.map { it.result.bind(bindings) }

                val resultPhrase = phrase.slice(start, claimEnd.index).recoverStructure(
                    Phrase.fromSubPhrases(results.map { it.phrase }),
                    exceptSyllableBreaks = claimEnd.matchedSyllableBreaks.map {
                        it - start
                    },
                )
                val resultEmitsSyllableBreaks = results.sequenceEmitsSyllableBreaks()
                val resultSyllableFeatureChanges = results.sequenceSyllableFeatureChanges()

                ChangeResult(
                    resultPhrase,
                    resultEmitsSyllableBreaks,
                    resultSyllableFeatureChanges,
                )
            }

            UnboundTransformation(
                order,
                start,
                claimEnd.index,
                unboundResult,
                claimEnd.returnBindings,
                transformationBits,
                removesSyllableBreaks = claimEnd.matchedSyllableBreaks,
            )
        }

    private fun SequenceEmitter.resultBits(
        order: Int,
        start: PhraseIndex,
        claimEnd: PhraseMatchEnd,
    ): List<UnboundTransformation> =
        elements.flatMap {
            when (it) {
                is SequenceEmitter -> it.resultBits(order, start, claimEnd)
                else -> listOf(
                    UnboundTransformation(
                        order,
                        start,
                        claimEnd.index,
                        (it as IndependentEmitter).result(),
                        claimEnd.returnBindings,
                    )
                )
            }
        }
}