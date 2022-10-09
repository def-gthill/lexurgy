package com.meamoria.lexurgy.sc.parser

import com.meamoria.lexurgy.WordLevel
import com.meamoria.lexurgy.sc.*
import com.meamoria.lexurgy.zipOrThisNull


internal interface Element : AstNode {
    val publicName: String

    fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher

    val subElements: List<Element>
        get() = emptyList()
}

internal interface ResultElement : Element {
    fun emitter(declarations: ParseTimeDeclarations): Emitter
}

internal fun castToResultElement(element: Element): ResultElement =
    element as? ResultElement ?: throw LscIllegalStructureInOutput(element.publicName, element.text)

// Base class for elements that simply forward matcher/emitter calls to sub-elements
internal abstract class ContainerResultElement(text: String) : BaseAstNode(text), ResultElement {
    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        combineMatchers(declarations, elements.map { it.matcher(context, declarations) })

    override fun emitter(declarations: ParseTimeDeclarations): Emitter =
        combineEmitters(declarations, resultElements.map { it.emitter(declarations) })

    abstract val elements: List<Element>

    val resultElements: List<ResultElement> by lazy { elements.map(::castToResultElement) }

    abstract fun combineMatchers(
        declarations: ParseTimeDeclarations,
        elements: List<Matcher>,
    ): Matcher

    abstract fun combineEmitters(
        declarations: ParseTimeDeclarations,
        elements: List<Emitter>,
    ): Emitter

    override val subElements: List<Element>
        get() = elements
}

internal object DoNothingElement : BaseAstNode("unchanged"), ResultElement {
    override val publicName: String = "an \"unchanged\" element"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        NeverMatcher

    override fun emitter(declarations: ParseTimeDeclarations): Emitter =
        NeverEmitter
}

internal class EnvironmentElement(
    text: String,
    val element: Element,
    val environment: CompoundEnvironmentNode,
) : BaseAstNode(text), Element {
    override val publicName: String = "a nested environment"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        EnvironmentMatcher(
            element.matcher(context, declarations),
            environment.link(declarations),
        )

    override val subElements: List<Element>
        get() = listOf(element) +
                environment.positive.flatMap { listOfNotNull(it.before, it.after) } +
                environment.negative.flatMap { listOfNotNull(it.before, it.after) }
}

internal class CompoundEnvironmentNode(
    text: String,
    val positive: List<EnvironmentNode>,
    val negative: List<EnvironmentNode>,
) : BaseAstNode(text) {
    fun link(declarations: ParseTimeDeclarations): CompoundEnvironment =
        CompoundEnvironment(
            positive.map { it.link(declarations) },
            negative.map { it.link(declarations) },
        )
}

internal class EnvironmentNode(
    text: String,
    val before: Element?,
    val after: Element?,
) : BaseAstNode(text) {

    fun link(declarations: ParseTimeDeclarations): Environment = try {
        Environment(
            before?.matcher(ElementContext.rightBeforeAnchor(), declarations) ?: EmptyMatcher,
            after?.matcher(ElementContext.rightAfterAnchor(), declarations) ?: EmptyMatcher
        )
    } catch (e: LscBadSequence) {
        throw e.initEnvironment(text)
    }
}

internal class AlternativeElement(
    text: String,
    override val elements: List<Element>,
) : ContainerResultElement(text) {
    override val publicName: String = "an alternative list"

    override fun combineMatchers(
        declarations: ParseTimeDeclarations,
        elements: List<Matcher>
    ): Matcher =
        elements.singleOrNull() ?: AlternativeMatcher(declarations.runtime, elements)

    override fun combineEmitters(
        declarations: ParseTimeDeclarations,
        elements: List<Emitter>
    ): Emitter =
        elements.singleOrNull() ?: AlternativeEmitter(elements)
}

internal class SequenceElement(
    text: String,
    override val elements: List<Element>,
) : ContainerResultElement(text) {
    override val publicName: String = "a sequence"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        try {
            combineMatchers(
                declarations,
                (listOf<Element?>(null) + elements + listOf(null)).windowed(3) { window ->
                    val (preceding, current, following) = window
                    current!!.matcher(
                        context.butBetween(preceding, following),
                        declarations,
                    )
                },
            )
        } catch (e: LscBadSequence) {
            throw e.initSequence(text)
        }

    override fun combineMatchers(
        declarations: ParseTimeDeclarations,
        elements: List<Matcher>,
    ): Matcher = SequenceMatcher(declarations.runtime, elements)

    override fun combineEmitters(
        declarations: ParseTimeDeclarations,
        elements: List<Emitter>,
    ): Emitter = SequenceEmitter(elements)
}

internal class IntersectionElement(
    text: String,
    val initialElement: Element,
    val matchVerifierElements: List<MatchVerifierElement>,
) : BaseAstNode(text), Element {
    override val publicName: String = "an intersection"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        IntersectionMatcher(
            initialElement.matcher(context, declarations),
            matchVerifierElements.map { it.matcher(context, declarations) }
        )

    override val subElements: List<Element>
        get() = listOf(initialElement) + matchVerifierElements.map { it.element }
}

/**
 * An element that verifies if a word slice of known length matches a given
 * element, rather than seeking out a prefix of any length to match.
 */
internal data class MatchVerifierElement(val element: Element, val negated: Boolean) {
    fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): MatchVerifier =
        MatchVerifier(element.matcher(context, declarations), negated)
}

@Suppress("unused")
internal class TransformingElement(
    text: String,
    val elements: List<ResultElement>,
) : BaseAstNode(text), ResultElement {
    override val publicName: String = "a transforming element"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        matcher(declarations, elements.first(), elements.first().emitter(declarations))

    private fun matcher(
        declarations: ParseTimeDeclarations,
        element: ResultElement?,
        emitter: Emitter,
    ): Matcher =
        when (emitter) {
            is AlternativeEmitter ->
                AlternativeMatcher(
                    declarations.runtime,
                    (element as? AlternativeElement)?.elements.zipOrThisNull(
                        emitter.elements
                    ) { subElement, subEmitter ->
                        matcher(declarations, subElement as ResultElement?, subEmitter)
                    },
                )
            is SequenceEmitter ->
                SequenceMatcher(
                    declarations.runtime,
                    (element as SequenceElement).elements.zip(
                        emitter.elements
                    ) { subElement, subEmitter ->
                        matcher(declarations, subElement as ResultElement, subEmitter)
                    }
                )
            else -> singleMatcher(
                declarations,
                element,
                emitter,
            )
        }

    private fun singleMatcher(
        declarations: ParseTimeDeclarations,
        element: ResultElement?,
        emitter: Emitter,
    ): Matcher {
        val alternatives = remainingElementsAsConditional(
            declarations, "matcher"
        ).map { transformations ->
            EmitterMatcher(
                TransformingEmitter(
                    castToIndependent(element, emitter),
                    transformations.singleOrNull() ?: MultiConditionalEmitter(
                        transformations,
                    ),
                )
            )
        }
        return alternatives.singleOrNull() ?: AlternativeMatcher(
            declarations.runtime,
            alternatives
        )
    }

    override fun emitter(declarations: ParseTimeDeclarations): Emitter =
        emitter(declarations, elements.first().emitter(declarations))

    private fun emitter(
        declarations: ParseTimeDeclarations,
        emitter: Emitter,
    ): Emitter =
        when (emitter) {
            is AlternativeEmitter ->
                AlternativeEmitter(
                    emitter.elements.map {
                        emitter(declarations, it)
                    }
                )
            is SequenceEmitter ->
                SequenceEmitter(
                    emitter.elements.map {
                        emitter(declarations, it)
                    },
                )
            else -> singleEmitter(declarations, emitter)
        }

    private fun singleEmitter(
        declarations: ParseTimeDeclarations,
        emitter: Emitter,
    ): Emitter {
        val alternatives = remainingElementsAsConditional(
            declarations, "emitter"
        ).map { transformations ->
            if (emitter.isIndependent()) {
                TransformingEmitter(
                    emitter as IndependentEmitter,
                    transformations.singleOrNull() ?: MultiConditionalEmitter(
                        transformations,
                    )
                )
            } else {
                MultiConditionalEmitter(
                    listOf(emitter as ConditionalEmitter) + transformations
                )
            }
        }
        return alternatives.singleOrNull() ?: AlternativeEmitter(alternatives)
    }

    private fun castToIndependent(element: ResultElement?, emitter: Emitter): IndependentEmitter =
        emitter as? IndependentEmitter ?: throw LscIllegalStructure(
            element!!.publicName, element.text, "at the start of a transforming matcher"
        )

    // The outer list represents "lifted" alternative lists.
    private fun remainingElementsAsConditional(
        declarations: ParseTimeDeclarations,
        elementType: String,
    ): List<List<ConditionalEmitter>> {
        var alternatives = emptyList<List<ConditionalEmitter>>()
        val remainingElements = elements.drop(1)
        for (remainingElement in remainingElements) {
            val elements =
                if (remainingElement is AlternativeElement) {
                    remainingElement.elements
                } else {
                    listOf(remainingElement)
                }
            val emitters = elements.map { element ->
                val emitter = castToResultElement(element).emitter(declarations)
                emitter as? ConditionalEmitter ?: throw LscIllegalStructure(
                    element.publicName, element.text, "to continue a transforming $elementType"
                )
            }
            alternatives = if (alternatives.isEmpty()) {
                emitters.map { listOf(it) }
            } else {
                alternatives.flatMap { alternative ->
                    emitters.map { alternative + it }
                }
            }
        }
        return alternatives
    }

    override val subElements: List<Element>
        get() = elements
}

internal class NegatedElement(
    text: String,
    val element: Element,
) : BaseAstNode(text), Element {
    override val publicName: String = "a negated element"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        NegatedMatcher(element.matcher(context, declarations))

    override val subElements: List<Element>
        get() = listOf(element)
}

internal class CaptureElement(
    text: String,
    val element: Element,
    val capture: CaptureReferenceElement,
) : BaseAstNode(text), Element {
    override val publicName: String = "a capture"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        CaptureMatcher(element.matcher(context, declarations), capture.number)

    override val subElements: List<Element>
        get() = listOf(element)
}

internal class RepeaterElement(
    text: String,
    val element: Element,
    val repeaterType: RepeaterTypeNode,
) : BaseAstNode(text), Element {
    override val publicName: String = when (repeaterType.type) {
        StandardRepeaterType.ZERO_OR_ONE -> "an optional"
        else -> "a repeater"
    }

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher {
        checkContext(context)
        return RepeaterMatcher(
            declarations.runtime,
            element.matcher(context, declarations),
            repeaterType.type,
        )
    }

    private fun checkContext(context: ElementContext) {
        if (!repeaterType.type.isSpecificMultiple() &&
            context.isAtEdgeOfEnvironment
        ) {
            throw LscPeripheralRepeater(text, repeaterType.type)
        }
    }

    private fun RepeaterType.isSpecificMultiple(): Boolean =
        minReps > 1 && minReps == maxReps

    override val subElements: List<Element>
        get() = listOf(element)
}

internal object SyllableElement : BaseAstNode("<syl>"), Element {
    override val publicName: String = "a syllable element"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        SyllableMatcher

}

internal class ElementReferenceElement(
    text: String,
    val name: String,
) : BaseAstNode(text), ResultElement {
    override val publicName: String = "an element reference"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        declarations.dereferenceElement(name).matcher(context, declarations)

    override fun emitter(declarations: ParseTimeDeclarations): Emitter =
        castToResultElement(declarations.dereferenceElement(name)).emitter(declarations)
}

internal class CaptureReferenceElement(
    text: String,
    val number: Int,
    val exact: Boolean,
) : BaseAstNode(text), ResultElement {
    override val publicName: String = "a capture reference"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        CaptureReferenceMatcher(declarations.runtime, number, exact)

    override fun emitter(declarations: ParseTimeDeclarations): Emitter =
        if (!exact) throw LscIllegalStructureInOutput(
            "an inexact capture reference", "~"
        ) else CaptureReferenceEmitter(number)
}

internal class MatrixElement(
    text: String,
    val matrix: Matrix,
) : BaseAstNode(text), ResultElement {
    override val publicName: String = "a matrix"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        with(declarations.runtime) {
            val split = matrix.splitByLevel()
            val segmentMatcher = split[WordLevel.SEGMENT]?.let {
                MatrixMatcher(this, it)
            }
            val syllableMatcher = split[WordLevel.SYLLABLE]?.let {
                SyllableMatrixMatcher(this, it)
            }
            if (syllableMatcher == null) {
                segmentMatcher ?: MatrixMatcher(this, Matrix.EMPTY)
            } else {
                if (segmentMatcher == null) {
                    syllableMatcher
                } else {
                    IntersectionMatcher(
                        segmentMatcher,
                        listOf(MatchVerifier(syllableMatcher, false))
                    )
                }
            }
        }

    override fun emitter(declarations: ParseTimeDeclarations): Emitter =
        with(declarations.runtime) {
            val split = matrix.splitByLevel()
            val segmentEmitter = split[WordLevel.SEGMENT]?.let {
                MatrixEmitter(this, it)
            }
            val syllableEmitter = split[WordLevel.SYLLABLE]?.let {
                SyllableMatrixEmitter(this, it)
            }
            if (syllableEmitter == null) {
                segmentEmitter ?: MatrixEmitter(this, Matrix.EMPTY)
            } else {
                if (segmentEmitter == null) {
                    syllableEmitter
                } else {
                    MultiConditionalEmitter(
                        listOf(segmentEmitter, syllableEmitter)
                    )
                }
            }
        }
}

internal object EmptyElement : BaseAstNode("*"), ResultElement {
    override val publicName: String = "an empty element"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        EmptyMatcher

    override fun emitter(declarations: ParseTimeDeclarations): Emitter = EmptyEmitter
}

internal object SyllableBoundaryElement : BaseAstNode("."), ResultElement {
    override val publicName: String = "a syllable boundary"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        if (declarations.runtime.syllabifier == null) {
            TextElement(".", ".").matcher(context, declarations)
        } else SyllableBoundaryMatcher

    override fun emitter(declarations: ParseTimeDeclarations): Emitter =
        if (declarations.runtime.syllabifier == null) {
            TextElement(".", ".").emitter(declarations)
        } else SyllableBoundaryEmitter
}

internal object WordBoundaryElement : BaseAstNode("$"), Element {
    override val publicName: String = "a word boundary"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        when {
            context.section == RuleSection.MAIN -> throw LscIllegalStructureInInput(publicName, text)
            context.isAtStartOfSection -> WordStartMatcher
            context.isAtEndOfSection -> WordEndMatcher
            else -> throw LscInteriorWordBoundary()
        }
}

internal object BetweenWordsElement : BaseAstNode("$$"), ResultElement, Element {
    override val publicName: String = "a space between words"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        BetweenWordsMatcher

    override fun emitter(declarations: ParseTimeDeclarations): Emitter =
        BetweenWordsEmitter
}

internal class TextElement(
    text: String,
    val literalText: String,
    val exact: Boolean = false,
) : BaseAstNode(text), ResultElement {
    override val publicName: String = "literal text"

    override fun matcher(context: ElementContext, declarations: ParseTimeDeclarations): Matcher =
        declarations.runtime.parsePhonetic(literalText, syllabify = false).let {
            if (exact) TextMatcher(it) else SymbolMatcher(declarations.runtime, it)
        }

    override fun emitter(declarations: ParseTimeDeclarations): Emitter =
        declarations.runtime.parsePhonetic(literalText, syllabify = false).let {
            if (exact) TextEmitter(it) else SymbolEmitter(declarations.runtime, it)
        }
}
