package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Segment
import com.meamoria.lexurgy.Word

interface Matcher<I : Segment<I>> {
    fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int?
}

class WordStartMatcher<I : Segment<I>> : Matcher<I> {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? =
        start.takeIf { it == 0 }

    override fun toString(): String = "$"
}

class WordEndMatcher<I : Segment<I>> : Matcher<I> {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? =
        start.takeIf { it == word.length }

    override fun toString(): String = "$"
}

class SequenceMatcher<I : Segment<I>>(val elements: List<Matcher<I>>) : Matcher<I> {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? {
        var elementStart = start
        for (element in elements) {
            elementStart = element.claim(declarations, word, elementStart, bindings) ?: return null
        }
        return elementStart
    }

    override fun toString(): String = elements.joinToString(separator = " ", prefix = "(", postfix = ")")
}

class RepeaterMatcher<I : Segment<I>>(val element: Matcher<I>, val type: RepeaterType) : Matcher<I> {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? {
        var elementStart = start
        var times = 0
        while (elementStart < word.length) {
            elementStart = element.claim(declarations, word, elementStart, bindings) ?: break
            times++
            if (type.maxReps?.let { times >= it } == true) break
        }
        return elementStart.takeIf { times >= type.minReps }
    }

    override fun toString(): String = "$element${type.string}"
}

class ListMatcher<I : Segment<I>>(val elements: List<Matcher<I>>) : Matcher<I> {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? {
        for (element in elements) {
            val altBindings = bindings.copy()
            element.claim(declarations, word, start, altBindings)?.let {
                bindings.combine(altBindings)
                return it
            }
        }
        return null
    }

    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")
}

/**
 * A matcher that isn't a container for other matchers
 */
interface SimpleMatcher<I : Segment<I>> : Matcher<I>

class CaptureMatcher(val element: Matcher<PhonS>, val number: Int) : SimpleMatcher<PhonS> {
    override fun claim(declarations: Declarations, word: Word<PhonS>, start: Int, bindings: Bindings): Int? =
        element.claim(declarations, word, start, bindings)?.also { end ->
            bindings.captures[number] = word.slice(start until end)
        }
}

class CaptureReferenceMatcher(val number: Int) : SimpleMatcher<PhonS> {
    override fun claim(declarations: Declarations, word: Word<PhonS>, start: Int, bindings: Bindings): Int? =
        bindings.captures[number]?.let { capturedText ->
            return (start + capturedText.length).takeIf { end ->
                word.drop(start).take(end - start) == capturedText
            }
        } ?: throw LscUnboundCapture(number)
}

class MatrixMatcher(val matrix: Matrix) : SimpleMatcher<PhonS> {
    override fun claim(declarations: Declarations, word: Word<PhonS>, start: Int, bindings: Bindings): Int? =
        with(declarations) {
            val boundMatrix = matrix.bindVariables(bindings)
            if (start < word.length && word[start].matches(boundMatrix, bindings)) start + 1
            else null
        }

    override fun toString(): String = matrix.toString()
}

abstract class AbstractTextMatcher<I : Segment<I>>(val text: Word<I>) : SimpleMatcher<I>

class SymbolMatcher(text: Word<PhonS>) : AbstractTextMatcher<PhonS>(text) {
    override fun claim(declarations: Declarations, word: Word<PhonS>, start: Int, bindings: Bindings): Int? {
        val wordStart = word.drop(start).take(text.length)
        val matches = wordStart.length == text.length &&
                with(declarations) {
                    wordStart.segments.zip(text.segments) { wordSegment, textSegment ->
                        wordSegment.matches(textSegment)
                    }.all { it }
                }
        return if (matches) start + text.length else null
    }

    override fun toString(): String = text.string.ifEmpty { "*" }
}

class TextMatcher<I : Segment<I>>(text: Word<I>) : AbstractTextMatcher<I>(text) {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? {
        val wordStart = word.drop(start).take(text.length)
        return if (wordStart == text) start + text.length else null
    }

    override fun toString(): String = text.string
}

class NegatedMatcher<I : Segment<I>>(val matcher: Matcher<I>) : SimpleMatcher<I> {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? =
        if (matcher.claim(declarations, word, start, bindings) == null) start + 1
        else null

    override fun toString(): String = "!$matcher"
}

class NullMatcher<I : Segment<I>> : SimpleMatcher<I> {
    override fun claim(declarations: Declarations, word: Word<I>, start: Int, bindings: Bindings): Int? =
        start

    override fun toString(): String = "*"
}
