package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.sc.*

class CaptureMatcher(
    val element: Matcher,
    val number: Int,
    val isReversed: Boolean = false,
) : LiftingMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        if (number in bindings.captures) {
            throw LscReboundCapture(number)
        } else {
            element.claim(phrase, start, bindings, partial).map { end ->
                val capture = phrase.slice(start, end.index).toSimple()
                end.replaceBindings(
                    end.returnBindings.bindCapture(
                        number,
                        Capture(
                            element,
                            capture.fullyReversedIf(isReversed)
                        )
                    )
                )
            }
        }

    override fun reversed(): Matcher =
        CaptureMatcher(element.reversed(), number, !isReversed)

    override fun toString(): String = "$element$$number"

    override fun liftingTransformerTo(
        result: Emitter,
        filtered: Boolean
    ): Transformer =
        CaptureTransformer(element, element.transformerTo(result, filtered), number)
}

class CaptureTransformer(
    val matcher: Matcher,
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
                val capture = Capture(
                    matcher,
                    phrase.slice(
                        transform.start, transform.end
                    )
                )
                transform.replaceBindings(
                    transform.returnBindings.bindCapture(number, capture)
                )
            }
        }
}

class CaptureReferenceMatcher(
    val declarations: Declarations,
    val number: Int,
    val exact: Boolean,
    val isReversed: Boolean = false,
) : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> {
        val capturedPhrase =
            resolve(bindings).matchedPhrase.fullyReversedIf(isReversed)

        val matchEnd = phrase.matchSubPhrase(
            start, capturedPhrase,
            if (exact) {
                { it.segments }
            } else {
                { word ->
                    with(declarations) {
                        word.segments.map { it.withoutFloatingDiacritics() }
                    }
                }
            }
        ) ?: return emptyList()
        return listOf(PhraseMatchEnd(matchEnd, bindings))
    }

    override fun length(bindings: Bindings): Int? =
        resolve(bindings).matcher.length(bindings)

    private fun resolve(bindings: Bindings): Capture =
        bindings.captures[number] ?: throw LscUnboundCapture(number)

    override fun reversed(): Matcher = CaptureReferenceMatcher(
        declarations, number, exact, !isReversed
    )

    override fun toString(): String = "$$number"
}

class CaptureReferenceEmitter(val number: Int) : IndependentEmitter {
    override fun result(): UnboundResult =
        UnboundResult.fromPhraseBinder { bindings ->
            bindings.captures[number]?.matchedPhrase ?: throw LscUnboundCapture(number)
        }

    override fun toString(): String = "$$number"
}