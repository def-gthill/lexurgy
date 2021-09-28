package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.fail
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestAlternatives : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to write compact changes with alternative lists" {
        val ch = lsc(
            """
                vowel-shift:
                {o, u} => {u, y}
                {i, e} => {e, a} / _ {m, n}
            """.trimIndent()
        )

        ch("botu") shouldBe "buty"
        ch("tintin") shouldBe "tenten"
        ch("tenpin") shouldBe "tanpen"
        ch("mitochondrion") shouldBe "mituchundriun"
    }

    "We should be able to define reusable alternative lists as sound classes" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class unvcdstop {p, t, k}
                Class vcdstop {b, d, g}
                intervocalic-lenition:
                @unvcdstop => @vcdstop / @vowel _ @vowel
            """.trimIndent()
        )

        ch("apetiko") shouldBe "abedigo"
        ch("aptiko") shouldBe "aptigo"
    }

    "Duplicate class declarations should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Class foo {a, b, c}
                    Class foo {d, e, f}
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The class \"foo\" is defined more than once"
        }
    }

    "We should be able to use previous class definitions in classes" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class fricative {f, s}
                Class obstruent {@stop, @fricative}
                drop-final-obstruent:
                    @obstruent => * / _ $
            """.trimIndent()
        )

        ch("ararat") shouldBe "arara"
        ch("ananas") shouldBe "anana"
        ch("bananal") shouldBe "bananal"
    }

    "One-element alternative lists should act like the element itself" {
        val ch = lsc(
            """
                Symbol aː, eː, iː, oː, uː

                Class shortvowel {a, e, i, o, u}
                Class longvowel {aː, eː, iː, oː, uː}
                
                imbalanced:
                 {@shortvowel, @longvowel} => {@shortvowel}
            """.trimIndent()
        )

        ch("foː") shouldBe "fo"
    }

    "Alternative lists should backtrack if the rest of the rule can't match" {
        val ch = lsc(
            """
                overlapping-alts:
                 d => f / _ {a, ab} n
            """.trimIndent()
        )

        ch("cadabn") shouldBe "cafabn"
        ch("cadan") shouldBe "cafan"
    }

    "Only captures in a successful match should be bound" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l}
                capture-from-alt:
                {@cons$1 a, @vowel$1 n} => n $1
            """.trimIndent()
        )

        ch("pataki") shouldBe "npntki"
        ch("anana") shouldBe "nanaa"
    }
})