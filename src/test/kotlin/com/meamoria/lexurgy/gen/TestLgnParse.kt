package com.meamoria.lexurgy.gen

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestLgnParse : StringSpec({
    val parser = LgnInterpreter(StringWalker())

    "A class declaration should be parsable" {
        parser.parseClassDeclaration("Class vowel {a, e, i, o, u}") shouldBe "cdec(vowel: a, e, i, o, u)"
        parser.parseClassDeclaration("Class final {p, t, k, s, m, n}") shouldBe "cdec(final: p, t, k, s, m, n)"
    }

    "Class declarations that reference other classes should be parsable" {
        parser.parseClassDeclaration("Class cons {@stop, s, @nasal}") shouldBe "cdec(cons: ref(stop), s, ref(nasal))"
    }

    "Simple sequences should be parsable" {
        parser.parseSequence("g @vowel b") shouldBe "seq(g, ref(vowel), b)"
        parser.parseSequence("@cons @vowel @cons") shouldBe "seq(ref(cons), ref(vowel), ref(cons))"
    }

    "A question mark should be parsed as an optional" {
        parser.parseOptional("b?") shouldBe "op(b)"
        parser.parseOptional("@vowel?") shouldBe "op(ref(vowel))"
    }

    "Pattern declarations should be parsable" {
        "Pattern gibgab:\n    g @vowel b"
    }
}) {
    class StringWalker : LgnWalker<String>() {
        override fun walkClassDeclaration(className: String, elements: List<String>): String =
            "cdec($className: ${elements.joinToString()})"

        override fun walkClassReference(className: String): String = "ref($className)"

        override fun walkSequence(items: List<String>): String = "seq(${items.joinToString()})"

        override fun walkText(text: String): String = text
    }
}