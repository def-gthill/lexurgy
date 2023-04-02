package com.meamoria.lexurgy.word

import com.meamoria.lexurgy.ifNotEmpty
import com.meamoria.lexurgy.normalizeDecompose

/**
 * A diacritic symbol that gets added to another string (the "core")
 * to change its meaning.
 */
data class Modifier(val string: String, val position: ModifierPosition) {
    fun normalizeDecompose(): Modifier =
        Modifier(string.normalizeDecompose(), position)
}

/**
 * Where a modifer should be written relative to the core.
 */
enum class ModifierPosition {
    /**
     * Before the entire core
     */
    BEFORE,

    /**
     * After the first symbol in the core
     */
    FIRST,

    /**
     * After the syllable nucleus
     */
    NUCLEUS,

    /**
     * After the entire core
     */
    AFTER,
}

/**
 * Add the specified modifiers to this string, in their
 * appropriate positions
 */
internal fun String.modify(modifiers: List<Modifier>): String {
    val modifiersByPosition = modifiers.groupBy { it.position }
    return modifiersByPosition[ModifierPosition.BEFORE].concat() +
            (firstOrNull() ?: "") +
            modifiersByPosition[ModifierPosition.FIRST].concat() +
            drop(1) +
            modifiersByPosition[ModifierPosition.AFTER].concat()
}

private fun List<Modifier>?.concat(): String =
    (this ?: emptyList()).joinToString("") { it.string }

/**
 * Create a schematic showing how the specified modifiers are
 * added to the specified string, useful for debugging and testing
 */
internal fun String.modifySchematic(
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

/**
 * Parse the specified schematic (as created by `modifySchematic`)
 * back into a core and modifiers, useful for debugging and testing
 */
internal fun fromSchematic(
    string: String,
    beforeSeparator: String,
    firstSeparator: String,
    afterSeparator: String,
): Pair<String, List<Modifier>> {
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

    val core = string.slice(coreStart until coreEnd)
    val modifiers = beforeModifiers + firstModifiers + afterModifiers

    return core to modifiers
}
