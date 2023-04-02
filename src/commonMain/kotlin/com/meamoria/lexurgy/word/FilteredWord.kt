package com.meamoria.lexurgy.word

/**
 * A word derived from applying a filter to another word.
 * The `filterMap` records the index of each retained segment
 * in the original word, e.g. [1, 3, 4] indicates that the
 * second, fourth, and fifth segments of the original word
 * have been retained.
 */
class FilteredWord(val word: Word, val filterMap: IntArray) {
    override fun toString(): String =
        "$word [${filterMap.joinToString()}]"
}