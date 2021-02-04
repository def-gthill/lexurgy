package com.meamoria.lexurgy.gen

import com.meamoria.mpp.kotest.*

class TestLgnParse : StringSpec({
    val parser = LgnInterpreter

    "A class declaration should be parsable" {
        parser.parseClassDeclaration("Class vowel {a, e, i, o, u}").text shouldBe
                "cdec(vowel: a, e, i, o, u)"
        parser.parseClassDeclaration("Class final {p, t, k, s, m, n}").text shouldBe
                "cdec(final: p, t, k, s, m, n)"
    }

    "Class declarations that reference other classes should be parsable" {
        parser.parseClassDeclaration("Class cons {@stop, s, @nasal}").text shouldBe
                "cdec(cons: ref(stop), s, ref(nasal))"
    }

    "Simple sequences should be parsable" {
        parser.parseSequence("g @vowel b").text shouldBe "seq(g, ref(vowel), b)"
        parser.parseSequence("@cons @vowel @cons").text shouldBe
                "seq(ref(cons), ref(vowel), ref(cons))"
    }

    "A question mark should be parsed as an optional" {
        parser.parseOptional("b?").text shouldBe "op(b)"
        parser.parseOptional("@vowel?").text shouldBe "op(ref(vowel))"
    }

    "An alternative list should be parsable" {
        parser.parseList("{a, b}").text shouldBe "alt(a, b)"
        parser.parseList("{@cons, @vowel}").text shouldBe "alt(ref(cons), ref(vowel))"
        parser.parseList("{@cons, a}").text shouldBe "alt(ref(cons), a)"
        parser.parseList("{s, p, a, m}").text shouldBe "alt(s, p, a, m)"
    }

    "Pattern declarations should be parsable" {
        parser.parsePatternDeclaration("Pattern gibgab:\n    g @vowel b").text shouldBe
                "pat(gibgab: seq(g, ref(vowel), b))"
    }
})