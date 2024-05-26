package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.element.*
import com.meamoria.lexurgy.word.StandardWord
import com.meamoria.lexurgy.word.Word
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestSyllabifier : StringSpec({
    fun syllabifier(vararg patterns: Syllabifier.Pattern) =
        Syllabifier(
            Declarations.empty,
            patterns.asList(),
        )
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic)
    fun text(schematic: String): TextMatcher = TextMatcher(word(schematic))
    fun capture(matcher: Matcher, number: Int): CaptureMatcher = CaptureMatcher(matcher, number)
    fun captureReference(number: Int): CaptureReferenceMatcher = CaptureReferenceMatcher(
        Declarations.empty,
        number,
        exact = true,
    )
    fun optional(matcher: Matcher): RepeaterMatcher = RepeaterMatcher(
        Declarations.empty,
        matcher,
        StandardRepeaterType.ZERO_OR_ONE,
    )
    fun sequence(vararg matchers: Matcher): SequenceMatcher = SequenceMatcher(
        Declarations.empty,
        matchers.asList(),
    )
    fun either(vararg matchers: Matcher): AlternativeMatcher = AlternativeMatcher(
        Declarations.empty,
        matchers.asList(),
    )
    fun flexible(matcher: Matcher, minReps: Int, maxReps: Int? = null): RepeaterMatcher = RepeaterMatcher(
        Declarations.empty,
        matcher,
        FlexibleRepeaterType(minReps, maxReps),
    )

    "A syllabifier can split up a word into syllables" {
        val syllabifier = syllabifier(
            Syllabifier.SimplePattern(text("b/a")),
            Syllabifier.SimplePattern(text("n/a"))
        )
        val word = word("b/a/n/a/n/a")

        val result = syllabifier.syllabify(word)

        result.string shouldBe "ba.na.na"
    }

    "A syllabifier can include captures" {
        val syllabifier = syllabifier(
            Syllabifier.SimplePattern(
                sequence(
                    capture(either(text("a"), text("b")), 1),
                    captureReference(1),
                )
            )
        )
        val word = word("a/a/b/b/a/a")

        val result = syllabifier.syllabify(word)

        result.string shouldBe "aa.bb.aa"
    }

    "A syllabifier with structured patterns can split up a word into syllables" {
        val syllabifier = syllabifier(
            Syllabifier.StructuredPattern(
                onset = text("b"),
                nucleus = text("a"),
            ),
            Syllabifier.StructuredPattern(
                onset = text("n"),
                nucleus = text("a"),
            )
        )
        val word = word("b/a/n/a/n/a")

        val result = syllabifier.syllabify(word)

        result.string shouldBe "ba.na.na"
    }

    "A structured pattern can specify a coda" {
        val syllabifier = syllabifier(
            Syllabifier.StructuredPattern(
                onset = text("b"),
                nucleus = text("a"),
                coda = optional(text("n"))
            ),
        )
        val word = word("b/a/b/a/n/b/a")

        val result = syllabifier.syllabify(word)

        result.string shouldBe "ba.ban.ba"
    }

    "The onset of a structured syllable pattern consumes as much to the left as possible" {
        val syllabifier = syllabifier(
            Syllabifier.StructuredPattern(
                onset = text("n"),
                nucleus = text("a"),
                coda = optional(text("n"))
            )
        )
        val word = word("n/a/n/a/n/n/a")

        val result = syllabifier.syllabify(word)

        result.string shouldBe "na.nan.na"
    }

    "The nucleus of a structured syllable pattern consumes as much to the right as possible" {
        // AKA "Why won't Lexurgy put two vowels in the same syllable!?"
        val syllabifier = syllabifier(
            Syllabifier.StructuredPattern(
                onset = optional(text("b")),
                nucleus = flexible(text("a"), 1, 2),
            ),
        )
        val word = word("b/a/a/b/a")

        val result = syllabifier.syllabify(word)

        result.string shouldBe "baa.ba"
    }

    "A reluctant onset consumes as little to the left as possible" {
        // AKA "Why won't Lexurgy split clusters between syllables!?"
        val syllabifier = syllabifier(
            Syllabifier.StructuredPattern(
                reluctantOnset = optional(text("s")),
                onset = optional(text("p")),
                nucleus = text("a"),
                coda = optional(either(text("s"), text("p")))
            )
        )
        val word = word("s/p/a/s/p/a/p/a/p/s/p/a")

        val result = syllabifier.syllabify(word)

        result.string shouldBe "spas.pa.pap.spa"
    }

    "Structured syllables correctly identify the problem segment if a component is missing" {
        val syllabifier = syllabifier(
            Syllabifier.StructuredPattern(
                onset = text("b"),
                nucleus = text("a"),
            )
        )
        val word = word("b/a/b/o")

        shouldThrow<SyllableStructureViolated> {
            syllabifier.syllabify(word)
        }.also {
            it.lastSyllableBreak shouldBe 2
            it.invalidSymbolPosition shouldBe 3
        }
    }

    "Structured syllables correctly identify the problem segment if a component has a partial match" {
        val syllabifier = syllabifier(
            Syllabifier.StructuredPattern(
                onset = text("b"),
                nucleus = text("o/u"),
            )
        )
        val word = word("b/o/u/b/o")

        shouldThrow<SyllableStructureViolated> {
            syllabifier.syllabify(word)
        }.also {
            it.lastSyllableBreak shouldBe 3
            it.invalidSymbolPosition shouldBe 4
        }
    }

    "A structured syllabifier can include captures" {
        val syllabifier = syllabifier(
            Syllabifier.StructuredPattern(
                onset = capture(either(text("a"), text("b")), 1),
                nucleus = captureReference(1),
            )
        )
        val word = word("a/a/b/b/a/a")

        val result = syllabifier.syllabify(word)

        result.string shouldBe "aa.bb.aa"
    }
})
