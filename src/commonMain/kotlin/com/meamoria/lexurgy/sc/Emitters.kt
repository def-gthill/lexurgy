package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

typealias UnboundResult<T> = (Bindings) -> List<Word<T>>

/**
 * A device that produces segments in the output word.
 * Emitters can be either *conditional* (they depend on
 * the match result) or *independent* (they don't need
 * the match result). It's possible for an emitter to
 * be both conditional and independent, which means
 * it will change its output to suit the match result but also
 * has a reasonable default if the match result isn't available.
 */
interface Emitter<I : Segment<I>, O : Segment<O>> {
    /**
     * Tests if this emitter is conditional, i.e. its output
     * depends on the match result.
     */
    fun isConditional(): Boolean

    /**
     * Tests if this emitter is independent, i.e. it can
     * produce output without knowing the match result.
     */
    fun isIndependent(): Boolean
}

class SequenceEmitter<I : Segment<I>, O : Segment<O>>(val elements: List<Emitter<I, O>>) : Emitter<I, O> {
    override fun toString(): String = elements.joinToString(separator = " ", prefix = "(", postfix = ")")

    override fun isConditional(): Boolean = elements.any { it.isConditional() }

    override fun isIndependent(): Boolean = elements.all { it.isIndependent() }
}

class AlternativeEmitter<I : Segment<I>, O : Segment<O>>(val elements: List<Emitter<I, O>>) : Emitter<I, O> {
    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")

    override fun isConditional(): Boolean = true

    override fun isIndependent(): Boolean = false
}

/**
 * An emitter that conjures part of a word out of nothing.
 * This means it doesn't need information from a connected
 * ``Matcher`` about what it matched.
 */
interface IndependentEmitter<I : Segment<I>, O : Segment<O>> : Emitter<I, O> {
    fun result(): UnboundResult<O>

    override fun isConditional(): Boolean = false

    override fun isIndependent(): Boolean = true
}

/**
 * An emitter whose result depends on a connected ``Matcher``.
 */
interface ConditionalEmitter<I : Segment<I>, O : Segment<O>> : Emitter<I, O> {
    fun result(
        declarations: Declarations,
        matcher: SimpleMatcher<I>,
        original: List<Word<I>>
    ): UnboundResult<O> = result(declarations, matcher, original.first())

    fun result(
        declarations: Declarations,
        matcher: SimpleMatcher<I>,
        original: Word<I>
    ): UnboundResult<O>

    override fun isConditional(): Boolean = true

    override fun isIndependent(): Boolean = false
}

class CaptureReferenceEmitter(val number: Int) : IndependentEmitter<PhonS, PhonS> {
    override fun result(): UnboundResult<PhonS> =
        { bindings ->
            listOf(bindings.captures[number] ?: throw LscUnboundCapture(number))
        }

    override fun toString(): String = "$$number"
}

class MatrixEmitter(val matrix: Matrix) : ConditionalEmitter<PhonS, PhonS> {

    init {
        if (matrix.valueList.any { it is NegatedValue }) {
            throw LscInvalidOutputMatrix(matrix, "negated feature")
        }
    }

    override fun result(
        declarations: Declarations, matcher: SimpleMatcher<PhonS>, original: Word<PhonS>
    ): UnboundResult<PhonS> =
        { bindings ->
            listOf(
                with(declarations) {
                    val boundMatrix = matrix.bindVariables(bindings)
                    val matchMatrix = original.softGet(0)?.toMatrix() ?: Matrix(emptyList())
                    val resultMatrix = matchMatrix.update(boundMatrix)
                    Phonetic.single(resultMatrix.toSymbol())
                }
            )
        }

    override fun toString(): String = matrix.toString()
}

class SymbolEmitter<I : Segment<I>>(val text: Word<PhonS>) :
    ConditionalEmitter<I, PhonS>,
    IndependentEmitter<I, PhonS> {

    override fun result(): UnboundResult<PhonS> = { listOf(text) }

    override fun result(
        declarations: Declarations, matcher: SimpleMatcher<I>, original: Word<I>
    ): UnboundResult<PhonS> {
        if (
            matcher is SymbolMatcher && original is PhoneticWord
        ) {
            val result = with(declarations) {
                if (matcher.text.length == text.length && original.length == text.length) {
                    matcher.text.segments.zip3(
                        original.segments, text.segments
                    ) { matcherSegment, originalSegment, textSegment ->
                        textSegment.withFloatingDiacriticsFrom(originalSegment, excluding = matcherSegment)
                    }
                } else if (matcher.text.length == original.length && text.length == 1) {
                    var newText = text.segments.first()
                    matcher.text.segments.zip(original.segments).forEach { (matcherSegment, originalSegment) ->
                        newText = newText.withFloatingDiacriticsFrom(originalSegment, excluding = matcherSegment)
                    }
                    listOf(newText)
                } else if (matcher.text.length == 1 && original.length == 1) {
                    val matcherSegment = matcher.text.segments.first()
                    val originalSegment = original.segments.first()
                    text.segments.map {
                        it.withFloatingDiacriticsFrom(originalSegment, excluding = matcherSegment)
                    }
                } else text.segments
            }
            return { listOf(Phonetic.fromSegments(result)) }
        } else {
            return { listOf(text) }
        }
    }

    override fun toString(): String = text.string.ifEmpty { "*" }

    override fun isConditional(): Boolean = true

    override fun isIndependent(): Boolean = true
}

class TextEmitter<I : Segment<I>, O : Segment<O>>(val text: Word<O>) : IndependentEmitter<I, O> {
    override fun result(): UnboundResult<O> {
        return { listOf(text) }
    }

    override fun toString(): String = text.string.ifEmpty { "*" }
}

class EmptyEmitter<I : Segment<I>, O : Segment<O>>(val outType: SegmentType<O>) : IndependentEmitter<I, O> {
    override fun result(): UnboundResult<O> =
        { listOf(outType.empty) }

    override fun toString(): String = "*"
}

class LscInvalidOutputMatrix(val matrix: Matrix, val invalidFeature: String) :
    LscUserError("Feature matrix $matrix has a $invalidFeature, which isn't allowed in the output of a rule")
