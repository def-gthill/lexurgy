package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.SyllabifiedWord
import com.meamoria.lexurgy.SyllableStructureViolated
import com.meamoria.lexurgy.Word

class Syllabifier(
    val declarations: Declarations,
    val patterns: List<Matcher>,
) {
    private val reversedPatterns = patterns.map { it.reversed() }

    fun syllabify(word: Word): SyllabifiedWord =
        if (patterns.isEmpty() && word.isSyllabified()) word.asSyllabified()!! else {
            val reversedWord = word.reversed()

            val syllableBreaks = mutableListOf<Int>()
            var index = 0
            val bindings = Bindings()

            while (index < word.length) {
                val bestMatch = reversedPatterns.mapNotNull {
                    it.claim(declarations, reversedWord, index, bindings)
                }.maxOrNull()
                    ?: throw SyllableStructureViolated(
                        word, word.length - index - 1
                    )
                index = bestMatch
                if (index < word.length) {
                    syllableBreaks += word.length - index
                }
            }

            val syllableModifiers =
                word.asSyllabified()?.syllableModifiers ?: emptyMap()

            SyllabifiedWord(word, syllableBreaks.reversed(), syllableModifiers)
        }
}