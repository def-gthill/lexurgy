package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Segment
import com.meamoria.lexurgy.Word

typealias UnboundResult<T> = (Bindings) -> Word<T>

interface Emitter<I : Segment<I>, O : Segment<O>> {
    fun result(declarations: Declarations, original: Word<I>): UnboundResult<O>
}

interface SimpleEmitter<I : Segment<I>, O : Segment<O>> : Emitter<I, O>

class TextEmitter<I : Segment<I>, O : Segment<O>>(val text: Word<O>) : SimpleEmitter<I, O> {
    override fun result(declarations: Declarations, original: Word<I>): UnboundResult<O> =
        { text }
}
