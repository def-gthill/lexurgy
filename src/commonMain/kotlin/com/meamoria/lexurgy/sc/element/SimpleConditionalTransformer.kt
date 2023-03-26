package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

class SimpleConditionalTransformer(
    val matcher: SimpleMatcher,
    val emitter: ConditionalEmitter,
) : Transformer {
    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
    ): List<UnboundTransformation> =
        matcher.claim(phrase, start, bindings).map { claimEnd ->
            val claim = phrase.slice(start, claimEnd.index)
            val result = emitter.result(matcher, claim)
            UnboundTransformation(
                order,
                start,
                claimEnd.index,
                result,
                claimEnd.returnBindings,
                removesSyllableBreaks = claimEnd.matchedSyllableBreaks,
            )
        }

    override fun toString(): String = "$matcher => $emitter"
}