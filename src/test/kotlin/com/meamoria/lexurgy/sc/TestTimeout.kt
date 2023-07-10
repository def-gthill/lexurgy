package com.meamoria.lexurgy.sc

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class TestTimeout : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "A timeout can stop an exploding rule" {
        val ch = lsc(
            """
                explode propagate:
                 a => aa
            """.trimIndent()
        )

        shouldThrow<RunTimedOut> {
            ch.change(listOf("a", "a", "a", "a"), timeoutSeconds = 0.1)
        }
    }
})
