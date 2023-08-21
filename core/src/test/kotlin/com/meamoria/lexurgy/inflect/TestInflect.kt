package com.meamoria.lexurgy.inflect

import com.meamoria.lexurgy.word.Word
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestInflect : FreeSpec({
    "A category tree" - {
        "with one form yields that form" {
            val tree = Form("foo")

            val result = tree.inflect(Word("bar"))

            result.string shouldBe "foo"
        }

        "with two categories yields the form for the chosen category" {
            val tree = CategorySplit(
                "present" to Form("foo"),
                "past" to Form("fid"),
            )

            val result = tree.inflectAll(
                Word("bar") to setOf("past"),
                Word("bar") to setOf("present"),
            )

            result.map { it.string } shouldBe listOf("fid", "foo")
        }

        "with two dimensions yields the form for the chosen pair of categories" {
            val tree = CategorySplit(
                "present" to CategorySplit(
                    "positive" to Form("foo"),
                    "negative" to Form("fon't"),
                ),
                "past" to CategorySplit(
                    "positive" to Form("fid"),
                    "negative" to Form("fidn't"),
                ),
            )

            val result = tree.inflectAll(
                Word("bar") to setOf("present", "negative"),
                Word("bar") to setOf("past", "positive"),
            )

            result.map { it.string } shouldBe listOf("fon't", "fid")
        }

        "can have branches that ignore further categories" {
            val tree = CategorySplit(
                "present" to CategorySplit(
                    "singular" to Form("fuzz"),
                    "plural" to Form("foo"),
                ),
                "past" to Form("fid"),
            )

            val result = tree.inflectAll(
                Word("bar") to setOf("present", "singular"),
                Word("bar") to setOf("past", "plural"),
            )

            result.map { it.string } shouldBe listOf("fuzz", "fid")
        }

        "throws UnspecifiedCategory if a required category is missing" {
            val tree = CategorySplit(
                "present" to Form("foo"),
                "past" to Form("fid"),
            )

            shouldThrow<UnspecifiedCategory> {
                tree.inflect(Word("bar"))
            }.also {
                it.stem.string shouldBe "bar"
                it.categories shouldBe emptySet()
                it.missingCategoryOptions shouldBe setOf("present", "past")
            }
        }
    }
})