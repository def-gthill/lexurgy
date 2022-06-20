package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestReusable : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to declare reusable elements" {
        val ch = lsc(
            """
                Feature +foo, +bar
                Diacritic ᶠ [+foo]
                Diacritic ᵇ [+bar]
                
                Element fooOrBar {[+foo], [+bar]}
                
                from-foo-or-bar:
                    @fooOrBar => x
                
                to-foo-or-bar:
                    {o, a} => @fooOrBar
                
                conditional-on-foo-or-bar:
                    e => i / @fooOrBar _
            """.trimIndent()
        )

        ch("reᶠurᵇish") shouldBe "rxuxish"
        ch("potato") shouldBe "poᶠtaᵇtoᶠ"
        ch("oeaee") shouldBe "oᶠiaᵇie"
    }

    "We should be able to declare \"cleanup\" rules that run after every rule" {
        val ch = lsc(
            """
                combine-ai cleanup:
                    ai => e
                
                rule-1:
                    b => i
                rule-2:
                    ec => i
                rule-3:
                    ed => i
            """.trimIndent()
        )

        ch("aaabcd") shouldBe "e"
    }

    "We should be able to turn off \"cleanup\" rules" {
        val ch = lsc(
            """
                combine-ai cleanup:
                    ai => e
                
                rule-1:
                    b => i
                rule-2:
                    ec => i
                
                combine-ai:
                    off
                
                rule-3:
                    ed => i
            """.trimIndent()
        )

        ch("aaabcd") shouldBe "ai"
    }

    "Cleanup rules should run for the first time when declared" {
        val ch = lsc(
            """
                combine-ai cleanup:
                    ai => e
                
                rule-1:
                    eb => i
                rule-2:
                    ec => i
                rule-3:
                    ed => i
            """.trimIndent()
        )

        ch("aaaaibcd") shouldBe "e"
    }

    "We should be able to have multiple cleanup rules with overlapping scope" {
        val ch = lsc(
            """
                combine-ai cleanup:
                    ai => e
                
                rule-1:
                    ek => i
                    Then:
                    t => k
                
                combine-x cleanup:
                    ks => x
                
                rule-2:
                    * => aiks / _ $
                
                combine-ai:
                    off
                
                rule-3:
                    * => aiks / _ $
            """.trimIndent()
        )

        ch("aiksets") shouldBe "isexexaix"
    }

    "Persisting cleanup rules should run BEFORE persisting resyllabification rules" {
        val ch = lsc(
            """
                Class cons {p, t, k, n, s, r, l, h}
                Class vowel {a, e, i, o, u}
                
                Syllables:
                    @cons @vowel
                
                resolve-hiatus cleanup:
                    {ai, au} => {e, o}
                    @vowel => * / @vowel _
                
                drop-h:
                    h => *
            """.trimIndent()
        )

        ch("sahitahunuhi") shouldBe "se.to.nu"
    }

    "Persisting syllabification rules should run BETWEEN a new cleanup rule and a following romanizer" {
        val ch = lsc(
            """
                Syllables:
                    {ba, na, ben, en, e}
                
                rule:
                    * => i / a _
                
                combine-ai cleanup:
                    ai => e
                
                romanizer-x:
                    unchanged
                
                rule-2:
                    e => i
                
                Syllables:
                    clear
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("banana")) shouldBe
                mapOf("x" to listOf("ben.en.e"), null to listOf("binini"))
    }

    "Persisting syllabification rules should run BEFORE any intermediate romanizers" {
        val ch = lsc(
            """
                Syllables:
                    {ba, na, ben, en, e}
                
                rule:
                    a => e
                
                romanizer-x:
                    unchanged
                
                rule-2:
                    e => i
                
                Syllables:
                    clear
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("banana")) shouldBe
                mapOf("x" to listOf("ben.en.e"), null to listOf("binini"))
    }

    "The \"cleanup\" modifier should be invalid in blocks" {
        shouldThrow<LscInvalidModifier> {
            lsc(
                """
                    rule:
                        unchanged
                        Then cleanup:
                        unchanged
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "Invalid modifier \"cleanup\" applied to \"<Then>\""
        }
    }
})