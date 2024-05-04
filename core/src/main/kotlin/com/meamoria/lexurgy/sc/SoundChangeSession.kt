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

class SoundChangeSession private constructor(
    val initialDeclarations: Declarations,
    val sequencedRules: List<SequencedRule>,
    val words: List<String>,
    val options: SoundChangeOptions = SoundChangeOptions(),
) {
    private val executor = ForkJoinPool()
    private val timer = Timer(true)

    @Volatile
    private var timedOut = false

    private val activeRules = applyStartAndStop(
        sequencedRules,
        options.startAt,
        options.stopBefore,
    )
    private val indexToDebugWords = words.withIndex()
        .filter { it.value in options.debugWords }
        .associate { it.index to it.value }

    private var curPhrases = words.map { row ->
        row.split("\t").map { cell ->
            val phoneticWords = cell.trim().split(" ").map(
                initialDeclarations::parsePhonetic
            )
            val phrase = Phrase(phoneticWords)
            Result.success(phrase)
        }
    }
    private var lastRule: NamedRule? = null
    private var syllableRulesRunAfterLastRule = 0
    private val result = mutableMapOf<String?, List<Result<String>>>()

    private fun run(): Map<String?, List<Result<String>>> {
        val resultTask = executor.submit(Callable {
            runInThread()
        })

        val timerTask = startTimer()

        try {
            val result = resultTask.get()
            return if (timedOut) {
                injectRunTimedOutException(result)
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

    private fun startTimer(): TimerTask? {
        var timerTask: TimerTask? = null
        timedOut = false
        if (options.totalTimeoutSeconds != null) {
            timerTask = timer.schedule((options.totalTimeoutSeconds * 1000).toLong()) {
                executor.shutdownNow()
                timedOut = true
            }
        }
        return timerTask
    }

    private fun injectRunTimedOutException(
        result: Map<String?, List<Result<String>>>
    ): Map<String?, List<Result<String>>> =
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

    private fun runInThread(): Map<String?, List<Result<String>>> {
        startTracing()

        for (sequencedRule in activeRules) {
            when (sequencedRule) {
                is ApplyRule -> {
                    val rule = sequencedRule.rule

                    if (options.romanize || rule.ruleType != RuleType.ROMANIZER) {
                        curPhrases = applyRule(
                            rule,
                            words,
                            curPhrases,
                            options.singleStepTimeoutSeconds,
                        )
                    }

                    lastRule = rule
                    syllableRulesRunAfterLastRule = 0
                }

                is IntermediateRomanize -> {
                    val romanizer = sequencedRule.rule

                    result[romanizer.stageName] = applyRule(
                        maybeReplace(romanizer),
                        words,
                        curPhrases,
                        options.singleStepTimeoutSeconds,
                    ).map { row ->
                        runCatching {
                            row.joinToString("\t") { res ->
                                res.getOrThrow().string
                            }
                        }
                    }
                }

                is Syllabify -> {
                    curPhrases = applySyllables(
                        sequencedRule.declarations, words, curPhrases
                    )
                }

                is CleanUp -> {
                    curPhrases = applyRule(
                        sequencedRule.rule,
                        words,
                        curPhrases,
                        options.singleStepTimeoutSeconds,
                        tracingRuleNameOverride = "<cleanup>/$lastRuleName/${sequencedRule.rule.name}"
                    )
                }
            }
        }

        result[null] = curPhrases.map { row ->
            runCatching {
                row.joinToString("\t") { phrase ->
                    phrase.getOrThrow().string.normalizeCompose()
                }
            }
        }

        return result
    }

    fun maybeReplace(realRomanizer: NamedRule): NamedRule =
        if (options.romanize) realRomanizer else StandardNamedRule(
            "fake-romanizer", initialDeclarations, EmptyRule
        )

    private fun startTracing() {
        if (indexToDebugWords.isNotEmpty()) {
            options.debug("Tracing ${indexToDebugWords.values.joinToString(", ")}")
        }
    }

    private val lastRuleName: String
        get() = lastRule?.name ?: "<initial>"

    private fun trace(
        name: String,
        curPhrases: List<List<Result<Phrase>>>,
        newPhrases: List<List<Result<Phrase>>>,
    ) {
        for (i in indexToDebugWords.keys) {
            val curPhrase = curPhrases[i].joinToString("\t") { it.string }
            val newPhrase = newPhrases[i].joinToString("\t") { it.string }
            if (newPhrase != curPhrase) {
                options.debug("Applied ${name}${appliedTo(i)}: $curPhrase -> $newPhrase")
                options.trace(
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

    private fun appliedTo(index: Int): String =
        if (indexToDebugWords.size > 1) {
            " to ${indexToDebugWords[index]}"
        } else {
            ""
        }

    private fun applySyllables(
        declarations: Declarations,
        origPhrases: List<String>,
        curPhrases: List<List<Result<Phrase>>>,
    ): List<List<Result<Phrase>>> {
        syllableRulesRunAfterLastRule += 1
        val syllableRuleName = "<syllables>/$lastRuleName/$syllableRulesRunAfterLastRule"
        return curPhrases.zip(origPhrases).map { (curRow, orig) ->
            curRow.map { curResult ->
                curResult.mapCatching { curPhrase ->
                    wrapError(syllableRuleName, orig, curPhrase.string) {
                        declarations.syllabify(curPhrase)
                    }
                }
            }
        }.also { newPhrases ->
            trace(syllableRuleName, curPhrases, newPhrases)
        }
    }

    private fun applyRule(
        rule: NamedRule,
        origPhrases: List<String>,
        curPhrases: List<List<Result<Phrase>>>,
        singleStepTimeoutSeconds: Double?,
        tracingRuleNameOverride: String? = null,
    ): List<List<Result<Phrase>>> =
        curPhrases.zip(origPhrases).parallelStream().map { (curRow, orig) ->
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
            val result = curRow.map { curResult ->
                curResult.mapCatching { curPhrase ->
                    wrapError(rule.name, orig, curPhrase.string) {
                        rule(curPhrase).removeBoundingBreaks()
                    }
                }
            }
            timerTask?.cancel()
            result
        }.toList().also { newPhrases ->
            trace(tracingRuleNameOverride ?: rule.name, curPhrases, newPhrases)
        }

    private fun <T> wrapError(
        ruleName: String,
        originalPhrase: String,
        currentPhrase: String,
        block: () -> T
    ): T {
        try {
            return block()
        } catch (e: Exception) {
            if (timedOut) {
                throw RunTimedOut(e)
            } else if (e is UserError) {
                throw LscRuleNotApplicable(e, ruleName, originalPhrase, currentPhrase)
            } else {
                throw LscRuleCrashed(e, ruleName, originalPhrase, currentPhrase)
            }
        }
    }

    companion object {
        fun run(
            initialDeclarations: Declarations,
            sequencedRules: List<SequencedRule>,
            words: List<String>,
            options: SoundChangeOptions = SoundChangeOptions(),
        ): Map<String?, List<Result<String>>> {
            val session = SoundChangeSession(
                initialDeclarations = initialDeclarations,
                sequencedRules = sequencedRules,
                words = words,
                options,
            )
            return session.run()
        }
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