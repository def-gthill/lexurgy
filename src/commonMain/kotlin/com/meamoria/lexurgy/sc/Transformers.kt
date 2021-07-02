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
        return transformations.filter { transformation ->
            environment.check(
                declarations, phrase, start, transformation.end, bindings
            )
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
        var resultBits = emptyList<UnboundTransformation>()
        for (element in elements) {
            resultBits = resultBits.flatMap { prev ->
                element.transform(order, declarations, phrase, prev.end, bindings)
            }
        }

        fun result(finalBindings: Bindings): Phrase =
            Phrase.fromSubPhrases(resultBits.map { it.result(finalBindings) })

        return listOf(UnboundTransformation(order, start, resultBits.last().end, ::result, resultBits))
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
            val altBindings = bindings.copy()
            element.transform(order, declarations, phrase, start, altBindings).also {
                bindings.combine(altBindings)
            }
        }

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
        val resultBits = mutableListOf(emptyList<UnboundTransformation>())
        while (true) {
            val newResultBits = resultBits.last().flatMap { prev ->
                transformer.transform(order, declarations, phrase, prev.end, bindings)
            }
            if (newResultBits.isEmpty()) break
            resultBits += newResultBits
            if (type.maxReps != null && resultBits.size > type.maxReps) break
        }

        return resultBits.drop(type.minReps).map { singleResultBits ->
            fun result(finalBindings: Bindings): Phrase =
                Phrase.fromSubPhrases(singleResultBits.map { it.result(finalBindings) })

            UnboundTransformation(order, start, singleResultBits.last().end, ::result, singleResultBits)
        }
    }
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
        var matchEnds: List<PhraseIndex> = emptyList()
        for (matcher in otherMatchers) {
            val thisMatchEnds = matcher.claim(declarations, phrase, start, bindings)
            if (matchEnds.isEmpty()) {
                matchEnds = thisMatchEnds
            } else {
                matchEnds = matchEnds.filter { it in thisMatchEnds }
                if (matchEnds.isEmpty()) return emptyList()
            }
        }
        return transformer.transform(order, declarations, phrase, start, bindings).filter {
            it.end in matchEnds
        }
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
            }.also {
                bindings.captures[number] = phrase[it.first().start.wordIndex].slice(
                    it.first().start.segmentIndex until it.first().end.segmentIndex
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
            val claim = phrase.slice(start, claimEnd)
            val result = emitter.result(declarations, matcher, claim)
            UnboundTransformation(order, start, claimEnd, result)
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
        return claimEnds.map { claimEnd ->
            UnboundTransformation(order, start, claimEnd, emitter.result())
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
            UnboundTransformation(order, start, claimEnd, ::result, resultBits)
        }

    private fun SequenceEmitter.resultBits(
        order: Int,
        start: PhraseIndex,
        claimEnd: PhraseIndex,
    ): List<UnboundTransformation> =
        elements.flatMap {
            when (it) {
                is SequenceEmitter -> it.resultBits(order, start, claimEnd)
                else -> listOf(UnboundTransformation(order, start, claimEnd, (it as IndependentEmitter).result()))
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
    val subs: List<UnboundTransformation> = emptyList(),
) {
    fun bindVariables(bindings: Bindings): Transformation =
        Transformation(
            order,
            start,
            end,
            result(bindings),
            subs.map { it.bindVariables(bindings) },
        )
}