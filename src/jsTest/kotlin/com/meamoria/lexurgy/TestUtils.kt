package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestUtils : StringSpec ({
    "Combining diacritic detection should work in the JS version" {
        "foo".combiningCount() shouldBe 0
        "ba̟r".combiningCount() shouldBe 1
        "báa͡aa̪a̠z".combiningCount() shouldBe 4
    }
})