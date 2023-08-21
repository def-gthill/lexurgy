package com.meamoria.lexurgy.word

data class PhraseIndex(val wordIndex: Int, val segmentIndex: Int) : Comparable<PhraseIndex> {
    /**
     * Compare this `PhraseIndex` to `other`; "larger" indices are
     * later in the phrase.
     *
     * Note that this function makes no reference to an actual `Phrase`,
     * so it can't verify whether any indices are actually valid for a given phrase.
     * It's the caller's responsibility to do that checking if necessary.
     */
    override fun compareTo(other: PhraseIndex): Int =
        compareBy<PhraseIndex>(
            { it.wordIndex },
            { it.segmentIndex },
        ).compare(this, other)

    /**
     * Advance this `PhraseIndex` by the number of words and/or
     * segments specified by `delta`.
     *
     * Advancing to a new word in the phrase resets the segment
     * index to zero; therefore, if `delta` specifies a non-zero number
     * of words, the resulting segment index will be exactly `delta.segmentIndex`,
     * ignoring this `PhraseIndex`'s segment index.
     *
     * Note that this function makes no reference to an actual `Phrase`,
     * so it can't verify whether any indices are actually valid for a given phrase.
     * It's the caller's responsibility to do that checking if necessary.
     */
    operator fun plus(delta: PhraseIndex): PhraseIndex =
        if (delta.wordIndex == 0) {
            PhraseIndex(
                wordIndex,
                segmentIndex + delta.segmentIndex,
            )
        } else {
            PhraseIndex(
                wordIndex + delta.wordIndex,
                delta.segmentIndex,
            )
        }

    /**
     * Convert this `PhraseIndex` to an index relative to `start`.
     *
     * Advancing to a new word in the phrase resets the segment
     * index to zero; therefore, if `start` has a different word index
     * than this, the resulting segment index will be exactly `this.segmentIndex`,
     * ignoring `start.segmentIndex`.
     *
     * Note that this function makes no reference to an actual `Phrase`,
     * so it can't verify whether any indices are actually valid for a given phrase.
     * It's the caller's responsibility to do that checking if necessary.
     */
    operator fun minus(start: PhraseIndex): PhraseIndex =
        if (wordIndex == start.wordIndex) {
            PhraseIndex(0, segmentIndex - start.segmentIndex)
        } else {
            PhraseIndex(wordIndex - start.wordIndex, segmentIndex)
        }


    override fun toString(): String = "($wordIndex, $segmentIndex)"
}

infix fun ClosedRange<PhraseIndex>.overlaps(other: ClosedRange<PhraseIndex>): Boolean =
    !(start >= other.endInclusive || other.start >= endInclusive)