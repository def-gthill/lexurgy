package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import com.meamoria.lexurgy.sc.element.Transformation
import com.meamoria.lexurgy.sc.element.TransformationCatching
import com.meamoria.lexurgy.sc.element.Transformer
import com.meamoria.lexurgy.word.*

interface ChangeRule {
    /**
     * Applies the rule to the specified phrase.
     *
     * Returns null if the rule wasn't applicable to the phrase at all,
     * i.e. none of the conditions matched. If
     * rules matched but happened not to change the words,
     * this method returns a result equal to ``phrase`` rather than null.
     */
    operator fun invoke(phrase: Phrase): Phrase?
}

/**
 * A rule at the top level (i.e. one with a name).
 * Named rules must return a new phrase; they can't
 * "give up" if nothing matched.
 */
interface NamedRule : ChangeRule {
    val name: String

    val ruleType: RuleType

    val declarations: Declarations

    override fun invoke(phrase: Phrase): Phrase
}

enum class RuleType {
    NORMAL,
    DEROMANIZER,
    ROMANIZER,
}

class StandardNamedRule(
    override val name: String,
    override val declarations: Declarations,
    val mainBlock: ChangeRule,
    override val ruleType: RuleType = RuleType.NORMAL,
    val filter: ((Segment) -> Boolean)? = null,
) : NamedRule {
    override operator fun invoke(phrase: Phrase): Phrase =
        mainBlock(phrase) ?: phrase

    override fun toString(): String = "Rule $name: $mainBlock"
}

/**
 * A rule that never matches its input.
 */
object EmptyRule : ChangeRule {
    override fun invoke(phrase: Phrase): Phrase? = null
}

/**
 * A rule at the bottom level, consisting of a sequence
 * of expressions and an optional filter.
 */
class SimpleChangeRule(
    val declarations: Declarations,
    val expressions: List<RuleExpression>,
    val filter: ((Segment) -> Boolean)? = null,
    val matchMode: MatchMode = MatchMode.SIMULTANEOUS,
) : ChangeRule {
    override operator fun invoke(phrase: Phrase): Phrase? =
        when (matchMode) {
            MatchMode.SIMULTANEOUS -> matchAndTransformOnce(phrase) { filteredPhrase, _ ->
                val allTransformations = expressions.mapIndexed { i, expr ->
                    expr.claimAll(i, filteredPhrase)
                }.flatten()
                filterOverlappingClaims(allTransformations)
            }

            MatchMode.LEFT_TO_RIGHT -> {
                var curPhrase = phrase
                var index = curPhrase.firstIndex
                while (index <= curPhrase.lastIndex) {
                    curPhrase = matchAndTransformOnceAt(curPhrase, index)
                    index = curPhrase.stepForward(index)
                }
                curPhrase
            }

            MatchMode.RIGHT_TO_LEFT -> {
                var curPhrase = phrase
                var index = curPhrase.lastIndex
                while (index >= curPhrase.firstIndex) {
                    curPhrase = matchAndTransformOnceAt(curPhrase, index)
                    index = curPhrase.stepBack(index)
                }
                curPhrase
            }
        }

    private fun matchAndTransformOnceAt(
        phrase: Phrase,
        index: PhraseIndex,
    ): Phrase = matchAndTransformOnce(phrase) { filteredPhrase, filterMap ->
        val filteredIndex = if (filterMap == null) {
            index
        } else {
            // Convert index in the original word into index in the filtered word
            val filteredSegmentIndex = filterMap[index.wordIndex].indexOf(index.segmentIndex)
            if (filteredSegmentIndex >= 0) {
                PhraseIndex(index.wordIndex, filteredSegmentIndex)
            } else {
                // The sound at this index doesn't pass the filter, so we can't possibly match here
                return phrase
            }
        }
        listOfNotNull(
            expressions.asSequence().mapIndexed { i, expr ->
                expr.claimAt(i, filteredPhrase, filteredIndex)?.throwing()
            }.firstNotNullOfOrNull { it }
        )
    } ?: phrase

    private inline fun matchAndTransformOnce(
        phrase: Phrase,
        transformationMaker: (Phrase, List<IntArray>?) -> List<Transformation>
    ): Phrase? {
        val (filteredWords, filterMaps) =
            if (filter == null) phrase to null else phrase.map(::filterWord).unzip()
        val filteredPhrase = Phrase(filteredWords.toList())
        val transformations = transformationMaker(filteredPhrase, filterMaps)
        val realTransformations = unfilterTransformations(phrase, filterMaps, transformations)
        if (realTransformations.isEmpty()) return null
        return applyTransformations(phrase, realTransformations)
    }

    private fun applyTransformations(phrase: Phrase, transformations: List<Transformation>): Phrase {
        var result = Phrase()
        var previousTransformation: Transformation? = null

        fun addExistingSlice(start: PhraseIndex, end: PhraseIndex? = null) {
            var existingSlice = end?.let { phrase.slice(start, it) } ?: phrase.dropUntil(start)
            if (previousTransformation?.removesSyllableBreakAfter == true)
                existingSlice = existingSlice.removeLeadingBreak()
            result = result.concat(
                existingSlice
            ) { left, right ->
                previousTransformation?.let {
                    with (declarations) {
                        var matrix = right.toMatrix().update(left.toMatrix())
                        for (index in result.iterateBackFrom(result.lastIndex)) {
                            matrix = matrix.update(
                                it.syllableFeatureChanges[index] ?: Matrix.EMPTY
                            )
                            if (result.hasSyllableBreakBefore(index)) {
                                break
                            }
                        }
                        matrix.toModifiers()
                    }
                } ?: right
            }
        }

        fun cursor() = previousTransformation?.end ?: PhraseIndex(0, 0)

        for (transformation in transformations.sortedBy { it.start }) {
            if (cursor() > transformation.start) continue
            addExistingSlice(cursor(), transformation.start)
            if (transformation.removesSyllableBreakBefore) {
                result = result.removeTrailingBreak()
            }
            val newBit = transformation.finalResult(declarations)
            result = result.concat(
                newBit,
            ) { left, right ->
                with (declarations) {
                    var matrix = left.toMatrix().update(right.toMatrix())
                    for (index in result.iterateFrom(result.firstIndex)) {
                        matrix = matrix.update(
                            transformation.syllableFeatureChanges[index] ?: Matrix.EMPTY
                        )
                        if (newBit.hasSyllableBreakAfter(index)) {
                            break
                        }
                    }
                    matrix.toModifiers()
                }
            }
            previousTransformation = transformation
        }
        addExistingSlice(cursor())
        return result
    }

    private fun filterWord(word: Word): Pair<Word, IntArray> {
        val filterResult = word.filterSegments(filter!!)
        return filterResult.word to filterResult.filterMap
    }

    // Strips out transformations that would try to change something that's already being changed.
    // Assumes the transformations argument is already sorted in precedence order.
    private fun filterOverlappingClaims(transformations: List<TransformationCatching>): List<Transformation> {
        val claimed = mutableListOf<ClosedRange<PhraseIndex>>()
        val result = mutableListOf<Transformation>()
        for (transformation in transformations) {
            val thisClaim = transformation.start.rangeTo(transformation.end)
            var foundOverlap = false
            for (previousClaim in claimed) {
                if (thisClaim overlaps previousClaim) {
                    foundOverlap = true
                    break
                }
            }
            if (foundOverlap) continue
            claimed += thisClaim
            result += transformation.throwing()
        }
        return result
    }

    private fun unfilterTransformations(
        phrase: Phrase, filterMap: List<IntArray>?, transformations: List<Transformation>
    ): List<Transformation> {
        if (filterMap == null) return transformations

        return transformations.flatMap { tr ->
            tr.elementalSubs.map { sub ->
                val (wordIndex, segmentIndex) = sub.start
                val filterIndex = PhraseIndex(wordIndex, filterMap[wordIndex][segmentIndex])
                var result = sub.result
                if (filterIndex.segmentIndex !in phrase[wordIndex].syllableBreaks) {
                    result = result.removeLeadingBreak()
                }
                val endIndex = phrase.stepForward(filterIndex)
                if (endIndex.segmentIndex !in phrase[endIndex.wordIndex].syllableBreaks) {
                    result = result.removeTrailingBreak()
                }
                Transformation(sub.order, filterIndex, endIndex, result)
            }
        }
    }

    override fun toString(): String = expressions.joinToString().ifBlank { "<no changes>" }
}

/**
 * Specifies which matches a rule should look for
 */
enum class MatchMode(val string: String) {
    SIMULTANEOUS("simul"),
    LEFT_TO_RIGHT("ltr"),
    RIGHT_TO_LEFT("rtl"),
}

/**
 * A change rule that imposes new declarations by
 * re-parsing the input phrase to match the new declarations
 */
class Redeclaration(val newDeclarations: Declarations) : ChangeRule {
    override fun invoke(phrase: Phrase): Phrase =
        Phrase(phrase.map(newDeclarations::parsePhonetic))
}

/**
 * A rule block that executes all its subrules one after the other
 */
class SequentialBlock(
    val subrules: List<ChangeRule>
) : ChangeRule {
    override fun invoke(phrase: Phrase): Phrase? {
        var somethingMatched = false
        var curPhrase = phrase
        for (subrule in subrules) {
            curPhrase = subrule(curPhrase)?.also { somethingMatched = true } ?: curPhrase
        }
        return curPhrase.takeIf { somethingMatched }
    }

    override fun toString(): String = subrules.joinToString("\nThen:\n")
}

/**
 * A rule block that executes only the first subrule that matches
 */
class FirstMatchingBlock(
    val subrules: List<ChangeRule>
) : ChangeRule {
    override fun invoke(phrase: Phrase): Phrase? {
        for (subrule in subrules) {
            subrule(phrase)?.let { return it }
        }
        return null
    }

    override fun toString(): String = subrules.joinToString("\nElse:\n")
}

/**
 * A rule block that executes rules separately for each word
 */
class WithinWordBlock(
    val subrule: ChangeRule
) : ChangeRule {
    override fun invoke(phrase: Phrase): Phrase? {
        var somethingMatched = false
        val result = phrase.map {
            subrule(Phrase(it))?.single()?.also { somethingMatched = true } ?: it
        }
        return Phrase(result).takeIf { somethingMatched }
    }
}

/**
 * A block that runs its rule repeatedly until the phrase
 * stops changing
 */
class PropagateBlock(
    val subrule: ChangeRule
) : ChangeRule {
    private val maxPropagateSteps = 100

    override fun invoke(phrase: Phrase): Phrase? {
        var curPhrase = phrase
        val steps = mutableSetOf(curPhrase)
        for (i in 1..maxPropagateSteps) {
            val newPhrase = subrule(curPhrase) ?: return if (i == 1) null else curPhrase
            if (newPhrase == curPhrase) return newPhrase
            if (newPhrase in steps) throw LscDivergingPropagation(this, phrase.string, steps.map { it.string })
            steps += newPhrase
            curPhrase = newPhrase
        }
        throw LscDivergingPropagation(this, phrase.string, steps.map { it.string }.takeLast(5))
    }
}

class RuleExpression(
    val declarations: Declarations,
    val transformer: Transformer,
) {
    /**
     * Finds all indices where this expression matches the specified phrase,
     * and returns a Transformation for each match.
     */
    fun claimAll(expressionNumber: Int, phrase: Phrase): List<TransformationCatching> {
        var index = PhraseIndex(0, 0)
        val result = mutableListOf<TransformationCatching>()

        while (true) {
            val transformation = claimNext(expressionNumber, phrase, index) ?: break
            result += transformation
            index = phrase.stepForward(transformation.start)
        }

        return result
    }

    private fun claimNext(expressionNumber: Int, phrase: Phrase, start: PhraseIndex): TransformationCatching? {
        for (matchStart in phrase.iterateFrom(start)) {
            return claimAt(expressionNumber, phrase, matchStart) ?: continue
        }
        return null
    }

    /**
     * Tries to match this expression at the specified index in the specified phrase.
     * Returns a Transformation if the expression matched, null otherwise.
     */
    fun claimAt(expressionNumber: Int, phrase: Phrase, index: PhraseIndex): TransformationCatching? {
        val bindings = Bindings()
        val transformation = transformer.transform(
            expressionNumber, phrase, index, bindings
        ).firstOrNull() ?: return null
        return transformation.bindVariablesCatching()
    }

    override fun toString(): String = "$transformer"
}

class LscDivergingPropagation(val rule: ChangeRule, val initialWord: String, val wordsAtAbort: List<String>) :
    LscUserError(
        "Propagating rule $rule applied to rule $initialWord appears " +
                "not to settle on a result; the last few versions of the word were ${wordsAtAbort.joinToString(" -> ")}"
    )
