package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

interface Matcher {
    fun claim(
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): PhraseIndex? {
        if (!phrase.hasIndex(start)) return null
        val (startWord, startIndex) = start
        claim(declarations, phrase[startWord], startIndex, bindings)?.let {
            return PhraseIndex(startWord, it)
        }
        return null
    }

    fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): Int? =
        claim(
            declarations,
            Phrase(listOf(word)),
            PhraseIndex(0, start),
            bindings
        )?.segmentIndex

    fun reversed(): Matcher

    /**
     * Makes a transformer that matches using this `Matcher` and uses the specified
     * `Emitter` to produce the result.
     * @param filtered: Whether the transformer is in a filtered rule
     */
    fun transformerTo(
        result: Emitter,
        filtered: Boolean,
    ): Transformer

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

abstract class BaseMatcher : Matcher {
    override fun transformerTo(
        result: Emitter,
        filtered: Boolean,
    ): Transformer {
        if (filtered) checkValidInFilter(result)
        return try {
            when (result) {
                is AlternativeEmitter -> transformerToAlternatives(result, filtered)
                is SequenceEmitter ->
                    if (prefersIndependentSequenceEmitters() && result.isIndependent()) {
                        transformerToIndependentSequence(result, filtered)
                    } else {
                        transformerToSequence(result, filtered)
                    }
                else ->
                    if (prefersIndependentEmitters() && result.isIndependent()) {
                        transformerToIndependent(result as IndependentEmitter, filtered)
                    } else if (result.isConditional()) {
                        transformerToConditional(result as ConditionalEmitter, filtered)
                    } else {
                        transformerToIndependent(result as IndependentEmitter, filtered)
                    }
            }
        } catch (e: LscInvalidTransformation) {
            if (result.isIndependent()) {
                when (result) {
                    is SequenceEmitter -> transformerToIndependentSequence(result, filtered)
                    else -> transformerToIndependent(result as IndependentEmitter, filtered)
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
    protected open fun checkValidInFilter(result: Emitter) = Unit

    protected abstract fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean,
    ): Transformer

    protected abstract fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean,
    ): Transformer

    protected abstract fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean,
    ): Transformer

    protected open fun transformerToIndependent(
        result: IndependentEmitter,
        filtered: Boolean,
    ): Transformer = IndependentTransformer(this, result)

    protected open fun transformerToIndependentSequence(
        result: SequenceEmitter,
        filtered: Boolean,
    ): Transformer = if (filtered) {
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
        IndependentSequenceTransformer(this, result)
    }

    protected fun mismatchedLengths(
        match: Matcher,
        result: Emitter,
        matchElements: List<Matcher>,
        resultElements: List<Emitter>,
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
abstract class LiftingMatcher : BaseMatcher() {
    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean
    ): Transformer = liftingTransformerTo(result, filtered)

    override fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean
    ): Transformer = liftingTransformerTo(result, filtered)

    override fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean
    ): Transformer = liftingTransformerTo(result, filtered)

    protected abstract fun liftingTransformerTo(
        result: Emitter,
        filtered: Boolean
    ): Transformer
}

class SequenceMatcher(val elements: List<Matcher>) : BaseMatcher() {
    override fun claim(
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): PhraseIndex? {
        var elementStart = start
        for (element in elements) {
            elementStart = element.claim(declarations, phrase, elementStart, bindings) ?: return null
        }
        return elementStart
    }

    override fun reversed(): Matcher = SequenceMatcher(elements.asReversed().map { it.reversed() })

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
            }.zipAll { SequenceMatcher(it) }
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
    ): Transformer = SequenceTransformer(elements, elements.map { result }, filtered)

    override fun prefersIndependentEmitters(): Boolean = true
}

class RepeaterMatcher(
    val element: Matcher,
    val type: RepeaterType,
    val precedingMatcher: Matcher?,
    val followingMatcher: Matcher?,
) : LiftingMatcher() {
    override fun claim(
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): PhraseIndex? {
        var elementStart = start
        var times = 0
        while (true) {
            val altBindings = bindings.copy()
            if (followingMatcher?.claim(declarations, phrase, elementStart, altBindings)?.takeIf {
                    it > elementStart
                } != null) break
            elementStart = element.claim(declarations, phrase, elementStart, bindings) ?: break
            times++
            if (type.maxReps?.let { times >= it } == true) break
        }
        return elementStart.takeIf { times >= type.minReps }
    }

    override fun reversed(): Matcher =
        RepeaterMatcher(
            element.reversed(),
            type,
            followingMatcher?.reversed(),
            precedingMatcher?.reversed(),
        )

    override fun toString(): String = "$element${type.string}"

    override fun liftingTransformerTo(
        result: Emitter,
        filtered: Boolean
    ): Transformer = RepeaterTransformer(this, result, filtered)

    override fun prefersIndependentEmitters(): Boolean = true

    override fun prefersIndependentSequenceEmitters(): Boolean = true
}

class AlternativeMatcher(val elements: List<Matcher>) : BaseMatcher() {
    override fun claim(
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): PhraseIndex? {
        for (element in elements) {
            val altBindings = bindings.copy()
            element.claim(declarations, phrase, start, altBindings)?.let {
                bindings.combine(altBindings)
                return it
            }
        }
        return null
    }

    override fun reversed(): Matcher = AlternativeMatcher(elements.map { it.reversed() })

    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")

    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean
    ): Transformer = if (elements.size == result.elements.size) {
        AlternativeTransformer(elements, result.elements, filtered)
    } else {
        mismatchedLengths(this, result, elements, result.elements)
    }

    override fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean
    ): Transformer = AlternativeTransformer(elements, result, filtered)

    override fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean
    ): Transformer = AlternativeTransformer(elements, result, filtered)
}

class IntersectionMatcher(val elements: List<Matcher>) : LiftingMatcher() {
    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int? {
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

    override fun reversed(): Matcher = IntersectionMatcher(elements.map { it.reversed() })

    override fun toString(): String = elements.joinToString("&")

    override fun liftingTransformerTo(
        result: Emitter,
        filtered: Boolean
    ): Transformer =
        IntersectionTransformer(
            elements.first().transformerTo(result, filtered),
            elements.drop(1),
        )
}

class CaptureMatcher(val element: Matcher, val number: Int) : LiftingMatcher() {
    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int? =
        if (number in bindings.captures) {
            throw LscReboundCapture(number)
        } else {
            element.claim(declarations, word, start, bindings)?.also { end ->
                bindings.captures[number] = word.slice(start until end)
            }
        }

    override fun reversed(): Matcher = CaptureMatcher(element.reversed(), number)

    override fun toString(): String = "$element$$number"

    override fun liftingTransformerTo(
        result: Emitter,
        filtered: Boolean
    ): Transformer =
        CaptureTransformer(element.transformerTo(result, filtered), number)
}

/**
 * A matcher that isn't a container for other matchers
 */
abstract class SimpleMatcher : BaseMatcher() {
    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean
    ): Transformer = mismatchedLengths(this, result, listOf(this), result.elements)

    override fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean
    ): Transformer = mismatchedLengths(this, result, listOf(this), result.elements)

    override fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean
    ): Transformer = SimpleConditionalTransformer(this, result)

    override fun transformerToIndependent(
        result: IndependentEmitter,
        filtered: Boolean
    ): Transformer = IndependentTransformer(this, result)

    override fun transformerToIndependentSequence(
        result: SequenceEmitter,
        filtered: Boolean
    ): Transformer = IndependentSequenceTransformer(this, result)
}

object BetweenWordsMatcher : SimpleMatcher() {
    override fun claim(
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): PhraseIndex? {
        val (startWord, startIndex) = start
        return if (startWord < phrase.size - 1 && startIndex == phrase[startWord].length) {
            PhraseIndex(startWord + 1, 0)
        } else null
    }

    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int? = null

    override fun reversed(): Matcher = this

    override fun toString(): String = "$$"
}

object WordStartMatcher : SimpleMatcher() {
    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int? =
        start.takeIf { it == 0 }

    override fun reversed(): Matcher = WordEndMatcher

    override fun toString(): String = "$"
}

object WordEndMatcher : SimpleMatcher() {
    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int? =
        start.takeIf { it == word.length }

    override fun reversed(): Matcher = WordStartMatcher

    override fun toString(): String = "$"
}

class CaptureReferenceMatcher(val number: Int) : SimpleMatcher() {
    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int? =
        bindings.captures[number]?.let { capturedText ->
            return (start + capturedText.length).takeIf { end ->
                word.drop(start).take(end - start) == capturedText
            }
        } ?: throw LscUnboundCapture(number)

    override fun reversed(): Matcher = this

    override fun toString(): String = "$$number"
}

class MatrixMatcher(val matrix: Matrix) : SimpleMatcher() {
    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int? =
        with(declarations) {
            val boundMatrix = matrix.bindVariables(bindings)
            if (start < word.length && word[start].matches(boundMatrix, bindings)) start + 1
            else null
        }

    override fun reversed(): Matcher = this

    override fun toString(): String = matrix.toString()
}

abstract class AbstractTextMatcher(val text: Word) : SimpleMatcher() {
    override fun checkValidInFilter(result: Emitter) {
        if (text.length > 1) {
            throw LscInvalidTransformation(
                matcher = this,
                emitter = result,
                message = "Multi-segment matches aren't allowed on the match side of filtered rules",
            )
        }
    }
}

class SymbolMatcher(text: Word) : AbstractTextMatcher(text) {
    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int? {
        val end = start + text.length
        if (end > word.length) return null
        val matches = with(declarations) {
            word.sliceSegments(start until end).zip(text.segments) { wordSegment, textSegment ->
                wordSegment.matches(textSegment)
            }.all { it }
        }
        return if (matches) end else null
    }

    override fun reversed(): Matcher = SymbolMatcher(text.reversed())

    override fun toString(): String = text.string.ifEmpty { "*" }
}

class TextMatcher(text: Word) : AbstractTextMatcher(text) {
    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int? {
        val wordStart = word.drop(start).take(text.length)
        return if (wordStart == text) start + text.length else null
    }

    override fun reversed(): Matcher = TextMatcher(text.reversed())

    override fun toString(): String = text.string
}

class NegatedMatcher(val matcher: Matcher) : SimpleMatcher() {
    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int? =
        when {
            start >= word.length -> null
            matcher.claim(declarations, word, start, bindings) == null -> start + 1
            else -> null
        }

    override fun reversed(): Matcher = NegatedMatcher(matcher.reversed())

    override fun toString(): String = "!$matcher"
}

object EmptyMatcher : SimpleMatcher() {
    override fun claim(declarations: Declarations, word: Word, start: Int, bindings: Bindings): Int =
        start

    override fun reversed(): Matcher = this

    override fun checkValidInFilter(result: Emitter) =
        throw LscInvalidTransformation(
            matcher = this,
            emitter = result,
            message = "Asterisks aren't allowed on the match side of filtered rules",
        )

    override fun toString(): String = "*"
}

/**
 * A matcher that doesn't match anything
 */
object NeverMatcher : SimpleMatcher() {
    override fun claim(
        declarations: Declarations, word: Word, start: Int, bindings: Bindings
    ): Int? = null

    override fun reversed(): Matcher = this

    override fun toString(): String = "N/A"
}
