package com.meamoria.lexurgy.sc

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestPartialRuns : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "Start-at ignores all anchored steps before the start rule" {
        val ch = lsc(
            """
                    syllables:
                        C V+
                        
                    clusters cleanup:
                        C => * / $ _ C
                        
                    hiatus cleanup:
                        V => * / V _
                        
                    syllables:
                        C V
                    
                    rule1:
                        C => C C / $ _
                        
                    syllables:
                        C C V
                        C V
                        
                    clusters:
                        off
    
                    another-rule:
                        unchanged
                        
                    rule2:
                        unchanged
                        
                """.trimIndent()
        )

        ch.change(listOf("CVCVV")) shouldBe listOf("CV.CV")
        ch.change(listOf("CCVCV"), startAt = "rule2") shouldBe listOf("CCV.CV")
    }

    "Start-at ignores all anchored steps before the start rule, including immediately before" {
        val ch = lsc(
            """
                    syllables:
                        C V+
                        
                    clusters cleanup:
                        C => * / $ _ C
                        
                    hiatus cleanup:
                        V => * / V _
                        
                    syllables:
                        C V
                    
                    rule1:
                        C => C C / $ _
                        
                    syllables:
                        C C V
                        C V
                        
                    clusters:
                        off
                        
                    rule2:
                        unchanged
                        
                """.trimIndent()
        )

        ch.change(listOf("CVCVV")) shouldBe listOf("CV.CV")
        ch.change(listOf("CCVCV"), startAt = "rule2") shouldBe listOf("CCV.CV")
    }

    "Stop-before runs cleanup rules and syllabification anchored to the stop rule" {
        val ch = lsc(
            """
                    syllables:
                        C V+
                        
                    clusters cleanup:
                        C => * / $ _ C
                        
                    hiatus cleanup:
                        V => * / V _
                        
                    syllables:
                        C V
                    
                    rule1:
                        C => C C / $ _
                        
                    syllables:
                        C C V
                        C V
                        
                    clusters:
                        off
                        
                    rule2:
                        C => CC
                        
                """.trimIndent()
        )

        ch.change(listOf("CVCVV")) shouldBe listOf("CCV.CCV")
        ch.change(listOf("CVCVV"), stopBefore = "rule2") shouldBe listOf("CV.CV")
    }
})