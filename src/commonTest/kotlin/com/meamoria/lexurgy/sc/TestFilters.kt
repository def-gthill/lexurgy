package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.*

@Suppress("unused")
class TestFilters : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "A rule with a filter only operates on sounds that pass the filter" {
        val ch = lsc(
            """
                Feature Height(low, high)
                Feature Depth(front, back)
                Symbol a [low back]
                Symbol e [low front]
                Symbol o [high back]
                Symbol i [high front]
                harmony [front]:
                [] => [${'$'}Height] / [${'$'}Height] _
                echo-deletion [back]:
                [${'$'}Height] [${'$'}Height] => [front] *
                fancy-breaking [high]:
                i => ai / o _
            """.trimIndent()
        )

        ch("enni") shouldBe "enne"
        ch("onna") shouldBe "onna"
        ch("ibstveki") shouldBe "ibstvike"

        ch("onno") shouldBe "inn"
        ch("onni") shouldBe "onnai"
    }

    "A rule with a filter can't have empty elements on the match side" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("Feature bad(vowel, low, high)\nharmony [vowel]:\n[low] * => [high] a")
        }.also {
            it.cause.shouldBeInstanceOf<LscIllegalStructureInFilteredRuleInput>()
            it.message shouldBe """
                Error in expression 1 ("[low] * => [high] a") of rule "harmony"
                An empty element like "*" can't be used on the match side of filtered rules
            """.trimIndent()
        }
    }

    "A rule with a filter can't have empty elements on the match side even if it's conditional" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("Feature bad(vowel, low, high)\nharmony [vowel]:\n* => a / [low] _")
        }
    }

    "A rule with a filter can't have multi-segment elements on the match side" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("Feature bad(vowel, low, high)\nharmony [vowel]:\n[low] ai => [high] a")
        }.also {
            it.cause.shouldBeInstanceOf<LscIllegalStructureInFilteredRuleInput>()
            it.message shouldBe """
                Error in expression 1 ("[low] ai => [high] a") of rule "harmony"
                A multi-segment element like "ai" can't be used on the match side of filtered rules
            """.trimIndent()
        }
        shouldNotThrowAny {
            lsc("Feature bad(vowel, low, high)\nSymbol ai\nharmony [vowel]:\n[low] ai => [high] a")
        }
    }

    "Negated features should be usable in filters" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, mid, high)
                Feature Depth(front, back)
                Symbol æ [low front vowel]
                Symbol e [mid front vowel]
                Symbol i [high front vowel]
                Symbol ɑ [low back vowel]
                Symbol o [mid back vowel]
                Symbol u [high back vowel]
                harmony [vowel !low]:
                    [] => [${'$'}Depth] / [${'$'}Depth] _
            """.trimIndent()
        )

        ch("pinoki") shouldBe "pineku"
        ch("pinɑku") shouldBe "pinɑki"
    }

    "Classes should be usable as filters" {
        val ch = lsc(
            """
                Class low {a, e}
                Class high {o, i}
                Class front {e, i}
                Class back {a, o}
                harmony @front:
                    @high => @low / @low _
                    @low => @high / @high _
            """.trimIndent()
        )

        ch("enni") shouldBe "enne"
        ch("onna") shouldBe "onna"
        ch("ibstveki") shouldBe "ibstvike"
    }

    "Overlapping rules in a filter rule should be resolved in precedence order" {
        val ch = lsc(
            """
                Feature Type(vowel)
                Feature Height(low, mid, high)
                Symbol a [vowel low]
                Symbol e [vowel mid]
                Symbol i [vowel high]
                levelling [vowel]:
                a i => e e
                i a => e e
            """.trimIndent()
        )

        ch("hapi") shouldBe "hepe"
        ch("hapipa") shouldBe "hepepa"
        ch("hipapi") shouldBe "hipepe"
    }

    "Expressions that error out in a filtered rule are ignored if an earlier expression takes precedence" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                bad-second-rule @vowel:
                    a => e
                    a => $1
            """.trimIndent()
        )

        ch("banana") shouldBe "benene"
    }
})