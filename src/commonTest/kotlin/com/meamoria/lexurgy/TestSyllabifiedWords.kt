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

    "Syllabified words are syllabified" {
        banana.isSyllabified() shouldBe true
        excellent.isSyllabified() shouldBe true
        shine.isSyllabified() shouldBe true
        startBreak.isSyllabified() shouldBe true
        endBreak.isSyllabified() shouldBe true
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

    "We should be able to slice syllabified words" {
        banana.slice(0 .. 2).string shouldBe "ba.n"
        banana.slice(2 .. 4).string shouldBe ".na.n"
        excellent.slice(5 .. 6).string shouldBe "ˈen."
        shine.slice(0 .. 1).string shouldBe "sʰcei`"
    }

    "We should be able to drop segments from syllabified words" {
        banana.drop(2).string shouldBe ".na.na"
        banana.drop(5).string shouldBe "a"
        excellent.drop(5).string shouldBe "ˈen.te"
        shine.drop(1).string shouldBe "eʰin`"
    }

    "We should be able to recover structures in phrases" {
        val plainWord = Phrase(StandardWord.fromSchematic("b/a/n/a/n/a"))
        val plainPhrase = Phrase(
            listOf(
                StandardWord.fromSchematic("b/a/n/a/n/a"),
                StandardWord.fromSchematic("sch/ei/n"),
                StandardWord.fromSchematic("p)ʰ/ou|́/ⁿ(t/ei|̀/t/o")
            )
        )

        Phrase(banana).recoverStructure(plainWord).string shouldBe "ba.na.na"
        Phrase(excellent).recoverStructure(plainWord).string shouldBe "ba.na.ˈna."
        Phrase(shine).recoverStructure(plainWord).string shouldBe "bʰanana`"
        Phrase(endBreak).recoverStructure(plainWord).string shouldBe "ba.nana"
        Phrase(listOf(startBreak, banana)).recoverStructure(plainWord).string shouldBe ".ba.na.na."
        Phrase(endBreak).recoverStructure(
            plainWord.slice(PhraseIndex(0, 0), PhraseIndex(0, 2))
        ).string shouldBe "ba."
        Phrase(banana).recoverStructure(plainPhrase).string shouldBe "ba.na.na schein pʰóuⁿtèito"
        Phrase(excellent).recoverStructure(plainPhrase).string shouldBe "ba.na.ˈna ˈsch.ein pʰóuⁿtèito"
        Phrase(shine).recoverStructure(plainPhrase).string shouldBe "bʰanana` sʰchein` pʰʰóuⁿtèito`"
        Phrase(listOf(startBreak, banana, shine)).recoverStructure(plainPhrase).string shouldBe ".ba.na.na schei.nʰ` pʰʰóuⁿtèito`"
    }
})