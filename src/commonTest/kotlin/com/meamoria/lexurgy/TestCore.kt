package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.should
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestCore : StringSpec({

    "We should be able extract sub-words between specified indices" {
        StandardWord.fromString("foobar").slice(1 .. 3) shouldBe
                StandardWord.fromString("oob")
        StandardWord.fromString("foobar").reversed().slice(1 .. 3) shouldBe
                StandardWord.fromString("oba").reversed()
    }

    fun foobarWithModifier(modifier: Modifier): StandardWord =
        StandardWord.fromString("foobar").withSyllabification(
            syllableBreaks = listOf(3),
            syllableModifiers = mapOf(0 to listOf(modifier))
        )

    "We should be able to put diacritics in different positions on a syllable" {
        foobarWithModifier(Modifier("ˈ", ModifierPosition.BEFORE)).string shouldBe "ˈfoo.bar"
        foobarWithModifier(Modifier("ʼ", ModifierPosition.FIRST)).string shouldBe "fʼoo.bar"
        foobarWithModifier(Modifier("|", ModifierPosition.AFTER)).string shouldBe "foo|.bar"
    }

    fun emptyWithModifier(modifier: Modifier): StandardWord =
        StandardWord.fromString("foobar").withSyllabification(
            syllableBreaks = listOf(3, 3),
            syllableModifiers = mapOf(1 to listOf(modifier))
        )

    "Syllable diacritics should render even if the syllable is empty" {
        emptyWithModifier(Modifier("ˈ", ModifierPosition.BEFORE)).string shouldBe "foo.ˈ.bar"
        emptyWithModifier(Modifier("ʼ", ModifierPosition.FIRST)).string shouldBe "foo.ʼ.bar"
        emptyWithModifier(Modifier("|", ModifierPosition.AFTER)).string shouldBe "foo.|.bar"
    }

    "We should be able to create a SegmentTree from a Map" {
        val treeMap = mapOf(
            "d" to 1,
            "de" to 2,
            "def" to 3,
            "e" to 4,
            "ef" to 5,
            "deb" to 6,
            "edeb" to 7
        )

        val tree = SegmentTree(treeMap)
        tree.toString() shouldBe "SegmentTree(d->(1, e->(2, f->(3), b->(6))), e->(4, f->(5), d->(e->(b->(7)))))"
    }

    "We should be able to parse a word into its segments using a PhoneticParser" {
        val segments = listOf("ᵐb", "ⁿd", "ᵑg")
        val beforeDiacritics = listOf("ˈ")
        val afterDiacritics = listOf("ʼ", "ʰ")

        val parser = PhoneticParser(segments, beforeDiacritics, afterDiacritics)

        parser.parse("ⁿdapʰi") shouldBe StandardWord.fromSchematic("ⁿd/a/pʰ/i")
        shouldThrow<DanglingDiacritic> { parser.parse("ʰana") }
        shouldThrow<DanglingDiacritic> { parser.parse("anaˈ") }
    }
})