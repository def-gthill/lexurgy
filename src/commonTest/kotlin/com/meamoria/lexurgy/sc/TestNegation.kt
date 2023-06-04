package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.element.MultipleSegmentNegation
import com.meamoria.lexurgy.sc.parser.LscInteriorWordBoundary
import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldBeInstanceOf
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestNegation : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    fun shouldReportInvalidNegation(block: () -> Any?) {
        shouldThrow<LscRuleNotApplicable>(block).also {
            it.reason.shouldBeInstanceOf<MultipleSegmentNegation>()
        }
    }

    "Single-segment plain text can be negated" {
        val ch = lsc(
            """
                i-before-e:
                    i => * / $ !c _ e
            """.trimIndent()
        )

        ch("cietu") shouldBe "cietu"
        ch("vietu") shouldBe "vetu"
    }

    "Multi-segment plain text CANNOT be negated" {
        val ch = lsc(
            """
                picky-exception:
                    !ab => xx
            """.trimIndent()
        )
        shouldReportInvalidNegation {
            ch("acac")
        }
    }

    "Exact symbols can be negated" {
        val ch = lsc(
            """
                Feature +foo
                Diacritic ́  (floating) [+foo]
                not-exact:
                    !a! => x
            """.trimIndent()
        )

        ch("fáa") shouldBe "xxa"
    }

    "Classes can be negated" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class vowel {a, e, i, o, u}
                final-vowel-loss:
                    @vowel => * / [] !@stop _ $
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
        val ch = lsc(
            """
                Feature foo, bar, baz
                Symbol a [+foo +bar +baz]
                Symbol b [+foo +bar -baz]
                Symbol c [+foo -bar +baz]
                Symbol d [-foo -bar -baz]
                
                not-exact-combination:
                    ![+foo +bar] => x
            """.trimIndent()
        )

        ch("abcd") shouldBe "abxx"
    }

    "Word boundaries can be negated" {
        val ch = lsc(
            """
                not-at-boundary:
                    t => d / !$ _ !$
            """.trimIndent()
        )

        ch("tatat") shouldBe "tadat"
    }

    "Negated word boundaries are invalid in the rule input, just like regular word boundaries" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc(
                """
                    nonsense:
                        !$ => x
                """.trimIndent()
            )
        }.also {
            it.cause.shouldBeInstanceOf<LscIllegalStructureInInput>()
        }
    }

    "Negated word boundaries are invalid away from the periphery, just like regular word boundaries" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc(
                """
                    nonsense:
                        x => z / _ !$ a
                """.trimIndent()
            )
        }.also {
            it.cause.shouldBeInstanceOf<LscInteriorWordBoundary>()
        }
    }

    "Between words symbols CANNOT be negated" {
        val ch = lsc(
            """
                not-between-words:
                    !$$ => x
            """.trimIndent()
        )

        shouldReportInvalidNegation {
            ch("foo bar")
        }
    }

    "Syllable boundaries can be negated, and consume no segments" {
        val ch = lsc(
            """
                Syllables:
                    explicit
                not-across-syllable-boundary:
                    a !. b => x
            """.trimIndent()
        )

        ch("caba") shouldBe "cxa"
        ch("ca.ba") shouldBe "ca.ba"
        ch("carba") shouldBe "carba"
    }

    "Sequences CANNOT be negated" {
        val ch = lsc(
            """
                Class foo {f, o}
                Class bar {b, a, r}
                not-sequence:
                    !(@foo @bar) => x
            """.trimIndent()
        )

        shouldReportInvalidNegation {
            ch("faba")
        }
    }

    "Repeaters CANNOT be negated" {
        val ch = lsc(
            """
                not-repeater:
                    !(a+) => x
            """.trimIndent()
        )

        shouldReportInvalidNegation {
            ch("aaaaa")
        }
    }

    "Alternative lists where every alternative is a single segment can be negated" {
        val ch = lsc(
            """
                Class foo {f, o}
                Class bar {b, a, r}
                not-alternative:
                    !{@foo, @bar} => x
            """.trimIndent()
        )

        ch("frogbat") shouldBe "froxbax"
    }

    "Alternative lists with a multi-segment alternative CANNOT be negated" {
        val ch = lsc(
            """
                Class foo {f, oo}
                Class bar {b, a, r}
                not-alternative:
                    !{@foo, @bar} => x
            """.trimIndent()
        )

        shouldReportInvalidNegation {
            ch("frogbat")
        }
    }

    "Reusable elements can be negated if the expression they reference can be" {
        val ch = lsc(
            """
                Class foo {f, o}
                Class bar {b, a, r}
                Element foobar {@foo, @bar}
                not-alternative:
                    !@foobar => x
            """.trimIndent()
        )

        ch("frogbat") shouldBe "froxbax"
    }

    "Reusable elements CANNOT be negated if the expression they reference can't be" {
        val ch = lsc(
            """
                Class foo {f, oo}
                Class bar {b, a, r}
                Element foobar {@foo, @bar}
                not-alternative:
                    !@foobar => x
            """.trimIndent()
        )

        shouldReportInvalidNegation {
            ch("frogbat")
        }
    }

    "Intersections can be negated if the first matcher can be" {
        val ch = lsc(
            """
                not-intersection:
                    !({a, b, c}&[]*) => x
            """.trimIndent()
        )

        ch("caboose") shouldBe "cabxxxx"
    }

    "Intersections CANNOT be negated if the first matcher can't be" {
        val ch = lsc(
            """
                not-intersection:
                    !({ca, b}&[]*) => x
            """.trimIndent()
        )

        shouldReportInvalidNegation {
            ch("caboose")
        }
    }

    "Environment elements can be negated if the core can be" {
        val ch = lsc(
            """
                not-environment:
                    !(a / _ b) => x
            """.trimIndent()
        )

        ch("abacus") shouldBe "axxxxx"
    }

    "Environment elements CANNOT be negated if the core can't be" {
        val ch = lsc(
            """
                not-environment:
                    !(ab / _ a) => x
            """.trimIndent()
        )

        shouldReportInvalidNegation {
            ch("abacus")
        }
    }

    "References to captures of single segments can be negated" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                not-the-same:
                    {i, u}$1 => {j, w} / _ !$1&@vowel {t, $}
            """.trimIndent()
        )

        ch("ciitua") shouldBe "ciitwa"
        ch("vietuu") shouldBe "vjetuu"
    }

    "Inexact references to captures of single segments can be negated" {
        val ch = lsc(
            """
                Feature +hightone
                Diacritic ́  (floating) [+hightone]
                Class vowel {a, e, i, o, u}
                
                not-the-same:
                    {i, u}$1 => {j, w} / _ !~$1&@vowel {t, $}
            """.trimIndent()
        )

        ch("ciítuá") shouldBe "ciítwá"
        ch("viétuu") shouldBe "vjétuu"
    }

    "References to captures that might have multiple segments CANNOT be negated" {
        val ch = lsc(
            """
                not-capture:
                    {a, bc}$1 => x / d !$1 _
            """.trimIndent()
        )

        shouldReportInvalidNegation {
            ch("dbca")
        }
    }

    "Arbitrary elements can be negated on the periphery of an environment" {
        val ch = lsc(
            """
                use-negation-as-lookaround:
                    x => z / !ab _ !ab
            """.trimIndent()
        )

        ch("abxxxabxab") shouldBe "abxzxabxab"
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

    "Negated elements with length one consume one segment even on the periphery" {
        val ch = lsc(
            """
                Feature place (alveolar, velar)
                Feature manner (stop)
                Feature voiced
                
                Symbol t [-voiced alveolar stop]
                Symbol d [+voiced alveolar stop]
                Symbol k [-voiced velar stop]
                Symbol g [+voiced velar stop]
                Element consonant ![*place]
                
                voicing-assimilation:
                 [stop] => [${'$'}voiced] / _ @consonant&[${'$'}voiced]
            """.trimIndent()
        )

        ch("agta") shouldBe "akta"
    }
})