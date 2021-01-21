package com.meamoria.lexurgy.gen

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestAwkwordsParse : StringSpec({
    val parser = AwkwordsInterpreter

    "An uppercase letter should be interpreted as a subreference" {
        parser.parseSubreference("C") shouldBe "sr(C)"
        parser.parseSubreference("X") shouldBe "sr(X)"
    }

    "Several symbols concatenated should parse as a sequence" {
        parser.parseSequence("ab") shouldBe "seq(a, b)"
        parser.parseSequence("CV") shouldBe "seq(sr(C), sr(V))"
        parser.parseSequence("Ca") shouldBe "seq(sr(C), a)"
        parser.parseSequence("spam") shouldBe "seq(s, p, a, m)"
    }

    "A parenthetical expression should parse as an optional" {
        parser.parseOptional("(a)") shouldBe "op(a)"
        parser.parseOptional("(C)") shouldBe "op(sr(C))"
        shouldThrow<AwkwordsNotParsable> { parser.parseOptional("(a") }
    }

    "Expressions separated by slashes should parse as alternatives" {
        parser.parseAlternative("a/b") shouldBe "alt(a, b)"
        parser.parseAlternative("C/V") shouldBe "alt(sr(C), sr(V))"
        parser.parseAlternative("C/a") shouldBe "alt(sr(C), a)"
        parser.parseAlternative("s/p/a/m") shouldBe "alt(s, p, a, m)"
        shouldThrow<AwkwordsNotParsable> { parser.parseAlternative("ab") }
        shouldThrow<AwkwordsNotParsable> { parser.parseAlternative("a//b") }
    }

    "Any combination of the above should be parsable as a pattern" {
        parser.parsePattern("a") shouldBe "a"
        parser.parsePattern("C") shouldBe "sr(C)"
        parser.parsePattern("(C)") shouldBe "op(sr(C))"
        parser.parsePattern("((C))") shouldBe "op(op(sr(C)))"
        parser.parsePattern("Ca") shouldBe "seq(sr(C), a)"
        parser.parsePattern("(f/p)oo") shouldBe "seq(op(alt(f, p)), o, o)"
        parser.parsePattern("Aa/Bb") shouldBe "alt(seq(sr(A), a), seq(sr(B), b))"
        parser.parsePattern("(a(e(i/o)u)V)t") shouldBe "seq(op(seq(a, op(seq(e, op(alt(i, o)), u)), sr(V))), t)"
    }

}) {
//    class StringWalker : AwkwordsWalker<String>() {
//        override fun walkAlternative(elements: List<String>): String = "alt(${elements.joinToString()})"
//
//        override fun walkOptional(element: String): String = "op($element)"
//
//        override fun walkSequence(elements: List<String>): String = "seq(${elements.joinToString()})"
//
//        override fun walkSubref(name: String): String = "sr($name)"
//
//        override fun walkAtom(text: String): String = text
//    }
}