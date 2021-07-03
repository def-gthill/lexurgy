package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.*

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

        val ch2 = lsc(
            """
                Class consonant {b, d, g}
                silly:
                    o => a / @consonant ab @consonant* _
            """.trimIndent()
        )

        ch2("babgdo") shouldBe "babgda"
        ch2("ibabogago") shouldBe "ibabagago"

        // Don't refuse to consume zero-length matches
        val ch3 = lsc(
            """
                Class glide {w, j}
                Class consonant {p, t, k, f, s, m, n, l}
                Class vowel {a, e, i, o, u, ø, y}
                
                umlaut:
                    {a, e, o, u} => {e, i, ø, y} / _ @glide? @consonant* j
            """.trimIndent()
        )

        ch3("awtja") shouldBe "ewtja"
    }

    "Repeaters should backtrack if the rest of the rule can't match" {
        val ch = lsc(
            """
                backtrack-optional:
                    b => c / _ a? a d
                backtrack-repeater:
                    f => g / _ e+ e h
            """.trimIndent()
        )

        ch("bad") shouldBe "cad"
        ch("baad") shouldBe "caad"
        ch("baaad") shouldBe "baaad"
        ch("feh") shouldBe "feh"
        ch("feeh") shouldBe "geeh"
        ch("feeeeeh") shouldBe "geeeeeh"
        ch("fh") shouldBe "fh"
    }

    "Backtracking should work between the input and after environment" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                messy-glomination:
                    @vowel? $$ @vowel? => * / _ @vowel
            """.trimIndent()
        )

        ch("ek ana eta iona") shouldBe "ekanetona"
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