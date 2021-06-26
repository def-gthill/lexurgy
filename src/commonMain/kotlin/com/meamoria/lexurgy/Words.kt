package com.meamoria.lexurgy

interface Word {
    /**
     * The word represented by this ``Word`` as a plain string. This is distinct from calling ``toString()``, which
     * might show additional markup to indicate the word's structure.
     */
    val string: String

    val segments: List<Segment>

    val length: Int

    fun normalize(): Word

    fun isEmpty(): Boolean = segments.isEmpty()

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

    /**
     * Returns a word with the same segments as ``other``,
     * but structures copied from this word if those structures
     * are missing in ``other``.
     */
    fun recoverStructure(other: Word): Word

    /**
     * Checks whether this word has syllable structure
     */
    fun isSyllabified(): Boolean

    /**
     * Converts to a syllabified word if possible, otherwise
     * returns null
     */
    fun asSyllabified(): SyllabifiedWord?

    /**
     * Returns the word represented by this ``Word`` as
     * a plain string (as per ``string``) but with the
     * specified segment made prominent
     */
    fun highlightSegment(index: Int): String =
        take(index).string + "(" + this[index].string + ")" + drop(index + 1).string

    companion object {
        fun join(words: List<Word>): Word =
            if (words.isEmpty()) StandardWord.empty
            else {
                var result = words.first()
                for (word in words.drop(1)) {
                    result += word
                }
                result
            }
    }
}

// A reversed view of a word
private class ReversedWord(val inner: Word) : Word {
    override val string: String
        get() = force().string

    override val segments: List<Segment>
        get() = inner.segments.asReversed()

    override val length: Int
        get() = inner.length

    override fun normalize(): Word = ReversedWord(inner.normalize())

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
            inner.drop(inner.length - n)
        )

    override fun drop(n: Int): Word =
        ReversedWord(
            inner.take(inner.length - n)
        )

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
            else -> forceReversed().concat(other, syllableModifierCombiner)
        }

    override fun recoverStructure(other: Word): Word =
        when(other) {
            is ReversedWord -> ReversedWord(inner.recoverStructure(other.inner))
            else -> inner.forceReversed().recoverStructure(other)
        }

    override fun isSyllabified(): Boolean = inner.isSyllabified()

    override fun asSyllabified(): SyllabifiedWord? =
        force().asSyllabified()

    override fun toString(): String =
        segments.joinToString(separator = "/") { it.string } + " (reversed)"

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

class StandardWord private constructor(
    override val segments: List<Segment>,
    private val syllabification: Syllabification? = null,
) : Word {

    constructor(segments: List<Segment>) : this(segments, null)

    override val string: String
        get() = syllabification?.string ?: segments.joinToString("")

    override val length: Int = segments.size

    fun withSyllabification(
        syllableBreaks: List<Int>,
        syllableModifiers: Map<Int, List<Modifier>> = emptyMap(),
    ): StandardWord = StandardWord(
        segments,
        Syllabification(segments, syllableBreaks, syllableModifiers),
    )

    override fun normalize(): Word =
        StandardWord(segments.map { it.normalizeDecompose() })

    override fun forceReversed(): Word =
        StandardWord(segments.reversed())

    override fun slice(indices: IntRange): Word =
        StandardWord(segments.slice(indices))

    override fun take(n: Int): Word =
        StandardWord(segments.take(n))

    override fun drop(n: Int): Word =
        StandardWord(segments.drop(n))

    override fun concat(
        other: Word,
        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier>
    ): Word = other.asSyllabified()?.let { sylOther ->
        SyllabifiedWord(this, emptyList()).concat(sylOther, syllableModifierCombiner)
    } ?: StandardWord(segments + other.segments)

    override fun recoverStructure(other: Word): Word = other

    override fun isSyllabified(): Boolean = false

    override fun asSyllabified(): SyllabifiedWord? = null

    override fun toString(): String =
        segments.joinToString(separator = "/")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StandardWord) return false
        return segments == other.segments
    }

    override fun hashCode(): Int = segments.hashCode()

    companion object {
        val empty: StandardWord = StandardWord(emptyList())

        fun single(segment: Segment): StandardWord =
            StandardWord(listOf(segment))

        /**
         * Creates a word with a segment for each character
         * in the string.
         */
        fun fromString(string: String): StandardWord =
            StandardWord(string.toList().map { Segment(it.toString()) })

        /**
         * Creates a word from the specified schematic, using the
         * following syntax:
         *
         * - Segments are separated by slashes '/';
         * - "Before" diacritics are separated from the core by an open paren '(';
         * - "After" diacritics are separated from the core by a close paren ')';
         * - "First" diacritics are written after the core and separated from it by a pipe '|'.
         */
        fun fromSchematic(string: String): StandardWord =
            StandardWord(string.split("/").map(::Segment))
    }
}

data class Segment(val string: String, val modifiers: List<Modifier> = emptyList()) {
    fun normalizeDecompose(): Segment =
        Segment(string.normalizeDecompose(), modifiers)

    override fun toString(): String = string.modify(modifiers)
}

data class Modifier(val string: String, val position: ModifierPosition)

private fun List<Modifier>?.concat(): String =
    (this ?: emptyList()).joinToString { it.string }

private fun String.modify(modifiers: List<Modifier>): String {
    val modifiersByPosition = modifiers.groupBy { it.position }
    return modifiersByPosition[ModifierPosition.BEFORE].concat() +
            (firstOrNull() ?: "") +
            modifiersByPosition[ModifierPosition.FIRST].concat() +
            drop(1) +
            modifiersByPosition[ModifierPosition.AFTER].concat()
}

enum class ModifierPosition {
    BEFORE,
    FIRST,
    NUCLEUS,
    AFTER,
}

private class Syllabification(
    private val segments: List<Segment>,
    val syllableBreaks: List<Int>,
    val syllableModifiers: Map<Int, List<Modifier>> = emptyMap(),
) {
    val length: Int = segments.size

    val string: String
        get() = syllablesAsWords.mapIndexed {
                i, syl -> syl.string.modify(syllableModifiers[i] ?: emptyList())
        }.joinToString(".")

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
}

class SyllabifiedWord(
    override val segments: List<Segment>,
    val syllableBreaks: List<Int>,
    val syllableModifiers: Map<Int, List<Modifier>> = emptyMap(),
) : Word {

    constructor(
        word: Word,
        syllableBreaks: List<Int>,
        syllableModifiers: Map<Int, List<Modifier>> = emptyMap()
    ) : this(word.segments, syllableBreaks, syllableModifiers)

    override val string: String
        get() = syllablesAsWords.mapIndexed {
                i, syl -> syl.string.modify(syllableModifiers[i] ?: emptyList())
        }.joinToString(".")

    override val length: Int = segments.size

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

    fun modifiersAt(index: Int): List<Modifier> =
        syllableModifiers[syllableNumberAt(index)] ?: emptyList()

    fun syllableNumberAt(index: Int): Int =
        syllableBreaks.indexOfFirst { it > index } - (if (syllableBreakAtStart()) 1 else 0)

    override fun normalize(): Word =
        SyllabifiedWord(
            segments.map { it.normalizeDecompose() }, syllableBreaks
        )

    override fun forceReversed(): Word =
        SyllabifiedWord(
            segments.reversed(),
            syllableBreaks.reversed().map { length - it }
        )

    override fun slice(indices: IntRange): Word =
        SyllabifiedWord(
            segments.slice(indices),
            syllableBreaks.filter {
                it >= indices.first &&
                        it <= indices.last + 1
            }.map { it - indices.first },
            syllableModifiers.filterKeys {
                it >= syllableNumberAt(indices.first) &&
                        it <= syllableNumberAt(indices.last)
            }.mapKeys { it.key - syllableNumberAt(indices.first) },
        )

    override fun take(n: Int): Word =
        SyllabifiedWord(
            segments.take(n),
            syllableBreaks.filter { it <= n },
            syllableModifiers.filterKeys { it <= syllableNumberAt(n) },
        )

    override fun drop(n: Int): Word =
        SyllabifiedWord(
            segments.drop(n),
            syllableBreaks.map { it - n }.filter { it >= 0 },
            syllableModifiers.mapKeys {
                it.key - syllableNumberAt(n)
            }.filterKeys { it >= 0 },
        )

    override fun concat(
        other: Word,
        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier>
    ): Word =
        other.asSyllabified()?.let { sylOther ->
            var otherSyllableBreaks = sylOther.syllableBreaks.map { it + length }
            if (this.syllableBreakAtEnd() && sylOther.syllableBreakAtStart()) {
                otherSyllableBreaks = otherSyllableBreaks.drop(1)
            }
            val combinedSyllableModifiers =
                if(this.syllableBreakAtEnd() || sylOther.syllableBreakAtStart()) {
                    this.syllableModifiers + sylOther.syllableModifiers.mapKeys {
                        it.key + syllableBreaks.size + if (this.syllableBreakAtEnd()) 0 else 1
                    }
                } else {
                    (this.syllableModifiers - syllableBreaks.size) +
                            (syllableBreaks.size to syllableModifierCombiner(
                                this.syllableModifiers[syllableBreaks.size] ?: emptyList(),
                                sylOther.syllableModifiers[0] ?: emptyList(),
                            )) +
                            (sylOther.syllableModifiers - 0).mapKeys {
                                it.key + syllableBreaks.size + 1
                            }
                }
            SyllabifiedWord(
                segments + sylOther.segments,
                syllableBreaks + otherSyllableBreaks,
                combinedSyllableModifiers,
            )
        } ?: SyllabifiedWord(
            segments + other.segments,
            syllableBreaks,
            syllableModifiers,
        )

    override fun recoverStructure(other: Word): Word =
        other.asSyllabified() ?: SyllabifiedWord(
            other.segments,
            syllableBreaks.filter { it <= other.length }
        )

    override fun isSyllabified(): Boolean = true

    override fun asSyllabified(): SyllabifiedWord = this

    override fun toString(): String =
        syllablesAsWords.joinToString("//")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SyllabifiedWord) return false
        return segments == other.segments &&
                syllableBreaks == other.syllableBreaks
    }

    override fun hashCode(): Int {
        var result = segments.hashCode()
        result = 31 * result + syllableBreaks.hashCode()
        return result
    }
}

class PhoneticParser(
    val segments: List<String>,
    val beforeDiacritics: List<String>,
    val afterDiacritics: List<String>,
    val syllableSeparator: String? = null,
) {
    private val fullDict = segments.associateWith { 0 } +
            beforeDiacritics.associateWith { -1 } +
            afterDiacritics.associateWith { 1 }

    private val tree = SegmentTree(fullDict)

    fun parse(word: String): Word {
        var segStart = 0
        var cursor = 0
        var coreFound = false
        val parsedSegments = mutableListOf<String>()
        var syllableOffset = 0
        val syllableBreaks = mutableListOf<Int>()

        fun doneSegment() {
            parsedSegments += word.substring(segStart, cursor)
            segStart = cursor
        }

        fun doneSyllable() {
            syllableBreaks += cursor - syllableOffset
        }

        while (cursor < word.length) {
            if (syllableSeparator != null) {
                if (word.drop(cursor).startsWith(syllableSeparator)) {
                    if (coreFound) doneSegment()
                    coreFound = false
                    doneSyllable()
                    cursor += syllableSeparator.length
                    segStart += syllableSeparator.length
                    syllableOffset += syllableSeparator.length
                    continue
                }
            }
            val match = tree.tryMatch(word.drop(cursor))
            if (match == null) {
                if (coreFound) doneSegment()
                cursor++
                coreFound = true
            } else {
                val (matchString, matchType) = match
                if (matchType == -1) {
                    // Before diacritic
                    if (coreFound) doneSegment()
                    coreFound = false
                    cursor += matchString.length
                    if (cursor >= word.length)
                        throw DanglingDiacritic(word, cursor - matchString.length, matchString)
                } else if (matchType == 0) {
                    // Core symbol
                    if (coreFound) doneSegment()
                    cursor += matchString.length
                    coreFound = true
                } else {
                    // After diacritic
                    if (coreFound) cursor += matchString.length
                    else throw DanglingDiacritic(word, cursor, matchString)
                }
            }
        }

        if (cursor > segStart) doneSegment()
        return if (syllableSeparator == null) {
            StandardWord(parsedSegments.map(::Segment))
        } else {
            doneSyllable()
            SyllabifiedWord(parsedSegments.map(::Segment), syllableBreaks)
        }
    }

    fun breakDiacritics(symbol: String): DiacriticBreakdown {
        var cursor = 0
        val before = mutableListOf<String>()
        var core: String? = null
        val after = mutableListOf<String>()
        var alreadyFailedMatch = false
        while (cursor < symbol.length) {
            val match = tree.tryMatch(symbol.drop(cursor)) ?: (symbol[cursor].toString() to 0).also {
                if (alreadyFailedMatch) return DiacriticBreakdown(symbol)
                alreadyFailedMatch = true
            }

            val (matchString, matchType) = match
            if (matchType == -1) {
                // Before diacritic
                if (core != null) throw DanglingDiacritic(symbol, cursor, matchString)
                cursor += matchString.length
                before += matchString
                if (cursor >= symbol.length) throw DanglingDiacritic(symbol, cursor - matchString.length, matchString)
            } else if (matchType == 0) {
                // Core symbol
                if (after.isNotEmpty()) throw DanglingDiacritic(symbol, cursor - matchString.length, matchString)
                cursor += matchString.length
                core = (core ?: "") + matchString
            } else {
                // After diacritic
                if (core == null) throw DanglingDiacritic(symbol, cursor, matchString)
                cursor += matchString.length
                after += matchString
            }
        }
        if (core == null) throw DanglingDiacritic(symbol, cursor, symbol.lastOrNull()?.toString() ?: "")
        return DiacriticBreakdown(core, before, after)
    }
}

data class DiacriticBreakdown(
    val core: String, val before: List<String> = emptyList(), val after: List<String> = emptyList()
)

class DanglingDiacritic(word: String, position: Int, diacritic: String) :
    UserError("The diacritic $diacritic at position $position in $word isn't attached to a symbol")

class SyllableStructureViolated(word: Word, position: Int) :
    UserError(
        "The segment \"${word[position].string}\" in \"${word.highlightSegment(position)}\" " +
                "doesn't fit the syllable structure"
    )

data class PhraseIndex(val wordIndex: Int, val segmentIndex: Int) : Comparable<PhraseIndex> {
    override fun compareTo(other: PhraseIndex): Int =
        compareBy<PhraseIndex>(
            { it.wordIndex },
            { it.segmentIndex },
        ).compare(this, other)

    override fun toString(): String = "($wordIndex, $segmentIndex)"
}

infix fun ClosedRange<PhraseIndex>.overlaps(other: ClosedRange<PhraseIndex>): Boolean =
    !(start >= other.endInclusive || other.start >= endInclusive)

class Phrase(val words: List<Word>) : Iterable<Word> {
    constructor(word: Word) : this(listOf(word))

    constructor(vararg words: Word) : this(words.asList())

    val string: String
        get() = words.joinToString(" ") { it.string }

    operator fun get(index: Int): Word = words[index]

    val size: Int
        get() = words.size

    fun hasIndex(index: PhraseIndex): Boolean =
        index.wordIndex in 0 .. size &&
                index.segmentIndex in 0 .. words[index.wordIndex].length

    override fun iterator(): Iterator<Word> = words.iterator()

    fun iterateFrom(start: PhraseIndex): Iterator<PhraseIndex> =
        object : Iterator<PhraseIndex> {
            private var cursor: PhraseIndex = start

            override fun hasNext(): Boolean =
                !(cursor.wordIndex == words.size - 1 &&
                        cursor.segmentIndex == words.last().length + 1)

            override fun next(): PhraseIndex = cursor.also { cursor = advance(it) }
        }

    fun advance(index: PhraseIndex): PhraseIndex {
        val (wordIndex, segmentIndex) = index
        return if (segmentIndex > words[wordIndex].length) {
            PhraseIndex(wordIndex + 1, 0)
        } else {
            PhraseIndex(wordIndex, segmentIndex + 1)
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
     * Concatenates the specified phrase to the end of this phrase.
     * ``syllableModifierCombiner`` specifies how to resolve
     * syllable modifiers when two syllables are combined into
     * one at the boundary. By default, the new syllable gets
     * the modifiers from the left component only.
     */
    fun concat(
        other: Phrase,
        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier> = { a, _ -> a },
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

    private val fullyReversed: Phrase by lazy { Phrase(reversed().map { it.reversed() }) }

    fun fullyReversed(): Phrase = fullyReversed

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

enum class WordLevel {
    SEGMENT,
    SYLLABLE,
    WORD,
    PHRASE,
}
