package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

interface Matcher {
    fun claim(
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<PhraseMatchEnd> {
        if (!phrase.hasIndex(start)) return emptyList()
        val (startWord, startIndex) = start
        return claim(declarations, phrase[startWord], startIndex, bindings).map {
            it.withWordIndex(startWord)
        }
    }

    fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> =
        claim(
            declarations,
            Phrase(listOf(word)),
            PhraseIndex(0, start),
            bindings
        ).map { it.segmentIndex }

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

class EnvironmentMatcher(
    val element: Matcher,
    val environment: CompoundEnvironment,
) : LiftingMatcher() {
    override fun claim(
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<PhraseMatchEnd> {
        val claimEnds = element.claim(declarations, phrase, start, bindings)
        return claimEnds.mapNotNull { claimEnd ->
            environment.check(
                declarations, phrase, start,
                claimEnd.index, claimEnd.returnBindings,
            )?.let {
                claimEnd.updateBindings(it)
            }
        }
    }

    override fun reversed(): Matcher =
        EnvironmentMatcher(element.reversed(), environment.reversed())

    override fun toString(): String = "$element$environment"

    override fun liftingTransformerTo(result: Emitter, filtered: Boolean): Transformer =
        EnvironmentTransformer(element.transformerTo(result, filtered), environment)
}

/**
 * A lookahead/lookbehind condition that tests whether the material
 * before and after a match fits the specified criteria.
 * The check passes if at least one of the ``positive`` environments
 * is satisfied (or the list is empty), and if none of the ``negative``
 * environments are satisfied.
 */
class CompoundEnvironment(val positive: List<Environment>, val negative: List<Environment>) {

    private val realPositive =
        if (positive.isEmpty()) listOf(Environment(EmptyMatcher, EmptyMatcher))
        else positive.map { it.beforeReversed() }

    private val realNegative = negative.map { it.beforeReversed() }

    fun check(
        declarations: Declarations,
        phrase: Phrase,
        matchStart: PhraseIndex,
        matchEnd: PhraseIndex,
        bindings: Bindings,
    ): Bindings? {
        val positiveBindings = realPositive.firstNotNullOfOrNull { environment ->
            environment.check(
                declarations, phrase, matchStart, matchEnd, bindings
            )
        } ?: return null
        for (environment in realNegative) {
            environment.check(
                declarations, phrase, matchStart, matchEnd, positiveBindings
            )?.let { return null }
        }
        return positiveBindings
    }

    fun reversed(): CompoundEnvironment =
        CompoundEnvironment(
            positive.map { it.reversed() },
            negative.map { it.reversed() }
        )

    override fun toString(): String =
        "${environtext("/", positive)}${environtext("//", negative)}"

    private fun environtext(sep: String, environ: List<Environment>) =
        when (environ.size) {
            0 -> ""
            1 -> " $sep ${environ.single()}"
            else -> " $sep ${environ.joinToString(prefix = "{", postfix = "}")}"
        }
}

class Environment(val before: Matcher, val after: Matcher) {
    fun check(
        declarations: Declarations,
        phrase: Phrase,
        matchStart: PhraseIndex,
        matchEnd: PhraseIndex,
        bindings: Bindings,
    ): Bindings? {
        val reversedPhrase = phrase.fullyReversed()
        val beforeEnd = before.claim(
            declarations, reversedPhrase, phrase.reversedIndex(matchStart), bindings
        )
        if (beforeEnd.isEmpty()) return null
        val afterEnd = after.claim(
            declarations, phrase, matchEnd, beforeEnd.first().returnBindings
        )
        if (afterEnd.isEmpty()) return null
        return afterEnd.first().returnBindings
    }

    fun beforeReversed(): Environment = Environment(before.reversed(), after)

    fun reversed(): Environment =
        Environment(after.reversed(), before.reversed())

    override fun toString(): String = "$before _ $after"
}

class SequenceMatcher(val elements: List<Matcher>) : BaseMatcher() {
    override fun claim(
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
    ): List<PhraseMatchEnd> {
        var ends = listOf(PhraseMatchEnd(start, bindings))
        for (element in elements) {
            ends = ends.flatMap { (end, prevBindings) ->
                element.claim(declarations, phrase, end, prevBindings)
            }
            if (ends.isEmpty()) return emptyList()
        }
        return ends
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
    ): List<PhraseMatchEnd> {
        val result = mutableListOf(listOf(PhraseMatchEnd(start, bindings)))
        while (true) {
            val newResult = result.last().flatMap { (end, prevBindings) ->
                element.claim(declarations, phrase, end, prevBindings)
            }
            if (newResult.isEmpty()) break
            result += newResult
            if (type.maxReps != null && result.size > type.maxReps) break
        }
        return result.drop(type.minReps).reversed().flatten()
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
    ): List<PhraseMatchEnd> =
        elements.flatMap { element ->
            element.claim(declarations, phrase, start, bindings)
        }

    override fun reversed(): Matcher = AlternativeMatcher(elements.map { it.reversed() })

    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")

    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean
    ): Transformer = if (elements.size == result.elements.size) {
        AlternativeTransformer(elements, result.elements, filtered)
    } else {
        try {
            AlternativeTransformer(elements, result, filtered)
        } catch (_: LscInvalidTransformation) {
            mismatchedLengths(this, result, elements, result.elements)
        }
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
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> {
        var matchEnds: List<WordMatchEnd> = emptyList()
        for (element in elements) {
            val elementMatchEnds = element.claim(declarations, word, start, bindings)
            val elementMatchEndsMap = elementMatchEnds.associate { it.index to it.returnBindings }
            matchEnds = if (matchEnds.isEmpty()) {
                elementMatchEnds
            } else {
                matchEnds.mapNotNull { matchEnd ->
                    elementMatchEndsMap[matchEnd.index]?.let {
                        matchEnd.updateBindings(it)
                    }
                }
            }
            if (matchEnds.isEmpty()) return emptyList()
        }
        return matchEnds
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

class CaptureMatcher(
    val element: Matcher,
    val number: Int,
    val isReversed: Boolean = false,
) : LiftingMatcher() {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> =
        if (number in bindings.captures) {
            throw LscReboundCapture(number)
        } else {
            element.claim(declarations, word, start, bindings).map { end ->
                val capture = word.slice(start until end.index)
                end.replaceBindings(
                    end.returnBindings.bindCapture(
                        number,
                        if (isReversed) capture.reversed() else capture
                    )
                )
            }
        }

    override fun reversed(): Matcher =
        CaptureMatcher(element.reversed(), number, !isReversed)

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
    ): List<PhraseMatchEnd> {
        val (startWord, startIndex) = start
        return if (startWord < phrase.size - 1 && startIndex == phrase[startWord].length) {
            listOf(PhraseMatchEnd(PhraseIndex(startWord + 1, 0), bindings))
        } else emptyList()
    }

    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> = emptyList()

    override fun reversed(): Matcher = this

    override fun toString(): String = "$$"
}

object WordStartMatcher : SimpleMatcher() {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> =
        if (start == 0) listOf(WordMatchEnd(start, bindings)) else emptyList()

    override fun reversed(): Matcher = WordEndMatcher

    override fun toString(): String = "$"
}

object WordEndMatcher : SimpleMatcher() {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> =
        if (start == word.length) listOf(WordMatchEnd(start, bindings)) else emptyList()

    override fun reversed(): Matcher = WordStartMatcher

    override fun toString(): String = "$"
}

class CaptureReferenceMatcher(val number: Int, val isReversed: Boolean = false) : SimpleMatcher() {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> =
        bindings.captures[number]?.let { capturedText ->
            val orientedCapturedText = if (isReversed) capturedText.reversed() else capturedText
            return if (word.drop(start).take(capturedText.length) == orientedCapturedText) {
                listOf(WordMatchEnd(start + capturedText.length, bindings))
            } else emptyList()
        } ?: throw LscUnboundCapture(number)

    override fun reversed(): Matcher = CaptureReferenceMatcher(number, !isReversed)

    override fun toString(): String = "$$number"
}

class MatrixMatcher(val matrix: Matrix) : SimpleMatcher() {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> =
        with(declarations) {
            val boundMatrix = matrix.bindVariables(bindings)
            if (start < word.length) {
                word[start].matches(boundMatrix, bindings)?.let {
                    listOf(WordMatchEnd(start + 1, it))
                } ?: emptyList()
            } else emptyList()
        }

    override fun reversed(): Matcher = this

    override fun toString(): String = matrix.toString()
}

class SyllableMatrixMatcher(val matrix: Matrix) : SimpleMatcher() {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> =
        with(declarations) {
            val boundMatrix = matrix.bindVariables(bindings)
            word.modifiersAt(start).toMatrix().matches(boundMatrix, bindings)?.let {
                listOf(WordMatchEnd(start + 1, it))
            } ?: emptyList()
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
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> {
        val end = start + text.length
        if (end > word.length) return emptyList()
        val matches = with(declarations) {
            word.sliceSegments(start until end).zip(text.segments) { wordSegment, textSegment ->
                wordSegment.matches(textSegment)
            }.all { it }
        }
        return if (matches) listOf(WordMatchEnd(end, bindings)) else emptyList()
    }

    override fun reversed(): Matcher = SymbolMatcher(text.reversed())

    override fun toString(): String = text.string.ifEmpty { "*" }
}

class TextMatcher(text: Word) : AbstractTextMatcher(text) {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> {
        val wordStart = word.drop(start).take(text.length)
        return if (wordStart == text) {
            listOf(WordMatchEnd(start + text.length, bindings))
        } else emptyList()
    }

    override fun reversed(): Matcher = TextMatcher(text.reversed())

    override fun toString(): String = text.string
}

class NegatedMatcher(val matcher: Matcher) : SimpleMatcher() {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> =
        when {
            start >= word.length -> emptyList()
            matcher.claim(declarations, word, start, bindings).isEmpty() ->
                listOf(WordMatchEnd(start + 1, bindings))
            else -> emptyList()
        }

    override fun reversed(): Matcher = NegatedMatcher(matcher.reversed())

    override fun toString(): String = "!$matcher"
}

object EmptyMatcher : SimpleMatcher() {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings
    ): List<WordMatchEnd> =
        listOf(WordMatchEnd(start, bindings))

    override fun reversed(): Matcher = this

    override fun checkValidInFilter(result: Emitter) =
        throw LscInvalidTransformation(
            matcher = this,
            emitter = result,
            message = "Asterisks aren't allowed on the match side of filtered rules",
        )

    override fun toString(): String = "*"
}

object SyllableMatcher : SimpleMatcher() {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings,
    ): List<WordMatchEnd> {
        if (!word.isSyllabified()) return emptyList()
        val syllableIndex = word.syllableBreaks.indexOf(start)
        return listOfNotNull(
                when {
                start == 0 && word.numSyllables == 0 -> word.length
                start == 0 -> word.syllableBreaks[0]
                syllableIndex < 0 -> null
                syllableIndex + 1 == word.syllableBreaks.size -> word.length
                else -> word.syllableBreaks[syllableIndex + 1]
            }
        ).map { WordMatchEnd(it, bindings) }
    }

    override fun reversed(): Matcher = this

    override fun checkValidInFilter(result: Emitter) =
        throw LscInvalidTransformation(
            matcher = this,
            emitter = result,
            message = "<syl> isn't allowed in filtered rules"
        )

    override fun toString(): String = "<syl>"
}

/**
 * A matcher that doesn't match anything
 */
object NeverMatcher : SimpleMatcher() {
    override fun claim(
        declarations: Declarations,
        word: Word,
        start: Int,
        bindings: Bindings,
    ): List<WordMatchEnd> = emptyList()

    override fun reversed(): Matcher = this

    override fun toString(): String = "N/A"
}

data class WordMatchEnd(val index: Int, val returnBindings: Bindings) {
    fun withWordIndex(wordIndex: Int) =
        PhraseMatchEnd(PhraseIndex(wordIndex, index), returnBindings)

    fun replaceBindings(bindings: Bindings) =
        WordMatchEnd(index, bindings)

    fun updateBindings(bindings: Bindings) =
        WordMatchEnd(index, returnBindings.combine(bindings))
}

data class PhraseMatchEnd(val index: PhraseIndex, val returnBindings: Bindings) {
    val segmentIndex = WordMatchEnd(index.segmentIndex, returnBindings)

    fun replaceBindings(bindings: Bindings) =
        PhraseMatchEnd(index, bindings)

    fun updateBindings(bindings: Bindings) =
        PhraseMatchEnd(index, returnBindings.combine(bindings))
}
