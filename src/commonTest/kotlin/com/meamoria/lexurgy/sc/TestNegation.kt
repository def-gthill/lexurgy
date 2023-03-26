package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestNegation : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    // In general, negation is allowed:
    // - if the thing being negated has a definite length (in which case
    //   the negated element consumes that many segments)
    // - OR if the negation is on the periphery of a condition (in which case
    //   it just acts as negative lookahead/lookbehind)
    // - OR if the negation appears after an & (because the element before the &
    //   provides a definite length)

    "Single-segment plain text can be negated" {
        val ch = lsc(
            """
                i-before-e:
                    i => * / !c _ e
            """.trimIndent()
        )

        ch("cietu") shouldBe "cietu"
        ch("vietu") shouldBe "vetu"
    }

    "Multi-segment plain text can be negated, and consumes the same number of segments" {
        val ch = lsc(
            """
                picky-exception:
                    !ab => xx
            """.trimIndent()
        )

        ch("acac") shouldBe "xxxx"
        ch("ebeb") shouldBe "xxxx"
        ch("acababa") shouldBe "xxaxxxx"
    }

    "Exact symbols can be negated" {
        // TODO
    }

    "Classes can be negated" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class vowel {a, e, i, o, u}
                final-vowel-loss:
                    @vowel => * / !@stop _ $
            """.trimIndent()
        )

        ch("buka") shouldBe "buka"
        ch("suna") shouldBe "sun"
        ch("puraa") shouldBe "pura"
    }

    "Feature matrices can be negated" {
        // Because ![foo bar baz] and [!foo !bar !baz] mean totally different
        // things --- the former means it can't have that *exact combination*
        // of features, while the latter means it can't have *any* of the features.
        // TODO
    }

    "Word boundaries can be negated" {
        // TODO
    }

    "Negated word boundaries are invalid in the rule input, just like regular word boundaries" {
        // TODO
    }

    "Negated word boundaries are invalid away from the periphery, just like regular word boundaries" {
        // TODO
    }

    "Between words symbols CANNOT be negated" {
        // Even though the between-words matcher has a definite length of 0,
        // negating it doesn't make sense, since adjacency doesn't cross word
        // boundaries by default anyway.
        // TODO
    }

    "Syllable boundaries can be negated, and consume no segments" {
        // TODO
    }

    "Sequences with a definite length can be negated" {
        // TODO
    }

    "Sequences with a variable length CANNOT be negated" {
        // TODO
    }

    "Repeaters CANNOT be negated" {
        // TODO
    }

    "Alternative lists with a definite length can be negated" {
        // TODO
    }

    "Alternative lists with a variable length CANNOT be negated" {
        // TODO
    }

    "Intersections can be negated if the first matcher can be" {
        // TODO
    }

    "Intersections CANNOT be negated if the first matcher can't be" {
        // TODO
    }

    "Environment elements can be negated if the core can be" {
        // TODO
    }

    "Environment elements CANNOT be negated if the core can't be" {
        // TODO
    }

    "References to captures of single segments can be negated" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                not-the-same:
                    {i, u}$1 => {j, w} / _ !$1&@vowel
            """.trimIndent()
        )

        ch("ciitua") shouldBe "ciitwa"
        ch("vietuu") shouldBe "vjetuu"
    }

    "Inexact capture references can be negated" {
        // TODO
    }

    "References to captures of arbitrary elements can be negated" {
        // TODO
    }

    "Arbitrary elements can be negated on the periphery of an environment" {
        // TODO
    }

    "Arbitrary elements can be negated as the second part of an intersection" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class cons {@stop, s, m, n, l, r}
                
                cluster-reduction:
                    (@cons+ @cons$1)&!(s? @stop {l, r}?) => * $1
            """.trimIndent()
        )

        ch("ptar") shouldBe "tar"
        ch("smakla") shouldBe "makla"
        ch("sprakti") shouldBe "sprati"
    }
})