package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.StandardWord
import com.meamoria.lexurgy.SyllableStructureViolated
import com.meamoria.lexurgy.Word

class Syllabifier(
    val declarations: Declarations,
    val patterns: List<Pattern>,
) {
    fun syllabify(word: Word): Word =
        if (patterns.isEmpty() && word.isSyllabified()) word else {
            val syllableSequences = mutableMapOf(0 to PatternMatchSequence(emptyList()))
            var latestSyllableEnd = 0
            for (i in 0 until word.length) {
                val prev = syllableSequences[i] ?: continue
                val newSequences = patterns.flatMapIndexed { patternNumber, pattern ->
                    pattern.matcher.claim(declarations, word, i, Bindings()).map {
                        prev + PatternMatch(
                            patternNumber,
                            it.index,
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
            val patternMatches =
                syllableSequences[word.length]?.patternMatches ?: throw SyllableStructureViolated(
                    word,
                    latestSyllableEnd
                )
            val newSyllableModifiers =
                patternMatches.withIndex().filter {
                    it.value.assignedMatrix != null
                }.associate { it.index to it.value.assignedMatrix!! }
            val combinedSyllableModifiers = word.syllableModifiers.toMutableMap()
            for ((syllableNumber, assignedMatrix) in newSyllableModifiers) {
                combinedSyllableModifiers += syllableNumber to with(declarations) {
                    (combinedSyllableModifiers[syllableNumber]?.toMatrix() ?: Matrix.EMPTY).update(
                        assignedMatrix
                    ).toModifiers()
                }
            }
            StandardWord(word.segments).withSyllabification(
                patternMatches.dropLast(1).map { it.end },
                combinedSyllableModifiers,
            )
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