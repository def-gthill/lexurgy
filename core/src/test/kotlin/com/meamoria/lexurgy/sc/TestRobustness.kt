package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.element.InvalidTransformation
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

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

    "A more complex naked expression yields a helpful error message" {
        shouldThrow<ExpressionNotInRule> {
            lsc(
                """
                    Feature (syllable) +stress
                    Diacritic ˈ (before) [+stress]
                    ([]+)${'$'}1 ${'$'}${'$'} ([]+)${'$'}2 => ${'$'}2 . ${'$'}1
                """.trimIndent()
            )
        }
    }

    "We should be able to have numbers in names, as long as the whole name isn't numbers" {
        lsc(
            """
                Feature 2fast(2furious)
                Class v0w3l {a, i, u}
                4tition-1:
                    b => p
            """.trimIndent()
        )
    }

    "A file with syntax errors should fail to parse even if the start is valid" {
        shouldThrow<LscNotParsable> {
            lsc(
                """
                    a-rule:
                    x=>h
                    ]]]]]
                """.trimIndent()
            )
        }
    }

    "Duplicate rules should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    duplicate-rule:
                        o => a
                    duplicate-rule:
                        a => o
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The rule \"duplicate-rule\" is defined more than once"
        }
    }

    "Rules with mismatched elements should produce an LscInvalidRuleExpression with a clear error message" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("Feature bad(mat)\nbadrule:\n   a => b [mat]")
        }.also {
            it.cause.shouldBeInstanceOf<InvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("a => b [mat]") of rule "badrule"
                Found 1 element ("a") on the left side of the arrow but 2 elements ("b", "[mat]") on the right side
            """.trimIndent()
        }
    }

    "We should be able to use keywords as literal text and parts of rule names" {
        val ch = lsc(
            """
                ltr-to-ch:
                    ltr => tʃ
            """.trimIndent()
        )

        ch("eltrun") shouldBe "etʃun"

        val ch2 = lsc(
            """
                syllables-are-syllables:
                    o => syllables
            """.trimIndent()
        )

        ch2("foo") shouldBe "fsyllablessyllables"

        val ch3 = lsc(
            """
                class-feature-diacritic-symbol:
                    {class, feature} => {diacritic, symbol}
            """.trimIndent()
        )

        ch3("featureymcclassington") shouldBe "symbolymcdiacriticington"

        val ch4 = lsc(
            """
                clear-explicit:
                    clear => explicit
            """.trimIndent()
        )

        ch4("oooclearooo") shouldBe "oooexplicitooo"

        val ch5 = lsc(
            """
                deromanizer-romanizer-literal:
                    {deromanizer, romanizer} => literal
            """.trimIndent()
        )

        ch5("ideromanizeriromanizeri") shouldBe "iliteraliliterali"

        val ch6 = lsc(
            """
                then-else:
                    then => else
            """.trimIndent()
        )

        ch6("ifthendo") shouldBe "ifelsedo"

        val ch7 = lsc(
            """
                off-unchanged:
                    off => unchanged
            """.trimIndent()
        )

        ch7("coffee") shouldBe "cunchangedee"

        val ch8 = lsc(
            """
                element-defer:
                    element => defer
            """.trimIndent()
        )

        ch8("elementary") shouldBe "deferary"
    }
})
