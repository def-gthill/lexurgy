package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestRealExamples : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "The Kharulian consonant separation rule should break apart consecutive consonants" {
        val ch = lsc(
            """
                Class vowel {a, i, ə}
                Class cons {p, t, k, s, m, n, l, r}
                break-up-clusters:
                    * => ə / {$ @cons _ @cons, @cons @cons _ @cons, @vowel @cons _ @cons $}
            """.trimIndent()
        )

        ch("mtmkaasr") shouldBe "mətəməkaasər"
        ch("tmkipnralpt") shouldBe "təməkipnəralpət"
    }

    "The Caidorian syncope rule should work properly (i.e. before environments should match backwards from the anchor)" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, lowmid, mid, high)
                Feature Depth(front, central, back)
                Feature Stress(*unstressed, stressed)
                Feature Length(*short, long)

                Diacritic ́  (floating) [stressed]
                Diacritic ː (floating) [long]

                Symbol pʰ, tʰ, cʰ, kʰ, bʱ, dʱ, ɟʱ, gʱ
                Symbol ɛ [vowel lowmid front]
                Symbol e [vowel mid front]
                Symbol i [vowel high front]
                Symbol a [vowel low central]
                Symbol ɔ [vowel lowmid back]
                Symbol o [vowel mid back]
                Symbol u [vowel high back]
                
                Class aspir {pʰ, tʰ, cʰ, kʰ}
                Class breathy {bʱ, dʱ, ɟʱ, gʱ}
                Class unvcd {p, t, c, k}
                Class vcd {b, d, ɟ, g}
                Class stop {@aspir, @breathy, @unvcd, @vcd}
                Class fricative {f, s, ç}
                Class obstruent {@stop, @fricative}

                Deromanizer:
                    {ph, th, ch, kh} => {pʰ, tʰ, cʰ, kʰ}
                    {bh, dh, jh, gh} => {bʱ, dʱ, ɟʱ, gʱ}
                    j => ɟ
                    sh => ç
                    nh => ɲ
                    Then:
                    [vowel]${'$'}1 ${'$'}1 => [long] *
                    Then:
                    [vowel] => [stressed] / ${'$'} [cons]* _
                syncope:
                    [vowel short] => * / [vowel stressed] [cons]* _ @stop [cons]* [vowel]
                    [vowel short] => * / [vowel stressed] [cons]* @obstruent _ @obstruent [cons]* [vowel]
            """.trimIndent()
        )

        ch("migomausis") shouldBe "mígomausis"
        ch("egidhi") shouldBe "égdʱi"
        ch("eefase") shouldBe "éːfse"
    }

    "Technomancer00's example should work with the new deromanizer/romanizer rules" {
        val ch = lsc(
            """
            Feature Type(*cons, vowel, obstruent, resonant, glide)
            Feature Place(labial, coronal, dorsal, glottal)
            Feature Manner(nasal, stop, affricate, fricative, approximant)
            Feature Height(high, mid, low)
            Feature Depth(front, central, back)
            Feature Stress(*stressed, unstressed)
            Feature Voice(*voiced, unvoiced, aspirated, ejective)
            Feature Length(*short, long)
            Feature Nasality(*oral, nasalized)
    
            Diacritic ʰ [aspirated]
            Diacritic ’ [ejective]
            Diacritic ́ [stressed]
            Diacritic ː [long]
    
            #Proto Sata'ilun
            Symbol a [low central vowel]
            Symbol i [high front vowel]
            Symbol u [high back vowel]
            Symbol ā [long low central vowel]
            Symbol ī [long high front vowel]
            Symbol ū [long high back vowel]
            Symbol m [labial nasal]
            Symbol n [coronal nasal]
            Symbol p [unvoiced labial stop]
            Symbol t [unvoiced coronal stop]
            Symbol k [unvoiced dorsal stop]
            Symbol ʔ [unvoiced glottal stop]
            Symbol s [unvoiced coronal fricative]
            Symbol h [unvoiced glottal fricative]
            #Intermediate symbols
                Symbol b [voiced labial stop]
            Symbol d [voiced coronal stop]
            Symbol ɡ [voiced dorsal stop]
    
            Deromanizer:
            y => j
            ā => aː
            ī => iː
            ū => uː
            ' => ʔ
    
            vowel-loss:
            [vowel] => * / [unvoiced] _ [unvoiced]
    
            intervocalic-stop-voicing:
            [unvoiced stop !glottal] => [voiced] / [vowel] _ [vowel]
    
            ejectives:
            [unvoiced] => [ejective] / _ [glottal stop]
    
            Romanizer:
            j => y
            aː => ā
            iː => ī
            uː => ū
            ʔ => '
            [stressed vowel] => [vowel]
            """.trimIndent()
        )

        ch("ta'ínki") shouldBe "t’'ínki"
        ch("ta'an") shouldBe "t’'an"
    }
})