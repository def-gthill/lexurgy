package com.meamoria.lexurgy.word

class StandardWord private constructor(
    override val segments: List<Segment>,
    private val syllabification: Syllabification? = null,
) : Word {
    constructor(segments: List<Segment>) : this(segments, null)

    override val string: String
        get() = syllabification?.string ?: segments.joinToString("") { it.string }

    override val length: Int = segments.size

    fun withSyllabification(
        syllableBreaks: List<Int>,
        syllableModifiers: Map<Int, List<Modifier>> = emptyMap(),
    ): StandardWord = StandardWord(
        segments,
        Syllabification(segments, syllableBreaks, syllableModifiers),
    )

    override fun toStandard(): StandardWord = this

    override fun normalize(parser: PhoneticParser): Word =
        StandardWord(
            segments.map { it.normalizeDecompose(parser) },
            syllabification?.normalize(parser)
        )

    private val forcedSyllabification: Syllabification
        get() = syllabification ?: Syllabification(segments, emptyList(), emptyMap())

    override val numSyllables: Int
        get() = syllabification?.numSyllables ?: 0

    override val syllableBreaks: List<Int>
        get() = syllabification?.syllableBreaks ?: emptyList()

    override val syllableModifiers: Map<Int, List<Modifier>>
        get() = syllabification?.syllableModifiers ?: emptyMap()

    override fun modifiersAt(index: Int): List<Modifier> =
        syllabification?.modifiersAt(index) ?: emptyList()

    override fun forceReversed(): Word =
        StandardWord(
            segments.reversed(),
            syllabification?.reversed(),
        )

    override fun slice(indices: IntRange): Word =
        StandardWord(
            segments.slice(indices),
            syllabification?.slice(indices),
        )

    override fun take(n: Int): Word =
        StandardWord(
            segments.take(n),
            syllabification?.take(n),
        )

    override fun drop(n: Int): Word =
        StandardWord(
            segments.drop(n),
            syllabification?.drop(n),
        )

    override fun filterSegments(filter: (Segment) -> Boolean): FilteredWord {
        val (filteredSegments, filterMap) = segments.filterReturningIndices(filter)
        return FilteredWord(
            StandardWord(
                filteredSegments,
                syllabification?.retainOnlyIndices(filterMap),
            ),
            filterMap
        )
    }

    private fun List<Segment>.filterReturningIndices(
        filter: (Segment) -> Boolean
    ): Pair<List<Segment>, IntArray> {
        val (segments, filterMap) = withIndex().filter {
            filter(it.value)
        }.map { it.value to it.index }.unzip()
        return segments to filterMap.toIntArray()
    }

    override fun removeLeadingBreak(): Word =
        StandardWord(
            segments,
            syllabification?.removeLeadingBreak(),
        )

    override fun removeTrailingBreak(): Word =
        StandardWord(
            segments,
            syllabification?.removeTrailingBreak(),
        )

    override fun concat(
        other: Word,
        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier>
    ): Word {
        val otherStandard = other.toStandard()
        val combiner = when {
            // Empty words shouldn't influence syllable-level features
            this.isEmpty() -> { _, right -> right }
            other.isEmpty() -> { left, _ -> left }
            else -> syllableModifierCombiner
        }
        return StandardWord(
            segments + other.segments,
            if (isSyllabified() || other.isSyllabified()) {
                forcedSyllabification.concat(
                    otherStandard.forcedSyllabification,
                    combiner,
                )
            } else null
        )
    }

    override fun <T> updateSyllableModifiers(
        changes: Map<Int, T>,
        updater: (List<Modifier>, T) -> List<Modifier>
    ): Word =
        StandardWord(
            segments,
            syllabification?.updateSyllableModifiers(changes, updater),
        )

    override fun recoverStructure(other: Word, exceptSyllableBreaks: List<Int>): Word =
        syllabification?.recoverStructure(other, exceptSyllableBreaks) ?: other

    override fun isSyllabified(): Boolean = syllabification != null

    override fun toSimple(): Word = StandardWord(segments)

    override fun toSyllabified(): Word =
        if (isSyllabified()) this else withSyllabification(emptyList())

    override fun toString(): String =
        syllabification?.toString() ?: segments.joinToString(separator = "/")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StandardWord) return false
        return segments == other.segments &&
                syllabification == other.syllabification
    }

    override fun hashCode(): Int = segments.hashCode()

    companion object {
        val EMPTY: StandardWord = StandardWord(emptyList())
        val SYLLABLE_BREAK_ONLY: StandardWord = StandardWord(
            emptyList(), Syllabification(emptyList(), listOf(0), emptyMap())
        )

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
            if ("//" in string || "((" in string || "||" in string || "))" in string) {
                fromSyllabifiedSchematic(string)
            } else {
                StandardWord(
                    string.split("/").map { Segment.fromSchematic(it) }
                )
            }

        private fun fromSyllabifiedSchematic(string: String): StandardWord {
            val syllableSchematics = string.split("//").filter { it.isNotEmpty() }
            val (syllableSegments, syllableModifiers) =
                syllableSchematics.map { fromSyllableSchematic(it) }.unzip()
            val segments = syllableSegments.flatten()
            return StandardWord(
                segments,
                Syllabification(
                    segments,
                    syllableSegments.scan(0) { acc, s -> acc + s.size }.slice(
                        (if (string.startsWith("//")) 0 else 1)..
                                syllableSegments.size - (if (string.endsWith("//")) 0 else 1)
                    ),
                    syllableModifiers.withIndex().filter {
                        it.value.isNotEmpty()
                    }.associateBy({ it.index }, { it.value }),
                )
            )
        }

        private fun fromSyllableSchematic(string: String): Pair<List<Segment>, List<Modifier>> {
            val (syllableCore, syllableModifiers) = fromSchematic(
                string,
                beforeSeparator = "((",
                firstSeparator = "||",
                afterSeparator = "))",
            )
            return fromSchematic(syllableCore).segments to syllableModifiers
        }
    }
}