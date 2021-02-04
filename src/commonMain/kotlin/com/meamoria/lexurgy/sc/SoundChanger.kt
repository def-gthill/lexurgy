package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

class SoundChanger(
    val declarations: Declarations,
    val rules: List<ChangeRule>,
    val deromanizer: Deromanizer,
    val romanizer: Romanizer,
    val intermediateRomanizers: Map<String?, List<IntermediateRomanizer>> = emptyMap()
) : SoundChangerLscWalker.ParseNode {
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
        val startWords =
            if (startAt == null) applyRule(
                Phonetic, deromanizer, words, words.map(::PlainWord), debugIndices, debug
            )
            else words.map(declarations::parsePhonetic)

        val result = mutableMapOf<String?, List<String>>()

        var curWords = startWords
        var started = false
        var stopped = false

        fun maybeReplace(realRomanizer: Romanizer): Romanizer =
            if (romanize) realRomanizer else Romanizer.empty()

        fun runIntermediateRomanizers(ruleName: String?) {
            intermediateRomanizers[ruleName]?.forEach { rom ->
                result[rom.name] = applyRule(
                    Plain, maybeReplace(rom.romanizer), words, curWords, debugIndices, debug
                ).map { it.string }
            }
        }

        for (rule in rules) {
            if (rule.name == stopBefore) {
                stopped = true
                break
            }
            runIntermediateRomanizers(rule.name)
            if (!started && (startAt == null || rule.name == startAt)) {
                started = true
            }
            if (started) {
                curWords = applyRule(
                    Phonetic, rule, words, curWords, debugIndices, debug
                )
            }
        }
        runIntermediateRomanizers(null)

        if (stopBefore != null && !stopped) {
            throw LscRuleNotFound(stopBefore, "stop before")
        }
        if (startAt != null && !started) {
            throw LscRuleNotFound(startAt, "start at")
        }

        result[null] = if (stopBefore == null) applyRule(
            Plain, maybeReplace(romanizer), words, curWords, debugIndices, debug
        ).map { it.string }
        else curWords.map { it.string }

        return result
    }

    private fun <I : Segment<I>, O : Segment<O>> applyRule(
        outType: SegmentType<O>,
        rule: NamedRule<I, O>,
        origWords: List<String>,
        curWords: List<Word<I>>,
        debugIndices: List<Int>,
        debug: (String) -> Unit,
    ): List<Word<O>> =
        curWords.fastZipMap(origWords) { curWord, word ->
            try {
                outType.joinWithSpaces(rule(curWord.split()))
            } catch (e: Exception) {
                if (e is LscUserError) throw LscRuleNotApplicable(e, rule.name, word, curWord.string)
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
            val walker = SoundChangerLscWalker()
            val parser = LscInterpreter(walker)
            return parser.parseFile(code) as SoundChanger
        }
    }

    override fun toString(): String = (listOf(deromanizer) + rules + romanizer).joinToString(
        separator = "; ", prefix = "SoundChanger(", postfix = ")"
    )

    data class IntermediateRomanizer(val name: String, val romanizer: Romanizer)
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

internal fun Iterable<String>.maxLength(): Int = map { it.length }.maxOrNull() ?: 0

expect fun <T, U, R> Iterable<T>.fastZipMap(other: Iterable<U>, function: (T, U) -> R): List<R>

interface NamedRule<I : Segment<I>, O : Segment<O>> {
    val name: String

    operator fun invoke(words: List<Word<I>>): List<Word<O>>
}

class SimpleChangeRule<I : Segment<I>, O : Segment<O>>(
    val inType: SegmentType<I>,
    val outType: SegmentType<O>,
    val expressions: List<RuleExpression<I, O>>,
    val defaultRule: (Word<I>) -> Word<O>,
    val filter: ((I) -> Boolean)? = null
) {
    operator fun invoke(words: List<Word<I>>): List<Word<O>> {
        val (filteredWords, filterMaps) =
            if (filter == null) words to null else words.map(::filterWord).unzip()
        val allTransformations = expressions.mapIndexed { i, expr -> expr.claim(i, filteredWords) }.flatten()
        val validTransformations = filterOverlappingClaims(allTransformations)
        val realTransformations = unfilterTransformations(words, filterMaps, validTransformations)

        val bits = mutableListOf<List<Word<O>>>()
        var cursor = WordListIndex(0, 0)
        for (transformation in realTransformations.sortedBy { it.start }) {
            if (cursor > transformation.start) continue
            bits += words.slice(cursor, transformation.start).map(defaultRule)
            bits += transformation.result
            cursor = transformation.end
        }
        bits += words.dropUntil(cursor).map(defaultRule)
        return outType.joinEdgeWords(bits)
    }

    private fun filterWord(word: Word<I>): Pair<Word<I>, IntArray> {
        val resultBits = mutableListOf<I>()
        val filterMap = mutableListOf<Int>()
        var filterIndex = 0
        for ((i, seg) in word.segments.withIndex()) {
            if (filter!!(seg)) {
                resultBits += seg
                filterMap += i
                filterIndex++
            }
        }
        return inType.fromSegments(resultBits) to filterMap.toIntArray()
    }

    // Strips out transformations that would try to change something that's already being changed.
    // Assumes the transformations argument is already sorted in precedence order.
    private fun filterOverlappingClaims(transformations: List<Transformation<O>>): List<Transformation<O>> {
        val claimed = mutableListOf<ClosedRange<WordListIndex>>()
        val result = mutableListOf<Transformation<O>>()
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
        words: List<Word<I>>, filterMap: List<IntArray>?, transformations: List<Transformation<O>>
    ): List<Transformation<O>> {
        if (filterMap == null) return transformations

        return transformations.flatMap { tr ->
            tr.elementalSubs.map { sub ->
                val (wordIndex, segmentIndex) = sub.start
                val filterIndex = WordListIndex(wordIndex, filterMap[wordIndex][segmentIndex])
                Transformation(sub.order, filterIndex, words.advance(filterIndex), sub.result)
            }
        }
    }

    override fun toString(): String = expressions.joinToString().ifBlank { "<no changes>" }
}

typealias PhonS = PhoneticSegment
typealias PlainS = PlainSegment

class Deromanizer(
    deromanizerExpressions: List<RuleExpression<PlainS, PhonS>>,
    phoneticExpressions: List<List<RuleExpression<PhonS, PhonS>>>,
    declarations: Declarations
) : NamedRule<PlainS, PhonS> {
    override val name: String = "deromanizer"

    val deromanizerRule = SimpleChangeRule(Plain, Phonetic, deromanizerExpressions, defaultRuleFor(declarations))
    val phoneticRules = ChangeRule(name, phoneticExpressions)

    override fun invoke(words: List<Word<PlainS>>): List<Word<PhonS>> =
        phoneticRules.invoke(deromanizerRule.invoke(words))

    companion object {
        fun empty(declarations: Declarations): Deromanizer = Deromanizer(emptyList(), emptyList(), declarations)

        private fun defaultRuleFor(declarations: Declarations): (Word<PlainS>) -> Word<PhonS> =
            declarations::parsePhonetic
    }
}

class Romanizer(
    phoneticExpressions: List<List<RuleExpression<PhonS, PhonS>>>,
    romanizerExpressions: List<RuleExpression<PhonS, PlainS>>
) : NamedRule<PhonS, PlainS> {
    override val name: String = "romanizer"

    val phoneticRules = ChangeRule(name, phoneticExpressions)
    val romanizerRule = SimpleChangeRule(Phonetic, Plain, romanizerExpressions, { PlainWord(it.string) })

    override fun invoke(words: List<Word<PhonS>>): List<Word<PlainS>> =
        romanizerRule.invoke(phoneticRules.invoke(words))

    companion object {
        fun empty(): Romanizer = Romanizer(emptyList(), emptyList())
    }
}

class ChangeRule(
    override val name: String,
    expressions: List<List<RuleExpression<PhonS, PhonS>>>,
    val filter: ((PhoneticSegment) -> Boolean)? = null,
    val propagate: Boolean = false
) : NamedRule<PhonS, PhonS> {
    private val maxPropagateSteps = 100

    val subrules: List<SimpleChangeRule<PhonS, PhonS>> =
        expressions.map { SimpleChangeRule(Phonetic, Phonetic, it, { x -> x }, filter) }

    override operator fun invoke(words: List<Word<PhonS>>): List<Word<PhonS>> {
        if (propagate) {
            var curWords = words
            val steps = mutableSetOf(curWords)
            for (i in 1..maxPropagateSteps) {
                val newWord = applyOnce(curWords)
                if (newWord == curWords) return newWord
                if (newWord in steps) throw LscDivergingPropagation(this, words.string, steps.map { it.string })
                steps += newWord
                curWords = newWord
            }
            throw LscDivergingPropagation(this, words.string, steps.map { it.string }.takeLast(5))
        } else {
            return applyOnce(words)
        }
    }

    private fun applyOnce(words: List<Word<PhonS>>): List<Word<PhonS>> {
        var curWord = words
        for (subrule in subrules) curWord = subrule(curWord)
        return curWord
    }

    override fun toString(): String = subrules.joinToString(
        separator = " then ", prefix = "Rule $name: "
    )
}

class RuleExpression<I : Segment<I>, O : Segment<O>>(
    @Suppress("unused") val inType: SegmentType<I>,
    val outType: SegmentType<O>,
    val declarations: Declarations,
    val match: Matcher<I>,
    val result: Emitter<I, O>,
    val condition: List<Environment<I>>,
    val exclusion: List<Environment<I>>,
    val filtered: Boolean = false
) {
    val transformer = makeTransformer(match, result)

    private val realCondition =
        if (condition.isEmpty()) listOf(Environment(NullMatcher(), NullMatcher()))
        else condition.map { it.beforeReversed() }

    private val realExclusion = exclusion.map { it.beforeReversed() }

    private fun makeTransformer(match: Matcher<I>, result: Emitter<I, O>): Transformer<I, O> {
        if (filtered) {
            if (match is NullMatcher) {
                throw LscInvalidRuleExpression(
                    match, result, "Asterisks aren't allowed on the match side of filtered rules"
                )
            } else if (match is AbstractTextMatcher && match.text.length > 1) {
                throw LscInvalidRuleExpression(
                    match, result, "Multi-segment matches aren't allowed on the match side of filtered rules"
                )
            }
        }
        return makeTransformerChecked(match, result)
    }


    private fun makeTransformerChecked(match: Matcher<I>, result: Emitter<I, O>): Transformer<I, O> =
        if (match is ListMatcher) {
            if (result is ListEmitter) {
                if (match.elements.size == result.elements.size) {
                    ListTransformer(match.elements.zip(result.elements, this::makeTransformer))
                } else {
                    mismatchedLengths(match, result, match.elements.size, result.elements.size)
                }
            } else {
                ListTransformer(match.elements.map { makeTransformer(it, result) })
            }
        } else if (result is ListEmitter) {
            mismatchedLengths(match, result, 1, result.elements.size)
        } else if (match is SequenceMatcher) {
            if (result is SequenceEmitter) {
                if (match.elements.size == result.elements.size) {
                    SequenceTransformer(outType, match.elements.zip(result.elements, this::makeTransformer))
                } else {
                    mismatchedLengths(match, result, match.elements.size, result.elements.size)
                }
            } else {
                mismatchedLengths(match, result, match.elements.size, 1)
            }
        } else if (result is SequenceEmitter) {
            mismatchedLengths(match, result, 1, result.elements.size)
        } else if (match is SimpleMatcher && result is SimpleEmitter) {
            if (result is MatrixEmitter && result.matrix.valueList.any { it is NegatedValue }) {
                throw LscInvalidOutputMatrix(result.matrix, "negated feature")
            }
            SimpleTransformer(match, result)
        } else {
            throw IllegalArgumentException(
                "Invalid element types: ${match::class.simpleName} and ${result::class.simpleName}"
            )
        }

    private fun mismatchedLengths(
        match: Matcher<I>, result: Emitter<I, O>, matchLength: Int, resultLength: Int
    ): Nothing = throw LscInvalidRuleExpression(
        match, result, "Found ${enpl(matchLength, "element")} on the left side but $resultLength on the right side"
    )

    fun claim(expressionNumber: Int, words: List<Word<I>>): List<Transformation<O>> {
        var index = WordListIndex(0, 0)
        val exclusions = mutableSetOf<WordListIndex>()

        while (true) {
            val exclusionStart = claimNextExclusion(words, index) ?: break
            exclusions.add(exclusionStart)
            index = words.advance(exclusionStart)
        }

        index = WordListIndex(0, 0)
        val result = mutableListOf<Transformation<O>>()

        while (true) {
            val transformation = claimNext(expressionNumber, words, index) ?: break
            if (transformation.start !in exclusions)
                result += transformation
            index = words.advance(transformation.start)
        }

        return result
    }

    private fun claimNext(expressionNumber: Int, words: List<Word<I>>, start: WordListIndex): Transformation<O>? {
        val reversedWords = words.fullyReversed()
        for (matchStart in words.iterateFrom(start)) {
            for (environment in realCondition) {
                val bindings = Bindings()
                environment.before.claim(
                    declarations, reversedWords, words.reversedIndex(matchStart), bindings
                ) ?: continue
                val transformation = transformer.transform(
                    expressionNumber, declarations, words, matchStart, bindings
                ) ?: continue
                environment.after.claim(
                    declarations, words, transformation.end, bindings
                ) ?: continue
                return transformation.bindVariables(bindings)
            }
        }
        return null
    }

    private fun claimNextExclusion(words: List<Word<I>>, start: WordListIndex): WordListIndex? {
        val reversedWords = words.fullyReversed()
        for (matchStart in words.iterateFrom(start)) {
            for (environment in realExclusion) {
                val bindings = Bindings()
                environment.before.claim(
                    declarations, reversedWords, words.reversedIndex(matchStart), bindings
                ) ?: continue
                val matchEnd = match.claim(
                    declarations, words, matchStart, bindings
                ) ?: continue
                environment.after.claim(
                    declarations, words, matchEnd, bindings
                ) ?: continue
                return matchStart
            }
        }
        return null
    }

    override fun toString(): String {
        fun environtext(sep: String, environ: List<Environment<I>>) =
            when (environ.size) {
                0 -> ""
                1 -> " $sep ${environ.single()}"
                else -> " $sep ${environ.joinToString(prefix = "{", postfix = "}")}"
            }

        return "$match => $result${environtext("/", condition)}${environtext("//", exclusion)}"
    }
}

class Environment<I : Segment<I>>(val before: Matcher<I>, val after: Matcher<I>) {
    fun beforeReversed(): Environment<I> = Environment(before.reversed(), after)

    override fun toString(): String = "$before _ $after"
}

class LscRuleNotApplicable(val reason: UserError, val rule: String, val originalWord: String, val currentWord: String) :
    LscUserError(
        "Rule $rule could not be applied to word $currentWord (originally $originalWord)\nReason: ${reason.message}",
        reason
    )

class LscRuleCrashed(val reason: Exception, val rule: String, val originalWord: String, val currentWord: String) :
    Exception(
        "Rule $rule encountered a programming error when applied to word $currentWord (originally $originalWord)",
        reason
    )

@Suppress("unused")
class LscInvalidRuleExpression(
    val matcher: Matcher<*>, val emitter: Emitter<*, *>, message: String
) : LscUserError(message)

class LscInteriorWordBoundary(
    override val cause: LscInteriorWordBoundary?,
    sequence: String?,
    environment: String?
) :
    LscBadSequence(
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
) :
    LscBadSequence(
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
) :
    LscUserError(
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

class LscMatrixInPlain(val matrix: Matrix) :
    LscUserError("Feature matrix $matrix isn't allowed in a romanized context")

class LscInvalidOutputMatrix(val matrix: Matrix, val invalidFeature: String) :
    LscUserError("Feature matrix $matrix has a $invalidFeature, which isn't allowed in the output of a rule")

class LscClassInPlain(val className: String) :
    LscUserError("Sound class $className isn't allowed in a romanized context")

class LscCaptureInPlain(val number: Int) :
    LscUserError("Capture $number isn't allowed in a romanized context")

class LscDivergingPropagation(val rule: ChangeRule, val initialWord: String, val wordsAtAbort: List<String>) :
    LscUserError(
        "Propagating rule $rule applied to rule $initialWord appears " +
                "not to settle on a result; the last few versions of the word were ${wordsAtAbort.joinToString(" -> ")}"
    )
