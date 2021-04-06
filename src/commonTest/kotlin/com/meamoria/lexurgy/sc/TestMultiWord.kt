package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestMultiWord : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "Spaces in a line should delimit separate words" {
        val ch = lsc(
            """
                drop-final-t:
                    t => * / _ $
            """.trimIndent()
        )

        ch("sit amet") shouldBe "si ame"
    }

    "We should be able to delete the $$ token to join words together" {
        val ch = lsc(
            """
                Feature Stress(*unstressed, stressed)
                Diacritic ˈ (floating) [stressed]
                Class vowel {a, e, i, o, u}
                
                stress-first-syllable @vowel:
                    @vowel => [stressed] / $ _
                
                stress-raising:
                    {eˈ, oˈ} => {iˈ, uˈ}
                
                tapping:
                    t => ɾ / @vowel _ @vowel
                
                glomination:
                    $$ => *
                    Then:
                    [stressed] => [unstressed] / [stressed] [unstressed]* _
                
                intervocalic-lenition:
                    {p, t, k} => {b, d, g} / @vowel _ @vowel
            """.trimIndent()
        )

        ch("sit amet") shouldBe "siˈdamet"
        ch("ko peko") shouldBe "kuˈbigo"
        ch("mate kupo tonumeka") shouldBe "maˈɾegubodunumega"
    }

    "We should be able to join words conditionally" {
        val ch = lsc(
            """
                selective-glomination:
                    $$ => * / t _
                    $$ => * / _ s
            """.trimIndent()
        )

        ch("sit amet") shouldBe "sitamet"
        ch("cogito ergo sum") shouldBe "cogito ergosum"
    }

    "We should be able to implement sandhi rules by using $$ in the environment" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                mutation:
                    {p, t, k} => {b, d, g} / @vowel $$ _
            """.trimIndent()
        )

        ch("rumpa pum pum") shouldBe "rumpa bum pum"
        ch("skupi tupi tu") shouldBe "skupi dupi du"
    }

    "We should be able to implement rules that apply within words *and* across word boundaries" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                lenition:
                    {p, t, k} => {b, d, g} / @vowel $$? _
            """.trimIndent()
        )

        ch("rumpa pum pum") shouldBe "rumpa bum pum"
        ch("skupi tupi tu") shouldBe "skubi dubi du"
    }

    "We should be able to split words by turning elements into $$" {
        val ch = lsc(
            """
                Feature height(high, mid, low)
                Feature frontness(front, central, back)
                Symbol a [low central]
                Symbol e [mid front]
                Symbol i [high front]
                Symbol o [mid back]
                Symbol u [high back]
                
                split-at-high:
                    [high] => $$
            """.trimIndent()
        )

        ch("haniatuma") shouldBe "han at ma"

        val ch2 = lsc(
            """
                split-between-a:
                    * => $$ / a _ a
            """.trimIndent()
        )

        ch2("knaan aardvark") shouldBe "kna an a ardvark"
    }
})