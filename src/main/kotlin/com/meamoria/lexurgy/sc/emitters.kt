package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Phonetic
import com.meamoria.lexurgy.Segment
import com.meamoria.lexurgy.Word

typealias UnboundResult<T> = (Bindings) -> Word<T>

interface Emitter<I : Segment<I>, O : Segment<O>>

class SequenceEmitter<I : Segment<I>, O : Segment<O>>(val elements: List<Emitter<I, O>>) : Emitter<I, O>

class ListEmitter<I : Segment<I>, O : Segment<O>>(val elements: List<Emitter<I, O>>) : Emitter<I, O>

interface SimpleEmitter<I : Segment<I>, O : Segment<O>> : Emitter<I, O> {
    fun result(declarations: Declarations, original: Word<I>): UnboundResult<O>
}

class MatrixEmitter(val matrix: Matrix) : SimpleEmitter<PhonS, PhonS> {
    override fun result(declarations: Declarations, original: Word<PhonS>): UnboundResult<PhonS> =
        {bindings ->
            with(declarations) {
                val boundMatrix = matrix.bindVariables(bindings)
                val matchMatrix = original[0].toMatrix()!!
                val resultMatrix = matchMatrix.update(boundMatrix)
                Phonetic.fromSegments(listOf(resultMatrix.toSymbol()))
            }
        }
}

class TextEmitter<I : Segment<I>, O : Segment<O>>(val text: Word<O>) : SimpleEmitter<I, O> {
    override fun result(declarations: Declarations, original: Word<I>): UnboundResult<O> =
        { text }
}
