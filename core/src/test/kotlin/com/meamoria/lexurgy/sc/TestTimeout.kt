package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.element.LscTooManyOptions
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

@Suppress("unused")
class TestTimeout : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "A total timeout can stop an exploding rule" {
        val ch = lsc(
            """
                explode propagate:
                 a => aa
            """.trimIndent()
        )

        shouldThrow<RunTimedOut> {
            ch.change(listOf("a", "a", "a", "a"), totalTimeoutSeconds = 0.1)
        }.also { it.reason.shouldBeInstanceOf<LscDivergingPropagation>() }
    }

    "A single-step timeout can stop an exploding rule" {
        val ch = lsc(
            """
                explode propagate:
                 a => aa
            """.trimIndent()
        )

        shouldThrow<RunTimedOut> {
            ch.change(listOf("a", "a", "a", "a"), singleStepTimeoutSeconds = 0.1)
        }.also { it.reason.shouldBeInstanceOf<LscDivergingPropagation>() }
    }

    "A total timeout can stop catastrophic backtracking" {
        val ch = lsc(
            """
                catastrophic:
                    (x+ x+)+ y => q
            """.trimIndent()
        )

        shouldThrow<RunTimedOut> {
            ch.change(listOf("x".repeat(30)), totalTimeoutSeconds = 0.1)
        }.also { it.reason.shouldBeInstanceOf<LscTooManyOptions>()}
    }

    "A single-step timeout can stop catastrophic backtracking" {
        val ch = lsc(
            """
                catastrophic:
                    (x+ x+)+ y => q
            """.trimIndent()
        )

        shouldThrow<RunTimedOut> {
            ch.change(listOf("x".repeat(30)), singleStepTimeoutSeconds = 0.1)
        }.also { it.reason.shouldBeInstanceOf<LscTooManyOptions>()}
    }

    "A total timeout can stop a run on a huge list of words" {
        val ch = lsc(
            """
                simple:
                    a => b
            """.trimIndent()
        )

        shouldThrow<RunTimedOut> {
            ch.change(
                generateSequence { "a" }.take(10000).toList(),
                totalTimeoutSeconds = 0.01,
            )
        }.also { it.reason.shouldBeInstanceOf<TooManyWords>()}
    }

    "A single-step timeout alone CANNOT stop a run as long as each rule is fast" {
        val ch = lsc(
            """
                simple:
                    a => b
            """.trimIndent()
        )

        ch.change(
            generateSequence { "a" }.take(10000).toList(),
            singleStepTimeoutSeconds = 0.01
        ).size shouldBe 10000
    }
})
