package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.*
import com.meamoria.lexurgy.sc.*

class MatrixMatcher(
    val declarations: Declarations,
    val matrix: Matrix
) : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        with(declarations) {
            val word = phrase[start.wordIndex]
            val index = start.segmentIndex
            val boundMatrix = matrix.bindVariables(bindings)
            if (index < word.length) {
                word[index].matches(boundMatrix, bindings)?.let {
                    listOf(
                        PhraseMatchEnd(
                            start.copy(segmentIndex = index + 1),
                            it
                        )
                    )
                } ?: emptyList()
            } else emptyList()
        }

    override fun length(bindings: Bindings): Int = 1

    override fun reversed(): Matcher = this

    override fun toString(): String = matrix.toString()
}

class MatrixEmitter(val declarations: Declarations, val matrix: Matrix) :
    ConditionalEmitter {

    init {
        if (matrix.valueList.any { it is NegatedValue }) {
            throw LscInvalidOutputMatrix(matrix, "negated feature")
        }
    }

    override fun result(
        matcher: SimpleMatcher, original: Word
    ): UnboundResult =
        UnboundResult.fromPhraseBinder { bindings ->
            Phrase(
                with(declarations) {
                    val boundMatrix = matrix.bindVariables(bindings)
                    if (original.isEmpty()) {
                        try {
                            StandardWord.single(boundMatrix.toSymbol())
                        } catch (e: LscInvalidMatrix) {
                            StandardWord.EMPTY
                        }
                    } else {
                        val resultSegments = original.segments.map {
                            it.toMatrix().update(boundMatrix).toSymbol()
                        }
                        original.recoverStructure(
                            StandardWord(resultSegments)
                        )
                    }
                }
            )
        }

    override fun toString(): String = matrix.toString()
}

class SyllableMatrixMatcher(
    val declarations: Declarations,
    val matrix: Matrix
) : SimpleMatcher(), LengthHintedMatcher {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val word = phrase[start.wordIndex]
        val index = start.segmentIndex
        if (index == word.length) return emptyList()
        with(declarations) {
            val boundMatrix = matrix.bindVariables(bindings)
            return word.modifiersAt(index).toMatrix().matches(boundMatrix, bindings)?.let {
                listOf(
                    PhraseMatchEnd(
                        start.copy(segmentIndex = index + 1),
                        it
                    )
                )
            } ?: emptyList()
        }
    }

    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        expectedEnd: PhraseIndex,
        bindings: Bindings
    ): Bindings? {
        if (expectedEnd.wordIndex != start.wordIndex) return null
        val word = phrase[start.wordIndex]
        val index = start.segmentIndex
        val expectedEndIsPastCurrentSyllable =
            word.syllableBreaks.any { it in ((index + 1) until expectedEnd.segmentIndex) }
        if (expectedEndIsPastCurrentSyllable) return null
        with(declarations) {
            val boundMatrix = matrix.bindVariables(bindings)
            return word.modifiersAt(index).toMatrix().matches(boundMatrix, bindings)
        }
    }

    override fun reversed(): Matcher = this

    override fun toString(): String = matrix.toString()
}

class SyllableMatrixEmitter(val declarations: Declarations, val matrix: Matrix) :
    ConditionalEmitter {

    init {
        if (matrix.valueList.any { it is NegatedValue }) {
            throw LscInvalidOutputMatrix(matrix, "negated feature")
        }
    }

    override fun result(
        matcher: SimpleMatcher, original: Word
    ): UnboundResult =
        UnboundResult { bindings ->
            with(declarations) {
                val boundMatrix = matrix.bindVariables(bindings)
                val originalModifiers = original.syllableModifiers
                val newModifiers = (0 until original.numSyllables).associateWith { syllableNumber ->
                    val originalMatrix = originalModifiers[syllableNumber]?.toMatrix() ?: Matrix.EMPTY
                    originalMatrix.update(boundMatrix).toModifiers()
                }
                val phrase = Phrase(
                    original.toStandard().withSyllabification(
                        original.syllableBreaks, newModifiers
                    )
                )
                ChangeResult(phrase, emptyList(), phrase.indices.associateWith { boundMatrix })
            }
        }

    override fun toString(): String = matrix.toString()
}

class LscInvalidOutputMatrix(val matrix: Matrix, val invalidFeature: String) :
    LscUserError("Feature matrix $matrix has a $invalidFeature, which isn't allowed in the output of a rule")