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

    val segmentsAsWords: Iterable<Word>
        get() = segments.map { seg -> StandardWord.fromSegments(listOf(seg)) }

    fun isEmpty(): Boolean = segments.isEmpty()

    fun reversed(): Word = ReversedWord(this)

    operator fun iterator(): Iterator<Segment> = segments.iterator()

    operator fun get(index: Int): Segment = segments[index]

    fun softGet(index: Int): Segment? = if (index in 0 until length) this[index] else null

    fun slice(indices: IntRange): Word = StandardWord.fromSegments(segments.slice(indices))

    fun sliceSegments(indices: IntRange): Iterable<Segment> = object : Iterable<Segment> {
        override fun iterator(): Iterator<Segment> = object : Iterator<Segment> {
            private var cursor = indices.first

            override fun hasNext(): Boolean = cursor <= indices.last

            override fun next(): Segment = get(cursor).also { cursor++ }
        }
    }

    fun take(n: Int): Word = StandardWord.fromSegments(segments.take(n))

    fun drop(n: Int): Word = StandardWord.fromSegments(segments.drop(n))

    /**
     * Splits the word at spaces
     */
    fun split(): List<Word> = segments.split(Segment.space).map { StandardWord.fromSegments(it) }

    operator fun plus(other: Word): Word = StandardWord.fromSegments(segments + other.segments)
}

// A reversed view of a word
private class ReversedWord(val inner: Word) : Word {
    override val string: String
        get() = force().string

    override val segments: List<Segment>
        get() = inner.segments.asReversed()

    override fun normalize(): Word = ReversedWord(inner.normalize())

    override fun toString(): String =
        segments.joinToString(separator = "/") { it.string } + " (reversed)"

    override fun compareTo(other: Word): Int = force().compareTo(other)

    private fun force(): Word = StandardWord.fromSegments(segments)

    override fun reversed(): Word = inner
}

class StandardWord(
    private val stringSegments: List<String>,
) : Word {
    override val string: String = stringSegments.joinToString("")

    override val segments: List<Segment> = stringSegments.map(::Segment)

    override fun normalize(): Word =
        StandardWord(stringSegments.map { it.normalizeDecompose() })

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

        fun join(words: List<Word>): StandardWord =
            fromSegments(words.flatMap { it.segments })

        fun joinWithSpaces(words: List<Word>): StandardWord =
            fromSegments(words.map { it.segments }.join(Segment.space))
    }
}

data class Segment(val string: String) {
    companion object {
        val space = Segment(" ")
    }
}

class SyllabifiedWord(
    private val stringSegments: List<String>,
    private val syllables: List<Syllable>,
) : Word {
    override val string: String = syllablesAsWords.joinToString(".") { it.string }

    override val segments: List<Segment> = stringSegments.map(::Segment)

    val syllablesAsWords: List<Word>
        get() = syllables.map {
            StandardWord(stringSegments.slice(it.startIndex until it.endIndex))
        }

    override fun normalize(): Word =
        SyllabifiedWord(
            stringSegments.map { it.normalizeDecompose() }, syllables
        )

    override fun toString(): String =
        syllablesAsWords.joinToString("//")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SyllabifiedWord) return false
        return stringSegments == other.stringSegments &&
                syllables == other.syllables
    }

    override fun hashCode(): Int {
        var result = stringSegments.hashCode()
        result = 31 * result + syllables.hashCode()
        return result
    }

    override fun compareTo(other: Word): Int = 0
}

data class Syllable(val startIndex: Int, val endIndex: Int)

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
        var syllableStart = 0
        var syllableOffset = 0
        val syllables = mutableListOf<Syllable>()

        fun doneSegment() {
            parsedSegments += word.substring(segStart, cursor)
            segStart = cursor
        }

        fun doneSyllable() {
            val syllableEnd = cursor - syllableOffset
            syllables += Syllable(syllableStart, syllableEnd)
            syllableStart = syllableEnd
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
            SyllabifiedWord(parsedSegments, syllables)
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

    fun fullyReversed(): Phrase =
        Phrase(reversed().map { it.reversed() })

    /**
     * Joins this Phrase's words together with space to form a Word
     */
    fun toWord(): Word = StandardWord.joinWithSpaces(words)

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
                    result += StandardWord.join(listOf(last, first))
                    result += phrase.drop(1)
                }
            }
            return Phrase(result)
        }
    }
}
