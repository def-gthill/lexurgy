package com.meamoria.lexurgy.word

/**
 * The scale within a word at which something applies
 */
enum class WordLevel(val text: String) {
    /**
     * Applies to individual segments
     */
    SEGMENT("segment"),

    /**
     * Applies to syllables
     */
    SYLLABLE("syllable"),
}