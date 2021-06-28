package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestSyllabifiedWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic)

    val banana = word("b/a//n/a//n/a")
    val excellent = word("e/k//s/e//ˈ((l/e/n//t/e")
    val shine = word("sc/ei/n||ʰ))`")

    "The \"string\" value of a syllabified word should include syllable markup" {
        banana.string shouldBe "ba.na.na"
        excellent.string shouldBe "ek.se.ˈlen.te"
        shine.string shouldBe "sʰcein`"
    }
})