package com.meamoria.lexurgy.sc

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

@Suppress("unused")
class TestSoundChanger : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

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