package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.pairs
import com.meamoria.lexurgy.subsets
import com.meamoria.mpp.kotest.*

@Suppress("unused")
class TestLscParse : StringSpec({
    val parser = LscInterpreter()

    val statements = listOf(
        "Feature Foo(foo, bar)",
        "Diacritic ́  [foo]",
        "Symbol r̼",
        "Class bar {b, a, r}",
        "Deromanizer:\n{o, e} => {ɔ, ɛ}",
        "foobar:\no=>a",
        "Romanizer:\n{ɔ, ɛ} => {o, e}",
    )

    fun tryParsing(text: String) {
        try {
            parser.parseFile(text)
        } catch (e: LscNotParsable) {
            println("Failing example:")
            println("------")
            println(text)
            println("------")
            throw e
        }
    }

    "Lsc file parsing should allow any of the statement types to be present or absent, with or without extra newlines" {
        for (subset in statements.filterNot {it.startsWith("Diacritic")}.subsets()) {
            tryParsing(subset.joinToString(separator = "\n", prefix = "\n"))
            tryParsing(subset.joinToString(separator = "\n", postfix = "\n"))
            tryParsing(subset.joinToString(separator = "\n\n"))
        }
    }

    data class SwapError(val mustComeBefore: Int, val mustComeAfter: Int, val errorAtStatement: Int)

    "Lsc file parsing should reject confusing orderings of statements" {
        val statementNames = listOf(
            "feature declarations",
            "diacritic declarations",
            "symbol declarations",
            "class declarations",
            "deromanizer",
            "change rules",
            "final romanizer",
        )
        val swapErrors = mapOf(
            (0 to 1) to SwapError(0, 1, 0), (0 to 2) to SwapError(0, 1, 1), (0 to 3) to SwapError(1, 3, 0),
            (0 to 4) to SwapError(1, 4, 0), (0 to 5) to SwapError(1, 5, 0), (0 to 6) to SwapError(1, 6, 0),
            (1 to 3) to SwapError(2, 3, 1), (1 to 4) to SwapError(2, 4, 1),
            (1 to 5) to SwapError(2, 5, 1), (1 to 6) to SwapError(2, 6, 1),
            (2 to 3) to SwapError(2, 3, 2), (2 to 4) to SwapError(3, 4, 2),
            (2 to 5) to SwapError(3, 5, 2), (2 to 6) to SwapError(3, 6, 2),
            (3 to 4) to SwapError(3, 4, 3), (3 to 5) to SwapError(4, 5, 3),
            (3 to 6) to SwapError(4, 6, 3),
            (4 to 5) to SwapError(4, 5, 4), (4 to 6) to SwapError(5, 6, 4),
            (5 to 6) to SwapError(5, 6, 5),
        )
        for (pair in statements.indices.pairs()) {
            val (x, y) = pair
            // These variables work around a weird corner-case bug in Kotlin/JS
            @Suppress("UnnecessaryVariable") val first = x
            @Suppress("UnnecessaryVariable") val second = y
            val swapped = statements.withIndex().map {
                when (it.index) {
                    first -> statements[second]
                    second -> statements[first]
                    else -> it.value
                }
            }
            val lineNumbers = statements.scan(1) { acc, statement -> acc + statement.split("\n").size }
            val swapError = swapErrors[pair]
            if (swapError != null) {
                val (a, b, c) = swapError
                @Suppress("UnnecessaryVariable") val mustComeBefore = a
                @Suppress("UnnecessaryVariable") val mustComeAfter = b
                @Suppress("UnnecessaryVariable") val errorAtStatement = c
                val line = lineNumbers[errorAtStatement]
                val column = 0
                shouldThrow<LscNotParsable> {
                    parser.parseFile(swapped.joinToString("\n"))
                }.also {
                    it.message shouldBe
                        "The ${statementNames[mustComeAfter]} must come after the " +
                            "${statementNames[mustComeBefore]} (line $line)"
                    it.line shouldBe line
                    it.column shouldBe column
                    it.offendingSymbol shouldBe statements[mustComeAfter]
                }
            }
        }
    }

    "But switching diacritics and symbols isn't confusing" {
        val swapped = listOf(statements[0], statements[2], statements[1]) + statements.drop(3)
        parser.parseFile(swapped.joinToString("\n"))
    }

    "All keywords should be case-insensitive" {
        parser.parseFile(
            """
            feature Foo(foo, bar)
            diacritic ́  (Before) (Floating) [foo]
            symbol r̼ [bar]
            class bar {b, a, r}
            deromanizer:
                {o, e} => {ɔ, ɛ}
            foobar Propagate:
                o=>a
            romanizer:
                {ɔ, ɛ} => {o, e}
            """.trimIndent()
        )
    }

    "A rule without a colon should trigger a friendly LscNotParsable" {
        shouldThrow<LscNotParsable> {
            parser.parseFile(
                """
                    rule-without-colon
                        o => a
                """.trimIndent()
            )
        }.also {
            it.message should startWith("The rule \"rule-without-colon\" needs a colon after the rule name")
        }

        shouldThrow<LscNotParsable> {
            parser.parseFile(
                """
                    fancy-rule-without-colon [vowel] propagate
                        o => a
                """.trimIndent()
            )
        }.also {
            it.message should startWith("The rule \"fancy-rule-without-colon\" needs a colon after \"propagate\"")
        }
    }

    "Bad feature declarations should be rejected" {
        shouldThrow<LscNotParsable> { parser.parseFeatureDeclaration("Feature Type(Co-ns, Vowel)") }
        shouldThrow<LscNotParsable> { parser.parseFeatureDeclaration("Type(cons, vowel)") }
        shouldThrow<LscNotParsable> { parser.parseFeatureDeclaration("=>") }
    }

    "Bad diacritic declarations should be rejected" {
        shouldThrow<LscNotParsable> { parser.parseDiacriticDeclaration("ʰ [aspir]") }
        shouldThrow<LscNotParsable> { parser.parseDiacriticDeclaration("Diacritic ʰ aspir") }
        shouldThrow<LscNotParsable> { parser.parseDiacriticDeclaration("=>") }
    }

    "Bad symbol declarations should be rejected" {
        shouldThrow<LscNotParsable> { parser.parseSymbolDeclaration("Symbol blah blah [blah]") }
        shouldThrow<LscNotParsable> { parser.parseSymbolDeclaration("=>") }
    }

    "Bad deromanizers should be rejected" {
        shouldThrow<LscNotParsable> {
            parser.parseDeromanizer(
                """
                   |Deromanizer {
                   |    c => s / _ {e, i}
                   |    c => k
                   |}
                """.trimMargin()
            )
        }
        shouldThrow<LscNotParsable> {
            parser.parseDeromanizer(
                """
                   |Deromanizer:
                   |    a
                """.trimMargin()
            )
        }
        shouldThrow<LscNotParsable> {
            parser.parseDeromanizer(
                """
                   |    a => a
                """.trimMargin()
            )
        }
        shouldThrow<LscNotParsable> { parser.parseDeromanizer("Deromanizer a => a") }
        shouldThrow<LscNotParsable> { parser.parseDeromanizer("=>") }
    }

    "A change rule with no '_' anchor should throw an error with a helpful message" {
        shouldThrow<LscNotParsable> {
            parser.parseChangeRule(
                """
                    foobar:
                        a => b / c
                """.trimIndent()
            )
        }.also {
            it.message should startWith("The environment \"c\" in rule foobar needs an underscore")
        }
        shouldThrow<LscNotParsable> {
            parser.parseFile(
                """
                    foobar:
                        a => b / c
                    barfoo:
                        a => b / c _
                """.trimIndent()
            )
        }.also {
            it.message should startWith("The environment \"c\" in rule foobar needs an underscore")
            it.line shouldBe 2
            it.column shouldBe 14
            it.offendingSymbol shouldBe "c"
        }
        shouldThrow<LscNotParsable> {
            parser.parseFile(
                """
                    foobar:
                        a => b / c _
                    barfoo:
                        a => b / c
                    farboo:
                        a => b / c _
                """.trimIndent()
            )
        }.also {
            it.message should startWith("The environment \"c\" in rule barfoo needs an underscore")
            it.line shouldBe 4
        }
    }

    "Completely unintelligible files should still yield decent error messages" {
        shouldThrow<LscNotParsable> {
            parser.parseFile("[foo]")
        }.also {
            it.message should startWith("\"[\" doesn't make sense in the line \"[foo]\"")
        }
    }

    "Bad romanizers should be rejected" {
        shouldThrow<LscNotParsable> {
            parser.parseRomanizer(
                """
                   |Romanizer {
                   |    f => v / [vowel] _ [vowel]
                   |    f => ph
                   |}
                """.trimMargin()
            )
        }
        shouldThrow<LscNotParsable> {
            parser.parseRomanizer(
                """
                   |Romanizer:
                   |    a
                """.trimMargin()
            )
        }
        shouldThrow<LscNotParsable> {
            parser.parseRomanizer(
                """
                   |    a => a
                """.trimMargin()
            )
        }
        shouldThrow<LscNotParsable> { parser.parseRomanizer("Romanizer a => a") }
        shouldThrow<LscNotParsable> { parser.parseRomanizer("=>") }
    }

    "Bad matrices should be rejected" {
        shouldThrow<LscNotParsable> { parser.parseMatrix("cons") }
        shouldThrow<LscNotParsable> { parser.parseMatrix("[stop, unvcd, lab]") }
        shouldThrow<LscNotParsable> { parser.parseMatrix("=>") }
    }
})