package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.*

class EnvironmentMatcher(
    val element: Matcher,
    val environment: CompoundEnvironment,
) : LiftingMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val claimEnds = element.claim(phrase, start, bindings, partial)
        return claimEnds.mapNotNull { claimEnd ->
            environment.check(
                phrase, start,
                claimEnd.index, claimEnd.returnBindings,
            )?.let {
                claimEnd.updateBindings(it)
            }
        }
    }

    override fun length(bindings: Bindings): Int? = element.length(bindings)

    override fun reversed(): Matcher =
        EnvironmentMatcher(element.reversed(), environment.reversed())

    override fun toString(): String = "$element$environment"

    override fun liftingTransformerTo(result: Emitter, filtered: Boolean): Transformer =
        EnvironmentTransformer(element.transformerTo(result, filtered), environment)
}

class EnvironmentTransformer(
    val element: Transformer,
    val environment: CompoundEnvironment,
) : Transformer {
    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> {
        val transformations = element.transform(
            order, phrase, start, bindings
        )
        return transformations.mapNotNull { transformation ->
            environment.check(
                phrase, start,
                transformation.end, transformation.returnBindings
            )?.let {
                transformation.updateBindings(it)
            }
        }
    }

    override fun toString(): String =
        "$element$environment"
}

/**
 * A lookahead/lookbehind condition that tests whether the material
 * before and after a match fits the specified criteria.
 * The check passes if at least one of the ``positive`` environments
 * is satisfied (or the list is empty), and if none of the ``negative``
 * environments are satisfied.
 */
class CompoundEnvironment(val positive: List<Environment>, val negative: List<Environment>) {

    private val realPositive =
        if (positive.isEmpty()) listOf(Environment(EmptyMatcher, EmptyMatcher))
        else positive.map { it.beforeReversed() }

    private val realNegative = negative.map { it.beforeReversed() }

    fun check(
        phrase: Phrase,
        matchStart: PhraseIndex,
        matchEnd: PhraseIndex,
        bindings: Bindings,
    ): Bindings? {
        val positiveBindings = realPositive.firstNotNullOfOrNull { environment ->
            environment.check(
                phrase, matchStart, matchEnd, bindings
            )
        } ?: return null
        for (environment in realNegative) {
            environment.check(
                phrase, matchStart, matchEnd, positiveBindings
            )?.let { return null }
        }
        return positiveBindings
    }

    fun reversed(): CompoundEnvironment =
        CompoundEnvironment(
            positive.map { it.reversed() },
            negative.map { it.reversed() }
        )

    override fun toString(): String =
        "${environtext("/", positive)}${environtext("//", negative)}"

    private fun environtext(sep: String, environ: List<Environment>) =
        when (environ.size) {
            0 -> ""
            1 -> " $sep ${environ.single()}"
            else -> " $sep ${environ.joinToString(prefix = "{", postfix = "}")}"
        }
}

class Environment(val before: Matcher, val after: Matcher) {
    fun check(
        phrase: Phrase,
        matchStart: PhraseIndex,
        matchEnd: PhraseIndex,
        bindings: Bindings,
    ): Bindings? {
        val reversedPhrase = phrase.fullyReversed()
        val beforeEnd = before.claim(
            reversedPhrase, phrase.reversedIndex(matchStart), bindings
        )
        if (beforeEnd.isEmpty()) return null
        val afterEnd = after.claim(
            phrase, matchEnd, beforeEnd.first().returnBindings
        )
        if (afterEnd.isEmpty()) return null
        return afterEnd.first().returnBindings
    }

    fun beforeReversed(): Environment = Environment(before.reversed(), after)

    fun reversed(): Environment =
        Environment(after.reversed(), before.reversed())

    override fun toString(): String = "$before _ $after"
}