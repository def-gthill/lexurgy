package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

class SoundChanger(
    val declarations: Declarations,
    val rules: List<NamedRule>,
    val intermediateRomanizers: Map<String?, List<NamedRule>> = emptyMap()
) {
    init {
        val duplicated = rules.groupBy { it.name }.filterValues { it.size > 1 }.keys.firstOrNull()
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
        val debugIndices = words.withIndex().filter { it.value in debugWords }.map { it.index }
        val startWords = words.map(declarations::parsePhonetic)

        val result = mutableMapOf<String?, List<String>>()

        var curWords = startWords
        var started = false
        var stopped = false

        fun maybeReplace(realRomanizer: NamedRule): NamedRule =
            if (romanize) realRomanizer else StandardNamedRule("fake-romanizer", EmptyRule)

        fun runIntermediateRomanizers(ruleName: String?) {
            intermediateRomanizers[ruleName]?.forEach { rom ->
                result[rom.name] = applyRule(
                    maybeReplace(rom), words, curWords, debugIndices, debug
                ).map { it.string }
            }
        }

        for (rule in rules) {
            if (rule.name == stopBefore) {
                stopped = true
                break
            }
            if (rule.ruleType == RuleType.ROMANIZER) {
                runIntermediateRomanizers(null)
            } else {
                runIntermediateRomanizers(rule.name)
            }
            if (!started && (startAt == null || rule.name == startAt)) {
                started = true
            }
            if (started) {
                if (romanize || rule.ruleType != RuleType.ROMANIZER) {
                    curWords = applyRule(
                        rule, words, curWords, debugIndices, debug
                    )
                }
            }
        }

        if (rules.lastOrNull()?.ruleType != RuleType.ROMANIZER) {
            runIntermediateRomanizers(null)
        }

        if (stopBefore != null && !stopped) {
            throw LscRuleNotFound(stopBefore, "stop before")
        }
        if (startAt != null && !started) {
            throw LscRuleNotFound(startAt, "start at")
        }

        result[null] = curWords.map { it.string.normalizeCompose() }

        return result
    }

    private fun applyRule(
        rule: NamedRule,
        origWords: List<String>,
        curWords: List<Word>,
        debugIndices: List<Int>,
        debug: (String) -> Unit,
    ): List<Word> =
        curWords.fastZipMap(origWords) { curWord, word ->
            try {
                rule(Phrase.splitWord(curWord)).toWord()
            } catch (e: Exception) {
                if (e is UserError) throw LscRuleNotApplicable(e, rule.name, word, curWord.string)
                else throw LscRuleCrashed(e, rule.name, word, curWord.string)
            }
        }.also { newWords ->
            for (i in debugIndices) {
                if (newWords[i] != curWords[i]) {
                    debug("Applied ${rule.name}: ${curWords[i].string} -> ${newWords[i].string}")
                }
            }
        }

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

internal fun Iterable<String>.maxLength(): Int = map { it.lengthCombining() }.maxOrNull() ?: 0

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

    override fun invoke(phrase: Phrase): Phrase
}

enum class RuleType {
    NORMAL,
    DEROMANIZER,
    ROMANIZER,
}

class StandardNamedRule(
    override val name: String,
    val mainBlock: ChangeRule,
    override val ruleType: RuleType = RuleType.NORMAL,
    val filter: ((Segment) -> Boolean)? = null,
    val propagate: Boolean = false,
) : NamedRule {
    private val maxPropagateSteps = 100

    override operator fun invoke(phrase: Phrase): Phrase {
        if (propagate) {
            var curPhrase = phrase
            val steps = mutableSetOf(curPhrase)
            for (i in 1..maxPropagateSteps) {
                val newPhrase = mainBlock(curPhrase) ?: curPhrase
                if (newPhrase == curPhrase) return newPhrase
                if (newPhrase in steps) throw LscDivergingPropagation(this, phrase.string, steps.map { it.string })
                steps += newPhrase
                curPhrase = newPhrase
            }
            throw LscDivergingPropagation(this, phrase.string, steps.map { it.string }.takeLast(5))
        } else {
            return mainBlock(phrase) ?: phrase
        }
    }

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
 * of expressions and an optional filter
 */
class SimpleChangeRule(
    val expressions: List<RuleExpression>,
    val filter: ((Segment) -> Boolean)? = null
) : ChangeRule {
    override operator fun invoke(phrase: Phrase): Phrase {
        val (filteredWords, filterMaps) =
            if (filter == null) phrase to null else phrase.map(::filterWord).unzip()
        val filteredPhrase = Phrase(filteredWords.toList())
        val allTransformations = expressions.mapIndexed { i, expr -> expr.claim(i, filteredPhrase) }.flatten()
        val validTransformations = filterOverlappingClaims(allTransformations)
        val realTransformations = unfilterTransformations(phrase, filterMaps, validTransformations)

        val bits = mutableListOf<Phrase>()
        var cursor = PhraseIndex(0, 0)
        for (transformation in realTransformations.sortedBy { it.start }) {
            if (cursor > transformation.start) continue
            bits += phrase.slice(cursor, transformation.start)
            bits += transformation.result
            cursor = transformation.end
        }
        bits += phrase.dropUntil(cursor)
        return Phrase.fromSubPhrases(bits)
    }

    private fun filterWord(word: Word): Pair<Word, IntArray> {
        val resultBits = mutableListOf<Segment>()
        val filterMap = mutableListOf<Int>()
        var filterIndex = 0
        for ((i, seg) in word.segments.withIndex()) {
            if (filter!!(seg)) {
                resultBits += seg
                filterMap += i
                filterIndex++
            }
        }
        return StandardWord.fromSegments(resultBits) to filterMap.toIntArray()
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
                Transformation(sub.order, filterIndex, phrase.advance(filterIndex), sub.result)
            }
        }
    }

    override fun toString(): String = expressions.joinToString().ifBlank { "<no changes>" }
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

class RuleExpression(
    val declarations: Declarations,
    val match: Matcher,
    val result: Emitter,
    val condition: List<Environment>,
    val exclusion: List<Environment>,
    val filtered: Boolean = false
) {
    val transformer = match.transformerTo(result, filtered)

    private val realCondition =
        if (condition.isEmpty()) listOf(Environment(EmptyMatcher, EmptyMatcher))
        else condition.map { it.beforeReversed() }

    private val realExclusion = exclusion.map { it.beforeReversed() }

    fun claim(expressionNumber: Int, phrase: Phrase): List<Transformation> {
        var index = PhraseIndex(0, 0)
        val exclusions = mutableSetOf<PhraseIndex>()

        while (true) {
            val exclusionStart = claimNextExclusion(phrase, index) ?: break
            exclusions.add(exclusionStart)
            index = phrase.advance(exclusionStart)
        }

        index = PhraseIndex(0, 0)
        val result = mutableListOf<Transformation>()

        while (true) {
            val transformation = claimNext(expressionNumber, phrase, index) ?: break
            if (transformation.start !in exclusions)
                result += transformation
            index = phrase.advance(transformation.start)
        }

        return result
    }

    private fun claimNext(expressionNumber: Int, phrase: Phrase, start: PhraseIndex): Transformation? {
        val reversedWords = phrase.fullyReversed()
        for (matchStart in phrase.iterateFrom(start)) {
            for (environment in realCondition) {
                val bindings = Bindings()
                environment.before.claim(
                    declarations, reversedWords, phrase.reversedIndex(matchStart), bindings
                ) ?: continue
                val transformation = transformer.transform(
                    expressionNumber, declarations, phrase, matchStart, bindings
                ) ?: continue
                environment.after.claim(
                    declarations, phrase, transformation.end, bindings
                ) ?: continue
                return transformation.bindVariables(bindings)
            }
        }
        return null
    }

    private fun claimNextExclusion(phrase: Phrase, start: PhraseIndex): PhraseIndex? {
        val reversedPhrase = phrase.fullyReversed()
        for (matchStart in phrase.iterateFrom(start)) {
            for (environment in realExclusion) {
                val bindings = Bindings()
                environment.before.claim(
                    declarations, reversedPhrase, phrase.reversedIndex(matchStart), bindings
                ) ?: continue
                val matchEnd = match.claim(
                    declarations, phrase, matchStart, bindings
                ) ?: continue
                environment.after.claim(
                    declarations, phrase, matchEnd, bindings
                ) ?: continue
                return matchStart
            }
        }
        return null
    }

    override fun toString(): String {
        fun environtext(sep: String, environ: List<Environment>) =
            when (environ.size) {
                0 -> ""
                1 -> " $sep ${environ.single()}"
                else -> " $sep ${environ.joinToString(prefix = "{", postfix = "}")}"
            }

        return "$match => $result${environtext("/", condition)}${environtext("//", exclusion)}"
    }
}

class Environment(val before: Matcher, val after: Matcher) {
    fun beforeReversed(): Environment = Environment(before.reversed(), after)

    override fun toString(): String = "$before _ $after"
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
        LscInteriorWordBoundary(cause, sequence, environment ?: newEnvironment)

    override fun initSequence(newSequence: String): LscBadSequence =
        LscInteriorWordBoundary(cause, sequence ?: newSequence, environment)
}

class LscPeripheralRepeater(
    override val cause: LscPeripheralRepeater?,
    val repeater: String,
    sequence: String?,
    environment: String?
) : LscBadSequence(
    cause,
    "The repeater \"$repeater\"",
    sequence,
    environment,
    "is meaningless because it's at the edge of the environment; " +
            peripheralRepeaterInstruction(repeater),
) {

    constructor(repeater: String) : this(null, repeater, null, null)

    override fun initEnvironment(newEnvironment: String): LscPeripheralRepeater =
        LscPeripheralRepeater(cause, repeater, sequence, environment ?: newEnvironment)

    override fun initSequence(newSequence: String): LscPeripheralRepeater =
        LscPeripheralRepeater(cause, repeater, sequence ?: newSequence, environment)
}

private fun peripheralRepeaterInstruction(repeater: String) =
    if (repeater.endsWith("+")) "just use \"${repeater.dropLast(1)}\"" else "remove it"

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
