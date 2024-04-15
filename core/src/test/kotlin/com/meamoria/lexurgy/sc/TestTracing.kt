package com.meamoria.lexurgy.sc

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestTracing: StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    class Tracer {
        val traces: MutableList<TraceInfo> = mutableListOf()

        fun trace(traceInfo: TraceInfo) {
            traces += traceInfo
        }
    }

    fun runTracing(ch: SoundChanger, word: String, tracer: Tracer) {
        ch.change(listOf(word), SoundChangeOptions(debugWords = listOf(word), trace = tracer::trace))
    }

    "Deromanizers show up in the trace as <deromanizer>" {
        val ch = lsc(
            """
                deromanizer:
                  a => b
                
                foo:
                  b => c
            """.trimIndent()
        )
        val tracer = Tracer()

        runTracing(ch, "aaa", tracer)

        tracer.traces[0].ruleName shouldBe "<deromanizer>"
        tracer.traces[0].wordBeforeChange shouldBe "aaa"
        tracer.traces[0].wordAfterChange shouldBe "bbb"
        tracer.traces[1].ruleName shouldBe "foo"
    }

    "Romanizers show up in the trace as <romanizer>" {
        val ch = lsc(
            """
                foo:
                  a => b
                
                romanizer:
                  b => c
            """.trimIndent()
        )
        val tracer = Tracer()

        runTracing(ch, "aaa", tracer)

        tracer.traces[0].ruleName shouldBe "foo"
        tracer.traces[1].ruleName shouldBe "<romanizer>"
        tracer.traces[1].wordBeforeChange shouldBe "bbb"
        tracer.traces[1].wordAfterChange shouldBe "ccc"
    }

    "Intermediate romanizers show up in the trace as <romanizer> plus the stage name" {
        val ch = lsc(
            """
            romanizer-foo:
              a => b
            
            foo:
              a => b
            """.trimIndent()
        )
        val tracer = Tracer()

        runTracing(ch, "aaa", tracer)

        tracer.traces[0].ruleName shouldBe "<romanizer>-foo"
        tracer.traces[0].wordBeforeChange shouldBe "aaa"
        tracer.traces[0].wordAfterChange shouldBe "bbb"
        tracer.traces[1].ruleName shouldBe "foo"
    }

    "Syllable rules show up in the trace as <syllables> plus the preceding rule name plus a counter" {
        val ch = lsc(
            """
                Syllables:
                    {ba, na}
                
                foo:
                    a => o
                
                Syllables:
                    {bon, on, o}
                
                Syllables:
                    {bon, no, o}
            """.trimIndent()
        )
        val tracer = Tracer()

        runTracing(ch, "banana", tracer)

        tracer.traces[0].ruleName shouldBe "<syllables>/<initial>/1"
        tracer.traces[0].wordBeforeChange shouldBe "banana"
        tracer.traces[0].wordAfterChange shouldBe "ba.na.na"
        tracer.traces[1].ruleName shouldBe "foo"
        tracer.traces[2].ruleName shouldBe "<syllables>/foo/1"
        tracer.traces[2].wordBeforeChange shouldBe "bo.no.no"
        tracer.traces[2].wordAfterChange shouldBe "bon.on.o"
        tracer.traces[3].ruleName shouldBe "<syllables>/foo/2"
        tracer.traces[3].wordBeforeChange shouldBe "bon.on.o"
        tracer.traces[3].wordAfterChange shouldBe "bon.o.no"
    }

    "Cleanup rules show up in the trace as <cleanup> plus the preceding rule name plus the cleanup rule name" {
        val ch = lsc(
            """
                foo cleanup:
                    a => b
                
                bar cleanup:
                    b => c
                
                rule1:
                    c => a
            """.trimIndent()
        )
        val tracer = Tracer()

        runTracing(ch, "aaa", tracer)

        tracer.traces[0].ruleName shouldBe "<cleanup>/<initial>/foo"
        tracer.traces[0].wordBeforeChange shouldBe "aaa"
        tracer.traces[0].wordAfterChange shouldBe "bbb"
        tracer.traces[1].ruleName shouldBe "<cleanup>/<initial>/bar"
        tracer.traces[1].wordBeforeChange shouldBe "bbb"
        tracer.traces[1].wordAfterChange shouldBe "ccc"
        tracer.traces[2].ruleName shouldBe "rule1"
        tracer.traces[3].ruleName shouldBe "<cleanup>/rule1/foo"
        tracer.traces[3].wordBeforeChange shouldBe "aaa"
        tracer.traces[3].wordAfterChange shouldBe "bbb"
        tracer.traces[4].ruleName shouldBe "<cleanup>/rule1/bar"
        tracer.traces[4].wordBeforeChange shouldBe "bbb"
        tracer.traces[4].wordAfterChange shouldBe "ccc"
    }
})
