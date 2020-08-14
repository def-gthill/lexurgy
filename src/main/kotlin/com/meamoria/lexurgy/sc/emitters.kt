package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

typealias UnboundResult<T> = (Bindings) -> Word<T>

interface Emitter<I : Segment<I>, O : Segment<O>>

class SequenceEmitter<I : Segment<I>, O : Segment<O>>(val elements: List<Emitter<I, O>>) : Emitter<I, O> {
    override fun toString(): String = elements.joinToString(separator = " ", prefix = "(", postfix = ")")
}

class ListEmitter<I : Segment<I>, O : Segment<O>>(val elements: List<Emitter<I, O>>) : Emitter<I, O> {
    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")
}

interface SimpleEmitter<I : Segment<I>, O : Segment<O>> : Emitter<I, O> {
    fun result(declarations: Declarations, matcher: SimpleMatcher<I>, original: Word<I>): UnboundResult<O>
}

class CaptureReferenceEmitter(val number: Int) : SimpleEmitter<PhonS, PhonS> {
    override fun result(
        declarations: Declarations, matcher: SimpleMatcher<PhonS>, original: Word<PhonS>
    ): UnboundResult<PhonS> =
        { bindings ->
            bindings.captures[number] ?: throw LscUnboundCapture(number)
        }
}

class MatrixEmitter(val matrix: Matrix) : SimpleEmitter<PhonS, PhonS> {
    override fun result(
        declarations: Declarations, matcher: SimpleMatcher<PhonS>, original: Word<PhonS>
    ): UnboundResult<PhonS> =
        { bindings ->
            with(declarations) {
                val boundMatrix = matrix.bindVariables(bindings)
                val matchMatrix = original[0].toMatrix() ?: Matrix(emptyList())
                val resultMatrix = matchMatrix.update(boundMatrix)
                Phonetic.fromSegments(listOf(resultMatrix.toSymbol()))
            }
        }

    override fun toString(): String = matrix.toString()
}

class SymbolEmitter<I : Segment<I>>(val text: Word<PhonS>) : SimpleEmitter<I, PhonS> {
    override fun result(
        declarations: Declarations, matcher: SimpleMatcher<I>, original: Word<I>
    ): UnboundResult<PhonS> {
        if (
            matcher is SymbolMatcher && original is PhoneticWord &&
            matcher.text.length == text.length && original.length == text.length
        ) {
            val result = with(declarations) {
                matcher.text.segments.zip3(
                    original.segments, text.segments
                ) { matcherSegment, originalSegment, textSegment ->
                    textSegment.withFloatingDiacriticsFrom(originalSegment, excluding = matcherSegment)
                }
            }
            return { Phonetic.fromSegments(result) }
        } else {
            return { text }
        }
    }

    override fun toString(): String = text.string.ifEmpty { "*" }
}

class TextEmitter<I : Segment<I>, O : Segment<O>>(val text: Word<O>) : SimpleEmitter<I, O> {
    override fun result(
        declarations: Declarations, matcher: SimpleMatcher<I>, original: Word<I>
    ): UnboundResult<O> {
        return { text }
    }

    override fun toString(): String = text.string.ifEmpty { "*" }
}

class NullEmitter<I : Segment<I>, O : Segment<O>>(val outType: SegmentType<O>) : SimpleEmitter<I, O> {
    override fun result(
        declarations: Declarations, matcher: SimpleMatcher<I>, original: Word<I>
    ): UnboundResult<O> =
        { outType.empty }

    override fun toString(): String = "*"
}
