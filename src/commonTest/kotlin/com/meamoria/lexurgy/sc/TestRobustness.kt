package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestRobustness : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "An empty file yields a sound changer that returns each word unmodified" {
        val ch = lsc("")

        ch("foo") shouldBe "foo"
        ch("fgdgfggfgfggffdf") shouldBe "fgdgfggfgfggffdf"
        ch("thefiveboxingwizardsjumpquickly") shouldBe "thefiveboxingwizardsjumpquickly"
    }

    "A naked expression yields a helpful error message" {
        shouldThrow<ExpressionNotInRule> {
            lsc("a => b")
        }.also {
            it.message shouldBe "The expression \"a => b\" isn't in a rule; put it after a line like \"rule-name:\""
        }
    }

})
