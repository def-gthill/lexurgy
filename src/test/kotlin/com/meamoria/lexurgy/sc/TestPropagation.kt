package com.meamoria.lexurgy.sc

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

@Suppress("unused")
class TestPropagation : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "A propagating rule is applied repeatedly until the word stabilizes" {
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
    }

    "If a propagating rule is going in circles, it errors out" {
        val ch = lsc(
            """
                bouncing propagate:
                a => e / b _
                e => a / _ d
            """.trimIndent()
        )

        val ex = shouldThrow<LscRuleNotApplicable> { ch("bed") }
        ex.cause.shouldBeInstanceOf<LscDivergingPropagation>()
    }

    "A propagating rule can run a large number of iterations if they're fast enough" {
        val ch = lsc(
            """
                count-binary propagate:
                    \0 => \1 / _ ${'$'}
                    \1 => '\0 / _ ${'$'}
                    Then propagate:
                    \0' => \1
                    \1' => '\0
                    ' => \1 / ${'$'} _
                    Then:
                    \10000000000 => madeit
            """.trimIndent()
        )

        ch("1") shouldBe "madeit"
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

    "We should be able to use ltr and rtl on innermost blocks" {
        val ch = lsc(
            """
                sweep:
                    x => b
                    Then ltr:
                        * => a / bb _ b
                        bab => d
                    Then:
                        d => x
            """.trimIndent()
        )

        ch("axxxxxxaxaxaxxxx") shouldBe "abbabbabxaxbbab"

        val ch2 = lsc(
            """
                sweep:
                    x => b
                    Then rtl:
                        bbb => babb
                        bab => d
                    Then:
                        d => x
            """.trimIndent()
        )

        ch2("axxxxxxaxaxaxxxx") shouldBe "ababbabbxaxbabb"
    }

    "Blocks marked with ltr or rtl with other blocks inside them should trigger an LscIllegalNestedModifier" {
        shouldThrow<LscIllegalNestedModifier> {
            lsc(
                """
                    bad-sweep ltr:
                        a => b
                        Then:
                        b => c
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "Blocks with the \"ltr\" modifier can't have other blocks inside them"
        }
    }

    "An ltr rule can have a filter" {
        val ch = lsc(
            """
                Feature type(consonant, vowel)
                Feature (syllable) stress(*unstressed, stress)
                
                Symbol C [consonant]
                Symbol V [vowel]
                
                Diacritic ˈ (before) (floating) [stress]
                
                Syllables:
                  C? V C? C?
                
                rule-one [vowel]:
                  [] => [stress] / $ _
                
                rule-two ltr [vowel]:
                  [unstressed] => [stress] / [stress] [] _
            """.trimIndent()
        )

        ch("CVCCVCVV") shouldBe "ˈCVC.CV.ˈCV.V"
    }

    "An ltr rule ignores expressions that error out if earlier expressions take precedence" {
        val ch = lsc(
            """
                bad-second-rule ltr:
                    a => e
                    a => $1
            """.trimIndent()
        )

        ch("banana") shouldBe "benene"
    }

    "We should get a nice error message when we misspell a modifier" {
        shouldThrow<LscInvalidModifier> {
            lsc(
                """
                    rule propogate:
                        a => b
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "Invalid modifier \"propogate\" applied to \"rule\""
        }
    }
})