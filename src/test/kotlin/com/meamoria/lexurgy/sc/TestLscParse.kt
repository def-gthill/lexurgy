package com.meamoria.lexurgy.sc

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

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

    "A feature declaration should be parsable as a string" {
        parser.parseFeatureDeclaration("Feature Type(cons, vowel)") shouldBe "fdec(f(Type), v(cons), v(vowel))"
        parser.parseFeatureDeclaration(
            "Feature Rounding(*unrnd, rnd)"
        ) shouldBe "fdec(f(Rounding), na(v(unrnd)), v(rnd))"
        parser.parseFeatureDeclaration(
            "Feature Nasal(*unnas, nas) => [cons]"
        ) shouldBe "fdec(f(Nasal), na(v(unnas)), v(nas), impl(mat(v(cons))))"
        shouldThrow<LscNotParsable> { parser.parseFeatureDeclaration("Feature type(cons, vowel)") }
        shouldThrow<LscNotParsable> { parser.parseFeatureDeclaration("Feature Type(Cons, Vowel)") }
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
        shouldThrow<LscNotParsable> { parser.parseSymbolDeclaration("symbol blah [blah]") }
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

        override fun walkDeromanizer(subrules: List<String>): String = "drom(${subrules.joinToString()})"

        override fun walkRomanizer(subrules: List<String>): String = "rom(${subrules.joinToString()})"

        override fun walkIntermediateRomanizer(ruleName: String, subrules: List<String>): String =
            "introm($ruleName, ${subrules.joinToString()})"

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

        override fun walkRuleEnvironment(
            before: String?,
            after: String?,
            boundaryBefore: Boolean,
            boundaryAfter: Boolean
        ): String {
            val beforeText = optionalArg(before, ((if (boundaryBefore) "$ " else "") + "$before, "))
            val afterText = optionalArg(after, ", $after" + if (boundaryAfter) "$" else "")
            return "env(${beforeText}_${afterText})"
        }

        override fun walkRuleSequence(items: List<String>): String = "seq(${items.joinToString()})"

        override fun walkRuleList(items: List<String>): String = "list(${items.joinToString()})"

        override fun walkNegatedElement(element: String): String = "!${element}"

        override fun walkEmpty(): String = "null"

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