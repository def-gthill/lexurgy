package com.meamoria.lexurgy

interface Word<S : Segment<S>> : Comparable<Word<S>> {
    val type: SegmentType<S>

    /**
     * The word represented by this ``Word`` as a plain string. This is distinct from calling ``toString()``, which
     * might show additional markup to indicate the word's structure.
     */
    val string: String

    val segments: List<S>

    val segmentsAsWords: Iterable<Word<S>>
        get() = segments.map { seg -> type.fromSegments(listOf(seg)) }

    val length: Int
        get() = segments.size

    operator fun iterator(): Iterator<S> = segments.iterator()

    operator fun get(index: Int): S = segments[index]

    fun slice(indices: IntRange): Word<S> = type.fromSegments(segments.slice(indices))

    operator fun plus(other: Word<S>): Word<S> = type.fromSegments(segments + other.segments)
}

interface Segment<S : Segment<S>> {
    val type: SegmentType<S>
}

interface SegmentType<S : Segment<S>> {
    val empty: Word<S>
        get() = fromSegments(emptyList())

    fun fromSegments(segments: Iterable<S>): Word<S>

    fun join(words: Iterable<Word<S>>): Word<S> = fromSegments(words.flatMap { it.segments })
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
    override fun fromSegments(segments: Iterable<PlainSegment>): Word<PlainSegment> =
        PlainWord(segments.map(PlainSegment::char).joinToString())
}


abstract class StringSegmentWord<S : StringSegment<S>>(private val stringSegments: List<String>) : Word<S> {
    abstract override val type: StringSegmentType<S>

    override val string: String = stringSegments.joinToString()

    override val segments: List<S>
        get() = stringSegments.map(type::segmentFromString)

    override fun toString(): String = stringSegments.joinToString(separator = "/", postfix = type.toString())
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

    override fun compareTo(other: Word<PhoneticSegment>): Int {
        for ((thisSegment, otherSegment) in phoneticSegments.zip(other.segments.map(PhoneticSegment::string))) {
            if (thisSegment < otherSegment) return -1
            if (thisSegment > otherSegment) return 1
        }
        if (phoneticSegments.size < other.segments.size) return -1
        if (phoneticSegments.size > other.segments.size) return 1
        return 0
    }
}

data class PhoneticSegment(override val string: String) : StringSegment<PhoneticSegment> {
    override val type: StringSegmentType<PhoneticSegment>
        get() = Phonetic
}

object Phonetic : StringSegmentType<PhoneticSegment> {
    override fun fromSegments(segments: Iterable<PhoneticSegment>): Word<PhoneticSegment> =
        PhoneticWord(segments.map(PhoneticSegment::string))

    override fun segmentFromString(string: String): PhoneticSegment = PhoneticSegment(string)
}