package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestRules : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We can declare a simple character-to-character change rule" {
        val ch = lsc(
            """
                a-rule:
                x=>h
            """.trimIndent()
        )

        ch("maxel") shouldBe "mahel"
        ch("expexax") shouldBe "ehpehah"
    }

    "We can declare multiple rules in a file, executed sequentially" {
        val ch = lsc(
            """
                rule-one:
                a=>b
                rule-two:
                b=>c
            """.trimIndent()
        )

        ch("ababad") shouldBe "cccccd"
    }

    "We can declare compound rules that execute simultaneously" {
        val ch = lsc(
            """
                chain:
                    p => f
                    f => h
                    h => *
            """.trimIndent()
        )

        ch("mapel") shouldBe "mafel"
        ch("fanoham") shouldBe "hanoam"
        ch("pehgept") shouldBe "fegeft"
    }

    "Overlapping rules are resolved in precedence order" {
        val ch1 = lsc(
            """
                decluster: 
                    kn => n
                    sk => k
            """.trimIndent()
        )

        ch1("skem") shouldBe "kem"
        ch1("knum") shouldBe "num"
        ch1("sknit") shouldBe "snit"
    }

    "Rules whose matches contain each other are resolved in precedence order" {
        val ch2 = lsc(
            """
                repetitious:
                    aaab => q
                    aaa => z
                    aa => x
            """.trimIndent()
        )

        ch2("baaabaaa") shouldBe "bqz"
        ch2("baaacaaa") shouldBe "bzcz"
        ch2("baaaacaa") shouldBe "bzacx"
        ch2("baaaaaaabaaaaa") shouldBe "bzaqzx"
    }

    "Overlapping sequence rules are resolved in precedence order" {
        val ch1 = lsc(
            """
                decluster: 
                    k n => * n
                    s k => * k
            """.trimIndent()
        )

        ch1("skem") shouldBe "kem"
        ch1("knum") shouldBe "num"
        ch1("sknit") shouldBe "snit"

        val ch2 = lsc(
            """
                repetitious:
                    aa a b => * q *
                    a aa => z *
                    a a => * x
            """.trimIndent()
        )

        ch2("baaabaaa") shouldBe "bqz"
        ch2("baaacaaa") shouldBe "bzcz"
        ch2("baaaacaa") shouldBe "bzacx"
        ch2("baaaaaaabaaaaa") shouldBe "bzaqzx"
    }

    "Expressions that error out are ignored if an earlier expression takes precedence" {
        val ch = lsc(
            """
                bad-second-rule:
                    a => e
                    a => $1
            """.trimIndent()
        )

        ch("banana") shouldBe "benene"
    }

    "The special rule 'unchanged' does nothing" {
        val ch = lsc(
            """
                Deromanizer:
                    unchanged
                    Then:
                    ch => tʃ
                nothing:
                    unchanged
                nothing-and-something:
                    unchanged
                    tʃ => ʃ
                Romanizer-phonetic:
                    unchanged
                something:
                    a => æ
                Romanizer:
                    ʃ => sh
                    æ => ä
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("chachi", "vanechak")) shouldBe mapOf(
            "phonetic" to listOf("ʃaʃi", "vaneʃak"),
            null to listOf("shäshi", "väneshäk"),
        )
    }
})
