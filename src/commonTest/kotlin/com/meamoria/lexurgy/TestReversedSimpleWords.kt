package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestReversedSimpleWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic).reversed()

    "The \"string\" value of a reversed word should be the concatenation of its (reversed) segments" {
        word("b/a/n/a/n/a").string shouldBe "ananab"
        word("sch/ei/n").string shouldBe "neisch"
        word("p)ʰ/ou|́/ⁿ(t/ei|̀/t/o").string shouldBe "otèiⁿtóupʰ"
    }
})