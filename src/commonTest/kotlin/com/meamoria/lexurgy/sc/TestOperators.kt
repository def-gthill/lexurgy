package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

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

    "We should be able to create transforming matchers using >" {
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
        ch("meleː") shouldBe "mileː"
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
})