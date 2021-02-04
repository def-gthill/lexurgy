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

    "The echo vowel rule in Engala should work" {
        val ch = lsc(
            """
                Class consonant {p, t, k, s, n}
                Class vowel {a, e, i, o, u}
                
                echo-vowel:
                    * => $1 / @vowel$1 @consonant* _ $ // {n, s} _
            """.trimIndent()
        )

        ch("pak") shouldBe "paka"
        ch("nop") shouldBe "nopo"
        ch("kis") shouldBe "kis"
        ch("san") shouldBe "san"
    }

    val exampleWords = listOf(
        "ka",
        "pika",
        "tonu",
        "lita",
        "sema",
        "talimu",
        "mehato",
        "kameti",
        "lapote",
        "po'alu",
        "samali",
        "muhasa",
        "kopiko",
        "atepino",
        "ki'ama",
        "haniposa",
        "kani'asoto",
        "nekosa'ima",
    )

    "The Basican example in the web app should work" {
        val ch = lsc(
            """
            Class vowel {a, e, i, o, u}

            k-before-a:
             k => ʃ / _ a

            palatalization:
             k => tʃ / _ i
    
            intervocalic-voicing:
             {p, t, k, s} => {b, d, g, z} / @vowel _ @vowel
    
            initial-s-aspiration:
             s => h / $ _
    
            glottal-loss:
             {h, '} => *

            l-gliding:
             # "Except at the start of a word"; otherwise lita becomes jda
             li => j // $ _

            final-vowel-loss-after-nasal:
             @vowel => * / @vowel {m, n} _ $
            """.trimIndent()
        )

        val expected = listOf(
            "ʃa",
            "piʃa",
            "ton",
            "lida",
            "em",
            "tajmu",
            "meado",
            "ʃamedi",
            "labode",
            "poalu",
            "amaj",
            "muaza",
            "kobigo",
            "adebin",
            "tʃiam",
            "aniboza",
            "ʃaniazodo",
            "negozaim",
        )

        for ((expectedWord, originalWord) in expected.zip(exampleWords)) {
            ch(originalWord) shouldBe expectedWord
        }
    }

    "The Intermediatese example in the web app should work" {
        val ch = lsc(
            """
            Feature Type(*cons, vowel)

            Feature Place(bilabial, alveolar, velar, glottal)
            Feature Manner(stop, fricative, nasal, lateral)
            
            Feature Height(low, mid, high)
            Feature Frontness(front, central, back)
            
            Feature Length(*short, long)
            Feature Stress(*unstressed, stressed)
            
            Diacritic ː [long]
            Diacritic ˈ [stressed]
            
            Symbol p [bilabial stop]
            Symbol t [alveolar stop]
            Symbol k [velar stop]
            Symbol ʔ [glottal stop]
            Symbol s [alveolar fricative]
            Symbol h [glottal fricative]
            Symbol m [bilabial nasal]
            Symbol n [alveolar nasal]
            Symbol l [alveolar lateral]
            
            Symbol a [low central vowel]
            Symbol e [mid front vowel]
            Symbol i [high front vowel]
            Symbol o [mid back vowel]
            Symbol u [high back vowel]
            
            Deromanizer:
             ' => ʔ
            
            stress-first-syllable:
             [vowel] => [stressed] / ${'$'} [cons]? _
            
            syncope:
             [unstressed vowel] => * / {[!stop] _ [cons], [stop] _ [stop]}
            
            coda-drop-and-lengthen:
             [vowel] {h, [stop]} => [long] * / _ [cons]
            
            nasal-assimilation:
             [nasal] => [${'$'}Place] / _ [cons !glottal ${'$'}Place]
            
            Romanizer-phonetic:
             unchanged
            
            Romanizer:
             # Get rid of the stress marks, since stress is still predictable
             [stressed] => [unstressed]
             Then:
             {aː, eː, iː, oː, uː} => {ā, ē, ī, ō, ū}
             ʔ => '

            """.trimIndent()
        )

        val expected = listOf(
            "ka",
            "pika",
            "tonu",
            "lita",
            "sema",
            "talmu",
            "mēto",
            "kanti",
            "lāte",
            "po'alu",
            "sanli",
            "mūsa",
            "kōko",
            "āpino",
            "ki'ama",
            "hamposa",
            "kan'asto",
            "nekos'ima",
        )

        for ((expectedWord, originalWord) in expected.zip(exampleWords)) {
            ch(originalWord) shouldBe expectedWord
        }
    }

    "The Advancedish example in the web app should work" {
        val ch = lsc(
            """
            Feature Type(*cons, vowel)

            Feature Place(bilabial, alveolar, velar, glottal)
            Feature Manner(stop, fricative, nasal, lateral)
            
            Feature Height(low, mid, high)
            Feature Frontness(front, central, back)
            
            Feature Length(*short, long)
            Feature Stress(*unstressed, secondary, primary)
            
            Diacritic ː [long]
            Diacritic ˈ [primary]
            Diacritic ˌ [secondary]
            
            Symbol a [low central vowel]
            Symbol e [mid front vowel]
            Symbol i [high front vowel]
            Symbol o [mid back vowel]
            Symbol u [high back vowel]
            
            Class stop {p, t, k}
            Class sonorant {m, n, l}
            
            Deromanizer:
             ' => ʔ
            
            primary-stress-second-last-syllable [vowel]:
             [] => [primary] / _ [] ${'$'}
            
            add-secondary-stress [vowel] propagate:
             # Applies secondary stress to alternating vowels before the main stress
             [unstressed] => [secondary] / _ [] {[primary], [secondary]}
            
            Romanizer-before-syncope:
             unchanged
            
            syncope:
             [unstressed vowel] => * // _ ${'$'}
             Then:
             # Secondary stress has served its purpose
             [secondary] => [unstressed]
            
            glottal-loss:
             ʔ => * / {[cons] _, _ [cons]}
            
            stop-stop-clusters:
             @stop => * / ${'$'} _ @stop
             @stop => ${'$'}1 / _ @stop${'$'}1
            
            obey-sonority:
             @sonorant${'$'}1 @stop${'$'}2 => ${'$'}2 ${'$'}1 / ${'$'} _
            
            Romanizer:
             # Get rid of the stress marks, since stress is still predictable
             [primary] => [unstressed]
            """.trimIndent()
        )

        val expected = listOf(
            "ka",
            "pika",
            "tonu",
            "lita",
            "sema",
            "tlimu",
            "mhato",
            "kmeti",
            "plote",
            "palu",
            "smali",
            "mhasa",
            "piko",
            "appino",
            "kama",
            "hanposa",
            "knisoto",
            "knosima",
        )

        for ((expectedWord, originalWord) in expected.zip(exampleWords)) {
            ch(originalWord) shouldBe expectedWord
        }
    }
})