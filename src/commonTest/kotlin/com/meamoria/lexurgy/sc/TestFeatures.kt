package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldBeInstanceOf
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestFeatures : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to match sounds against a simple feature matrix" {
        val ch = lsc(
            """
                Feature Manner(stop, nonstop)
                Feature Place(labial, alveolar, velar)
                Symbol p [labial stop]
                Symbol t [alveolar stop]
                Symbol k [velar stop]
                Symbol f [nonstop]
                drop-stop:
                    [stop] => *
            """.trimIndent()
        )

        ch("klaptrap") shouldBe "lara"
        ch("fniftikuf") shouldBe "fnifiuf"
    }

    "Duplicate feature declarations should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Manner(stop, nonstop)
                    Feature Manner(labial, alveolar, velar)
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The feature \"Manner\" is defined more than once"
        }
    }

    "Duplicate feature value declarations should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Manner(stop, stop)
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The feature value \"stop\" is defined more than once"
        }
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Manner(stop, nonstop)
                    Feature Place(nonstop, alveolar, velar)
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The feature value \"nonstop\" is defined more than once"
        }
    }

    "References to undefined features should produce an LscUndefinedName" {
        shouldThrow<LscUndefinedName> {
            lsc(
                """
                    Feature foo(baz)
                    Symbol x [bar]
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The feature value \"bar\" is not defined"
        }
        shouldThrow<LscUndefinedName> {
            lsc(
                """
                    Feature +baz
                    Diacritic ˈ [+bar]
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The feature value \"+bar\" is not defined"
        }
//        shouldThrow<LscUndefinedName> {
//            lsc(
//                """
//                    Feature foo(baz, qux)
//                    silly:
//                     [bar] => [qux]
//                """.trimIndent()
//            )
//        }.also {
//            it.message shouldBe "The feature value \"bar\" is not defined"
//        }
    }

    "Duplicate symbol declarations should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Manner(stop, nonstop)
                    Symbol p [stop]
                    Symbol p [nonstop]
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The symbol \"p\" is defined more than once"
        }
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Manner(stop, affricate)
                    Symbol ts [affricate]
                    Symbol ts, dz
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The symbol \"ts\" is defined more than once"
        }
    }

    "Multiple symbols with the same feature matrix should produce an LscDuplicateMatrices" {
        shouldThrow<LscDuplicateMatrices> {
            lsc(
                """
                    Feature Type(*cons, vowel)
                    Symbol æ [vowel]
                    Symbol ɛ [vowel]
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The symbols æ and ɛ both have the matrix [vowel]; add features to make them distinct."
        }
    }

    "We should be able to alter matrix features with a rule" {
        val ch = lsc(
            """
               |Feature Voicing(unvcd, vcd)
               |Feature Manner(stop, nonstop)
               |Symbol p [unvcd stop]
               |Symbol b [vcd stop]
               |Symbol f [unvcd nonstop]
               |Symbol v [vcd nonstop]
               |devoice-all:
               |    [vcd] => [unvcd]
            """.trimMargin()
        )

        ch("bivalve") shouldBe "pifalfe"
        ch("prefabricative") shouldBe "prefapricatife"
    }

    "We should be able to name the \"absent\" value of a feature" {
        val ch = lsc(
            """
               |Feature Manner(stop)
               |Feature Place(lab, apic, vel)
               |Feature Breath(*plain, aspir)
               |Diacritic ʰ [aspir]
               |Symbol p [stop lab]
               |Symbol t [stop apic]
               |Symbol k [stop vel plain]
               |aspiration:
               |    [stop plain] s => [aspir] *
               |lenition:
               |    [stop aspir] => [plain] / a _ a
               |    [stop plain] => * / a _ a
               |velar-shift:
               |    [stop] => [vel] / _ u
            """.trimMargin()
        )

        ch("psataba") shouldBe "pʰaaba"
        ch("patsaba") shouldBe "pataba"
        ch("putsu") shouldBe "kukʰu"
    }

    "Even if we name the absent value, we should still be able to use the * syntax for it" {
        val ch = lsc(
            """
               |Feature Manner(stop)
               |Feature Place(lab, apic, vel)
               |Feature Breath(*plain, aspir)
               |Diacritic ʰ [aspir]
               |Symbol p [stop lab]
               |Symbol t [stop apic]
               |Symbol k [stop vel plain]
               |aspiration:
               |    [stop *Breath] s => [aspir] *
               |lenition:
               |    [stop aspir] => [*Breath] / a _ a
               |    [stop *Breath] => * / a _ a
               |velar-shift:
               |    [stop] => [vel] / _ u
            """.trimMargin()
        )

        ch("psataba") shouldBe "pʰaaba"
        ch("patsaba") shouldBe "pataba"
        ch("putsu") shouldBe "kukʰu"
    }

    "A negated matrix value should only match sounds that don't have that feature value" {
        val ch = lsc(
            """
                Feature Place(lab, alv, glot)
                Feature Voicing(unvcd, vcd)
                Symbol f [unvcd lab]
                Symbol v [vcd lab]
                Symbol s [unvcd alv]
                Symbol z [vcd alv]
                Symbol h [unvcd glot]
                h-is-special:
                [unvcd !glot] => [vcd] / a _ a
            """.trimIndent()
        )

        ch("ahafasa") shouldBe "ahavaza"

        shouldThrow<LscInvalidRuleExpression> {
            lsc("negated-in-output:\n[foo] => [!bar]")
        }.also {
            it.cause.shouldBeInstanceOf<LscInvalidOutputMatrix>()
            it.message shouldBe """
                Error in expression 1 ("[foo] => [!bar]") of rule "negated-in-output"
                Feature matrix [!bar] has a negated feature, which isn't allowed in the output of a rule
            """.trimIndent()
        }
    }

    "An absent feature value should only match sounds that don't have any value from that feature" {
        val ch = lsc(
            """
                Feature Type(cons)
                Feature Manner(stop, fric, nas)
                Feature Voicing(unvcd, vcd)
                Symbol t [cons stop unvcd]
                Symbol d [cons stop vcd]
                Symbol n [cons nas]
                stop-to-nasal:
                [stop] => [nas *Voicing] / a _ a
                drop-nasal:
                [cons *Voicing] => * / _ [stop]
            """.trimIndent()
        )

        ch("antata") shouldBe "atana"
        ch("adtata") shouldBe "adtana"
    }

    "We should be able to copy feature variables from one matrix to another using feature variables" {
        val ch1 = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, high)
                Feature Depth(front, back)
                Symbol a [vowel low back]
                Symbol e [vowel low front]
                Symbol o [vowel high back]
                Symbol i [vowel high front]
                short-harmony:
                [vowel] => [${'$'}Height] / [vowel ${'$'}Height] n+ _
                [vowel ${'$'}Height ${'$'}Depth] => * / [vowel ${'$'}Height ${'$'}Depth] _
            """.trimIndent()
        )

        ch1("anni") shouldBe "anne"
        ch1("inna") shouldBe "inno"
        ch1("beetaamae") shouldBe "betamae"

        val ch2 = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, high)
                Feature Depth(front, back)
                Feature Rounding(round, unround)
                Symbol a [vowel low back unround]
                Symbol o [vowel low back round]
                Symbol e [vowel low front unround]
                Symbol ö [vowel low front round]
                Symbol ï [vowel high back unround]
                Symbol u [vowel high back round]
                Symbol i [vowel high front unround]
                Symbol ü [vowel high front round]
                coalescence:
                {[vowel ${'$'}Rounding ${'$'}Height] [high ${'$'}Depth], [high ${'$'}Depth] [vowel ${'$'}Rounding ${'$'}Height]} => [${'$'}Rounding ${'$'}Depth ${'$'}Height] *
            """.trimIndent()
        )

        ch2("duomaitio") shouldBe "dometö"
    }

    "Feature variables should capture a feature's default value" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(*low, high)
                Feature Depth(*front, back)

                Symbol a [vowel back]
                Symbol e [vowel]
                Symbol i [vowel high]
                Symbol u [vowel high back]

                harmony [vowel] propagate:
                    [] => [${'$'}Height] / [${'$'}Height] _
            """.trimIndent()
        )

        ch("kaki") shouldBe "kake"
        ch("putatu") shouldBe "pututu"
        ch("ichigaku") shouldBe "ichiguku"
        ch("epistrefu") shouldBe "epestrefa"
    }

    "We should be able to use feature variables to conjure a matrix out of nothing" {
        val ch = lsc(
            """
                Feature Place(labial, alveolar, velar)
                Feature Manner(stop, nasal)
                Symbol p [labial stop]
                Symbol t [alveolar stop]
                Symbol k [velar stop]
                Symbol m [labial nasal]
                Symbol n [alveolar nasal]
                Symbol ŋ [velar nasal]
                interpolate:
                    * => [${'$'}Place stop] / [${'$'}Place nasal] _ [stop]
            """.trimIndent()
        )

        ch("klomter") shouldBe "klompter"
        ch("sfiŋter") shouldBe "sfiŋkter"
        ch("bumkin") shouldBe "bumpkin"
    }

    "When a matrix is applied to a multi-segment literal, it should change all segments" {
        val ch = lsc(
            """
                Feature +hightone
                Diacritic ́  [+hightone]
                diphthong-hightone:
                    ie => [+hightone]
            """.trimIndent()
        )

        ch("kiemei") shouldBe "kíémei"
    }

    "Feature and value names should allow mixed case" {
        val ch = lsc(
            """
                Feature place(laBial, aLveolar, velaR)
                Feature maNNer(STOP, Nasal)
                Symbol p [laBial STOP]
                Symbol t [aLveolar STOP]
                Symbol k [velaR STOP]
                Symbol m [laBial Nasal]
                Symbol n [aLveolar Nasal]
                Symbol ŋ [velaR Nasal]
                interpolate:
                    * => [${'$'}place STOP] / [${'$'}place Nasal] _ [STOP]
            """.trimIndent()
        )

        ch("klomter") shouldBe "klompter"
        ch("sfiŋter") shouldBe "sfiŋkter"
        ch("bumkin") shouldBe "bumpkin"
    }

    "We should be able to declare binary features that behave the way linguists expect features to behave" {
        val ch = lsc(
            """
                Feature type(*cons, vowel)
                Feature +stress
                Feature high, low, front, back
                Diacritic ˈ [+stress]
                Symbol a [vowel +low -high -front -back]
                Symbol e [vowel -low -high +front -back]
                Symbol i [vowel -low +high +front -back]
                Symbol o [vowel -low -high -front +back]
                Symbol u [vowel -low +high -front +back]
                
                stress-second-last-syllable [vowel]:
                    [] => [+stress] / _ [] $
                vowel-harmony [vowel] propagate:
                    [-low] => [${'$'}high] / [${'$'}high -low] []* _
                stress-breaking:
                    *  => [vowel -low +high ${'$'}front ${'$'}back] / _ [-low -high +stress ${'$'}front ${'$'}back]
            """.trimIndent()
        )

        ch("dormo") shouldBe "duoˈrmo"
        ch("pegakibo") shouldBe "pegakieˈbo"
        ch("minemuto") shouldBe "minimuˈtu"
    }

    "We should be able to use the absent values of binary features" {
        // And we should be able to negate a plus-only feature with * and - interchangeably.
        val ch = lsc(
            """
                Feature hitone
                Feature +stress
                Diacritic ˈ (floating) [+stress]
                Diacritic ́  (floating) [+hitone]
                Diacritic ̀  (floating) [-hitone]
                Class vowel {a, e, i, o, u}
                lowtone-last-syllable-if-not-stressed @vowel:
                    [-stress] => [-hitone] / _ $
                tone-spreading-unstressed @vowel:
                    [*stress *hitone] => [${'$'}hitone] / [${'$'}hitone] _
            """.trimIndent()
        )

        ch("fuba") shouldBe "fubà"
        ch("kímataˈ") shouldBe "kímátaˈ"
    }
})