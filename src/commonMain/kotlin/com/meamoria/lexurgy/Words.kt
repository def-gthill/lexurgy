package com.meamoria.lexurgy

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
     * Returns the word represented by this ``Word`` as
     * a plain string (as per ``string``) but with the
     * specified segment made prominent
     */
    fun highlightSegment(index: Int): String =
        take(index).string + "(" + this[index].core + ")" + drop(index + 1).string

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

    override fun toStandard(): StandardWord = force().toStandard()

    override fun normalize(parser: PhoneticParser): Word =
        ReversedWord(inner.normalize(parser))

    override val numSyllables: Int
        get() = TODO("Not yet implemented")

    override val syllableBreaks: List<Int>
        get() = TODO("Not yet implemented")

    override val syllableModifiers: Map<Int, List<Modifier>>
        get() = TODO("Not yet implemented")

    override fun modifiersAt(index: Int): List<Modifier> {
        TODO("Not yet implemented")
    }

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
        when (other) {
            is ReversedWord -> ReversedWord(inner.recoverStructure(other.inner))
            else -> inner.forceReversed().recoverStructure(other)
        }

    override fun isSyllabified(): Boolean = inner.isSyllabified()

    override fun toString(): String =
        segments.joinToString(separator = "/") { it.core } + " (reversed)"

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
        StandardWord(segments.map { it.normalizeDecompose(parser) })

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
        StandardWord(segments.slice(indices))

    override fun take(n: Int): Word =
        StandardWord(segments.take(n))

    override fun drop(n: Int): Word =
        StandardWord(segments.drop(n))

    override fun concat(
        other: Word,
        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier>
    ): Word {
        val otherStandard = other.toStandard()
        return StandardWord(
            segments + other.segments,
            forcedSyllabification.concat(
                otherStandard.forcedSyllabification,
                syllableModifierCombiner,
            )
        )
    }
//    other.asSyllabified()?.let { sylOther ->
//        SyllabifiedWord(this, emptyList()).concat(sylOther, syllableModifierCombiner)
//    } ?: StandardWord(segments + other.segments)

    override fun recoverStructure(other: Word): Word = other

    override fun isSyllabified(): Boolean = false

    override fun toString(): String =
        syllabification?.toString() ?: segments.joinToString(separator = "/")

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
                        (if (string.startsWith("//")) 0 else 1) ..
                                syllableSegments.size - (if(string.endsWith("//")) 0 else 1)
                    ),
                    syllableModifiers.withIndex().filter {
                        it.value.isNotEmpty()
                    }.associateBy({ it.index }, { it.value }),
                )
            )
        }

        private fun fromSyllableSchematic(string: String): Pair<List<Segment>, List<Modifier>> {
            val (syllableCore, syllableModifiers) = breakModifiers(
                string,
                beforeSeparator = "((",
                firstSeparator = "||",
                afterSeparator = "))",
            )
            return fromSchematic(syllableCore).segments to syllableModifiers
        }
    }
}

data class Segment(val core: String, val modifiers: List<Modifier> = emptyList()) {

    val string: String
        get() = core.modify(modifiers)

    /**
     * Normalizes this segment to NFD form, both in the core string
     * and in the modifiers. The core string is re-parsed using
     * the given ``PhoneticParser`` to see if it itself contains
     * declared modifiers; if so, these modifiers are moved to
     * the modifier list.
     */
    fun normalizeDecompose(parser: PhoneticParser): Segment {
        val normalizedString = core.normalizeDecompose()
        val normalizedModifiers = modifiers.map { it.normalizeDecompose() }
        if (normalizedString == core) return Segment(core, normalizedModifiers)
        val parsedString = parser.parse(normalizedString)
        return if (parsedString.length == 1) {
            val parsedSegment = parsedString[0]
            Segment(parsedSegment.core, parsedSegment.modifiers + normalizedModifiers)
        } else Segment(normalizedString, normalizedModifiers)
    }

    override fun toString(): String =
        core.modifySchematic(
            modifiers,
            beforeSeparator = "(",
            firstSeparator = "|",
            afterSeparator = ")",
        )

    companion object {
        fun fromSchematic(string: String): Segment = breakModifiers(
            string,
            beforeSeparator = "(",
            firstSeparator = "|",
            afterSeparator = ")",
        )
    }
}

data class Modifier(val string: String, val position: ModifierPosition) {
    fun normalizeDecompose(): Modifier =
        Modifier(string.normalizeDecompose(), position)
}

private fun List<Modifier>?.concat(): String =
    (this ?: emptyList()).joinToString("") { it.string }

private fun String.modify(modifiers: List<Modifier>): String {
    val modifiersByPosition = modifiers.groupBy { it.position }
    return modifiersByPosition[ModifierPosition.BEFORE].concat() +
            (firstOrNull() ?: "") +
            modifiersByPosition[ModifierPosition.FIRST].concat() +
            drop(1) +
            modifiersByPosition[ModifierPosition.AFTER].concat()
}

private fun String.modifySchematic(
    modifiers: List<Modifier>,
    beforeSeparator: String,
    firstSeparator: String,
    afterSeparator: String,
): String {
    val modifiersByPosition = modifiers.groupBy { it.position }
    return modifierString(modifiersByPosition[ModifierPosition.BEFORE], postfix = beforeSeparator) +
            this +
            modifierString(modifiersByPosition[ModifierPosition.FIRST], prefix = firstSeparator) +
            modifierString(modifiersByPosition[ModifierPosition.AFTER], prefix = afterSeparator)
}

private fun modifierString(
    modifiers: List<Modifier>?, prefix: String = "", postfix: String = ""
): String =
    modifiers?.ifNotEmpty { mods ->
        prefix + mods.joinToString("") { it.string } + postfix
    } ?: ""

private fun breakModifiers(
    string: String,
    beforeSeparator: String,
    firstSeparator: String,
    afterSeparator: String,
): Segment {
    val beforeEnd = string.indexOf(beforeSeparator)
    val maybeCoreEnd = string.indexOf(firstSeparator)
    val maybeFirstEnd = string.indexOf(afterSeparator)

    val coreStart =
        if (beforeEnd >= 0) beforeEnd + beforeSeparator.length
        else 0
    val coreEnd = when {
        maybeCoreEnd >= 0 -> maybeCoreEnd
        maybeFirstEnd >= 0 -> maybeFirstEnd
        else -> string.length
    }
    val firstStart =
        if (maybeCoreEnd >= 0) maybeCoreEnd + firstSeparator.length
        else -1
    val firstEnd = if (maybeFirstEnd >= 0) maybeFirstEnd else string.length
    val afterStart =
        if (firstEnd >= 0) firstEnd + afterSeparator.length
        else -1

    val beforeModifiers = if (beforeEnd < 0) emptyList() else {
        string.take(beforeEnd).map {
            Modifier(it.toString(), ModifierPosition.BEFORE)
        }
    }
    val firstModifiers = if (firstStart < 0) emptyList() else {
        (if (afterStart < 0) string.drop(firstEnd)
        else string.slice(firstStart until firstEnd)
                ).map { Modifier(it.toString(), ModifierPosition.FIRST) }
    }
    val afterModifiers = if (afterStart < 0) emptyList() else {
        string.drop(afterStart).map {
            Modifier(it.toString(), ModifierPosition.AFTER)
        }
    }

    return Segment(
        string.slice(coreStart until coreEnd),
        beforeModifiers + firstModifiers + afterModifiers,
    )
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
        get() = (if (syllableBreakAtStart()) "." else "") +
                syllablesAsWords.mapIndexed { i, syl ->
                    syl.string.modify(syllableModifiers[i] ?: emptyList())
                }.joinToString(".") +
                (if (syllableBreakAtEnd()) "." else "")

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

    val numSyllables: Int =
        syllableBreaks.size + 1 -
                (if (syllableBreakAtStart()) 1 else 0) -
                (if (syllableBreakAtEnd()) 1 else 0)

    fun modifiersAt(index: Int): List<Modifier> =
        syllableModifiers[syllableNumberAt(index)] ?: emptyList()

    fun syllableNumberAt(index: Int): Int =
        if (syllableBreaks.isEmpty()) 0
        else syllableBreaks.indexOfFirst { it > index } - (if (syllableBreakAtStart()) 1 else 0)

    fun reversed(): Syllabification =
        Syllabification(
            segments.reversed(),
            syllableBreaks.reversed().map { length - it },
            syllableModifiers.mapKeys { numSyllables - it.key - 1 }
        )

    fun concat(
        other: Syllabification,
        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier>
    ): Syllabification {
        var otherSyllableBreaks = other.syllableBreaks.map { it + length }
        if (syllableBreakAtEnd() && other.syllableBreakAtStart()) {
            otherSyllableBreaks = otherSyllableBreaks.drop(1)
        }
        val combinedSyllableModifiers =
            if (syllableBreakAtEnd() || other.syllableBreakAtStart()) {
                syllableModifiers + other.syllableModifiers.mapKeys {
                    it.key + numSyllables + if (syllableBreakAtEnd()) 0 else 1
                }
            } else {
                val syllableOffset = numSyllables - 1
                (syllableModifiers - syllableOffset) +
                        (syllableOffset to syllableModifierCombiner(
                            syllableModifiers[syllableOffset] ?: emptyList(),
                            other.syllableModifiers[0] ?: emptyList(),
                        )) +
                        (other.syllableModifiers - 0).mapKeys {
                            it.key + syllableOffset
                        }
            }
        return Syllabification(
            segments + other.segments,
            syllableBreaks + otherSyllableBreaks,
            combinedSyllableModifiers,
        )
    }

    override fun toString(): String =
        (if (syllableBreakAtStart()) "//" else "") +
                syllablesAsWords.mapIndexed { i, syl ->
                    syl.toString().modifySchematic(
                        syllableModifiers[i] ?: emptyList(),
                        beforeSeparator = "((",
                        firstSeparator = "||",
                        afterSeparator = "))",
                    )
                }.joinToString("//") +
                (if (syllableBreakAtEnd()) "//" else "")
}

//
//class SyllabifiedWord(
//    override val segments: List<Segment>,
//    val syllableBreaks: List<Int>,
//    val syllableModifiers: Map<Int, List<Modifier>> = emptyMap(),
//) : Word {
//
//    constructor(
//        word: Word,
//        syllableBreaks: List<Int>,
//        syllableModifiers: Map<Int, List<Modifier>> = emptyMap()
//    ) : this(word.segments, syllableBreaks, syllableModifiers)
//
//    override val string: String
//        get() = syllablesAsWords.mapIndexed {
//                i, syl -> syl.string.modify(syllableModifiers[i] ?: emptyList())
//        }.joinToString(".")
//
//    override val length: Int = segments.size
//
//    val syllablesAsWords: List<Word>
//        get() = syllableBreaksAndBoundaries.zipWithNext { startIndex, endIndex ->
//            StandardWord(segments.slice(startIndex until endIndex))
//        }
//
//    private val syllableBreaksAndBoundaries =
//        (if (syllableBreakAtStart()) emptyList() else listOf(0)) +
//                syllableBreaks +
//                (if (syllableBreakAtEnd()) emptyList() else listOf(length))
//
//    private fun syllableBreakAtStart(): Boolean =
//        syllableBreaks.firstOrNull() == 0
//
//    private fun syllableBreakAtEnd(): Boolean =
//        syllableBreaks.lastOrNull() == length
//
//    fun modifiersAt(index: Int): List<Modifier> =
//        syllableModifiers[syllableNumberAt(index)] ?: emptyList()
//
//    fun syllableNumberAt(index: Int): Int =
//        syllableBreaks.indexOfFirst { it > index } - (if (syllableBreakAtStart()) 1 else 0)
//
//    override fun normalize(parser: PhoneticParser): Word =
//        SyllabifiedWord(
//            segments.map { it.normalizeDecompose(parser) }, syllableBreaks
//        )
//
//    override fun forceReversed(): Word =
//        SyllabifiedWord(
//            segments.reversed(),
//            syllableBreaks.reversed().map { length - it }
//        )
//
//    override fun slice(indices: IntRange): Word =
//        SyllabifiedWord(
//            segments.slice(indices),
//            syllableBreaks.filter {
//                it >= indices.first &&
//                        it <= indices.last + 1
//            }.map { it - indices.first },
//            syllableModifiers.filterKeys {
//                it >= syllableNumberAt(indices.first) &&
//                        it <= syllableNumberAt(indices.last)
//            }.mapKeys { it.key - syllableNumberAt(indices.first) },
//        )
//
//    override fun take(n: Int): Word =
//        SyllabifiedWord(
//            segments.take(n),
//            syllableBreaks.filter { it <= n },
//            syllableModifiers.filterKeys { it <= syllableNumberAt(n) },
//        )
//
//    override fun drop(n: Int): Word =
//        SyllabifiedWord(
//            segments.drop(n),
//            syllableBreaks.map { it - n }.filter { it >= 0 },
//            syllableModifiers.mapKeys {
//                it.key - syllableNumberAt(n)
//            }.filterKeys { it >= 0 },
//        )
//
//    override fun concat(
//        other: Word,
//        syllableModifierCombiner: (List<Modifier>, List<Modifier>) -> List<Modifier>
//    ): Word =
//        other.asSyllabified()?.let { sylOther ->
//            var otherSyllableBreaks = sylOther.syllableBreaks.map { it + length }
//            if (this.syllableBreakAtEnd() && sylOther.syllableBreakAtStart()) {
//                otherSyllableBreaks = otherSyllableBreaks.drop(1)
//            }
//            val combinedSyllableModifiers =
//                if(this.syllableBreakAtEnd() || sylOther.syllableBreakAtStart()) {
//                    this.syllableModifiers + sylOther.syllableModifiers.mapKeys {
//                        it.key + syllableBreaks.size + if (this.syllableBreakAtEnd()) 0 else 1
//                    }
//                } else {
//                    (this.syllableModifiers - syllableBreaks.size) +
//                            (syllableBreaks.size to syllableModifierCombiner(
//                                this.syllableModifiers[syllableBreaks.size] ?: emptyList(),
//                                sylOther.syllableModifiers[0] ?: emptyList(),
//                            )) +
//                            (sylOther.syllableModifiers - 0).mapKeys {
//                                it.key + syllableBreaks.size + 1
//                            }
//                }
//            SyllabifiedWord(
//                segments + sylOther.segments,
//                syllableBreaks + otherSyllableBreaks,
//                combinedSyllableModifiers,
//            )
//        } ?: SyllabifiedWord(
//            segments + other.segments,
//            syllableBreaks,
//            syllableModifiers,
//        )
//
//    override fun recoverStructure(other: Word): Word =
//        other.asSyllabified() ?: SyllabifiedWord(
//            other.segments,
//            syllableBreaks.filter { it <= other.length }
//        )
//
//    override fun isSyllabified(): Boolean = true
//
//    override fun asSyllabified(): SyllabifiedWord = this
//
//    override fun toString(): String =
//        syllablesAsWords.joinToString("//")
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other !is SyllabifiedWord) return false
//        return segments == other.segments &&
//                syllableBreaks == other.syllableBreaks
//    }
//
//    override fun hashCode(): Int {
//        var result = segments.hashCode()
//        result = 31 * result + syllableBreaks.hashCode()
//        return result
//    }
//}

class PhoneticParser(
    val segments: List<String>,
    val beforeDiacritics: List<String> = emptyList(),
    val firstDiacritics: List<String> = emptyList(),
    val afterDiacritics: List<String> = emptyList(),
    val syllableSeparator: String? = null,
) {
    private val fullDict = segments.associateWith { 0 } +
            beforeDiacritics.associateWith { ModifierPosition.BEFORE } +
            firstDiacritics.associateWith { ModifierPosition.FIRST } +
            afterDiacritics.associateWith { ModifierPosition.AFTER }

    private val tree = SegmentTree(fullDict)

    fun parse(string: String): Word {
        var cursor = 0
        var unparsedString = string

        var core: String? = null
        val diacritics = mutableListOf<Modifier>()

        val parsedSegments = mutableListOf<Segment>()
        var syllableOffset = 0
        val syllableBreaks = mutableListOf<Int>()

        fun doneSegment() {
            parsedSegments += Segment(core!!, diacritics.toList())
            core = null
            diacritics.clear()
        }

        fun doneSyllable() {
            syllableBreaks += cursor - syllableOffset
        }

        while (cursor < string.length) {
            if (syllableSeparator != null) {
                if (unparsedString.startsWith(syllableSeparator)) {
                    if (core != null) doneSegment()
                    doneSyllable()
                    cursor += syllableSeparator.length
                    unparsedString = unparsedString.drop(syllableSeparator.length)
                    syllableOffset += syllableSeparator.length
                    continue
                }
            }
            val match = tree.tryMatch(unparsedString)
            if (match == null) {
                if (core != null) doneSegment()
                core = string[cursor].toString()
                cursor++
                unparsedString = unparsedString.drop(1)
            } else {
                val (matchString, matchType) = match
                when (matchType) {
                    ModifierPosition.BEFORE -> {
                        // Before diacritic
                        if (core != null) doneSegment()
                        val matchEnd = cursor + matchString.length
                        if (matchEnd >= string.length)
                            throw DanglingDiacritic(string, cursor, matchString)
                        diacritics += Modifier(
                            matchString,
                            ModifierPosition.BEFORE,
                        )
                        cursor = matchEnd
                        unparsedString = unparsedString.drop(matchString.length)
                    }
                    0 -> {
                        // Core symbol
                        if (core != null) doneSegment()
                        core = matchString
                        cursor += matchString.length
                        unparsedString = unparsedString.drop(matchString.length)
                    }
                    ModifierPosition.FIRST -> {
                        // First-character diacritic
                        if (core != null && core!!.length == 1) {
                            unparsedString = core!! + unparsedString.drop(matchString.length)
                            core = null
                            diacritics += Modifier(matchString, ModifierPosition.FIRST)
                        } else throw DanglingDiacritic(string, cursor, matchString)
                    }
                    ModifierPosition.AFTER -> {
                        // After diacritic
                        if (core != null) {
                            diacritics += Modifier(
                                matchString,
                                ModifierPosition.AFTER,
                            )
                            cursor += matchString.length
                            unparsedString = unparsedString.drop(matchString.length)
                        } else throw DanglingDiacritic(string, cursor, matchString)
                    }
                    else -> throw AssertionError()
                }
            }
        }

        if (core != null) doneSegment()
        return if (syllableSeparator == null) {
            StandardWord(parsedSegments)
        } else {
            doneSyllable()
            StandardWord(parsedSegments).withSyllabification(syllableBreaks)
        }
    }
}

class DanglingDiacritic(word: String, position: Int, diacritic: String) :
    UserError("The diacritic $diacritic at position $position in $word isn't attached to a symbol")

class SyllableStructureViolated(word: Word, position: Int) :
    UserError(
        "The segment \"${word[position].core}\" in \"${word.highlightSegment(position)}\" " +
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
        index.wordIndex in 0..size &&
                index.segmentIndex in 0..words[index.wordIndex].length

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
