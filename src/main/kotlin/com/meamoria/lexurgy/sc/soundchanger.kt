package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.streams.toList
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

class SoundChanger(
    val declarations: Declarations,
    val rules: List<ChangeRule>,
    val deromanizer: Deromanizer,
    val romanizer: Romanizer,
    val intermediateRomanizers: Map<String, IntermediateRomanizer> = emptyMap()
) : SoundChangerLscWalker.ParseNode {
    operator fun invoke(word: String): String = change(listOf(word)).single()

    @ExperimentalTime
    fun changeFiles(
        wordsPaths: List<Path>,
        startAt: String? = null,
        stopBefore: String? = null,
        inSuffix: String? = null,
        outSuffix: String = "ev",
        debugWords: List<String> = emptyList(),
        intermediates: Boolean = false,
        romanize: Boolean = true,
        compareStages: Boolean = false,
        compareVersions: Boolean = false
    ) {
        for (wordsPath in wordsPaths) {
            console("Applying changes to words in ${suffixPath(wordsPath, inSuffix)}")

            UnicodeLogger.path = suffixPath(wordsPath, "trace")

            val words = loadList(wordsPath, suffix = inSuffix)

            val (wordListSequence, time) = if (intermediates) {
                val (stages, time) = measureTimedValue {
                    changeWithIntermediates(
                        words,
                        startAt = startAt,
                        stopBefore = stopBefore,
                        debugWords = debugWords,
                        romanize = romanize
                    )
                }

                val intermediateStages = stages.filterKeys { it != null }

                for ((name, stageWords) in intermediateStages) {
                    dumpList(wordsPath, stageWords, suffix = name)
                    console("Wrote the forms at stage $name to ${suffixPath(wordsPath, name)}")
                }

                TimedValue(
                    listOf(words) + intermediateStages.values + listOf(stages.getValue(null)),
                    time
                )
            } else {
                measureTimedValue {
                    listOf(
                        words,
                        change(
                            words,
                            startAt = startAt,
                            stopBefore = stopBefore,
                            debugWords = debugWords,
                            romanize = romanize
                        )
                    )
                }
            }

            val finalWords = wordListSequence.last()

            val stageCompare =
                if (compareStages) makeStageComparisons(wordListSequence) else finalWords

            val versionCompare =
                if (compareVersions) {
                    val previous = loadList(wordsPath, suffix = outSuffix)
                    makeVersionComparisons(finalWords, previous, stageCompare)
                } else stageCompare

            console(
                "Applied the changes to ${enpl(words.size, "word")} in ${"%.3f".format(time.inSeconds)} seconds"
            )

            dumpList(wordsPath, finalWords, suffix = outSuffix)
            console("Wrote the final forms to ${suffixPath(wordsPath, outSuffix)}")

            if (compareStages || compareVersions) {
                val markupPath = wordsPath.replaceExtension("wlm")
                dumpList(markupPath, versionCompare, suffix = outSuffix)
                console("Wrote comparison markup to ${suffixPath(markupPath, outSuffix)}")
            }
        }
    }

    private fun makeStageComparisons(wordListSequence: List<List<String>>): List<String> {
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

    private fun makeVersionComparisons(
        newWords: List<String>, previousWords: List<String>, stageCompare: List<String>
    ): List<String> {
        // If the list has changed length, the user has definitely changed the
        // input wordlist, so any comparisons are likely to be meaningless.
        if (newWords.size != previousWords.size) return stageCompare

        val maxLength = stageCompare.maxLength()
        return stageCompare.zip(
            newWords.zip(previousWords) { newWord, previousWord ->
                if (newWord == previousWord) null else previousWord
            }
        ) { compare, previousWord ->
            if (previousWord == null) compare
            else compare.padEndCombining(maxLength + 1) + "XX " + previousWord
        }
    }

    private fun Iterable<String>.maxLength(): Int = map { it.length }.max() ?: 0

    fun change(
        words: List<String>,
        startAt: String? = null,
        stopBefore: String? = null,
        debugWords: List<String> = emptyList(),
        romanize: Boolean = true
    ): List<String> = changeWithIntermediates(
        words,
        startAt = startAt,
        stopBefore = stopBefore,
        debugWords = debugWords,
        romanize = romanize
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
        romanize: Boolean = true
    ): Map<String?, List<String>> {
        val debugIndices = words.withIndex().filter { it.value in debugWords }.map { it.index }
        val startWords =
            if (startAt == null) applyRule(deromanizer, words, words.map(::PlainWord), debugIndices)
            else words.map(declarations::parsePhonetic)

        val result = mutableMapOf<String?, List<String>>()

        var curWords = startWords
        var started = false
        var stopped = false

        if (!UnicodeLogger.debugFilePathIsInitialized) UnicodeLogger.path = Paths.get("words.debug")

        fun maybeReplace(realRomanizer: Romanizer): Romanizer =
            if (romanize) realRomanizer else Romanizer.empty()

        for (rule in rules) {
            if (rule.name == stopBefore) {
                stopped = true
                break
            }
            intermediateRomanizers[rule.name]?.let { rom ->
                result[rom.name] = applyRule(
                    maybeReplace(rom.romanizer), words, curWords, debugIndices
                ).map { it.string }
            }
            if (!started && (startAt == null || rule.name == startAt)) {
                started = true
            }
            if (started) {
                curWords = applyRule(rule, words, curWords, debugIndices)
            }
        }

        if (stopBefore != null && !stopped) {
            console("WARNING: No rule called $stopBefore; all rules applied")
        }
        if (startAt != null && !started) {
            console("WARNING: No rule called $startAt; no rules applied")
        }

        result[null] = if (stopBefore == null) applyRule(
            maybeReplace(romanizer), words, curWords, debugIndices
        ).map { it.string }
        else curWords.map { it.string }

        return result
    }

    private fun <I : Segment<I>, O : Segment<O>> applyRule(
        rule: NamedRule<I, O>, origWords: List<String>, curWords: List<Word<I>>, debugIndices: List<Int>
    ): List<Word<O>> =
        curWords.zip(origWords).parallelStream().map { (curWord, word) ->
            try {
                rule(curWord)
            } catch (e: Exception) {
                if (e is LscUserError) throw LscRuleNotApplicable(e, rule.name, word, curWord.string)
                else throw LscRuleCrashed(e, rule.name, word, curWord.string)
            }
        }.toList().also { newWords ->
            for (i in debugIndices) {
                if (newWords[i] != curWords[i]) {
                    debug("Applied ${rule.name}: ${curWords[i].string} -> ${newWords[i].string}")
                }
            }
        }

    companion object {
        @ExperimentalTime
        fun changeFiles(
            changesPath: Path,
            wordsPaths: List<Path>,
            startAt: String? = null,
            stopBefore: String? = null,
            inSuffix: String? = null,
            outSuffix: String = "ev",
            debugWords: List<String> = emptyList(),
            intermediates: Boolean = false,
            romanize: Boolean = true,
            compareStages: Boolean = false,
            compareVersions: Boolean = false
        ) {
            console("Loading sound changes from $changesPath")
            val changer = fromLscFile(changesPath)
            changer.changeFiles(
                wordsPaths,
                startAt = startAt,
                stopBefore = stopBefore,
                inSuffix = inSuffix,
                outSuffix = outSuffix,
                debugWords = debugWords,
                intermediates = intermediates,
                romanize = romanize,
                compareStages = compareStages,
                compareVersions = compareVersions
            )
        }

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

        fun fromLscFile(path: Path): SoundChanger =
            fromLsc(path.toFile().readLines().joinToString("\n"))
    }

    override fun toString(): String = (listOf(deromanizer) + rules + romanizer).joinToString(
        separator = "; ", prefix = "SoundChanger(", postfix = ")"
    )

    data class IntermediateRomanizer(val name: String, val romanizer: Romanizer)
}

interface NamedRule<I : Segment<I>, O : Segment<O>> {
    val name: String

    operator fun invoke(word: Word<I>): Word<O>
}

class SimpleChangeRule<I : Segment<I>, O : Segment<O>>(
    val inType: SegmentType<I>,
    val outType: SegmentType<O>,
    val expressions: List<RuleExpression<I, O>>,
    val defaultRule: (Word<I>) -> Word<O>,
    val filter: ((I) -> Boolean)? = null
) {
    operator fun invoke(word: Word<I>): Word<O> {
        val (filteredWord, filterMap) = filterWord(word)
        val allTransformations = expressions.mapIndexed { i, expr -> expr.claim(i, filteredWord) }.flatten()
        val validTransformations = filterOverlappingClaims(allTransformations)
        val realTransformations = unfilterTransformations(filterMap, validTransformations)

        val bits = mutableListOf<Word<O>>()
        var cursor = 0
        for (transformation in realTransformations.sortedBy { it.start }) {
            if (cursor > transformation.start) continue
            bits += defaultRule(word.slice(cursor until transformation.start))
            bits += transformation.result
            cursor = transformation.start + transformation.length
        }
        bits += defaultRule(word.drop(cursor))
        return outType.join(bits)
    }

    private fun filterWord(word: Word<I>): Pair<Word<I>, IntArray?> {
        if (filter == null) return word to null

        val resultBits = mutableListOf<I>()
        val filterMap = mutableListOf<Int>()
        var filterIndex = 0
        for ((i, seg) in word.segments.withIndex()) {
            if (filter.invoke(seg)) {
                resultBits += seg
                filterMap += i
                filterIndex++
            }
        }
        return inType.fromSegments(resultBits) to filterMap.toIntArray()
    }

    // Strips out transformatinos that would try to change something that's already being changed.
    // Assumes the transformations argument is already sorted in precedence order.
    private fun filterOverlappingClaims(transformations: List<Transformation<O>>): List<Transformation<O>> {
        val claimed = mutableSetOf<Int>()
        val result = mutableListOf<Transformation<O>>()
        for (transformation in transformations) {
            val thisClaim = transformation.start until transformation.end
            if (thisClaim.any { it in claimed }) continue
            claimed.addAll(thisClaim)
            result += transformation
        }
        return result
    }

    private fun unfilterTransformations(
        filterMap: IntArray?, transformations: List<Transformation<O>>
    ): List<Transformation<O>> {
        if (filterMap == null) return transformations

        return transformations.flatMap { tr ->
            tr.elementalSubs.map { sub ->
                Transformation(sub.order, filterMap[sub.start], 1, sub.result)
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

    override fun invoke(word: Word<PlainS>): Word<PhonS> =
        phoneticRules.invoke(deromanizerRule.invoke(word))

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

    override fun invoke(word: Word<PhonS>): Word<PlainS> =
        romanizerRule.invoke(phoneticRules.invoke(word))

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

    override operator fun invoke(word: Word<PhonS>): Word<PhonS> {
        if (propagate) {
            var curWord = word
            val steps = mutableSetOf(curWord)
            for (i in 1..maxPropagateSteps) {
                val newWord = applyOnce(curWord)
                if (newWord == curWord) return newWord
                if (newWord in steps) throw LscDivergingPropagation(this, word.string, steps.map { it.string })
                steps += newWord
                curWord = newWord
            }
            throw LscDivergingPropagation(this, word.string, steps.map { it.string }.takeLast(5))
        } else {
            return applyOnce(word)
        }
    }

    private fun applyOnce(word: Word<PhonS>): Word<PhonS> {
        var curWord = word
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
            SimpleTransformer(match, result)
        } else {
            throw IllegalArgumentException(
                "Invalid element types: ${match.javaClass.name} and ${result.javaClass.name}"
            )
        }

    private fun mismatchedLengths(
        match: Matcher<I>, result: Emitter<I, O>, matchLength: Int, resultLength: Int
    ): Nothing = throw LscInvalidRuleExpression(
        match, result, "Found ${enpl(matchLength, "element")} on the left side but $resultLength on the right side"
    )

    fun claim(expressionNumber: Int, word: Word<I>): List<Transformation<O>> {
        var index = 0
        val exclusions = mutableSetOf<Int>()

        while (true) {
            val exclusionStart = claimNextExclusion(word, index) ?: break
            exclusions.add(exclusionStart)
            index = exclusionStart + 1
        }

        index = 0
        val result = mutableListOf<Transformation<O>>()

        while (true) {
            val transformation = claimNext(expressionNumber, word, index) ?: break
            if (transformation.start !in exclusions)
                result += transformation
            index = transformation.start + 1
        }

        return result
    }

    private fun claimNext(expressionNumber: Int, word: Word<I>, start: Int): Transformation<O>? {
        for (matchStart in start..word.length) {
            for (environment in realCondition) {
                val bindings = Bindings()
                environment.before.claim(
                    declarations, word.reversed(), word.length - matchStart, bindings
                ) ?: continue
                val transformation = transformer.transform(
                    expressionNumber, declarations, word, matchStart, bindings
                ) ?: continue
                environment.after.claim(
                    declarations, word, transformation.end, bindings
                ) ?: continue
                return transformation.bindVariables(bindings)
            }
        }
        return null
    }

    private fun claimNextExclusion(word: Word<I>, start: Int): Int? {
        for (matchStart in start until word.length) {
            for (environment in realExclusion) {
                val bindings = Bindings()
                environment.before.claim(
                    declarations, word.reversed(), word.length - matchStart, bindings
                ) ?: continue
                val matchEnd = match.claim(
                    declarations, word, matchStart, bindings
                ) ?: continue
                environment.after.claim(
                    declarations, word, matchEnd, bindings
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

class LscMatrixInPlain(val matrix: Matrix) :
    LscUserError("Feature matrix $matrix isn't allowed in a romanized context")

class LscClassInPlain(val className: String) :
    LscUserError("Sound class $className isn't allowed in a romanized context")

class LscCaptureInPlain(val number: Int) :
    LscUserError("Capture $number isn't allowed in a romanized context")

class LscDivergingPropagation(val rule: ChangeRule, val initialWord: String, val wordsAtAbort: List<String>) :
    LscUserError(
        "Propagating rule $rule applied to rule $initialWord appears " +
                "not to settle on a result; the last few versions of the word were ${wordsAtAbort.joinToString(" -> ")}"
    )
