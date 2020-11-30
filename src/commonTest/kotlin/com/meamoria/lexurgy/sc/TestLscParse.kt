package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.pairs
import com.meamoria.lexurgy.subsets
import com.meamoria.mpp.kotest.*

@Suppress("unused")
class TestLscParse : StringSpec({
    val parser = LscInterpreter(StringWalker())

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
        for (pair in statements.indices.pairs()) {
            val (x, y) = pair
            @Suppress("UnnecessaryVariable") val first = x // These variables work around a weird corner-case bug
            @Suppress("UnnecessaryVariable") val second = y
            val swapped = statements.withIndex().map {
                when (it.index) {
                    first -> statements[second]
                    second -> statements[first]
                    else -> it.value
                }
            }
            val lineNumbers = statements.scan(1) { acc, statement -> acc + statement.split("\n").size }
            shouldThrow<LscNotParsable> {
                parser.parseFile(swapped.joinToString("\n"))
            }.also {
                it.message should startWith(
                    "The ${statementNames[second]} must come after"
                )
                it.line shouldBe lineNumbers[first]
                it.column shouldBe 0
                it.offendingSymbol shouldBe statements[second]
            }
        }
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
}) {
    class StringWalker : LscWalker<String>() {
        override fun walkFile(
            featureDeclarations: List<String>,
            diacriticDeclarations: List<String>,
            symbolDeclarations: List<String>,
            classDeclarations: List<String>,
            deromanizer: String?,
            changeRules: List<String>,
            romanizer: String?,
            intermediateRomanizers: List<RomanizerToFollowingRule<String>>
        ): String = (
                featureDeclarations + diacriticDeclarations + symbolDeclarations + classDeclarations +
                        listOfNotNull(deromanizer) + changeRules + listOfNotNull(romanizer)
                ).joinToString()

        override fun walkClassDeclaration(className: String, elements: List<String>): String =
            "cdec($className, ${elements.joinToString()})"

        override fun walkFeatureDeclaration(
            featureName: String,
            nullAlias: String?,
            values: List<String>,
            implication: String?
        ): String {
            val nullAliasList = listOfNotNull(nullAlias?.let {"na($it)"})
            val implicationList = listOfNotNull(implication?.let {"impl($it)"})
            return "fdec($featureName, ${(nullAliasList + values + implicationList).joinToString()})"
        }

        override fun walkDiacriticDeclaration(
            diacritic: String, matrix: String, before: Boolean, floating: Boolean
        ): String =
            "dia($diacritic, $matrix${if (before) ", bf" else ""}${if (floating) ", fl" else ""})"

        override fun walkSymbolDeclaration(symbol: String, matrix: String?): String =
            "sym($symbol${optionalArg(matrix)})"

        override fun walkDeromanizer(subrules: List<String>, literal: Boolean): String =
            "drom(${subrules.joinToString()}${if (literal) ", literal" else ""})"

        override fun walkRomanizer(subrules: List<String>, literal: Boolean): String =
            "rom(${subrules.joinToString()}${if (literal) ", literal" else ""})"

        override fun walkIntermediateRomanizer(ruleName: String, subrules: List<String>, literal: Boolean): String =
            "introm($ruleName, ${subrules.joinToString()}${if (literal) ", literal" else ""})"

        override fun walkChangeRule(
            ruleName: String,
            subrules: List<String>,
            ruleFilter: String?,
            propagate: Boolean
        ): String {
            val expressionString =
                if (subrules.size == 1) subrules.single() else subrules.joinToString(" then ") { "($it)" }
            val filterText = optionalArg(ruleFilter, ", filter=$ruleFilter")
            val propagateText = if (propagate) ", propagate" else ""
            return "rule($ruleName, $expressionString$filterText$propagateText)"
        }

        override fun walkSubrule(expressions: List<String>): String = expressions.joinToString()

        override fun walkRuleExpression(
            ruleFrom: String,
            ruleTo: String,
            condition: String?,
            exclusion: String?
        ): String = "(from($ruleFrom), to($ruleTo)${optionalArg(condition)}${optionalArg(exclusion)})"

        override fun walkDoNothingExpression(): String = "unchanged"

        override fun walkRuleEnvironment(
            text: String,
            before: String?,
            after: String?,
        ): String {
            val beforeText = optionalArg(before, "$before, ")
            val afterText = optionalArg(after, ", $after")
            return "env(${beforeText}_${afterText})"
        }

        override fun walkRuleSequence(text: String, items: List<String>): String = "seq(${items.joinToString()})"

        override fun walkRuleList(items: List<String>): String = "list(${items.joinToString()})"

        override fun walkNegatedElement(element: String): String = "!${element}"

        override fun walkEmpty(): String = "null"

        override fun walkBoundary(): String = "$"

        override fun walkClassReference(value: String): String = "c($value)"

        override fun walkCaptureReference(number: Int): String = "cap($number)"

        override fun walkMatrix(values: List<String>): String = "mat(${values.joinToString()})"

        override fun walkValue(name: String): String = "v($name)"

        override fun walkFeature(name: String): String = "f($name)"

        override fun walkText(text: String, exact: Boolean): String = text + if (exact) "!" else ""

        override fun tlist(items: List<String>): String = items.joinToString("|")

        override fun untlist(list: String): List<String> = list.split("|")

        private fun optionalArg(inText: String?, outText: String? = null): String =
            if (inText == null) "" else (outText ?: ", $inText")
    }
}