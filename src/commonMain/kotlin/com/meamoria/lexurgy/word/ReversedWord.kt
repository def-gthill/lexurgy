package com.meamoria.lexurgy.word

import kotlin.math.max

// A reversed view of a word
internal class ReversedWord(val inner: Word) : Word {
    override val string: String
        get() = force().string

    override val segments: List<Segment>
        get() = inner.segments.asReversed()

    override val length: Int
        get() = inner.length

    override fun toStandard(): StandardWord = force().toStandard()

    override fun normalize(parser: PhoneticParser): Word =
        ReversedWord(inner.normalize(parser))

    override val numSyllables: Int
        get() = inner.numSyllables

    override val syllableBreaks: List<Int>
        get() = reversedSyllableBreaks(inner.syllableBreaks)

    private fun reversedSyllableBreaks(syllableBreaks: List<Int>): List<Int> =
        syllableBreaks.reversed().map { inner.length - it }

    override val syllableModifiers: Map<Int, List<Modifier>>
        get() = inner.syllableModifiers.mapKeys { inner.numSyllables - it.key - 1 }

    override fun modifiersAt(index: Int): List<Modifier> =
        inner.modifiersAt(inner.length - index - 1)

    override fun reversed(): Word = inner

    override fun forceReversed(): Word = inner

    override fun slice(indices: IntRange): Word =
        ReversedWord(
            inner.slice(
                inner.length - indices.last - 1 until
                        inner.length - indices.first
            )
        )

    override fun take(n: Int): Word =
        ReversedWord(
            inner.drop(max(inner.length - n, 0))
        )

    override fun drop(n: Int): Word =
        ReversedWord(
            inner.take(max(inner.length - n, 0))
        )

    override fun filterSegments(filter: (Segment) -> Boolean): FilteredWord {
        val filterResult = inner.filterSegments(filter)
        return FilteredWord(
            ReversedWord(filterResult.word),
            filterResult.filterMap.map { inner.length - it - 1 }.reversed().toIntArray(),
        )
    }

    override fun removeLeadingBreak(): Word =
        ReversedWord(inner.removeTrailingBreak())

    override fun removeTrailingBreak(): Word =
        ReversedWord(inner.removeLeadingBreak())

    override fun concat(
        other: Word,
        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier>
    ): Word =
        when (other) {
            is ReversedWord -> ReversedWord(
                other.inner.concat(this.inner) { a, b ->
                    syllableModifierCombiner(b, a)
                }
            )
            else -> force().concat(other, syllableModifierCombiner)
        }

    override fun <T> updateSyllableModifiers(
        changes: Map<Int, T>,
        updater: (List<Modifier>, T) -> List<Modifier>
    ): Word =
        ReversedWord(
            inner.updateSyllableModifiers(
                changes.mapKeys { inner.length - it.key - 1 },
                updater,
            ),
        )

    override fun recoverStructure(other: Word, exceptSyllableBreaks: List<Int>): Word =
        when (other) {
            is ReversedWord -> ReversedWord(
                inner.recoverStructure(
                    other.inner,
                    reversedSyllableBreaks(exceptSyllableBreaks)
                )
            )
            else -> force().recoverStructure(other, exceptSyllableBreaks)
        }

    override fun isSyllabified(): Boolean = inner.isSyllabified()

    override fun toSimple(): Word = ReversedWord(inner.toSimple())

    override fun toString(): String =
        force().toString() + " (reversed)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ReversedWord) return false
        return inner == other.inner
    }

    override fun hashCode(): Int {
        return inner.hashCode()
    }

    private fun force(): Word = inner.forceReversed()
}