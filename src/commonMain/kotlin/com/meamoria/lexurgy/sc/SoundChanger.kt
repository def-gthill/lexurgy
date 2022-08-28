package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

class SoundChanger(
    val initialDeclarations: Declarations,
    val rules: List<RuleWithAnchoredSteps>,
) {
    init {
        val duplicated = rules.groupBy {
            it.rule?.name
        }.filterValues { it.size > 1 }.keys.firstOrNull()
        if (duplicated != null) {
            throw LscDuplicateName("rule", duplicated)
        }
    }

    operator fun invoke(word: String): String = change(listOf(word)).single()

    fun change(
        words: List<String>,
        startAt: String? = null,
        stopBefore: String? = null,
        debugWords: List<String> = emptyList(),
        romanize: Boolean = true,
        debug: (String) -> Unit = ::println,
    ): List<String> = changeWithIntermediates(
        words,
        startAt = startAt,
        stopBefore = stopBefore,
        debugWords = debugWords,
        romanize = romanize,
        debug = debug,
    ).getValue(null)

    /**
     * Runs the sound changes on the specified words, capturing intermediate stages using the sound changer's
     * intermediate romanizers. This produces a map associating the name of each romanizer to the intermediate
     * words produced by that romanizer. The final results are included under the ``null`` key.
     */
    fun changeWithIntermediates(
        words: List<String>,
        startAt: String? = null,
        stopBefore: String? = null,
        debugWords: List<String> = emptyList(),
        romanize: Boolean = true,
        debug: (String) -> Unit = ::println,
    ): Map<String?, List<String>> {
        val tracer = words.withIndex()
            .filter { it.value in debugWords }
            .associate { it.index to it.value }
            .let { Tracer(debug, it) }
        val persistentEffects = PersistentEffects()
        val phoneticPhrases = words.map {
            Phrase(
                it.split(" ").map(
                    initialDeclarations::parsePhonetic
                )
            )
        }
        val startPhrases = applySyllables(
            initialDeclarations, phoneticPhrases, tracer
        )

        val result = mutableMapOf<String?, List<String>>()

        var curPhrases = startPhrases
        var started = false
        var stopped = false

        fun maybeReplace(realRomanizer: NamedRule): NamedRule =
            if (romanize) realRomanizer else StandardNamedRule(
                "fake-romanizer", initialDeclarations, EmptyRule
            )

        fun runAnchoredStep(anchoredStep: AnchoredStep) {
            when (anchoredStep) {
                is IntermediateRomanizerStep -> {
                    if (!started) {
                        return
                    }
                    val rom = anchoredStep.romanizer
                    result[rom.name] = applyRule(
                        maybeReplace(rom), words, curPhrases, tracer
                    ).map { it.string }
                }

                is CleanupStep -> {
                    if (!started) {
                        return
                    }
                    curPhrases = applyRule(
                        anchoredStep.cleanupRule, words, curPhrases, tracer
                    )
                }

                is CleanupOffStep -> {
                    persistentEffects.removeCleanupRule(anchoredStep.ruleName)
                }

                is SyllabificationStep -> {
                    if (!started) {
                        return
                    }
                    curPhrases = applySyllables(
                        anchoredStep.declarations, curPhrases, tracer
                    )
                }
            }
        }

        for (ruleWithAnchoredSteps in rules) {
            val rule = ruleWithAnchoredSteps.rule

            if (!started && (startAt == null || rule?.name == startAt)) {
                started = true
            }

            for (anchoredStep in persistentEffects.cleanupRules) {
                // Always run persistent cleanup rules first.
                // They have to run before any syllabification rules,
                // and if they're about to be cancelled, they need one
                // last chance to run.
                runAnchoredStep(anchoredStep)
            }

            val stepsToRunBeforeSyllabification =
                if (ruleWithAnchoredSteps.anchoredSteps.firstOrNull() is IntermediateRomanizerStep)
                    0 else 1

            for (anchoredStep in ruleWithAnchoredSteps.anchoredSteps.take(stepsToRunBeforeSyllabification)) {
                // Then run the *first* new anchored step (if it isn't a romanizer).
                // The first step is considered "more tightly bound" to the preceding
                // rule, and can intervene before persistent syllabification
                // rules.
                runAnchoredStep(anchoredStep)
                persistentEffects += anchoredStep
            }

            persistentEffects.syllabificationStep?.let {
                // Now run the persistent syllabification rule, if any.
                runAnchoredStep(it)
            }

            for (anchoredStep in ruleWithAnchoredSteps.anchoredSteps.drop(stepsToRunBeforeSyllabification)) {
                // Now run the remaining anchored steps, in declaration order.
                runAnchoredStep(anchoredStep)
                persistentEffects += anchoredStep
            }

            if (stopBefore != null && rule?.name == stopBefore) {
                stopped = true
                break
            }

            if (started) {
                if (rule != null && (romanize || rule.ruleType != RuleType.ROMANIZER)) {
                    curPhrases = applyRule(
                        rule, words, curPhrases, tracer
                    )
                }
            }
        }

        if (stopBefore != null && !stopped) {
            throw LscRuleNotFound(stopBefore, "stop before")
        }
        if (startAt != null && !started) {
            throw LscRuleNotFound(startAt, "start at")
        }

        result[null] = curPhrases.map { it.string.normalizeCompose() }

        return result
    }

    private class PersistentEffects(
        var syllabificationStep: SyllabificationStep? = null,
        val cleanupRules: MutableList<CleanupStep> = mutableListOf(),
    ) {
        operator fun plusAssign(effect: AnchoredStep) {
            when (effect) {
                is SyllabificationStep -> syllabificationStep = effect
                is CleanupStep -> cleanupRules += effect
                else -> Unit // No persistent effect
            }
        }

        fun removeCleanupRule(ruleName: String) {
            cleanupRules.removeAll { it.cleanupRule.name == ruleName }
        }
    }

    private class Tracer(
        val debug: (String) -> Unit,
        val indexToDebugWords: Map<Int, String>,
    ) {
        init {
            if (indexToDebugWords.isNotEmpty()) {
                debug("Tracing ${indexToDebugWords.values.joinToString(", ")}")
            }
        }
        operator fun invoke(
            name: String,
            curPhrases: List<Phrase>,
            newPhrases: List<Phrase>,
        ) {
            for (i in indexToDebugWords.keys) {
                if (newPhrases[i] != curPhrases[i]) {
                    debug("Applied ${name}${appliedTo(i)}: ${curPhrases[i].string} -> ${newPhrases[i].string}")
                }
            }
        }

        fun appliedTo(index: Int): String =
            if (indexToDebugWords.size > 1) {
                " to ${indexToDebugWords[index]}"
            } else {
                ""
            }
    }

    private fun applySyllables(
        declarations: Declarations,
        curPhrases: List<Phrase>,
        tracer: Tracer,
    ): List<Phrase> = curPhrases.map {
        declarations.syllabify(it)
    }.also { newPhrases -> tracer("syllables", curPhrases, newPhrases) }

    private fun applyRule(
        rule: NamedRule,
        origPhrases: List<String>,
        curPhrases: List<Phrase>,
        tracer: Tracer,
    ): List<Phrase> =
        curPhrases.fastZipMap(origPhrases) { curPhrase, phrase ->
            try {
                rule(curPhrase).removeBoundingBreaks()
            } catch (e: Exception) {
                if (e is UserError) throw LscRuleNotApplicable(e, rule.name, phrase, curPhrase.string)
                else throw LscRuleCrashed(e, rule.name, phrase, curPhrase.string)
            }
        }.also { newPhrases -> tracer(rule.name, curPhrases, newPhrases) }


    data class RuleWithAnchoredSteps(
        val rule: NamedRule?,
        val anchoredSteps: List<AnchoredStep>,
    )

    sealed interface AnchoredStep

    data class IntermediateRomanizerStep(val romanizer: NamedRule) : AnchoredStep

    data class CleanupStep(val cleanupRule: NamedRule) : AnchoredStep

    data class CleanupOffStep(val ruleName: String) : AnchoredStep

    data class SyllabificationStep(val declarations: Declarations) : AnchoredStep

    companion object {
        fun change(
            changes: String,
            words: List<String>,
            startAt: String? = null,
            stopBefore: String? = null,
            debugWords: List<String> = emptyList()
        ): List<String> {
            val changer = fromLsc(changes)
            return changer.change(
                words,
                startAt = startAt,
                stopBefore = stopBefore,
                debugWords = debugWords
            )
        }

        fun fromLsc(code: String): SoundChanger {
            val parser = LscInterpreter()
            return (parser.parseFile(code) as LscWalker.SoundChangerNode).soundChanger
        }

        /**
         * A rule with no anchored steps
         */
        fun plainRule(rule: NamedRule): RuleWithAnchoredSteps =
            RuleWithAnchoredSteps(rule, emptyList())
    }

    override fun toString(): String = rules.joinToString(
        separator = "; ", prefix = "SoundChanger(", postfix = ")"
    )
}

internal fun makeStageComparisons(wordListSequence: List<List<String>>): List<String> {
    val result = mutableListOf<String>()
    val maxLengths = wordListSequence.map { it.maxLength() }
    val iterators = wordListSequence.map { it.iterator() }
    while (iterators.all { it.hasNext() }) {
        val stages = iterators.map { it.next() }
        val resultLine =
            if (stages.all { it == stages.first() }) stages.first()
            else stages.zip(maxLengths) { stage, length ->
                stage.padEndCombining(length)
            }.joinToString(" => ").trim()
        result += resultLine
    }
    return result
}

internal fun Iterable<String>.maxLength(): Int = maxOfOrNull { it.lengthCombining() } ?: 0

expect fun <T, U, R> Iterable<T>.fastZipMap(other: Iterable<U>, function: (T, U) -> R): List<R>

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
            MatchMode.SIMULTANEOUS -> matchAndTransformOnce(phrase) { filteredPhrase ->
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
    ) = matchAndTransformOnce(phrase) { filteredPhrase ->
        listOfNotNull(
            expressions.asSequence().mapIndexed { i, expr ->
                expr.claimAt(i, filteredPhrase, index)
            }.firstNotNullOfOrNull { it }
        )
    } ?: phrase

    private fun matchAndTransformOnce(
        phrase: Phrase,
        transformationMaker: (Phrase) -> List<Transformation>
    ): Phrase? {
        val (filteredWords, filterMaps) =
            if (filter == null) phrase to null else phrase.map(::filterWord).unzip()
        val filteredPhrase = Phrase(filteredWords.toList())
        val transformations = transformationMaker(filteredPhrase)
        val realTransformations = unfilterTransformations(phrase, filterMaps, transformations)
        if (realTransformations.isEmpty()) return null
        return applyTransformations(phrase, realTransformations)
    }

    private fun applyTransformations(phrase: Phrase, transformations: List<Transformation>): Phrase {
        var result = Phrase()
        var removeNextSyllableBreak = false
        var cursor = PhraseIndex(0, 0)

        fun addExistingSlice(start: PhraseIndex, end: PhraseIndex? = null) {
            var existingSlice = end?.let { phrase.slice(start, it) } ?: phrase.dropUntil(start)
            if (removeNextSyllableBreak)
                existingSlice = existingSlice.removeLeadingBreak()
            result = result.concat(
                existingSlice
            ) { left, _ -> left }
        }

        for (transformation in transformations.sortedBy { it.start }) {
            if (cursor > transformation.start) continue
            addExistingSlice(cursor, transformation.start)
            if (transformation.removesSyllableBreakBefore) {
                result = result.removeTrailingBreak()
            }
            result = result.concat(
                transformation.result,
            ) { _, right -> right }
            removeNextSyllableBreak = transformation.removesSyllableBreakAfter
            cursor = transformation.end
        }
        addExistingSlice(cursor)
        return result
    }

    private fun filterWord(word: Word): Pair<Word, IntArray> {
        val filterResult = word.filterSegments(filter!!)
        return filterResult.word to filterResult.filterMap
    }

    // Strips out transformations that would try to change something that's already being changed.
    // Assumes the transformations argument is already sorted in precedence order.
    private fun filterOverlappingClaims(transformations: List<Transformation>): List<Transformation> {
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
            result += transformation
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
    fun claimAll(expressionNumber: Int, phrase: Phrase): List<Transformation> {
        var index = PhraseIndex(0, 0)
        val result = mutableListOf<Transformation>()

        while (true) {
            val transformation = claimNext(expressionNumber, phrase, index) ?: break
            result += transformation
            index = phrase.stepForward(transformation.start)
        }

        return result
    }

    private fun claimNext(expressionNumber: Int, phrase: Phrase, start: PhraseIndex): Transformation? {
        for (matchStart in phrase.iterateFrom(start)) {
            return claimAt(expressionNumber, phrase, matchStart) ?: continue
        }
        return null
    }

    /**
     * Tries to match this expression at the specified index in the specified phrase.
     * Returns a Transformation if the expression matched, null otherwise.
     */
    fun claimAt(expressionNumber: Int, phrase: Phrase, index: PhraseIndex): Transformation? {
        val bindings = Bindings()
        val transformation = transformer.transform(
            expressionNumber, phrase, index, bindings
        ).firstOrNull() ?: return null
        return transformation.bindVariables()
    }

    override fun toString(): String = "$transformer"
}

class LscRuleNotApplicable(
    val reason: UserError,
    val rule: String,
    val originalWord: String,
    val currentWord: String
) : LscUserError(
    "Rule $rule could not be applied to word $currentWord (originally $originalWord)\n${reason.message}",
    reason
)

class LscRuleCrashed(val reason: Exception, val rule: String, val originalWord: String, val currentWord: String) :
    Exception(
        "Rule $rule encountered a programming error when applied to word $currentWord (originally $originalWord)",
        reason
    )

@Suppress("unused")
class LscInvalidTransformation(
    val matcher: Matcher, val emitter: Emitter, message: String
) : LscUserError(message)

class LscInteriorWordBoundary(
    override val cause: LscInteriorWordBoundary?,
    sequence: String?,
    environment: String?
) : LscBadSequence(
    cause,
    "A word boundary",
    sequence,
    environment,
    "needs to be at the beginning or end"
) {

    constructor() : this(null, null, null)

    override fun initEnvironment(newEnvironment: String): LscInteriorWordBoundary =
        LscInteriorWordBoundary(this, sequence, environment ?: newEnvironment)

    override fun initSequence(newSequence: String): LscBadSequence =
        LscInteriorWordBoundary(this, sequence ?: newSequence, environment)
}

class LscPeripheralRepeater(
    override val cause: LscPeripheralRepeater?,
    val text: String,
    val repeaterType: RepeaterType,
    sequence: String?,
    environment: String?
) : LscBadSequence(
    cause,
    "The repeater \"$text\"",
    sequence,
    environment,
    "is meaningless because it's at the edge of the environment; " +
            peripheralRepeaterInstruction(text, repeaterType),
) {

    constructor(text: String, repeaterType: RepeaterType) : this(
        null, text, repeaterType, null, null
    )

    override fun initEnvironment(newEnvironment: String): LscPeripheralRepeater =
        LscPeripheralRepeater(this, text, repeaterType, sequence, environment ?: newEnvironment)

    override fun initSequence(newSequence: String): LscPeripheralRepeater =
        LscPeripheralRepeater(this, text, repeaterType, sequence ?: newSequence, environment)
}

private fun peripheralRepeaterInstruction(text: String, repeaterType: RepeaterType): String {
    val repeaterSymbolIndex = text.lastIndexOfAny(charArrayOf('*', '+', '?'))
    val elementText = text.take(repeaterSymbolIndex)
    return when (repeaterType.minReps) {
        0 -> "remove it"
        1 -> "just use \"$elementText\""
        else -> "just use \"$elementText*${repeaterType.minReps}\""
    }
}

abstract class LscBadSequence(
    cause: LscBadSequence?,
    prefix: String,
    val sequence: String?,
    val environment: String?,
    postfix: String
) : LscUserError(
    interiorWordBoundaryMessage(
        prefix,
        sequence,
        environment,
        postfix,
    ), cause
) {

    abstract fun initEnvironment(newEnvironment: String): LscBadSequence

    abstract fun initSequence(newSequence: String): LscBadSequence
}

private fun interiorWordBoundaryMessage(
    prefix: String,
    sequence: String?,
    environment: String?,
    postfix: String,
): String {
    val sequenceText = if (sequence == null || sequence == environment) null else "in \"$sequence\""
    val environmentText = environment?.let { "in the environment \"$environment\"" }
    return listOfNotNull(
        prefix, sequenceText, environmentText, postfix
    ).joinToString(" ")
}

class LscRuleNotFound(val ruleName: String, val attemptedAction: String) :
    LscUserError("Can't $attemptedAction rule $ruleName; there is no rule with that name")

class LscIntersectionInOutput(val elements: List<Emitter>) :
    LscUserError("Multiple criteria ${elements.joinToString()} aren't allowed in the output of a rule")

class LscDivergingPropagation(val rule: ChangeRule, val initialWord: String, val wordsAtAbort: List<String>) :
    LscUserError(
        "Propagating rule $rule applied to rule $initialWord appears " +
                "not to settle on a result; the last few versions of the word were ${wordsAtAbort.joinToString(" -> ")}"
    )

class LscTooManyOptions(val matcher: Any) :
    LscUserError(
        "Too many possibilities when matching $matcher"
    )

class LscFutureStructure(val structureName: String) : LscUserError(structureName)
