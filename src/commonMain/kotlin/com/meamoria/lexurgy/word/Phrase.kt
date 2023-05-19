package com.meamoria.lexurgy.word

class Phrase(val words: List<Word>) : Iterable<Word> {
    constructor(word: Word) : this(listOf(word))

    constructor(vararg words: Word) : this(words.asList())

    val string: String
        get() = words.joinToString(" ") { it.string }

    operator fun get(index: Int): Word = words[index]

    val size: Int = words.size

    val firstIndex: PhraseIndex = PhraseIndex(0, 0)

    val lastIndex: PhraseIndex =
        PhraseIndex(size - 1, words.lastOrNull()?.length ?: 0)

    /**
     * The valid indices that can be used to access segments in this `Phrase`.
     */
    val indices: List<PhraseIndex>
        get() = words.flatMapIndexed { wordIndex, word ->
            (0 until word.length).map { segmentIndex ->
                PhraseIndex(wordIndex, segmentIndex)
            }
        }

    override fun iterator(): Iterator<Word> = words.iterator()

    fun iterateFrom(start: PhraseIndex): Iterator<PhraseIndex> =
        object : Iterator<PhraseIndex> {
            private var cursor: PhraseIndex = start

            override fun hasNext(): Boolean =
                cursor.wordIndex < words.size

            override fun next(): PhraseIndex = cursor.also { cursor = stepForward(it) }
        }

    fun iterateBackFrom(start: PhraseIndex): Iterator<PhraseIndex> =
        object : Iterator<PhraseIndex> {
            private var cursor: PhraseIndex = start

            override fun hasNext(): Boolean =
                cursor.wordIndex >= 0 && cursor.segmentIndex >= 0

            override fun next(): PhraseIndex = cursor.also { cursor = stepBack(it) }
        }

    fun stepForward(index: PhraseIndex): PhraseIndex {
        val (wordIndex, segmentIndex) = index
        return if (segmentIndex >= words[wordIndex].length) {
            PhraseIndex(wordIndex + 1, 0)
        } else {
            PhraseIndex(wordIndex, segmentIndex + 1)
        }
    }

    fun stepBack(index: PhraseIndex): PhraseIndex {
        val (wordIndex, segmentIndex) = index
        return if (segmentIndex == 0) {
            if (wordIndex == 0) {
                PhraseIndex(-1, 0)
            } else {
                PhraseIndex(wordIndex - 1, words[wordIndex - 1].length)
            }
        } else {
            PhraseIndex(wordIndex, segmentIndex - 1)
        }
    }

    fun reversedIndex(index: PhraseIndex): PhraseIndex {
        val (wordIndex, segmentIndex) = index
        return PhraseIndex(
            words.size - wordIndex - 1,
            words[wordIndex].length - segmentIndex
        )
    }

    fun dropUntil(index: PhraseIndex): Phrase =
        Phrase(
            listOf(words[index.wordIndex].drop(index.segmentIndex)) +
                    words.drop(index.wordIndex + 1)
        )

    fun slice(start: PhraseIndex, end: PhraseIndex): Phrase =
        if (start.wordIndex == end.wordIndex) {
            Phrase(
                words[start.wordIndex].slice(start.segmentIndex until end.segmentIndex)
            )
        } else {
            Phrase(
                listOf(words[start.wordIndex].drop(start.segmentIndex)) +
                        words.slice(start.wordIndex + 1 until end.wordIndex) +
                        words[end.wordIndex].take(end.segmentIndex)
            )
        }

    /**
     * Tries to find the specified phrase (``expectedText``) starting
     * at position ``start`` in this phrase.
     * If ``segmentExtractor`` is specified, it will be used
     * to get segments from each word in both ``phrase`` and ``expectedText``
     * (instead of just accessing the ``segments`` property)
     */
    fun matchSubPhrase(
        start: PhraseIndex,
        expectedSubPhrase: Phrase,
        segmentExtractor: (Word) -> List<Segment> = { it.segments },
    ): PhraseIndex? {
        val lastExpectedLength = expectedSubPhrase.last().length
        val subWords = words.drop(start.wordIndex).take(expectedSubPhrase.size).toMutableList()
        if (subWords.size != expectedSubPhrase.size) {
            return null
        }
        subWords[0] = subWords[0].drop(start.segmentIndex)
        subWords[subWords.lastIndex] = subWords[subWords.lastIndex].take(
            lastExpectedLength
        )
        for ((subWord, expectedSubWord) in subWords.zip(expectedSubPhrase)) {
            if (segmentExtractor(subWord) != segmentExtractor(expectedSubWord)) {
                return null
            }
        }
        val wordIndex = start.wordIndex + expectedSubPhrase.size - 1
        val segmentIndex = if (expectedSubPhrase.size == 1) {
            start.segmentIndex + lastExpectedLength
        } else {
            lastExpectedLength
        }
        return PhraseIndex(wordIndex, segmentIndex)
    }

    fun removeLeadingBreak(): Phrase =
        Phrase(listOf(words.first().removeLeadingBreak()) + words.drop(1))

    fun removeTrailingBreak(): Phrase =
        Phrase(words.dropLast(1) + words.last().removeTrailingBreak())

    /**
     * Removes all syllable breaks at the edges of words.
     */
    fun removeBoundingBreaks(): Phrase =
        Phrase(words.map { it.removeBoundingBreaks() })

    fun hasSyllableBreakBefore(index: PhraseIndex): Boolean =
        index.segmentIndex == 0 || index.segmentIndex in words[index.wordIndex].syllableBreaks

    fun hasSyllableBreakAfter(index: PhraseIndex): Boolean {
        val word = words[index.wordIndex]
        val nextSegmentIndex = index.segmentIndex + 1
        return nextSegmentIndex == word.length || nextSegmentIndex in word.syllableBreaks
    }

    fun syllableBreaks(): List<PhraseIndex> =
        flatMapIndexed { wordIndex, word ->
            word.syllableBreaks.map { segmentIndex ->
                PhraseIndex(
                    wordIndex,
                    segmentIndex
                )
            }
        }

    fun modifiersAt(index: PhraseIndex): List<Modifier> {
        val word = words[index.wordIndex]
        return word.modifiersAt(index.segmentIndex)
    }

    /**
     * Concatenates the specified phrase to the end of this phrase.
     * ``syllableModifierCombiner`` specifies how to resolve
     * syllable modifiers when two syllables are combined into
     * one at the boundary.
     */
    fun concat(
        other: Phrase,
        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier>,
    ): Phrase = when {
        words.isEmpty() -> other
        other.words.isEmpty() -> this
        else ->
            Phrase(
                words.dropLast(1) +
                        words.last().concat(
                            other.first(),
                            syllableModifierCombiner,
                        ) +
                        other.drop(1)
            )
    }

    fun <T> updateSyllableModifiers(
        changes: Map<PhraseIndex, T>, updater: (List<Modifier>, T) -> List<Modifier>,
    ): Phrase {
        val changesByWord = changes.entries.groupBy { it.key.wordIndex }
        val updatedWords = words.mapIndexed { i, word ->
            changesByWord[i]?.let { changes ->
                word.updateSyllableModifiers(
                    changes.associate { it.key.segmentIndex to it.value },
                    updater,
                )
            } ?: word
        }
        return Phrase(updatedWords)
    }

    /**
     * Joins this phrase into a single word
     */
    fun join(): Word = Word.join(words)

    /**
     * Joins this phrase into a single word, putting
     * syllable breaks between the original words
     */
    fun joinWithSyllableBreaks(): Word =
        if (words.any { it.isSyllabified() }) {
            var result = words[0]
            for (word in words.drop(1)) {
                result += StandardWord.SYLLABLE_BREAK_ONLY
                result += word
            }
            result
        } else join()

    private val fullyReversed: Phrase by lazy { Phrase(reversed().map { it.reversed() }) }

    fun fullyReversed(): Phrase = fullyReversed

    fun fullyReversedIf(condition: Boolean): Phrase =
        if (condition) fullyReversed else this

    // Manually telescoped function to appease the JS compiler
    fun recoverStructure(other: Phrase): Phrase = recoverStructure(other, emptyList())

    /**
     * Returns a phrase with the same segments as ``other``,
     * but structures copied from this phrase.
     * Syllable breaks in ``exceptSyllableBreaks`` aren't
     * copied.
     */
    fun recoverStructure(
        other: Phrase,
        exceptSyllableBreaks: List<PhraseIndex>,
    ): Phrase {
        val wordStarts = words.scan(0) { acc, word -> acc + word.length }
        val combinedExceptSyllableBreaks = exceptSyllableBreaks.map { index ->
            wordStarts[index.wordIndex] + index.segmentIndex
        }
        return other.resplit(
            joinWithSyllableBreaks().recoverStructure(
                other.join(),
                exceptSyllableBreaks = combinedExceptSyllableBreaks
            )
        )
    }

    private fun resplit(other: Word): Phrase {
        val resultWords = mutableListOf<Word>()
        var remaining = other
        for (word in words) {
            if (word.length >= remaining.length)
                resultWords += remaining
            else {
                resultWords += remaining.take(word.length).removeTrailingBreak()
                remaining = remaining.drop(word.length).removeLeadingBreak()
            }
        }
        return Phrase(resultWords)
    }

    fun toSimple(): Phrase = Phrase(words.map { it.toSimple() })

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Phrase) return false
        return words == other.words
    }

    override fun hashCode(): Int {
        return words.hashCode()
    }

    override fun toString(): String = string

    companion object {
        fun fromSubPhrases(subPhrases: Iterable<Phrase>): Phrase {
            val result = mutableListOf<Word>()
            for (phrase in subPhrases) {
                val first = phrase.firstOrNull() ?: continue
                if (result.isEmpty()) {
                    result += phrase
                } else {
                    val last = result.removeLast()
                    result += Word.join(listOf(last, first))
                    result += phrase.drop(1)
                }
            }
            return Phrase(result)
        }
    }
}

