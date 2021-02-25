package com.meamoria.lexurgy

import com.meamoria.mpp.kotest.StringSpec
import io.kotest.matchers.shouldBe

class TestUtils : StringSpec ({
    "The XRegExp class should be correctly bound" {
        "foo".combiningCount() shouldBe 0
        "ba̟r".combiningCount() shouldBe 1
    }
})