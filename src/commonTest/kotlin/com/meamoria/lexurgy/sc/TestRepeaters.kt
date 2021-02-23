package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldBeInstanceOf
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestRepeaters : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to match repeated segments" {
        val ch = lsc(
            """
                umlaut:
                {a, e, u} => {e, i, y} / _ {m, n}+ i {m, n}* $
            """.trimIndent()
        )

        ch("anni") shouldBe "enni"
        ch("uim") shouldBe "uim"
        ch("unim") shouldBe "ynim"
        ch("enmnenmni") shouldBe "enmninmni"
    }

    "Repeaters should refuse to consume things that match the next element in sequence" {
        val ch = lsc(
            """
                Class glide {w, j}
                Class consonant {p, t, k, f, s, m, n, l, @glide}
                Class vowel {a, e, i, o, u, ø, y}
                
                umlaut:
                    {a, e, o, u} => {e, i, ø, y} / _ @consonant* j
            """.trimIndent()
        )

        ch("altja") shouldBe "eltja"
        ch("otja") shouldBe "øtja"
    }

    "We should be able to change repeaters into things" {
        val ch = lsc(
            """
                Feature Height(low, high)
                Symbol a [low]
                Symbol i [high]
                any-number-of-i-to-j:
                    i+ => j / k _ a
                any-number-of-a-all-high:
                    a+ => [high] / t _
                s-palatal-and-swallow-c:
                    s c? => ʃ * / _ i
            """.trimIndent()
        )

        ch("kiiia") shouldBe "kja"
        ch("taaaaba") shouldBe "tiiiiba"
        ch("sciensia") shouldBe "ʃienʃia"
    }

    "But we shouldn't be able to put repeaters on the output side" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\no => a+ / _ a")
        }.also {
            it.cause.shouldBeInstanceOf<LscIllegalStructureInOutput>()
            it.message shouldBe """
                Error in expression 1 ("o => a+ / _ a") of rule "foo"
                A repeater like "a+" can't be used in the output of a rule
            """.trimIndent()
        }
    }

    "Repeated segments on the edge of a rule should result in an LscPeripheralRepeater" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\no => a / _ a*")
        }.also {
            it.cause.shouldBeInstanceOf<LscPeripheralRepeater>()
            it.message shouldBe """
                Error in expression 1 ("o => a / _ a*") of rule "foo"
                The repeater "a*" in the environment "_ a*" is meaningless because it's at the edge of the environment; remove it
            """.trimIndent()
        }
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\no => a / f+ _")
        }.also {
            it.cause.shouldBeInstanceOf<LscPeripheralRepeater>()
            it.message shouldBe """
                Error in expression 1 ("o => a / f+ _") of rule "foo"
                The repeater "f+" in the environment "f+ _" is meaningless because it's at the edge of the environment; just use "f"
            """.trimIndent()
        }
    }
})