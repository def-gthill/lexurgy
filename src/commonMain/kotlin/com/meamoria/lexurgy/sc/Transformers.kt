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
    ): UnboundTransformation?
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
    ): UnboundTransformation? {
        val transformation = element.transform(
            order, declarations, phrase, start, bindings
        ) ?: return null
        if (
            !environment.check(
                declarations, phrase, start, transformation.end, bindings
            )
        ) return null
        return transformation
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
    ): UnboundTransformation? {
        var elementStart = start
        val resultBits = mutableListOf<UnboundTransformation>()
        for (element in elements) {
            val transformation = element.transform(order, declarations, phrase, elementStart, bindings) ?: return null
            elementStart = transformation.end
            resultBits += transformation
        }

        fun result(finalBindings: Bindings): Phrase =
            Phrase.fromSubPhrases(resultBits.map { it.result(finalBindings) })

        return UnboundTransformation(order, start, elementStart, ::result, resultBits)
    }
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
    ): UnboundTransformation? {
        for (element in elements) {
            val altBindings = bindings.copy()
            element.transform(order, declarations, phrase, start, altBindings)?.let {
                bindings.combine(altBindings)
                return it
            }
        }
        return null
    }
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
    ): UnboundTransformation? {
        var elementStart = start
        val resultBits = mutableListOf<UnboundTransformation>()
        var times = 0
        while (true) {
            val altBindings = bindings.copy()
            if (followingMatcher?.claim(declarations, phrase, elementStart, altBindings) != null) break
            val transformation = transformer.transform(order, declarations, phrase, elementStart, bindings) ?: break
            elementStart = transformation.end
            resultBits += transformation
            times++
            if (type.maxReps?.let { times >= it } == true) break
        }

        fun result(finalBindings: Bindings): Phrase =
            Phrase.fromSubPhrases(resultBits.map { it.result(finalBindings) })

        return UnboundTransformation(order, start, elementStart, ::result, resultBits).takeIf {
            times >= type.minReps
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
    ): UnboundTransformation? {
        var matchEnd: PhraseIndex? = null
        for (matcher in otherMatchers) {
            val thisMatchEnd = matcher.claim(declarations, phrase, start, bindings) ?: return null
            if (matchEnd == null) {
                matchEnd = thisMatchEnd
            } else if (thisMatchEnd != matchEnd) {
                return null
            }
        }
        return transformer.transform(order, declarations, phrase, start, bindings)?.takeIf {
            it.end == matchEnd
        }
    }
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
    ): UnboundTransformation? =
        if (number in bindings.captures) {
            throw LscReboundCapture(number)
        } else {
            element.transform(order, declarations, phrase, start, bindings)?.takeIf {
                it.start.wordIndex == it.end.wordIndex
            }?.also {
                bindings.captures[number] = phrase[it.start.wordIndex].slice(
                    it.start.segmentIndex until it.end.segmentIndex
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
    ): UnboundTransformation? {
        val claimEnd = matcher.claim(declarations, phrase, start, bindings) ?: return null
        val claim = phrase.slice(start, claimEnd)
        val result = emitter.result(declarations, matcher, claim)
        return UnboundTransformation(order, start, claimEnd, result)
    }
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
    ): UnboundTransformation? {
        val claimEnd = matcher.claim(declarations, phrase, start, bindings) ?: return null
        return UnboundTransformation(order, start, claimEnd, emitter.result())
    }
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
    ): UnboundTransformation? {
        val claimEnd = matcher.claim(declarations, phrase, start, bindings) ?: return null
        val resultBits = emitter.resultBits(order, start, claimEnd)

        fun result(finalBindings: Bindings): Phrase =
            Phrase.fromSubPhrases(resultBits.map { it.result(finalBindings) })

        return UnboundTransformation(order, start, claimEnd, ::result, resultBits)
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