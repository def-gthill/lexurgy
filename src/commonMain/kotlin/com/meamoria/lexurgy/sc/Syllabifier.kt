package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.StandardWord
import com.meamoria.lexurgy.SyllableStructureViolated
import com.meamoria.lexurgy.Word

class Syllabifier(
    val declarations: Declarations,
    val patterns: List<Pattern>,
) {
    private val reversedPatterns = patterns.map { it.reversed() }

    fun syllabify(word: Word): Word =
        if (patterns.isEmpty() && word.isSyllabified()) word else {
            val reversedWord = word.reversed()

            val syllableBreaks = mutableListOf<Int>()
            val newSyllableModifiers = word.syllableModifiers.mapKeys {
                word.numSyllables - it.key - 1
            }.toMutableMap()
            var index = 0
            val bindings = Bindings()

            while (index < word.length) {
                val bestMatch = reversedPatterns.mapNotNull { pattern ->
                    pattern.matcher.claim(declarations, reversedWord, index, bindings).firstOrNull()?.let {
                        PatternMatch(it.index, pattern.assignedMatrix)
                    }
                }.maxByOrNull { it.end }
                    ?: throw SyllableStructureViolated(
                        word, word.length - index - 1
                    )
                index = bestMatch.end
                if (bestMatch.assignedMatrix != null) {
                    with(declarations) {
                        newSyllableModifiers +=
                            syllableBreaks.size to
                                    (newSyllableModifiers[syllableBreaks.size] ?: emptyList()).toMatrix().update(
                                        bestMatch.assignedMatrix
                                    ).toModifiers()
                    }
                }
                if (index < word.length) {
                    syllableBreaks += word.length - index
                }
            }

            StandardWord(word.segments).withSyllabification(
                syllableBreaks.reversed(),
                newSyllableModifiers.mapKeys {
                    syllableBreaks.size - it.key
                }
            )
        }

    class Pattern(val matcher: Matcher, val assignedMatrix: Matrix?) {
        fun reversed(): Pattern = Pattern(matcher.reversed(), assignedMatrix)
    }

    private class PatternMatch(val end: Int, val assignedMatrix: Matrix?)
}