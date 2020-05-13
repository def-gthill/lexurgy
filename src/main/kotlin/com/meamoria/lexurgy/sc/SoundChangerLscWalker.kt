package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Phonetic
import com.meamoria.lexurgy.Plain
import com.meamoria.lexurgy.PlainWord
import com.meamoria.lexurgy.Segment

class SoundChangerLscWalker : LscWalker<SoundChangerLscWalker.ParseNode>() {
    override fun walkFile(
        featureDeclarations: List<ParseNode>,
        diacriticDeclarations: List<ParseNode>,
        symbolDeclarations: List<ParseNode>,
        classDeclarations: List<ParseNode>,
        deromanizer: ParseNode?,
        changeRules: List<ParseNode>,
        romanizer: ParseNode?
    ): ParseNode {
        val declarations = Declarations(
            featureDeclarations.map { (it as FeatureDeclarationNode).feature },
            diacriticDeclarations.map { (it as DiacriticDeclarationNode).diacritic },
            symbolDeclarations.flatMap { sublist ->
                (sublist as TList).elements.map { (it as SymbolDeclarationNode).symbol }
            },
            classDeclarations.map { (it as ClassDeclarationNode).segmentClass }
        )
        val linkedRules = changeRules.map { (it as UnlinkedChangeRule).link(declarations) }
        val linkedDeromanizer =
            (deromanizer as? UnlinkedDeromanizer)?.link(declarations) ?: Deromanizer.empty(declarations)
        val linkedRomanizer =
            (romanizer as? UnlinkedRomanizer)?.link(declarations) ?: Romanizer.empty()
        return SoundChanger(linkedRules, linkedDeromanizer, linkedRomanizer)
    }

    override fun walkClassDeclaration(className: ParseNode, sounds: List<ParseNode>): ParseNode = ClassDeclarationNode(
        SegmentClass(
            (className as SimpleValueNode).simpleValue.name,
            sounds.map { (it as TextNode).text }
        )
    )

    override fun walkFeatureDeclaration(
        featureName: ParseNode,
        nullAlias: ParseNode?,
        values: List<ParseNode>,
        implication: ParseNode?
    ): ParseNode = FeatureDeclarationNode(
        Feature(
            (featureName as FeatureNode).name,
            values.map { (it as SimpleValueNode).simpleValue },
            (nullAlias as? SimpleValueNode)?.simpleValue
        )
    )

    override fun walkDiacriticDeclaration(diacritic: String, matrix: ParseNode, before: Boolean): ParseNode =
        DiacriticDeclarationNode(
            Diacritic(diacritic, (matrix as MatrixNode).matrix, before)
        )

    override fun walkSymbolDeclaration(symbol: String, matrix: ParseNode?): ParseNode =
        SymbolDeclarationNode(Symbol(symbol, (matrix as? MatrixNode)?.matrix ?: Matrix(emptyList())))

    override fun walkDeromanizer(expressions: List<ParseNode>): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkRomanizer(expressions: List<ParseNode>): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkChangeRule(
        ruleName: String,
        subrules: List<ParseNode>,
        ruleFilter: ParseNode?,
        propagate: Boolean
    ): ParseNode = UnlinkedChangeRule(
        ruleName,
        subrules.map { subrule -> (subrule as TList).elements.map { it as UnlinkedRuleExpression } },
        ruleFilter as? MatrixNode,
        propagate
    )

    override fun walkSubrule(expressions: List<ParseNode>): ParseNode = tlist(expressions)

    override fun walkRuleExpression(
        ruleFrom: ParseNode,
        ruleTo: ParseNode,
        condition: ParseNode?,
        exclusion: ParseNode?
    ): ParseNode = UnlinkedRuleExpression(
        ruleFrom as RuleElement,
        ruleTo as ResultElement,
        when (condition) {
            is TList -> condition.elements.map { it as UnlinkedEnvironment }
            is UnlinkedEnvironment -> listOf(condition)
            else -> emptyList()
        },
        when (exclusion) {
            is TList -> exclusion.elements.map { it as UnlinkedEnvironment }
            is UnlinkedEnvironment -> listOf(exclusion)
            else -> emptyList()
        }
    )

    override fun walkRuleEnvironment(
        before: ParseNode?,
        after: ParseNode?,
        boundaryBefore: Boolean,
        boundaryAfter: Boolean
    ): ParseNode = UnlinkedEnvironment(
        (before as? RuleElement).let {
            if (boundaryBefore) {
                if (it == null) WordStartElement
                else SequenceElement(listOf(WordStartElement, it))
            } else it
        },
        (after as? RuleElement).let {
            if (boundaryAfter) {
                if (it == null) WordEndElement
                else SequenceElement(listOf(it, WordEndElement))
            } else it
        }
    )

    override fun walkRuleSequence(items: List<ParseNode>): ParseNode =
        SequenceElement(items.map { it as RuleElement })

    override fun walkRuleCapture(item: ParseNode, capture: ParseNode): ParseNode =
        CaptureElement(item as RuleElement, capture as CaptureReferenceElement)

    override fun walkRuleRepeater(item: ParseNode, repeaterType: ParseNode): ParseNode =
        RepeaterElement(item as RuleElement, repeaterType as RepeaterTypeNode)

    override fun walkRuleList(items: List<ParseNode>): ParseNode =
        ListElement(items.map { it as RuleElement })

    override fun walkSimpleElement(element: ParseNode): ParseNode = when (element) {
        is TextNode -> TextElement(element.text)
        is MatrixNode -> MatrixElement(element.matrix)
        else -> element
    }

    override fun walkEmpty(): ParseNode = EmptyElement

    override fun walkClassReference(value: ParseNode): ParseNode =
        ClassReferenceElement((value as SimpleValueNode).simpleValue.name)

    override fun walkCaptureReference(number: Int): ParseNode = CaptureReferenceElement(number)

    override fun walkRepeaterType(type: RepeaterType): ParseNode = RepeaterTypeNode(type)

    override fun walkMatrix(values: List<ParseNode>): ParseNode =
        MatrixNode(Matrix(values.map { (it as ValueNode).value }))

    override fun walkNegatedValue(value: ParseNode): ParseNode =
        ValueNode(NegatedValue((value as SimpleValueNode).simpleValue.name))

    override fun walkAbsentFeature(feature: ParseNode): ParseNode =
        ValueNode(AbsentFeature((feature as FeatureNode).name))

    override fun walkFeatureVariable(feature: ParseNode): ParseNode =
        ValueNode(FeatureVariable((feature as FeatureNode).name))

    override fun walkFeature(name: String): ParseNode = FeatureNode(name)

    override fun walkValue(name: String): ParseNode = SimpleValueNode(SimpleValue(name))

    override fun walkText(text: String): ParseNode = TextNode(text)

    override fun tlist(items: List<ParseNode>): ParseNode = TList(items)

    private class TList(val elements: List<ParseNode>) : ParseNode

    private fun TList?.elementsIfAny(): List<ParseNode> = this?.elements ?: emptyList()

    interface ParseNode

    private class FeatureDeclarationNode(val feature: Feature) : ParseNode

    private class DiacriticDeclarationNode(val diacritic: Diacritic) : ParseNode

    private class SymbolDeclarationNode(val symbol: Symbol) : ParseNode

    private class ClassDeclarationNode(val segmentClass: SegmentClass) : ParseNode

    private class UnlinkedDeromanizer(val expressions: List<UnlinkedRuleExpression>) : ParseNode {
        fun link(declarations: Declarations): Deromanizer =
            Deromanizer(expressions.map { it.outPhonetic(declarations) }, declarations)
    }

    private class UnlinkedRomanizer(val expressions: List<UnlinkedRuleExpression>) : ParseNode {
        fun link(declarations: Declarations): Romanizer = Romanizer(expressions.map { it.inPhonetic(declarations) })
    }

    private class UnlinkedChangeRule(
        val name: String,
        val expressions: List<List<UnlinkedRuleExpression>>,
        val ruleFilter: MatrixNode?,
        val propagate: Boolean
    ) : ParseNode {
        fun link(declarations: Declarations): ChangeRule =
            ChangeRule(name, expressions.map { subrule -> subrule.map { it.phonetic(declarations) } })
    }

    private class UnlinkedRuleExpression(
        val match: RuleElement,
        val result: ResultElement,
        val condition: List<UnlinkedEnvironment>,
        val exclusion: List<UnlinkedEnvironment>
    ) : ParseNode {
        fun inPhonetic(declarations: Declarations): RuleExpression<PhonS, PlainS> = RuleExpression(
            Phonetic, Plain, declarations,
            match.phonetic(declarations),
            result.inPhoneticEmitter(declarations),
            condition.map { it.phonetic(declarations) },
            exclusion.map { it.phonetic(declarations) }
        )

        fun outPhonetic(declarations: Declarations): RuleExpression<PlainS, PhonS> = RuleExpression(
            Plain, Phonetic, declarations,
            match.plain(),
            result.outPhoneticEmitter(declarations),
            condition.map { it.plain() },
            exclusion.map { it.plain() }
        )

        fun phonetic(declarations: Declarations): RuleExpression<PhonS, PhonS> = RuleExpression(
            Phonetic, Phonetic, declarations,
            match.phonetic(declarations),
            result.phoneticEmitter(declarations),
            condition.map { it.phonetic(declarations) },
            exclusion.map { it.phonetic(declarations) }
        )
    }

    private class UnlinkedEnvironment(val before: RuleElement?, val after: RuleElement?) : ParseNode {
        fun plain(): Environment<PlainS> = Environment(
            before?.plain() ?: TextMatcher(Plain.empty),
            after?.plain() ?: TextMatcher(Plain.empty)
        )

        fun phonetic(declarations: Declarations): Environment<PhonS> = Environment(
            before?.phonetic(declarations) ?: TextMatcher(Phonetic.empty),
            after?.phonetic(declarations) ?: TextMatcher(Phonetic.empty)
        )
    }

    private interface RuleElement : ParseNode {
        fun plain(): Matcher<PlainS>

        fun phonetic(declarations: Declarations): Matcher<PhonS>
    }

    // Base class for elements that don't need to use different logic depending on the word type
    private interface ChameleonRuleElement : RuleElement {
        override fun plain(): Matcher<PlainS> = link()

        override fun phonetic(declarations: Declarations): Matcher<PhonS> = link()

        fun <T : Segment<T>> link(): Matcher<T>
    }

    // Base class for elements whose only word type dependency is forwarding to sub-elements
    private interface ContainerRuleElement : RuleElement {
        override fun plain(): Matcher<PlainS> = matcher(elements.map { it.plain() })

        override fun phonetic(declarations: Declarations): Matcher<PhonS> =
            matcher(elements.map { it.phonetic(declarations) })

        val elements: List<RuleElement>

        fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T>
    }

    private abstract class PhoneticOnlyRuleElement : RuleElement {
        override fun plain(): Matcher<PlainS> = foundInPlain()

        // Throw the desired exception
        abstract fun foundInPlain(): Nothing
    }

    private interface ResultElement : RuleElement {
        fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS>

        fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS>

        fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS>
    }

    private interface ChameleonResultElement : ChameleonRuleElement, ResultElement {
        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> = linkEmitter()

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> = linkEmitter()

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = linkEmitter()

        fun <I : Segment<I>, O : Segment<O>> linkEmitter(): Emitter<I, O>
    }

    private abstract class ContainerResultElement : ContainerRuleElement, ResultElement {

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> =
            emitter(resultElements.map { it.inPhoneticEmitter(declarations) })

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            emitter(resultElements.map { it.outPhoneticEmitter(declarations) })

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            emitter(resultElements.map { it.phoneticEmitter(declarations) })

        val resultElements: List<ResultElement> by lazy { elements.map { it as ResultElement } }

        abstract fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O>
    }

    // Base class for elements that are invalid in plain context, and throw an exception indicating this
    private abstract class PhoneticOnlyResultElement : PhoneticOnlyRuleElement(), ResultElement {
        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> =
            foundInPlain()

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            foundInPlain()
    }

    private object WordStartElement : ChameleonRuleElement {
        override fun <T : Segment<T>> link(): Matcher<T> = WordStartMatcher()
    }

    private object WordEndElement : ChameleonRuleElement {
        override fun <T : Segment<T>> link(): Matcher<T> = WordEndMatcher()
    }

    private class SequenceElement(override val elements: List<RuleElement>) :
        ContainerResultElement() {

        override fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T> = SequenceMatcher(elements)

        override fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O> =
            SequenceEmitter(elements)
    }

    private class CaptureElement(val element: RuleElement, val capture: CaptureReferenceElement) :
        PhoneticOnlyRuleElement() {

        override fun phonetic(declarations: Declarations): Matcher<PhonS> =
            CaptureMatcher(element.phonetic(declarations), capture.number)

        override fun foundInPlain(): Nothing = throw LscCaptureInPlain(capture.number)
    }

    private class RepeaterElement(val element: RuleElement, val repeaterType: RepeaterTypeNode) :
        RuleElement {

        override fun plain(): Matcher<PlainS> = RepeaterMatcher(element.plain(), repeaterType.type)

        override fun phonetic(declarations: Declarations): Matcher<PhonS> =
            RepeaterMatcher(element.phonetic(declarations), repeaterType.type)
    }

    private class ListElement(override val elements: List<RuleElement>) :
        ContainerResultElement() {

        override fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T> = ListMatcher(elements)

        override fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O> =
            ListEmitter(elements)
    }

    private class TextElement(val text: String) : ResultElement {
        override fun plain(): Matcher<PlainS> = TextMatcher(PlainWord(text))

        override fun phonetic(declarations: Declarations): Matcher<PhonS> =
            TextMatcher(declarations.parsePhonetic(text))

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> =
            TextEmitter(PlainWord(text))

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            TextEmitter(declarations.parsePhonetic(text))

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            TextEmitter(declarations.parsePhonetic(text))
    }

    private class MatrixElement(val matrix: Matrix) : PhoneticOnlyResultElement() {
        override fun phonetic(declarations: Declarations): Matcher<PhonS> = MatrixMatcher(matrix)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = MatrixEmitter(matrix)

        override fun foundInPlain(): Nothing = throw LscMatrixInPlain(matrix)
    }

    private object EmptyElement : ResultElement {
        override fun plain(): Matcher<PlainS> = TextMatcher(Plain.empty)

        override fun phonetic(declarations: Declarations): Matcher<PhonS> = TextMatcher(Phonetic.empty)

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> = TextEmitter(Plain.empty)

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            TextEmitter(Phonetic.empty)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = TextEmitter(Phonetic.empty)
    }

    private class ClassReferenceElement(val name: String) : PhoneticOnlyResultElement() {
        override fun phonetic(declarations: Declarations): Matcher<PhonS> =
            with (declarations) {
                ListMatcher(name.toClass().sounds.map { TextElement(it).phonetic(this) })
            }

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            with (declarations) {
                ListEmitter(name.toClass().sounds.map { TextElement(it).phoneticEmitter(this) })
            }

        override fun foundInPlain(): Nothing = throw LscClassInPlain(name)
    }

    private class CaptureReferenceElement(val number: Int) : PhoneticOnlyResultElement() {
        override fun phonetic(declarations: Declarations): Matcher<PhonS> =
            CaptureReferenceMatcher(number)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            CaptureReferenceEmitter(number)

        override fun foundInPlain(): Nothing = throw LscCaptureInPlain(number)
    }

    private class RepeaterTypeNode(val type: RepeaterType) : ParseNode

    private class MatrixNode(val matrix: Matrix) : ParseNode

    private class FeatureNode(val name: String) : ParseNode

    private open class ValueNode(val value: MatrixValue) : ParseNode

    private class SimpleValueNode(val simpleValue: SimpleValue) : ValueNode(simpleValue)

    private class TextNode(val text: String) : ParseNode
}