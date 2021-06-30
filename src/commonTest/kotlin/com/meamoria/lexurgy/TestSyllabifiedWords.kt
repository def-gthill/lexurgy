package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestSyllabifiedWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic)

    val banana = word("b/a//n/a//n/a")
    val excellent = word("e/k//s/e//ˈ((l/e/n//t/e")
    val shine = word("sc/ei/n||ʰ))`")
    val startBreak = word("//f/oo")
    val endBreak = word("f/oo//")

    val stress = Modifier("ˈ", ModifierPosition.BEFORE)
    val h = Modifier("ʰ", ModifierPosition.FIRST)
    val backquote = Modifier("`", ModifierPosition.AFTER)

    "The \"string\" value of a syllabified word should include syllable markup" {
        banana.string shouldBe "ba.na.na"
        excellent.string shouldBe "ek.se.ˈlen.te"
        shine.string shouldBe "sʰcein`"
        startBreak.string shouldBe ".foo"
        endBreak.string shouldBe "foo."
    }

    "The \"toString\" should recreate the schematic" {
        banana.toString() shouldBe "b/a//n/a//n/a"
        excellent.toString() shouldBe "e/k//s/e//ˈ((l/e/n//t/e"
        shine.toString() shouldBe "sc/ei/n||ʰ))`"
        startBreak.toString() shouldBe "//f/oo"
        endBreak.toString() shouldBe "f/oo//"
    }

    "Syllabified words should have correct syllable counts" {
        banana.numSyllables shouldBe 3
        excellent.numSyllables shouldBe 4
        shine.numSyllables shouldBe 1
        startBreak.numSyllables shouldBe 1
        endBreak.numSyllables shouldBe 1
        word("").numSyllables shouldBe 0
        word("//").numSyllables shouldBe 0
    }

    "Syllabified words should have syllable breaks in the correct places" {
        banana.syllableBreaks shouldBe listOf(2, 4)
        excellent.syllableBreaks shouldBe listOf(2, 4, 7)
        shine.syllableBreaks shouldBe emptyList()
        startBreak.syllableBreaks shouldBe listOf(0)
        endBreak.syllableBreaks shouldBe listOf(2)
    }

    "Syllabified words should have syllable modifiers in the correct places" {
        banana.syllableModifiers shouldBe emptyMap()
        excellent.syllableModifiers shouldBe mapOf(2 to listOf(stress))
        shine.syllableModifiers shouldBe mapOf(
            0 to listOf(h, backquote)
        )
        startBreak.syllableModifiers shouldBe emptyMap()
        endBreak.syllableModifiers shouldBe emptyMap()
    }

    "Syllabified words should return syllable modifiers for any index in the syllable" {
        banana.modifiersAt(0) shouldBe emptyList()
        banana.modifiersAt(3) shouldBe emptyList()
        banana.modifiersAt(5) shouldBe emptyList()
        excellent.modifiersAt(0) shouldBe emptyList()
        excellent.modifiersAt(3) shouldBe emptyList()
        excellent.modifiersAt(4) shouldBe listOf(stress)
        excellent.modifiersAt(5) shouldBe listOf(stress)
        excellent.modifiersAt(6) shouldBe listOf(stress)
        excellent.modifiersAt(7) shouldBe emptyList()
        shine.modifiersAt(0) shouldBe listOf(h, backquote)
        shine.modifiersAt(1) shouldBe listOf(h, backquote)
        shine.modifiersAt(2) shouldBe listOf(h, backquote)
    }

    "We should be able to concatenate syllabified words" {
        (banana + excellent).string shouldBe "ba.na.naek.se.ˈlen.te"
        (banana + shine).string shouldBe "ba.na.nascein"
        (banana + startBreak).string shouldBe "ba.na.na.foo"
        (startBreak + excellent).string shouldBe ".fooek.se.ˈlen.te"
        ((shine + endBreak) + (startBreak + excellent)).string shouldBe "sʰceinfoo`.fooek.se.ˈlen.te"
        (excellent + startBreak + shine).string shouldBe "ek.se.ˈlen.te.fooscein"
    }

    "We should be able to provide a modifier combiner to override the default left-only behaviour" {
        startBreak.concat(shine) { _, b -> b }.string shouldBe ".fʰooscein`"
    }

    "We should be able to concatenate simple words to syllabified words" {
        (banana + word("f/o/o")).string shouldBe "ba.na.nafoo"
        (word("f/o/o") + banana).string shouldBe "fooba.na.na"
        (shine + word("f/o/o")).string shouldBe "sʰceinfoo`"
        (word("f/o/o") + shine).string shouldBe "fooscein"
        word("f/o/o").concat(shine) { _, b -> b }.string shouldBe "fʰooscein`"
    }
})