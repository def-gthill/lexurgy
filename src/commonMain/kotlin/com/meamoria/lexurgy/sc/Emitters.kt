package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

typealias UnboundResult = (Bindings) -> Phrase

/**
 * A device that produces segments in the output word.
 * Emitters can be either *conditional* (they depend on
 * the match result) or *independent* (they don't need
 * the match result). It's possible for an emitter to
 * be both conditional and independent, which means
 * it will change its output to suit the match result but also
 * has a reasonable default if the match result isn't available.
 */
interface Emitter {
    /**
     * Tests if this emitter is conditional, i.e. its output
     * depends on the match result.
     */
    fun isConditional(): Boolean

    /**
     * Tests if this emitter is independent, i.e. it can
     * produce output without knowing the match result.
     */
    fun isIndependent(): Boolean
}

class SequenceEmitter(val elements: List<Emitter>) : Emitter {
    override fun toString(): String =
        elements.joinToString(separator = " ", prefix = "(", postfix = ")")

    override fun isConditional(): Boolean = elements.any { it.isConditional() }

    override fun isIndependent(): Boolean = elements.all { it.isIndependent() }
}

class AlternativeEmitter(val elements: List<Emitter>) : Emitter {
    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")

    override fun isConditional(): Boolean = true

    override fun isIndependent(): Boolean = false
}

/**
 * An emitter that conjures part of a word out of nothing.
 * This means it doesn't need information from a connected
 * ``Matcher`` about what it matched.
 */
interface IndependentEmitter : Emitter {
    fun result(): UnboundResult

    override fun isConditional(): Boolean = false

    override fun isIndependent(): Boolean = true
}

/**
 * An emitter whose result depends on a connected ``Matcher``.
 */
interface ConditionalEmitter : Emitter {
    fun result(
        declarations: Declarations,
        matcher: SimpleMatcher,
        original: Phrase
    ): UnboundResult = result(declarations, matcher, original.first())

    fun result(
        declarations: Declarations,
        matcher: SimpleMatcher,
        original: Word
    ): UnboundResult

    override fun isConditional(): Boolean = true

    override fun isIndependent(): Boolean = false
}

object BetweenWordsEmitter :
    IndependentEmitter {
    override fun result(): UnboundResult =
        { Phrase(StandardWord.empty, StandardWord.empty) }
}

class CaptureReferenceEmitter(val number: Int) : IndependentEmitter {
    override fun result(): UnboundResult =
        { bindings ->
            Phrase(bindings.captures[number] ?: throw LscUnboundCapture(number))
        }

    override fun toString(): String = "$$number"
}

class MatrixEmitter(val matrix: Matrix) : ConditionalEmitter {

    init {
        if (matrix.valueList.any { it is NegatedValue }) {
            throw LscInvalidOutputMatrix(matrix, "negated feature")
        }
    }

    override fun result(
        declarations: Declarations, matcher: SimpleMatcher, original: Word
    ): UnboundResult =
        { bindings ->
            Phrase(
                with(declarations) {
                    val boundMatrix = matrix.bindVariables(bindings)
                    if (original.isEmpty()) {
                        StandardWord.single(boundMatrix.toSymbol())
                    } else {
                        val resultSegments = original.segments.map {
                            it.toMatrix().update(boundMatrix).toSymbol()
                        }
                        StandardWord.fromSegments(resultSegments)
                    }
                }
            )
        }

    override fun toString(): String = matrix.toString()
}

class SyllableMatrixEmitter(val matrix: Matrix) : ConditionalEmitter {

    init {
        if (matrix.valueList.any { it is NegatedValue }) {
            throw LscInvalidOutputMatrix(matrix, "negated feature")
        }
    }

    override fun result(
        declarations: Declarations, matcher: SimpleMatcher, original: Word
    ): UnboundResult =
        {
            val syllableFeatures = with(declarations) {
                matrix.toModifiers()
            }
            Phrase(
                SyllabifiedWord(
                    original, emptyList(), syllableModifiers = mapOf(0 to syllableFeatures)
                )
            )
        }

    override fun toString(): String = matrix.toString()
}

class SymbolEmitter(val text: Word) :
    ConditionalEmitter,
    IndependentEmitter {

    override fun result(): UnboundResult = { Phrase(text) }

    override fun result(
        declarations: Declarations, matcher: SimpleMatcher, original: Word
    ): UnboundResult = {
        Phrase(
            original.recoverStructure(
                if (matcher is SymbolMatcher) {
                    resultFromSymbolMatcher(declarations, matcher, original)
                } else text
            )
        )
    }

    private fun resultFromSymbolMatcher(
        declarations: Declarations, matcher: SymbolMatcher, original: Word
    ): Word {
        val result = with(declarations) {
            if (matcher.text.length == text.length && original.length == text.length) {
                matcher.text.segments.zip3(
                    original.segments, text.segments
                ) { matcherSegment, originalSegment, textSegment ->
                    textSegment.withFloatingDiacriticsFrom(originalSegment, excluding = matcherSegment)
                }
            } else if (matcher.text.length == original.length && text.length == 1) {
                var newText = text.segments.first()
                matcher.text.segments.zip(original.segments).forEach { (matcherSegment, originalSegment) ->
                    newText = newText.withFloatingDiacriticsFrom(originalSegment, excluding = matcherSegment)
                }
                listOf(newText)
            } else if (matcher.text.length == 1 && original.length == 1) {
                val matcherSegment = matcher.text.segments.first()
                val originalSegment = original.segments.first()
                text.segments.map {
                    it.withFloatingDiacriticsFrom(originalSegment, excluding = matcherSegment)
                }
            } else text.segments
        }
        return StandardWord.fromSegments(result)
    }

    override fun toString(): String = text.string.ifEmpty { "*" }

    override fun isConditional(): Boolean = true

    override fun isIndependent(): Boolean = true
}

class TextEmitter(val text: Word) : IndependentEmitter {
    override fun result(): UnboundResult {
        return { Phrase(text) }
    }

    override fun toString(): String = text.string.ifEmpty { "*" }
}

object EmptyEmitter : IndependentEmitter {
    override fun result(): UnboundResult =
        { Phrase(StandardWord.empty) }

    override fun toString(): String = "*"
}

object NeverEmitter : IndependentEmitter {
    override fun result(): UnboundResult = throw AssertionError("A never-emitter can't emit")

    override fun toString(): String = "N/A"
}

class LscInvalidOutputMatrix(val matrix: Matrix, val invalidFeature: String) :
    LscUserError("Feature matrix $matrix has a $invalidFeature, which isn't allowed in the output of a rule")
