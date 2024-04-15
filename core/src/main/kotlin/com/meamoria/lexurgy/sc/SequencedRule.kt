package com.meamoria.lexurgy.sc

sealed interface SequencedRule

data class ApplyRule(val rule: NamedRule) : SequencedRule

data class IntermediateRomanize(val rule: IntermediateRomanizer) : SequencedRule

data class Syllabify(val declarations: Declarations) : SequencedRule

data class CleanUp(val rule: NamedRule) : SequencedRule

fun sequenceRules(rulesWithAnchoredSteps: List<RuleWithAnchoredSteps>): List<SequencedRule> {
    var persistentSyllabify: Syllabify? = null
    val persistentCleanups = mutableListOf<CleanUp>()
    val result = mutableListOf<SequencedRule>()

    fun applyAnchoredStep(anchoredStep: AnchoredStep) {
        when (anchoredStep) {
            is IntermediateRomanizerStep -> {
                result += IntermediateRomanize(anchoredStep.romanizer)
            }

            is CleanupStep -> {
                val cleanup = CleanUp(anchoredStep.cleanupRule)
                result += cleanup
                persistentCleanups += cleanup
            }

            is CleanupOffStep -> {
                persistentCleanups.removeAll { it.rule.name == anchoredStep.ruleName }
            }

            is SyllabificationStep -> {
                val syllabify = Syllabify(anchoredStep.declarations)
                result += syllabify
                persistentSyllabify = syllabify
            }
        }
    }

    val fullRules = rulesWithAnchoredSteps + listOf(RuleWithAnchoredSteps(null, emptyList()))

    for (rule in fullRules) {
        // Always run persistent cleanup rules first.
        // They have to run before any syllabification rules,
        // and if they're about to be cancelled, they need one
        // last chance to run.
        result.addAll(persistentCleanups)
        val stepsToRunBeforeSyllabification =
            if (rule.anchoredSteps.firstOrNull() is IntermediateRomanizerStep)
                0 else 1
        for (anchoredStep in rule.anchoredSteps.take(stepsToRunBeforeSyllabification)) {
            // Then run the *first* new anchored step (if it isn't a romanizer).
            // The first step is considered "more tightly bound" to the preceding
            // rule, and can intervene before persistent syllabification
            // rules.
            applyAnchoredStep(anchoredStep)
        }
        // Now run the persistent syllabification rule, if any.
        persistentSyllabify?.let {
            if (result.lastOrNull() != it) result += it
        }
        for (anchoredStep in rule.anchoredSteps.drop(stepsToRunBeforeSyllabification)) {
            // Now run the remaining anchored steps, in declaration order.
            applyAnchoredStep(anchoredStep)
        }
        if (rule.rule != null) {
            result += ApplyRule(rule.rule)
        }
    }
    return result
}

fun applyStartAndStop(
    rules: List<SequencedRule>,
    startAt: String? = null,
    stopBefore: String? = null
): List<SequencedRule> {
    var startIndex: Int
    if (startAt == null) {
        startIndex = 0
    } else {
        startIndex = rules.indexOfFirst { it is ApplyRule && it.rule.name == startAt }
        if (startIndex < 0) {
            throw LscRuleNotFound(startAt, "start at")
        }
    }
    if (startIndex > 0 && rules[startIndex - 1] is Syllabify) {
        startIndex -= 1
    }
    val stopIndex: Int
    if (stopBefore == null) {
        stopIndex = rules.size
    } else {
        stopIndex = rules.indexOfFirst { it is ApplyRule && it.rule.name == stopBefore}
        if (stopIndex < 0) {
            throw LscRuleNotFound(stopBefore, "stop before")
        }
    }
    return rules.drop(startIndex).take(stopIndex - startIndex)
}
