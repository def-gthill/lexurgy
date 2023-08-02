package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.*

class IntersectionMatcher(
    val initialMatcher: Matcher,
    val matchVerifiers: List<MatchVerifier>,
) : LiftingMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val matchEnds = initialMatcher.claim(
            phrase, start, bindings, partial
        )
        return filterIntersection(
            matchVerifiers, phrase, start, bindings, matchEnds
        ) { it }
    }

    override fun length(bindings: Bindings): Int? = initialMatcher.length(bindings)

    override fun reversed(): Matcher = IntersectionMatcher(
        initialMatcher.reversed(),
        matchVerifiers.map { it.reversed() }
    )

    override fun toString(): String =
        "$initialMatcher&${matchVerifiers.joinToString("&")}"

    override fun liftingTransformerTo(
        result: Emitter,
        filtered: Boolean
    ): Transformer =
        IntersectionTransformer(
            initialMatcher.transformerTo(result, filtered),
            matchVerifiers,
        )
}

class IntersectionTransformer(
    val transformer: Transformer,
    val matchVerifiers: List<MatchVerifier>,
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
            matchVerifiers,
            phrase,
            start,
            bindings,
            transformers,
        ) { it.toMatchEnd() }
    }

    override fun toString(): String =
        "($transformer)&${matchVerifiers.joinToString("&")}"
}

data class MatchVerifier(val matcher: Matcher, val negated: Boolean) {
    fun reversed(): MatchVerifier = MatchVerifier(matcher.reversed(), negated)

    override fun toString(): String = "${if (negated) "!" else ""}$matcher"
}

fun <T : WithBindings<T>> filterIntersection(
    elements: List<MatchVerifier>,
    phrase: Phrase,
    start: PhraseIndex,
    initialBindings: Bindings,
    possibleMatches: List<T>,
    matchEndTransformer: (T) -> PhraseMatchEnd,
): List<T> {
    var matchEnds = possibleMatches
    for ((element, negated) in elements) {
        if (element is LengthHintedMatcher) {
            matchEnds = matchEnds.mapNotNull { matchEnd ->
                val transformed = matchEndTransformer(matchEnd)
                val elementMatchEnd = element.claim(
                    phrase, start, transformed.index, initialBindings
                )
                if (negated) {
                    if (elementMatchEnd == null) matchEnd else null
                } else {
                    elementMatchEnd?.let { matchEnd.updateBindings(it) }
                }
            }
        } else {
            val elementMatchEnds = element.claim(phrase, start, initialBindings)
            val elementMatchEndsMap = elementMatchEnds.associate { it.index to it.returnBindings }
            matchEnds = matchEnds.mapNotNull { matchEnd ->
                val transformed = matchEndTransformer(matchEnd)
                if (negated) {
                    if (transformed.index in elementMatchEndsMap) null else matchEnd
                } else {
                    elementMatchEndsMap[transformed.index]?.let {
                        matchEnd.updateBindings(it)
                    }
                }
            }
            if (matchEnds.isEmpty()) return emptyList()
        }
    }
    return matchEnds
}