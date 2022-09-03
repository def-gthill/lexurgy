package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex

interface Transformer {
    fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
    ): List<UnboundTransformation>

    fun <T> List<T>.checkTooManyOptions(): List<T> =
        checkTooManyOptions(this@Transformer, this)
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
            order, phrase, start, bindings)
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

class SequenceTransformer(
    val declarations: Declarations,
    val elements: List<Transformer>
) : Transformer {

    constructor(
        declarations: Declarations,
        matchers: List<Matcher>,
        emitters: List<Emitter>,
        filtered: Boolean,
    ) : this(
        declarations,
        matchers.zip(emitters) { matcher, emitter ->
            matcher.transformerTo(emitter, filtered)
        },
    )

    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
    ): List<UnboundTransformation> {
        var resultBits = listOf(emptyList<UnboundTransformation>())
        for (element in elements) {
            resultBits = resultBits.flatMap { prev ->
                element.transform(
                    order, phrase,
                    prev.lastOrNull()?.end ?: start,
                    prev.lastOrNull()?.returnBindings ?: bindings,
                ).map {
                    prev + it
                }
            }.checkTooManyOptions()
            if (resultBits.isEmpty()) return emptyList()
        }

        return resultBits.map {
            UnboundTransformation.fromSubTransformations(
                declarations, order, start, bindings, it
            )
        }
    }

    override fun toString(): String = elements.joinToString(" ") { "($it)" }
}

class AlternativeTransformer(
    val elements: List<Transformer>
) : Transformer {

    constructor(
        matchers: List<Matcher>,
        emitters: List<Emitter>,
        filtered: Boolean,
    ) : this(
        matchers.zip(emitters) { matcher, emitter ->
            matcher.transformerTo(emitter, filtered)
        }
    )

    constructor(
        matchers: List<Matcher>,
        emitter: Emitter,
        filtered: Boolean,
    ) : this(
        matchers.map { it.transformerTo(emitter, filtered) }
    )

    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> =
        elements.flatMap { element ->
            element.transform(order, phrase, start, bindings)
        }.checkTooManyOptions()

    override fun toString(): String = elements.joinToString(
        prefix = "{",
        postfix = "}",
    )
}

internal class ClassTransformer(
    val declarations: Declarations,
    val matchers: List<AbstractTextMatcher>,
    val transformers: List<Transformer>,
) : Transformer {
    private val tree = TextMatcherTree(declarations, matchers)

    constructor(
        declarations: Declarations,
        matchers: List<AbstractTextMatcher>,
        emitters: List<Emitter>,
        filtered: Boolean
    ) : this(
        declarations,
        matchers,
        matchers.zip(emitters) { matcher, emitter ->
            matcher.transformerTo(emitter, filtered)
        }
    )

    constructor(
        declarations: Declarations,
        matchers: List<AbstractTextMatcher>,
        emitter: Emitter,
        filtered: Boolean
    ) : this(
        declarations,
        matchers,
        matchers.map { it.transformerTo(emitter, filtered) }
    )

    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> =
        tree.tryMatch(phrase[start.wordIndex], start.segmentIndex).flatMap {
            transformers[it].transform(order, phrase, start, bindings)
        }
}

class RepeaterTransformer(
    val declarations: Declarations,
    val transformer: Transformer,
    val type: RepeaterType,
) : Transformer {

    constructor(
        declarations: Declarations,
        matcher: RepeaterMatcher,
        emitter: Emitter,
        filtered: Boolean,
    ) : this(
        declarations,
        matcher.element.transformerTo(emitter, filtered),
        matcher.type,
    )

    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> {
        val resultBits = mutableListOf(listOf(emptyList<UnboundTransformation>()))
        while (true) {
            val newResultBits = resultBits.last().flatMap { prev ->
                transformer.transform(
                    order, phrase,
                    prev.lastOrNull()?.end ?: start,
                    prev.lastOrNull()?.returnBindings ?: bindings
                ).map {
                    prev + it
                }
            }.checkTooManyOptions()
            if (newResultBits.isEmpty()) break
            resultBits += newResultBits
            if (type.maxReps != null && resultBits.size > type.maxReps!!) break
        }

        return resultBits.drop(type.minReps).reversed().flatten().map {
            UnboundTransformation.fromSubTransformations(
                declarations, order, start, bindings, it
            )
        }
    }

    override fun toString(): String = "($transformer)${type.string}"
}

class IntersectionTransformer(
    val transformer: Transformer,
    val checkMatchers: List<CheckMatcher>,
) : Transformer {
    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> {
        val transformers = transformer.transform(
            order, phrase, start, bindings
        ).filter { it.start.wordIndex == it.end.wordIndex }
        return filterIntersection(
            checkMatchers,
            phrase,
            start,
            bindings,
            transformers,
        ) { it.toMatchEnd() }
    }

    override fun toString(): String =
        "($transformer)&${checkMatchers.joinToString("&")}"
}

class CaptureTransformer(
    val element: Transformer,
    val number: Int
) : Transformer {
    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> =
        if (number in bindings.captures) {
            throw LscReboundCapture(number)
        } else {
            element.transform(order, phrase, start, bindings).filter {
                it.start.wordIndex == it.end.wordIndex
            }.map { transform ->
                val capture = phrase.slice(
                    transform.start, transform.end
                )
                transform.replaceBindings(
                    transform.returnBindings.bindCapture(number, capture)
                )
            }
        }
}

class SimpleConditionalTransformer(
    val matcher: SimpleMatcher,
    val emitter: ConditionalEmitter,
) : Transformer {
    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
    ): List<UnboundTransformation> =
        matcher.claim(phrase, start, bindings).map { claimEnd ->
            val claim = phrase.slice(start, claimEnd.index)
            val result = emitter.result(matcher, claim)
            UnboundTransformation(
                order,
                start,
                claimEnd.index,
                result,
                claimEnd.returnBindings,
                removesSyllableBreaks = claimEnd.matchedSyllableBreaks,
            )
        }

    override fun toString(): String = "$matcher => $emitter"
}

class IndependentTransformer(
    val matcher: Matcher,
    val emitter: IndependentEmitter,
) : Transformer {
    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> =
        matcher.claim(phrase, start, bindings).map { claimEnd ->
            val unboundResult = UnboundResult { bindings ->
                val result = emitter.result().bind(bindings)
                val resultPhrase = phrase.slice(start, claimEnd.index).recoverStructure(
                    result.phrase,
                    exceptSyllableBreaks = claimEnd.matchedSyllableBreaks.map {
                        it - start
                    }
                )
                Result(
                    resultPhrase,
                    result.emitsSyllableBreaks,
                    result.syllableFeatureChanges,
                )
            }

            UnboundTransformation(
                order,
                start,
                claimEnd.index,
                unboundResult,
                claimEnd.returnBindings,
                removesSyllableBreaks = claimEnd.matchedSyllableBreaks,
            )
        }

    override fun toString(): String = "$matcher => $emitter"
}

class IndependentSequenceTransformer(
    val matcher: Matcher,
    val emitter: SequenceEmitter,
) : Transformer {
    override fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> =
        matcher.claim(phrase, start, bindings).map { claimEnd ->
            val transformationBits = emitter.resultBits(
                order, start, claimEnd
            )

            val unboundResult = UnboundResult { bindings ->
                val results = transformationBits.map { it.result.bind(bindings) }

                val resultPhrase = phrase.slice(start, claimEnd.index).recoverStructure(
                    Phrase.fromSubPhrases(results.map { it.phrase }),
                    exceptSyllableBreaks = claimEnd.matchedSyllableBreaks.map {
                        it - start
                    },
                )
                val resultEmitsSyllableBreaks = results.sequenceEmitsSyllableBreaks()
                val resultSyllableFeatureChanges = with (emitter.declarations) {
                    results.map { it.syllableFeatureChanges }.reduce(keepExplicitDefaults = true)
                }

                Result(
                    resultPhrase,
                    resultEmitsSyllableBreaks,
                    resultSyllableFeatureChanges,
                )
            }

            UnboundTransformation(
                order,
                start,
                claimEnd.index,
                unboundResult,
                claimEnd.returnBindings,
                transformationBits,
                removesSyllableBreaks = claimEnd.matchedSyllableBreaks,
            )
        }

    private fun SequenceEmitter.resultBits(
        order: Int,
        start: PhraseIndex,
        claimEnd: PhraseMatchEnd,
    ): List<UnboundTransformation> =
        elements.flatMap {
            when (it) {
                is SequenceEmitter -> it.resultBits(order, start, claimEnd)
                else -> listOf(
                    UnboundTransformation(
                        order,
                        start,
                        claimEnd.index,
                        (it as IndependentEmitter).result(),
                        claimEnd.returnBindings,
                    )
                )
            }
        }
}

/**
 * An instruction to replace a part of a phrase with new sounds.
 * @param order: The precedence order of the transformation - lower numbers are applied first.
 * @param start: The first index of the original phrase that needs to be replaced.
 * @param end: The first index of the original phrase after the end of section to be replaced.
 * @param result: The new phrase to insert.
 * @param subs: Sub-transformations, if any.
 * @param removesSyllableBreaks: List of syllable break indices that were explicitly
 * matched and need to be suppressed in the output.
 */
data class Transformation(
    val order: Int,
    val start: PhraseIndex,
    val end: PhraseIndex,
    val result: Phrase,
    val subs: List<Transformation> = emptyList(),
    val removesSyllableBreaks: List<PhraseIndex> = emptyList(),
    val syllableFeatureChanges: Matrix = Matrix.EMPTY,
) {
    val removesSyllableBreakBefore: Boolean = removesSyllableBreaks.firstOrNull() == start
    val removesSyllableBreakAfter: Boolean = removesSyllableBreaks.lastOrNull() == end

    val elementalSubs: List<Transformation>
        get() = if (subs.isEmpty()) listOf(this) else subs.flatMap { it.elementalSubs }
}

data class UnboundTransformation(
    val order: Int,
    val start: PhraseIndex,
    val end: PhraseIndex,
    val result: UnboundResult,
    val returnBindings: Bindings,
    val subs: List<UnboundTransformation> = emptyList(),
    val removesSyllableBreaks: List<PhraseIndex> = emptyList(),
) : WithBindings<UnboundTransformation> {
    val removesSyllableBreakBefore: Boolean = removesSyllableBreaks.firstOrNull() == start
    val removesSyllableBreakAfter: Boolean = removesSyllableBreaks.lastOrNull() == end

    fun bindVariables(bindings: Bindings = returnBindings): Transformation {
        val boundResult = result.bind(bindings)
        return Transformation(
            order,
            start,
            end,
            boundResult.phrase,
            subs.map { it.bindVariables(bindings) },
            removesSyllableBreaks,
            boundResult.syllableFeatureChanges,
        )
    }

    override fun replaceBindings(bindings: Bindings): UnboundTransformation =
        copy(returnBindings = bindings)

    override fun updateBindings(bindings: Bindings): UnboundTransformation =
        copy(returnBindings = returnBindings.combine(bindings))

    fun toMatchEnd(): PhraseMatchEnd =
        PhraseMatchEnd(end, returnBindings)

    override fun toString(): String {
        val tryResult = try {
            result.bind(Bindings()).phrase.string
        } catch (e: Exception) {
            "<unbound>"
        }
        return "UnboundTransformation($order, $start to $end, $tryResult, binding $returnBindings, ${subs.size} subs"
    }

    companion object {
        fun fromSubTransformations(
            declarations: Declarations,
            order: Int,
            start: PhraseIndex,
            bindings: Bindings,
            subs: List<UnboundTransformation>,
        ): UnboundTransformation {
            val unboundResult = UnboundResult { finalBindings ->
                val (nonEmptySubs, results) = subs.map {
                    it to it.result.bind(finalBindings)
                }.filter {
                    it.second.phrase.words.isNotEmpty()
                }.unzip()

                val resultPhrases = results.map { it.phrase }

                val subPhrases = mutableListOf<Phrase>()
                for ((i, sub) in nonEmptySubs.withIndex()) {
                    var subPhrase = resultPhrases[i]

                    val thisRemovesSyllableBreakBefore =
                        sub.removesSyllableBreakBefore &&
                                !results[i].emitsSyllableBreakBefore
                    val previousRemovesSyllableBreakAfter =
                        i > 0 && nonEmptySubs[i - 1].removesSyllableBreakAfter
                    if (
                        thisRemovesSyllableBreakBefore ||
                        previousRemovesSyllableBreakAfter
                    ) subPhrase = subPhrase.removeLeadingBreak()

                    val thisRemovesSyllableBreakAfter =
                        sub.removesSyllableBreakAfter &&
                                !results[i].emitsSyllableBreakAfter
                    val nextRemovesSyllableBreakBefore =
                        i < nonEmptySubs.indices.last && nonEmptySubs[i + 1].removesSyllableBreakBefore
                    if (
                        thisRemovesSyllableBreakAfter ||
                        nextRemovesSyllableBreakBefore
                    ) subPhrase = subPhrase.removeTrailingBreak()
                    subPhrases += subPhrase
                }

                val resultPhrase = Phrase.fromSubPhrases(subPhrases)
                val resultEmitsSyllableBreaks = results.sequenceEmitsSyllableBreaks()
                val resultSyllableFeatureChanges = with (declarations) {
                    results.map { it.syllableFeatureChanges }.reduce(keepExplicitDefaults = true)
                }

                Result(
                    resultPhrase,
                    resultEmitsSyllableBreaks,
                    resultSyllableFeatureChanges,
                )
            }

            return UnboundTransformation(
                order,
                start,
                subs.lastOrNull()?.end ?: start,
                unboundResult,
                subs.lastOrNull()?.returnBindings ?: bindings,
                subs,
                subs.flatMap { it.removesSyllableBreaks }.distinct(),
            )
        }
    }
}