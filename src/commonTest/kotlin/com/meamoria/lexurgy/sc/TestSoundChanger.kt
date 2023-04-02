package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.element.InvalidTransformation
import com.meamoria.mpp.kotest.*

@Suppress("unused")
class TestSoundChanger : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "An empty file should parse into a sound changer that returns each word unmodified" {
        val ch = lsc("")

        ch("foo") shouldBe "foo"
        ch("fgdgfggfgfggffdf") shouldBe "fgdgfggfgfggffdf"
        ch("thefiveboxingwizardsjumpquickly") shouldBe "thefiveboxingwizardsjumpquickly"
    }

    "We should be able to have numbers in names, as long as the whole name isn't numbers" {
        lsc(
            """
                Feature 2fast(2furious)
                Class v0w3l {a, i, u}
                4tition-1:
                    b => p
            """.trimIndent()
        )
    }

    "A file with syntax errors should fail to parse even if the start is valid" {
        shouldThrow<LscNotParsable> {
            lsc(
                """
                    a-rule:
                    x=>h
                    ]]]]]
                """.trimIndent()
            )
        }
    }

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

    "Duplicate rules should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    duplicate-rule:
                        o => a
                    duplicate-rule:
                        a => o
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The rule \"duplicate-rule\" is defined more than once"
        }
    }

    "Rules with mismatched elements should produce an LscInvalidRuleExpression with a clear error message" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("Feature bad(mat)\nbadrule:\n   a => b [mat]")
        }.also {
            it.cause.shouldBeInstanceOf<InvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("a => b [mat]") of rule "badrule"
                Found 1 element ("a") on the left side of the arrow but 2 elements ("b", "[mat]") on the right side
            """.trimIndent()
        }
    }

    "We should be able to implement deletion and epenthesis with * rules" {
        val ch = lsc(
            """
                deletion:
                    a => * / $ _
                    i => * / _ $
                    u => * / s _ s
                epenthesis:
                    * => i / $ _ d
                    * => a / _ $
                    * => u / d _ d
            """.trimIndent()
        )

        ch("afoobi") shouldBe "fooba"
        ch("dasusad") shouldBe "idassada"
        ch("muddud") shouldBe "mudududa"
    }

    "Multiple-character symbols should be recognized as single symbols" {
        val ch = lsc(
            """
               |Feature Place(lab, apic)
               |Feature Manner(stop, sonor)
               |Feature Nasal(unnas, nas)
               |Symbol b [lab stop unnas]
               |Symbol ᵐb [lab stop nas]
               |Symbol w [lab sonor unnas]
               |Symbol m [lab sonor nas]
               |Symbol d [apic stop unnas]
               |Symbol ⁿd [apic stop nas]
               |Symbol l [apic sonor unnas]
               |Symbol n [apic sonor nas]
               |sonorize:
               |    [stop] => [sonor] / a _ a
            """.trimMargin()
        )

        ch("babaⁿdade") shouldBe "bawanade"
        ch("baᵐbaⁿdebada") shouldBe "bamaⁿdebala"
    }

    "The matrix to symbol converter should still work if some symbols don't have features" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, high)
                Feature Depth(front, back)
                Feature Stress(*unstr, str)
                Diacritic ˈ (before) [str]
                Symbol a [vowel low]
                Symbol i [vowel high front]
                Symbol u [vowel high back]
                Symbol ts, dz
                stress-shift [vowel]:
                [vowel] => [str] / _ [] $
            """.trimIndent()
        )

        ch("vlimura") shouldBe "vlimˈura"
    }

    "Symbols with no features should count as lacking all features (and having all nulls)" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                coda-h:
                h => * / _ [cons]
            """.trimIndent()
        )

        ch("sohko") shouldBe "soko"
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

    "The file format should allow spaces to be included or not in places where this doesn't affect the meaning" {
        // We're just testing that these don't throw exceptions
        lsc("Feature Stress (*unstressed, stressed)")
    }

    "We should be able to use reserved characters in literal text by escaping them with a backslash" {
        val ch = lsc(
            """
                Feature Type(cons, vowel)
                Feature Voicing(unvoiced, voiced)
                Symbol t [cons unvoiced]
                Symbol d [cons voiced]
                Symbol \@ [vowel]
                Class swirly {\@}
                Deromanizer:
                    \+ => t
                    a => \@
                intervocalic-lenition:
                    [unvoiced] => [voiced] / [vowel] _ [vowel]
                no-swirly:
                    @swirly => i
                Romanizer:
                    d => \\
                    i => \_
            """.trimIndent()
        )

        ch("a+a+a") shouldBe "_\\_\\_"
    }

    "We should be able to use keywords as literal text and parts of rule names" {
        val ch = lsc(
            """
                ltr-to-ch:
                    ltr => tʃ
            """.trimIndent()
        )

        ch("eltrun") shouldBe "etʃun"

        val ch2 = lsc(
            """
                syllables-are-syllables:
                    o => syllables
            """.trimIndent()
        )

        ch2("foo") shouldBe "fsyllablessyllables"

        val ch3 = lsc(
            """
                class-feature-diacritic-symbol:
                    {class, feature} => {diacritic, symbol}
            """.trimIndent()
        )

        ch3("featureymcclassington") shouldBe "symbolymcdiacriticington"

        val ch4 = lsc(
            """
                clear-explicit:
                    clear => explicit
            """.trimIndent()
        )

        ch4("oooclearooo") shouldBe "oooexplicitooo"

        val ch5 = lsc(
            """
                deromanizer-romanizer-literal:
                    {deromanizer, romanizer} => literal
            """.trimIndent()
        )

        ch5("ideromanizeriromanizeri") shouldBe "iliteraliliterali"

        val ch6 = lsc(
            """
                then-else:
                    then => else
            """.trimIndent()
        )

        ch6("ifthendo") shouldBe "ifelsedo"

        val ch7 = lsc(
            """
                off-unchanged:
                    off => unchanged
            """.trimIndent()
        )

        ch7("coffee") shouldBe "cunchangedee"

        val ch8 = lsc(
            """
                element-defer:
                    element => defer
            """.trimIndent()
        )

        ch8("elementary") shouldBe "deferary"
    }

    "We can ask a sound changer to return all successfully changed words and all errors" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                conditional-binding:
                    h => $1 / {@vowel$1, j, w} _
            """.trimIndent()
        )

        val actual = ch.changeWithIndividualErrors(listOf("mahtiht", "bajhowh"))
        actual[0] shouldBe Result.success("maatiit")
        shouldThrow<LscRuleNotApplicable> {
            actual[1].getOrThrow()
        }
    }

    "A sound changer can be used as a word verifier" {
        val ch = lsc(
            """
                Class cons {p, t, k, s, m, n, l}
                Class glide {w, y}
                Class vowel {a, e, i, o, u}
                
                Syllables:
                    @cons @glide? @vowel @cons?
            """.trimIndent()
        )

        val actual = ch.changeWithIndividualErrors(listOf("lo", "pye", "pte", "kwus", "ak"))
        actual[0] shouldBe Result.success("lo")
        actual[1] shouldBe Result.success("pye")
        actual[2].exceptionOrNull().shouldBeInstanceOf<SyllableStructureViolated>()
        actual[3] shouldBe Result.success("kwus")
        actual[4].exceptionOrNull().shouldBeInstanceOf<SyllableStructureViolated>()
    }
})