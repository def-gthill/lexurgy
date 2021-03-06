package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.SyllableStructureViolated
import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestSyllables : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "Sound changes should work across explicit syllable boundaries" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Syllables:
                    explicit
                intervocalic-voicing:
                    {p, t, k} => {b, d, g} / @vowel _ @vowel
                t-assimilation:
                    {pt, kt} => tt
            """.trimIndent()
        )

        ch("ko.li.mo") shouldBe "ko.li.mo"
        ch("k.opi.mo") shouldBe "k.obi.mo"
        ch("ko.pi.ko") shouldBe "ko.bi.go"
        ch("kop.tik.to") shouldBe "kot.tit.to"
    }

    "We should be able to define automatic syllabification rules" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, b, d, g, s, m, n, l, r}
                Syllables:
                    @cons @vowel
            """.trimIndent()
        )

        ch("kolimo") shouldBe "ko.li.mo"
        ch("tiramisu") shouldBe "ti.ra.mi.su"

        shouldThrow<SyllableStructureViolated> {
            ch("katmandu")
        }.also {
            it.message shouldBe
                    "The segment \"t\" in \"ka(t)mandu\" doesn't fit the syllable structure"
        }
    }

    "We should be able to use complex structures in syllabification rules" {
        val ch = lsc(
            """
                Feature type(*cons, vowel)
                Feature height(low, mid, high)
                Feature frontness(front, central, back)
                Symbol a [low central vowel]
                Symbol e [mid front vowel]
                Symbol i [high front vowel]
                Symbol o [mid back vowel]
                Symbol u [high back vowel]
                Syllables:
                    s? {{p, t, k} r, [cons]} [vowel] [cons]? // [vowel] _
                    [cons] [vowel] [cons]?
            """.trimIndent()
        )

        ch("jaksprat") shouldBe "jak.sprat"
        ch("wisnagnit") shouldBe "wis.nag.nit"

        shouldThrow<SyllableStructureViolated> { ch("mtar") }
        shouldThrow<SyllableStructureViolated> { ch("antki") }
    }

    "Syllabification should proceed left-to-right, always choosing the shortest syllable that doesn't cause subsequent syllables to fail" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel (t s)?
            """.trimIndent()
        )

        ch("patso") shouldBe "pats.o"
    }

    "Words that have been automatically syllabified should be re-syllabified after every named rule" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                r-drop:
                    r => * / @cons _
                hiatus-collapse:
                    {ea, oa, ae, ao} => a
            """.trimIndent()
        )

        ch("patran") shouldBe "pa.tan"
        ch("kaonira") shouldBe "ka.ni.ra"
    }

    "The <syl> token should match any single syllable" {
        val ch = lsc(
            """
                Feature +stress
                Diacritic ˈ (before) (floating) [+stress]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                stress-penult:
                    @vowel => [+stress] / _ @cons? <syl> $
            """.trimIndent()
        )

        ch("kopiko") shouldBe "ko.pˈi.ko"
        ch("maria") shouldBe "ma.rˈi.a"
        ch("salamanka") shouldBe "sa.la.mˈan.ka"

        val ch2 = lsc(
            """
                Feature +stress
                Diacritic ˈ (before) (floating) [+stress]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                stress-second:
                    @vowel => [+stress] / $ <syl> @cons? _
            """.trimIndent()
        )

        ch2("kopiko") shouldBe "ko.pˈi.ko"
        ch2("maria") shouldBe "ma.rˈi.a"
        ch2("salamanka") shouldBe "sa.lˈa.man.ka"
    }

    "<syl> should match the entirety of a one-syllable word" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                    I+ / _ $
                tally-syllables:
                    <syl> => I
            """.trimIndent()
        )

        ch("kopiko") shouldBe "III"
        ch("sampo") shouldBe "II"
        ch("tal") shouldBe "I"
    }

    "We should be able to declare and reference syllable-level features" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Class vowel {a, æ, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                stress-penult:
                    <syl> => [+stress] / _ <syl> $
                stress-raising:
                    a&[+stress] => æ
            """.trimIndent()
        )

        ch("piko") shouldBe "ˈpi.ko"
        ch("kopiko") shouldBe "ko.ˈpi.ko"
        ch("maria") shouldBe "ma.ˈri.a"
        ch("salamanka") shouldBe "sa.la.ˈmæn.ka"
    }

    "We should get an error if we try to mix features from different levels on a diacritic" {
        shouldThrow<LscInvalidFeatureLevel> {
            lsc("Feature (syllable) +stress\nFeature +long\nDiacritic ˈː [+stress +long]")
        }
    }

    "We should get an error if we try to give symbols syllable-level diacritics" {
        shouldThrow<LscInvalidFeatureLevel> {
            lsc("Feature (syllable) +stress\nSymbol o [+stress]")
        }
    }

    "We should be able to assign syllable-level features in the syllabification rules" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Feature (syllable) sylType(light, heavy)
                Feature +long
                Diacritic ˈ (before) [+stress]
                Diacritic ¹ [light]
                Diacritic ² [heavy]
                Diacritic ː (floating) [+long]
                Class vowel {a, e, i, o, u}
                Class diphthong {aj, oj}
                Class cons {p, t, k, b, d, g, f, s, h, m, n, l, r, w}
                Syllables:
                    @cons? {@vowel, @diphthong} @cons => [heavy]
                    @cons? @diphthong => [heavy]
                    @cons? @vowel&[+long] => [heavy]
                    @cons? @vowel => [light]
                stress:
                    <syl>&[heavy] => [+stress] / _ <syl> $
                    Else:
                    <syl> => [+stress] / _ <syl> <syl> $
                coda-dropping:
                    @cons => * / _ @cons
            """.trimIndent()
        )

        ch("feːminaj") shouldBe "ˈfeː².mi¹.naj²"
        ch("pueroː") shouldBe "ˈpu¹.e¹.roː²"
        ch("wolukris") shouldBe "wo¹.ˈlu¹.ris²"
        ch("wideːre") shouldBe "wi¹.ˈdeː².re¹"
    }

    "We should be able to return syllable-level features to their default values" {
        val ch = lsc(
            """
                Feature (syllable) +stress, (syllable) +test
                Diacritic ˈ (before) [+stress]
                Diacritic ^ [+test]
                Syllables:
                    explicit
                remove-stress:
                    <syl>&[+stress] => [-stress]
            """.trimIndent()
        )

        ch("ˈfu.ba") shouldBe "fu.ba"
        ch("ka.lu.ˈma") shouldBe "ka.lu.ma"
        ch("con.ˈtest^") shouldBe "con.test^"
        ch("ˈtest^") shouldBe "test^"
    }

    "Syllable-level features should persist through other kind of rules" {
        val ch = lsc(
            """
                Feature +long, (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Diacritic ː [+long]
                Syllables:
                    explicit
                shorten:
                    [+long] => [-long]
                vowel-shift:
                    u! => y
            """.trimIndent()
        )

        ch("ˈfoː.baːr") shouldBe "ˈfo.bar"
        ch("ˈfu.bar") shouldBe "ˈfy.bar"
    }

    "Syllable-level features should stay as close to their original sounds as possible when resyllabifying" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    (@cons // @vowel _)? @cons? @vowel @cons?
                stress-penult:
                    <syl> => [+stress] / _ <syl> $
                syncope:
                    @vowel => * / _ <syl>&[+stress]
                final-mid-loss:
                    {e, o} => * / _ $
            """.trimIndent()
        )

        ch("kamina") shouldBe "ˈkmi.na"
        ch("arensa") shouldBe "ˈren.sa"
        ch("akamina") shouldBe "ak.ˈmi.na"
        ch("akamine") shouldBe "ak.ˈmin"
    }

    "We should be able to change syllable structure partway through the rules" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                stress-penult:
                    <syl> => [+stress] / _ <syl> $
                syncope:
                    @vowel => * / _ <syl>&[+stress]
                Syllables:
                    (@cons // @vowel _)? @cons? @vowel @cons?
            """.trimIndent()
        )

        ch("kamina") shouldBe "ˈkmi.na"
        ch("arensa") shouldBe "ˈren.sa"
    }
})