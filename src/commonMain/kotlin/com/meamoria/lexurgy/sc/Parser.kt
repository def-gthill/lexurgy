package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.LscUserError
import com.meamoria.lexurgy.downToType
import com.meamoria.lexurgy.upToType
import com.meamoria.mpp.antlr.*
import kotlin.reflect.KClass

class LscInterpreter<T>(val walker: LscWalker<T>) {
    fun parseFile(text: String): T = parseAndWalk(text) { it.lscFile() }

    fun parseFeatureDeclaration(text: String): T = parseAndWalk(text) { it.featureDecl() }

    fun parseDiacriticDeclaration(text: String): T = parseAndWalk(text) { it.diacriticDecl() }

    fun parseSymbolDeclaration(text: String): T = parseAndWalk(text) { it.symbolDecl() }

    fun parseDeromanizer(text: String): T = parseAndWalk(text) { it.deromanizer() }

    fun parseRomanizer(text: String): T = parseAndWalk(text) { it.romanizer() }

    fun parseChangeRule(text: String): T = parseAndWalk(text) { it.changeRule() }

    fun parseMatrix(text: String): T = parseAndWalk(text) { it.matrix() }

    fun parseFeature(text: String): T = parseAndWalk(text) { it.feature() }

    fun parseValue(text: String): T = parseAndWalk(text) { it.value() }

    private fun parseAndWalk(text: String, parser: (LscParser) -> ParseTree): T {
        val inputStream = CharStreams.fromString(text)
        val lexer = LscLexer(inputStream)
        val tokenStream = CommonTokenStream(lexer)
        try {
            val tree = parser(makeLscParser(tokenStream))
            return walker.visit(tree)!!
        } catch (e: LscNotParsable) {
            if (e.needsBetterErrorMessage()) {
                throwWithBetterErrorMessage(e, text)
            } else throw e
        }
    }

    private fun makeLscParser(stream: TokenStream): LscParser {
        val parser = LscParser(stream)
        parser.removeErrorListeners()
        parser.addCommonAntlrErrorListener(LscErrorListener())
        return parser
    }

    private fun LscNotParsable.needsBetterErrorMessage() =
        customMessage.startsWith("extraneous") ||
                customMessage.startsWith("mismatched")

    private fun throwWithBetterErrorMessage(e: LscNotParsable, inputText: String): Nothing {
        val offendingLine = inputText.lines()[e.line - 1]
        throw LscNotParsable(
            e.line, e.column, e.offendingSymbol,
            betterErrorMessage(e.customMessage, e.offendingSymbol, offendingLine)
        )
    }

    private fun betterErrorMessage(
        @Suppress("UNUSED_PARAMETER") oldMessage: String,
        offendingSymbol: String,
        offendingLine: String
    ): String = "\"$offendingSymbol\" doesn't make sense in the line \"$offendingLine\""
}

abstract class LscWalker<T> : LscBaseVisitor<T>() {
    override fun visitLscFile(ctx: LscFileContext): T {
        val statementContexts = ctx.allStatements().map { it.getChild(0) as ParserRuleContext }
        validateOrder(statementContexts)
        val (changeRules, intermediateRomanizers) = visitRulesAndIntermediateRomanizers(statementContexts)
        return walkFile(
            featureDeclarations = listVisit(statementContexts.filterIsInstance<FeatureDeclContext>()),
            diacriticDeclarations = listVisit(statementContexts.filterIsInstance<DiacriticDeclContext>()),
            symbolDeclarations = listVisit(statementContexts.filterIsInstance<SymbolDeclContext>()),
            classDeclarations = listVisit(statementContexts.filterIsInstance<ClassDeclContext>()),
            deromanizer = optionalVisit(statementContexts.filterIsInstance<DeromanizerContext>().singleOrNull()),
            changeRules = changeRules,
            romanizer = optionalVisit(statementContexts.filterIsInstance<RomanizerContext>().singleOrNull()),
            intermediateRomanizers = intermediateRomanizers,
        )
    }

    private fun visitRulesAndIntermediateRomanizers(
        contexts: List<ParserRuleContext>
    ): Pair<List<T>, List<RomanizerToFollowingRule<T>>> {
        val changeRules = mutableListOf<T>()
        val romanizers = mutableListOf<RomanizerToFollowingRule<T>>()
        val curRomanizers = mutableListOf<T>()
        for (context in contexts) {
            when (context) {
                is InterRomanizerContext -> curRomanizers += visit(context)
                is ChangeRuleContext -> {
                    val rule = visit(context)
                    changeRules += rule
                    romanizers.addAll(curRomanizers.map { RomanizerToFollowingRule(it, rule) })
                    curRomanizers.clear()
                }
            }
        }
        romanizers.addAll(curRomanizers.map { RomanizerToFollowingRule(it, null) })
        return changeRules to romanizers
    }

    private fun validateOrder(statements: List<ParserRuleContext>) {
        for ((prev, next) in statements.zipWithNext()) {
            if (allowedStatementPositions.getValue(prev::class) > allowedStatementPositions.getValue(next::class)) {
                throw LscNotParsable(
                    prev.getStartLine(), 0, prev.getText(),
                    "The ${statementNames.getValue(prev::class)} must come after " +
                            "the ${statementNames.getValue(next::class)}"
                )
            }
        }
    }

    private val allowedStatementPositions: Map<KClass<*>, Int> = mapOf(
        FeatureDeclContext::class to 0,
        DiacriticDeclContext::class to 10,
        SymbolDeclContext::class to 10,
        ClassDeclContext::class to 30,
        DeromanizerContext::class to 40,
        ChangeRuleContext::class to 50,
        InterRomanizerContext::class to 50,
        RomanizerContext::class to 60,
    )

    private val statementNames: Map<KClass<*>, String> = mapOf(
        FeatureDeclContext::class to "feature declarations",
        DiacriticDeclContext::class to "diacritic declarations",
        SymbolDeclContext::class to "symbol declarations",
        ClassDeclContext::class to "class declarations",
        DeromanizerContext::class to "deromanizer",
        ChangeRuleContext::class to "change rules",
        InterRomanizerContext::class to "intermediate romanizers",
        RomanizerContext::class to "final romanizer",
    )

    /**
     * A romanizer anchored before a particular rule.
     * If ``rule`` is null, this romanizer is after all the rules.
     */
    protected data class RomanizerToFollowingRule<T>(val romanizer: T, val rule: T?)

    override fun visitClassDecl(ctx: ClassDeclContext): T = walkClassDeclaration(
        visit(ctx.value()),
        listVisit(ctx.allClassElements()),
    )

    override fun visitClassElement(ctx: ClassElementContext): T = visit(ctx.getChild(0))

    override fun visitFeatureDecl(ctx: FeatureDeclContext): T = walkFeatureDeclaration(
        visit(ctx.feature()),
        optionalVisit(ctx.nullAlias()),
        listVisit(ctx.allValues()),
        optionalVisit(ctx.matrix()),
    )

    override fun visitNullAlias(ctx: NullAliasContext): T = visit(ctx.value())

    override fun visitDiacriticDecl(ctx: DiacriticDeclContext): T {
        val modifiers = ctx.allDiacriticModifiers()
        val before = modifiers.any { it.DIA_BEFORE() != null }
        val floating = modifiers.any { it.DIA_FLOATING() != null }
        return walkDiacriticDeclaration(
            ctx.STR1().getText(),
            visit(ctx.matrix()),
            before,
            floating,
        )
    }

    override fun visitSymbolDecl(ctx: SymbolDeclContext): T {
        val symbolNames = ctx.allSymbolNames().map { removeEscapes(it.getText()) }
        val matrix = ctx.matrix()
        return if (matrix == null) tlist(symbolNames.map { walkSymbolDeclaration(it) })
        else tlist(listOf(walkSymbolDeclaration(symbolNames.single(), visit(matrix))))
    }

    override fun visitDeromanizer(ctx: DeromanizerContext): T =
        walkDeromanizer(untlist(visit(ctx.subrules())), ctx.LITERAL() != null)

    override fun visitRomanizer(ctx: RomanizerContext): T =
        walkRomanizer(untlist(visit(ctx.subrules())), ctx.LITERAL() != null)

    override fun visitInterRomanizer(ctx: InterRomanizerContext): T =
        walkIntermediateRomanizer(ctx.ruleName().getText(), untlist(visit(ctx.subrules())), ctx.LITERAL() != null)

    override fun visitChangeRule(ctx: ChangeRuleContext): T {
        val ruleName = ctx.ruleName().getText()
        val modifiers = ctx.allChangeRuleModifiers()
        if (ctx.RULE_START() == null) {
            noColon(ruleName, modifiers, ctx.firstNewline())
        }
        val filter = modifiers.mapNotNull { it.filter() }.let { filters ->
            if (filters.isEmpty()) null
            else filters.singleOrNull() ?: multipleFilters(ruleName, filters)
        }
        val propagate = modifiers.any { it.PROPAGATE() != null }
        return walkChangeRule(
            ruleName,
            untlist(visit(ctx.subrules())),
            optionalVisit(filter),
            propagate,
        )
    }

    private fun noColon(
        ruleName: String, modifiers: List<ChangeRuleModifierContext>, newline: TerminalNode
    ): Nothing =
        throw LscNotParsable(
            newline.getLine(),
            newline.getStartColumn(),
            "new line",
            "The rule \"$ruleName\" needs a colon after " +
                    if (modifiers.isEmpty()) "the rule name" else "\"${modifiers.last().getText()}\""
        )

    private fun multipleFilters(ruleName: String, filters: List<FilterContext>): Nothing =
        throw LscNotParsable(
            filters[1].getStartLine(),
            filters[1].getStartColumn(),
            filters[1].getText(),
            "The rule \"$ruleName\" has more than one filter: ${filters[0].getText()} and ${filters[1].getText()}"
        )

    override fun visitFilter(ctx: FilterContext): T = visit(ctx.getChild(0))

    override fun visitSubrules(ctx: SubrulesContext): T = tlist(listVisit(ctx.allSubrules()))

    override fun visitSubrule(ctx: SubruleContext): T = walkSubrule(listVisit(ctx.allExpressions()))

    override fun visitExpression(ctx: ExpressionContext): T =
        if (ctx.UNCHANGED() == null) {
            walkRuleExpression(
                visit(ctx.from()!!),
                visit(ctx.to()!!),
                optionalVisit(ctx.condition()),
                optionalVisit(ctx.exclusion()),
            )
        } else {
            walkDoNothingExpression()
        }

    override fun visitCondition(ctx: ConditionContext): T = visit(ctx.getChild(0))

    override fun visitExclusion(ctx: ExclusionContext): T = visit(ctx.getChild(0))

    override fun visitFrom(ctx: FromContext): T = visit(ctx.ruleElement())

    override fun visitTo(ctx: ToContext): T = visit(ctx.ruleElement())

    override fun visitEnvironmentList(ctx: EnvironmentListContext): T = tlist(listVisit(ctx.allEnvironments()))

    override fun visitEnvironment(ctx: EnvironmentContext): T {
        if (ctx.ANCHOR() == null) {
            val ruleName = ctx.upToType<ChangeRuleContext>().downToType<RuleNameContext>()?.getText()
            throw LscNotParsable(
                ctx.getStartLine(), ctx.getStartColumn() + 1, ctx.getText(),
                "The environment \"${ctx.getText()}\" in rule $ruleName needs an underscore"
            )
        }
        return walkRuleEnvironment(
            ctx.getText(),
            optionalVisit(ctx.environmentBefore()),
            optionalVisit(ctx.environmentAfter()),
        )
    }

    override fun visitEnvironmentBefore(ctx: EnvironmentBeforeContext): T = visit(ctx.ruleElement())

    override fun visitEnvironmentAfter(ctx: EnvironmentAfterContext): T = visit(ctx.ruleElement())

    override fun visitRuleElement(ctx: RuleElementContext): T = visit(ctx.getChild(0))

    override fun visitSequence(ctx: SequenceContext): T =
        walkRuleSequence(ctx.getText(), listVisit(ctx.allSequenceElements()))

    override fun visitSequenceElement(ctx: SequenceElementContext): T = visit(ctx.getChild(0))

    override fun visitCapture(ctx: CaptureContext): T =
        walkRuleCapture(visit(ctx.getChild(0)), visit(ctx.captureRef()))

    override fun visitRepeater(ctx: RepeaterContext): T =
        walkRuleRepeater(ctx.getText(), visit(ctx.getChild(0)), visit(ctx.repeaterType()))

    override fun visitGroup(ctx: GroupContext): T = visit(ctx.ruleElement())

    override fun visitList(ctx: ListContext): T = walkRuleList(listVisit(ctx.allRuleElements()))

    override fun visitSimple(ctx: SimpleContext): T = walkSimpleElement(visit(ctx.getChild(0)))

    override fun visitNegated(ctx: NegatedContext): T = walkNegatedElement(visit(ctx.getChild(1)))

    override fun visitClassRef(ctx: ClassRefContext): T = walkClassReference(visit(ctx.value()))

    override fun visitCaptureRef(ctx: CaptureRefContext): T = walkCaptureReference(ctx.NUMBER().getText().toInt())

    override fun visitFancyMatrix(ctx: FancyMatrixContext): T = walkMatrix(listVisit(ctx.allFancyValues()))

    override fun visitFancyValue(ctx: FancyValueContext): T = visit(ctx.getChild(0))

    override fun visitNegatedValue(ctx: NegatedValueContext): T = walkNegatedValue(visit(ctx.value()))

    override fun visitAbsentFeature(ctx: AbsentFeatureContext): T = walkAbsentFeature(visit(ctx.feature()))

    override fun visitFeatureVariable(ctx: FeatureVariableContext): T =
        walkFeatureVariable(visit(ctx.feature()))

    override fun visitEmpty(ctx: EmptyContext): T = walkEmpty()

    override fun visitBoundary(ctx: BoundaryContext): T = walkBoundary()

    override fun visitRepeaterType(ctx: RepeaterTypeContext): T = walkRepeaterType(
        when {
            ctx.AT_LEAST_ONE() != null -> RepeaterType.ONE_OR_MORE
            ctx.NULL() != null -> RepeaterType.ZERO_OR_MORE
            ctx.OPTIONAL() != null -> RepeaterType.ZERO_OR_ONE
            else -> throw AssertionError()
        }
    )

    override fun visitMatrix(ctx: MatrixContext): T = walkMatrix(listVisit(ctx.allValues()))

    override fun visitFeature(ctx: FeatureContext): T = walkFeature(ctx.FEATURE().getText())

    override fun visitValue(ctx: ValueContext): T = walkValue(ctx.VALUE().getText())

    override fun visitText(ctx: TextContext): T =
        walkText(removeEscapes(ctx.getChild(0).getText()), ctx.NEGATION() != null)

    private fun removeEscapes(text: String): String =
        text.split("\\\\").joinToString("\\") { it.replace("\\", "") }

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

    protected abstract fun walkClassDeclaration(className: T, elements: List<T>): T

    protected abstract fun walkFeatureDeclaration(
        featureName: T,
        nullAlias: T?,
        values: List<T>,
        implication: T?
    ): T

    protected abstract fun walkDiacriticDeclaration(
        diacritic: String, matrix: T, before: Boolean, floating: Boolean
    ): T

    protected abstract fun walkSymbolDeclaration(symbol: String, matrix: T? = null): T

    protected abstract fun walkDeromanizer(subrules: List<T>, literal: Boolean): T

    protected abstract fun walkRomanizer(subrules: List<T>, literal: Boolean): T

    protected abstract fun walkIntermediateRomanizer(ruleName: String, subrules: List<T>, literal: Boolean): T

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

    protected abstract fun walkDoNothingExpression(): T

    protected abstract fun walkRuleEnvironment(
        text: String,
        before: T?,
        after: T?,
    ): T

    protected abstract fun walkRuleSequence(text: String, items: List<T>): T

    protected open fun walkRuleCapture(item: T, capture: T): T = item

    protected open fun walkRuleRepeater(text: String, item: T, repeaterType: T): T = item

    protected abstract fun walkRuleList(items: List<T>): T

    protected open fun walkSimpleElement(element: T): T = element

    protected abstract fun walkNegatedElement(element: T): T

    protected abstract fun walkEmpty(): T

    protected abstract fun walkBoundary(): T

    protected abstract fun walkClassReference(value: T): T

    protected abstract fun walkCaptureReference(number: Int): T

    protected open fun walkRepeaterType(type: RepeaterType): T = throw NotImplementedError()

    protected abstract fun walkMatrix(values: List<T>): T

    protected open fun walkNegatedValue(value: T): T = value

    protected open fun walkAbsentFeature(feature: T): T = feature

    protected open fun walkFeatureVariable(feature: T): T = feature

    protected abstract fun walkFeature(name: String): T

    protected abstract fun walkValue(name: String): T

    protected abstract fun walkText(text: String, exact: Boolean): T

    /**
     * Packages a list of T's into an object that is also a T, so that visit functions can return lists
     */
    protected abstract fun tlist(items: List<T>): T

    /**
     * Unpackages items from a tlist.
     */
    protected abstract fun untlist(list: T): List<T>

    private fun listVisit(node: List<ParseTree>): List<T> = node.map { visit(it) }

    private fun optionalVisit(node: ParseTree?): T? = node?.let { visit(it) }
}

private class LscErrorListener : CommonAntlrErrorListener() {
    override fun handleSyntaxError(
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        exception: RecognitionException?,
    ): Nothing {
        val offendingToken = (offendingSymbol as? Token)?.getTokenText() ?: offendingSymbol.toString()
        val userFriendlyMessage = exception?.let { getUserFriendlyMessage(it, offendingToken) }
        throw LscNotParsable(
            line,
            charPositionInLine,
            offendingToken,
            userFriendlyMessage ?: msg
        )
    }

    private fun getUserFriendlyMessage(exception: RecognitionException, offendingToken: String): String? {
        for (messageMaker in userFriendlyMessageMakers) {
            messageMaker(exception, offendingToken)?.let { return it }
        }
        return null
    }

    private val userFriendlyMessageMakers: List<(RecognitionException, String) -> String?> = listOf(
        this::ifFeatureNameIsInvalid,
        this::ifFeatureValueNameIsInvalid,
        this::ifRuleNameIsInvalid,
    )

    private fun ifFeatureNameIsInvalid(
        exception: RecognitionException,
        @Suppress("UNUSED_PARAMETER") offendingToken: String
    ): String? =
        (exception.getContext() as ParserRuleContext?).upToType<FeatureDeclContext> {
            if (exception.getExpectedTokens().contains(LSC_FEATURE)) {
                val attemptedFeatureName = exception.getMismatchedToken().getTokenText()
                val reason = when {
                    attemptedFeatureName[0].toUpperCase() != attemptedFeatureName[0] ->
                        "feature names must start with an uppercase letter"
                    else -> "feature names must consist of letters and numbers only and start with an uppercase letter"
                }
                "A feature can't be called \"$attemptedFeatureName\"; $reason"
            } else null
        }

    private fun ifFeatureValueNameIsInvalid(
        exception: RecognitionException,
        @Suppress("UNUSED_PARAMETER") offendingToken: String
    ): String? =
        (exception.getContext() as ParserRuleContext?).upToType<FeatureDeclContext> {
            if (exception.getExpectedTokens().contains(LSC_VALUE)) {
                val attemptedValueName = exception.getMismatchedToken().getTokenText()
                val reason = when {
                    attemptedValueName[0].toLowerCase() != attemptedValueName[0] ->
                        "value names must start with a lowercase letter"
                    else -> "value names must consist of letters and numbers only and start with a lowercase letter"
                }
                "A feature value can't be called \"$attemptedValueName\"; $reason"
            } else null
        }

    private fun ifRuleNameIsInvalid(exception: RecognitionException, offendingToken: String): String? =
        (exception.getContext() as ParserRuleContext?).upToType<ChangeRuleContext> { ctx ->
            val expectedTokens = exception.getExpectedTokens()
            val ruleNameStart =
                when {
                    expectedTokens.contains(LSC_RULE_START) -> {
                        ctx.getText() + offendingToken
                    }
                    expectedTokens.contains(LSC_PROPAGATE) -> {
                        ctx.getText()
                    }
                    else -> null
                }
            ruleNameStart?.let {
                "A rule name can't start with \"${it}\"; " +
                        "rule names must consist of only lowercase letters and hyphens"
            }
        }
}

class LscNotParsable(val line: Int, val column: Int, val offendingSymbol: String, val customMessage: String) :
    LscUserError("$customMessage (Line $line, column $column)")
