package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldBeInstanceOf
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestPropagation : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "A propagating rule should be applied repeatedly until the word stabilizes" {
        val ch1 = lsc(
            """
                Feature Height(low, high)
                Feature Depth(front, back)
                Feature Rounding(unrnd, rnd)
                Feature Type(cons, vowel)
                Symbol a [vowel low back unrnd]
                Symbol e [vowel low front unrnd]
                Symbol o [vowel low back rnd]
                Symbol ø [vowel low front rnd]
                Symbol ɨ [vowel high back unrnd]
                Symbol i [vowel high front unrnd]
                Symbol u [vowel high back rnd]
                Symbol y [vowel high front rnd]
                harmony-forward [vowel] propagate:
                [] => [${'$'}Depth] / [${'$'}Depth] _
                harmony-backward propagate [vowel]:
                [] => [${'$'}Rounding] / _ [${'$'}Rounding]
            """.trimIndent()
        )

        ch1("enotahu") shouldBe "ønøtøhy"
        ch1("ypatoka") shouldBe "ipeteke"

        val ch2 = lsc(
            """
                bouncing propagate:
                a => e / b _
                e => a / _ d
            """.trimIndent()
        )

        val ex = shouldThrow<LscRuleNotApplicable> { ch2("bed") }
        ex.cause.shouldBeInstanceOf<LscDivergingPropagation>()
    }

    "We should be able to propagate parts of a sequential block" {
        val ch = lsc(
            """
                alternate:
                    a => b / _ c
                    Then propagate:
                        c => b / b c _
            """.trimIndent()
        )

        ch("aaaaaccccccccc") shouldBe "aaaabcbcbcbcbc"
    }

    "An ltr rule should sweep left to right" {
        val ch = lsc(
            """
                sweep ltr:
                    * => a / bb _ b
                    bab => d
            """.trimIndent()
        )

        ch("abbbbbbabababbbb") shouldBe "abbabbabdadbbab"
    }

    "An rtl rule should sweep right to left" {
        val ch = lsc(
            """
                sweep rtl:
                    bbb => babb
                    bab => d
            """.trimIndent()
        )

        ch("abbbbbbabababbbb") shouldBe "ababbabbdadbabb"
    }
})