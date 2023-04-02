package com.meamoria.lexurgy.word

import com.meamoria.lexurgy.normalizeDecompose

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
        fun fromSchematic(string: String): Segment {
            val (core, modifiers) = fromSchematic(
                string,
                beforeSeparator = "(",
                firstSeparator = "|",
                afterSeparator = ")",
            )
            return Segment(core, modifiers)
        }
    }
}