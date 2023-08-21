package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.element.LscTooManyOptions
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.types.shouldBeInstanceOf

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

    "A timeout can stop catastrophic backtracking" {
        val ch = lsc(
            """
                catastrophic:
                    (x+ x+)+ y => q
            """.trimIndent()
        )

        shouldThrow<RunTimedOut> {
            ch.change(listOf("x".repeat(30)), timeoutSeconds = 0.1)
        }.also { it.reason.shouldBeInstanceOf<LscTooManyOptions>()}
    }
})
