package com.meamoria.lexurgy

import com.meamoria.lexurgy.word.*
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestCore : StringSpec({
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
        val segments = listOf("ᵐb", "ⁿd", "ᵑg", "ou")
        val diacritics = listOf(
            Modifier("ˈ", ModifierPosition.BEFORE),
            Modifier("́", ModifierPosition.FIRST),
            Modifier("ʼ", ModifierPosition.AFTER),
            Modifier("ʰ", ModifierPosition.AFTER),
        )

        val parser = PhoneticParser(
            segments,
            modifiers = diacritics,
        )

        parser.parse("ⁿdapʰi") shouldBe StandardWord.fromSchematic("ⁿd/a/p)ʰ/i")
        parser.parse("tʼˈóula") shouldBe StandardWord.fromSchematic("t)ʼ/ˈ(ou|́/l/a")
        shouldThrow<DanglingDiacritic> { parser.parse("ʰana") }
        shouldThrow<DanglingDiacritic> { parser.parse("anaˈ") }
    }

    "We should be able to parse a word with syllable-level diacritics using a PhoneticParser" {
        val segments = listOf("nʲ")
        val diacritics = listOf(
            Modifier("ⁿ", ModifierPosition.BEFORE),
            Modifier("̥", ModifierPosition.FIRST),
            Modifier("ʼ", ModifierPosition.AFTER),
        )
        val syllableDiacritics = listOf(
            Modifier("ˈ", ModifierPosition.BEFORE),
            Modifier("ʰ", ModifierPosition.FIRST),
            Modifier("ˠ", ModifierPosition.AFTER),
        )
        val parser = PhoneticParser(
            segments,
            diacritics,
            syllableSeparator = ".",
            syllableModifiers = syllableDiacritics,
        )

        parser.parse("ⁿda.pʰi") shouldBe StandardWord.fromSchematic("ⁿ(d/a//p/i||ʰ")
        parser.parse("ˈtʼou.n̥ʲaˠ") shouldBe StandardWord.fromSchematic("ˈ((t)ʼ/o/u//nʲ|̥/a))ˠ")
        shouldThrow<DanglingDiacritic> { parser.parse("aˈn") }
        shouldThrow<DanglingDiacritic> { parser.parse("ʰan") }
        shouldThrow<DanglingDiacritic> { parser.parse("aˠn") }
    }
})