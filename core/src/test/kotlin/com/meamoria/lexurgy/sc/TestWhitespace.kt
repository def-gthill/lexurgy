package com.meamoria.lexurgy.sc

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestWhitespace : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We can break rules across lines at =>" {
        val ch = lsc(
            """
                rule:
                    a =>
                    b
            """.trimIndent()
        )

        ch("ara") shouldBe "brb"
    }

    "We can break rules across lines at /" {
        val ch = lsc(
            """
                rule:
                    a => b /
                        _ c
            """.trimIndent()
        )

        ch("aca") shouldBe "bca"
    }

    "We can't break rules across blank lines" {
        shouldThrow<LscNotParsable> {
            lsc(
                """
                    rule:
                        a =>
                        
                        b
                """.trimIndent()
            )
        }
    }

    "We can't break rules across lines inside sequences" {
        shouldThrow<LscNotParsable> {
            lsc(
                """
                    rule:
                        a
                        b => c
                """.trimIndent()
            )
        }
    }

    "We can't break rules across lines inside alternative lists" {
        shouldThrow<LscNotParsable> {
            lsc(
                """
                    rule:
                        {a,
                        b} => c
                """.trimIndent()
            )
        }
    }

    "We can break class declarations at commas and the opening brace" {
        val ch = lsc(
            """
                Class letter {
                    a, b, c, d, e, f, g, h, i, j, k, l, m,
                    n, o, p, q, r, s, t, u, v, w, x, y, z,
                }
                
                destroy-letters:
                    @letter => *
            """.trimIndent()
        )

        ch("1a2x3") shouldBe "123"
    }

    "The file format should be fairly robust to extra newlines and blank lines" {
        // We're just testing that these don't throw exceptions
        lsc("Deromanizer:\n    y => j\n")
        lsc("Deromanizer:\n\ty => j\nrule:\n    j => ʒ\n\n\n")("yay") shouldBe "ʒaʒ"
        lsc("   ")
        lsc("\n\n  \nDeromanizer:\n\t\n y => j\nrule:\n  \n   j => ʒ\n\n          ")
        lsc(
            """
                rule:
                    p => b
                # Pointless comment
                    t => d # End of line pointless comment
                    # Indented pointless comment
                    k => g
            """.trimIndent()
        )
    }

    "We can have leading spaces at the beginning of the file" {
        val ch = lsc("    rule:\na => b")

        ch("aaa") shouldBe "bbb"
    }

    "We can have trailing whitespace at the end of the file" {
        val ch = lsc("rule:\na => b    ")

        ch("aaa") shouldBe "bbb"
    }

    "We can have a space between a feature name and the value declarations" {
        lsc("Feature Stress (*unstressed, stressed)")
    }

    "We can have spaces immediately inside alternatives" {
        lsc("Class foo { f, o }")
        lsc("rule:\n{ a, b } => { c, d }")
    }
})
