package com.meamoria.lexurgy

interface Word : Comparable<Word> {
    /**
     * The word represented by this ``Word`` as a plain string. This is distinct from calling ``toString()``, which
     * might show additional markup to indicate the word's structure.
     */
    val string: String

    val segments: List<Segment>

    val length: Int
        get() = segments.size

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

    /**
     * Splits the word at spaces
     */
    fun split(): List<Word> =
        (listOf(-1) + segments.allIndicesOf(Segment.space).map { it } + length).zipWithNext {
            start, end -> slice(start + 1 until end)
        }

    operator fun plus(other: Word): Word

    /**
     * Returns a word with the same segments as ``other``,
     * but structures copied from this word if those structures
     * are missing in ``other``.
     */
    fun recoverStructure(other: Word): Word

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

        fun joinWithSpaces(words: List<Word>): Word =
            if (words.isEmpty()) StandardWord.empty
            else {
                var result = words.first()
                for (word in words.drop(1)) {
                    result += StandardWord.single(Segment.space)
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

    override fun plus(other: Word): Word =
        when(other) {
            is ReversedWord -> ReversedWord(other.inner + this.inner)
            else -> forceReversed() + other
        }

    override fun recoverStructure(other: Word): Word =
        when(other) {
            is ReversedWord -> ReversedWord(inner.recoverStructure(other.inner))
            else -> inner.forceReversed().recoverStructure(other)
        }

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

    override fun compareTo(other: Word): Int = force().compareTo(other)

    private fun force(): Word = inner.forceReversed()
}

class StandardWord(
    private val stringSegments: List<String>,
) : Word {
    override val string: String = stringSegments.joinToString("")

    override val segments: List<Segment> = stringSegments.map(::Segment)

    override fun normalize(): Word =
        StandardWord(stringSegments.map { it.normalizeDecompose() })

    override fun forceReversed(): Word =
        StandardWord(stringSegments.reversed())

    override fun slice(indices: IntRange): Word =
        StandardWord(stringSegments.slice(indices))

    override fun take(n: Int): Word =
        StandardWord(stringSegments.take(n))

    override fun drop(n: Int): Word =
        StandardWord(stringSegments.drop(n))

    override fun plus(other: Word): Word =
        StandardWord(stringSegments + other.segments.map { it.string })

    override fun recoverStructure(other: Word): Word = other

    override fun toString(): String =
        stringSegments.joinToString(separator = "/")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StandardWord) return false
        return stringSegments == other.stringSegments
    }

    override fun hashCode(): Int = stringSegments.hashCode()

    override fun compareTo(other: Word): Int {
        for ((thisSegment, otherSegment) in stringSegments.zip(other.segments.map { it.string })) {
            if (thisSegment < otherSegment) return -1
            if (thisSegment > otherSegment) return 1
        }
        if (stringSegments.size < other.segments.size) return -1
        if (stringSegments.size > other.segments.size) return 1
        return 0
    }

    companion object {
        val empty: StandardWord = StandardWord(emptyList())

        fun single(segment: Segment): StandardWord = fromSegments(listOf(segment))

        fun fromSegments(segments: List<Segment>): StandardWord =
            StandardWord(segments.map { it.string })

        /**
         * Creates a word with a segment for each character
         * in the string.
         */
        fun fromString(string: String): StandardWord =
            StandardWord(string.toList().map { it.toString() })
    }
}

data class Segment(val string: String) {
    companion object {
        val space = Segment(" ")
    }
}

class SyllabifiedWord(
    private val stringSegments: List<String>,
    val syllableBreaks: List<Int>,
) : Word {

    constructor(word: Word, syllableBreaks: List<Int>) :
            this(word.segments.map { it.string }, syllableBreaks)

    override val string: String
        get() = syllablesAsWords.joinToString(".") { it.string }

    override val segments: List<Segment>
        get() = stringSegments.map(::Segment)

    val syllablesAsWords: List<Word>
        get() = syllableBreaksAndBoundaries.zipWithNext { startIndex, endIndex ->
            StandardWord(stringSegments.slice(startIndex until endIndex))
        }

    private val syllableBreaksAndBoundaries =
        syllableBreaks.addStart().addEnd()

    private fun List<Int>.addStart() =
        if (firstOrNull() == 0) this else listOf(0) + this

    private fun List<Int>.addEnd() =
        if (last() == length) this else this + length

    override fun normalize(): Word =
        SyllabifiedWord(
            stringSegments.map { it.normalizeDecompose() }, syllableBreaks
        )

    override fun forceReversed(): Word =
        SyllabifiedWord(
            stringSegments.reversed(),
            syllableBreaks.reversed().map { length - it }
        )

    override fun slice(indices: IntRange): Word =
        SyllabifiedWord(
            stringSegments.slice(indices),
            syllableBreaks.filter {
                it >= indices.first &&
                        it <= indices.last + 1
            }.map { it - indices.first }
        )

    override fun take(n: Int): Word =
        SyllabifiedWord(
            stringSegments.take(n),
            syllableBreaks.filter { it <= n }
        )

    override fun drop(n: Int): Word =
        SyllabifiedWord(
            stringSegments.drop(n),
            syllableBreaks.filter { it >= n }.map { it - n }
        )

    override fun plus(other: Word): Word =
        when (other) {
            is SyllabifiedWord -> {
                var otherSyllableBreaks = other.syllableBreaks.map { it + length }
                if (syllableBreaks.isNotEmpty() &&
                        syllableBreaks.last() == otherSyllableBreaks.firstOrNull()) {
                    otherSyllableBreaks = otherSyllableBreaks.drop(1)
                }
                SyllabifiedWord(
                    stringSegments + other.stringSegments,
                    syllableBreaks + otherSyllableBreaks
                )
            }
            else -> SyllabifiedWord(
                stringSegments + other.segments.map { it.string },
                syllableBreaks,
            )
        }

    override fun recoverStructure(other: Word): Word =
        when (other) {
            is SyllabifiedWord -> other
            else -> SyllabifiedWord(
                other.segments.map { it.string },
                syllableBreaks.filter { it <= other.length }
            )
        }

    override fun toString(): String =
        syllablesAsWords.joinToString("//")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SyllabifiedWord) return false
        return stringSegments == other.stringSegments &&
                syllableBreaks == other.syllableBreaks
    }

    override fun hashCode(): Int {
        var result = stringSegments.hashCode()
        result = 31 * result + syllableBreaks.hashCode()
        return result
    }

    override fun compareTo(other: Word): Int = 0
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
            StandardWord(parsedSegments)
        } else {
            doneSyllable()
            SyllabifiedWord(parsedSegments, syllableBreaks)
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

    private val fullyReversed: Phrase by lazy { Phrase(reversed().map { it.reversed() }) }

    fun fullyReversed(): Phrase = fullyReversed


    /**
     * Joins this Phrase's words together with space to form a Word
     */
    fun toWord(): Word = Word.joinWithSpaces(words)

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
        fun splitWord(word: Word): Phrase = Phrase(word.split())

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
