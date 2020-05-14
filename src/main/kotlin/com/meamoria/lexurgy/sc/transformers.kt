package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Segment
import com.meamoria.lexurgy.SegmentType
import com.meamoria.lexurgy.Word

interface Transformer<I : Segment<I>, O : Segment<O>> {
    fun transform(
        order: Int, declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings
    ): UnboundTransformation<O>?
}

class SequenceTransformer<I : Segment<I>, O : Segment<O>>(
    val outType: SegmentType<O>,
    val elements: List<Transformer<I, O>>
) : Transformer<I, O> {
    override fun transform(
        order: Int, declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings
    ): UnboundTransformation<O>? {
        var elementStart = start
        val resultBits = mutableListOf<UnboundTransformation<O>>()
        for (element in elements) {
            val transformation = element.transform(order, declarations, word, elementStart, bindings) ?: return null
            elementStart += transformation.length
            resultBits += transformation
        }

        fun result(finalBindings: Bindings): Word<O> =
            outType.join(resultBits.map { it.result(finalBindings) })

        return UnboundTransformation(order, start, elementStart - start, ::result, resultBits)
    }
}

class ListTransformer<I : Segment<I>, O : Segment<O>>(
    val elements: List<Transformer<I, O>>
) : Transformer<I, O> {
    override fun transform(
        order: Int, declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings
    ): UnboundTransformation<O>? {
        for (element in elements) {
            val altBindings = bindings.copy()
            element.transform(order, declarations, word, start, altBindings)?.let {
                bindings.combine(altBindings)
                return it
            }
        }
        return null
    }
}

class SimpleTransformer<I : Segment<I>, O : Segment<O>>(
    val matcher: SimpleMatcher<I>,
    val emitter: SimpleEmitter<I, O>
) : Transformer<I, O> {
    override fun transform(
        order: Int, declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings
    ): UnboundTransformation<O>? {
        val claimEnd = matcher.claim(declarations, word, start, bindings) ?: return null
        val claim = word.slice(start until claimEnd)
        val result = emitter.result(declarations, claim)
        return UnboundTransformation(order, start, claimEnd - start, result)
    }
}

data class Transformation<O : Segment<O>>(
    val order: Int, val start: Int, val length: Int, val result: Word<O>,
    val subs: List<Transformation<O>> = emptyList()
) {
    val end = start + length

    val elementalSubs: List<Transformation<O>>
        get() = if (subs.isEmpty()) listOf(this) else subs.flatMap { it.elementalSubs }
}

data class UnboundTransformation<O : Segment<O>>(
    val order: Int, val start: Int, val length: Int, val result: UnboundResult<O>,
    val subs: List<UnboundTransformation<O>> = emptyList()
) {
    val end = start + length

    fun bindVariables(bindings: Bindings): Transformation<O> =
        Transformation(
            order, start, length, result(bindings), subs.map { it.bindVariables(bindings) }
        )
}