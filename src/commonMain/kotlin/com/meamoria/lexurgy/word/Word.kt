package com.meamoria.lexurgy.word

interface Word {
    /**
     * The word represented by this ``Word`` as a plain string. This is distinct from calling ``toString()``, which
     * might show additional markup to indicate the word's structure.
     */
    val string: String

    val segments: List<Segment>

    val length: Int

    fun toStandard(): StandardWord

    fun normalize(parser: PhoneticParser): Word

    fun isEmpty(): Boolean = segments.isEmpty()

    val numSyllables: Int

    val syllableBreaks: List<Int>

    val syllableModifiers: Map<Int, List<Modifier>>

    fun modifiersAt(index: Int): List<Modifier>

    /**
     * Returns a reversed view of this word
     */
    fun reversed(): Word = ReversedWord(this)

    /**
     * Returns a copy of this word with its
     * segments reversed
     */
    fun forceReversed(): Word

    operator fun iterator(): Iterator<Segment> = segments.iterator()

    operator fun get(index: Int): Segment = segments[index]

    fun slice(indices: IntRange): Word

    fun sliceSegments(indices: IntRange): Iterable<Segment> = object : Iterable<Segment> {
        override fun iterator(): Iterator<Segment> = object : Iterator<Segment> {
            private var cursor = indices.first

            override fun hasNext(): Boolean = cursor <= indices.last

            override fun next(): Segment = get(cursor).also { cursor++ }
        }
    }

    fun take(n: Int): Word

    fun drop(n: Int): Word

    /**
     * Retain only segments that match the specified filter
     */
    fun filterSegments(filter: (Segment) -> Boolean): FilteredWord

    fun removeLeadingBreak(): Word

    fun removeTrailingBreak(): Word

    fun removeBoundingBreaks(): Word = removeLeadingBreak().removeTrailingBreak()

    operator fun plus(other: Word): Word = concat(other)

    /**
     * Concatenates the specified word to the end of this word.
     * ``syllableModifierCombiner`` specifies how to resolve
     * syllable modifiers when two syllables are combined into
     * one at the boundary. By default, the new syllable gets
     * the modifiers from the left component only.
     */
    fun concat(
        other: Word,
        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier> = { a, _ -> a },
    ): Word

    fun <T> updateSyllableModifiers(
        changes: Map<Int, T>, updater: (List<Modifier>, T) -> List<Modifier>,
    ): Word

    /**
     * Returns a word with the same segments as ``other``,
     * but structures copied from this word.
     * Syllable breaks in ``exceptSyllableBreaks`` aren't copied.
     */
    fun recoverStructure(
        other: Word,
        exceptSyllableBreaks: List<Int> = emptyList()
    ): Word

    /**
     * Checks whether this word has syllable structure
     */
    fun isSyllabified(): Boolean

    /**
     * Returns a word with just this word's segments (no structure)
     */
    fun toSimple(): Word

    /**
     * Returns the word represented by this ``Word`` as
     * a plain string (as per ``string``) but with the
     * specified segment made prominent
     */
    fun highlightSegment(index: Int): String {
        val parenModifiers = listOf(Modifier("(", ModifierPosition.BEFORE)) +
                this[index].modifiers +
                Modifier(")", ModifierPosition.AFTER)
        val highlightedSegment = this[index].copy(modifiers = parenModifiers)
        val highlightedWord = take(index) + StandardWord.single(highlightedSegment) + drop(index + 1)
        return highlightedWord.string
    }

    companion object {
        fun join(words: List<Word>): Word =
            if (words.isEmpty()) StandardWord.EMPTY
            else {
                var result = words.first()
                for (word in words.drop(1)) {
                    result += word
                }
                result
            }
    }
}