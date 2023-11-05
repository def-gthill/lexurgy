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

    fun parse(string: String): Word =
        PhoneticParseRun(tree, syllableSeparator, string).run()
}

private class PhoneticParseRun(
    val tree: SegmentTree<MatchType>,
    val syllableSeparator: String?,
    val string: String,
) {
    private var unparsedString = string
    private var core: String? = null

    private val diacritics = mutableListOf<Modifier>()
    private val syllableDiacritics = mutableListOf<Modifier>()

    private val parsedSegments = mutableListOf<Segment>()
    private val syllableBreaks = mutableListOf<Int>()
    private val finalSyllableModifiers = mutableMapOf<Int, MutableList<Modifier>>()

    fun run(): Word {
        while (unparsedString.isNotEmpty()) {
            parseNext()
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

    fun parseNext() {
        if (parseSyllableLevelSymbol()) {
            return
        }
        val match = tree.tryMatch(unparsedString)
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

                is SegmentModifier -> processSegmentModifier(matchType.position, matchString)

                is SyllableModifier -> processSyllableModifier(matchType.position, matchString)
            }
        }
    }

    fun parseSyllableLevelSymbol(): Boolean {
        val cursor = string.length - unparsedString.length
        val match = tree.tryMatch(unparsedString)

        if (syllableSeparator != null) {
            if (unparsedString.startsWith(syllableSeparator)) {
                if (core != null) doneSegment()
                doneSyllable()
                unparsedString = unparsedString.drop(syllableSeparator.length)
                return true
            } else if (
                syllableDiacritics.any { it.position == ModifierPosition.AFTER } &&
                match?.second != SyllableModifier(ModifierPosition.AFTER)
            ) throw DanglingDiacritic(
                string, cursor, match?.first ?: unparsedString.first().toString()
            )
            return false
        }
        return false
    }

    fun processSegmentModifier(position: ModifierPosition, matchString: String) {
        val cursor = string.length - unparsedString.length
        when (position) {
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
    }

    fun processSyllableModifier(position: ModifierPosition, matchString: String) {
        val cursor = string.length - unparsedString.length
        when (position) {
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
}

private sealed class MatchType

private object Core : MatchType()

private data class SegmentModifier(val position: ModifierPosition) : MatchType()

private data class SyllableModifier(val position: ModifierPosition) : MatchType()

class DanglingDiacritic(word: String, position: Int, diacritic: String) :
    UserError("The diacritic $diacritic at position $position in $word isn't attached to a symbol")