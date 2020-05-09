package com.meamoria.lexurgy.sc

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestSoundChanger : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to declare a simple character-to-character change rule" {
        val ch = lsc(
            """
                a-rule:
                x=>h
            """.trimIndent()
        )

        ch("maxel") shouldBe "mahel"
        ch("expexax") shouldBe "ehpehah"
    }
})