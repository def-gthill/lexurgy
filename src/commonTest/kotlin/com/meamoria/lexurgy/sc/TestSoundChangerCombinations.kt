package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldBeInstanceOf
import com.meamoria.mpp.kotest.shouldThrow

// Testing every transformerToXXX method in the various Matchers
@Suppress("unused")
class TestSoundChangerCombinations : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "The parser should distribute sequences into adjacent alternative lists if the lengths match" {
        val ch = lsc(
            """
                two-to-one:
                    a {e, o} => {e e, o o}
                three-to-one:
                    {a, i} ɛ {i, a} => {ei * *, ia * *}
            """.trimIndent()
        )

        ch("baela") shouldBe "beela"
        ch("maomaeteo") shouldBe "moomeeteo"
        ch("kaɛitiɛa") shouldBe "keitia"
    }

    "But if the lengths don't match, report the mismatch at the top level" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("bad-sequence-in-alternative:\na {e, o} => {e e, o}")
        }.also {
            it.cause.shouldBeInstanceOf<LscInvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("a {e, o} => {e e, o}") of rule "bad-sequence-in-alternative"
                Found 2 elements ("a", "{e, o}") on the left side of the arrow but 1 element ("{(e e), o}") on the right side
            """.trimIndent()
        }

        shouldThrow<LscInvalidRuleExpression> {
            lsc("bad-alternative-in-sequence:\na {e, i, o} => {e e, o o}")
        }.also {
            it.cause.shouldBeInstanceOf<LscInvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("a {e, i, o} => {e e, o o}") of rule "bad-alternative-in-sequence"
                Found 2 elements ("a", "{e, i, o}") on the left side of the arrow but 1 element ("{(e e), (o o)}") on the right side
            """.trimIndent()
        }
    }
})