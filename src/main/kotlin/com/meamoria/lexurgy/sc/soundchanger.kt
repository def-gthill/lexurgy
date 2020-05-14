package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import java.lang.IllegalArgumentException

class SoundChanger(
    val rules: List<ChangeRule>,
    val deromanizer: Deromanizer,
    val romanizer: Romanizer
) : SoundChangerLscWalker.ParseNode {

    operator fun invoke(word: String): String {
        val startWord = PlainWord(word)
        var curWord = deromanizer(startWord)
        for (rule in rules) curWord = rule(curWord)
        val endWord = romanizer(curWord)
        return endWord.string
    }

    companion object {
        fun fromLsc(code: String): SoundChanger {
            val walker = SoundChangerLscWalker()
            val parser = LscInterpreter(walker)
            return parser.parseFile(code) as SoundChanger
        }
    }

    override fun toString(): String = (listOf(deromanizer) + rules + romanizer).joinToString(
        separator = "; ", prefix = "SoundChanger(", postfix = ")"
    )
}

abstract class SimpleChangeRule<I : Segment<I>, O : Segment<O>>(
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

class Deromanizer(expressions: List<RuleExpression<PlainS, PhonS>>, declarations: Declarations) :
    SimpleChangeRule<PlainS, PhonS>(Plain, Phonetic, expressions, defaultRuleFor(declarations)) {
    companion object {
        fun empty(declarations: Declarations): Deromanizer = Deromanizer(emptyList(), declarations)

        private fun defaultRuleFor(declarations: Declarations): (Word<PlainS>) -> Word<PhonS> =
            declarations::parsePhonetic
    }
}

class Romanizer(expressions: List<RuleExpression<PhonS, PlainS>>) :
    SimpleChangeRule<PhonS, PlainS>(Phonetic, Plain, expressions, { PlainWord(it.string) }) {
    companion object {
        fun empty(): Romanizer = Romanizer(emptyList())
    }
}

class ChangeRule(
    val name: String,
    expressions: List<List<RuleExpression<PhonS, PhonS>>>,
    val filter: ((PhoneticSegment) -> Boolean)?,
    val propagate: Boolean) {

    val subrules: List<SimpleChangeRule<PhonS, PhonS>> = expressions.map { Subrule(it, filter) }

    operator fun invoke(word: Word<PhonS>): Word<PhonS> {
        var curWord = word
        for (subrule in subrules) curWord = subrule(curWord)
        return curWord
    }

    private class Subrule(expressions: List<RuleExpression<PhonS, PhonS>>, filter: ((PhoneticSegment) -> Boolean)?) :
        SimpleChangeRule<PhonS, PhonS>(Phonetic, Phonetic, expressions, { x -> x }, filter)

    override fun toString(): String = subrules.joinToString(
        separator = " then ", prefix = "Rule $name: "
    )
}

class RuleExpression<I : Segment<I>, O : Segment<O>>(
    val inType: SegmentType<I>,
    val outType: SegmentType<O>,
    val declarations: Declarations,
    val match: Matcher<I>,
    val result: Emitter<I, O>,
    val condition: List<Environment<I>>,
    val exclusion: List<Environment<I>>,
    val filtered: Boolean = false
) {
    val transformer = makeTransformer(match, result)

    private val realEnvironment =
        if (condition.isEmpty()) listOf(Environment(TextMatcher(inType.empty), TextMatcher(inType.empty)))
        else condition

    private fun makeTransformer(match: Matcher<I>, result: Emitter<I, O>): Transformer<I, O> {
        if (filtered && match is TextMatcher) {
            if (match.text.string.isEmpty()) {
                throw LscInvalidRuleExpression(
                    match, result, "Asterisks aren't allowed on the match side of filtered rules"
                )
            }
            else if (match.text.string.length > 1) {
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
            val claimResult = claimNext(expressionNumber, word, index) ?: break
            val (transformation, matchStart) = claimResult
            if (transformation.start !in exclusions)
                result += transformation
            index = matchStart + 1
        }

        return result
    }

    private fun claimNext(expressionNumber: Int, word: Word<I>, start: Int): TransformationWithMatchStart<O>? {
        for (matchStart in start until word.length) {
            for (environment in realEnvironment) {
                val bindings = Bindings()
                val beforeMatchEnd = environment.before.claim(
                    declarations, word, matchStart, bindings
                ) ?: continue
                val transformation = transformer.transform(
                    expressionNumber, declarations, word, beforeMatchEnd, bindings
                ) ?: continue
                environment.after.claim(
                    declarations, word, transformation.end, bindings
                ) ?: continue
                return TransformationWithMatchStart(transformation.bindVariables(bindings), matchStart)
            }
        }
        return null
    }

    private fun claimNextExclusion(word: Word<I>, start: Int): Int? {
        for (matchStart in start until word.length) {
            for (environment in exclusion) {
                val bindings = Bindings()
                val beforeMatchEnd = environment.before.claim(
                    declarations, word, matchStart, bindings
                ) ?: continue
                val matchEnd = match.claim(
                    declarations, word, beforeMatchEnd, bindings
                ) ?: continue
                environment.after.claim(
                    declarations, word, matchEnd, bindings
                ) ?: continue
                return beforeMatchEnd
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

data class TransformationWithMatchStart<O : Segment<O>>(val transformation: Transformation<O>, val matchStart: Int)

class Environment<I : Segment<I>>(val before: Matcher<I>, val after: Matcher<I>) {
    override fun toString(): String = "$before _ $after"
}

class LscRuleNotApplicable(cause: Exception, rule: String, originalWord: String, currentWord: String) :
    Exception(
        "Rule $rule could not be applied to word $currentWord (originally $originalWord)\nReason: ${cause.message}",
        cause
    )

class LscInvalidRuleExpression(
    val matcher: Matcher<*>, val emitter: Emitter<*, *>, message: String
) :
    Exception(message)

class LscMatrixInPlain(val matrix: Matrix) : Exception("Feature matrix $matrix isn't allowed in a romanized context")

class LscClassInPlain(val className: String) : Exception("Sound class $className isn't allowed in a romanized context")

class LscCaptureInPlain(val number: Int) : Exception("Capture $number isn't allowed in a romanized context")

class LscDivergingPropagation(val rule: ChangeRule, val initialWord: String, val wordsAtAbort: List<String>) :
    Exception(
        "Propagating rule $rule applied to rule $initialWord appears " +
                "not to settle on a result; the last few versions of the word were ${wordsAtAbort.joinToString(" -> ")}"
    )
