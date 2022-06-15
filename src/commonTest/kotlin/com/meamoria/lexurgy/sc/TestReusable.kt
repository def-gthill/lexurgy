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

    // We should be able to turn them off
    // They should run for the first time when declared
    // They should run BEFORE resyllabification (so they can correct syllable structure errors)
    // The "cleanup" modifier should be invalid in blocks
})