package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.normalizeCompose
import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldThrow

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

        ch("migomausis") shouldBe "mígomausis"
        ch("egidhi") shouldBe "égdʱi"
        ch("eefase") shouldBe "éːfse"
    }

    "This version of the Kharulian sound changes should work consistently" {
        val ch = lsc(
            """
            Feature Type(*cons, vowel)

            Feature Place(labial, alveolar, velar, glottal)
            Feature Tightness(*loose, tight)
            Feature Manner(stop, fricative, sibilant, nasal, lateral, rhotic)
            Feature Voicing(unvoiced, voiced)

            Feature Height(low, lowmid, mid, high)
            Feature Depth(front, central, back)
            Feature Schwa(*nonschwa, schwa)
            Feature Length(*short, glide, long)
            Feature Stress(*unstressed, stressed)

            Diacritic ́  (floating) [stressed]
            Diacritic ː (floating) [long]
            Diacritic ʲ [tight]

            Symbol p [unvoiced labial stop]
            Symbol b [voiced labial stop]
            Symbol t [unvoiced alveolar stop]
            Symbol d [voiced alveolar stop]
            Symbol tʃ [unvoiced alveolar tight stop]
            Symbol dʒ [voiced alveolar tight stop]
            Symbol k [unvoiced velar stop]
            Symbol g [voiced velar stop]
            Symbol c [unvoiced velar tight stop]
            Symbol ɟ [voiced velar tight stop]
            Symbol h [glottal]
            Symbol ɸ [unvoiced labial fricative]
            Symbol β [voiced labial fricative]
            Symbol t͜s [unvoiced alveolar fricative]
            Symbol d͜z [voiced alveolar fricative]
            Symbol ç [unvoiced velar tight fricative]
            Symbol ʝ [voiced velar tight fricative]
            Symbol x [unvoiced velar fricative]
            Symbol ɣ [voiced velar fricative]
            Symbol s [unvoiced alveolar sibilant]
            Symbol z [voiced alveolar sibilant]
            Symbol ʃ [unvoiced alveolar tight sibilant]
            Symbol ʒ [voiced alveolar tight sibilant]
            Symbol m [voiced labial nasal]
            Symbol n [voiced alveolar nasal]
            Symbol ɲ [voiced alveolar tight nasal]
            Symbol l [voiced alveolar lateral]
            Symbol r [voiced alveolar rhotic]

            Symbol a [vowel low central]
            Symbol ə [vowel mid central schwa]
            Symbol ɛ [vowel lowmid front]
            Symbol e [vowel mid front]
            Symbol i [vowel high front]
            Symbol ɔ [vowel lowmid back]
            Symbol o [vowel mid back]
            Symbol u [vowel high back]
            Symbol j [vowel high front glide]
            Symbol w [vowel high back glide]

            Class liquid {l, r, w, j}

            Deromanizer:
                x => ç
                y => j
                {é, e, ó, o} => {e, ɛ, o, ɔ}

            # Find the surface form of the Proto-Kharulian word

            glides:
                [glide] => [long] / ${'$'} _ [glide] [vowel !glide]
                [glide] => [long] / {[cons] _, ${'$'} [glide] _} // _ [vowel !glide]
                [glide] => [long] / ${'$'} _ // _ [vowel]

            glides-prop propagate:
                [glide] => [long] / [vowel !glide] [glide] _

            glides-cleanup:
                [glide ${'$'}Depth] => * / [long ${'$'}Depth] _ ${'$'}

            single-consonant:
                * => ə / ${'$'} [cons] _ ${'$'}

            break-up-clusters:
                * => ə / {{[cons], [glide]} [cons] _ [cons], [vowel] {[cons], [glide]} _ [cons] ${'$'}}
                Then:
                * => ə / ${'$'} {[cons], [glide]} _ [cons]

            voice-intervocalic:
                [unvoiced] => [voiced] / [vowel !glide] _ [vowel !glide]

            break-up-stops-and-h:
                * => ə / [stop] _ [stop]
                * => ə / {[cons] _ h, h _ [cons]}

            long-vowels propagate:
                [vowel ${'$'}Height ${'$'}Depth] [vowel ${'$'}Height ${'$'}Depth] => [long] *

            stress:
                [vowel nonschwa !glide] => [stressed] / _ {[cons], [glide]}* [vowel short] [vowel short] ${'$'}
                Then:
                [vowel nonschwa !glide] => [stressed] / ${'$'} [unstressed]* _ {[cons], [glide], [schwa]}* ([vowel] ${'$'})
                Then:
                [vowel nonschwa !glide] => [stressed] / ${'$'} [unstressed]* _ {[cons], [glide], [schwa]}* ${'$'}

            # Surface form of the Proto-Kharulian word
            Romanizer-pksurface:
                [long]${'$'}1 * => ${'$'}1 ${'$'}1
                Then: [long] => [short]
                Then:
                {ç, ʝ} => {sh, zh}
                j => y
                {á, ɛ́, é, í, ɔ́, ó, ú} => {á, ê, é, í, ô, ó, ú}
                {ɛ, e, ɔ, o} => {è, e, ò, o}
                ə => ë

            # Now start evolving it

            metathesis:
                {[rhotic], [lateral]}${'$'}1 {[stop], [fricative], [sibilant]}${'$'}2 => ${'$'}2 ${'$'}1
                {[stop]}${'$'}1 {[fricative], [sibilant], [nasal]}${'$'}2 => ${'$'}2 ${'$'}1
                {[fricative], [sibilant]}${'$'}1 [nasal]${'$'}2 => ${'$'}2 ${'$'}1
                [nasal]${'$'}1 {[rhotic], [lateral]}${'$'}2 => ${'$'}2 ${'$'}1

            echo-vowels [vowel]:
                ə => [${'$'}Height ${'$'}Depth nonschwa] / [${'$'}Height ${'$'}Depth nonschwa !glide] [glide]* _

            boundary-vowels [vowel]:
                ə => a / {${'$'} _, _ ${'$'}}
                Then: a => [stressed] / _ ${'$'}
                Then: [stressed] => [unstressed] / [stressed] [unstressed]* _

            schwa-loss:
                ə => * / _ [cons] [nonschwa] // [cons] [cons] _

            # Semiev

            stress-movement [vowel !glide]:
                [] => [stressed] / [unstressed] [unstressed] _ ${'$'}
                Then:
                [stressed] => [unstressed] / _ [unstressed]* [stressed]

            cluster-reduction:
                @liquid => * / {@liquid _ [cons], [cons] _ @liquid}
                {ts, dz} => {t͜s, d͜z}
                Then:
                tl => tʃ

            umlaut:
                {a, ɛ, e} => {ɛ, e, i} / _ {[cons], [glide]}+ [high front]

            # Old Kharulian, c. -1000
            Romanizer-ok:
                [stressed] => [unstressed] / {_ [cons]+ [vowel]* ${'$'}, ${'$'} {[cons], [glide]}* _ {[cons], [glide]}* ${'$'}}
                Then: [long]${'$'}1 * => ${'$'}1 ${'$'}1
                Then: [long] => [short]
                Then:
                {t͜s, d͜z} => {ts, dz}
                tʃ => ch
                {ç, ʝ} => {sh, zh}
                j => y
                {á, ɛ́, é, í, ɔ́, ó, ú} => {á, ê, é, í, ô, ó, ú}
                {ɛ, e, ɔ, o} => {è, e, ò, o}
                ə => ë

            h-loss:
                h => *

            palatalization:
                [cons loose] => [tight] / _ [cons]* [front]
                {ç, ʝ} => {x, ɣ} / {_ [back high], _ [back] [vowel !back !glide]}
                Then:
                {t͜sʲ, d͜zʲ} => {tʃ, dʒ}

            high-shift:
                [high !long unstressed] => ə / {${'$'} [cons] _ [cons], [cons] [cons] _ [cons], [cons] _ [cons] ${'$'}, [cons] _ [cons] [cons]}
                [high !long unstressed] => * / [cons] _
                {[lowmid], [mid nonschwa]} => {[mid], [high]}

            unstressed-first-vowel:
                [vowel !low !long unstressed] => * / [cons] _ [vowel !glide]

            frication:
                # Reassert this so they don't revert to {ts, dz}
                {tʃ, dʒ} => {tʃ, dʒ}
                [stop] => [fricative] / {_ [low central], _ [stop]} // [cons] _

            s-voicing:
                {s, ʃ} => {z, ʒ} / {[vowel], [voiced]} _ {[vowel], [voiced]}

            vowel-shortening:
                [vowel long] => [short]

            vowel-coalescence:
                [vowel ${'$'}Height ${'$'}Depth] [vowel ${'$'}Height ${'$'}Depth stressed] => * [long]
                [vowel ${'$'}Height ${'$'}Depth] [vowel ${'$'}Height ${'$'}Depth] => [long] *
                Then: {{ei, ie}, {ou, uo}} => {iː, uː}
                Then: {ae, ea, ao, oa} => aː
                Then: {a i!, i! a, a u!, u! a} => {eː *, * eː, oː *, * oː}

            high-vowel-gliding:
                [vowel high short unstressed] => [glide] / [vowel !glide] _ // [vowel !glide] [vowel !glide] _

            glide-fortition:
                j => ʝ // _ [cons]
                w => ɣ / _ [front]
                w => β // _ [cons]

            glide-coalescence:
                {[low], [lowmid]} j => [front mid long] *
                [vowel] j => [front high long] *
                {[low], [lowmid], [front mid]} w => [back mid long] *
                [vowel] w => [back high long] *

            re-long-vowels propagate:
                [vowel ${'$'}Height ${'$'}Depth] [vowel ${'$'}Height ${'$'}Depth] => [long] *

            rhotacization:
                z => r / [vowel] _ [vowel]

            # Romanization designed to be reasonably friendly for
            # English speakers, for use in stories and media.
            Romanizer-friendly:
                [stressed] => [unstressed] / {_ [cons]+ [vowel]* ${'$'}, ${'$'} [cons]* _ [cons]* ${'$'}}
                Then: [long]${'$'}1 * => ${'$'}1 ${'$'}1
                Then: [stressed] => [unstressed] / [stressed] _
                Then: [long] => [short]
                Then: * => w / {p, b, k, g, ɸ, β, x, ɣ, m, n, l, r} _ {[front], [tight]}
                Then:
                {pʲ, bʲ, ɸʲ, βʲ, mʲ} => {p, b, ɸ, β, m} / _ {[front], [tight]}
                {pʲ, bʲ, c, ɟ, ɸʲ, βʲ, ç, ʝ, mʲ, ɲ, lʲ, rʲ} * => {p, b, k, g, ɸ, β, x, ɣ, m, n, l, r} y
                Then:
                {tʃ, dʒ} => {ch, dj}
                {t͜s, d͜z} => {ts, dz}
                {ɸ, β} => {f, v}
                {ʃ, ʒ} => {sh, zh}
                {x, ɣ} => {kh, gh}
                {á, é, í, ó, ú} => {á, é, í, ó, ú}
                y => * / {_ ${'$'}, _ [cons]}
                yə => yi
                wə => a
                ə => i / {ʃ, ʒ} _
                ə => yi / [tight] _
                ə => a / [loose] _

            # Romanizer for language documentation, which sacrifices
            # some ease of use to more closely represent the phonetic
            # structure
            Romanizer:
                [stressed] => [unstressed] / {_ {[cons], [schwa]}+ ([vowel]* ${'$'}), ${'$'} {[cons], [schwa]}* _ {[cons], [schwa]}* ${'$'}}
                Then: [long]${'$'}1 * => ${'$'}1 ${'$'}1
                Then: [stressed] => [unstressed] / [stressed] _
                Then: [long] => [short]
                Then: * => w / [cons loose] _ {[front], [tight]}
                Then:
                [tight] => [loose] / _ {[front], [tight]}
                [tight] * => [loose] y
                Then:
                {{i!}${'$'}1, {u!}${'$'}1} => {ï, ü} / [cons] _ [vowel] // _ ${'$'}1
                Then:
                {t͜s, d͜z} => {ts, dz}
                {ɸ, β} => {f, v}
                {x, ɣ} => {c, j}
                {á, é, í, ó, ú} => {á, é, í, ó, ú}
                {y, w} => {i, u} / _ [vowel nonschwa]
                yə => y'
                wə => w'
                ə => '

            """.trimIndent()
        )

        val exampleWords = listOf(
            "aers",
            "aerso",
            "aersy",
            "aersm",
            "aersi",
            "aersio",
            "aersiy",
            "aersim",
            "am",
            "amo",
            "amy",
            "amm",
            "ami",
            "amio",
            "amiy",
            "amim",
            "amakt",
            "amakto",
            "amakty",
            "amaktm",
            "amakti",
            "amaktio",
            "amaktiy",
            "amaktim",
            "ekaw",
            "ekawo",
            "ekawy",
            "ekawm",
            "ekawi",
            "ekawio",
            "ekawiy",
            "ekawim",
            "et",
            "eto",
            "ety",
            "etm",
            "eti",
            "etio",
            "etiy",
            "etim",
            "éxuil",
            "éxuilo",
            "éxuily",
            "éxuilm",
            "éxuili",
            "éxuilio",
            "éxuiliy",
            "éxuilim",
            "hans",
            "hanso",
            "hansy",
            "hansm",
            "hansi",
            "hansio",
            "hansiy",
            "hansim",
            "haóht",
            "haóhto",
            "haóhty",
            "haóhtm",
            "haóhti",
            "haóhtio",
            "haóhtiy",
            "haóhtim",
            "hiaw",
            "hiawo",
            "hiawy",
            "hiawm",
            "hiawi",
            "hiawio",
            "hiawiy",
            "hiawim",
            "huwa",
            "huwao",
            "huway",
            "huwam",
            "huwai",
            "huwaio",
            "huwaiy",
            "huwaim",
            "huwasior",
            "huwasioro",
            "huwasiory",
            "huwasiorm",
            "huwasiori",
            "huwasiorio",
            "huwasioriy",
            "huwasiorim",
            "huwasiorni",
            "huwasiornio",
            "huwasiorniy",
            "huwasiornim",
            "huwasiornii",
            "huwasiorniio",
            "huwasiorniiy",
            "huwasiorniim",
        )

        val expected = listOf(
            "áares",
            "aazro",
            "aizri",
            "áazrem",
            "aizry",
            "aizrio",
            "aizri",
            "eezrim",
            "am",
            "amo",
            "emi",
            "ámam",
            "emy",
            "emio",
            "emi",
            "emim",
            "amájat",
            "amácato",
            "amáketi",
            "amácatsam",
            "amákety",
            "amaketío",
            "amáketi",
            "amaketim",
            "ejav",
            "ejavo",
            "egejui",
            "ejávam",
            "egejui",
            "egejuio",
            "egejui",
            "egejuim",
            "et",
            "edo",
            "idi",
            "édem",
            "idy",
            "idio",
            "idi",
            "idim",
            "ijuil",
            "ijuilo",
            "ijuili",
            "ijuily'm",
            "ijuily",
            "ijuilio",
            "ijuili",
            "ijuilim",
            "ánas",
            "anzo",
            "enzi",
            "ánzam",
            "ensy",
            "enzio",
            "enzi",
            "enzim",
            "auut",
            "auuto",
            "auuti",
            "aúutsam",
            "auuty",
            "auutío",
            "auuti",
            "auutim",
            "eev",
            "eevo",
            "iijui",
            "éevam",
            "iijui",
            "iijuio",
            "iijui",
            "iijuim",
            "úa",
            "úaa",
            "oojy",
            "oom",
            "úee",
            "oojio",
            "oojy",
            "ooim",
            "uezior",
            "uezioro",
            "ueziori",
            "ueziórom",
            "ueziory",
            "ueziorio",
            "ueziori",
            "ueziorim",
            "ueziorny",
            "ueziornio",
            "ueziorni",
            "ueziornim",
            "ueziorni",
            "ueziornío",
            "ueziorni",
            "ueziornim",
        )

        for ((expectedWord, originalWord) in expected.zip(exampleWords)) {
            ch(originalWord) shouldBe expectedWord
        }
    }

    "This version of the Nusyan sound changes should work consistently" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, mid, high)
                Feature Depth(front, central, back)
                Feature Tone(*neutral, lowtone, hightone, rising, falling)
                Feature Length(*short, long)

                Diacritic ̀  (floating) [lowtone]
                Diacritic ́  (floating) [hightone]
                Diacritic ̌  (floating) [rising]
                Diacritic ̂  (floating) [falling]
                Diacritic ː [long]

                Symbol æ [vowel low front]
                Symbol a [vowel low central]
                Symbol ɑ [vowel low back]
                Symbol e [vowel mid front]
                Symbol ə [vowel mid central]
                Symbol o [vowel mid back]
                Symbol i [vowel high front]
                Symbol ɨ [vowel high central]
                Symbol u [vowel high back]

                Class unvcd {p, t, k}
                Class vcd {b, d, g}
                Class stop {@unvcd, ʔ, @vcd}
                Class fricative {s, h}
                Class nasal {m, n, ŋ}
                Class approximant {w, ɾ, j}
                Class sonorant {@nasal, @approximant}

                Deromanizer:
                    ' => ʔ
                    ng => ŋ
                    nk => ŋk
                    r => ɾ
                    y => j
                    s => z / {{@vcd, @sonorant} _, _ {@vcd, @sonorant}}
                    [vowel]${'$'}1 ${'$'}1 => [long] *

                level-tones:
                    [vowel] => [lowtone] / @vcd @sonorant? _
                    [vowel] => [hightone] / @unvcd @sonorant? _

                devoicing:
                    @vcd => @unvcd
                    z => s

                vowel-shift-early:
                    [long] => [short] / _ ɾ {[cons], ${'$'}}
                    Then:
                    {aː, eː, iː, oː, uː} => {æ, e, i, o, u}
                    {aɾ, eɾ, iɾ, oɾ, uɾ} => {ɑ, æ, e, ɑ, o} / _ {[cons], ${'$'}}
                    {a, e, i, o, u} => {ɑ, i, i, ɑ, u} / _ ${'$'}
                    {a, e, i, o, u} => {ɑ, ə, ɨ, ə, ɨ}
                    Then:
                    {əj, əw, ɨj, ɨw} => {e, o, i, u}
                    {jɨ, wɨ} => {i, u}

                contour-tones:
                    {[lowtone], [neutral vowel]} => {[rising], [hightone]} / _ {s, @sonorant}? @stop {[cons], ${'$'}}
                    {[hightone], [neutral vowel]} => {[falling], [lowtone]} / _ @sonorant? s {[cons], ${'$'}}

                toning-coda-loss:
                    {s, @stop} => * / _ {[cons] [vowel], ${'$'}} // ${'$'} _
                    ʔ => *

                clustered-h-loss:
                    h => * / {[cons] _, _ [cons]}

                full-coda-loss:
                    [vowel] {s, @stop} => [long] * / _ {[cons], ${'$'}} // ${'$'} _

                nasal-assimilation:
                    @nasal => m / _ {p, m}
                    @nasal => n / _ {t, s, ɾ, n, ${'$'}}
                    @nasal => ŋ / _ {k, ŋ, w}

                cluster-reduction:
                    ɾ => * / @stop _
                    Then:
                    {@stop, s} => * / _ {@stop, @fricative, @nasal}
                    s => * / _ ɾ

                Romanizer-on:
                    ŋ => n / _ k
                    ŋ => ng
                    {j, ɾ} => {y, r}

                palatalization:
                    {k, t, s} => {tʃ, tʃ, ʃ} / _ i
                    {kj, tj, sj} => {tʃ, tʃ, ʃ}

                nasal-raising:
                    {[low], [mid]} => {[mid], [high]} / _ @nasal {[cons], ${'$'}}

                vowel-shift-late:
                    {e, eː, o, oː} => {i, iː, u, uː} / @approximant _
                    {* e, * o, ɨ} => {j æ, w ɑ, ə}
                    {* eː, * oː, ɨː} => {j æ, w ɑ, əː}

                fortition:
                    {w, j} => {f, ʃ} // {[cons] _, _ [cons]}

                intervocalic-lenition:
                    {t, s, h} => {ts, h, *} / [vowel] _ [vowel]

                nasal-dropping:
                    [vowel] @nasal => [long] * / _ [cons]

                vowel-coalescence:
                    unchanged

                deaffrication:
                    {tʃ, ts} => {ʃ, s}

                Romanizer-phonetic:
                    unchanged

                Romanizer:
                    [long]${'$'}1 * => ${'$'}1 ${'$'}1
                    Then:
                    [long] => [short]
                    Then:
                    {æ, ə, i, ɑ, u} => {a, e, i, o, u}
                    Then:
                    ŋ => n / _ k
                    ŋ => ng
                    {j, tʃ, ʃ, ɾ} => {y, ch, sh, r}
            """.trimIndent()
        )

        val exampleWords = listOf(
            "sniwsaans",
            "rankahuumsi",
            "rankahuumste",
            "rankahuumsree",
            "wiir",
            "poyginuu",
            "poygist",
            "sreskansi",
            "sreskanste",
            "sreskansree",
            "ksaartobdast",
            "es",
            "estees",
            "en",
            "entees",
            "re",
            "retees",
            "doro",
            "dorotees",
            "gow",
            "gowtees",
            "ktam",
            "ktamtees",
            "dsii",
            "dsiitees",
            "honuu",
            "honuutees",
            "ka",
            "katees",
            "brani",
            "brante",
            "branyin",
            "brankas",
            "branwa",
            "branree",
            "brantsa",
            "branken",
            "bransoo",
            "byorti",
            "byortte",
            "byortree",
            "dati",
            "datte",
            "datree",
            "dorti",
            "dortte",
            "dortree",
            "doski",
            "doskte",
            "doskree",
            "gampi",
            "gampte",
            "gampree",
            "huumsi",
            "huumste",
            "huumsree",
            "hyuungi",
            "hyuungto",
            "hyuungtos'",
            "hyuungtobdast",
            "ksaar'i",
            "ksaarto",
            "ksaartos'",
            "ksaartobdast",
            "mesti",
            "mestte",
            "mestree",
            "naamsi",
            "naamste",
            "naamsree",
            "niidsi",
            "niidste",
            "niidsree",
            "paninuu",
            "pani",
            "panto",
            "pantos'",
            "pantobdast",
            "poygi",
            "poykto",
            "poyktos'",
            "poyktobdast",
            "psansi",
            "psanste",
            "psansree",
            "pursi",
            "purste",
            "pursree",
            "ranki",
            "rankte",
            "rankree",
            "reki",
            "rekte",
            "rekree",
            "sresi",
            "sresto",
            "srestos'",
            "srestobdast",
            "tari",
            "tarto",
            "tartos'",
            "tartobdast",
            "tsonki",
            "tsonkte",
            "tsonkree",
            "wedi",
            "wetto",
            "wettos'",
            "wettobdast",
            "wiiri",
            "wiirte",
            "wiirree",
            "yorbi",
            "yorpte",
            "yorbree",
        )

        val expected = listOf(
            "nusyàn",
            "ruukóuushi",
            "ruukóùùshí",
            "ruukóùùri",
            "fi",
            "pyákènu",
            "pyákěě",
            "rèkwóóshi",
            "rèkwôôshí",
            "rèkwôôri",
            "sosésǒǒ",
            "è",
            "ètyâ",
            "en",
            "eetyâ",
            "ri",
            "retyâ",
            "tèro",
            "tèretyâ",
            "kwò",
            "kwòtyâ",
            "twón",
            "twóótyâ",
            "shi",
            "shityâ",
            "henu",
            "henutyâ",
            "kó",
            "kótyâ",
            "pòni",
            "pwòòshí",
            "pònin",
            "pwòòkô",
            "pwòòwo",
            "pwòòri",
            "pwǒǒso",
            "pwòòkén",
            "pwòòswo",
            "pyòshí",
            "pyǒshí",
            "pyǒrí",
            "tòshí",
            "tǒshí",
            "tǒrí",
            "tòshí",
            "tǒshí",
            "tǒrí",
            "tèshí",
            "těěshí",
            "těěrí",
            "kwòòpí",
            "kwǒǒshí",
            "kwǒǒrí",
            "huushi",
            "hùùshí",
            "hùùri",
            "shungi",
            "shuutó",
            "shuutêê",
            "shuutésǒǒ",
            "soi",
            "sosó",
            "sosêê",
            "sosésǒǒ",
            "mèshí",
            "mééshí",
            "méérí",
            "nyaashi",
            "nyààshí",
            "nyààri",
            "níshi",
            "nííshí",
            "nííri",
            "pónenu",
            "póni",
            "pwóótó",
            "pwóótêê",
            "pwóótésǒǒ",
            "pyáshì",
            "pyásó",
            "pyásêê",
            "pyásésǒǒ",
            "swooshi",
            "swòòshí",
            "swòòri",
            "pwóshi",
            "pwôshí",
            "pwôri",
            "ruushí",
            "rúúshí",
            "rúúrí",
            "reshí",
            "réshí",
            "rérí",
            "reshi",
            "rèsó",
            "rèsêê",
            "rèsésǒǒ",
            "tóri",
            "tósó",
            "tósêê",
            "tósésǒǒ",
            "seeshí",
            "sééshí",
            "séérí",
            "feshì",
            "fésó",
            "fésêê",
            "fésésǒǒ",
            "firi",
            "fishí",
            "firi",
            "shopì",
            "shóshí",
            "shórì",
        ).map { it.normalizeCompose() }

        for ((expectedWord, originalWord) in expected.zip(exampleWords)) {
            ch(originalWord) shouldBe expectedWord
        }
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

        ch("ta'ínki") shouldBe "t’'inki"
        ch("ta'an") shouldBe "t’'an"
    }

    "Henlee's example should work the way they originally tried it" {
        val ch = lsc(
            """
            Feature type(*consonant, vowel)
            Feature low, high
            Feature front, back
            Feature +round
            Feature place(labial, alveolar, postalveolar, palatal, velar, glottal)
            Feature manner(nasal, plosive, fricative, rhotic, liquid, approximant)
            Feature +hightone
            Diacritic ́  (floating) [+hightone]
            
            Symbol i [-low +high +front -back -round vowel]
            Symbol u [-low +high -front +back +round vowel]
            Symbol e [-low -high +front -back -round vowel]
            Symbol o [-low -high -front +back +round vowel]
            Symbol a [+low -high -front -back -round vowel]
            Symbol ɯ [-low +high -front +back -round vowel]
            Symbol m [labial nasal]
            Symbol n [alveolar nasal]
            Symbol ŋ [velar nasal]
            Symbol p [labial plosive]
            Symbol t [alveolar plosive]
            Symbol c [palatal plosive]
            Symbol k [velar plosive]
            Symbol ʔ [glottal plosive]
            Symbol ɸ [labial fricative]
            Symbol s [alveolar fricative]
            Symbol ʃ [postalveolar fricative]
            Symbol ç [palatal fricative]
            Symbol x [velar fricative]
            Symbol h [glottal fricative]
            Symbol ɾ [alveolar rhotic]
            Symbol l [alveolar liquid]
            Symbol ɭ [postalveolar liquid]
            Symbol w [labial velar approximant]
            Symbol j [palatal approximant]
            
            Class consonant {m, n, ŋ, p, t, c, k, ʔ, ɸ, s, ʃ, ç, x, h, ɾ, l, ɭ, w, j}
            Class coda {m, n, ŋ, p, t, k, ʔ, l, ɭ}
            Class vowel {i, u, e, o, a, ɯ}
            Class nasal {m, n, ŋ}
            Class plosive {p, t, c, k, ʔ}
            Class fricative {ɸ, s, ʃ, ç, x}
            Class liquid {ɾ, l, ɭ, j, w}
            Class bilabial {m, p, ɸ}
            Class alveolar {n, t, s, ɾ, l, ɭ}
            Class palatal {ʃ, c, ç}
            Class velar {ŋ, k, x}
            Class front {i, e}
            Class back {u, o, ɯ}
            
            vowel-breaking:
                {ii, uu} => {ai, au}
            #romanizer-old-language:
                #unchanged
            gemination:
                ʔh => ʔ
                then: @consonant${'$'}1 h => ${'$'}1 ${'$'}1
                then: h => *
            nasal-assimilation:
                n => [${'$'}place] / _ [consonant ${'$'}place]
                [nasal] => [${'$'}place] / _ @nasal&[${'$'}place]
            palatalization:
                {t, s, k, x} => {tʃ, ʃ, c, ç} / _ @front
                t => ts / _ @back
            weak-vowel-deletion:
                {i, u} => * / @fricative _ // {${'$'} t? @fricative _ @consonant? ${'$'}, _ @consonant @consonant, @consonant _ @consonant ${'$'}, _ @fricative}
                then: j => * / @palatal _
                      i => * / @coda _ j
                      u => * / @coda _ w
            #romanizer-middle-language:
                #unchanged
            u-unrounding:
                u => [-round] / @consonant _ ${'$'}
            simplification:
                [-low -high] => [+high]
                aa => a / {@vowel _, _ @vowel}
                kc => cc
            rhotacism:
                l => ɾ / {@consonant _, @vowel _ @vowel} // l _
                l l => ɭ ɭ
                l => ɭ / _ ${'$'}
            """.trimIndent()
        )

        val exampleWords = listOf(
            "lúulit",
            "súuluk",
            "nomóló",
            "tal",
            "xét",
            "xát",
            "té",
            "tó",
            "hat",
            "pál",
            "sén",
            "káli",
            "xetó",
            "pitáaʔ",
            "lúma",
            "júki",
            "satkíi",
            "toŋtá",
            "hélhan",
            "nelíi",
            "salíi",
            "patíi",
            "tepíi",
            "kisíi",
            "pósohal",
            "ɸetók",
            "kúuluŋ",
            "tamlíi",
            "katíi",
            "taxeka",
            "siɸúl",
            "kuutóŋ",
            "janínú",
            "hósóta",
        )

        val expected = listOf(
            "láuɾit",
            "sáuɾuk",
            "numúɾú",
            "taɭ",
            "çít",
            "xát",
            "tʃí",
            "tsú",
            "at",
            "páɭ",
            "ʃín",
            "káɾi",
            "çitsú",
            "pitáaʔ",
            "lúma",
            "júci",
            "satkái",
            "tsuŋtá",
            "íɭɭan",
            "niɾái",
            "saɾái",
            "patái",
            "tʃipái",
            "cisái",
            "púsuaɭ",
            "ɸitsúk",
            "káuɾuŋ",
            "tamɾái",
            "katái",
            "taçika",
            "ʃiɸúɭ",
            "kautsúŋ",
            "janínɯ́",
            "úsúta",
        )

        for ((expectedWord, originalWord) in expected.zip(exampleWords)) {
            ch(originalWord) shouldBe expectedWord
        }
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
        "kani'asoto nekosa'ima",
    )

    "This example with tons of features should throw an error quickly" {
        val ch = lsc(
            """
                Feature type(*consonant, vowel)
                Feature low, high, middle
                Feature front, back, central
                Feature round, unround
                Feature +nasalized
                feature +long
                Feature +stressed
                Feature +aspirated
                Feature +ejective
                Feature +labialized
                Feature +lateral

                Feature voicing(unvoiced, voiced)
                Feature place(bilabial, labiodental, dental, alveolar, postalveolar, retroflex, palatal, velar, uvular, epiglottal, glottal)
                Feature manner(nasal, plosive, affricate, fricative, approximate, tap, trill)

                Symbol m [voiced bilabial nasal]
                Symbol n [voiced dental nasal]
                Symbol ŋ [voiced velar nasal]
                Symbol p [unvoiced bilabial plosive]
                Symbol pʼ [unvoiced bilabial plosive +ejective]
                Symbol t [unvoiced dental plosive]
                Symbol tʼ [unvoiced dental plosive +ejective]
                Symbol c [unvoiced palatal plosive]
                Symbol ɟ [voiced palatal plosive]
                Symbol k [unvoiced velar plosive]
                Symbol kʼ [unvoiced velar plosive +ejective]
                Symbol q [unvoiced uvular plosive]
                Symbol qʼ [unvoiced uvular plosive +ejective]
                Symbol ʔ [unvoiced glottal plosive]
                Symbol ɸ [unvoiced bilabial fricative]
                Symbol β [voiced bilabial fricative]
                Symbol ð [voiced dental fricative]
                Symbol s [unvoiced alveolar fricative]
                Symbol z [voiced alveolar fricative]
                Symbol ʃ [unvoiced postalveolar fricative]
                Symbol ʒ [voiced postalveolar fricative]
                Symbol ç [unvoiced palatal fricative]
                Symbol ʝ [voiced palatal fricative]
                Symbol x [unvoiced velar fricative]
                Symbol ɣ [voiced velar fricative]
                Symbol ʀ [voiced uvular trill]
                Symbol j [voiced palatal approximate]

                #vowels

                Symbol i [+unround -round +high -middle -low +front -central -back vowel]
                Symbol iː [+unround -round +high -middle -low +front -central -back +long vowel]
                Symbol ĩ [+unround -round +high -middle -low +front -central -back +nasalized vowel]
                Symbol y [-unround +round +high -middle -low +front -central -back vowel]
                Symbol ỹ [-unround +round +high -middle -low +front -central -back +nasalized vowel]
                Symbol e [+unround -round -high +middle -low +front -central -back vowel]
                Symbol eː [+unround -round -high +middle -low +front -central -back +long vowel]
                Symbol ɛ̃ [+unround -round -high +middle -low +front -central -back +nasalized vowel]
                Symbol ø [-unround +round -high +middle -low +front -central -back vowel]
                Symbol a [+unround -round -high -middle +low +front -central -back vowel]
                Symbol aː [+unround -round -high -middle +low +front -central -back +long vowel]
                Symbol ã [+unround -round -high -middle +low +front -central -back +nasalized vowel]
                Symbol ə [+unround -round -high +middle -low -front +central -back vowel]
                Symbol u [-unround +round +high -middle -low -front -central +back vowel]
                Symbol uː [-unround +round +high -middle -low -front -central +back +long vowel]
                Symbol ũ [-unround +round +high -middle -low -front -central +back +nasalized vowel]
                Symbol o [-unround +round -high +middle -low -front -central +back vowel]
                Symbol oː [-unround +round -high +middle -low -front -central +back +long vowel]
                Symbol õ [-unround +round -high +middle -low -front -central +back +nasalized vowel]
                Symbol ɔ [-unround +round -high -middle +low -front -central +back vowel]
                Symbol ɨ [+unround -round +high -middle -low -front +central -back vowel]
                Symbol ɨː [+unround -round +high -middle -low -front +central -back +long vowel]
                Symbol ɨ̃ [+unround -round +high -middle -low -front +central -back +nasalized vowel]
                Symbol ʌː [+unround -round -high +middle -low -front +central -back +long vowel]
                Symbol ʌ̃ [+unround -round -high +middle -low -front +central -back +nasalized vowel]

                vowel-harmony:
                [-front -central +back +round] => [-front +central -back -round] / _ i
            """.trimIndent()
        )

        shouldThrow<LscRuleNotApplicable> {
            ch("ɔi")
        }
    }

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
            "ʃaniazodo negozaim",
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
            "kan'asto nekos'ima",
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
            "knisoto knosima",
        )

        for ((expectedWord, originalWord) in expected.zip(exampleWords)) {
            ch(originalWord) shouldBe expectedWord
        }
    }

    "The Syllabian example in the web app should work" {
        val ch = lsc(
            """
                Feature +long, +nasalized
                Feature (syllable) stress(*unstressed, primary, secondary)
                Feature (syllable) +heavy
                
                Diacritic ː (floating) [+long]
                Diacritic ̃  (floating) [+nasalized]
                Diacritic ˈ (before) [primary]
                Diacritic ˌ (before) [secondary]
                Diacritic ² [+heavy]
                
                Class vowel {a, ɛ, e, i, ɔ, o, u}
                Class stop {p, t, k, b, d, ɡ}
                Class liquid {r, l, w, j}
                Class nasal {m, n, ŋ}
                Class cons {@stop, s, @nasal, @liquid}
                
                deromanizer:
                    {aa, ee, ii, oo, uu} => {aː, eː, iː, oː, uː}
                    g => ɡ
                    y => j
                
                Syllables:
                    {@cons, @liquid, (@cons @liquid // @vowel _), *} {@vowel @cons, @vowel&[+long]} => [+heavy]
                    {@cons, @liquid, (@cons @liquid // @vowel _), *} @vowel
                
                stress:
                    (
                        <syl> => [primary] / _ <syl>&[-heavy] <syl>&[-heavy] ${'$'}
                        Else:
                        <syl> => [primary] / _ <syl> ${'$'}
                        Else:
                        <syl> => [primary]
                    )
                    Then:
                    (
                        <syl>&[+heavy !primary] => [secondary] / ${'$'} _
                        Else:
                        <syl>&[!primary] => [secondary] / ${'$'} <syl>&[!primary] _
                    )
                    Then propagate:
                        <syl>&[unstressed] => [secondary] / <syl>&[secondary] <syl>&[unstressed] _
                
                make-primary-stress-heavy:
                    @vowel&[primary -heavy] => [+long]
                
                Romanizer-before-syncope:
                    unchanged
                
                syncope:
                    @vowel&[-long unstressed] => *
                    Then:
                    @cons => * / {${'$'} @cons _ @cons, @cons _ @cons ${'$'}}
                
                Syllables:
                    (@cons // @vowel _)? @cons? @vowel @cons? @cons?
                
                drop-syllable-features:
                    <syl>&[+heavy] => [-heavy]
                    Then:
                    <syl>&[secondary] => [unstressed]
                
                nasal-assimilation:
                    @nasal => m / _ {p, b, m}
                    @nasal => n / _ {t, d, n}
                    @nasal => ŋ / _ {k, ɡ, w, ŋ}
                
                shorten:
                    {e!, o!} => {ɛ, ɔ}
                    Then:
                    [+long] => [-long]
                
                nasalization:
                    @vowel @nasal => [+nasalized] * / _ @cons? .
                    Then:
                    {e, i, o, u}&[+nasalized] => {ɛ, e, ɔ, o}
                
                Romanizer-before-glomination:
                    unchanged
                
                glomination:
                    (@liquid / @cons _)? ${'$'}${'$'} => *
                
                stress-shift:
                    <syl>&[primary] => [unstressed]
                    Then:
                    <syl> => [primary] / ${'$'} _
                
                Syllables:
                    clear
            """.trimIndent()
        )

        val input = listOf(
            "pan",
            "pana",
            "epina",
            "karapuna",
            "sebnakulia",
            "salimiska",
            "kalima",
            "mataratagunta",
            "santabratagunta",
            "taapiruuga",
            "keemiitasa",
            "teyoomi",
            "lademura",
            "lademsura",
            "ladetura mat",
            "ladetsura mat",
        )

        val expected = listOf(
            "pã",
            "pã",
            "epn",
            "krapn",
            "sɛbŋkul",
            "slimisk",
            "kalm",
            "ntartaɡõt",
            "sãtbratɡõt",
            "tapruɡ",
            "kemits",
            "tjɔ̃",
            "ldɛ̃r",
            "ldɛ̃r",
            "ldetmat",
            "ldɛtmat",
        )

        for ((expectedWord, originalWord) in expected.zip(input)) {
            ch(originalWord) shouldBe expectedWord
        }
    }

    "This silly test should work" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                
                Symbol a [vowel]
                
                k-only:
                    !k => * / {[cons] _, _ [cons]}
            """.trimIndent()
        )

        ch("ka") shouldBe "k"
    }
})