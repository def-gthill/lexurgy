package com.meamoria.lexurgy

import com.meamoria.lexurgy.word.StandardWord
import com.meamoria.lexurgy.word.Word
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestReversedSimpleWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic).reversed()
    fun forward(schematic: String): Word = StandardWord.fromSchematic(schematic)

    val banana = word("b/a/n/a/n/a")
    val shine = word("sch/ei/n")
    val potato = word("p)ʰ/ou|́/ⁿ(t/ei|̀/t/o")

    "The \"string\" value of a reversed word should be the concatenation of its (reversed) segments" {
        banana.string shouldBe "ananab"
        shine.string shouldBe "neisch"
        potato.string shouldBe "otèiⁿtóupʰ"
    }

    "The \"toString\" should produce a reversed schematic" {
        banana.toString() shouldBe "a/n/a/n/a/b (reversed)"
        shine.toString() shouldBe "n/ei/sch (reversed)"
        potato.toString() shouldBe "o/t/ei|̀/ⁿ(t/ou|́/p)ʰ (reversed)"
    }

    "Reversed simple words should have no syllables" {
        banana.numSyllables shouldBe 0
        shine.numSyllables shouldBe 0
        potato.numSyllables shouldBe 0
    }

    "Reversed simple words should have no syllable breaks" {
        banana.syllableBreaks.size shouldBe 0
        shine.syllableBreaks.size shouldBe 0
        potato.syllableBreaks.size shouldBe 0
    }

    "Reversed simple words should have no syllable modifiers" {
        banana.syllableModifiers.size shouldBe 0
        shine.syllableModifiers.size shouldBe 0
        potato.syllableModifiers.size shouldBe 0
    }

    "Reversed simple words should have no syllable modifiers anywhere" {
        banana.modifiersAt(0) shouldBe emptyList()
        banana.modifiersAt(3) shouldBe emptyList()
        banana.modifiersAt(5) shouldBe emptyList()
        shine.modifiersAt(0) shouldBe emptyList()
        shine.modifiersAt(1) shouldBe emptyList()
        shine.modifiersAt(2) shouldBe emptyList()
    }

    "We should be able to concatenate reversed words and get reversed words" {
        (banana + shine).toString() shouldBe "a/n/a/n/a/b/n/ei/sch (reversed)"
        (banana + potato).toString() shouldBe "a/n/a/n/a/b/o/t/ei|̀/ⁿ(t/ou|́/p)ʰ (reversed)"
    }

    "We should be able to concatenate ordinary words to reversed words and get ordinary words" {
        (banana + forward("f/o/o")).toString() shouldBe "a/n/a/n/a/b/f/o/o"
        (forward("f/o/o") + banana).toString() shouldBe "f/o/o/a/n/a/n/a/b"
    }

    "We should be able to slice reversed words and get reversed wourds" {
        banana.slice(0 .. 2).toString() shouldBe "a/n/a (reversed)"
        banana.slice(2 .. 5).toString() shouldBe "a/n/a/b (reversed)"
        shine.slice(0 .. 1).toString() shouldBe "n/ei (reversed)"
        potato.slice(3 .. 5).toString() shouldBe "ⁿ(t/ou|́/p)ʰ (reversed)"
    }

    "We should be able to drop segments from reversed words" {
        banana.drop(2).string shouldBe "anab"
        banana.drop(5).string shouldBe "b"
        shine.drop(1).string shouldBe "eisch"
        potato.drop(3).string shouldBe "ⁿtóupʰ"
    }

    "We should be able to filter segments in reversed words" {
        banana.filterSegments { it.string == "n" }.toString() shouldBe "n/n (reversed) [1, 3]"
        potato.filterSegments { "o" in it.core }.toString() shouldBe "o/ou|́ (reversed) [0, 4]"
    }
})