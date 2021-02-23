package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

interface Matcher<I : Segment<I>> {
    fun claim(
        declarations: Declarations,
        words: List<Word<I>>,
        start: WordListIndex,
        bindings: Bindings
    ): WordListIndex? {
        val (startWord, startIndex) = start
        if (startIndex !in 0 .. words[startWord].length) return null
        claim(declarations, words[startWord], startIndex, bindings)?.let { return WordListIndex(startWord, it) }
        return null
    }

    fun claim(
        declarations: Declarations,
        word: Word<I>,
        start: Int,
        bindings: Bindings
    ): Int?

    fun reversed(): Matcher<I>

    /**
     * Makes a transformer that matches using this `Matcher` and uses the specified
     * `Emitter` to produce the result.
     * @param filtered: Whether the transformer is in a filtered rule
     */
    fun <O : Segment<O>> transformerTo(
        result: Emitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean,
    ): Transformer<I, O>

    /**
     * Checks whether this matcher prefers to treat emitters as
     * independent (rather than conditional) if both interpretations
     * are possible.
     */
    fun prefersIndependentEmitters(): Boolean

    /**
     * Checks whether this matcher prefers to treat sequence emitters
     * as independent (rather than conditional) if both interpretations
     * are possible.
     */
    fun prefersIndependentSequenceEmitters(): Boolean
}

abstract class BaseMatcher<I : Segment<I>> : Matcher<I> {
    override fun <O : Segment<O>> transformerTo(
        result: Emitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean,
    ): Transformer<I, O> {
        if (filtered) checkValidInFilter(result)
        return try {
            when (result) {
                is AlternativeEmitter -> transformerToAlternatives(result, outType, filtered)
                is SequenceEmitter ->
                    if (prefersIndependentSequenceEmitters() && result.isIndependent()) {
                        transformerToIndependentSequence(result, outType, filtered)
                    } else {
                        transformerToSequence(result, outType, filtered)
                    }
                else ->
                    if (prefersIndependentEmitters() && result.isIndependent()) {
                        transformerToIndependent(result as IndependentEmitter, outType, filtered)
                    } else if (result.isConditional()) {
                        transformerToConditional(result as ConditionalEmitter, outType, filtered)
                    } else {
                        transformerToIndependent(result as IndependentEmitter, outType, filtered)
                    }
            }
        } catch (e: LscInvalidTransformation) {
            if (result.isIndependent()) {
                when (result) {
                    is SequenceEmitter -> transformerToIndependentSequence(result, outType, filtered)
                    else -> transformerToIndependent(result as IndependentEmitter, outType, filtered)
                }
            } else {
                throw e
            }
        }
    }

    /**
     * Checks if this matcher can be paired with the specified emitter in a filtered rule.
     * Returns normally if yes, throws an appropriate `LscInvalidTransformation` if not.
     * The default implementation always returns normally.
     */
    protected open fun <O : Segment<O>> checkValidInFilter(result: Emitter<I, O>) = Unit

    protected abstract fun <O : Segment<O>> transformerToAlternatives(
        result: AlternativeEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean,
    ): Transformer<I, O>

    protected abstract fun <O : Segment<O>> transformerToSequence(
        result: SequenceEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean,
    ): Transformer<I, O>

    protected abstract fun <O : Segment<O>> transformerToConditional(
        result: ConditionalEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean,
    ): Transformer<I, O>

    protected open fun <O : Segment<O>> transformerToIndependent(
        result: IndependentEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean,
    ): Transformer<I, O> = IndependentTransformer(this, result)

    protected open fun <O : Segment<O>> transformerToIndependentSequence(
        result: SequenceEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean,
    ): Transformer<I, O> = if (filtered) {
        // Filtered rules need each output element to correspond to an
        // input element so it can restore the ignored segments in the
        // right places. This isn't possible with IndependentSequenceEmitter.
        mismatchedLengths(
            this,
            result,
            when (this) {
                is SequenceMatcher -> elements
                else -> listOf(this)
            },
            result.elements,
        )
    } else {
        IndependentSequenceTransformer(outType,this, result)
    }

    protected fun <O : Segment<O>> mismatchedLengths(
        match: Matcher<I>,
        result: Emitter<I, O>,
        matchElements: List<Matcher<I>>,
        resultElements: List<Emitter<I, O>>,
    ): Nothing = throw LscInvalidTransformation(
        match, result,
        "Found ${enpl(matchElements.size, "element")} " +
                "(${matchElements.joinToString { "\"$it\"" }}) on the left side of the arrow " +
                "but ${enpl(resultElements.size, "element")} " +
                "(${resultElements.joinToString { "\"$it\"" }}) on the right side"
    )

    override fun prefersIndependentEmitters(): Boolean = false

    override fun prefersIndependentSequenceEmitters(): Boolean = false
}

/**
 * A matcher whose response to all emitters is to try to connect
 * a sub-element to the emitter.
 */
abstract class LiftingMatcher<I : Segment<I>> : BaseMatcher<I>() {
    override fun <O : Segment<O>> transformerToAlternatives(
        result: AlternativeEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = liftingTransformerTo(result, outType, filtered)

    override fun <O : Segment<O>> transformerToSequence(
        result: SequenceEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = liftingTransformerTo(result, outType, filtered)

    override fun <O : Segment<O>> transformerToConditional(
        result: ConditionalEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = liftingTransformerTo(result, outType, filtered)

    protected abstract fun <O : Segment<O>> liftingTransformerTo(
        result: Emitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O>
}

class SequenceMatcher<I : Segment<I>>(val elements: List<Matcher<I>>) : BaseMatcher<I>() {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? {
        var elementStart = start
        for (element in elements) {
            elementStart = element.claim(declarations, word, elementStart, bindings) ?: return null
        }
        return elementStart
    }

    override fun reversed(): Matcher<I> = SequenceMatcher(elements.asReversed().map { it.reversed() })

    override fun toString(): String = elements.joinToString(separator = " ", prefix = "(", postfix = ")")

    override fun <O : Segment<O>> transformerToAlternatives(
        result: AlternativeEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> {
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
            }.zipAll { SequenceMatcher(it) }
            return AlternativeTransformer(
                matchSequences,
                resultSequences.requireNoNulls(),
                outType,
                filtered,
            )
        } else {
            mismatchedLengths(this, result, elements, listOf(result))
        }
    }

    override fun <O : Segment<O>> transformerToSequence(
        result: SequenceEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = if (elements.size == result.elements.size) {
        SequenceTransformer(elements, result.elements, outType, filtered)
    } else {
        mismatchedLengths(this, result, elements, result.elements)
    }

    override fun <O : Segment<O>> transformerToConditional(
        result: ConditionalEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = SequenceTransformer(elements, elements.map { result }, outType, filtered)

    override fun prefersIndependentEmitters(): Boolean = true
}

class RepeaterMatcher<I : Segment<I>>(
    val element: Matcher<I>,
    val type: RepeaterType,
    val precedingMatcher: Matcher<I>?,
    val followingMatcher: Matcher<I>?,
) : LiftingMatcher<I>() {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? {
        var elementStart = start
        var times = 0
        while (true) {
            val altBindings = bindings.copy()
            if (followingMatcher?.claim(declarations, word, elementStart, altBindings) != null) break
            elementStart = element.claim(declarations, word, elementStart, bindings) ?: break
            times++
            if (type.maxReps?.let { times >= it } == true) break
        }
        return elementStart.takeIf { times >= type.minReps }
    }

    override fun reversed(): Matcher<I> =
        RepeaterMatcher(element.reversed(), type, followingMatcher, precedingMatcher)

    override fun toString(): String = "$element${type.string}"

    override fun <O : Segment<O>> liftingTransformerTo(
        result: Emitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = RepeaterTransformer(this, result, outType, filtered)

    override fun prefersIndependentEmitters(): Boolean = true

    override fun prefersIndependentSequenceEmitters(): Boolean = true
}

class AlternativeMatcher<I : Segment<I>>(val elements: List<Matcher<I>>) : BaseMatcher<I>() {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? {
        for (element in elements) {
            val altBindings = bindings.copy()
            element.claim(declarations, word, start, altBindings)?.let {
                bindings.combine(altBindings)
                return it
            }
        }
        return null
    }

    override fun reversed(): Matcher<I> = AlternativeMatcher(elements.map { it.reversed() })

    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")

    override fun <O : Segment<O>> transformerToAlternatives(
        result: AlternativeEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = if (elements.size == result.elements.size) {
        AlternativeTransformer(elements, result.elements, outType, filtered)
    } else {
        mismatchedLengths(this, result, elements, result.elements)
    }

    override fun <O : Segment<O>> transformerToSequence(
        result: SequenceEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = AlternativeTransformer(elements, result, outType, filtered)

    override fun <O : Segment<O>> transformerToConditional(
        result: ConditionalEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = AlternativeTransformer(elements, result, outType, filtered)
}

class IntersectionMatcher<I : Segment<I>>(val elements: List<Matcher<I>>) : LiftingMatcher<I>() {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? {
        var matchEnd: Int? = null
        for (element in elements) {
            val elementMatchEnd = element.claim(declarations, word, start, bindings) ?: return null
            if (matchEnd == null) {
                matchEnd = elementMatchEnd
            } else if (elementMatchEnd != matchEnd) {
                return null
            }
        }
        return matchEnd
    }

    override fun reversed(): Matcher<I> = IntersectionMatcher(elements.map { it.reversed() })

    override fun toString(): String = elements.joinToString("&")

    override fun <O : Segment<O>> liftingTransformerTo(
        result: Emitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> =
        IntersectionTransformer(
            elements.first().transformerTo(result, outType, filtered),
            elements.drop(1),
        )
}

class CaptureMatcher(val element: Matcher<PhonS>, val number: Int) : LiftingMatcher<PhonS>() {
    override fun claim(declarations: Declarations, word: Word<PhonS>, start: Int, bindings: Bindings): Int? =
        if (number in bindings.captures) {
            throw LscReboundCapture(number)
        } else {
            element.claim(declarations, word, start, bindings)?.also { end ->
                bindings.captures[number] = word.slice(start until end)
            }
        }

    override fun reversed(): Matcher<PhonS> = CaptureMatcher(element.reversed(), number)

    override fun toString(): String = "$element$$number"

    override fun <O : Segment<O>> liftingTransformerTo(
        result: Emitter<PhonS, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<PhonS, O> =
        CaptureTransformer(element.transformerTo(result, outType, filtered), number)
}

/**
 * A matcher that isn't a container for other matchers
 */
abstract class SimpleMatcher<I : Segment<I>> : BaseMatcher<I>() {
    override fun <O : Segment<O>> transformerToAlternatives(
        result: AlternativeEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = mismatchedLengths(this, result, listOf(this), result.elements)

    override fun <O : Segment<O>> transformerToSequence(
        result: SequenceEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = mismatchedLengths(this, result, listOf(this), result.elements)

    override fun <O : Segment<O>> transformerToConditional(
        result: ConditionalEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = SimpleConditionalTransformer(this, result)

    override fun <O : Segment<O>> transformerToIndependent(
        result: IndependentEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = IndependentTransformer(this, result)

    override fun <O : Segment<O>> transformerToIndependentSequence(
        result: SequenceEmitter<I, O>,
        outType: SegmentType<O>,
        filtered: Boolean
    ): Transformer<I, O> = IndependentSequenceTransformer(outType, this, result)
}

class BetweenWordsMatcher<I : Segment<I>> : SimpleMatcher<I>() {
    override fun claim(
        declarations: Declarations,
        words: List<Word<I>>,
        start: WordListIndex,
        bindings: Bindings
    ): WordListIndex? {
        val (startWord, startIndex) = start
        return if (startWord < words.size - 1 && startIndex == words[startWord].length) {
            WordListIndex(startWord + 1, 0)
        } else null
    }

    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? = null

    override fun reversed(): Matcher<I> = this

    override fun toString(): String = "$$"
}

class WordStartMatcher<I : Segment<I>> : SimpleMatcher<I>() {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? =
        start.takeIf { it == 0 }

    override fun reversed(): Matcher<I> = WordEndMatcher()

    override fun toString(): String = "$"
}

class WordEndMatcher<I : Segment<I>> : SimpleMatcher<I>() {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? =
        start.takeIf { it == word.length }

    override fun reversed(): Matcher<I> = WordStartMatcher()

    override fun toString(): String = "$"
}

class CaptureReferenceMatcher(val number: Int) : SimpleMatcher<PhonS>() {
    override fun claim(declarations: Declarations, word: Word<PhonS>, start: Int, bindings: Bindings): Int? =
        bindings.captures[number]?.let { capturedText ->
            return (start + capturedText.length).takeIf { end ->
                word.drop(start).take(end - start) == capturedText
            }
        } ?: throw LscUnboundCapture(number)

    override fun reversed(): Matcher<PhonS> = this

    override fun toString(): String = "$$number"
}

class MatrixMatcher(val matrix: Matrix) : SimpleMatcher<PhonS>() {
    override fun claim(declarations: Declarations, word: Word<PhonS>, start: Int, bindings: Bindings): Int? =
        with(declarations) {
            val boundMatrix = matrix.bindVariables(bindings)
            if (start < word.length && word[start].matches(boundMatrix, bindings)) start + 1
            else null
        }

    override fun reversed(): Matcher<PhonS> = this

    override fun toString(): String = matrix.toString()
}

abstract class AbstractTextMatcher<I : Segment<I>>(val text: Word<I>) : SimpleMatcher<I>() {
    override fun <O : Segment<O>> checkValidInFilter(result: Emitter<I, O>) {
        if (text.length > 1) {
            throw LscInvalidTransformation(
                matcher = this,
                emitter = result,
                message = "Multi-segment matches aren't allowed on the match side of filtered rules",
            )
        }
    }
}

class SymbolMatcher(text: Word<PhonS>) : AbstractTextMatcher<PhonS>(text) {
    override fun claim(declarations: Declarations, word: Word<PhonS>, start: Int, bindings: Bindings): Int? {
        val end = start + text.length
        if (end > word.length) return null
        val matches = with(declarations) {
            word.sliceSegments(start until end).zip(text.segments) { wordSegment, textSegment ->
                wordSegment.matches(textSegment)
            }.all { it }
        }
        return if (matches) end else null
    }

    override fun reversed(): Matcher<PhonS> = SymbolMatcher(text.reversed())

    override fun toString(): String = text.string.ifEmpty { "*" }
}

class TextMatcher<I : Segment<I>>(text: Word<I>) : AbstractTextMatcher<I>(text) {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? {
        val wordStart = word.drop(start).take(text.length)
        return if (wordStart == text) start + text.length else null
    }

    override fun reversed(): Matcher<I> = TextMatcher(text.reversed())

    override fun toString(): String = text.string
}

class NegatedMatcher<I : Segment<I>>(val matcher: Matcher<I>) : SimpleMatcher<I>() {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? =
        when {
            start >= word.length -> null
            matcher.claim(declarations, word, start, bindings) == null -> start + 1
            else -> null
        }

    override fun reversed(): Matcher<I> = NegatedMatcher(matcher.reversed())

    override fun toString(): String = "!$matcher"
}

class EmptyMatcher<I : Segment<I>> : SimpleMatcher<I>() {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int =
        start

    override fun reversed(): Matcher<I> = this

    override fun <O : Segment<O>> checkValidInFilter(result: Emitter<I, O>) =
        throw LscInvalidTransformation(
            matcher = this,
            emitter = result,
            message = "Asterisks aren't allowed on the match side of filtered rules",
        )

    override fun toString(): String = "*"
}
