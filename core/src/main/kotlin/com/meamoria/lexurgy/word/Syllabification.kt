package com.meamoria.lexurgy.word

class Syllabification(
    private val segments: List<Segment>,
    val syllableBreaks: List<Int>,
    syllableModifiers: Map<Int, List<Modifier>> = emptyMap(),
) {
    val length: Int = segments.size
    val syllableModifiers = syllableModifiers.filterValues { it.isNotEmpty() }

    val string: String
        get() = if (length == 0) {
            if (syllableBreakAtStart() || syllableBreakAtEnd()) "." else ""
        } else {
            (if (syllableBreakAtStart()) "." else "") +
                    syllablesAsWords.mapIndexed { i, syl ->
                        syl.string.modify(syllableModifiers[i] ?: emptyList())
                    }.joinToString(".") +
                    (if (syllableBreakAtEnd()) "." else "")
        }

    private fun String.modify(modifiers: List<Modifier>): String {
        val modifiersByPosition = modifiers.groupBy { it.position }
        return modifiersByPosition[ModifierPosition.BEFORE].concat() +
                (firstOrNull() ?: "") +
                modifiersByPosition[ModifierPosition.FIRST].concat() +
                drop(1) +
                modifiersByPosition[ModifierPosition.AFTER].concat()
    }

    private fun List<Modifier>?.concat(): String =
        (this ?: emptyList()).joinToString { it.string }

    fun normalize(parser: PhoneticParser): Syllabification =
        Syllabification(
            segments.map { it.normalizeDecompose(parser) },
            syllableBreaks,
            syllableModifiers.mapValues { e -> e.value.map { it.normalizeDecompose() } },
        )

    val syllablesAsWords: List<Word>
        get() = syllableBreaksAndBoundaries.zipWithNext { startIndex, endIndex ->
            StandardWord(segments.slice(startIndex until endIndex))
        }

    private val syllableBreaksAndBoundaries =
        (if (syllableBreakAtStart()) emptyList() else listOf(0)) +
                syllableBreaks +
                (if (syllableBreakAtEnd()) emptyList() else listOf(length))

    private fun syllableBreakAtStart(): Boolean =
        syllableBreaks.firstOrNull() == 0

    private fun syllableBreakAtEnd(): Boolean =
        syllableBreaks.lastOrNull() == length

    val numSyllables: Int =
        syllableBreaks.size + 1 -
                (if (syllableBreakAtStart()) 1 else 0) -
                (if (syllableBreakAtEnd()) 1 else 0)

    fun modifiersAt(index: Int): List<Modifier> =
        syllableModifiers[syllableNumberAt(index)] ?: emptyList()

    fun syllableNumberAt(index: Int): Int =
        when {
            syllableBreaks.isEmpty() -> 0
            index >= syllableBreaks.last() -> numSyllables - 1
            else -> (syllableBreaks + length).indexOfFirst { it > index } -
                    (if (syllableBreakAtStart()) 1 else 0)
        }

    fun reversed(): Syllabification =
        Syllabification(
            segments.reversed(),
            syllableBreaks.reversed().map { length - it },
            syllableModifiers.mapKeys { numSyllables - it.key - 1 }
        )

    fun slice(indices: IntRange): Syllabification =
        Syllabification(
            segments.slice(indices),
            syllableBreaks.filter {
                it >= indices.first &&
                        it <= indices.last + 1
            }.map { it - indices.first },
            syllableModifiers.filterKeys {
                it >= syllableNumberAt(indices.first) &&
                        it <= syllableNumberAt(indices.last + 1)
            }.mapKeys { it.key - syllableNumberAt(indices.first) },
        )

    fun take(n: Int): Syllabification =
        when (n) {
            0 -> EMPTY
            length -> this
            else -> Syllabification(
                segments.take(n),
                syllableBreaks.filter { it <= n },
                syllableModifiers.filterKeys { it <= syllableNumberAt(n) },
            )
        }

    fun drop(n: Int): Syllabification =
        when (n) {
            0 -> this
            length -> EMPTY
            else -> Syllabification(
                segments.drop(n),
                syllableBreaks.map { it - n }.filter { it >= 0 },
                syllableModifiers.mapKeys {
                    it.key - syllableNumberAt(n)
                }.filterKeys { it >= 0 },
            )
        }

    fun retainOnlyIndices(indices: IntArray): Syllabification {
        val newSegments = mutableListOf<Segment>()
        val newSyllableBreaks = mutableListOf<Int>()
        val newSyllableModifiers = mutableMapOf<Int, List<Modifier>>()
        var newIndex = 0
        for ((sylIndex, sylBreak) in syllableBreaksAndBoundaries.withIndex()) {
            val origNewIndex = newIndex
            while (newIndex < indices.size && indices[newIndex] < sylBreak) {
                newSegments += segments[indices[newIndex]]
                newIndex++
            }
            if (newIndex > origNewIndex) {
                syllableModifiers[sylIndex - 1]?.let {
                    newSyllableModifiers += newSyllableBreaks.size to it
                }
                if (newIndex < indices.size) {
                    newSyllableBreaks += newIndex
                }
            }
        }
        return Syllabification(
            newSegments,
            newSyllableBreaks,
            newSyllableModifiers,
        )
    }

    fun removeLeadingBreak(): Syllabification =
        if (syllableBreakAtStart()) {
            Syllabification(segments, syllableBreaks.drop(1), syllableModifiers)
        } else this

    fun removeTrailingBreak(): Syllabification =
        if (syllableBreakAtEnd()) {
            Syllabification(segments, syllableBreaks.dropLast(1), syllableModifiers)
        } else this

    fun concat(
        other: Syllabification,
        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier>
    ): Syllabification {
        if (length == 0 && syllableBreaks.isEmpty()) {
            return other
        }
        var otherSyllableBreaks = other.syllableBreaks.map { it + length }
        if (syllableBreakAtEnd() && other.syllableBreakAtStart()) {
            otherSyllableBreaks = otherSyllableBreaks.drop(1)
        }
        val thisSyllableModifiers = syllableModifiersNoHanging()
        val combinedSyllableModifiers =
            if (syllableBreakAtEnd() || other.syllableBreakAtStart()) {
                thisSyllableModifiers + other.syllableModifiers.mapKeys {
                    it.key + numSyllables
                }
            } else {
                // We have to stitch together the last syllable of this and the first syllable of other
                val syllableOffset = numSyllables - 1
                (thisSyllableModifiers - syllableOffset) +
                        (syllableOffset to syllableModifierCombiner(
                            thisSyllableModifiers[syllableOffset] ?: emptyList(),
                            other.syllableModifiers[0] ?: emptyList(),
                        )) +
                        (other.syllableModifiers - 0).mapKeys {
                            it.key + syllableOffset
                        }
            }
        return Syllabification(
            segments + other.segments,
            syllableBreaks + otherSyllableBreaks,
            combinedSyllableModifiers,
        )
    }

    fun <T> updateSyllableModifiers(
        changes: Map<Int, T>,
        updater: (List<Modifier>, T) -> List<Modifier>
    ): Syllabification {
        val newModifiers = syllableModifiers.toMutableMap()
        for ((index, change) in changes) {
            val syllableNumber = syllableNumberAt(index)
            newModifiers[syllableNumber] = updater(
                newModifiers[syllableNumber] ?: emptyList(),
                change,
            )
        }
        return Syllabification(
            segments,
            syllableBreaks,
            newModifiers,
        )
    }

    /**
     * Syllable modifiers excluding "hanging" modifiers, i.e.
     * modifiers for the syllable after the last.
     */
    private fun syllableModifiersNoHanging(): Map<Int, List<Modifier>> =
        syllableModifiers.filterKeys { it < numSyllables }

    fun recoverStructure(other: Word, exceptSyllableBreaks: List<Int>): Word =
        if (other.isSyllabified() || other.isEmpty()) other
        else {
            val syllableBreaksToTransfer = syllableBreaks.filter { it !in exceptSyllableBreaks }
            val newSyllableBreaks = syllableBreaksToTransfer.filter {
                it < length && it < other.length
            } + if (length in syllableBreaksToTransfer) {
                listOf(other.length)
            } else emptyList()
            val newSyllableCount =
                newSyllableBreaks.size + 1 -
                        (if (newSyllableBreaks.firstOrNull() == 0) 1 else 0) -
                        (if (length in syllableBreaksToTransfer) 1 else 0)
            val newSyllableModifiers = mutableMapOf<Int, MutableList<Modifier>>()
            for ((syllableNumber, modifiers) in syllableModifiers) {
                val newSyllableNumber =
                    if (syllableNumber >= newSyllableCount) newSyllableCount - 1 else syllableNumber
                newSyllableModifiers.getOrPut(newSyllableNumber) { mutableListOf() }.addAll(modifiers)
            }
            StandardWord(other.segments).withSyllabification(
                newSyllableBreaks,
                newSyllableModifiers,
            )
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Syllabification) return false
        return syllableBreaks == other.syllableBreaks &&
                syllableModifiers == other.syllableModifiers
    }

    override fun hashCode(): Int {
        var result = syllableBreaks.hashCode()
        result = 31 * result + syllableModifiers.hashCode()
        return result
    }

    override fun toString(): String =
        if (length == 0) {
            if (syllableBreakAtStart() || syllableBreakAtEnd()) "//" else ""
        } else {
            (if (syllableBreakAtStart()) "//" else "") +
                    syllablesAsWords.mapIndexed { i, syl ->
                        syl.toString().modifySchematic(
                            syllableModifiers[i] ?: emptyList(),
                            beforeSeparator = "((",
                            firstSeparator = "||",
                            afterSeparator = "))",
                        )
                    }.joinToString("//") +
                    (if (syllableBreakAtEnd()) "//" else "")
        }

    companion object {
        val EMPTY = Syllabification(emptyList(), emptyList(), emptyMap())
    }
}