package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.LscUserError
import com.meamoria.lexurgy.UserError
import com.meamoria.lexurgy.normalizeCompose
import com.meamoria.lexurgy.word.Phrase
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.ForkJoinPool
import kotlin.concurrent.schedule
import kotlin.streams.toList

class SoundChangeSession(
    val initialDeclarations: Declarations,
    val rules: List<RuleWithAnchoredSteps>,
    val words: List<String>,
    val options: SoundChangeOptions = SoundChangeOptions(),
) {
    val timer = Timer(true)
    @Volatile
    var timedOut = false

    fun run(): Map<String?, List<Result<String>>> {
        val executor = ForkJoinPool()

        val resultTask = executor.submit(Callable {
            val tracer = words.withIndex()
                .filter { it.value in options.debugWords }
                .associate { it.index to it.value }
                .let { Tracer(options.debug, options.trace, it) }
            val persistentEffects = PersistentEffects()
            val startPhrases = words.map { row ->
                row.split("\t").map { cell ->
                    Phrase(
                        cell.trim().split(" ").map(
                            initialDeclarations::parsePhonetic
                        )
                    )
                }
            }

            val result = mutableMapOf<String?, List<Result<String>>>()

            var curPhrases = startPhrases.map { row -> row.map { Result.success(it) } }
            var started = false
            var stopped = false

            fun maybeReplace(realRomanizer: NamedRule): NamedRule =
                if (options.romanize) realRomanizer else StandardNamedRule(
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
                            maybeReplace(rom),
                            words,
                            curPhrases,
                            tracer,
                            options.singleStepTimeoutSeconds,
                        ).map { row ->
                            runCatching {
                                row.joinToString("\t") { res ->
                                    res.getOrThrow().string
                                }
                            }
                        }
                    }

                    is CleanupStep -> {
                        if (!started) {
                            return
                        }
                        curPhrases = applyRule(
                            anchoredStep.cleanupRule,
                            words,
                            curPhrases,
                            tracer,
                            options.singleStepTimeoutSeconds,
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

                if (!started && (options.startAt == null || rule?.name == options.startAt)) {
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

                if (options.stopBefore != null && rule?.name == options.stopBefore) {
                    stopped = true
                    break
                }

                if (started) {
                    if (rule != null && (options.romanize || rule.ruleType != RuleType.ROMANIZER)) {
                        curPhrases = applyRule(
                            rule,
                            words,
                            curPhrases,
                            tracer,
                            options.singleStepTimeoutSeconds,
                        )
                    }
                }
            }

            if (options.stopBefore != null && !stopped) {
                throw LscRuleNotFound(options.stopBefore, "stop before")
            }
            if (options.startAt != null && !started) {
                throw LscRuleNotFound(options.startAt, "start at")
            }

            result[null] = curPhrases.map { row ->
                runCatching {
                    row.joinToString("\t") { phrase ->
                        phrase.getOrThrow().string.normalizeCompose()
                    }
                }
            }

            result
        })

        var timerTask: TimerTask? = null
        timedOut = false
        if (options.totalTimeoutSeconds != null) {
            timerTask = timer.schedule((options.totalTimeoutSeconds * 1000).toLong()) {
                executor.shutdownNow()
                timedOut = true
            }
        }

        try {
            val result = resultTask.get()
            return if (timedOut) {
                result.mapValues { (_, wordResults) ->
                    wordResults.map { wordResult ->
                        wordResult.recoverCatching { e ->
                            if (e is LscRuleNotApplicable) {
                                throw RunTimedOut(e.reason)
                            } else {
                                throw e
                            }
                        }
                    }
                }
            } else {
                result
            }
        } catch (e: ExecutionException) {
            var reason: Throwable = e
            while (reason !is RunTimedOut) {
                reason = reason.cause ?: throw reason
            }
            throw reason
        } finally {
            timerTask?.cancel()
            executor.shutdown()
        }
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
            curPhrases: List<List<Result<Phrase>>>,
            newPhrases: List<List<Result<Phrase>>>,
        ) {
            for (i in indexToDebugWords.keys) {
                val curPhrase = curPhrases[i].joinToString("\t") { it.string }
                val newPhrase = newPhrases[i].joinToString("\t") { it.string }
                if (newPhrase != curPhrase) {
                    debug("Applied ${name}${appliedTo(i)}: $curPhrase -> $newPhrase")
                    tracer(
                        TraceInfo(
                            name,
                            indexToDebugWords[i]!!,
                            curPhrase,
                            newPhrase,
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

    private fun applySyllables(
        declarations: Declarations,
        curPhrases: List<List<Result<Phrase>>>,
        tracer: Tracer,
    ): List<List<Result<Phrase>>> =
        curPhrases.map { row ->
            row.map { curResult ->
                curResult.mapCatching {
                    declarations.syllabify(it)
                }
            }
        }.also { newPhrases ->
            tracer("syllables", curPhrases, newPhrases)
        }

    private fun applyRule(
        rule: NamedRule,
        origPhrases: List<String>,
        curPhrases: List<List<Result<Phrase>>>,
        tracer: Tracer,
        singleStepTimeoutSeconds: Double?,
    ): List<List<Result<Phrase>>> =
        curPhrases.zip(origPhrases).parallelStream().map { (cur, orig) ->
            if (this.timedOut) throw RunTimedOut(TooManyWords())
            var timerTask: TimerTask? = null
            var timedOut = false
            if (singleStepTimeoutSeconds != null) {
                val thisThread = Thread.currentThread()
                timerTask = timer.schedule((singleStepTimeoutSeconds * 1000).toLong()) {
                    thisThread.interrupt()
                    timedOut = true
                }
            }
            val result = cur.map { row ->
                row.mapCatching { curPhrase ->
                try {
                    rule(curPhrase).removeBoundingBreaks()
                } catch (e: Exception) {
                    if (timedOut) {
                        throw RunTimedOut(e)
                    } else if (e is UserError) {
                        throw LscRuleNotApplicable(e, rule.name, orig, curPhrase.string)
                    } else {
                        throw LscRuleCrashed(e, rule.name, orig, curPhrase.string)
                    }
                }
            }
                }
            timerTask?.cancel()
            result
        }.toList().also { newPhrases ->
            tracer(rule.name, curPhrases, newPhrases)
        }
}

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


class RunTimedOut(
    val reason: Exception
) : Exception("Run timed out: ${reason.message}")

class TooManyWords : Exception("Too many input words")