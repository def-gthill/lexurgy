package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.*
import com.meamoria.lexurgy.zipAll

class SequenceMatcher(
    val declarations: Declarations,
    val elements: List<Matcher>
) : BaseMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        var ends = listOf(PhraseMatchEnd(start, bindings))
        for (element in elements) {
            val newEnds = ends.filter { !it.isPartial }.flatMap { end ->
                element.claim(
                    phrase, end.index, end.returnBindings, partial
                ).map { it.precededBy(end) }
            }.checkTooManyOptions()
            if (newEnds.isEmpty()) {
                return if (partial) ends.filter {
                    it.index > start
                }.map { it.partial() } else emptyList()
            }
            ends = newEnds
        }
        return ends
    }

    override fun length(bindings: Bindings): Int? =
        elements.sumOf { it.length(bindings) ?: return null }

    override fun reversed(): Matcher = SequenceMatcher(
        declarations,
        elements.asReversed().map { it.reversed() }
    )

    override fun toString(): String = elements.joinToString(separator = " ", prefix = "(", postfix = ")")

    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean
    ): Transformer {
        val matchAlternatives = elements.mapNotNull { it as? AlternativeMatcher }
        val resultSequences = result.elements.map { it as? SequenceEmitter }
        if (
            matchAlternatives.all { it.elements.size == result.elements.size } &&
            resultSequences.all { it != null && it.elements.size == elements.size }
        ) {
            val matchSequences = elements.map {
                when (it) {
                    is AlternativeMatcher -> it.elements
                    else -> generateSequence { it }.asIterable()
                }
            }.zipAll { SequenceMatcher(declarations, it) }
            return AlternativeTransformer(
                matchSequences,
                resultSequences.requireNoNulls(),
                filtered,
            )
        } else {
            mismatchedLengths(this, result, elements, listOf(result))
        }
    }

    override fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean
    ): Transformer = if (elements.size == result.elements.size) {
        SequenceTransformer(elements, result.elements, filtered)
    } else {
        mismatchedLengths(this, result, elements, result.elements)
    }

    override fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean
    ): Transformer = SequenceTransformer(
        elements, elements.map { result }, filtered
    )

    override fun prefersIndependentEmitters(): Boolean = true
}

class SequenceEmitter(val elements: List<Emitter>) : Emitter {
    override fun toString(): String =
        elements.joinToString(separator = " ", prefix = "(", postfix = ")")

    override fun isConditional(): Boolean = elements.any { it.isConditional() }

    override fun isIndependent(): Boolean = elements.all { it.isIndependent() }
}

class SequenceTransformer(
    val elements: List<Transformer>
) : Transformer {

    constructor(
        matchers: List<Matcher>,
        emitters: List<Emitter>,
        filtered: Boolean,
    ) : this(
        matchers.zip(emitters) { matcher, emitter ->
            matcher.transformerTo(emitter, filtered)
        },
    )

    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
    ): List<UnboundTransformation> {
        var resultBits = listOf(emptyList<UnboundTransformation>())
        for (element in elements) {
            resultBits = resultBits.flatMap { prev ->
                element.transform(
                    order, phrase,
                    prev.lastOrNull()?.end ?: start,
                    prev.lastOrNull()?.returnBindings ?: bindings,
                ).map {
                    prev + it
                }
            }.checkTooManyOptions()
            if (resultBits.isEmpty()) return emptyList()
        }

        return resultBits.map {
            UnboundTransformation.fromSubTransformations(
                order, start, bindings, it
            )
        }
    }

    override fun toString(): String = elements.joinToString(" ") { "($it)" }
}