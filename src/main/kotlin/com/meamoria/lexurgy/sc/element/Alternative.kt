package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.*
import com.meamoria.lexurgy.uniformOrNull

class AlternativeMatcher(
    val declarations: Declarations,
    val elements: List<Matcher>,
) : BaseMatcher() {
    private val groupedElements = mutableListOf<Matcher>()

    init {
        var currentGroup = mutableListOf<AbstractTextMatcher>()
        for (element in elements) {
            if (element is AbstractTextMatcher) {
                currentGroup.add(element)
            } else {
                if (currentGroup.isNotEmpty()) {
                    groupedElements.add(ClassMatcher(declarations, currentGroup))
                    currentGroup = mutableListOf()
                }
                groupedElements.add(element)
            }
        }
        if (currentGroup.isNotEmpty()) {
            groupedElements.add(ClassMatcher(declarations, currentGroup))
        }
    }

    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        groupedElements.flatMap { element ->
            element.claim(phrase, start, bindings, partial)
        }.checkTooManyOptions()

    override fun length(bindings: Bindings): Int? =
        elements.uniformOrNull { it.length(bindings) }

    override fun reversed(): Matcher = AlternativeMatcher(
        declarations,
        elements.map { it.reversed() }
    )

    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")

    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean,
    ): Transformer = if (elements.size == result.elements.size) {
        val groupedEmitters = mutableListOf<Emitter>()
        var i = 0
        for (element in groupedElements) {
            if (element is ClassMatcher) {
                val numElements = element.elements.size
                val end = i + numElements
                groupedEmitters += AlternativeEmitter(
                    result.elements.slice(i until end)
                )
                i = end
            } else {
                groupedEmitters += result.elements[i]
                i++
            }
        }
        AlternativeTransformer(groupedElements, groupedEmitters, filtered)
    } else {
        try {
            AlternativeTransformer(groupedElements, result, filtered)
        } catch (_: InvalidTransformation) {
            mismatchedLengths(this, result, elements, result.elements)
        }
    }

    override fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean,
    ): Transformer = AlternativeTransformer(groupedElements, result, filtered)

    override fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean,
    ): Transformer = AlternativeTransformer(groupedElements, result, filtered)
}

class AlternativeEmitter(val elements: List<Emitter>) : Emitter {
    override fun toString(): String = elements.joinToString(prefix = "{", postfix = "}")

    override fun isConditional(): Boolean = true

    override fun isIndependent(): Boolean = false
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

// Optimized AlternativeMatcher for when all the elements are
// just looking for literal text.
internal class ClassMatcher(
    val declarations: Declarations,
    val elements: List<AbstractTextMatcher>,
) : BaseMatcher() {
    private val tree = TextMatcherTree(declarations, elements)

    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean
    ): List<PhraseMatchEnd> =
        tree.tryMatch(phrase[start.wordIndex], start.segmentIndex).flatMap {
            elements[it].claim(phrase, start, bindings, partial)
        }

    override fun length(bindings: Bindings): Int? =
        elements.uniformOrNull { it.length(bindings) }

    override fun reversed(): Matcher = ClassMatcher(
        declarations,
        elements.map { it.reversed() as AbstractTextMatcher }
    )

    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean,
    ): Transformer = if (elements.size == result.elements.size) {
        ClassTransformer(declarations, elements, result.elements, filtered)
    } else {
        mismatchedLengths(this, result, elements, result.elements)
    }

    override fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean,
    ): Transformer = ClassTransformer(declarations, elements, result, filtered)

    override fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean,
    ): Transformer = ClassTransformer(declarations, elements, result, filtered)
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

    override fun toString(): String = transformers.joinToString(
        prefix = "{",
        postfix = "}",
    )
}