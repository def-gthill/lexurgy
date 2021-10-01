package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldBeInstanceOf
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestOperators : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to use & to join two matchers" {
        val ch = lsc(
            """
                Feature Stressed(*unstressed, stressed)
                Diacritic ˈ [stressed]
                Class vowel {a, e, i, o, u}
                
                Deromanizer:
                    {á, é, í, ó, ú} => {aˈ, eˈ, iˈ, oˈ, uˈ}
                
                unstressed-final-vowel-loss:
                    @vowel&[unstressed] => * / _ ${'$'} // {p, t, k} _
                
                Romanizer:
                    {aˈ, eˈ, iˈ, oˈ, uˈ} => {á, é, í, ó, ú}
            """.trimIndent()
        )

        ch("páno") shouldBe "pán"
        ch("panó") shouldBe "panó"
        ch("pánt") shouldBe "pánt"
        ch("páko") shouldBe "páko"

        val ch2 = lsc(
            """
                Feature Stressed(*unstressed, stressed)
                Diacritic ˈ (floating) [stressed]

                unstressed-vowel-centralizing:
                    {e, i, o, u}&[unstressed] => {ə, ɨ, ə, ɨ}
            """.trimIndent()
        )

        ch2("paˈno") shouldBe "paˈnə"
        ch2("iniˈte") shouldBe "ɨniˈtə"

        val ch3 = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n}
                Class stop {p, t, k}
                
                final-vowel-loss:
                    @vowel => * / @vowel @cons&!@stop _ $
            """.trimIndent()
        )

        ch3("pano") shouldBe "pan"
        ch3("pako") shouldBe "pako"
        ch3("pao") shouldBe "pao"
    }

    "We should be able to copy a feature value out of an intersection" {
        val ch = lsc(
            """
                Feature Voicing(unvoiced, voiced)
                Feature Nasality(*nonnasal, nasal)
                Feature Place(labial, alveolar, velar, glottal)
                Feature Manner(stop, fricative, approximant)

                Symbol p [unvoiced labial stop]
                Symbol b [voiced labial stop]
                Symbol k [unvoiced velar stop]
                Symbol g [voiced velar stop]
                Symbol f [unvoiced labial fricative]
                Symbol v [voiced labial fricative]
                Symbol n [voiced nasal alveolar]
                Symbol m [voiced nasal labial]
                Symbol r [voiced approximant]

                Class vowel {a, i, e, o, u}
                Class cons {p, b, k, g, f, v, r}

                nasal-assimilation:
                [nasal] => [${'$'}Place] / _ @cons&[${'$'}Place]

                obstruent-voicing-assimilation:
                @cons&!r => [${'$'}Voicing] / _ @cons&[${'$'}Voicing]
            """.trimIndent()
        )

        ch("anpara") shouldBe "ampara"
        ch("aprirka") shouldBe "abrirka"
        ch("avpika") shouldBe "afpika"
    }

    "Transforming elements shouldn't be supported yet " {
        shouldThrow<LscFutureStructure> {
            lsc(
                """
                    not-supported:
                        a>b => c
                """.trimIndent()
            )
        }

        shouldThrow<LscFutureStructure> {
            lsc(
                """
                    not-supported:
                        a => b>c
                """.trimIndent()
            )
        }
    }

    "!We should be able to create transforming matchers using >" {
        val ch = lsc(
            """
                Feature +long
                Diacritic ː [+long]
                Class vowel {a, e, i, o, u, aː, eː, iː, oː, uː}

                raise-before-long-copy @vowel:
                    {e, o}$1 => {i, u} / _ $1>[+long]
            """.trimIndent()
        )

        ch("tokyoː") shouldBe "tukyoː"
        ch("tokyo") shouldBe "tokyo"
        ch("meleː") shouldBe "mileː"
    }

    "!We should be able to use transforming matchers in a reversed context" {
        val ch = lsc(
            """
                Feature +long
                Diacritic ː [+long]
                Class vowel {a, e, i, o, u, aː, eː, iː, oː, uː}

                raise-diphthong-after-long-copy:
                    {ai, au}$1 => {ei, ou} / $1>[+long] (!@vowel)+ _
            """.trimIndent()
        )

        ch("haːiːtai") shouldBe "haːiːtei"
    }

    ("!We should get nice error messages if we try to start a transforming matcher with a" +
            "conditional emitter or continue it with an independent emitter") {
                shouldThrow<LscInvalidRuleExpression> {
                    lsc(
                        """
                            Feature +foo
                            start-with-conditional:
                                [+foo]>[-foo] => a
                        """.trimIndent()
                    )
                }.also {
                    it.cause.shouldBeInstanceOf<LscIllegalStructure>()
                    it.message shouldBe """
                        Error in expression 1 ("[+foo]>[-foo] => a") of rule "start-with-conditional"
                        A matrix like "[+foo]" can't be used at the start of a transforming matcher
                    """.trimIndent()
                }

                shouldThrow<LscInvalidRuleExpression> {
                    lsc(
                        """
                            continue-with-independent:
                                a>* => a
                        """.trimIndent()
                    )
                }.also {
                    it.cause.shouldBeInstanceOf<LscIllegalStructure>()
                    it.message shouldBe """
                        Error in expression 1 ("a>* => a") of rule "continue-with-independent"
                        An empty element like "*" can't be used to continue a transforming matcher
                    """.trimIndent()
                }
            }

    "!Alternatives should be lifted out of transforming matchers" {
        val ch = lsc(
            """
                Feature +long
                Diacritic ː [+long]
                Class vowel {a, e, i, o, u, aː, eː, iː, oː, uː}
                vowel-combining propagate:
                    @vowel$1 $1>{[+long], [-long]} => [+long] *
            """.trimIndent()
        )

        ch("tooːooːo") shouldBe "toː"
        ch("toaoaaeːei") shouldBe "toaoaːeːi"
    }

    "!We should be able to create transforming emitters using >" {
        val ch = lsc(
            """
                Feature +long
                Diacritic ː [+long]
                Class vowel {a, e, i, o, u, aː, eː, iː, oː, uː}

                swap-and-lengthen:
                    @vowel$1 {r, l}$2 => $2 $1>[+long]
            """.trimIndent()
        )

        ch("tarn") shouldBe "traːn"
        ch("poːl") shouldBe "ploː"
    }

    "!Initial alternatives should be lifted out of transforming elements and joined to corresponding alternatives" {
        val ch = lsc(
            """
                Feature +long
                Diacritic ː [+long]
                Class midvowel {e, o}
                Class highvowel {i, u}

                raise-and-shorten:
                    @midvowel>[+long] => @highvowel>[-long]
            """.trimIndent()
        )

        ch("kobeː") shouldBe "kobi"
        ch("soːdo") shouldBe "sudo"
    }

    "!Initial sequences should be lifted out of transforming elements and joined to corresponding sequences" {
        val ch = lsc(
            """
                Feature place(labial, alveolar, velar)
                Feature manner(stop, fricative)
                Feature voiced
                Symbol p [-voiced labial stop]
                Symbol b [+voiced labial stop]
                Symbol t [-voiced alveolar stop]
                Symbol d [+voiced alveolar stop]
                Symbol k [-voiced velar stop]
                Symbol g [+voiced velar stop]
                Symbol f [-voiced labial fricative]
                Symbol v [+voiced labial fricative]
                Symbol s [-voiced alveolar fricative]
                Symbol z [+voiced alveolar fricative]

                swap-and-voice:
                    [-voiced]$1 [-voiced]$2 => ($2 $1)>[+voiced]
            """.trimIndent()
        )

        ch("apsa") shouldBe  "azba"
        ch("ektofka") shouldBe "edgogva"
    }

    "We should be able to match segments that don't belong to a particular class" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class vowel {a, e, i, o, u}
                final-vowel-loss:
                    @vowel => * / !@stop _ $
            """.trimIndent()
        )

        ch("buka") shouldBe "buka"
        ch("suna") shouldBe "sun"
        ch("puraa") shouldBe "pura"
    }

    "We should be able to negate plain text and capture references" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                i-before-e:
                    i => * / !c _ e
                
                not-the-same:
                    {i, u}$1 => {j, w} / _ @vowel&!$1
            """.trimIndent()
        )

        ch("cietua") shouldBe "cjetwa"
        ch("vietuu") shouldBe "vetuu"
    }

    "We should be able to negate arbitrary elements inside an intersection" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class cons {@stop, s, m, n, l, r}
                
                cluster-reduction:
                    (@cons @cons$1)&!(@stop {l, r}) => * $1
            """.trimIndent()
        )

        ch("ptar") shouldBe "tar"
        ch("smakla") shouldBe "makla"
        ch("prakti") shouldBe "prati"
    }
})