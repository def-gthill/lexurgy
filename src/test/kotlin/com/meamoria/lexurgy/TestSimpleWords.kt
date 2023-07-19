package com.meamoria.lexurgy

import com.meamoria.lexurgy.word.StandardWord
import com.meamoria.lexurgy.word.Word
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestSimpleWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic)

    val banana = word("b/a/n/a/n/a")
    val shine = word("sch/ei/n")
    val potato = word("p)ʰ/ou|́/ⁿ(t/ei|̀/t/o")

    "The \"string\" value of a simple word should be the concatenation of its segments" {
        banana.string shouldBe "banana"
        shine.string shouldBe "schein"
        potato.string shouldBe "pʰóuⁿtèito"
    }

    "The \"toString\" should recreate the schematic" {
        banana.toString() shouldBe "b/a/n/a/n/a"
        shine.toString() shouldBe "sch/ei/n"
        potato.toString() shouldBe "p)ʰ/ou|́/ⁿ(t/ei|̀/t/o"
    }

    "Simple words aren't syllabified" {
        banana.isSyllabified() shouldBe false
        shine.isSyllabified() shouldBe false
        potato.isSyllabified() shouldBe false
    }

    "Simple words should have no syllables" {
        banana.numSyllables shouldBe 0
        shine.numSyllables shouldBe 0
        potato.numSyllables shouldBe 0
    }

    "Simple words should have no syllable breaks" {
        banana.syllableBreaks.size shouldBe 0
        shine.syllableBreaks.size shouldBe 0
        potato.syllableBreaks.size shouldBe 0
    }

    "Simple words should have no syllable modifiers" {
        banana.syllableModifiers.size shouldBe 0
        shine.syllableModifiers.size shouldBe 0
        potato.syllableModifiers.size shouldBe 0
    }

    "Simple words should have no syllable modifiers anywhere" {
        banana.modifiersAt(0) shouldBe emptyList()
        banana.modifiersAt(3) shouldBe emptyList()
        banana.modifiersAt(5) shouldBe emptyList()
        shine.modifiersAt(0) shouldBe emptyList()
        shine.modifiersAt(1) shouldBe emptyList()
        shine.modifiersAt(2) shouldBe emptyList()
    }

    "We should be able to concatenate simple words" {
        (banana + shine).string shouldBe "bananaschein"
        (banana + potato).string shouldBe "bananapʰóuⁿtèito"
        (banana + shine).isSyllabified() shouldBe false
    }

    "We should be able to slice simple words" {
        banana.slice(0 .. 2).string shouldBe "ban"
        banana.slice(2 .. 4).string shouldBe "nan"
        shine.slice(0 .. 1).string shouldBe "schei"
        potato.slice(3 .. 5).string shouldBe "èito"
    }

    "We should be able to drop segments from simple words" {
        banana.drop(2).string shouldBe "nana"
        banana.drop(5).string shouldBe "a"
        shine.drop(1).string shouldBe "ein"
        potato.drop(3).string shouldBe "èito"
    }

    "We should be able to filter segments in simple words" {
        banana.filterSegments { it.string == "n" }.toString() shouldBe "n/n [2, 4]"
        potato.filterSegments { "o" in it.core }.toString() shouldBe "ou|́/o [1, 5]"
    }
})