package com.meamoria.lexurgy.gen

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestAwkwordsParse : StringSpec({
    val parser = AwkwordsInterpreter

    "An uppercase letter should be interpreted as a subreference" {
        parser.parseSubreference("C").text shouldBe "sr(C)"
        parser.parseSubreference("X").text shouldBe "sr(X)"
    }

    "Several symbols concatenated should parse as a sequence" {
        parser.parseSequence("ab").text shouldBe "seq(a, b)"
        parser.parseSequence("CV").text shouldBe "seq(sr(C), sr(V))"
        parser.parseSequence("Ca").text shouldBe "seq(sr(C), a)"
        parser.parseSequence("spam").text shouldBe "seq(s, p, a, m)"
    }

    "A parenthetical expression should parse as an optional" {
        parser.parseOptional("(a)").text shouldBe "op(a)"
        parser.parseOptional("(C)").text shouldBe "op(sr(C))"
        shouldThrow<AwkwordsNotParsable> { parser.parseOptional("(a") }
    }

    "Expressions separated by slashes should parse as alternatives" {
        parser.parseAlternative("a/b").text shouldBe "alt(a, b)"
        parser.parseAlternative("C/V").text shouldBe "alt(sr(C), sr(V))"
        parser.parseAlternative("C/a").text shouldBe "alt(sr(C), a)"
        parser.parseAlternative("s/p/a/m").text shouldBe "alt(s, p, a, m)"
        shouldThrow<AwkwordsNotParsable> { parser.parseAlternative("ab") }
        shouldThrow<AwkwordsNotParsable> { parser.parseAlternative("a//b") }
    }

    "Any combination of the above should be parsable as a pattern" {
        parser.parsePattern("a").text shouldBe "a"
        parser.parsePattern("C").text shouldBe "sr(C)"
        parser.parsePattern("(C)").text shouldBe "op(sr(C))"
        parser.parsePattern("((C))").text shouldBe "op(op(sr(C)))"
        parser.parsePattern("Ca").text shouldBe "seq(sr(C), a)"
        parser.parsePattern("(f/p)oo").text shouldBe "seq(op(alt(f, p)), o, o)"
        parser.parsePattern("Aa/Bb").text shouldBe "alt(seq(sr(A), a), seq(sr(B), b))"
        parser.parsePattern("(a(e(i/o)u)V)t").text shouldBe
                "seq(op(seq(a, op(seq(e, op(alt(i, o)), u)), sr(V))), t)"
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