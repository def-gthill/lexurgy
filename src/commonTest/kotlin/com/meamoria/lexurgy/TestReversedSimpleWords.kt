package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestReversedSimpleWords : StringSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic).reversed()

    val banana = word("b/a/n/a/n/a")
    val shine = word("sch/ei/n")
    val potato = word("p)ʰ/ou|́/ⁿ(t/ei|̀/t/o")

    "The \"string\" value of a reversed word should be the concatenation of its (reversed) segments" {
        banana.string shouldBe "ananab"
        shine.string shouldBe "neisch"
        potato.string shouldBe "otèiⁿtóupʰ"
    }
})