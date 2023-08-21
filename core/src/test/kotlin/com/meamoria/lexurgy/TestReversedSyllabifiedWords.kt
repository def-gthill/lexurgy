package com.meamoria.lexurgy

import com.meamoria.lexurgy.word.Modifier
import com.meamoria.lexurgy.word.ModifierPosition
import com.meamoria.lexurgy.word.StandardWord
import com.meamoria.lexurgy.word.Word
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestReversedSyllabifiedWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic).reversed()
    fun forward(schematic: String): Word = StandardWord.fromSchematic(schematic)

    val banana = word("b/a//n/a//n/a")
    val excellent = word("e/k//s/e//ˈ((l/e/n//t/e")
    val shine = word("sc/ei/n||ʰ))`")
    val startBreak = word("//f/oo")
    val endBreak = word("f/oo//")

    val stress = Modifier("ˈ", ModifierPosition.BEFORE)
    val h = Modifier("ʰ", ModifierPosition.FIRST)
    val backquote = Modifier("`", ModifierPosition.AFTER)

    "The \"string\" value of a reversed syllabified word should show correctly reversed syllable markup" {
        banana.string shouldBe "an.an.ab"
        excellent.string shouldBe "et.ˈnel.es.ke"
        shine.string shouldBe "nʰeisc`"
        startBreak.string shouldBe "oof."
        endBreak.string shouldBe ".oof"
    }

    "The \"toString\" should produce a reversed schematic" {
        banana.toString() shouldBe "a/n//a/n//a/b (reversed)"
        excellent.toString() shouldBe "e/t//ˈ((n/e/l//e/s//k/e (reversed)"
        shine.toString() shouldBe "n/ei/sc||ʰ))` (reversed)"
        startBreak.toString() shouldBe "oo/f// (reversed)"
        endBreak.toString() shouldBe "//oo/f (reversed)"
    }

    "Reversed syllabified words should have correct syllable counts" {
        banana.numSyllables shouldBe 3
        excellent.numSyllables shouldBe 4
        shine.numSyllables shouldBe 1
        startBreak.numSyllables shouldBe 1
        endBreak.numSyllables shouldBe 1
        word("").numSyllables shouldBe 0
        word("//").numSyllables shouldBe 0
    }

    "Reversed syllabified words should have syllable breaks at reversed indices" {
        banana.syllableBreaks shouldBe listOf(2, 4)
        excellent.syllableBreaks shouldBe listOf(2, 5, 7)
        shine.syllableBreaks shouldBe emptyList()
        startBreak.syllableBreaks shouldBe listOf(2)
        endBreak.syllableBreaks shouldBe listOf(0)
    }

    "Reversed syllabified words should have syllable modifiers at reversed indices" {
        banana.syllableModifiers shouldBe emptyMap()
        excellent.syllableModifiers shouldBe mapOf(1 to listOf(stress))
        shine.syllableModifiers shouldBe mapOf(
            0 to listOf(h, backquote)
        )
        startBreak.syllableModifiers shouldBe emptyMap()
        endBreak.syllableModifiers shouldBe emptyMap()
    }

    "Reversed syllabified words should return syllable modifiers for any index in the syllable" {
        banana.modifiersAt(0) shouldBe emptyList()
        banana.modifiersAt(3) shouldBe emptyList()
        banana.modifiersAt(5) shouldBe emptyList()
        excellent.modifiersAt(0) shouldBe emptyList()
        excellent.modifiersAt(1) shouldBe emptyList()
        excellent.modifiersAt(2) shouldBe listOf(stress)
        excellent.modifiersAt(3) shouldBe listOf(stress)
        excellent.modifiersAt(4) shouldBe listOf(stress)
        excellent.modifiersAt(5) shouldBe emptyList()
        excellent.modifiersAt(7) shouldBe emptyList()
        shine.modifiersAt(0) shouldBe listOf(h, backquote)
        shine.modifiersAt(1) shouldBe listOf(h, backquote)
        shine.modifiersAt(2) shouldBe listOf(h, backquote)
    }

    "We should be able to concatenate reversed syllabified words and get reversed words" {
        (banana + excellent).toString() shouldBe "a/n//a/n//a/b/e/t//ˈ((n/e/l//e/s//k/e (reversed)"
        (banana + shine).toString() shouldBe "a/n//a/n//a/b/n/ei/sc (reversed)"
        (banana + endBreak).toString() shouldBe "a/n//a/n//a/b//oo/f (reversed)"
    }

    "We should be able to provide a modifier combiner to override the default left-only behaviour" {
        banana.concat(shine) { _, b -> b }.string shouldBe "an.an.aʰbneisc`"
    }

    "We should be able to freely mix types" {
        (banana + forward("f/oo") + word("f/oo") + forward("b/a//n/a//n/a")).string shouldBe
                "an.an.abfoooofba.na.na"
    }

    "We should be able to slice reversed syllabified words and get reversed words" {
        banana.slice(0 .. 2).toString() shouldBe "a/n//a (reversed)"
        banana.slice(2 .. 5).toString() shouldBe "//a/n//a/b (reversed)"
        excellent.slice(4 .. 6).toString() shouldBe "ˈ((l//e/s// (reversed)"
        shine.slice(0 .. 1).toString() shouldBe "n/ei||ʰ))` (reversed)"
    }

    "We should be able to drop segments from reversed syllabified words" {
        banana.drop(2).string shouldBe ".an.ab"
        banana.drop(5).string shouldBe "b"
        excellent.drop(4).string shouldBe "ˈl.es.ke"
        shine.drop(1).string shouldBe "eʰisc`"
    }

    "We should be able to filter segments in reversed syllabified words" {
        banana.filterSegments { it.string == "n" }.toString() shouldBe "n//n (reversed) [1, 3]"
        excellent.filterSegments { it.string == "e" }.toString() shouldBe "e//ˈ((e//e//e (reversed) [0, 3, 5, 8]"
        excellent.filterSegments { it.string in "kl" }.toString() shouldBe "ˈ((l//k (reversed) [4, 7]"
        excellent.filterSegments { it.string in "kt" }.toString() shouldBe "t//k (reversed) [1, 7]"
    }
})