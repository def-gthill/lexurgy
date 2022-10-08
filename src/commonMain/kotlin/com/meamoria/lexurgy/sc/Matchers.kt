package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

interface Matcher {
    fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean = false,
    ): List<PhraseMatchEnd>

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

    fun <T> List<T>.checkTooManyOptions(): List<T> =
        checkTooManyOptions(this@Matcher, this)
}

abstract class BaseMatcher : Matcher {
    override fun transformerTo(
        result: Emitter,
        filtered: Boolean,
    ): Transformer {
        if (filtered) checkValidInFilterIfEmitterIs(result)
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
    protected open fun checkValidInFilterIfEmitterIs(result: Emitter) = Unit

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

/**
 * A matcher that may change its behaviour if given a specific
 * number of segments to try to match.
 */
interface LengthHintedMatcher {
    fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        expectedEnd: PhraseIndex,
        bindings: Bindings
    ): Bindings?
}

class EnvironmentMatcher(
    val element: Matcher,
    val environment: CompoundEnvironment,
) : LiftingMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val claimEnds = element.claim(phrase, start, bindings, partial)
        return claimEnds.mapNotNull { claimEnd ->
            environment.check(
                phrase, start,
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
        phrase: Phrase,
        matchStart: PhraseIndex,
        matchEnd: PhraseIndex,
        bindings: Bindings,
    ): Bindings? {
        val positiveBindings = realPositive.firstNotNullOfOrNull { environment ->
            environment.check(
                phrase, matchStart, matchEnd, bindings
            )
        } ?: return null
        for (environment in realNegative) {
            environment.check(
                phrase, matchStart, matchEnd, positiveBindings
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
        phrase: Phrase,
        matchStart: PhraseIndex,
        matchEnd: PhraseIndex,
        bindings: Bindings,
    ): Bindings? {
        val reversedPhrase = phrase.fullyReversed()
        val beforeEnd = before.claim(
            reversedPhrase, phrase.reversedIndex(matchStart), bindings
        )
        if (beforeEnd.isEmpty()) return null
        val afterEnd = after.claim(
            phrase, matchEnd, beforeEnd.first().returnBindings
        )
        if (afterEnd.isEmpty()) return null
        return afterEnd.first().returnBindings
    }

    fun beforeReversed(): Environment = Environment(before.reversed(), after)

    fun reversed(): Environment =
        Environment(after.reversed(), before.reversed())

    override fun toString(): String = "$before _ $after"
}

class SequenceMatcher(
    val declarations: Declarations,
    val elements: List<Matcher>
) : BaseMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        var ends = listOf(PhraseMatchEnd(start, bindings))
        for (element in elements) {
            val newEnds = ends.filter { !it.isPartial }.flatMap { end ->
                element.claim(
                    phrase, end.index, end.returnBindings, partial
                ).map { it.precededBy(end) }
            }.checkTooManyOptions()
            if (newEnds.isEmpty()) {
                return if (partial) ends.filter {
                    it.index > start
                }.map { it.partial() } else emptyList()
            }
            ends = newEnds
        }
        return ends
    }

    override fun reversed(): Matcher = SequenceMatcher(
        declarations,
        elements.asReversed().map { it.reversed() }
    )

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
            }.zipAll { SequenceMatcher(declarations, it) }
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
    ): Transformer = SequenceTransformer(
        elements, elements.map { result }, filtered
    )

    override fun prefersIndependentEmitters(): Boolean = true
}

class RepeaterMatcher(
    val declarations: Declarations,
    val element: Matcher,
    val type: RepeaterType,
) : LiftingMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val result = mutableListOf(listOf(PhraseMatchEnd(start, bindings)))
        while (true) {
            val newResult = result.last().filter { !it.isPartial }.flatMap { end ->
                element.claim(
                    phrase, end.index, end.returnBindings, partial
                ).map { it.precededBy(end) }
            }.checkTooManyOptions()
            if (newResult.isEmpty()) break
            result += newResult
            if (type.maxReps != null && result.size > type.maxReps!!) break
        }
        val resultAboveMinReps = result.drop(type.minReps)
        return if (resultAboveMinReps.isEmpty()) {
            if (partial) {
                result.reversed().flatten().filter {
                    it.index > start
                }.map { it.partial() }
            } else {
                emptyList()
            }
        } else {
            resultAboveMinReps.reversed().flatten()
        }
    }

    override fun reversed(): Matcher =
        RepeaterMatcher(
            declarations,
            element.reversed(),
            type,
        )

    override fun toString(): String = "$element${type.string}"

    override fun liftingTransformerTo(
        result: Emitter,
        filtered: Boolean
    ): Transformer = RepeaterTransformer(this, result, filtered)

    override fun prefersIndependentEmitters(): Boolean = true

    override fun prefersIndependentSequenceEmitters(): Boolean = true
}

class AlternativeMatcher(
    val declarations: Declarations,
    val elements: List<Matcher>,
) : BaseMatcher() {
    private val groupedElements = mutableListOf<Matcher>()

    init {
        var currentGroup = mutableListOf<AbstractTextMatcher>()
        for (element in elements) {
            if (element is AbstractTextMatcher) {
                currentGroup.add(element)
            } else {
                if (currentGroup.isNotEmpty()) {
                    groupedElements.add(ClassMatcher(declarations, currentGroup))
                    currentGroup = mutableListOf()
                }
                groupedElements.add(element)
            }
        }
        if (currentGroup.isNotEmpty()) {
            groupedElements.add(ClassMatcher(declarations, currentGroup))
        }
    }

    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        groupedElements.flatMap { element ->
            element.claim(phrase, start, bindings, partial)
        }.checkTooManyOptions()

    override fun reversed(): Matcher = AlternativeMatcher(
        declarations,
        elements.map { it.reversed() }
    )

    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")

    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean,
    ): Transformer = if (elements.size == result.elements.size) {
        val groupedEmitters = mutableListOf<Emitter>()
        var i = 0
        for (element in groupedElements) {
            if (element is ClassMatcher) {
                val numElements = element.elements.size
                val end = i + numElements
                groupedEmitters += AlternativeEmitter(
                    result.elements.slice(i until end)
                )
                i = end
            } else {
                groupedEmitters += result.elements[i]
                i++
            }
        }
        AlternativeTransformer(groupedElements, groupedEmitters, filtered)
    } else {
        try {
            AlternativeTransformer(groupedElements, result, filtered)
        } catch (_: LscInvalidTransformation) {
            mismatchedLengths(this, result, elements, result.elements)
        }
    }

    override fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean,
    ): Transformer = AlternativeTransformer(groupedElements, result, filtered)

    override fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean,
    ): Transformer = AlternativeTransformer(groupedElements, result, filtered)
}

// Optimized AlternativeMatcher for when all the elements are
// just looking for literal text.
internal class ClassMatcher(
    val declarations: Declarations,
    val elements: List<AbstractTextMatcher>,
) : BaseMatcher() {
    private val tree = TextMatcherTree(declarations, elements)

    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean
    ): List<PhraseMatchEnd> =
        tree.tryMatch(phrase[start.wordIndex], start.segmentIndex).flatMap {
            elements[it].claim(phrase, start, bindings, partial)
        }

    override fun reversed(): Matcher = ClassMatcher(
        declarations,
        elements.map { it.reversed() as AbstractTextMatcher }
    )

    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean,
    ): Transformer = if (elements.size == result.elements.size) {
        ClassTransformer(declarations, elements, result.elements, filtered)
    } else {
        mismatchedLengths(this, result, elements, result.elements)
    }

    override fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean,
    ): Transformer = ClassTransformer(declarations, elements, result, filtered)

    override fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean,
    ): Transformer = ClassTransformer(declarations, elements, result, filtered)
}

class IntersectionMatcher(
    val initialMatcher: Matcher,
    val checkMatchers: List<CheckMatcher>,
) : LiftingMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val matchEnds = initialMatcher.claim(
            phrase, start, bindings, partial
        )
        return filterIntersection(
            checkMatchers, phrase, start, bindings, matchEnds
        ) { it }
    }

    override fun reversed(): Matcher = IntersectionMatcher(
        initialMatcher.reversed(),
        checkMatchers.map { it.reversed() }
    )

    override fun toString(): String =
        "$initialMatcher&${checkMatchers.joinToString("&")}"

    override fun liftingTransformerTo(
        result: Emitter,
        filtered: Boolean
    ): Transformer =
        IntersectionTransformer(
            initialMatcher.transformerTo(result, filtered),
            checkMatchers,
        )
}

data class CheckMatcher(val matcher: Matcher, val negated: Boolean) {
    fun reversed(): CheckMatcher = CheckMatcher(matcher.reversed(), negated)

    override fun toString(): String = "${if (negated) "!" else ""}$matcher"
}

fun <T : WithBindings<T>> filterIntersection(
    elements: List<CheckMatcher>,
    phrase: Phrase,
    start: PhraseIndex,
    initialBindings: Bindings,
    possibleMatches: List<T>,
    matchEndTransformer: (T) -> PhraseMatchEnd,
): List<T> {
    var matchEnds = possibleMatches
    for ((element, negated) in elements) {
        if (element is LengthHintedMatcher) {
            matchEnds = matchEnds.mapNotNull { matchEnd ->
                val transformed = matchEndTransformer(matchEnd)
                val elementMatchEnd = element.claim(
                    phrase, start, transformed.index, initialBindings
                )
                if (negated) {
                    if (elementMatchEnd == null) matchEnd else null
                } else {
                    elementMatchEnd?.let { matchEnd.updateBindings(it) }
                }
            }
        } else {
            val elementMatchEnds = element.claim(phrase, start, initialBindings)
            val elementMatchEndsMap = elementMatchEnds.associate { it.index to it.returnBindings }
            matchEnds = matchEnds.mapNotNull { matchEnd ->
                val transformed = matchEndTransformer(matchEnd)
                if (negated) {
                    if (transformed.index in elementMatchEndsMap) null else matchEnd
                } else {
                    elementMatchEndsMap[transformed.index]?.let {
                        matchEnd.updateBindings(it)
                    }
                }
            }
            if (matchEnds.isEmpty()) return emptyList()
        }
    }
    return matchEnds
}

class CaptureMatcher(
    val element: Matcher,
    val number: Int,
    val isReversed: Boolean = false,
) : LiftingMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        if (number in bindings.captures) {
            throw LscReboundCapture(number)
        } else {
            element.claim(phrase, start, bindings, partial).map { end ->
                val capture = phrase.slice(start, end.index).toSimple()
                end.replaceBindings(
                    end.returnBindings.bindCapture(
                        number,
                        capture.fullyReversedIf(isReversed)
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

/**
 * A matcher that looks for text equal to the output of the specified
 * emitter
 */
class EmitterMatcher(
    val emitter: IndependentEmitter,
    val isReversed: Boolean = false,
) : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val emitterResult = emitter.result()
        val resultPhrase = emitterResult.bind(bindings).phrase.fullyReversedIf(isReversed)
        val matchEnd = matchSubPhrase(phrase, start, resultPhrase) ?: return emptyList()
        return listOf(PhraseMatchEnd(matchEnd, bindings))
    }

    override fun reversed(): Matcher = EmitterMatcher(emitter, !isReversed)
}

object BetweenWordsMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val (startWord, startIndex) = start
        return if (startWord < phrase.size - 1 && startIndex == phrase[startWord].length) {
            listOf(PhraseMatchEnd(PhraseIndex(startWord + 1, 0), bindings))
        } else emptyList()
    }

    override fun reversed(): Matcher = this

    override fun toString(): String = "$$"
}

object WordStartMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        if (start.segmentIndex == 0) {
            listOf(PhraseMatchEnd(start, bindings))
        } else emptyList()

    override fun reversed(): Matcher = WordEndMatcher

    override fun toString(): String = "$"
}

object WordEndMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        if (start.segmentIndex == phrase[start.wordIndex].length) {
            listOf(PhraseMatchEnd(start, bindings))
        } else emptyList()

    override fun reversed(): Matcher = WordStartMatcher

    override fun toString(): String = "$"
}

object SyllableBoundaryMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val word = phrase[start.wordIndex]
        val index = start.segmentIndex
        return if (word.isSyllabified()) {
            if (index == 0 || index == word.length || index in word.syllableBreaks) {
                listOf(
                    PhraseMatchEnd(start, bindings, listOf(start))
                )
            } else emptyList()
        } else emptyList()
    }

    override fun reversed(): Matcher = this

    override fun toString(): String = "."
}

class CaptureReferenceMatcher(
    val declarations: Declarations,
    val number: Int,
    val exact: Boolean,
    val isReversed: Boolean = false,
) : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val capturedPhrase = bindings.captures[number]?.fullyReversedIf(isReversed)
            ?: throw LscUnboundCapture(number)

        val matchEnd = matchSubPhrase(
            phrase, start, capturedPhrase,
            if (exact) {
                { it.segments }
            } else {
                { word ->
                    with (declarations) {
                        word.segments.map { it.withoutFloatingDiacritics() }
                    }
                }
            }
        ) ?: return emptyList()
        return listOf(PhraseMatchEnd(matchEnd, bindings))
    }

    override fun reversed(): Matcher = CaptureReferenceMatcher(
        declarations, number, exact, !isReversed
    )

    override fun toString(): String = "$$number"
}

class MatrixMatcher(
    val declarations: Declarations,
    val matrix: Matrix
) : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        with(declarations) {
            val word = phrase[start.wordIndex]
            val index = start.segmentIndex
            val boundMatrix = matrix.bindVariables(bindings)
            if (index < word.length) {
                word[index].matches(boundMatrix, bindings)?.let {
                    listOf(PhraseMatchEnd(
                        start.copy(segmentIndex = index + 1),
                        it
                    ))
                } ?: emptyList()
            } else emptyList()
        }

    override fun reversed(): Matcher = this

    override fun toString(): String = matrix.toString()
}

class SyllableMatrixMatcher(
    val declarations: Declarations,
    val matrix: Matrix
) : SimpleMatcher(), LengthHintedMatcher {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val word = phrase[start.wordIndex]
        val index = start.segmentIndex
        if (index == word.length) return emptyList()
        with(declarations) {
            val boundMatrix = matrix.bindVariables(bindings)
            return word.modifiersAt(index).toMatrix().matches(boundMatrix, bindings)?.let {
                listOf(PhraseMatchEnd(
                    start.copy(segmentIndex = index + 1),
                    it
                ))
            } ?: emptyList()
        }
    }

    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        expectedEnd: PhraseIndex,
        bindings: Bindings
    ): Bindings? {
        if (expectedEnd.wordIndex != start.wordIndex) return null
        val word = phrase[start.wordIndex]
        val index = start.segmentIndex
        val expectedEndIsPastCurrentSyllable =
            word.syllableBreaks.any {it in ((index + 1) until expectedEnd.segmentIndex) }
        if (expectedEndIsPastCurrentSyllable) return null
        with(declarations) {
            val boundMatrix = matrix.bindVariables(bindings)
            return word.modifiersAt(index).toMatrix().matches(boundMatrix, bindings)
        }
    }

    override fun reversed(): Matcher = this

    override fun toString(): String = matrix.toString()
}

abstract class AbstractTextMatcher(val text: Word) : SimpleMatcher() {
    override fun checkValidInFilterIfEmitterIs(result: Emitter) {
        if (text.length > 1) {
            throw LscIllegalStructureInFilteredRuleInput(
                "a multi-segment element",
                text.string,
            )
        }
    }
}

class SymbolMatcher(val declarations: Declarations, text: Word) :
    AbstractTextMatcher(text) {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val word = phrase[start.wordIndex]
        val index = start.segmentIndex
        val end = index + text.length
        if (end > word.length) return emptyList()
        val wordSegments = word.sliceSegments(index until end)
        val matches = with(declarations) {
            wordSegments.zip(text.segments) { wordSegment, textSegment ->
                wordSegment.matches(textSegment)
            }.all { it }
        }
        return if (matches) listOf(
            PhraseMatchEnd(start.copy(segmentIndex =  end), bindings)
        ) else emptyList()
    }

    override fun reversed(): Matcher = SymbolMatcher(declarations, text.reversed())

    override fun toString(): String = text.string.ifEmpty { "*" }
}

class TextMatcher(text: Word) : AbstractTextMatcher(text) {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val matchResult = matchSubPhrase(phrase, start, Phrase(text)) ?: return emptyList()
        return listOf(PhraseMatchEnd(
            matchResult,
            bindings,
        ))
    }

    override fun reversed(): Matcher = TextMatcher(text.reversed())

    override fun toString(): String = text.string
}

/**
 * Tries to find the specified phrase (``expectedText``) starting
 * at position ``start`` in ``phrase``. If
 * ``reversed`` is ``true``, ``expectedText`` is reversed first.
 * If ``segmentExtractor`` is specified, it will be used
 * to get segments from each word in both ``phrase`` and ``expectedText``
 * (instead of just accessing the ``segments`` property)
 */
private fun matchSubPhrase(
    phrase: Phrase,
    start: PhraseIndex,
    expectedSubPhrase: Phrase,
    segmentExtractor: (Word) -> List<Segment> = { it.segments },
): PhraseIndex? {
    val lastExpectedLength = expectedSubPhrase.last().length
    val subWords = phrase.words.drop(start.wordIndex).take(expectedSubPhrase.size).toMutableList()
    if (subWords.size != expectedSubPhrase.size) {
        return null
    }
    subWords[0] = subWords[0].drop(start.segmentIndex)
    subWords[subWords.lastIndex] = subWords[subWords.lastIndex].take(
        lastExpectedLength
    )
    for ((subWord, expectedSubWord) in subWords.zip(expectedSubPhrase)) {
        if (segmentExtractor(subWord) != segmentExtractor(expectedSubWord)) {
            return null
        }
    }
    val wordIndex = start.wordIndex + expectedSubPhrase.size - 1
    val segmentIndex = if (expectedSubPhrase.size == 1) {
        start.segmentIndex + lastExpectedLength
    } else {
        lastExpectedLength
    }
    return PhraseIndex(wordIndex, segmentIndex)
}

class NegatedMatcher(val matcher: Matcher) : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val word = phrase[start.wordIndex]
        val index = start.segmentIndex
        return when {
            index >= word.length -> emptyList()
            matcher.claim(phrase, start, bindings).isEmpty() ->
                listOf(PhraseMatchEnd(start.copy(segmentIndex = index + 1), bindings))
            else -> emptyList()
        }
    }

    override fun reversed(): Matcher = NegatedMatcher(matcher.reversed())

    override fun toString(): String = "!$matcher"
}

object EmptyMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        listOf(PhraseMatchEnd(start, bindings))

    override fun reversed(): Matcher = this

    override fun checkValidInFilterIfEmitterIs(result: Emitter) =
        throw LscIllegalStructureInFilteredRuleInput(
            "an empty element",
            "*"
        )

    override fun toString(): String = "*"
}

object SyllableMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val word = phrase[start.wordIndex]
        if (!word.isSyllabified()) return emptyList()
        if (word.isEmpty()) return emptyList()

        val index = start.segmentIndex
        val syllableIndex = word.syllableBreaks.indexOf(index)
        return listOfNotNull(
            when {
                // Match the entire word if it's only one syllable and we're at the beginning
                index == 0 && word.numSyllables == 1 -> word.length
                // Match up to the first syllable break if we're at the beginning
                index == 0 -> word.syllableBreaks[0]
                // Fail to match if we're in the middle of a syllable
                syllableIndex < 0 -> null
                // Match up to the end of the word if we're at the last syllable break
                syllableIndex + 1 == word.syllableBreaks.size -> word.length
                // Otherwise, we're at the start of a mid-word syllable; match up to the next syllable break
                else -> word.syllableBreaks[syllableIndex + 1]
            }
        ).map { PhraseMatchEnd(start.copy(segmentIndex = it), bindings) }
    }

    override fun reversed(): Matcher = this

    override fun checkValidInFilterIfEmitterIs(result: Emitter) =
        throw LscIllegalStructureInFilteredRuleInput(
            "a syllable element",
            "<syl>",
        )

    override fun toString(): String = "<syl>"
}

/**
 * A matcher that doesn't match anything
 */
object NeverMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> = emptyList()

    override fun reversed(): Matcher = this

    override fun toString(): String = "N/A"
}

interface WithBindings<T : WithBindings<T>> {
    fun replaceBindings(bindings: Bindings): T

    fun updateBindings(bindings: Bindings): T
}

data class PhraseMatchEnd(
    val index: PhraseIndex,
    val returnBindings: Bindings,
    val matchedSyllableBreaks: List<PhraseIndex> = emptyList(),
    val isPartial: Boolean = false,
) : WithBindings<PhraseMatchEnd> {

    override fun replaceBindings(bindings: Bindings) =
        copy(returnBindings = bindings)

    override fun updateBindings(bindings: Bindings) =
        copy(returnBindings = returnBindings.combine(bindings))

    fun precededBy(previous: PhraseMatchEnd): PhraseMatchEnd =
        copy(
            matchedSyllableBreaks =
            (previous.matchedSyllableBreaks + matchedSyllableBreaks).distinct()
        )

    fun partial(): PhraseMatchEnd = copy(isPartial = true)
}

fun <T> checkTooManyOptions(matcher: Any, options: List<T>): List<T> =
    if (options.size >= 1000) throw LscTooManyOptions(matcher) else options
