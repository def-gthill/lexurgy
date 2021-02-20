package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

typealias UnboundResult<T> = (Bindings) -> List<Word<T>>

interface Emitter<I : Segment<I>, O : Segment<O>> {
    /**
     * Returns a ``SubSequence`` that identifies whether
     * this emitter contains an accessible sequence of other emitters.
     * This may "lift" nested sequences out of their containing emitter.
     */
    fun subSequence(): SubSequence<Emitter<I, O>>

    /**
     * Returns a ``SubAlternatives`` that identifies whether this
     * emitter contains an accessible list of alternative emitters.
     * This may "lift" nested alternatives out of their containing
     * emitter.
     */
    fun subAlternatives(): SubAlternatives<Emitter<I, O>>

    /**
     * Tests if this emitter is simple, i.e. its result doesn't depend
     * on any matchers. An emitter is simple if and only if it
     * has no ``ConditionalEmitter``s in its structure.
     */
    fun isSimple(): Boolean
}

class SequenceEmitter<I : Segment<I>, O : Segment<O>>(val elements: List<Emitter<I, O>>) : Emitter<I, O> {
    override fun toString(): String = elements.joinToString(separator = " ", prefix = "(", postfix = ")")

    override fun isSimple(): Boolean = elements.all { it.isSimple() }

    override fun subAlternatives(): SubAlternatives<Emitter<I, O>> = OneAlternative

    override fun subSequence(): SubSequence<Emitter<I, O>> = DefiniteSequence(elements)
}

class AlternativeEmitter<I : Segment<I>, O : Segment<O>>(val elements: List<Emitter<I, O>>) : Emitter<I, O> {
    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")

    override fun isSimple(): Boolean = elements.all { it.isSimple() }

    override fun subAlternatives(): SubAlternatives<Emitter<I, O>> = ManyAlternatives(elements)

    override fun subSequence(): SubSequence<Emitter<I, O>> = NonSequence
}

/**
 * An emitter that conjures part of a word out of nothing.
 * This means it doesn't need information from a connected
 * ``Matcher`` about what it matched.
 */
interface SimpleEmitter<I : Segment<I>, O : Segment<O>> : Emitter<I, O> {
    fun result(): UnboundResult<O>

    override fun isSimple(): Boolean = true

    override fun subAlternatives(): SubAlternatives<Emitter<I, O>> = OneAlternative

    override fun subSequence(): SubSequence<Emitter<I, O>> = NonSequence
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

    override fun isSimple(): Boolean = false

    override fun subAlternatives(): SubAlternatives<Emitter<I, O>> = OneAlternative

    override fun subSequence(): SubSequence<Emitter<I, O>> = NonSequence
}

class CaptureReferenceEmitter(val number: Int) : SimpleEmitter<PhonS, PhonS> {
    override fun result(): UnboundResult<PhonS> =
        { bindings ->
            listOf(bindings.captures[number] ?: throw LscUnboundCapture(number))
        }
}

class MatrixEmitter(val matrix: Matrix) : ConditionalEmitter<PhonS, PhonS> {
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

class SymbolEmitter<I : Segment<I>>(val text: Word<PhonS>) : ConditionalEmitter<I, PhonS> {
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
}

class TextEmitter<I : Segment<I>, O : Segment<O>>(val text: Word<O>) : SimpleEmitter<I, O> {
    override fun result(): UnboundResult<O> {
        return { listOf(text) }
    }

    override fun toString(): String = text.string.ifEmpty { "*" }
}

class EmptyEmitter<I : Segment<I>, O : Segment<O>>(val outType: SegmentType<O>) : SimpleEmitter<I, O> {
    override fun result(): UnboundResult<O> =
        { listOf(outType.empty) }

    override fun toString(): String = "*"
}
