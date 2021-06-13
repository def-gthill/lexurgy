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

    "!We should be able to use complex structures in syllabification rules" {
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

        ch("ratsplat") shouldBe "rat.splat"
        ch("wisnagnit") shouldBe "wis.nag.nit"

        shouldThrow<SyllableStructureViolated> { ch("mtar") }
        shouldThrow<SyllableStructureViolated> { ch("antki")}
    }
})