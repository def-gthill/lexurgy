package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex

interface Transformer {
    fun transform(
        order: Int,
        declarations: Declarations,
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
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> {
        val transformations = element.transform(
            order, declarations, phrase, start, bindings)
        return transformations.mapNotNull { transformation ->
            environment.check(
                declarations, phrase, start,
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

    override fun transform(
        order: Int,
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
    ): List<UnboundTransformation> {
        var resultBits = listOf(emptyList<UnboundTransformation>())
        for (element in elements) {
            resultBits = resultBits.flatMap { prev ->
                element.transform(
                    order, declarations, phrase,
                    prev.lastOrNull()?.end ?: start,
                    prev.lastOrNull()?.returnBindings ?: bindings,
                ).map {
                    prev + it
                }
            }.checkTooManyOptions()
            if (resultBits.isEmpty()) return emptyList()
        }

        fun result(singleResultBits: List<UnboundTransformation>, finalBindings: Bindings): Phrase =
            Phrase.fromSubPhrases(singleResultBits.map { it.result(finalBindings) })

        return resultBits.map { singleResultBits ->

            UnboundTransformation(
                order,
                start,
                singleResultBits.last().end,
                { bindings -> result(singleResultBits, bindings) },
                singleResultBits.last().returnBindings,
                singleResultBits,
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
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> =
        elements.flatMap { element ->
            element.transform(order, declarations, phrase, start, bindings)
        }.checkTooManyOptions()

    override fun toString(): String = elements.joinToString(
        prefix = "{",
        postfix = "}",
    )
}

class RepeaterTransformer(
    val transformer: Transformer,
    val type: RepeaterType,
    val followingMatcher: Matcher?,
) : Transformer {

    constructor(
        matcher: RepeaterMatcher,
        emitter: Emitter,
        filtered: Boolean,
    ) : this(
        matcher.element.transformerTo(emitter, filtered),
        matcher.type,
        matcher.followingMatcher,
    )

    override fun transform(
        order: Int,
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> {
        val resultBits = mutableListOf(listOf(emptyList<UnboundTransformation>()))
        while (true) {
            val newResultBits = resultBits.last().flatMap { prev ->
                transformer.transform(
                    order, declarations, phrase,
                    prev.lastOrNull()?.end ?: start,
                    prev.lastOrNull()?.returnBindings ?: bindings
                ).map {
                    prev + it
                }
            }.checkTooManyOptions()
            if (newResultBits.isEmpty()) break
            resultBits += newResultBits
            if (type.maxReps != null && resultBits.size > type.maxReps) break
        }

        fun result(singleResultBits: List<UnboundTransformation>, finalBindings: Bindings): Phrase =
            Phrase.fromSubPhrases(singleResultBits.map { it.result(finalBindings) })

        return resultBits.drop(type.minReps).reversed().flatten().map { singleResultBits ->

            UnboundTransformation(
                order,
                start,
                singleResultBits.lastOrNull()?.end ?: start,
                { finalBindings -> result(singleResultBits, finalBindings) },
                singleResultBits.lastOrNull()?.returnBindings ?: bindings,
                singleResultBits,
            )
        }
    }

    override fun toString(): String = "($transformer)${type.string}"
}

class IntersectionTransformer(
    val transformer: Transformer,
    val otherMatchers: List<Matcher>,
) : Transformer {
    override fun transform(
        order: Int,
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> {
        val transformers = transformer.transform(
            order, declarations, phrase, start, bindings
        ).filter { it.start.wordIndex == it.end.wordIndex }
        return filterIntersection(
            declarations,
            otherMatchers,
            phrase[start.wordIndex],
            start.segmentIndex,
            bindings,
            transformers,
        ) { it.toMatchEnd() }
    }

    override fun toString(): String = "($transformer)&${otherMatchers.joinToString("&")}"
}

class CaptureTransformer(
    val element: Transformer,
    val number: Int
) : Transformer {
    override fun transform(
        order: Int,
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> =
        if (number in bindings.captures) {
            throw LscReboundCapture(number)
        } else {
            element.transform(order, declarations, phrase, start, bindings).filter {
                it.start.wordIndex == it.end.wordIndex
            }.map { transform ->
                val capture = phrase[transform.start.wordIndex].slice(
                    transform.start.segmentIndex until transform.end.segmentIndex
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
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
    ): List<UnboundTransformation> =
        matcher.claim(declarations, phrase, start, bindings).map { claimEnd ->
            val claim = phrase.slice(start, claimEnd.index)
            val result = emitter.result(declarations, matcher, claim)
            UnboundTransformation(order, start, claimEnd.index, result, claimEnd.returnBindings)
        }

    override fun toString(): String = "$matcher => $emitter"
}

class IndependentTransformer(
    val matcher: Matcher,
    val emitter: IndependentEmitter,
) : Transformer {
    override fun transform(
        order: Int,
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> {
        val claimEnds = matcher.claim(declarations, phrase, start, bindings)
        fun result(claimEnd: PhraseIndex, finalBindings: Bindings): Phrase =
            phrase.slice(start, claimEnd).recoverStructure(emitter.result()(finalBindings))
        return claimEnds.map { claimEnd ->
            UnboundTransformation(
                order,
                start,
                claimEnd.index,
                { finalBindings -> result(claimEnd.index, finalBindings) },
                claimEnd.returnBindings,
            )
        }
    }

    override fun toString(): String = "$matcher => $emitter"
}

class IndependentSequenceTransformer(
    val matcher: Matcher,
    val emitter: SequenceEmitter,
) : Transformer {
    override fun transform(
        order: Int,
        declarations: Declarations,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings
    ): List<UnboundTransformation> =
        matcher.claim(declarations, phrase, start, bindings).map { claimEnd ->
            val resultBits = emitter.resultBits(order, start, claimEnd)

            fun result(finalBindings: Bindings): Phrase =
                Phrase.fromSubPhrases(resultBits.map { it.result(finalBindings) })
            UnboundTransformation(
                order, start, claimEnd.index, ::result,
                claimEnd.returnBindings, resultBits,
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
                        order, start, claimEnd.index,
                        (it as IndependentEmitter).result(),
                        claimEnd.returnBindings,
                    )
                )
            }
        }
}

data class Transformation(
    val order: Int,
    val start: PhraseIndex,
    val end: PhraseIndex,
    val result: Phrase,
    val subs: List<Transformation> = emptyList(),
) {
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
) : WithBindings<UnboundTransformation> {
    fun bindVariables(bindings: Bindings = returnBindings): Transformation =
        Transformation(
            order,
            start,
            end,
            result(bindings),
            subs.map { it.bindVariables(bindings) },
        )

    override fun replaceBindings(bindings: Bindings): UnboundTransformation =
        copy(returnBindings = bindings)

    override fun updateBindings(bindings: Bindings): UnboundTransformation =
        copy(returnBindings = returnBindings.combine(bindings))

    fun toMatchEnd(): WordMatchEnd =
        WordMatchEnd(end.segmentIndex, returnBindings)

    override fun toString(): String {
        val tryResult = try {
            result(Bindings()).string
        } catch (e: Exception) {
            "<unbound>"
        }
        return "UnboundTransformation($order, $start to $end, $tryResult, binding $returnBindings, ${subs.size} subs"
    }
}