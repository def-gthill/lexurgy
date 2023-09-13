package com.meamoria.lexurgy.word

import com.meamoria.lexurgy.SegmentTree
import com.meamoria.lexurgy.UserError

class PhoneticParser(
    val segments: List<String>,
    val modifiers: List<Modifier>,
    val syllableSeparator: String? = null,
    val syllableModifiers: List<Modifier> = emptyList(),
) {
    private val fullDict = segments.associateWith { Core } +
            modifiers.associate { it.string to SegmentModifier(it.position) } +
            syllableModifiers.associate { it.string to SyllableModifier(it.position) }

    private val tree = SegmentTree(fullDict)

    fun parse(string: String): Word {
        var unparsedString = string

        var core: String? = null
        val diacritics = mutableListOf<Modifier>()
        val syllableDiacritics = mutableListOf<Modifier>()

        val parsedSegments = mutableListOf<Segment>()
        val syllableBreaks = mutableListOf<Int>()
        val finalSyllableModifiers = mutableMapOf<Int, MutableList<Modifier>>()

        fun doneSegment() {
            parsedSegments += Segment(core!!, diacritics.toList())
            core = null
            diacritics.clear()
        }

        fun doneSyllable(addSyllableBreak: Boolean = true) {
            finalSyllableModifiers.getOrPut(syllableBreaks.size) {
                mutableListOf()
            } += syllableDiacritics
            if (addSyllableBreak) {
                syllableBreaks += parsedSegments.size
            }
            syllableDiacritics.clear()
        }

        while (unparsedString.isNotEmpty()) {
            val cursor = string.length - unparsedString.length
            val match = tree.tryMatch(unparsedString)
            if (syllableSeparator != null) {
                if (unparsedString.startsWith(syllableSeparator)) {
                    if (core != null) doneSegment()
                    doneSyllable()
                    unparsedString = unparsedString.drop(syllableSeparator.length)
                    continue
                } else if (
                    syllableDiacritics.any { it.position == ModifierPosition.AFTER } &&
                    match?.second != SyllableModifier(ModifierPosition.AFTER)
                ) throw DanglingDiacritic(
                    string, cursor, match?.first ?: unparsedString.first().toString()
                )
            }
            if (match == null) {
                if (core != null) doneSegment()
                core = unparsedString.first().toString()
                unparsedString = unparsedString.drop(1)
            } else {
                val (matchString, matchType) = match
                when (matchType) {
                    Core -> {
                        if (core != null) doneSegment()
                        core = matchString
                        unparsedString = unparsedString.drop(matchString.length)
                    }

                    is SegmentModifier -> when (matchType.position) {
                        ModifierPosition.BEFORE -> {
                            if (core != null) doneSegment()
                            if (matchString.length >= unparsedString.length)
                                throw DanglingDiacritic(string, cursor, matchString)
                            diacritics += Modifier(
                                matchString,
                                ModifierPosition.BEFORE,
                            )
                            unparsedString = unparsedString.drop(matchString.length)
                        }

                        ModifierPosition.FIRST -> {
                            if (core != null && core!!.length == 1) {
                                unparsedString = core!! + unparsedString.drop(matchString.length)
                                core = null
                                diacritics += Modifier(matchString, ModifierPosition.FIRST)
                            } else throw DanglingDiacritic(string, cursor, matchString)
                        }

                        ModifierPosition.NUCLEUS -> throw AssertionError()
                        ModifierPosition.AFTER -> {
                            if (core != null) {
                                diacritics += Modifier(
                                    matchString,
                                    ModifierPosition.AFTER,
                                )
                                unparsedString = unparsedString.drop(matchString.length)
                            } else throw DanglingDiacritic(string, cursor, matchString)
                        }
                    }

                    is SyllableModifier -> when (matchType.position) {
                        ModifierPosition.BEFORE -> {
                            if (core != null) doneSegment()
                            if (parsedSegments.size != (syllableBreaks.lastOrNull() ?: 0))
                                throw DanglingDiacritic(string, cursor, matchString)
                            if (matchString.length >= unparsedString.length)
                                throw DanglingDiacritic(string, cursor, matchString)
                            syllableDiacritics += Modifier(
                                matchString,
                                ModifierPosition.BEFORE,
                            )
                            unparsedString = unparsedString.drop(matchString.length)
                        }

                        ModifierPosition.FIRST -> {
                            if (core != null && core!!.length == 1) {
                                unparsedString = core!! + unparsedString.drop(matchString.length)
                                core = null
                                syllableDiacritics += Modifier(matchString, ModifierPosition.FIRST)
                            } else throw DanglingDiacritic(string, cursor, matchString)
                        }

                        ModifierPosition.NUCLEUS -> throw AssertionError()
                        ModifierPosition.AFTER -> {
                            if (core != null) {
                                syllableDiacritics += Modifier(
                                    matchString,
                                    ModifierPosition.AFTER,
                                )
                                unparsedString = unparsedString.drop(matchString.length)
                            } else throw DanglingDiacritic(string, cursor, matchString)
                        }
                    }
                }
            }
        }

        if (core != null) doneSegment()
        doneSyllable(addSyllableBreak = false)

        return if (syllableSeparator != null) {
            StandardWord(parsedSegments).withSyllabification(
                syllableBreaks,
                finalSyllableModifiers,
            )
        } else {
            StandardWord(parsedSegments)
        }
    }

    private sealed class MatchType

    private object Core : MatchType()

    private data class SegmentModifier(val position: ModifierPosition) : MatchType()

    private data class SyllableModifier(val position: ModifierPosition) : MatchType()
}

class DanglingDiacritic(word: String, position: Int, diacritic: String) :
    UserError("The diacritic $diacritic at position $position in $word isn't attached to a symbol")