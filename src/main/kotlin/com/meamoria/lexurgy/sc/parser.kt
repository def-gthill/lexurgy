package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.BoringErrorListener
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.ParseTree

class LscInterpreter<T>(val walker: LscWalker<T>) {
    fun parseFile(text: String): T = parseAndWalk(text) { it.lscfile() }

    fun parseFeatureDeclaration(text: String): T = parseAndWalk(text) { it.featuredecl() }

    fun parseDiacriticDeclaration(text: String): T = parseAndWalk(text) { it.diacritic() }

    fun parseSymbolDeclaration(text: String): T = parseAndWalk(text) { it.symbol() }

    fun parseDeromanizer(text: String): T = parseAndWalk(text) { it.deromanizer() }

    fun parseRomanizer(text: String): T = parseAndWalk(text) { it.romanizer() }

    fun parseChangeRule(text: String): T = parseAndWalk(text) { it.changerule() }

    fun parseMatrix(text: String): T = parseAndWalk(text) { it.matrix() }

    fun parseFeature(text: String): T = parseAndWalk(text) { it.feature() }

    fun parseValue(text: String): T = parseAndWalk(text) { it.value() }

    private fun parseAndWalk(text: String, parser: (LscParser) -> ParseTree): T {
        val inputStream = CharStreams.fromString(text)
        val lexer = LscLexer(inputStream)
        val tokenStream = CommonTokenStream(lexer)
        val tree = parser(makeLscParser(tokenStream))
        return walker.visit(tree)!!
    }

    private fun makeLscParser(stream: TokenStream): LscParser {
        val parser = LscParser(stream)
        parser.removeErrorListeners()
        parser.addErrorListener(LscErrorListener())
        return parser
    }
}

abstract class LscWalker<T> : LscBaseVisitor<T>() {
    override fun visitLscfile(ctx: LscParser.LscfileContext): T {
        val (changerules, intermediateRomanizers) = visitRulesAndIntermediateRomanizers(ctx)
        return walkFile(
            listVisit(ctx.featuredecl()),
            listVisit(ctx.diacritic()),
            listVisit(ctx.symbol()),
            listVisit(ctx.classdecl()),
            optionalVisit(ctx.deromanizer()),
            changerules,
            optionalVisit(ctx.romanizer()),
            intermediateRomanizers
        )
    }

    private fun visitRulesAndIntermediateRomanizers(
        ctx: LscParser.LscfileContext): Pair<List<T>, List<RomanizerToFollowingRule<T>>> {
        val changeRules = mutableListOf<T>()
        val romanizers = mutableListOf<RomanizerToFollowingRule<T>>()
        var curRomanizer: T? = null
        for (child: ParseTree in ctx.children) {
            when(child) {
                is LscParser.InterromanizerContext -> curRomanizer = visit(child)
                is LscParser.ChangeruleContext -> {
                    val rule = visit(child)
                    changeRules += rule
                    if (curRomanizer != null) {
                        romanizers += RomanizerToFollowingRule(curRomanizer, rule)
                    }
                }
            }
        }
        return changeRules to romanizers
    }

    protected data class RomanizerToFollowingRule<T>(val romanizer: T, val rule: T)

    override fun visitClassdecl(ctx: LscParser.ClassdeclContext): T = walkClassDeclaration(
        visit(ctx.value()),
        listVisit(ctx.text())
    )

    override fun visitFeaturedecl(ctx: LscParser.FeaturedeclContext): T = walkFeatureDeclaration(
        visit(ctx.feature()),
        optionalVisit(ctx.nullalias()),
        listVisit(ctx.value()),
        optionalVisit(ctx.matrix())
    )

    override fun visitDiacritic(ctx: LscParser.DiacriticContext): T = walkDiacriticDeclaration(
        ctx.STR1().text!!,
        visit(ctx.matrix()),
        ctx.DIABEFORE() != null
    )

    override fun visitSymbol(ctx: LscParser.SymbolContext): T {
        val symbolNames = ctx.symbolname().map { it.text!! }
        val matrix = ctx.matrix()
        return if (matrix == null) tlist(symbolNames.map { walkSymbolDeclaration(it) })
        else tlist(listOf(walkSymbolDeclaration(symbolNames.single(), visit(matrix))))
    }

    override fun visitDeromanizer(ctx: LscParser.DeromanizerContext): T =
        walkDeromanizer(listVisit(ctx.ruleexpression()))

    override fun visitRomanizer(ctx: LscParser.RomanizerContext): T = walkRomanizer(listVisit(ctx.ruleexpression()))

    override fun visitInterromanizer(ctx: LscParser.InterromanizerContext): T =
        walkIntermediateRomanizer(ctx.rulename().text!!, listVisit(ctx.ruleexpression()))

    override fun visitChangerule(ctx: LscParser.ChangeruleContext): T = walkChangeRule(
        ctx.rulename().text!!,
        listVisit(ctx.subrule()),
        optionalVisit(ctx.matrix()),
        ctx.PROPAGATE() != null
    )

    override fun visitSubrule(ctx: LscParser.SubruleContext): T = walkSubrule(listVisit(ctx.ruleexpression()))

    override fun visitRuleexpression(ctx: LscParser.RuleexpressionContext): T = walkRuleExpression(
        visit(ctx.rulefrom()),
        visit(ctx.ruleto()),
        optionalVisit(ctx.condition()),
        optionalVisit(ctx.exclusion())
    )

    override fun visitCondition(ctx: LscParser.ConditionContext): T = visit(ctx.getChild(0))

    override fun visitExclusion(ctx: LscParser.ExclusionContext): T = visit(ctx.getChild(0))

    override fun visitRulefrom(ctx: LscParser.RulefromContext): T = visit(ctx.ruleelement())

    override fun visitRuleto(ctx: LscParser.RuletoContext): T = visit(ctx.ruleelement())

    override fun visitEnvironlist(ctx: LscParser.EnvironlistContext): T = tlist(listVisit(ctx.ruleenviron()))

    override fun visitRuleenviron(ctx: LscParser.RuleenvironContext): T = walkRuleEnvironment(
        optionalVisit(ctx.rulebefore()),
        optionalVisit(ctx.ruleafter()),
        ctx.boundarybefore() != null,
        ctx.boundaryafter() != null
    )

    override fun visitRulebefore(ctx: LscParser.RulebeforeContext): T = visit(ctx.ruleelement())

    override fun visitRuleafter(ctx: LscParser.RuleafterContext): T = visit(ctx.ruleelement())

    override fun visitRuleelement(ctx: LscParser.RuleelementContext): T = visit(ctx.getChild(0))

    override fun visitRulesequence(ctx: LscParser.RulesequenceContext): T =
        walkRuleSequence(listVisit(ctx.sequenceelement()))

    override fun visitSequenceelement(ctx: LscParser.SequenceelementContext): T = visit(ctx.getChild(0))

    override fun visitRulecapture(ctx: LscParser.RulecaptureContext): T =
        walkRuleCapture(visit(ctx.getChild(0)), visit(ctx.captureref()))

    override fun visitRulerepeater(ctx: LscParser.RulerepeaterContext): T =
        walkRuleRepeater(visit(ctx.getChild(0)), visit(ctx.repeatertype()))

    override fun visitRulegroup(ctx: LscParser.RulegroupContext): T = visit(ctx.ruleelement())

    override fun visitRulelist(ctx: LscParser.RulelistContext): T = walkRuleList(listVisit(ctx.ruleelement()))

    override fun visitSimpleelement(ctx: LscParser.SimpleelementContext): T = walkSimpleElement(visit(ctx.getChild(0)))

    override fun visitClassref(ctx: LscParser.ClassrefContext): T = walkClassReference(visit(ctx.value()))

    override fun visitCaptureref(ctx: LscParser.CapturerefContext): T = walkCaptureReference(ctx.NUMBER().text.toInt())

    override fun visitFancymatrix(ctx: LscParser.FancymatrixContext): T = walkMatrix(listVisit(ctx.fancyvalue()))

    override fun visitFancyvalue(ctx: LscParser.FancyvalueContext): T = visit(ctx.getChild(0))

    override fun visitNegvalue(ctx: LscParser.NegvalueContext): T = walkNegatedValue(visit(ctx.value()))

    override fun visitAbsentfeature(ctx: LscParser.AbsentfeatureContext): T = walkAbsentFeature(visit(ctx.feature()))

    override fun visitFeaturevariable(ctx: LscParser.FeaturevariableContext): T =
        walkFeatureVariable(visit(ctx.feature()))

    override fun visitEmpty(ctx: LscParser.EmptyContext): T = walkEmpty()

    override fun visitRepeatertype(ctx: LscParser.RepeatertypeContext): T = walkRepeaterType(
        when {
            ctx.ATLEASTONE() != null -> RepeaterType.ONE_OR_MORE
            ctx.NULL() != null -> RepeaterType.ZERO_OR_MORE
            ctx.OPTIONAL() != null -> RepeaterType.ZERO_OR_ONE
            else -> throw AssertionError()
        }
    )

    override fun visitMatrix(ctx: LscParser.MatrixContext): T = walkMatrix(listVisit(ctx.value()))

    override fun visitFeature(ctx: LscParser.FeatureContext): T = walkFeature(ctx.FEATURE().text)

    override fun visitValue(ctx: LscParser.ValueContext): T = walkValue(ctx.VALUE().text)

    override fun visitText(ctx: LscParser.TextContext): T = walkText(ctx.text)

    protected abstract fun walkFile(
        featureDeclarations: List<T>,
        diacriticDeclarations: List<T>,
        symbolDeclarations: List<T>,
        classDeclarations: List<T>,
        deromanizer: T?,
        changeRules: List<T>,
        romanizer: T?,
        intermediateRomanizers: List<RomanizerToFollowingRule<T>>
    ): T

    protected abstract fun walkClassDeclaration(className: T, sounds: List<T>): T

    protected abstract fun walkFeatureDeclaration(
        featureName: T,
        nullAlias: T?,
        values: List<T>,
        implication: T?
    ): T

    protected abstract fun walkDiacriticDeclaration(diacritic: String, matrix: T, before: Boolean): T

    protected abstract fun walkSymbolDeclaration(symbol: String, matrix: T? = null): T

    protected abstract fun walkDeromanizer(expressions: List<T>): T

    protected abstract fun walkRomanizer(expressions: List<T>): T

    protected abstract fun walkIntermediateRomanizer(ruleName: String, expressions: List<T>): T

    protected abstract fun walkChangeRule(
        ruleName: String,
        subrules: List<T>,
        ruleFilter: T?,
        propagate: Boolean
    ): T

    protected abstract fun walkSubrule(expressions: List<T>): T

    protected abstract fun walkRuleExpression(
        ruleFrom: T,
        ruleTo: T,
        condition: T?,
        exclusion: T?
    ): T

    protected abstract fun walkRuleEnvironment(
        before: T?,
        after: T?,
        boundaryBefore: Boolean,
        boundaryAfter: Boolean
    ): T

    protected abstract fun walkRuleSequence(items: List<T>): T

    protected open fun walkRuleCapture(item: T, capture: T): T = item

    protected open fun walkRuleRepeater(item: T, repeaterType: T): T = item

    protected abstract fun walkRuleList(items: List<T>): T

    protected open fun walkSimpleElement(element: T): T = element

    protected abstract fun walkEmpty(): T

    protected abstract fun walkClassReference(value: T): T

    protected abstract fun walkCaptureReference(number: Int): T

    protected open fun walkRepeaterType(type: RepeaterType): T = throw NotImplementedError()

    protected abstract fun walkMatrix(values: List<T>): T

    protected open fun walkNegatedValue(value: T): T = value

    protected open fun walkAbsentFeature(feature: T): T = feature

    protected open fun walkFeatureVariable(feature: T): T = feature

    protected abstract fun walkFeature(name: String): T

    protected abstract fun walkValue(name: String): T

    protected abstract fun walkText(text: String): T

    /**
     * Packages a list of T's into an object that is also a T, so that visit functions can return lists
     */
    protected abstract fun tlist(items: List<T>): T

    private fun listVisit(node: List<ParseTree>): List<T> = node.map { visit(it) }

    private fun optionalVisit(node: ParseTree?): T? = node?.let { visit(it) }
}

private class LscErrorListener : BoringErrorListener() {
    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        e: RecognitionException?
    ): Nothing {
        throw LscNotParsable(line, charPositionInLine, offendingSymbol.toString(), msg)
    }
}

class LscNotParsable(val line: Int, val column: Int, val offendingSymbol: String, message: String) :
    Exception("$message (Line $line, column $column)")
