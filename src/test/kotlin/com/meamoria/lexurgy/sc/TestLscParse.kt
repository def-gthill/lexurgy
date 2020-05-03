package com.meamoria.lexurgy.sc

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestLscParse : StringSpec({
    val parser = LscInterpreter(StringWalker())

    "A lowercase word should be parsable as a Value" {
        parser.parseValue("cons") shouldBe "v(cons)"
        parser.parseValue("vowel") shouldBe "v(vowel)"
        shouldThrow<LscNotParsable> {parser.parseValue("Cons")}
        shouldThrow<LscNotParsable> {parser.parseValue("=>")}
    }
}) {
    class StringWalker : LscWalker()
}