package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Phonetic
import com.meamoria.lexurgy.Plain
import com.meamoria.lexurgy.PlainWord
import com.meamoria.lexurgy.Segment
import java.text.ParseException

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
        diacritic: String,
        matrix: ParseNode,
        before: Boolean
    ): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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
        ruleFrom as UnlinkedRuleElement,
        ruleTo as UnlinkedResultElement,
        (condition as TList?).elementsIfAny().map { it as UnlinkedEnvironment },
        (exclusion as TList?).elementsIfAny().map { it as UnlinkedEnvironment }
    )

    override fun walkRuleEnvironment(
        before: ParseNode?,
        after: ParseNode?,
        boundaryBefore: Boolean,
        boundaryAfter: Boolean
    ): ParseNode = UnlinkedEnvironment(
        (before as? UnlinkedRuleElement).let {
            if (boundaryBefore) {
                if (it == null) UnlinkedWordStartElement
                else UnlinkedSequenceElement(listOf(UnlinkedWordStartElement, it))
            } else it
        },
        (after as? UnlinkedRuleElement).let {
            if (boundaryAfter) {
                if (it == null) UnlinkedWordEndElement
                else UnlinkedSequenceElement(listOf(it, UnlinkedWordEndElement))
            } else it
        }
    )

    override fun walkRuleSequence(items: List<ParseNode>): ParseNode =
        UnlinkedSequenceElement(items.map { it as UnlinkedRuleElement })

    override fun walkRuleList(items: List<ParseNode>): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkSimpleElement(element: ParseNode): ParseNode = when (element) {
        is TextNode -> UnlinkedTextElement(element.text)
        is MatrixNode -> UnlinkedMatrixElement(element.matrix)
        else -> element
    }

    override fun walkEmpty(): ParseNode = EmptyElement

    override fun walkMatrix(values: List<ParseNode>): ParseNode =
        MatrixNode(Matrix(values.map { (it as ValueNode).value }))

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
            ChangeRule(expressions.map { subrule -> subrule.map { it.phonetic(declarations) } })
    }

    private class UnlinkedRuleExpression(
        val match: UnlinkedRuleElement,
        val result: UnlinkedResultElement,
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

    private class UnlinkedEnvironment(val before: UnlinkedRuleElement?, val after: UnlinkedRuleElement?) : ParseNode {
        fun plain(): Environment<PlainS> = Environment(
            before?.plain() ?: TextMatcher(Plain.empty),
            after?.plain() ?: TextMatcher(Plain.empty)
        )

        fun phonetic(declarations: Declarations): Environment<PhonS> = Environment(
            before?.phonetic(declarations) ?: TextMatcher(Phonetic.empty),
            after?.phonetic(declarations) ?: TextMatcher(Phonetic.empty)
        )
    }

    private interface UnlinkedRuleElement : ParseNode {
        fun plain(): Matcher<PlainS>

        fun phonetic(declarations: Declarations): Matcher<PhonS>
    }

    // Base class for elements that don't need to use different logic depending on the word type
    private interface ChameleonRuleElement : UnlinkedRuleElement {
        override fun plain(): Matcher<PlainS> = link()

        override fun phonetic(declarations: Declarations): Matcher<PhonS> = link()

        fun <T : Segment<T>> link(): Matcher<T>
    }

    // Base class for elements whose only word type dependency is forwarding to sub-elements
    private interface ContainerRuleElement<S : UnlinkedRuleElement> : UnlinkedRuleElement {
        override fun plain(): Matcher<PlainS> = matcher(elements.map { it.plain() })

        override fun phonetic(declarations: Declarations): Matcher<PhonS> =
            matcher(elements.map { it.phonetic(declarations) })

        val elements: List<S>

        fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T>
    }

    private interface UnlinkedResultElement : UnlinkedRuleElement {
        fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS>

        fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS>

        fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS>
    }

    private interface ChameleonResultElement : ChameleonRuleElement, UnlinkedResultElement {
        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> = linkEmitter()

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> = linkEmitter()

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = linkEmitter()

        fun <I : Segment<I>, O : Segment<O>> linkEmitter(): Emitter<I, O>
    }

    private interface ContainerResultElement<S : UnlinkedResultElement> :
        ContainerRuleElement<S>, UnlinkedResultElement {

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> =
            emitter(elements.map { it.inPhoneticEmitter(declarations) })

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            emitter(elements.map { it.outPhoneticEmitter(declarations) })

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            emitter(elements.map { it.phoneticEmitter(declarations) })

        fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O>
    }

    private object UnlinkedWordStartElement : ChameleonRuleElement {
        override fun <T : Segment<T>> link(): Matcher<T> = WordStartMatcher()
    }

    private object UnlinkedWordEndElement : ChameleonRuleElement {
        override fun <T : Segment<T>> link(): Matcher<T> = WordEndMatcher()
    }

    private class UnlinkedSequenceElement(ruleElements: List<UnlinkedRuleElement>) :
        ContainerResultElement<UnlinkedResultElement> {

        override val elements: List<UnlinkedResultElement> = ruleElements.map { it as UnlinkedResultElement }

        override fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T> = SequenceMatcher(elements)

        override fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O> =
            SequenceEmitter(elements)
    }

    private class UnlinkedTextElement(val text: String) : UnlinkedResultElement {
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

    private class UnlinkedMatrixElement(val matrix: Matrix) : UnlinkedResultElement {
        override fun plain(): Matcher<PlainS> = throw LscMatrixInPlain(matrix)

        override fun phonetic(declarations: Declarations): Matcher<PhonS> = MatrixMatcher(matrix)

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> =
            throw LscMatrixInPlain(matrix)

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            throw LscMatrixInPlain(matrix)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = MatrixEmitter(matrix)
    }

    private object EmptyElement : UnlinkedResultElement {
        override fun plain(): Matcher<PlainS> = TextMatcher(Plain.empty)

        override fun phonetic(declarations: Declarations): Matcher<PhonS> = TextMatcher(Phonetic.empty)

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> = TextEmitter(Plain.empty)

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            TextEmitter(Phonetic.empty)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = TextEmitter(Phonetic.empty)
    }

    private class MatrixNode(val matrix: Matrix) : ParseNode

    private class FeatureNode(val name: String) : ParseNode

    private open class ValueNode(val value: MatrixValue) : ParseNode

    private class SimpleValueNode(val simpleValue: SimpleValue) : ValueNode(simpleValue)

    private class TextNode(val text: String) : ParseNode
}