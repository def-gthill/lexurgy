package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

class SoundChangerLscWalker : LscWalker<SoundChangerLscWalker.ParseNode>() {
    override fun walkFile(
        featureDeclarations: List<ParseNode>,
        diacriticDeclarations: List<ParseNode>,
        symbolDeclarations: List<ParseNode>,
        classDeclarations: List<ParseNode>,
        deromanizer: ParseNode?,
        changeRules: List<ParseNode>,
        romanizer: ParseNode?,
        intermediateRomanizers: List<RomanizerToFollowingRule<ParseNode>>
    ): ParseNode {
        val declarations = Declarations(
            featureDeclarations.map { (it as FeatureDeclarationNode).feature },
            diacriticDeclarations.map { (it as DiacriticDeclarationNode).diacritic },
            symbolDeclarations.flatMap { sublist ->
                (sublist as TList).elements.map { (it as SymbolDeclarationNode).symbol }
            },
            resolveClasses(classDeclarations)
        )
        val linkedRules = changeRules.map { (it as UnlinkedChangeRule).link(declarations) }
        val linkedDeromanizer =
            (deromanizer as UnlinkedDeromanizer?)?.link(declarations) ?: Deromanizer.empty(declarations)
        val linkedRomanizer =
            (romanizer as UnlinkedRomanizer?)?.link(declarations) ?: Romanizer.empty()
        val linkedIntermediateRomanizers = intermediateRomanizers.map {
            (it.rule as UnlinkedChangeRule).name to
                    (it.romanizer as UnlinkedIntermediateRomanizer).link(declarations)
        }.toMap()
        return SoundChanger(declarations, linkedRules, linkedDeromanizer, linkedRomanizer, linkedIntermediateRomanizers)
    }

    private fun resolveClasses(classDeclarations: List<ParseNode>): List<SegmentClass> {
        val classes = mutableMapOf<String, SegmentClass>()
        for (classDeclaration in classDeclarations) {
            val classNode = classDeclaration as ClassDeclarationNode
            val newClassSounds = classNode.elements.flatMap {
                if (it is TextNode) listOf(it.text)
                else {
                    val nestedName = (it as ClassReferenceElement).name
                    classes[nestedName]?.sounds ?: throw LscUndefinedName("class", nestedName)
                }
            }
            classes[classNode.name] = SegmentClass(classNode.name, newClassSounds)
        }
        return classes.values.toList()
    }

    override fun walkClassDeclaration(className: ParseNode, elements: List<ParseNode>): ParseNode =
        ClassDeclarationNode(
            (className as SimpleValueNode).simpleValue.name,
            elements
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

    override fun walkDiacriticDeclaration(
        diacritic: String, matrix: ParseNode, before: Boolean, floating: Boolean
    ): ParseNode =
        DiacriticDeclarationNode(
            Diacritic(diacritic, (matrix as MatrixNode).matrix, before, floating)
        )

    override fun walkSymbolDeclaration(symbol: String, matrix: ParseNode?): ParseNode =
        SymbolDeclarationNode(Symbol(symbol, (matrix as? MatrixNode)?.matrix ?: Matrix(emptyList())))

    override fun walkDeromanizer(subrules: List<ParseNode>): ParseNode =
        UnlinkedDeromanizer(subrules.convert())

    override fun walkRomanizer(subrules: List<ParseNode>): ParseNode =
        UnlinkedRomanizer(subrules.convert())

    override fun walkIntermediateRomanizer(ruleName: String, subrules: List<ParseNode>): ParseNode =
        UnlinkedIntermediateRomanizer(ruleName, subrules.convert())

    override fun walkChangeRule(
        ruleName: String,
        subrules: List<ParseNode>,
        ruleFilter: ParseNode?,
        propagate: Boolean
    ): ParseNode = UnlinkedChangeRule(
        ruleName,
        subrules.convert(),
        when (ruleFilter) {
            is MatrixNode -> MatrixElement(ruleFilter.matrix)
            else -> ruleFilter as RuleElement?
        },
        propagate
    )

    private fun List<ParseNode>.convert(): List<List<UnlinkedRuleExpression>> =
        map { subrule ->
            (subrule as TList).elements.map { it as UnlinkedRuleExpression }
        }

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

    override fun walkRuleCapture(item: ParseNode, capture: ParseNode): ParseNode = when (item) {
        is MatrixNode -> CaptureElement(MatrixElement(item.matrix), capture as CaptureReferenceElement)
        else -> CaptureElement(item as RuleElement, capture as CaptureReferenceElement)
    }

    override fun walkRuleRepeater(item: ParseNode, repeaterType: ParseNode): ParseNode =
        RepeaterElement(item as RuleElement, repeaterType as RepeaterTypeNode)

    override fun walkRuleList(items: List<ParseNode>): ParseNode =
        ListElement(items.map { it as RuleElement })

    override fun walkSimpleElement(element: ParseNode): ParseNode = when (element) {
        is TextNode -> TextElement(element.text, element.exact)
        is MatrixNode -> MatrixElement(element.matrix)
        else -> element
    }

    override fun walkNegatedElement(element: ParseNode): ParseNode = NegatedElement(element as RuleElement)

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
        ValueNode(SimpleValue.absent((feature as FeatureNode).name))

    override fun walkFeatureVariable(feature: ParseNode): ParseNode =
        ValueNode(FeatureVariable((feature as FeatureNode).name))

    override fun walkFeature(name: String): ParseNode = FeatureNode(name)

    override fun walkValue(name: String): ParseNode = SimpleValueNode(SimpleValue(name))

    override fun walkText(text: String, exact: Boolean): ParseNode = TextNode(text, exact)

    override fun tlist(items: List<ParseNode>): ParseNode = TList(items)

    override fun untlist(list: ParseNode): List<ParseNode> = (list as TList).elements

    private class TList(val elements: List<ParseNode>) : ParseNode

    interface ParseNode

    private class FeatureDeclarationNode(val feature: Feature) : ParseNode

    private class DiacriticDeclarationNode(val diacritic: Diacritic) : ParseNode

    private class SymbolDeclarationNode(val symbol: Symbol) : ParseNode

    private class ClassDeclarationNode(val name: String, val elements: List<ParseNode>) : ParseNode

    private class UnlinkedDeromanizer(val expressions: List<List<UnlinkedRuleExpression>>) : ParseNode {
        fun link(declarations: Declarations): Deromanizer =
            Deromanizer(
                expressions.first().map { it.outPhonetic(declarations) },
                expressions.drop(1).nestedMap { it.phonetic(declarations, false) },
                declarations
            )
    }

    private class UnlinkedRomanizer(val expressions: List<List<UnlinkedRuleExpression>>) : ParseNode {
        fun link(declarations: Declarations): Romanizer =
            Romanizer(
                expressions.dropLast(1).nestedMap { it.phonetic(declarations, false) },
                expressions.last().map { it.inPhonetic(declarations) }
            )
    }

    private class UnlinkedIntermediateRomanizer(
        val name: String, val expressions: List<List<UnlinkedRuleExpression>>
    ) : ParseNode {
        fun link(declarations: Declarations): SoundChanger.IntermediateRomanizer =
            SoundChanger.IntermediateRomanizer(name, Romanizer(
                expressions.dropLast(1).nestedMap { it.phonetic(declarations, false) },
                expressions.last().map { it.inPhonetic(declarations) }
            ))
    }

    private class UnlinkedChangeRule(
        val name: String,
        val expressions: List<List<UnlinkedRuleExpression>>,
        val ruleFilter: RuleElement?,
        val propagate: Boolean
    ) : ParseNode {
        fun link(declarations: Declarations): ChangeRule =
            ChangeRule(
                name,
                expressions.nestedMap { it.phonetic(declarations, ruleFilter != null) },
                ruleFilter?.let { filter ->
                    { segment: PhoneticSegment ->
                        filter.phonetic(declarations).claim(
                            declarations, Phonetic.single(segment), 0, Bindings()
                        ) == 1
                    }
                },
                propagate
            )
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

        fun phonetic(declarations: Declarations, filtered: Boolean): RuleExpression<PhonS, PhonS> = RuleExpression(
            Phonetic, Phonetic, declarations,
            match.phonetic(declarations),
            result.phoneticEmitter(declarations),
            condition.map { it.phonetic(declarations) },
            exclusion.map { it.phonetic(declarations) },
            filtered
        )
    }

    private class UnlinkedEnvironment(val before: RuleElement?, val after: RuleElement?) : ParseNode {
        fun plain(): Environment<PlainS> = Environment(
            before?.plain() ?: NullMatcher(),
            after?.plain() ?: NullMatcher()
        )

        fun phonetic(declarations: Declarations): Environment<PhonS> = Environment(
            before?.phonetic(declarations) ?: NullMatcher(),
            after?.phonetic(declarations) ?: NullMatcher()
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

    private class TextElement(val text: String, val exact: Boolean = false) : ResultElement {
        override fun plain(): Matcher<PlainS> = TextMatcher(PlainWord(text))

        override fun phonetic(declarations: Declarations): Matcher<PhonS> =
            declarations.parsePhonetic(text).let {
                if (exact) TextMatcher(it) else SymbolMatcher(it)
            }

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> =
            TextEmitter(PlainWord(text))

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            declarations.parsePhonetic(text).let {
                if (exact) TextEmitter(it) else SymbolEmitter(it)
            }

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            declarations.parsePhonetic(text).let {
                if (exact) TextEmitter(it) else SymbolEmitter(it)
            }
    }

    private class MatrixElement(val matrix: Matrix) : PhoneticOnlyResultElement() {
        override fun phonetic(declarations: Declarations): Matcher<PhonS> = MatrixMatcher(matrix)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = MatrixEmitter(matrix)

        override fun foundInPlain(): Nothing = throw LscMatrixInPlain(matrix)
    }

    private class NegatedElement(val element: RuleElement) : RuleElement {
        override fun plain(): Matcher<PlainS> = NegatedMatcher(element.plain())

        override fun phonetic(declarations: Declarations): Matcher<PhonS> =
            NegatedMatcher(element.phonetic(declarations))
    }

    private object EmptyElement : ResultElement {
        override fun plain(): Matcher<PlainS> = NullMatcher()

        override fun phonetic(declarations: Declarations): Matcher<PhonS> = NullMatcher()

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> = NullEmitter(Plain)

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> = NullEmitter(Phonetic)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = NullEmitter(Phonetic)
    }

    private class ClassReferenceElement(val name: String) : PhoneticOnlyResultElement() {
        override fun phonetic(declarations: Declarations): Matcher<PhonS> =
            with(declarations) {
                ListMatcher(name.toClass().sounds.map { TextElement(it).phonetic(this) })
            }

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            with(declarations) {
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

    private class TextNode(val text: String, val exact: Boolean) : ParseNode
}

