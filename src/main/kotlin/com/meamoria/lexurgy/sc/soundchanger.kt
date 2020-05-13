package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import java.lang.IllegalArgumentException

class SoundChanger(
    val rules: List<ChangeRule>, val deromanizer: Deromanizer, val romanizer: Romanizer
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
        separator = "; ", prefix = "SoundChanger(", postfix = ")")
}

abstract class SimpleChangeRule<I : Segment<I>, O : Segment<O>>(
    val inType: SegmentType<I>,
    val outType: SegmentType<O>,
    val expressions: List<RuleExpression<I, O>>,
    val defaultRule: (Word<I>) -> Word<O>
) {
    operator fun invoke(word: Word<I>): Word<O> {
        val allTransformations = expressions.mapIndexed { i, expr -> expr.claim(i, word) }.flatten()
        val validTransformations = filterOverlappingClaims(allTransformations)

        val bits = mutableListOf<Word<O>>()
        var cursor = 0
        for (transformation in validTransformations.sortedBy { it.start }) {
            if (cursor > transformation.start) continue
            bits += defaultRule(word.slice(cursor until transformation.start))
            bits += transformation.result
            cursor = transformation.start + transformation.length
        }
        bits += defaultRule(word.drop(cursor))
        return outType.join(bits)
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

class ChangeRule(val name: String, expressions: List<List<RuleExpression<PhonS, PhonS>>>) {
    val subrules: List<SimpleChangeRule<PhonS, PhonS>> = expressions.map { Subrule(it) }

    operator fun invoke(word: Word<PhonS>): Word<PhonS> {
        var curWord = word
        for (subrule in subrules) curWord = subrule(curWord)
        return curWord
    }

    private class Subrule(expressions: List<RuleExpression<PhonS, PhonS>>) :
        SimpleChangeRule<PhonS, PhonS>(Phonetic, Phonetic, expressions, { x -> x })

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
    val exclusion: List<Environment<I>>
) {
    val transformer = makeTransformer(match, result)

    private val realEnvironment =
        if (condition.isEmpty()) listOf(Environment(TextMatcher(inType.empty), TextMatcher(inType.empty)))
        else condition

    private fun makeTransformer(match: Matcher<I>, result: Emitter<I, O>): Transformer<I, O> =
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

class LscInvalidRuleExpression(
    val matcher: Matcher<*>, val emitter: Emitter<*, *>, message: String
) :
    Exception(message)

class LscMatrixInPlain(val matrix: Matrix) : Exception("Feature matrix $matrix isn't allowed in a romanized context")

class LscClassInPlain(val className: String): Exception("Sound class $className isn't allowed in a romanized context")

class LscCaptureInPlain(val number: Int): Exception("Capture $number isn't allowed in a romanized context")
