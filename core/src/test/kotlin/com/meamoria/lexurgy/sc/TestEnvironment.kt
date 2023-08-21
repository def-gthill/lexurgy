package com.meamoria.lexurgy.sc

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestEnvironment : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to restrict changes to a specific environment" {
        val ch = lsc(
            """
               |Feature Depth(front, back)
               |Feature Place(alv, pal, vel)
               |Symbol i [front]
               |Symbol u [back]
               |Symbol t [alv]
               |Symbol tʃ [pal]
               |Symbol k [vel]
               |soft-c:
               |    [alv] => [pal] / _ [front]
               |    [vel] => [pal] / _ [front]
            """.trimMargin()
        )

        ch("kikuki") shouldBe "tʃikutʃi"
        ch("tutit") shouldBe "tutʃit"
    }

    "We should be able to prevent changes from happening in a specific environment" {
        val ch1 = lsc(
            """
               |simple:
               |    k => x / a _ // _ a
               |complex:
               |    p => f / {a _, e _} // {_ a, _ e}
            """.trimMargin()
        )

        ch1("akakekak") shouldBe "akaxekax"
        ch1("apapepipapu") shouldBe "apapefipafu"

        val ch2 = lsc(
            """
               |Feature Manner(stop, fric)
               |Feature Place(lab, alv, vel)
               |Symbol p [stop lab]
               |Symbol t [stop alv]
               |Symbol k [stop vel]
               |Symbol f [fric lab]
               |Symbol s [fric alv]
               |Symbol x [fric vel]
               |different-stops:
               |    [stop ${'$'}Place] => [fric] / _ [stop] // _ [${'$'}Place]
            """.trimMargin()
        )

        ch2("aptekpa") shouldBe "aftexpa"
        ch2("atteppa") shouldBe "atteppa"
    }

    "A change should still proceed even if its environment is also changing" {
        val ch = lsc(
            """
                dissimilate:
                e => i / e _
                i => e / i _
            """.trimIndent()
        )

        ch("beeeeeeee") shouldBe "beiiiiiii"
        ch("beeiieeii") shouldBe "beiieeiie"
    }

    "We should be able to specify multiple possible environments for a change" {
        val ch1 = lsc(
            """
                boundary-h-drop:
                h => * / {$ _, _ $}
            """.trimIndent()
        )

        ch1("hahahahah") shouldBe "ahahaha"

        val ch2 = lsc(
            """
                fancy-frication:
                {p, t, k} => {f, ts, x} / {_ a, {a, e, i, o, u} _ {e, i, o, u}}
            """.trimIndent()
        )

        ch2("patika") shouldBe "fatsixa"
        ch2("topeka") shouldBe "tofexa"
        ch2("tentaklop") shouldBe "tentsaklop"
    }

    "We should be able to nest environments (i.e. lookahead/lookbehind) inside other structures" {
        val ch = lsc(
            """
                Feature +hitone
                Diacritic ́  (floating) [+hitone]
                Class vowel {a, e, i, o, u}
                Class uvstop {p, t, k}
                Class vstop {b, d, g}
                Class cons {@uvstop, @vstop, s, m, n, l}
                coda-tone:
                    @vowel (@cons*)$1 {@uvstop / @cons _, @uvstop} => [+hitone] $1 {*, @vstop}
            """.trimIndent()
        )

        ch("anast") shouldBe "anás"
        ch("anat") shouldBe "anád"
        ch("analski") shouldBe "análsi"
        ch("anaki") shouldBe "anági"
        ch("anals") shouldBe "anals"

        val ch2 = lsc(
            """
                partial-condition:
                    {{b, d, g} / _ $, {pʰ, tʰ, kʰ}} => {p, t, k}
            """.trimIndent()
        )

        ch2("pʰotatʰo") shouldBe "potato"
        ch2("aragog") shouldBe "aragok"
    }

    "This complex syllabification shouldn't hang the parser" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class glide {j, w}
                Class nasal {n, m}
                Class cons {p, t, k, @nasal, @glide}
                
                Syllables:
                 {(@cons // {@vowel, @nasal} _)? @cons, @cons? @glide}? @vowel @cons? @cons?
            """.trimIndent()
        )

        ch("akja") shouldBe "a.kja"
        ch("ktentka") shouldBe "ktent.ka"
    }
})