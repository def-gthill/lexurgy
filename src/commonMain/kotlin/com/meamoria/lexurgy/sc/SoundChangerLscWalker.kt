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
        val linkedIntermediateRomanizers = intermediateRomanizers.groupBy {
            (it.rule as UnlinkedChangeRule?)?.name
        }.mapValues { (_, value) ->
            value.map { (it.romanizer as UnlinkedIntermediateRomanizer).link(declarations) }
        }
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
            if (classNode.name in classes) throw LscDuplicateName("class", classNode.name)
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
        SymbolDeclarationNode(Symbol(symbol, (matrix as? MatrixNode)?.matrix))

    override fun walkDeromanizer(subrules: List<ParseNode>, literal: Boolean): ParseNode =
        UnlinkedDeromanizer(subrules.convert(), literal)

    override fun walkRomanizer(subrules: List<ParseNode>, literal: Boolean): ParseNode =
        UnlinkedRomanizer(subrules.convert(), literal)

    override fun walkIntermediateRomanizer(ruleName: String, subrules: List<ParseNode>, literal: Boolean): ParseNode =
        UnlinkedIntermediateRomanizer(ruleName, subrules.convert(), literal)

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
            (subrule as TList).elements.filterIsInstance<UnlinkedRuleExpression>()
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

    override fun walkDoNothingExpression(): ParseNode = DoNothingExpression

    override fun walkRuleEnvironment(
        text: String,
        before: ParseNode?,
        after: ParseNode?,
    ): ParseNode = UnlinkedEnvironment(
        text,
        (before as? RuleElement),
        (after as? RuleElement),
    )

    override fun walkRuleSequence(text: String, items: List<ParseNode>): ParseNode =
        SequenceElement(text, items.map { it as RuleElement })

    override fun walkRuleCapture(item: ParseNode, capture: ParseNode): ParseNode = when (item) {
        is MatrixNode -> CaptureElement(MatrixElement(item.matrix), capture as CaptureReferenceElement)
        else -> CaptureElement(item as RuleElement, capture as CaptureReferenceElement)
    }

    override fun walkRuleRepeater(text: String, item: ParseNode, repeaterType: ParseNode): ParseNode =
        RepeaterElement(text, item as RuleElement, repeaterType as RepeaterTypeNode)

    override fun walkRuleList(items: List<ParseNode>): ParseNode =
        ListElement(items.map { it as RuleElement })

    override fun walkSimpleElement(element: ParseNode): ParseNode = when (element) {
        is TextNode -> TextElement(element.text, element.exact)
        is MatrixNode -> MatrixElement(element.matrix)
        else -> element
    }

    override fun walkNegatedElement(element: ParseNode): ParseNode = NegatedElement(element as RuleElement)

    override fun walkEmpty(): ParseNode = EmptyElement

    override fun walkBoundary(): ParseNode = WordBoundaryElement

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

    private class UnlinkedDeromanizer(
        val expressions: List<List<UnlinkedRuleExpression>>, val literal: Boolean
    ) : ParseNode {
        fun link(declarations: Declarations): Deromanizer =
            if (literal) {
                Deromanizer(
                    expressions.first().map { it.outPhonetic(declarations) },
                    expressions.drop(1).nestedMap { it.phonetic(declarations, false) },
                    declarations,
                )
            } else {
                Deromanizer(
                    emptyList(),
                    expressions.nestedMap { it.phonetic(declarations, false) },
                    declarations,
                )
            }
    }

    private class UnlinkedRomanizer(
        val expressions: List<List<UnlinkedRuleExpression>>, val literal: Boolean
    ) : ParseNode {
        fun link(declarations: Declarations): Romanizer =
            if (literal) {
                Romanizer(
                    expressions.dropLast(1).nestedMap { it.phonetic(declarations, false) },
                    expressions.last().map { it.inPhonetic(declarations) },
                )
            } else {
                Romanizer(
                    expressions.nestedMap { it.phonetic(declarations, false) },
                    emptyList(),
                )
            }
    }

    private class UnlinkedIntermediateRomanizer(
        val name: String, val expressions: List<List<UnlinkedRuleExpression>>, val literal: Boolean
    ) : ParseNode {
        fun link(declarations: Declarations): SoundChanger.IntermediateRomanizer =
            SoundChanger.IntermediateRomanizer(
                name, UnlinkedRomanizer(expressions, literal).link(declarations)
            )
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
                        filter.phonetic(RulePos.MAIN, declarations).claim(
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
            match.phonetic(RulePos.MAIN, declarations),
            result.inPhoneticEmitter(declarations),
            condition.map { it.phonetic(declarations) },
            exclusion.map { it.phonetic(declarations) }
        )

        fun outPhonetic(declarations: Declarations): RuleExpression<PlainS, PhonS> = RuleExpression(
            Plain, Phonetic, declarations,
            match.plain(RulePos.MAIN),
            result.outPhoneticEmitter(declarations),
            condition.map { it.plain() },
            exclusion.map { it.plain() }
        )

        fun phonetic(declarations: Declarations, filtered: Boolean): RuleExpression<PhonS, PhonS> = RuleExpression(
            Phonetic, Phonetic, declarations,
            match.phonetic(RulePos.MAIN, declarations),
            result.phoneticEmitter(declarations),
            condition.map { it.phonetic(declarations) },
            exclusion.map { it.phonetic(declarations) },
            filtered
        )
    }

    private object DoNothingExpression : ParseNode

    private class UnlinkedEnvironment(
        val environmentText: String,val before: RuleElement?, val after: RuleElement?
    ) : ParseNode {
        fun plain(): Environment<PlainS> = try {
            Environment(
                before?.plain(RulePos.ENV_START) ?: NullMatcher(),
                after?.plain(RulePos.ENV_END) ?: NullMatcher()
            )
        } catch (e: LscBadSequence) {
            throw e.initEnvironment(environmentText)
        }

        fun phonetic(declarations: Declarations): Environment<PhonS> = try {
            Environment(
                before?.phonetic(RulePos.ENV_START, declarations) ?: NullMatcher(),
                after?.phonetic(RulePos.ENV_END, declarations) ?: NullMatcher()
            )
        } catch (e: LscBadSequence) {
            throw e.initEnvironment(environmentText)
        }
    }

    private interface RuleElement : ParseNode {
        fun plain(pos: RulePos): Matcher<PlainS>

        fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS>
    }

    private enum class RulePos {
        MAIN,
        ENV_START,
        ENV_MIDDLE,
        ENV_END,
    }

    // Base class for elements that don't need to use different logic depending on the word type
    private interface ChameleonRuleElement : RuleElement {
        override fun plain(pos: RulePos): Matcher<PlainS> = link(pos)

        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> = link(pos)

        fun <T : Segment<T>> link(pos: RulePos): Matcher<T>
    }

    // Base class for elements whose only word type dependency is forwarding to sub-elements
    private interface ContainerRuleElement : RuleElement {
        override fun plain(pos: RulePos): Matcher<PlainS> =
            matcher(elements.map { it.plain(pos) })

        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> =
            matcher(elements.map { it.phonetic(pos, declarations) })

        val elements: List<RuleElement>

        fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T>
    }

    private abstract class PhoneticOnlyRuleElement : RuleElement {
        override fun plain(pos: RulePos): Matcher<PlainS> = foundInPlain()

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

    private object WordBoundaryElement : ChameleonRuleElement {
        override fun <T : Segment<T>> link(pos: RulePos): Matcher<T> =
            when (pos) {
                RulePos.ENV_START -> WordStartMatcher()
                RulePos.ENV_END -> WordEndMatcher()
                else -> throw LscInteriorWordBoundary()
            }
    }

    private class SequenceElement(
        val sequenceText: String, override val elements: List<RuleElement>
    ) :
        ContainerResultElement() {

        override fun plain(pos: RulePos): Matcher<PlainS> = link(
            pos,
            { plain(it) },
            { super.plain(it) },
        )

        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> = link(
            pos,
            { phonetic(it, declarations) },
            { super.phonetic(it, declarations) },
        )

        private fun <T : Segment<T>> link(
            pos: RulePos,
            linker: RuleElement.(RulePos) -> Matcher<T>,
            superCall: (RulePos) -> Matcher<T>,
        ): Matcher<T> =
            try {
                when (pos) {
                    RulePos.ENV_START -> SequenceMatcher(
                        listOf(elements.first().linker(RulePos.ENV_START)) +
                                elements.drop(1).map { it.linker(RulePos.ENV_MIDDLE) }
                    )
                    RulePos.ENV_END -> SequenceMatcher(
                        elements.dropLast(1).map { it.linker(RulePos.ENV_MIDDLE) } +
                                listOf(elements.last().linker(RulePos.ENV_END))
                    )
                    else -> superCall(pos)
                }
            } catch (e: LscBadSequence) {
                throw e.initSequence(sequenceText)
            }

        override fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T> = SequenceMatcher(elements)

        override fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O> =
            SequenceEmitter(elements)
    }

    private class CaptureElement(val element: RuleElement, val capture: CaptureReferenceElement) :
        PhoneticOnlyRuleElement() {

        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> =
            CaptureMatcher(element.phonetic(pos, declarations), capture.number)

        override fun foundInPlain(): Nothing = throw LscCaptureInPlain(capture.number)
    }

    private class RepeaterElement(
        val repeaterText: String,
        val element: RuleElement,
        val repeaterType: RepeaterTypeNode,
    ) :
        RuleElement {

        override fun plain(pos: RulePos): Matcher<PlainS> {
            checkPos(pos)
            return RepeaterMatcher(element.plain(pos), repeaterType.type)
        }

        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> {
            checkPos(pos)
            return RepeaterMatcher(element.phonetic(pos, declarations), repeaterType.type)
        }

        private fun checkPos(pos: RulePos) {
            if (pos == RulePos.ENV_START || pos == RulePos.ENV_END) {
                throw LscPeripheralRepeater(repeaterText)
            }
        }
    }

    private class ListElement(override val elements: List<RuleElement>) :
        ContainerResultElement() {

        override fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T> = ListMatcher(elements)

        override fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O> =
            ListEmitter(elements)
    }

    private class TextElement(val text: String, val exact: Boolean = false) : ResultElement {
        override fun plain(pos: RulePos): Matcher<PlainS> = TextMatcher(PlainWord(text))

        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> =
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
        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> =
            MatrixMatcher(matrix)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = MatrixEmitter(matrix)

        override fun foundInPlain(): Nothing = throw LscMatrixInPlain(matrix)
    }

    private class NegatedElement(val element: RuleElement) : RuleElement {
        override fun plain(pos: RulePos): Matcher<PlainS> = NegatedMatcher(element.plain(pos))

        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> =
            NegatedMatcher(element.phonetic(pos, declarations))
    }

    private object EmptyElement : ResultElement {
        override fun plain(pos: RulePos): Matcher<PlainS> = NullMatcher()

        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> = NullMatcher()

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> = NullEmitter(Plain)

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> = NullEmitter(Phonetic)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = NullEmitter(Phonetic)
    }

    private class ClassReferenceElement(val name: String) : PhoneticOnlyResultElement() {
        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> =
            with(declarations) {
                ListMatcher(name.toClass().sounds.map { TextElement(it).phonetic(pos, this) })
            }

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            with(declarations) {
                ListEmitter(name.toClass().sounds.map { TextElement(it).phoneticEmitter(this) })
            }

        override fun foundInPlain(): Nothing = throw LscClassInPlain(name)
    }

    private class CaptureReferenceElement(val number: Int) : PhoneticOnlyResultElement() {
        override fun phonetic(pos: RulePos, declarations: Declarations): Matcher<PhonS> =
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

