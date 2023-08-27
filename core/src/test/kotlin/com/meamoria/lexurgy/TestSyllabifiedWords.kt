package com.meamoria.lexurgy

import com.meamoria.lexurgy.word.*
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.maps.shouldBeEmpty
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestSyllabifiedWords : FreeSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic)

    fun phrase(schematic: String): Phrase = Phrase(word(schematic))

    val banana = word("b/a//n/a//n/a")
    val excellent = word("e/k//s/e//ˈ((l/e/n//t/e")
    val shine = word("sc/ei/n||ʰ))`")
    val startBreak = word("//f/oo")
    val endBreak = word("f/oo//")
    val empty = StandardWord.EMPTY
    val breakOnly = StandardWord.SYLLABLE_BREAK_ONLY

    val stress = Modifier("ˈ", ModifierPosition.BEFORE)
    val h = Modifier("ʰ", ModifierPosition.FIRST)
    val backquote = Modifier("`", ModifierPosition.AFTER)

    "The \"string\" value of a syllabified word should include syllable markup" {
        banana.string shouldBe "ba.na.na"
        excellent.string shouldBe "ek.se.ˈlen.te"
        shine.string shouldBe "sʰcein`"
        startBreak.string shouldBe ".foo"
        endBreak.string shouldBe "foo."
        breakOnly.string shouldBe "."
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

    "Syllabified words have syllable modifiers in the correct places" {
        banana.syllableModifiers shouldBe emptyMap()
        excellent.syllableModifiers shouldBe mapOf(2 to listOf(stress))
        shine.syllableModifiers shouldBe mapOf(
            0 to listOf(h, backquote)
        )
        startBreak.syllableModifiers shouldBe emptyMap()
        endBreak.syllableModifiers shouldBe emptyMap()
    }

    "Syllabified words return syllable modifiers for any index in the syllable" {
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

    "Syllabified words can return a mapping from each index to the syllable modifiers at that index" {
        banana.syllableModifiersByIndex() shouldBe emptyMap()
        excellent.syllableModifiersByIndex() shouldBe mapOf(
            4 to listOf(stress),
            5 to listOf(stress),
            6 to listOf(stress),
        )
    }

    "We should be able to concatenate syllabified words" {
        (banana + excellent).string shouldBe "ba.na.naek.se.ˈlen.te"
        (banana + shine).string shouldBe "ba.na.nascein"
        (banana + startBreak).string shouldBe "ba.na.na.foo"
        (startBreak + excellent).string shouldBe ".fooek.se.ˈlen.te"
        (breakOnly + banana).string shouldBe ".ba.na.na"
        (breakOnly + excellent).string shouldBe ".ek.se.ˈlen.te"
        ((shine + endBreak) + (startBreak + excellent)).string shouldBe "sʰceinfoo`.fooek.se.ˈlen.te"
        (empty + (startBreak + excellent)).string shouldBe ".fooek.se.ˈlen.te"
        (breakOnly + (startBreak + excellent)).string shouldBe ".fooek.se.ˈlen.te"
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

    "slice" - {
        "includes syllable breaks from within the slice" {
            val result = word("b/a//n/a").slice(0 until 3)
            result.string shouldBe "ba.n"
        }

        "yields a word with an initial syllable break if the slice starts at a syllable break" {
            val result = word("a//n/a").slice(1 until 3)
            result.string shouldBe ".na"
        }

        "yields a word with a final syllable break if the slice ends at a syllable break" {
            val result = word("b/a//n/a").slice(0 until 2)
            result.string shouldBe "ba."
        }

        "includes syllable-level features from syllables that overlap the slice" {
            val result = word("ˈ((b/a//n/a//n/a))`").slice(1 until 5)
            result.string shouldBe "ˈa.na.n`"
        }

        "doesn't include syllable-level features from syllables that stop at the boundary of the slice" {
            val result = word("ˈ((b/a//n/a//n/a))`").slice(2 until 4)
            result.string shouldBe ".na."
            result.syllableModifiers.shouldBeEmpty()
        }
    }

    "We should be able to drop segments from syllabified words" {
        banana.drop(2).string shouldBe ".na.na"
        banana.drop(5).string shouldBe "a"
        excellent.drop(5).string shouldBe "ˈen.te"
        shine.drop(1).string shouldBe "eʰin`"
    }

    "We should be able to filter segments in syllabified words" {
        banana.filterSegments { it.string == "n" }.toString() shouldBe "n//n [2, 4]"
        excellent.filterSegments { it.string == "e" }.toString() shouldBe "e//e//ˈ((e//e [0, 3, 5, 8]"
        excellent.filterSegments { it.string in "kl" }.toString() shouldBe "k//ˈ((l [1, 4]"
        excellent.filterSegments { it.string in "kt" }.toString() shouldBe "k//t [1, 7]"
    }

    "recoverStructure" - {
        "copies syllable breaks exactly if the words are the same length" {
            val result = phrase("a//b/a//k/l/a").recoverStructure(phrase("e/v/e/x/l/e"))
            result.string shouldBe "e.ve.xle"
        }

        "copies syllable breaks by relative position from the start if the new word is longer" {
            val result = phrase("a//b/a").recoverStructure(phrase("e/v/e/a/i"))
            result.string shouldBe "e.veai"
        }

        "copies only syllable breaks within the new word if the new word is shorter" {
            val result = phrase("a//b/a//k/l/a").recoverStructure(phrase("e/v/e"))
            result.string shouldBe "e.ve"
        }

        "preserves an initial syllable break" {
            val result = phrase("//a").recoverStructure(phrase("e/a/i"))
            result.string shouldBe ".eai"
        }

        "preserves a final syllable break if the new word is longer" {
            val result = phrase("a//").recoverStructure(phrase("e/a/i"))
            result.string shouldBe "eai."
        }

        "preserves a final syllable break if the new word is shorter" {
            val result = phrase("a//b/a//").recoverStructure(phrase("e/a"))
            result.string shouldBe "e.a."
        }

        "preserves both initial and final syllable breaks" {
            val result = phrase("//a//").recoverStructure(phrase("e/a/i"))
            result.string shouldBe ".eai."
        }

        "copies syllable-level features exactly if the words are the same length" {
            val result = phrase("a//ˈ((b/a//k/l/a").recoverStructure(phrase("e/v/e/x/l/e"))
            result.string shouldBe "e.ˈve.xle"
        }

        "copies syllable-level features by relative position from the start if the new word is longer" {
            val result = phrase("a//ˈ((b/a").recoverStructure(phrase("e/v/e/a/i"))
            result.string shouldBe "e.ˈveai"
        }

        "coalesces syllable-level features from excess syllables if the new word is shorter" {
            val result = phrase("a//ˈ((b/a//k/l/a))`").recoverStructure(phrase("e/v/e"))
            result.string shouldBe "e.ˈve`"
        }

        "coalesces syllable-level features from excess syllables even if there's a final syllable break" {
            val result = phrase("a//ˈ((b/a//k/l/a))`//").recoverStructure(phrase("e/v/e"))
            result.string shouldBe "e.ˈve`."
        }

//        "doesn't copy syllable-level features from subsequent syllables if the new word is longer" {
//            val result = phrase("a//ˈ((b/a").recoverStructure(phrase("e/v/e/a/i"))
//        }

        "can be applied to entire phrases" {
            val plainPhrase = Phrase(
                listOf(
                    StandardWord.fromSchematic("b/a/n/a/n/a"),
                    StandardWord.fromSchematic("sch/ei/n"),
                    StandardWord.fromSchematic("p)ʰ/ou|́/ⁿ(t/ei|̀/t/o")
                )
            )

            Phrase(banana).recoverStructure(plainPhrase).string shouldBe "ba.na.na schein pʰóuⁿtèito"
            Phrase(excellent).recoverStructure(plainPhrase).string shouldBe "ba.na.ˈna ˈsch.ein pʰóuⁿtèito"
            Phrase(shine).recoverStructure(plainPhrase).string shouldBe "bʰanana` sʰchein` pʰʰóuⁿtèito`"
            Phrase(listOf(startBreak, banana, shine)).recoverStructure(plainPhrase).string shouldBe ".ba.na.na schei.nʰ` pʰʰóuⁿtèito`"
        }
    }
})