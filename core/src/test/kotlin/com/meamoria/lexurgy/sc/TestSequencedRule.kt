package com.meamoria.lexurgy.sc

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.instanceOf
import io.kotest.matchers.types.shouldBeSameInstanceAs

@Suppress("unused")
class TestSequencedRule : StringSpec({

    fun rule(name: String, ruleType: RuleType = RuleType.NORMAL): StandardNamedRule =
        StandardNamedRule(
            name = name,
            declarations = Declarations.empty,
            mainBlock = SequentialBlock(emptyList()),
            ruleType = ruleType,
        )

    fun syllables(): SyllabificationStep =
        SyllabificationStep(
            Declarations.empty.withSyllabifier(
                Syllabifier(Declarations.empty, emptyList())
            )
        )

    fun clearSyllables(): SyllabificationStep =
        SyllabificationStep(
            Declarations.empty.withSyllabifier(null)
        )

    fun intermediateRomanizer(name: String): IntermediateRomanizerStep =
        IntermediateRomanizerStep(
            IntermediateRomanizer(
                name = "",
                stageName = name,
                declarations = Declarations.empty,
                mainBlock = SequentialBlock(emptyList())
            )
        )

    fun cleanup(name: String): CleanupStep =
        CleanupStep(
            rule(name)
        )

    "Sequencing an empty list produces an empty list" {
        val rulesWithAnchoredSteps = emptyList<RuleWithAnchoredSteps>()

        val sequencedRules = sequenceRules(rulesWithAnchoredSteps)

        sequencedRules shouldBe emptyList()
    }

    "Sequencing rules with no anchored steps produces simple rule applications" {
        val rulesWithAnchoredSteps = listOf(
            RuleWithAnchoredSteps(
                rule("foo"),
                emptyList()
            ),
            RuleWithAnchoredSteps(
                rule("bar"),
                emptyList()
            )
        )

        val sequencedRules = sequenceRules(rulesWithAnchoredSteps)

        sequencedRules shouldHaveSize(2)
        sequencedRules[0] shouldBe instanceOf<ApplyRule>()
        (sequencedRules[0] as ApplyRule).rule.name shouldBe "foo"
        sequencedRules[1] shouldBe instanceOf<ApplyRule>()
        (sequencedRules[1] as ApplyRule).rule.name shouldBe "bar"
    }

    "Sequencing syllabification rules adds them after each susequent named rule" {
        val rulesWithAnchoredSteps = listOf(
            RuleWithAnchoredSteps(
                rule("foo"),
                listOf(syllables())
            ),
            RuleWithAnchoredSteps(
                rule("bar"),
                emptyList()
            )
        )

        val sequencedRules = sequenceRules(rulesWithAnchoredSteps)

        sequencedRules shouldHaveSize(5)
        sequencedRules[0] shouldBe instanceOf<Syllabify>()
        sequencedRules[1] shouldBe instanceOf<ApplyRule>()
        sequencedRules[2] shouldBeSameInstanceAs sequencedRules[0]
        sequencedRules[3] shouldBe instanceOf<ApplyRule>()
        sequencedRules[4] shouldBeSameInstanceAs sequencedRules[0]
    }

    "Sequencing a romanizer not attached to a rule preserves the romanizer" {
        val rulesWithAnchoredSteps = listOf(
            RuleWithAnchoredSteps(
                null,
                listOf(intermediateRomanizer("foo"))
            )
        )

        val sequencedRules = sequenceRules(rulesWithAnchoredSteps)

        sequencedRules shouldHaveSize(1)
        sequencedRules[0] shouldBe instanceOf<IntermediateRomanize>()
    }

    "Sequencing a romanizer followed by a clear-syllables includes both" {
        val rulesWithAnchoredSteps = listOf(
            RuleWithAnchoredSteps(
                null,
                listOf(
                    intermediateRomanizer("foo"),
                    clearSyllables(),
                )
            )
        )

        val sequencedRules = sequenceRules(rulesWithAnchoredSteps)

        sequencedRules shouldHaveSize(2)
        sequencedRules[0] shouldBe instanceOf<IntermediateRomanize>()
        sequencedRules[1] shouldBe instanceOf<Syllabify>()
    }

    "Sequencing a cleanup rule includes immediate execution of the rule" {
        val rulesWithAnchoredSteps = listOf(
            RuleWithAnchoredSteps(
                rule("foo"),
                listOf(cleanup("bar"))
            )
        )

        val sequencedRules = sequenceRules(rulesWithAnchoredSteps)

        sequencedRules shouldHaveSize(3)
        sequencedRules[0] shouldBe instanceOf<CleanUp>()
        sequencedRules[1] shouldBe instanceOf<ApplyRule>()
        sequencedRules[2] shouldBeSameInstanceAs(sequencedRules[0])
    }

    "Sequencing a cleanup rule doesn't include it after the final romanizer" {
        val rulesWithAnchoredSteps = listOf(
            RuleWithAnchoredSteps(
                rule("romanizer", ruleType = RuleType.ROMANIZER),
                listOf(cleanup("foo"))
            )
        )

        val sequencedRules = sequenceRules(rulesWithAnchoredSteps)

        sequencedRules shouldHaveSize(2)
        sequencedRules[0] shouldBe instanceOf<CleanUp>()
        sequencedRules[1] shouldBe instanceOf<ApplyRule>()
    }

    "Start-at cuts off named rules before the specified rule" {
        val allRules = listOf(
            ApplyRule(rule("foo")),
            ApplyRule(rule("bar")),
        )

        val rulesAfter = applyStartAndStop(allRules, startAt = "bar")

        rulesAfter shouldHaveSize(1)
        (rulesAfter[0] as ApplyRule).rule.name shouldBe "bar"
    }

    "Start-at preserves a syllable rule immediately before the specified rule" {
        val allRules = listOf(
            Syllabify(Declarations.empty),
            ApplyRule(rule("foo")),
            Syllabify(Declarations.empty),
            Syllabify(Declarations.empty),
            ApplyRule(rule("bar")),
        )

        val rulesAfter = applyStartAndStop(allRules, startAt = "bar")

        rulesAfter shouldHaveSize(2)
        rulesAfter[0] shouldBe instanceOf<Syllabify>()
        rulesAfter[1] shouldBe instanceOf<ApplyRule>()
        (rulesAfter[1] as ApplyRule).rule.name shouldBe "bar"
    }

    "Stop-before cuts off everything the specified named rule and everything after it" {
        val allRules = listOf(
            ApplyRule(rule("foo")),
            ApplyRule(rule("bar")),
        )

        val rulesAfter = applyStartAndStop(allRules, stopBefore = "bar")

        rulesAfter shouldHaveSize(1)
        (rulesAfter[0] as ApplyRule).rule.name shouldBe "foo"
    }
})