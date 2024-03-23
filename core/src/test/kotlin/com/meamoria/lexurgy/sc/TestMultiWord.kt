package com.meamoria.lexurgy.sc

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestMultiWord : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "Spaces in a line delimit separate words" {
        val ch = lsc(
            """
                drop-final-t:
                    t => * / _ $
            """.trimIndent()
        )

        ch("sit amet") shouldBe "si ame"
    }

    "We can delete the $$ token to join words together" {
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

    "We can join words conditionally" {
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

    "We can implement sandhi rules by using $$ in the environment" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                mutation:
                    {p, t, k} => {b, d, g} / @vowel $$ _ @vowel
            """.trimIndent()
        )

        ch("rumpa pum pum") shouldBe "rumpa bum pum"
        ch("skupi tupi tu") shouldBe "skupi dupi du"

        val ch2 = lsc(
            """
                Class vowel {a, e, i, o, u}
                rebracketing:
                    * => n / n $$ _ @vowel
                    Then: n => * / _ $$ n
            """.trimIndent()
        )

        ch2("an ewt") shouldBe "a newt"
        ch2("an head") shouldBe "an head"
    }

    "We can implement rules that apply within words *and* across word boundaries" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                lenition:
                    {p, t, k} => {b, d, g} / @vowel $$? _ @vowel
            """.trimIndent()
        )

        ch("rumpa pum pum") shouldBe "rumpa bum pum"
        ch("skupi tupi tu") shouldBe "skubi dubi du"
    }

    "We can split words by turning elements into $$" {
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

    "We can use $$ in alternative lists" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                selective-lenition:
                    {p, t, k} => {b, d, g} / {a $$, @vowel} _ @vowel
            """.trimIndent()
        )

        ch("rumpa pum pum") shouldBe "rumpa bum pum"
        ch("skupi tupi tu") shouldBe "skubi tubi tu"
    }

    "We can transform sequences including word boundaries" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                messy-glomination:
                    @vowel? $$ h? => * / _ @vowel
            """.trimIndent()
        )

        ch("ek ana eta hona") shouldBe "ekanetona"
    }

    "Tab characters separate columns" {
        val ch = lsc(
            """
                make-b:
                    a => b / $ _
                delete-boundaries:
                    $$ => *
            """.trimIndent()
        )

        ch("aaa\taaa aaa") shouldBe "baa\tbaabaa"
    }

//    "We should be able to capture sequences containing word boundaries" {
//        val ch = lsc(
//            """
//                Class vowel {a, e, i, o, u}
//                Class consonant {p, t, k, s, n, l}
//                goofy-swap:
//                    (@consonant $$ @consonant)$1 @vowel$2 (@consonant $$ @consonant)$3 => $3 $2 $1
//            """.trimIndent()
//        )
//
//        ch("cat lap sore") shouldBe "cap sat lore"
//    }
})