package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestReversedSyllabifiedWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic).reversed()

    val banana = word("b/a//n/a//n/a")
    val excellent = word("e/k//s/e//ˈ((l/e/n//t/e")
    val shine = word("sc/ei/n||ʰ))`")

    "The \"string\" value of a reversed syllabified word should show correctly reversed syllable markup" {
        banana.string shouldBe "an.an.ab"
        excellent.string shouldBe "et.ˈnel.es.ke"
        shine.string shouldBe "nʰeisc`"
    }
})