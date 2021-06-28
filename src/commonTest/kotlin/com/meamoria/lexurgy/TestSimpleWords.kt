package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestSimpleWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic)

    "The \"string\" value of a simple word should be the concatenation of its segments" {
        word("b/a/n/a/n/a").string shouldBe "banana"
        word("sch/ei/n").string shouldBe "schein"
        word("p)ʰ/ou|́/ⁿ(t/ei|̀/t/o").string shouldBe "pʰóuⁿtèito"
    }
})