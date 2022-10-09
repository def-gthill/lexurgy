package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.normalizeCompose
import com.meamoria.lexurgy.sc.parser.LscInteriorWordBoundary
import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldBeInstanceOf
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestBoundaries : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to mark the word boundary with a $" {
        val ch1 = lsc(
            """
               |boundary-h-drop:
               |    h => * / $ _
               |    h => * / _ $
            """.trimMargin()
        )

        ch1("hahahahah") shouldBe "ahahaha"

        val ch2 = lsc(
            """
               |overly-specific:
               |    a => e / $ b _ t $
            """.trimMargin()
        )

        ch2("bat") shouldBe "bet"
        ch2("abat") shouldBe "abat"
        ch2("bata") shouldBe "bata"
        ch2("cat") shouldBe "cat"
    }

    "Boundaries shouldn't be allowed in the output" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("bad:\na => $")
        }.also {
            it.message shouldBe """
                Error in expression 1 ("a => $") of rule "bad"
                A word boundary like "$" can't be used in the output of a rule
            """.trimIndent()
        }
        shouldThrow<LscInvalidRuleExpression> {
            lsc("bad-alternative:\n{p, t, k} => {b, d, $}")
        }.also {
            it.message shouldBe """
                Error in expression 1 ("{p, t, k} => {b, d, $}") of rule "bad-alternative"
                A word boundary like "$" can't be used in the output of a rule
            """.trimIndent()
        }
    }

    "Word boundaries should work inside alternative lists" {
        val ch = lsc(
            """
                Class cons {p, t, k, s, m, n, l}
                nasalization:
                    {an, en, on} => {ã, ẽ, õ} / _ {$, @cons}
            """.trimIndent()
        )

        ch("pant") shouldBe "pãt".normalizeCompose()
        ch("sen") shouldBe "sẽ".normalizeCompose()
        ch("senon") shouldBe "senõ".normalizeCompose()
        ch("senont") shouldBe "senõt".normalizeCompose()
        ch("senonet") shouldBe "senonet"

        val ch2 = lsc(
            """
                Feature Type(cons, vowel)
                Symbol t [cons]
                Symbol a [vowel]
                crazy:
                    a => e / {[cons] [vowel], $ [cons]} [vowel] [cons] _
            """.trimIndent()
        )

        ch2("tata") shouldBe "tate"
        ch2("ataatata") shouldBe "ataateta"
    }

    "Misplaced word boundaries should result in an LscInteriorWordBoundary" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\no => a / _ $ o")
        }.also {
            it.cause.shouldBeInstanceOf<LscInteriorWordBoundary>()
            it.message shouldBe """
                Error in expression 1 ("o => a / _ $ o") of rule "foo"
                A word boundary in "$ o" in the environment "_ $ o" needs to be at the beginning or end
            """.trimIndent()
        }
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\no => a / $ e _ {a, i {$ o, o $}, e $}")
        }.also {
            it.cause.shouldBeInstanceOf<LscInteriorWordBoundary>()
            it.message shouldBe """
                Error in expression 1 ("o => a / $ e _ {a, i {$ o, o $}, e $}") of rule "foo"
                A word boundary in "$ o" in the environment "$ e _ {a, i {$ o, o $}, e $}" needs to be at the beginning or end
            """.trimIndent()
        }
    }

    "Word boundaries on the input side should result in an LscIllegalStructureInInput" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\n$ => x")
        }.also {
            it.cause.shouldBeInstanceOf<LscIllegalStructureInInput>()
            it.message shouldBe """
                Error in expression 1 ("$ => x") of rule "foo"
                A word boundary like "$" can't be used in the input of a rule
            """.trimIndent()
        }
    }
})