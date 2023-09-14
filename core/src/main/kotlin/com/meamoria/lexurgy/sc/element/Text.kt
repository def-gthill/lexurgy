package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.*
import com.meamoria.lexurgy.sc.*
import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.word.StandardWord
import com.meamoria.lexurgy.word.Word

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
        val target = word.slice(index until end)
        val wordSegments = word.sliceSegments(index until end)
        val matches = with(declarations) {
            wordSegments.zip(text.segments) { wordSegment, textSegment ->
                wordSegment.matches(textSegment)
            }.all { it } &&
                    target.syllableMatrix.matches(text.syllableMatrix, bindings) != null
        }
        return if (matches) listOf(
            PhraseMatchEnd(start.copy(segmentIndex = end), bindings)
        ) else emptyList()
    }

    override fun length(bindings: Bindings): Int = text.length

    override fun reversed(): Matcher = SymbolMatcher(declarations, text.reversed())

    override fun toString(): String = text.string.ifEmpty { "*" }
}

class SymbolEmitter(val declarations: Declarations, val text: Word) :
    ConditionalEmitter,
    IndependentEmitter {

    override fun result(): UnboundResult = UnboundResult.fromPhrase(Phrase(text))

    override fun result(
        matcher: SimpleMatcher, original: Word
    ): UnboundResult =
        UnboundResult {
            val resultWord = when (matcher) {
                is SymbolMatcher -> resultFromSymbolMatcher(matcher, original)
                is MatrixMatcher -> resultFromMatrixMatcher(original)
                else -> text
            }
            val resultWordWithStructure = original.recoverStructure(resultWord)
            val phrase = Phrase(resultWordWithStructure)

            val syllableFeatureChanges = syllableFeatureChanges(matcher)
            val allSyllableFeatureChanges = phrase.indices.associateWith { syllableFeatureChanges }
            val phraseWithSyllableFeatureChanges = with(declarations) {
                phrase.updateSyllableModifiers(allSyllableFeatureChanges)
            }
            ChangeResult(
                phraseWithSyllableFeatureChanges,
                emptyList(),
                allSyllableFeatureChanges,
            )
        }

    private fun resultFromSymbolMatcher(
        matcher: SymbolMatcher, original: Word
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
        return StandardWord(result)
    }

    private fun resultFromMatrixMatcher(original: Word): Word {
        val result = with(declarations) {
            val originalSegment = original.segments.first()
            text.segments.map {
                it.withFloatingDiacriticsFrom(originalSegment)
            }
        }
        return StandardWord(result)
    }

    private fun syllableFeatureChanges(matcher: Matcher): Matrix =
        with(declarations) {
            val addedSyllableFeatures = text.syllableMatrix
            val removedSyllableFeatures = when (matcher) {
                is SymbolMatcher -> matcher.text.syllableMatrix
                else -> Matrix.EMPTY
            }
            val removalMatrix = Matrix(
                removedSyllableFeatures.explicitSimpleValues.map {
                    it.toFeature().default
                }
            )
            removalMatrix.update(addedSyllableFeatures)
        }

    override fun toString(): String = text.string.ifEmpty { "*" }

    override fun isConditional(): Boolean = true

    override fun isIndependent(): Boolean = true
}

class TextMatcher(text: Word) : AbstractTextMatcher(text) {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val matchResult = phrase.matchSubPhrase(start, Phrase(text)) ?: return emptyList()
        return listOf(
            PhraseMatchEnd(
                matchResult,
                bindings,
            )
        )
    }

    override fun length(bindings: Bindings): Int = text.length

    override fun reversed(): Matcher = TextMatcher(text.reversed())

    override fun toString(): String = text.string
}

class TextEmitter(val text: Word) : IndependentEmitter {
    override fun result(): UnboundResult =
        UnboundResult.fromPhrase(Phrase(text))

    override fun toString(): String = text.string.ifEmpty { "*" }
}