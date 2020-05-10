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
        val declarations = Declarations()
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
    ): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkDiacriticDeclaration(
        diacritic: String,
        matrix: ParseNode,
        before: Boolean
    ): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkSymbolDeclaration(symbol: String, matrix: ParseNode?): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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
    ): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkRuleSequence(items: List<ParseNode>): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkRuleList(items: List<ParseNode>): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkSimpleElement(element: ParseNode): ParseNode = when (element) {
        is Text -> UnlinkedTextElement(element.text)
        else -> element
    }

    override fun walkEmpty(): ParseNode = EmptyElement

    override fun walkMatrix(values: List<ParseNode>): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkFeature(name: String): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkValue(name: String): ParseNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkText(text: String): ParseNode = Text(text)

    override fun tlist(items: List<ParseNode>): ParseNode = TList(items)

    private class TList(val elements: List<ParseNode>) : ParseNode

    private fun TList?.elementsIfAny(): List<ParseNode> = this?.elements ?: emptyList()

    interface ParseNode

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
            result.inPhoneticEmitter(declarations)
        )

        fun outPhonetic(declarations: Declarations): RuleExpression<PlainS, PhonS> = RuleExpression(
            Plain, Phonetic, declarations,
            match.plain(),
            result.outPhoneticEmitter(declarations)
        )

        fun phonetic(declarations: Declarations): RuleExpression<PhonS, PhonS> = RuleExpression(
            Phonetic, Phonetic, declarations,
            match.phonetic(declarations),
            result.phoneticEmitter(declarations)
        )
    }

    private class UnlinkedEnvironment : ParseNode

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

    private object EmptyElement : UnlinkedResultElement {
        override fun plain(): Matcher<PlainS> = TextMatcher(Plain.empty)

        override fun phonetic(declarations: Declarations): Matcher<PhonS> = TextMatcher(Phonetic.empty)

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> = TextEmitter(Plain.empty)

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> = TextEmitter(Phonetic.empty)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = TextEmitter(Phonetic.empty)
    }

    private class MatrixNode(val matrix: Matrix) : ParseNode

    private class Text(val text: String) : ParseNode
}