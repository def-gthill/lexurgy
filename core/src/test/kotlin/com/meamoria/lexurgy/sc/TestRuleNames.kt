package com.meamoria.lexurgy.sc

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestRuleNames : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "Deromanizers show up in the rule names as <deromanizer>" {
        val ch = lsc(
            """
                deromanizer:
                  a => b
                
                foo:
                  b => c
            """.trimIndent()
        )

        val ruleNames = ch.ruleNames

        ruleNames shouldBe listOf("<deromanizer>", "foo")
    }

    "Romanizers show up in the rule names as <romanizer>" {
        val ch = lsc(
            """
                foo:
                  a => b
                
                romanizer:
                  b => c
            """.trimIndent()
        )

        val ruleNames = ch.ruleNames

        ruleNames shouldBe listOf("foo", "<romanizer>")
    }

    "Intermediate romanizers show up in the rule names as <romanizer> plus the stage name" {
        val ch = lsc(
            """
            romanizer-foo:
              a => b
            
            foo:
              a => b
            """.trimIndent()
        )

        val ruleNames = ch.ruleNames

        ruleNames shouldBe listOf("<romanizer>-foo", "foo")
    }

    "Syllable rules show up in the rule names as <syllables> plus the preceding rule name plus a counter" {
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

        val ruleNames = ch.ruleNames

        ruleNames shouldBe listOf(
            "<syllables>/<initial>/1",
            "foo",
            "<syllables>/foo/1",
            "<syllables>/foo/2",
        )
    }

    "Cleanup rules show up in the rule names as <cleanup> plus the preceding rule name plus the cleanup rule name" {
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

        val ruleNames = ch.ruleNames

        ruleNames shouldBe listOf(
            "<cleanup>/<initial>/foo",
            "<cleanup>/<initial>/bar",
            "rule1",
            "<cleanup>/rule1/foo",
            "<cleanup>/rule1/bar",
        )
    }
})