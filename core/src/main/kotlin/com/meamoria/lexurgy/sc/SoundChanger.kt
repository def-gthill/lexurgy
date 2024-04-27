package com.meamoria.lexurgy.sc

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

    private val sequencedRules = sequenceRules(rules)

    /**
     * The list of rule names that will be used in any tracing
     * output, in the order that the rules get applied.
     */
    val ruleNames: List<String> by lazy {
        var lastRuleName = "<initial>"
        var syllableRulesFoundAfterLastRule = 0
        sequencedRules.map {
            when (it) {
                is ApplyRule -> {
                    syllableRulesFoundAfterLastRule = 0
                    lastRuleName = it.rule.name
                    it.rule.name
                }
                is IntermediateRomanize -> it.rule.name
                is Syllabify -> {
                    syllableRulesFoundAfterLastRule += 1
                    "<syllables>/$lastRuleName/$syllableRulesFoundAfterLastRule"
                }
                is CleanUp -> "<cleanup>/$lastRuleName/${it.rule.name}"
            }
        }
    }

    operator fun invoke(word: String): String = change(listOf(word)).single()

    /**
     * Run the sound changer on the specified words.
     *
     * Throws an exception as soon as it encounters an error in any word.
     *
     * @param words The list of words to change
     * @param options Sound change options
     */
    fun change(
        words: List<String>,
        options: SoundChangeOptions = SoundChangeOptions(),
    ): List<String> = changeWithIntermediates(
        words,
        options = options,
    ).getValue(null)

    /**
     * Run the sound changer on the specified words, returning
     * a `Result` for each word encapsulating any errors encountered
     * when applying the changes to that word.
     *
     * @param words The list of words to change
     * @param options Sound change options
     */
    fun changeWithIndividualErrors(
        words: List<String>,
        options: SoundChangeOptions = SoundChangeOptions(),
    ): List<Result<String>> = changeWithIntermediatesAndIndividualErrors(
        words,
        options = options,
    ).getValue(null)

    /**
     * Runs the sound changes on the specified words, capturing
     * intermediate stages using the sound changer's
     * intermediate romanizers. This produces a map associating
     * the name of each romanizer to the intermediate
     * words produced by that romanizer. The final results are
     * included under the ``null`` key.
     *
     * @param words The list of words to change
     * @param options Sound change options
     */
    fun changeWithIntermediates(
        words: List<String>,
        options: SoundChangeOptions = SoundChangeOptions(),
    ): Map<String?, List<String>> {
        val fullResult = changeWithIntermediatesAndIndividualErrors(
            words = words,
            options = options,
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
     * @param words The list of words to change
     * @param options Sound change options
     */
    fun changeWithIntermediatesAndIndividualErrors(
        words: List<String>,
        options: SoundChangeOptions = SoundChangeOptions(),
    ): Map<String?, List<Result<String>>> = SoundChangeSession.run(
        initialDeclarations = initialDeclarations,
        sequencedRules = sequencedRules,
        words = words,
        options,
    )

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
                SoundChangeOptions(
                    startAt = startAt,
                    stopBefore = stopBefore,
                    debugWords = debugWords,
                )
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
