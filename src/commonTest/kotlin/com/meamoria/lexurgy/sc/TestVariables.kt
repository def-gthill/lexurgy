package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldBeInstanceOf
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestVariables : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to implement gemination and degemination with captures" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class fricative {f, s, x}
                stop-gemination:
                h @stop$1 => $1 $1
                fricative-degemination:
                @fricative$1 => * / _ $1
            """.trimIndent()
        )

        ch("ahpessi") shouldBe "appesi"
        ch("ifsehkasxo") shouldBe "ifsekkasxo"
    }

    "We should be able to implement gemination and degemination with matrix captures" {
        val ch = lsc(
            """
                Feature Manner(stop, fricative)
                Feature Place(labial, alveolar, velar)
                Symbol p [labial stop]
                Symbol t [alveolar stop]
                Symbol k [velar stop]
                Symbol f [labial fricative]
                Symbol s [alveolar fricative]
                Symbol x [velar fricative]
                stop-gemination:
                h [stop]$1 => $1 $1
                fricative-degemination:
                [fricative]$1 => * / _ $1
            """.trimIndent()
        )

        ch("ahpessi") shouldBe "appesi"
        ch("ifsehkasxo") shouldBe "ifsekkasxo"
        // Tests that we don't get crashes if the rule is looking for a geminate off the end of the word.
        ch("affes") shouldBe "afes"
    }

    "We should be able to implement metathesis with captures" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class fricative {f, s, x}
                Class vowel {a, e, i, o, u}
                metathesis:
                @stop$1 @fricative$2 => $2 $1 / @vowel _ @vowel
            """.trimIndent()
        )

        ch("taksidepsi") shouldBe "taskidespi"
        ch("fnitficuts") shouldBe "fnifticuts"
    }

    "We should be able to reference captured segments in the before environment" {
        val ch = lsc(
            """
                Feature manner(stop)
                Feature place(labial, alveolar, velar)
        
                Symbol p [labial stop]
                Symbol t [alveolar stop]
                Symbol k [velar stop]
                
                Class vowel {a, e, i, o, u}
        
                geminate-switch:
                 [stop]${'$'}1 @vowel${'$'}2 => ${'$'}2 ${'$'}1 / ${'$'}1 _ ${'$'}
            """.trimIndent()
        )

        ch("natta") shouldBe "natat"
        ch("napta") shouldBe "napta"
        ch("nanna") shouldBe "nanna"
    }

    "We should be able to reference captured segments in the before part of an exclusion" {
        val ch = lsc(
            """
                Feature manner(stop)
                Feature place(labial, alveolar, velar)
        
                Symbol p [labial stop]
                Symbol t [alveolar stop]
                Symbol k [velar stop]
                
                Class vowel {a, e, i, o, u}
        
                add-vowel-after-stops:
                 [stop]${'$'}1 @vowel${'$'}2 => ${'$'}2 ${'$'}1 / _ $ // ${'$'}1 _
            """.trimIndent()
        )

        ch("natta") shouldBe "natta"
        ch("napta") shouldBe "napat"
        ch("nanna") shouldBe "nanna"
    }

    "We should be able to bind a variable before and reference after" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class vowel {a, e, i, o, u}
                drop-between-identical-stops:
                    @vowel => * / @stop$1 _ $1
            """.trimIndent()
        )

        ch("natata") shouldBe "natta"
        ch("napata") shouldBe "napata"
    }

    "We should be able to bind a variable in the condition and reference it in the exclusion" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class vowel {a, e, i, o, u}
                drop-between-non-identical-stops:
                    @vowel => * / @stop$1 _ // _ $1
            """.trimIndent()
        )

        ch("natata") shouldBe "natat"
        ch("napata") shouldBe "napt"
    }

    "We should be able to bind character sequences without the reversing causing trouble" {
        val ch = lsc(
            """
                silly:
                    a => * / {tr, cl}$1 _ $1
            """.trimIndent()
        )

        ch("atratra") shouldBe "atrtra"
        ch("aclacla") shouldBe "aclcla"
        ch("atrarta") shouldBe "atrarta"
    }

    "Different environments should keep different variables" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                
                stop-extrusion:
                 * => $1 / {$ @stop$1 _, _ @stop$1 $}
            """.trimIndent()
        )

        ch("tam") shouldBe "ttam"
        ch("dalek") shouldBe "dalekk"
        ch("matam") shouldBe "matam"
    }

    "Capturing multiple things with the same capture number should result in a LscReboundCapture" {
        val badTemplate = """
            Class stop {p, t, k}
            bad-rule:
        """.trimIndent()

        shouldThrow<LscRuleNotApplicable> {
            val ch = lsc("$badTemplate\n* => i / _ @stop$1 @stop$1")
            ch("ppa")
        }.also {
            it.cause.shouldBeInstanceOf<LscReboundCapture>()
            it.message shouldBe
                    "Rule bad-rule could not be applied to word ppa (originally ppa)\n" +
                    "Capture variable 1 is bound more than once; " +
                    "replace the second with a capture reference (\"${'$'}1\")"
        }

        shouldThrow<LscRuleNotApplicable> {
            val ch = lsc("$badTemplate\n@stop$1 => * / _ @stop$1")
            ch("ppa")
        }

        shouldThrow<LscRuleNotApplicable> {
            val ch = lsc("$badTemplate\n(@stop$1)+ => * / _ a")
            ch("ppa")
        }
    }
})