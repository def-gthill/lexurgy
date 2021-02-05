package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Segment
import com.meamoria.lexurgy.SegmentType
import com.meamoria.lexurgy.Word
import com.meamoria.lexurgy.WordListIndex
import com.meamoria.lexurgy.slice

interface Transformer<I : Segment<I>, O : Segment<O>> {
    fun transform(
        order: Int,
        declarations: Declarations,
        words: List<Word<I>>,
        start: WordListIndex,
        bindings: Bindings,
    ): UnboundTransformation<O>?
}

class SequenceTransformer<I : Segment<I>, O : Segment<O>>(
    val outType: SegmentType<O>,
    val elements: List<Transformer<I, O>>
) : Transformer<I, O> {
    override fun transform(
        order: Int,
        declarations: Declarations,
        words: List<Word<I>>,
        start: WordListIndex,
        bindings: Bindings,
    ): UnboundTransformation<O>? {
        var elementStart = start
        val resultBits = mutableListOf<UnboundTransformation<O>>()
        for (element in elements) {
            val transformation = element.transform(order, declarations, words, elementStart, bindings) ?: return null
            elementStart = transformation.end
            resultBits += transformation
        }

        fun result(finalBindings: Bindings): List<Word<O>> =
            outType.joinEdgeWords(resultBits.map { it.result(finalBindings) })

        return UnboundTransformation(order, start, elementStart, ::result, resultBits)
    }
}

class ListTransformer<I : Segment<I>, O : Segment<O>>(
    val elements: List<Transformer<I, O>>
) : Transformer<I, O> {
    override fun transform(
        order: Int,
        declarations: Declarations,
        words: List<Word<I>>,
        start: WordListIndex,
        bindings: Bindings
    ): UnboundTransformation<O>? {
        for (element in elements) {
            val altBindings = bindings.copy()
            element.transform(order, declarations, words, start, altBindings)?.let {
                bindings.combine(altBindings)
                return it
            }
        }
        return null
    }
}

class IntersectionTransformer<I : Segment<I>, O : Segment<O>>(
    val transformer: Transformer<I, O>,
    val otherMatchers: List<Matcher<I>>,
) : Transformer<I, O> {
    override fun transform(
        order: Int,
        declarations: Declarations,
        words: List<Word<I>>,
        start: WordListIndex,
        bindings: Bindings
    ): UnboundTransformation<O>? {
        var matchEnd: WordListIndex? = null
        for (matcher in otherMatchers) {
            val thisMatchEnd = matcher.claim(declarations, words, start, bindings) ?: return null
            if (matchEnd == null) {
                matchEnd = thisMatchEnd
            } else if (thisMatchEnd != matchEnd) {
                return null
            }
        }
        return transformer.transform(order, declarations, words, start, bindings)?.takeIf {
            it.end == matchEnd
        }
    }
}

class CaptureTransformer<O : Segment<O>>(
    val element: Transformer<PhonS, O>,
    val number: Int
) : Transformer<PhonS, O> {
    override fun transform(
        order: Int,
        declarations: Declarations,
        words: List<Word<PhonS>>,
        start: WordListIndex,
        bindings: Bindings
    ): UnboundTransformation<O>? =
        if (number in bindings.captures) {
            throw LscReboundCapture(number)
        } else {
            element.transform(order, declarations, words, start, bindings)?.takeIf {
                it.start.wordIndex == it.end.wordIndex
            }?.also {
                bindings.captures[number] = words[it.start.wordIndex].slice(
                    it.start.segmentIndex until it.end.segmentIndex
                )
            }
        }
}

class SimpleTransformer<I : Segment<I>, O : Segment<O>>(
    val matcher: SimpleMatcher<I>,
    val emitter: SimpleEmitter<I, O>
) : Transformer<I, O> {
    override fun transform(
        order: Int,
        declarations: Declarations,
        words: List<Word<I>>,
        start: WordListIndex,
        bindings: Bindings,
    ): UnboundTransformation<O>? {
        val claimEnd = matcher.claim(declarations, words, start, bindings) ?: return null
        val claim = words.slice(start, claimEnd)
        val result = emitter.result(declarations, matcher, claim)
        return UnboundTransformation(order, start, claimEnd, result)
    }
}

data class Transformation<O : Segment<O>>(
    val order: Int,
    val start: WordListIndex,
    val end: WordListIndex,
    val result: List<Word<O>>,
    val subs: List<Transformation<O>> = emptyList(),
) {
    val elementalSubs: List<Transformation<O>>
        get() = if (subs.isEmpty()) listOf(this) else subs.flatMap { it.elementalSubs }
}

data class UnboundTransformation<O : Segment<O>>(
    val order: Int,
    val start: WordListIndex,
    val end: WordListIndex,
    val result: UnboundResult<O>,
    val subs: List<UnboundTransformation<O>> = emptyList(),
) {
    fun bindVariables(bindings: Bindings): Transformation<O> =
        Transformation(
            order,
            start,
            end,
            result(bindings),
            subs.map { it.bindVariables(bindings) },
        )
}