package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestReusable : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

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

    // Syllabification rules and cleanup rules should "break each others' connections" to
    // the previous rule.

    // The "cleanup" modifier should be invalid in blocks
})