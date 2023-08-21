package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.*

class RepeaterMatcher(
    val declarations: Declarations,
    val element: Matcher,
    val type: RepeaterType,
) : LiftingMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val result = mutableListOf(listOf(PhraseMatchEnd(start, bindings)))
        while (true) {
            val newResult = result.last().filter { !it.isPartial }.flatMap { end ->
                element.claim(
                    phrase, end.index, end.returnBindings, partial
                ).map { it.precededBy(end) }
            }.checkTooManyOptions()
            if (newResult.isEmpty()) break
            result += newResult
            if (type.maxReps != null && result.size > type.maxReps!!) break
        }
        val resultAboveMinReps = result.drop(type.minReps)
        return if (resultAboveMinReps.isEmpty()) {
            if (partial) {
                result.reversed().flatten().filter {
                    it.index > start
                }.map { it.partial() }
            } else {
                emptyList()
            }
        } else {
            resultAboveMinReps.reversed().flatten()
        }
    }

    override fun length(bindings: Bindings): Int? = null

    override fun reversed(): Matcher =
        RepeaterMatcher(
            declarations,
            element.reversed(),
            type,
        )

    override fun toString(): String = "$element${type.string}"

    override fun liftingTransformerTo(
        result: Emitter,
        filtered: Boolean
    ): Transformer = RepeaterTransformer(this, result, filtered)

    override fun prefersIndependentEmitters(): Boolean = true

    override fun prefersIndependentSequenceEmitters(): Boolean = true
}

class RepeaterTransformer(
    val transformer: Transformer,
    val type: RepeaterType,
) : Transformer {

    constructor(
        matcher: RepeaterMatcher,
        emitter: Emitter,
        filtered: Boolean,
    ) : this(
        matcher.element.transformerTo(emitter, filtered),
        matcher.type,
    )

    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> {
        val resultBits = mutableListOf(listOf(emptyList<UnboundTransformation>()))
        while (true) {
            val newResultBits = resultBits.last().flatMap { prev ->
                transformer.transform(
                    order, phrase,
                    prev.lastOrNull()?.end ?: start,
                    prev.lastOrNull()?.returnBindings ?: bindings
                ).map {
                    prev + it
                }
            }.checkTooManyOptions()
            if (newResultBits.isEmpty()) break
            resultBits += newResultBits
            if (type.maxReps != null && resultBits.size > type.maxReps!!) break
        }

        return resultBits.drop(type.minReps).reversed().flatten().map {
            UnboundTransformation.fromSubTransformations(
                order, start, bindings, it
            )
        }
    }

    override fun toString(): String = "($transformer)${type.string}"
}