package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import com.meamoria.lexurgy.sc.element.*
import com.meamoria.lexurgy.word.*

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
        val syllableSequences = Array<PatternMatchSequence?>(word.length + 1) { null }
        syllableSequences[0] = PatternMatchSequence(emptyList())
        for (i in 0 until word.length) {
            val prev = syllableSequences[i]?.takeIf { !it.isPartial } ?: continue
            val newSequences = patterns.flatMapIndexed { patternNumber, pattern ->
                matchPattern(word, i, patternNumber, pattern).map { prev + it }
            }
            for (sequence in newSequences) {
                val existing = syllableSequences[sequence.end]
                if (existing == null || sequence < existing) {
                    syllableSequences[sequence.end] = sequence
                }
            }
        }
        syllableSequences[word.length]?.takeIf { !it.isPartial }?.let {
            return it
        }
        syllableStructureViolated(word, syllableSequences)
    }

    private fun matchPattern(
        word: Word,
        segmentIndex: Int,
        patternNumber: Int,
        pattern: Pattern,
    ): List<PatternMatch> = when (pattern) {
        is SimplePattern -> pattern.matcher.claim(
            Phrase(word),
            PhraseIndex(0, segmentIndex),
            Bindings(),
            partial = true,
        ).map {
            PatternMatch(
                patternNumber,
                it.index.segmentIndex,
                Bindings(),
                assignedMatrix = pattern.assignedMatrix,
                isPartial = it.isPartial,
            )
        }
        is StructuredPattern ->
            matchStructuredPattern(word, segmentIndex, patternNumber, pattern)
    }

    private fun matchStructuredPattern(
        word: Word,
        segmentIndex: Int,
        patternNumber: Int,
        pattern: StructuredPattern,
    ): List<PatternMatch> {
        fun List<PatternMatch>.partials(): List<PatternMatch> {
            return filter { it.end > segmentIndex }.map { it.partial() }
        }

        fun List<PatternMatch>.matchNextPart(
            part: Matcher,
            nextPatternMatch: (PatternMatch, PhraseMatchEnd) -> PatternMatch,
        ) = filter { !it.isPartial }.flatMap { match ->
            part.claim(
                Phrase(word),
                PhraseIndex(0, match.end),
                match.returnBindings,
                partial = true,
            ).map { nextPatternMatch(match, it) }
        }

        val initialMatches = listOf(PatternMatch(patternNumber, segmentIndex, Bindings()))
        val reluctantOnsetMatches = initialMatches.matchNextPart(
            pattern.reluctantOnset ?: EmptyMatcher
        ) { match, end ->
            PatternMatch(
                patternNumber,
                end.index.segmentIndex,
                end.returnBindings,
                reluctantOnsetLength = end.index.segmentIndex - match.end,
                assignedMatrix = pattern.assignedMatrix,
                isPartial = end.isPartial,
            )
        }
        if (reluctantOnsetMatches.isEmpty()) {
            return initialMatches.partials()
        }
        val onsetMatches = reluctantOnsetMatches.matchNextPart(pattern.onset) { match, end ->
            PatternMatch(
                patternNumber,
                end.index.segmentIndex,
                end.returnBindings,
                reluctantOnsetLength = match.reluctantOnsetLength,
                onsetLength = end.index.segmentIndex - match.end,
                assignedMatrix = pattern.assignedMatrix,
                isPartial = end.isPartial,
            )
        }
        if (onsetMatches.isEmpty()) {
            return reluctantOnsetMatches.partials()
        }
        val nucleusMatches = onsetMatches.matchNextPart(pattern.nucleus) { match, end ->
            PatternMatch(
                patternNumber,
                end.index.segmentIndex,
                end.returnBindings,
                reluctantOnsetLength = match.reluctantOnsetLength,
                onsetLength = match.onsetLength,
                nucleusLength = end.index.segmentIndex - match.end,
                assignedMatrix = pattern.assignedMatrix,
                isPartial = end.isPartial,
            )
        }
        if (nucleusMatches.isEmpty()) {
            return onsetMatches.partials()
        }
        val codaMatches = nucleusMatches.matchNextPart(
            pattern.coda ?: EmptyMatcher
        ) { match, end ->
            PatternMatch(
                patternNumber,
                end.index.segmentIndex,
                end.returnBindings,
                reluctantOnsetLength = match.reluctantOnsetLength,
                onsetLength = match.onsetLength,
                nucleusLength = match.nucleusLength,
                codaLength = end.index.segmentIndex - match.end,
                assignedMatrix = pattern.assignedMatrix,
                isPartial = end.isPartial,
            )
        }
        if (codaMatches.isEmpty()) {
            return nucleusMatches.partials()
        }

        val environmentMatches = pattern.environment?.let { env ->
            codaMatches.filter { match ->
                env.check(
                    Phrase(word),
                    PhraseIndex(0, segmentIndex),
                    PhraseIndex(0, match.end),
                    Bindings(),
                ) != null
            }
        } ?: codaMatches

        return environmentMatches
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

    private fun syllableStructureViolated(
        word: Word,
        syllableSequences: Array<PatternMatchSequence?>
    ): Nothing {
        val longestSequenceIndex = syllableSequences.indexOfLast { it != null }
        val longestSequence = syllableSequences[longestSequenceIndex]!!
        val lastSyllableBreak = if (longestSequence.isPartial) {
            val longestMatches = longestSequence.patternMatches
            if (longestMatches.size <= 1) 0 else {
                longestMatches[longestMatches.lastIndex - 1].end
            }
        } else longestSequenceIndex
        throw SyllableStructureViolated(
            word,
            lastSyllableBreak,
            longestSequenceIndex,
        )
    }

    sealed interface Pattern

    data class SimplePattern(
        val matcher: Matcher,
        val assignedMatrix: Matrix? = null,
    ) : Pattern

    data class StructuredPattern(
        val onset: Matcher,
        val nucleus: Matcher,
        val coda: Matcher? = null,
        val reluctantOnset: Matcher? = null,
        val environment: CompoundEnvironment? = null,
        val assignedMatrix: Matrix? = null,
    ) : Pattern

    private data class PatternMatch(
        val patternNumber: Int,
        val end: Int,
        val returnBindings: Bindings,
        val reluctantOnsetLength: Int? = null,
        val onsetLength: Int? = null,
        val nucleusLength: Int? = null,
        val codaLength: Int? = null,
        val assignedMatrix: Matrix? = null,
        val isPartial: Boolean = false,
    ) {
        fun partial(): PatternMatch = copy(isPartial = true)
    }

    private data class PatternMatchSequence(
        val patternMatches: List<PatternMatch>,
    ) : Comparable<PatternMatchSequence> {

        val end: Int = patternMatches.lastOrNull()?.end ?: 0

        val isPartial: Boolean = patternMatches.lastOrNull()?.isPartial == true

        override fun compareTo(other: PatternMatchSequence): Int {
            if (this.isPartial != other.isPartial) {
                return this.isPartial.compareTo(other.isPartial)
            }
            var i = 0
            while (i < patternMatches.size && i < other.patternMatches.size) {
                val thisPattern = patternMatches[i]
                val otherPattern = other.patternMatches[i]
                if (i + 1 < patternMatches.size && i + 1 < other.patternMatches.size) {
                    if (patternMatches[i + 1].reluctantOnsetLength != other.patternMatches[i + 1].reluctantOnsetLength) {
                        return (patternMatches[i + 1].reluctantOnsetLength ?: 0).compareTo(other.patternMatches[i + 1].reluctantOnsetLength ?: 0)
                    }
                }
                if (thisPattern.nucleusLength != otherPattern.nucleusLength) {
                    return (otherPattern.nucleusLength ?: 0).compareTo(thisPattern.nucleusLength ?: 0)
                }
                if (thisPattern.end != otherPattern.end) {
                    return thisPattern.end.compareTo(otherPattern.end)
                }
                if (thisPattern.patternNumber != otherPattern.patternNumber) {
                    return thisPattern.patternNumber.compareTo(otherPattern.patternNumber)
                }
                i += 1
            }
            return 0
        }

        operator fun plus(patternMatch: PatternMatch): PatternMatchSequence =
            PatternMatchSequence(patternMatches + patternMatch)
    }
}

class SyllableStructureViolated(
    val word: Word,
    val lastSyllableBreak: Int,
    val invalidSymbolPosition: Int
) :
    UserError(
        if(invalidSymbolPosition < word.length) {
            "The segment \"${word[invalidSymbolPosition].string}\" in " +
                    "\"${word.highlightSegment(invalidSymbolPosition)}\" " +
                    "doesn't fit the syllable structure; " +
                    if (lastSyllableBreak == invalidSymbolPosition) {
                        "no syllable pattern can start with \"${word[invalidSymbolPosition].string}\""
                    } else {
                        "no syllable pattern that starts with " +
                                "\"${word.slice(lastSyllableBreak until invalidSymbolPosition).toSimple().string}\" " +
                                "can continue with \"${word[invalidSymbolPosition].string}\""
                    }
        } else {
            "The word \"${word.string}\" doesn't fit the syllable structure; " +
                    "the last syllable \"${word.drop(lastSyllableBreak).string}\" is incomplete"
        }
    )