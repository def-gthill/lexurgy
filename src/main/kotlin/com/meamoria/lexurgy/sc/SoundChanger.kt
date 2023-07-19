package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import com.meamoria.lexurgy.word.Phrase
import kotlin.streams.toList

class SoundChanger(
    val initialDeclarations: Declarations,
    val rules: List<RuleWithAnchoredSteps>,
) {
    init {
        val duplicated = rules.groupBy {
            it.rule?.name
        }.filterValues { it.size > 1 }.keys.firstOrNull()
        if (duplicated != null) {
            throw LscDuplicateName("rule", duplicated)
        }
    }

    /**
     * The list of rule names that will be used in any tracing
     * output, in the order that the rules get applied.
     */
    val ruleNames: List<String> by lazy {
        rules.flatMap {
            val ruleName = it.rule?.name
            val anchoredStepNames = it.anchoredSteps.mapNotNull { step ->
                when (step) {
                    is IntermediateRomanizerStep -> step.romanizer.name
                    is CleanupStep -> step.cleanupRule.name
                    is SyllabificationStep -> "syllables"
                    else -> null
                }
            }
            anchoredStepNames + listOfNotNull(ruleName)
        }
    }

    operator fun invoke(word: String): String = change(listOf(word)).single()

    /**
     * Run the sound changer on the specified words.
     *
     * Throws an exception as soon as it encounters an error in any word.
     *
     * @param words The list of words to change
     * @param startAt If provided, ignore all rules before the one with the specified name
     * @param stopBefore If provided, ignore the rule with the specified name and all rules after it
     * @param debugWords Words to trace the evolution of
     * @param romanize True to run the romanizer (if any), false to ignore it
     * @param debug Function to call with tracing output
     */
    fun change(
        words: List<String>,
        startAt: String? = null,
        stopBefore: String? = null,
        debugWords: List<String> = emptyList(),
        romanize: Boolean = true,
        debug: (String) -> Unit = ::println,
        trace: (TraceInfo) -> Unit = { },
    ): List<String> = changeWithIntermediates(
        words,
        startAt = startAt,
        stopBefore = stopBefore,
        debugWords = debugWords,
        romanize = romanize,
        debug = debug,
        trace = trace,
    ).getValue(null)

    /**
     * Run the sound changer on the specified words, returning
     * a `Result` for each word encapsulating any errors encountered
     * when applying the changes to that word.
     *
     * Parameters are the same as `change`.
     */
    fun changeWithIndividualErrors(
        words: List<String>,
        startAt: String? = null,
        stopBefore: String? = null,
        debugWords: List<String> = emptyList(),
        romanize: Boolean = true,
        debug: (String) -> Unit = ::println,
        trace: (TraceInfo) -> Unit = { },
    ): List<Result<String>> = changeWithIntermediatesAndIndividualErrors(
        words,
        startAt = startAt,
        stopBefore = stopBefore,
        debugWords = debugWords,
        romanize = romanize,
        debug = debug,
        trace = trace,
    ).getValue(null)

    /**
     * Runs the sound changes on the specified words, capturing
     * intermediate stages using the sound changer's
     * intermediate romanizers. This produces a map associating
     * the name of each romanizer to the intermediate
     * words produced by that romanizer. The final results are
     * included under the ``null`` key.
     *
     * Parameters are the same as `change`.
     */
    fun changeWithIntermediates(
        words: List<String>,
        startAt: String? = null,
        stopBefore: String? = null,
        debugWords: List<String> = emptyList(),
        romanize: Boolean = true,
        debug: (String) -> Unit = ::println,
        trace: (TraceInfo) -> Unit = { },
    ): Map<String?, List<String>> {
        val fullResult = changeWithIntermediatesAndIndividualErrors(
            words = words,
            startAt = startAt,
            stopBefore = stopBefore,
            debugWords = debugWords,
            romanize = romanize,
            debug = debug,
            trace = trace,
        )
        return fullResult.mapValues { (_, outputWords) ->
            outputWords.map { it.getOrThrow() }
        }
    }

    /**
     * Runs the sound changer on the specified words, encapsulating
     * errors in `Result` objects like `changeWithIndividualErrors` AND
     * capturing intermediate stages like `changeWithIndermediates`.
     *
     * Parameters are the same as `change`.
     */
    fun changeWithIntermediatesAndIndividualErrors(
        words: List<String>,
        startAt: String? = null,
        stopBefore: String? = null,
        debugWords: List<String> = emptyList(),
        romanize: Boolean = true,
        debug: (String) -> Unit = ::println,
        trace: (TraceInfo) -> Unit = { },
    ): Map<String?, List<Result<String>>> {
        val tracer = words.withIndex()
            .filter { it.value in debugWords }
            .associate { it.index to it.value }
            .let { Tracer(debug, trace, it) }
        val persistentEffects = PersistentEffects()
        val startPhrases = words.map {
            Phrase(
                it.split(" ").map(
                    initialDeclarations::parsePhonetic
                )
            )
        }

        val result = mutableMapOf<String?, List<Result<String>>>()

        var curPhrases = startPhrases.map { Result.success(it) }
        var started = false
        var stopped = false

        fun maybeReplace(realRomanizer: NamedRule): NamedRule =
            if (romanize) realRomanizer else StandardNamedRule(
                "fake-romanizer", initialDeclarations, EmptyRule
            )

        fun runAnchoredStep(anchoredStep: AnchoredStep) {
            when (anchoredStep) {
                is IntermediateRomanizerStep -> {
                    if (!started) {
                        return
                    }
                    val rom = anchoredStep.romanizer
                    result[rom.name] = applyRule(
                        maybeReplace(rom), words, curPhrases, tracer
                    ).map { res -> res.map { it.string } }
                }

                is CleanupStep -> {
                    if (!started) {
                        return
                    }
                    curPhrases = applyRule(
                        anchoredStep.cleanupRule, words, curPhrases, tracer
                    )
                }

                is CleanupOffStep -> {
                    persistentEffects.removeCleanupRule(anchoredStep.ruleName)
                }

                is SyllabificationStep -> {
                    if (!started) {
                        return
                    }
                    curPhrases = applySyllables(
                        anchoredStep.declarations, curPhrases, tracer
                    )
                }
            }
        }

        for (ruleWithAnchoredSteps in rules) {
            val rule = ruleWithAnchoredSteps.rule

            for (anchoredStep in persistentEffects.cleanupRules) {
                // Always run persistent cleanup rules first.
                // They have to run before any syllabification rules,
                // and if they're about to be cancelled, they need one
                // last chance to run.
                runAnchoredStep(anchoredStep)
            }

            if (!started && (startAt == null || rule?.name == startAt)) {
                started = true
            }

            val stepsToRunBeforeSyllabification =
                if (ruleWithAnchoredSteps.anchoredSteps.firstOrNull() is IntermediateRomanizerStep)
                    0 else 1

            for (anchoredStep in ruleWithAnchoredSteps.anchoredSteps.take(stepsToRunBeforeSyllabification)) {
                // Then run the *first* new anchored step (if it isn't a romanizer).
                // The first step is considered "more tightly bound" to the preceding
                // rule, and can intervene before persistent syllabification
                // rules.
                runAnchoredStep(anchoredStep)
                persistentEffects += anchoredStep
            }

            persistentEffects.syllabificationStep?.let {
                // Now run the persistent syllabification rule, if any.
                runAnchoredStep(it)
            }

            for (anchoredStep in ruleWithAnchoredSteps.anchoredSteps.drop(stepsToRunBeforeSyllabification)) {
                // Now run the remaining anchored steps, in declaration order.
                runAnchoredStep(anchoredStep)
                persistentEffects += anchoredStep
            }

            if (stopBefore != null && rule?.name == stopBefore) {
                stopped = true
                break
            }

            if (started) {
                if (rule != null && (romanize || rule.ruleType != RuleType.ROMANIZER)) {
                    curPhrases = applyRule(
                        rule, words, curPhrases, tracer
                    )
                }
            }
        }

        if (stopBefore != null && !stopped) {
            throw LscRuleNotFound(stopBefore, "stop before")
        }
        if (startAt != null && !started) {
            throw LscRuleNotFound(startAt, "start at")
        }

        result[null] = curPhrases.map { phrase ->
            phrase.map {
                it.string.normalizeCompose()
            }
        }

        return result
    }

    private class PersistentEffects(
        var syllabificationStep: SyllabificationStep? = null,
        val cleanupRules: MutableList<CleanupStep> = mutableListOf(),
    ) {
        operator fun plusAssign(effect: AnchoredStep) {
            when (effect) {
                is SyllabificationStep -> syllabificationStep = effect
                is CleanupStep -> cleanupRules += effect
                else -> Unit // No persistent effect
            }
        }

        fun removeCleanupRule(ruleName: String) {
            cleanupRules.removeAll { it.cleanupRule.name == ruleName }
        }
    }

    private class Tracer(
        val debug: (String) -> Unit,
        val tracer: (TraceInfo) -> Unit,
        val indexToDebugWords: Map<Int, String>,
    ) {
        init {
            if (indexToDebugWords.isNotEmpty()) {
                debug("Tracing ${indexToDebugWords.values.joinToString(", ")}")
            }
        }

        operator fun invoke(
            name: String,
            curPhrases: List<Result<Phrase>>,
            newPhrases: List<Result<Phrase>>,
        ) {
            for (i in indexToDebugWords.keys) {
                if (newPhrases[i] != curPhrases[i]) {
                    debug("Applied ${name}${appliedTo(i)}: ${curPhrases[i].string} -> ${newPhrases[i].string}")
                    tracer(
                        TraceInfo(
                            indexToDebugWords[i]!!,
                            name,
                            curPhrases[i].string,
                            newPhrases[i].string,
                        )
                    )
                }
            }
        }

        private val Result<Phrase>.string: String
            get() = map { it.string }.getOrElse { "ERROR" }

        fun appliedTo(index: Int): String =
            if (indexToDebugWords.size > 1) {
                " to ${indexToDebugWords[index]}"
            } else {
                ""
            }
    }

    data class TraceInfo(
        val ruleName: String,
        val originalWord: String,
        val wordBeforeChange: String,
        val wordAfterChange: String,
    )

    private fun applySyllables(
        declarations: Declarations,
        curPhrases: List<Result<Phrase>>,
        tracer: Tracer,
    ): List<Result<Phrase>> =
        curPhrases.map { curResult ->
            curResult.mapCatching {
                declarations.syllabify(it)
            }
        }.also { newPhrases ->
            tracer("syllables", curPhrases, newPhrases)
        }

    private fun applyRule(
        rule: NamedRule,
        origPhrases: List<String>,
        curPhrases: List<Result<Phrase>>,
        tracer: Tracer,
    ): List<Result<Phrase>> =
        curPhrases.fastZipMap(origPhrases) { curResult, phrase ->
            curResult.mapCatching { curPhrase ->
                try {
                    rule(curPhrase).removeBoundingBreaks()
                } catch (e: Exception) {
                    if (e is UserError) throw LscRuleNotApplicable(e, rule.name, phrase, curPhrase.string)
                    else throw LscRuleCrashed(e, rule.name, phrase, curPhrase.string)
                }
            }
        }.also { newPhrases ->
            tracer(rule.name, curPhrases, newPhrases)
        }

    data class RuleWithAnchoredSteps(
        val rule: NamedRule?,
        val anchoredSteps: List<AnchoredStep>,
    )

    sealed interface AnchoredStep

    data class IntermediateRomanizerStep(val romanizer: NamedRule) : AnchoredStep

    data class CleanupStep(val cleanupRule: NamedRule) : AnchoredStep

    data class CleanupOffStep(val ruleName: String) : AnchoredStep

    data class SyllabificationStep(val declarations: Declarations) : AnchoredStep

    companion object {
        fun change(
            changes: String,
            words: List<String>,
            startAt: String? = null,
            stopBefore: String? = null,
            debugWords: List<String> = emptyList()
        ): List<String> {
            val changer = fromLsc(changes)
            return changer.change(
                words,
                startAt = startAt,
                stopBefore = stopBefore,
                debugWords = debugWords
            )
        }

        fun fromLsc(code: String): SoundChanger {
            val parser = LscInterpreter()
            return (parser.parseFile(code) as LscWalker.SoundChangerNode).soundChanger
        }

        /**
         * A rule with no anchored steps
         */
        fun plainRule(rule: NamedRule): RuleWithAnchoredSteps =
            RuleWithAnchoredSteps(rule, emptyList())
    }

    override fun toString(): String = rules.joinToString(
        separator = "; ", prefix = "SoundChanger(", postfix = ")"
    )
}

internal fun Iterable<String>.maxLength(): Int = maxOfOrNull { it.lengthCombining() } ?: 0

fun <T, U, R> Iterable<T>.fastZipMap(other: Iterable<U>, function: (T, U) -> R): List<R> =
    zip(other).parallelStream().map { function(it.first, it.second) }.toList()

class LscRuleNotApplicable(
    val reason: UserError,
    val rule: String,
    val originalWord: String,
    val currentWord: String
) : LscUserError(
    "Rule $rule could not be applied to word $currentWord (originally $originalWord)\n${reason.message}",
    reason
)

class LscRuleCrashed(
    val reason: Exception,
    val rule: String,
    val originalWord: String,
    val currentWord: String,
) :
    Exception(
        "Rule $rule encountered a programming error when applied to word $currentWord (originally $originalWord)",
        reason
    )

class LscRuleNotFound(val ruleName: String, val attemptedAction: String) :
    LscUserError("Can't $attemptedAction rule $ruleName; there is no rule with that name")
