package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestSyllables : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "Sound changes should work across explicit syllable boundaries" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Syllables:
                    default
                intervocalic:
                    {p, t, k} => {b, d, g} / @vowel _ @vowel
            """.trimIndent()
        )

        ch("ko.pi.ko") shouldBe "ko.bi.go"
    }
})