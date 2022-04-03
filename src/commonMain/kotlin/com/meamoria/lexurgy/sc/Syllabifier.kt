package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

class Syllabifier(
    val declarations: Declarations,
    val patterns: List<Pattern>,
) {
    fun syllabify(word: Word): Word =
        if (patterns.isEmpty()) word else {
            val syllableSequence = findBestSyllableSequence(word)
            val patternMatches = syllableSequence.patternMatches
            val newSyllableBreaks = patternMatches.dropLast(1).map { it.end }
            val newSyllableMatrices =
                patternMatches.withIndex().filter {
                    it.value.assignedMatrix != null
                }.associate { it.index to it.value.assignedMatrix!! }
            val combinedSyllableModifiers = combineSyllableModifiers(
                word, newSyllableBreaks, newSyllableMatrices
            )
            StandardWord(word.segments).withSyllabification(
                newSyllableBreaks,
                combinedSyllableModifiers,
            )
        }

    private fun findBestSyllableSequence(word: Word): PatternMatchSequence {
        val syllableSequences = mutableMapOf(0 to PatternMatchSequence(emptyList()))
        var latestSyllableEnd = 0
        for (i in 0 until word.length) {
            val prev = syllableSequences[i] ?: continue
            val newSequences = patterns.flatMapIndexed { patternNumber, pattern ->
                pattern.matcher.claim(declarations, Phrase(word), PhraseIndex(0, i), Bindings()).map {
                    prev + PatternMatch(
                        patternNumber,
                        it.index.segmentIndex,
                        pattern.assignedMatrix,
                    )
                }
            }
            for (sequence in newSequences) {
                val existing = syllableSequences[sequence.end]
                if (existing == null || sequence < existing) {
                    syllableSequences[sequence.end] = sequence
                    latestSyllableEnd = sequence.end
                }
            }
        }
        return syllableSequences[word.length] ?: throw SyllableStructureViolated(word, latestSyllableEnd)
    }

    private fun combineSyllableModifiers(
        word: Word, newSyllableBreaks: List<Int>, newSyllableMatrices: Map<Int, Matrix>
    ): Map<Int, List<Modifier>> {
        val syllableMap = findSyllableMap(word, newSyllableBreaks)
        with(declarations) {
            val combinedSyllableModifiers = mutableMapOf<Int, Matrix>()
            for ((syllableNumber, modifiers) in word.syllableModifiers) {
                val newSyllableNumber = syllableMap[syllableNumber] ?: syllableNumber
                val existingMatrix = combinedSyllableModifiers[newSyllableNumber] ?: Matrix.EMPTY
                val newMatrix = existingMatrix.update(modifiers.toMatrix())
                combinedSyllableModifiers += newSyllableNumber to newMatrix
            }
            for ((syllableNumber, assignedMatrix) in newSyllableMatrices) {
                val existingMatrix = combinedSyllableModifiers[syllableNumber] ?: Matrix.EMPTY
                val newMatrix = existingMatrix.update(assignedMatrix)
                combinedSyllableModifiers += syllableNumber to newMatrix
            }
            return combinedSyllableModifiers.mapValues { it.value.toModifiers() }
        }
    }

    private fun findSyllableMap(word: Word, newSyllableBreaks: List<Int>): Map<Int, Int> {
        if (!word.isSyllabified()) return emptyMap()
        val result = mutableMapOf<Int, Int>()
        val oldEnds = word.syllableBreaks + word.length
        val newEnds = newSyllableBreaks + word.length
        var newIndex = 0
        for (oldIndex in oldEnds.indices) {
            result[oldIndex] = newIndex
            newIndex += when {
                newIndex == newEnds.size - 1 -> 0
                oldIndex + 1 < oldEnds.size && newEnds[newIndex] >= oldEnds[oldIndex + 1] -> 0
                newIndex + 1 < newEnds.size && oldEnds[oldIndex] >= newEnds[newIndex + 1] -> 2
                else -> 1
            }
        }
        return result
    }

    data class Pattern(val matcher: Matcher, val assignedMatrix: Matrix?)

    private data class PatternMatch(
        val patternNumber: Int,
        val end: Int,
        val assignedMatrix: Matrix?,
    )

    private data class PatternMatchSequence(
        val patternMatches: List<PatternMatch>,
    ) : Comparable<PatternMatchSequence> {

        val end: Int = patternMatches.lastOrNull()?.end ?: 0

        override fun compareTo(other: PatternMatchSequence): Int {
            for ((thisPattern, otherPattern) in patternMatches.zip(other.patternMatches)) {
                if (thisPattern.end != otherPattern.end) {
                    return thisPattern.end.compareTo(otherPattern.end)
                }
                if (thisPattern.patternNumber != otherPattern.patternNumber) {
                    return thisPattern.patternNumber.compareTo(otherPattern.patternNumber)
                }
            }
            return 0
        }

        operator fun plus(patternMatch: PatternMatch): PatternMatchSequence =
            PatternMatchSequence(patternMatches + patternMatch)
    }
}