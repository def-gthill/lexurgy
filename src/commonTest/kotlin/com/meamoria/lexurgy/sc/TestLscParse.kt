package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.pairs
import com.meamoria.lexurgy.subsets
import com.meamoria.mpp.kotest.*

@Suppress("unused")
class TestLscParse : StringSpec({
    val parser = LscInterpreter()

    "An entire lsc file should be parsable as a string" {
        parser.parseFile(
            """
                a-rule:
                x=>h
            """.trimIndent()
        ) shouldBe "rule(a-rule, (from(x), to(h)))"
        parser.parseFile(
            """
               |Deromanizer:
               |    c => x
               |a-rule:
               |    x => h
               |Romanizer:
               |    h => '
            """.trimMargin()
        ) shouldBe "drom((from(c), to(x))), rule(a-rule, (from(x), to(h))), rom((from(h), to(')))"
    }

    val statements = listOf(
        "Feature Foo(foo, bar)",
        "Diacritic ́  [stressed]",
        "Symbol r̼ [silly]",
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
        for (subset in statements.subsets()) {
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
                            "${statementNames[mustComeBefore]} (Line $line, column $column)"
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
            diacritic ́  (Before) (Floating) [stressed]
            symbol r̼ [silly]
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

    "A rule name with invalid characters should trigger a helpful error message" {
        shouldThrow<LscNotParsable> {
            parser.parseFile(
                """
                    rule with spaces:
                        o => a
                """.trimIndent()
            )
        }.also {
            it.message should startWith("A rule name can't start with \"rule \"; " +
                    "rule names must consist of only lowercase letters and hyphens")
        }

        shouldThrow<LscNotParsable> {
            parser.parseFile(
                """
                    rule+with+special+characters:
                        o => a
                """.trimIndent()
            )
        }.also {
            it.message should startWith("A rule name can't start with \"rule+\"; " +
                    "rule names must consist of only lowercase letters and hyphens")
        }
    }

    "A feature declaration should be parsable as a string" {
        parser.parseFeatureDeclaration("Feature Type(cons, vowel)") shouldBe "fdec(f(Type), v(cons), v(vowel))"
        parser.parseFeatureDeclaration(
            "Feature Rounding(*unrnd, rnd)"
        ) shouldBe "fdec(f(Rounding), na(v(unrnd)), v(rnd))"
        parser.parseFeatureDeclaration(
            "Feature Nasal(*unnas, nas) => [cons]"
        ) shouldBe "fdec(f(Nasal), na(v(unnas)), v(nas), impl(mat(v(cons))))"
        shouldThrow<LscNotParsable> { parser.parseFeatureDeclaration("Feature type(cons, vowel)") }.also {
            it.message should startWith("A feature can't be called \"type\"; feature names must start with an uppercase letter")
        }
        shouldThrow<LscNotParsable> { parser.parseFeatureDeclaration("Feature Type(Cons, Vowel)") }.also {
            it.message should startWith("A feature value can't be called \"Cons\"; value names must start with a lowercase letter")
        }
        shouldThrow<LscNotParsable> { parser.parseFeatureDeclaration("Type(cons, vowel)") }
        shouldThrow<LscNotParsable> { parser.parseFeatureDeclaration("=>") }
        shouldThrow<LscNotParsable> { parser.parseFeatureDeclaration("Feature Type[cons, vowel]") }.also {
            it.message should startWith("The values of the feature Type need to be in parentheses () not square brackets []")
        }
    }

    "A diacritic declaration should be parsable as a string" {
        parser.parseDiacriticDeclaration("Diacritic ʰ [aspir]") shouldBe "dia(ʰ, mat(v(aspir)))"
        parser.parseDiacriticDeclaration("Diacritic ̥  [unvcd]") shouldBe "dia(̥, mat(v(unvcd)))"
        parser.parseDiacriticDeclaration("Diacritic ˈ (before) [str]") shouldBe "dia(ˈ, mat(v(str)), bf)"
        shouldThrow<LscNotParsable> { parser.parseDiacriticDeclaration("ʰ [aspir]") }
        shouldThrow<LscNotParsable> { parser.parseDiacriticDeclaration("Diacritic ʰ aspir") }
        shouldThrow<LscNotParsable> { parser.parseDiacriticDeclaration("Diacritic ʰʰ [aspir]") }
        shouldThrow<LscNotParsable> { parser.parseDiacriticDeclaration("=>") }
    }

    "A symbol declaration should be parsable as a string" {
        parser.parseSymbolDeclaration("Symbol p [stop unvcd lab]") shouldBe "sym(p, mat(v(stop), v(unvcd), v(lab)))"
        parser.parseSymbolDeclaration("Symbol ᵑg [stop nas vcd vel]") shouldBe "sym(ᵑg, mat(v(stop), v(nas), v(vcd), v(vel)))"
        parser.parseSymbolDeclaration("Symbol stoopid [dumb idiotic]") shouldBe "sym(stoopid, mat(v(dumb), v(idiotic)))"
        shouldThrow<LscNotParsable> { parser.parseSymbolDeclaration("Symbol blah blah [blah]") }
        shouldThrow<LscNotParsable> { parser.parseSymbolDeclaration("=>") }
    }

    "A deromanizer should be parsable as a string" {
        parser.parseDeromanizer(
            """
               |Deromanizer:
               |    c => x
               |    ' => ʔ
            """.trimMargin()
        ) shouldBe "drom((from(c), to(x)), (from('), to(ʔ)))"
        parser.parseDeromanizer(
            """
               |Deromanizer:
               |    c => s / _ {e, i}
               |    c => k
            """.trimMargin()
        ) shouldBe "drom((from(c), to(s), env(_, list(e, i))), (from(c), to(k)))"
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

    "A change rule should be parsable as a string" {
        parser.parseChangeRule(
            """
               |velar-fricative:
               |    x => h
            """.trimMargin()
        ) shouldBe "rule(velar-fricative, (from(x), to(h)))"
        parser.parseChangeRule(
            """
               |remove-stress:
               |    [str] => [unstr]
            """.trimMargin()
        ) shouldBe "rule(remove-stress, (from(mat(v(str))), to(mat(v(unstr)))))"
        parser.parseChangeRule(
            """
               |intervoc-voice:
               |    [stop] => [vcd] / [vowel] _ [vowel]
            """.trimMargin()
        ) shouldBe "rule(intervoc-voice, (from(mat(v(stop))), to(mat(v(vcd))), env(mat(v(vowel)), _, mat(v(vowel)))))"
        parser.parseChangeRule(
            """
               |intervoc-voice:
               |    {p, t, k} => {b, d, g} / [vowel] _ [vowel]
            """.trimMargin()
        ) shouldBe
                "rule(intervoc-voice, (from(list(p, t, k)), to(list(b, d, g)), env(mat(v(vowel)), _, mat(v(vowel)))))"
        parser.parseChangeRule(
            """
               |delete-h:
               |    h => *
            """.trimMargin()
        ) shouldBe "rule(delete-h, (from(h), to(null)))"
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

    "A romanizer should be parsable as a string" {
        parser.parseRomanizer(
            """
               |Romanizer:
               |    x => c
               |    ʔ => '
            """.trimMargin()
        ) shouldBe "rom((from(x), to(c)), (from(ʔ), to(')))"
        parser.parseRomanizer(
            """
               |Romanizer:
               |    f => v / [vowel] _ [vowel]
               |    f => ph
            """.trimMargin()
        ) shouldBe "rom((from(f), to(v), env(mat(v(vowel)), _, mat(v(vowel)))), (from(f), to(ph)))"
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

    "A matrix should be parsable as a string" {
        parser.parseMatrix("[cons]") shouldBe "mat(v(cons))"
        parser.parseMatrix("[stop unvcd lab]") shouldBe "mat(v(stop), v(unvcd), v(lab))"
        shouldThrow<LscNotParsable> { parser.parseMatrix("cons") }
        shouldThrow<LscNotParsable> { parser.parseMatrix("[stop, unvcd, lab]") }
        shouldThrow<LscNotParsable> { parser.parseMatrix("=>") }
    }

    "A feature reference should be parsable as a string" {
        parser.parseFeature("Place") shouldBe "f(Place)"
        parser.parseFeature("Manner") shouldBe "f(Manner)"
        shouldThrow<LscNotParsable> { parser.parseFeature("place") }
        shouldThrow<LscNotParsable> { parser.parseFeature("=>") }
    }

    "A lowercase word should be parsable as a string" {
        parser.parseValue("cons") shouldBe "v(cons)"
        parser.parseValue("vowel") shouldBe "v(vowel)"
        shouldThrow<LscNotParsable> { parser.parseValue("Cons") }
        shouldThrow<LscNotParsable> { parser.parseValue("=>") }
    }
})