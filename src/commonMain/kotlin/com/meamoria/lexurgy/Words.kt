package com.meamoria.lexurgy

interface Word<S : Segment<S>> : Comparable<Word<S>> {
    val type: SegmentType<S>

    /**
     * The word represented by this ``Word`` as a plain string. This is distinct from calling ``toString()``, which
     * might show additional markup to indicate the word's structure.
     */
    val string: String

    val segments: List<S>

    val length: Int
        get() = segments.size

    val segmentsAsWords: Iterable<Word<S>>
        get() = segments.map { seg -> type.single(seg) }

    fun reversed(): Word<S> = ReversedWord(this)

    operator fun iterator(): Iterator<S> = segments.iterator()

    operator fun get(index: Int): S = segments[index]

    fun softGet(index: Int): S? = if (index in 0 until length) this[index] else null

    fun slice(indices: IntRange): Word<S> = type.fromSegments(segments.slice(indices))

    fun sliceSegments(indices: IntRange): Iterable<S> = object : Iterable<S> {
        override fun iterator(): Iterator<S> = object : Iterator<S> {
            private var cursor = indices.first

            override fun hasNext(): Boolean = cursor <= indices.last

            override fun next(): S = get(cursor).also { cursor++ }
        }
    }

    fun take(n: Int): Word<S> = type.fromSegments(segments.take(n))

    fun drop(n: Int): Word<S> = type.fromSegments(segments.drop(n))

    /**
     * Splits the word at spaces
     */
    fun split(): List<Word<S>> = segments.split(type.space).map { type.fromSegments(it) }

    operator fun plus(other: Word<S>): Word<S> = type.fromSegments(segments + other.segments)
}

// A reversed view of a word
private class ReversedWord<S : Segment<S>>(val inner: Word<S>) : Word<S> {
    override val type: SegmentType<S> = inner.type

    override val string: String
        get() = force().string

    override val segments: List<S> = inner.segments.asReversed()

    override fun compareTo(other: Word<S>): Int = force().compareTo(other)

    private fun force(): Word<S> = type.fromSegments(segments)

    override fun reversed(): Word<S> = inner
}

interface Segment<S : Segment<S>> {
    val type: SegmentType<S>
}

interface SegmentType<S : Segment<S>> {
    val empty: Word<S>
        get() = fromSegments(emptyList())

    val space: S

    fun single(segment: S): Word<S> = fromSegments(listOf(segment))

    fun fromSegments(segments: Iterable<S>): Word<S>

    fun join(words: Iterable<Word<S>>): Word<S> = fromSegments(words.flatMap { it.segments })

    /**
     * Joins the last element of each sub-iterable to the first element of the
     * next subiterable.
     */
    fun joinEdgeWords(words: Iterable<Iterable<Word<S>>>): List<Word<S>> {
        val result = mutableListOf<Word<S>>()
        for (subList in words) {
            if (result.isEmpty()) {
                result += subList
            } else {
                val last = result.removeLast()
                result += join(listOf(last, subList.first()))
                result += subList.drop(1)
            }
        }
        return result
    }

    fun joinWithSpaces(words: Iterable<Word<S>>): Word<S> = fromSegments(words.map { it.segments }.join(space))
}


data class PlainWord(override val string: String) : Word<PlainSegment> {
    override val type: SegmentType<PlainSegment>
        get() = Plain

    override val segments: List<PlainSegment>
        get() = string.toCharArray().map(::PlainSegment)

    override fun compareTo(other: Word<PlainSegment>): Int = string.compareTo(other.string)
}

data class PlainSegment(val char: Char) : Segment<PlainSegment> {
    override val type: SegmentType<PlainSegment>
        get() = Plain
}

object Plain : SegmentType<PlainSegment> {
    override val space: PlainSegment = PlainSegment(' ')

    override fun fromSegments(segments: Iterable<PlainSegment>): Word<PlainSegment> =
        PlainWord(segments.map(PlainSegment::char).joinToString(""))
}


abstract class StringSegmentWord<S : StringSegment<S>>(private val stringSegments: List<String>) : Word<S> {
    abstract override val type: StringSegmentType<S>

    override val string: String = stringSegments.joinToString("")

    @Suppress("LeakingThis")
    override val segments: List<S> = stringSegments.map(type::segmentFromString)

    final override fun toString(): String =
        stringSegments.joinToString(separator = "/", postfix = " (${type::class.simpleName})")

    override fun compareTo(other: Word<S>): Int {
        for ((thisSegment, otherSegment) in stringSegments.zip(other.segments.map { it.string })) {
            if (thisSegment < otherSegment) return -1
            if (thisSegment > otherSegment) return 1
        }
        if (stringSegments.size < other.segments.size) return -1
        if (stringSegments.size > other.segments.size) return 1
        return 0
    }
}

interface StringSegment<S : StringSegment<S>> : Segment<S> {
    override val type: StringSegmentType<S>

    val string: String
}

interface StringSegmentType<S : StringSegment<S>> : SegmentType<S> {
    fun segmentFromString(string: String): S
}


data class PhoneticWord(val phoneticSegments: List<String>) :
    StringSegmentWord<PhoneticSegment>(phoneticSegments) {
    override val type: StringSegmentType<PhoneticSegment>
        get() = Phonetic
}

data class PhoneticSegment(override val string: String) : StringSegment<PhoneticSegment> {
    override val type: StringSegmentType<PhoneticSegment>
        get() = Phonetic
}

object Phonetic : StringSegmentType<PhoneticSegment> {
    override val space: PhoneticSegment = PhoneticSegment(" ")

    override fun fromSegments(segments: Iterable<PhoneticSegment>): Word<PhoneticSegment> =
        PhoneticWord(segments.map(PhoneticSegment::string))

    override fun segmentFromString(string: String): PhoneticSegment = PhoneticSegment(string)
}

class PhoneticParser(
    val segments: List<String>, val beforeDiacritics: List<String>, val afterDiacritics: List<String>
) {
    private val fullDict = segments.associateWith { 0 } +
            beforeDiacritics.associateWith { -1 } +
            afterDiacritics.associateWith { 1 }

    private val tree = SegmentTree(fullDict)

    fun parse(word: String): PhoneticWord {
        var segStart = 0
        var cursor = 0
        var coreFound = false
        val parsedSegments = mutableListOf<String>()

        fun doneSegment() {
            parsedSegments += word.substring(segStart, cursor)
            segStart = cursor
        }

        while (cursor < word.length) {
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
        return PhoneticWord(parsedSegments)
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
                if (core != null) throw DanglingDiacritic(symbol, cursor, matchString)
                cursor += matchString.length
                core = matchString
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

data class WordListIndex(val wordIndex: Int, val segmentIndex: Int) : Comparable<WordListIndex> {
    override fun compareTo(other: WordListIndex): Int =
        compareBy<WordListIndex>(
            { it.wordIndex },
            { it.segmentIndex },
        ).compare(this, other)

    override fun toString(): String = "($wordIndex, $segmentIndex)"
}

infix fun ClosedRange<WordListIndex>.overlaps(other: ClosedRange<WordListIndex>): Boolean =
    !(start >= other.endInclusive || other.start >= endInclusive)

val List<Word<*>>.string : String
    get() = joinToString(" ") { it.string }

fun <S : Segment<S>> List<Word<S>>.iterateFrom(start: WordListIndex): Iterator<WordListIndex> =
    object : Iterator<WordListIndex> {
        private var cursor: WordListIndex = start

        override fun hasNext(): Boolean =
            !(cursor.wordIndex == size - 1 && cursor.segmentIndex == last().length + 1)

        override fun next(): WordListIndex = cursor.also { cursor = advance(it) }
    }

fun List<Word<*>>.advance(index: WordListIndex): WordListIndex {
    val (wordIndex, segmentIndex) = index
    return if (segmentIndex > this[wordIndex].length) {
        WordListIndex(wordIndex + 1, 0)
    } else {
        WordListIndex(wordIndex, segmentIndex + 1)
    }
}

fun List<Word<*>>.reversedIndex(index: WordListIndex): WordListIndex {
    val (wordIndex, segmentIndex) = index
    return WordListIndex(size - wordIndex - 1, this[wordIndex].length - segmentIndex)
}

fun <S : Segment<S>> List<Word<S>>.dropUntil(index: WordListIndex): List<Word<S>> =
    listOf(this[index.wordIndex].drop(index.segmentIndex)) + drop(index.wordIndex + 1)


fun <S : Segment<S>> List<Word<S>>.slice(start: WordListIndex, end: WordListIndex): List<Word<S>> =
    if (start.wordIndex == end.wordIndex) {
        listOf(this[start.wordIndex].slice(start.segmentIndex until end.segmentIndex))
    } else {
        listOf(this[start.wordIndex].drop(start.segmentIndex)) +
                slice(start.wordIndex + 1 until end.wordIndex) +
                this[end.wordIndex].take(end.segmentIndex)
    }


fun <S : Segment<S>> List<Word<S>>.fullyReversed(): List<Word<S>> =
    reversed().map { it.reversed() }
