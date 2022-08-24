package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.DanglingDiacritic
import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldBeInstanceOf
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestRomanization : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "A deromanizer should convert plain words to phonetic, and a romanizer should do the opposite" {
        val ch = lsc(
            """
                Feature Type(cons, vowel)
                Feature Depth(front, central, back)
                Symbol a [vowel central]
                Symbol i [vowel front]
                Symbol u [vowel back]
                Deromanizer:
                sh => ʃ
                sh-loss:
                ʃ => s
                Romanizer:
                k => qu / _ [front]
                k => c
                f => v / [vowel] _ [vowel]
            """.trimIndent()
        )

        ch("shaki") shouldBe "saqui"
        ch("kafash") shouldBe "cavas"
    }

    "It's invalid to have more than one deromanizer" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    deromanizer:
                     sh => ʃ
                    
                    deromanizer:
                     th => θ
                """.trimIndent()
            )
        }

    }

    "It's invalid to have more than one romanizer" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    romanizer:
                     ʃ => sh
                    
                    romanizer:
                     θ => th
                """.trimIndent()
            )
        }
    }

    "Deromanizers and romanizers should default to all-phonetic" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc(
                """
                    Feature +ejective
                    Diacritic ' [+ejective]
                    Deromanizer:
                        ' => ʔ
                """.trimIndent()
            )
        }.also { it.reason.shouldBeInstanceOf<DanglingDiacritic>() }
        shouldThrow<LscInvalidRuleExpression> {
            lsc(
                """
                    Feature +ejective
                    Diacritic ' [+ejective]
                    Romanizer:
                        ʔ => '
                """.trimIndent()
            )
        }.also { it.reason.shouldBeInstanceOf<DanglingDiacritic>() }
        shouldThrow<LscInvalidRuleExpression> {
            lsc(
                """
                    Feature +ejective
                    Diacritic ' [+ejective]
                    Romanizer-foo:
                        ʔ => '
                """.trimIndent()
            )
        }.also { it.reason.shouldBeInstanceOf<DanglingDiacritic>() }
    }

    "Deromanizers and romanizers marked 'literal' should ignore declarations" {
        val ch = lsc(
            """
                Feature +ejective
                Diacritic ' [+ejective]
                Deromanizer literal:
                    ' => ʔ
                Romanizer literal:
                    ʔ => '
            """.trimIndent()
        )

        ch("'ama") shouldBe "'ama"
        ch("ma'a") shouldBe "ma'a"
    }

    "Literal deromanizers ignore declarations before the first Then:" {
        val ch = lsc(
            """
                Feature +ejective
                Diacritic ' [+ejective]
                deromanizer literal:
                  ' => h
                rule:
                  k => k'
            """.trimIndent()
        )

        ch("'a'i") shouldBe "hahi"
        ch("kaki") shouldBe "k'ak'i"
        ch("k'ak'i") shouldBe "k'hak'hi"
    }

    "Literal romanizers ignore declarations after the last Then:" {
        val ch = lsc(
            """
                Feature +ejective
                Diacritic ' [+ejective]
                rule:
                  k' => k
                romanizer literal:
                  h => '
            """.trimIndent()
        )

        ch("hahi") shouldBe "'a'i"
        ch("k'ak'i") shouldBe "kaki"
        ch("khakhi") shouldBe "k'ak'i"
    }

    "Running with intermediate romanizers should produce multiple result lists" {
        val ch = lsc(
            """
                Deromanizer:
                ch => tʃ
                change-a:
                tʃ => ʃ
                Romanizer-a:
                ʃ => sh
                change-b:
                a => æ
                Romanizer-b:
                ʃ => x
                æ => aa
                change-final:
                ʃ => s
                Romanizer:
                æ => ä
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("chachi", "vanechak")) shouldBe mapOf(
            "a" to listOf("shashi", "vaneshak"),
            "b" to listOf("xaaxi", "vaanexaak"),
            null to listOf("säsi", "vänesäk"),
        )
    }

    "We should be able to have several romanizers with no rules between them" {
        val ch = lsc(
            """
                Deromanizer:
                ch => tʃ
                change:
                tʃ => ʃ
                Romanizer-a:
                ʃ => sh
                Romanizer-b:
                ʃ => x
                Romanizer:
                ʃ => si
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("chachi", "vanechak")) shouldBe mapOf(
            "a" to listOf("shashi", "vaneshak"),
            "b" to listOf("xaxi", "vanexak"),
            null to listOf("siasii", "vanesiak"),
        )

        val ch2 = lsc(
            """
                Deromanizer:
                ch => tʃ
                change:
                tʃ => ʃ
                Romanizer-a:
                ʃ => sh
                Romanizer-b:
                ʃ => x
                change-final:
                a => æ
                Romanizer:
                ʃ => si
                æ => ä
            """.trimIndent()
        )

        ch2.changeWithIntermediates(listOf("chachi", "vanechak")) shouldBe mapOf(
            "a" to listOf("shashi", "vaneshak"),
            "b" to listOf("xaxi", "vanexak"),
            null to listOf("siäsii", "vänesiäk"),
        )
    }

    "Setting romanize = false should make all romanizers dump phonetic forms" {
        val ch = lsc(
            """
                Deromanizer:
                ch => tʃ
                change:
                tʃ => ʃ
                Romanizer-a:
                ʃ => sh
                Romanizer-b:
                ʃ => x
                Romanizer:
                ʃ => si
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("chachi", "vanechak"), romanize = false) shouldBe mapOf(
            "a" to listOf("ʃaʃi", "vaneʃak"),
            "b" to listOf("ʃaʃi", "vaneʃak"),
            null to listOf("ʃaʃi", "vaneʃak"),
        )
    }
})