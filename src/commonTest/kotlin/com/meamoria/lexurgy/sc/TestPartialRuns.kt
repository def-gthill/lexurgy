package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe

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

        ch.change(listOf("CVCV")) shouldBe listOf("CV.CV")
        ch.change(listOf("CCVCVV"), startAt = "rule2") shouldBe listOf("CCV.CV")
    }
})