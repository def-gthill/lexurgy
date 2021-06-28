package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestSyllabifiedWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic)

    "The \"string\" value of a syllabified word should include syllable markup" {
        word("b/a//n/a//n/a").string shouldBe "ba.na.na"
        word("e/k//s/e//ˈ((l/e/n//t/e").string shouldBe "ek.se.ˈlen.te"
        word("sc/ei/n||ʰ))`").string shouldBe "sʰcein`"
    }
})