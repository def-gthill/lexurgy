package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestReversedSyllabifiedWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic).reversed()

    "The \"string\" value of a reversed syllabified word should show correctly reversed syllable markup" {
        word("b/a//n/a//n/a").string shouldBe "an.an.ab"
        word("e/k//s/e//ˈ((l/e/n//t/e").string shouldBe "et.ˈnel.es.ke"
        word("sc/ei/n||ʰ))`").string shouldBe "nʰeisc`"
    }
})