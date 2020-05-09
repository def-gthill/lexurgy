package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Segment
import com.meamoria.lexurgy.Word

interface Transformer<I : Segment<I>, O : Segment<O>> {
    fun transform(
        order: Int, declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings
    ): UnboundTransformation<O>?
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
        get() = if (subs.isEmpty()) listOf(this) else subs.flatMap { it.subs }
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