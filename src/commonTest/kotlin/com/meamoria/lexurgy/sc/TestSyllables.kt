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
                    "The segment \"n\" in \"katma(n)du\" doesn't fit the syllable structure"
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
        shouldThrow<SyllableStructureViolated> { ch("antki")}
    }

    "Words that have been automatically syllabified should be re-syllabified after every simple rule" {
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
})