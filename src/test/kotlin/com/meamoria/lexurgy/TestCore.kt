package com.meamoria.lexurgy

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import com.meamoria.lexurgy.SegmentTree

class TestCore : StringSpec({
    "We should be able to create a SegmentTree from a Map" {
        val treeMap = mapOf(
            "d" to 1,
            "de" to 2,
            "def" to 3,
            "e" to 4,
            "ef" to 5,
            "deb" to 6,
            "edeb" to 7
        )

        val tree = SegmentTree(treeMap)
        tree.toString() shouldBe "SegmentTree(d->(1, e->(2, f->(3), b->(6))), e->(4, f->(5), d->(e->(b->(7)))))"
    }
})