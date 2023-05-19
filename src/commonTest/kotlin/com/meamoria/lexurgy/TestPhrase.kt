package com.meamoria.lexurgy

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.word.StandardWord
import com.meamoria.lexurgy.word.Word
import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestPhrase : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic)

    "Iterating over a single-word phrase hits all the segments in the phrase" {
        val phrase = Phrase(word("f/o/o"))
        val indices = phrase.iterateFrom(phrase.firstIndex).asSequence().toList()
        indices shouldBe listOf(
            PhraseIndex(0, 0),
            PhraseIndex(0, 1),
            PhraseIndex(0, 2),
            PhraseIndex(0, 3),
        )
    }

    "Iterating backward over a single-word phrase hits all the segments in the phrase" {
        val phrase = Phrase(word("f/o/o"))
        val indices = phrase.iterateBackFrom(phrase.lastIndex).asSequence().toList()
        indices shouldBe listOf(
            PhraseIndex(0, 3),
            PhraseIndex(0, 2),
            PhraseIndex(0, 1),
            PhraseIndex(0, 0),
        )
    }
})
