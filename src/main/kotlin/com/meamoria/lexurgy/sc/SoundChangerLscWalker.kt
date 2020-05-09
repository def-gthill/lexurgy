package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Phonetic
import com.meamoria.lexurgy.Plain
import com.meamoria.lexurgy.PlainWord

class SoundChangerLscWalker : LscWalker<SoundChangerElement>() {
    override fun walkFile(
        featureDeclarations: List<SoundChangerElement>,
        diacriticDeclarations: List<SoundChangerElement>,
        symbolDeclarations: List<SoundChangerElement>,
        classDeclarations: List<SoundChangerElement>,
        deromanizer: SoundChangerElement?,
        changeRules: List<SoundChangerElement>,
        romanizer: SoundChangerElement?
    ): SoundChangerElement {
        val declarations = Declarations()
        val linkedRules = changeRules.map { (it as UnlinkedChangeRule).link(declarations) }
        val linkedDeromanizer =
            (deromanizer as? UnlinkedDeromanizer)?.link(declarations) ?: Deromanizer.empty(declarations)
        val linkedRomanizer =
            (romanizer as? UnlinkedRomanizer)?.link(declarations) ?: Romanizer.empty()
        return SoundChanger(linkedRules, linkedDeromanizer, linkedRomanizer)
    }

    override fun walkFeatureDeclaration(
        featureName: SoundChangerElement,
        nullAlias: SoundChangerElement?,
        values: List<SoundChangerElement>,
        implication: SoundChangerElement?
    ): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkDiacriticDeclaration(
        diacritic: String,
        matrix: SoundChangerElement,
        before: Boolean
    ): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkSymbolDeclaration(symbol: String, matrix: SoundChangerElement?): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkDeromanizer(expressions: List<SoundChangerElement>): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkRomanizer(expressions: List<SoundChangerElement>): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkChangeRule(
        ruleName: String,
        subrules: List<SoundChangerElement>,
        ruleFilter: SoundChangerElement?,
        propagate: Boolean
    ): SoundChangerElement = UnlinkedChangeRule(
        ruleName,
        subrules.map { subrule -> (subrule as TList).elements.map { it as UnlinkedRuleExpression } },
        ruleFilter as? Matrix,
        propagate
    )

    override fun walkSubrule(expressions: List<SoundChangerElement>): SoundChangerElement = tlist(expressions)

    override fun walkRuleExpression(
        ruleFrom: SoundChangerElement,
        ruleTo: SoundChangerElement,
        condition: SoundChangerElement?,
        exclusion: SoundChangerElement?
    ): SoundChangerElement = UnlinkedRuleExpression(
        ruleFrom as UnlinkedRuleElement,
        ruleTo as UnlinkedResultElement,
        (condition as TList?).elementsIfAny().map { it as UnlinkedEnvironment },
        (exclusion as TList?).elementsIfAny().map { it as UnlinkedEnvironment }
    )

    override fun walkRuleEnvironment(
        before: SoundChangerElement?,
        after: SoundChangerElement?,
        boundaryBefore: Boolean,
        boundaryAfter: Boolean
    ): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkRuleSequence(items: List<SoundChangerElement>): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkRuleList(items: List<SoundChangerElement>): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkSimpleElement(element: SoundChangerElement): SoundChangerElement = when (element) {
        is Text -> UnlinkedTextElement(element.text)
        else -> element
    }

    override fun walkEmpty(): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkMatrix(values: List<SoundChangerElement>): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkFeature(name: String): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkValue(name: String): SoundChangerElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun walkText(text: String): SoundChangerElement = Text(text)

    override fun tlist(items: List<SoundChangerElement>): SoundChangerElement = TList(items)

    private class TList(val elements: List<SoundChangerElement>) : SoundChangerElement

    private fun TList?.elementsIfAny(): List<SoundChangerElement> = this?.elements ?: emptyList()

    private class UnlinkedDeromanizer(val expressions: List<UnlinkedRuleExpression>): SoundChangerElement {
        fun link(declarations: Declarations): Deromanizer =
            Deromanizer(expressions.map { it.outPhonetic(declarations) }, declarations)
    }

    private class UnlinkedRomanizer(val expressions: List<UnlinkedRuleExpression>): SoundChangerElement {
        fun link(declarations: Declarations): Romanizer = Romanizer(expressions.map { it.inPhonetic(declarations) })
    }

    private class UnlinkedChangeRule(
        val name: String,
        val expressions: List<List<UnlinkedRuleExpression>>,
        val ruleFilter: Matrix?,
        val propagate: Boolean
    ) : SoundChangerElement {
        fun link(declarations: Declarations): ChangeRule =
            ChangeRule(expressions.map { subrule -> subrule.map { it.phonetic(declarations) } } )
    }

    private class UnlinkedRuleExpression(
        val match: UnlinkedRuleElement,
        val result: UnlinkedResultElement,
        val condition: List<UnlinkedEnvironment>,
        val exclusion: List<UnlinkedEnvironment>
    ) : SoundChangerElement {
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

    private class UnlinkedEnvironment : SoundChangerElement

    private interface UnlinkedRuleElement : SoundChangerElement {
        fun plain(): Matcher<PlainS>

        fun phonetic(declarations: Declarations): Matcher<PhonS>
    }

    private interface UnlinkedResultElement : UnlinkedRuleElement {
        fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS>

        fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS>

        fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS>
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

    private class Text(val text: String) : SoundChangerElement
}