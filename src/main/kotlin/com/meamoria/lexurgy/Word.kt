package com.meamoria.lexurgy

interface Word<S : Segment<S>> {
    val type: SegmentType<S>

    /**
     * The word represented by this ``Word`` as a plain string. This is distinct from calling ``toString()``, which
     * might show additional markup to indicate the word's structure.
     */
    val string: String

    val segments: List<S>

    val segmentsAsWords: Iterable<Word<S>>
        get() = segments.map {seg -> type.fromSegments(listOf(seg))}

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

    fun join(words: Iterable<Word<S>>): Word<S> = fromSegments(words.flatMap {it.segments})
}


class PlainWord(override val string: String) : Word<PlainSegment> {
    override val type: SegmentType<PlainSegment>
        get() = Plain

    override val segments: List<PlainSegment>
        get() = string.toCharArray().map(::PlainSegment)
}

class PlainSegment(val char: Char) : Segment<PlainSegment> {
    override val type: SegmentType<PlainSegment>
        get() = Plain
}

object Plain : SegmentType<PlainSegment> {
    override fun fromSegments(segments: Iterable<PlainSegment>): Word<PlainSegment> =
        PlainWord(segments.map(PlainSegment::char).joinToString())
}