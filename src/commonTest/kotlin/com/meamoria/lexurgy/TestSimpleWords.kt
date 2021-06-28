package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestSimpleWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic)

    val banana = word("b/a/n/a/n/a")
    val shine = word("sch/ei/n")
    val potato = word("p)ʰ/ou|́/ⁿ(t/ei|̀/t/o")

    "The \"string\" value of a simple word should be the concatenation of its segments" {
        banana.string shouldBe "banana"
        shine.string shouldBe "schein"
        potato.string shouldBe "pʰóuⁿtèito"
    }
})