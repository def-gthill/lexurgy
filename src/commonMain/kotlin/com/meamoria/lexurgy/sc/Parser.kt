package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import com.meamoria.mpp.antlr.*
import kotlin.jvm.JvmName
import kotlin.reflect.KClass

class LscInterpreter {
    fun parseFile(text: String): LscWalker.ParseNode = parseAndWalk(text) { it.lscFile() }

    fun parseFeatureDeclaration(text: String): LscWalker.ParseNode = parseAndWalk(text) { it.featureDecl() }

    fun parseDiacriticDeclaration(text: String): LscWalker.ParseNode = parseAndWalk(text) { it.diacriticDecl() }

    fun parseSymbolDeclaration(text: String): LscWalker.ParseNode = parseAndWalk(text) { it.symbolDecl() }

    fun parseDeromanizer(text: String): LscWalker.ParseNode = parseAndWalk(text) { it.deromanizer() }

    fun parseRomanizer(text: String): LscWalker.ParseNode = parseAndWalk(text) { it.romanizer() }

    fun parseChangeRule(text: String): LscWalker.ParseNode = parseAndWalk(text) { it.changeRule() }

    fun parseMatrix(text: String): LscWalker.ParseNode = parseAndWalk(text) { it.matrix() }

    private fun parseAndWalk(text: String, parser: (LscParser) -> ParseTree): LscWalker.ParseNode {
        val inputStream = CharStreams.fromString(text)
        val lexer = LscLexer(inputStream)
        val tokenStream = CommonTokenStream(lexer)
        try {
            val tree = parser(makeLscParser(tokenStream))
            return LscWalker.visit(tree)
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
                customMessage.startsWith("mismatched") ||
                customMessage.startsWith("no viable alternative") ||
                customMessage.startsWith("missing")

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

object LscWalker : LscBaseVisitor<LscWalker.ParseNode>() {
    override fun visitLscFile(ctx: LscFileContext): ParseNode {
        val statementContexts = ctx.allStatements().map { it.getChild(0) as ParserRuleContext }
        validateOrder(statementContexts)
        val (changeRules, intermediateRomanizers) = visitRulesAndIntermediateRomanizers(statementContexts)
        return walkFile(
            ctx.getText(),
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
    ): Pair<List<ParseNode>, List<RomanizerToFollowingRule<ParseNode>>> {
        val changeRules = mutableListOf<ParseNode>()
        val romanizers = mutableListOf<RomanizerToFollowingRule<ParseNode>>()
        val curRomanizers = mutableListOf<ParseNode>()
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
    private data class RomanizerToFollowingRule<ParseNode>(
        val romanizer: ParseNode,
        val rule: ParseNode?,
    )

    override fun visitClassDecl(ctx: ClassDeclContext): ParseNode = walkClassDeclaration(
        ctx.getText(),
        visit(ctx.name()),
        listVisit(ctx.allClassElements()),
    )

    override fun visitClassElement(ctx: ClassElementContext): ParseNode = visit(ctx.getChild(0))

    override fun visitFeatureDecl(ctx: FeatureDeclContext): ParseNode =
        if (ctx.name() == null) {
            ParseNodeList(
                listVisit(ctx.allPlusFeatures()),
            )
        } else {
            ParseNodeList(
                listOf(
                    walkFeatureDeclaration(
                        ctx.getText(),
                        visit(ctx.name()!!),
                        optionalVisit(ctx.nullAlias()),
                        listVisit(ctx.allFeatureValues()),
                    )
                )
            )
        }

    override fun visitPlusFeature(ctx: PlusFeatureContext): ParseNode = walkPlusFeature(
        ctx.getText(),
        visit(ctx.name()),
        ctx.AT_LEAST_ONE() != null,
    )

    override fun visitNullAlias(ctx: NullAliasContext): ParseNode = visit(ctx.featureValue())

    override fun visitDiacriticDecl(ctx: DiacriticDeclContext): ParseNode {
        val modifiers = ctx.allDiacriticModifiers()
        val before = modifiers.any { it.DIA_BEFORE() != null }
        val floating = modifiers.any { it.DIA_FLOATING() != null }
        return walkDiacriticDeclaration(
            ctx.getText(),
            removeEscapes(ctx.text().getText()),
            visit(ctx.matrix()),
            before,
            floating,
        )
    }

    override fun visitSymbolDecl(ctx: SymbolDeclContext): ParseNode {
        val symbolNames = ctx.allSymbolNames().map { removeEscapes(it.getText()) }
        val matrix = ctx.matrix()
        return if (matrix == null) ParseNodeList(
            symbolNames.map { walkSymbolDeclaration(it, it, null) }
        )
        else ParseNodeList(
            listOf(walkSymbolDeclaration(ctx.getText(), symbolNames.single(), visit(matrix)))
        )
    }

    override fun visitDeromanizer(ctx: DeromanizerContext): ParseNode =
        walkDeromanizer(
            ctx.getText(),
            unpackParseNodeList(visit(ctx.subrules())),
            ctx.LITERAL() != null
        )

    override fun visitRomanizer(ctx: RomanizerContext): ParseNode =
        walkRomanizer(
            ctx.getText(),
            unpackParseNodeList(visit(ctx.subrules())),
            ctx.LITERAL() != null
        )

    override fun visitInterRomanizer(ctx: InterRomanizerContext): ParseNode =
        walkIntermediateRomanizer(
            ctx.getText(),
            ctx.ruleName().getText(),
            unpackParseNodeList(visit(ctx.subrules())),
            ctx.LITERAL() != null
        )

    override fun visitChangeRule(ctx: ChangeRuleContext): ParseNode {
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
            ctx.getText(),
            ruleName,
            unpackParseNodeList(visit(ctx.subrules())),
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

    override fun visitFilter(ctx: FilterContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitSubrules(ctx: SubrulesContext): ParseNode =
        ParseNodeList(listVisit(ctx.allSubrules()))

    override fun visitSubrule(ctx: SubruleContext): ParseNode =
        walkSubrule(listVisit(ctx.allExpressions()))

    override fun visitExpression(ctx: ExpressionContext): ParseNode =
        if (ctx.UNCHANGED() == null) {
            walkRuleExpression(
                ctx.getText(),
                visit(ctx.from()!!),
                visit(ctx.to()!!),
                optionalVisit(ctx.condition()),
                optionalVisit(ctx.exclusion()),
            )
        } else {
            walkDoNothingExpression()
        }

    override fun visitCondition(ctx: ConditionContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitExclusion(ctx: ExclusionContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitFrom(ctx: FromContext): ParseNode =
        visit(ctx.ruleElement())

    override fun visitTo(ctx: ToContext): ParseNode =
        visit(ctx.ruleElement())

    override fun visitEnvironmentList(ctx: EnvironmentListContext): ParseNode =
        ParseNodeList(listVisit(ctx.allEnvironments()))

    override fun visitEnvironment(ctx: EnvironmentContext): ParseNode {
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

    override fun visitEnvironmentBefore(ctx: EnvironmentBeforeContext): ParseNode = visit(ctx.ruleElement())

    override fun visitEnvironmentAfter(ctx: EnvironmentAfterContext): ParseNode = visit(ctx.ruleElement())

    override fun visitRuleElement(ctx: RuleElementContext): ParseNode = visit(ctx.getChild(0))

    override fun visitSequence(ctx: SequenceContext): ParseNode =
        walkRuleSequence(ctx.getText(), listVisit(ctx.allSequenceElements()))

    override fun visitSequenceElement(ctx: SequenceElementContext): ParseNode = visit(ctx.getChild(0))

    override fun visitCapture(ctx: CaptureContext): ParseNode =
        walkRuleCapture(
            ctx.getText(),
            visit(ctx.getChild(0)),
            visit(ctx.captureRef()),
        )

    override fun visitRepeater(ctx: RepeaterContext): ParseNode =
        walkRuleRepeater(ctx.getText(), visit(ctx.getChild(0)), visit(ctx.repeaterType()))

    override fun visitGroup(ctx: GroupContext): ParseNode =
        visit(ctx.ruleElement())

    override fun visitList(ctx: ListContext): ParseNode =
        walkRuleList(
            ctx.getText(),
            listVisit(ctx.allRuleElements()),
        )

    override fun visitIntersection(ctx: IntersectionContext): ParseNode =
        walkIntersection(
            ctx.getText(),
            listVisit(ctx.allIntersectionElements()),
        )

    override fun visitIntersectionElement(ctx: IntersectionElementContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitSimple(ctx: SimpleContext): ParseNode =
        walkSimpleElement(visit(ctx.getChild(0)))

    override fun visitNegated(ctx: NegatedContext): ParseNode =
        walkNegatedElement(
            ctx.getText(),
            visit(ctx.getChild(1)),
        )

    override fun visitClassRef(ctx: ClassRefContext): ParseNode =
        walkClassReference(
            ctx.getText(),
            visit(ctx.name()),
        )

    override fun visitCaptureRef(ctx: CaptureRefContext): ParseNode =
        walkCaptureReference(
            ctx.getText(),
            ctx.NUMBER().getText().toInt(),
        )

    override fun visitFancyMatrix(ctx: FancyMatrixContext): ParseNode =
        walkMatrix(
            ctx.getText(),
            listVisit(ctx.allFancyValues()),
        )

    override fun visitFancyValue(ctx: FancyValueContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitNegatedValue(ctx: NegatedValueContext): ParseNode =
        walkNegatedValue(
            ctx.getText(),
            visit(ctx.name()),
        )

    override fun visitAbsentFeature(ctx: AbsentFeatureContext): ParseNode =
        walkAbsentFeature(
            ctx.getText(),
            visit(ctx.name()),
        )

    override fun visitFeatureVariable(ctx: FeatureVariableContext): ParseNode =
        walkFeatureVariable(
            ctx.getText(),
            visit(ctx.name()),
        )

    override fun visitEmpty(ctx: EmptyContext): ParseNode = walkEmpty()

    override fun visitBoundary(ctx: BoundaryContext): ParseNode = walkBoundary()

    override fun visitBetweenWords(ctx: BetweenWordsContext): ParseNode = walkBetweenWords()

    override fun visitRepeaterType(ctx: RepeaterTypeContext): ParseNode =
        walkRepeaterType(
            ctx.getText(),
            when {
                ctx.AT_LEAST_ONE() != null -> RepeaterType.ONE_OR_MORE
                ctx.NULL() != null -> RepeaterType.ZERO_OR_MORE
                ctx.OPTIONAL() != null -> RepeaterType.ZERO_OR_ONE
                else -> throw AssertionError()
            }
        )

    override fun visitMatrix(ctx: MatrixContext): ParseNode =
        walkMatrix(
            ctx.getText(),
            listVisit(ctx.allMatrixValues()),
        )

    override fun visitMatrixValue(ctx: MatrixValueContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitPlusFeatureValue(ctx: PlusFeatureValueContext): ParseNode =
        walkPlusFeatureValue(
            ctx.getText(),
            visit(ctx.name()),
            when {
                ctx.AT_LEAST_ONE() != null -> PlusMinus.PLUS
                ctx.HYPHEN() != null -> PlusMinus.MINUS
                else -> throw AssertionError()
            }
        )

    private enum class PlusMinus(val string: String) {
        PLUS("+"),
        MINUS("-"),
    }

    override fun visitFeatureValue(ctx: FeatureValueContext): ParseNode =
        walkFeatureValue(
            ctx.getText(),
            visit(ctx.name()),
        )

    override fun visitName(ctx: NameContext): ParseNode =
        walkName(
            ctx.getText(),
            ctx.NAME().getText(),
        )

    override fun visitText(ctx: TextContext): ParseNode =
        walkText(ctx.getText(), removeEscapes(ctx.getChild(0).getText()), ctx.NEGATION() != null)

    private fun removeEscapes(text: String): String =
        text.split("\\\\").joinToString("\\") {
            it.replace("\\", "")
        }

    private fun walkFile(
        text: String,
        featureDeclarations: List<ParseNode>,
        diacriticDeclarations: List<ParseNode>,
        symbolDeclarations: List<ParseNode>,
        classDeclarations: List<ParseNode>,
        deromanizer: ParseNode?,
        changeRules: List<ParseNode>,
        romanizer: ParseNode?,
        intermediateRomanizers: List<RomanizerToFollowingRule<ParseNode>>
    ): ParseNode = SoundChangerNodeImpl(
        text,
        featureDeclarations,
        diacriticDeclarations,
        symbolDeclarations,
        classDeclarations,
        deromanizer,
        changeRules,
        romanizer,
        intermediateRomanizers
    )

    private fun resolveClasses(classDeclarations: List<ParseNode>): List<SegmentClass> {
        val classes = mutableMapOf<String, SegmentClass>()
        for (classDeclaration in classDeclarations) {
            val classNode = classDeclaration as ClassDeclarationNode
            val newClassSounds = classNode.elements.flatMap {
                if (it is TextNode) listOf(it.literalText)
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

    private fun walkClassDeclaration(
        text: String,
        className: ParseNode,
        elements: List<ParseNode>,
    ): ParseNode =
        ClassDeclarationNode(
            text,
            (className as NameNode).name,
            elements,
        )

    private fun walkFeatureDeclaration(
        text: String,
        featureName: ParseNode,
        nullAlias: ParseNode?,
        values: List<ParseNode>,
    ): ParseNode = FeatureDeclarationNode(
        text,
        Feature(
            (featureName as NameNode).name,
            values.map { (it as SimpleValueNode).simpleValue },
            (nullAlias as? SimpleValueNode)?.simpleValue,
        )
    )

    private fun walkPlusFeature(
        text: String,
        featureName: ParseNode,
        plusOnly: Boolean,
    ): ParseNode {
        val name = (featureName as NameNode).name
        return FeatureDeclarationNode(
            text,
            Feature(
                name,
                listOf(SimpleValue("+$name")) +
                        if (!plusOnly) listOf(SimpleValue("-$name")) else emptyList(),
                if (plusOnly) SimpleValue("-$name") else null,
            )
        )
    }

    private fun walkDiacriticDeclaration(
        text: String,
        diacritic: String,
        matrix: ParseNode,
        before: Boolean,
        floating: Boolean,
    ): ParseNode =
        DiacriticDeclarationNode(
            text,
            Diacritic(diacritic, (matrix as MatrixNode).matrix, before, floating),
        )

    private fun walkSymbolDeclaration(
        text: String,
        symbol: String,
        matrix: ParseNode?,
    ): ParseNode =
        SymbolDeclarationNode(
            text,
            Symbol(symbol, (matrix as? MatrixNode)?.matrix),
        )

    private fun walkDeromanizer(
        text: String,
        subrules: List<ParseNode>, literal: Boolean
    ): ParseNode =
        UnlinkedDeromanizer(
            text,
            subrules.convert(),
            literal
        )

    private fun walkRomanizer(
        text: String,
        subrules: List<ParseNode>,
        literal: Boolean
    ): ParseNode =
        UnlinkedRomanizer(
            text,
            subrules.convert(),
            literal
        )

    private fun walkIntermediateRomanizer(
        text: String,
        ruleName: String,
        subrules: List<ParseNode>,
        literal: Boolean
    ): ParseNode =
        UnlinkedIntermediateRomanizer(
            text,
            ruleName,
            subrules.convert(),
            literal
        )

    private fun walkChangeRule(
        text: String,
        ruleName: String,
        subrules: List<ParseNode>,
        ruleFilter: ParseNode?,
        propagate: Boolean
    ): ParseNode = UnlinkedPhoneticRule(
        text,
        ruleName,
        subrules.convert(),
        when (ruleFilter) {
            is MatrixNode -> MatrixElement(ruleFilter.text, ruleFilter.matrix)
            else -> ruleFilter as RuleElement?
        },
        propagate
    )

    private fun List<ParseNode>.convert(): List<List<UnlinkedRuleExpression>> =
        map { subrule ->
            (subrule as ParseNodeList).elements.filterIsInstance<UnlinkedRuleExpression>()
        }

    private fun walkSubrule(expressions: List<ParseNode>): ParseNode = ParseNodeList(expressions)

    private fun walkRuleExpression(
        text: String,
        ruleFrom: ParseNode,
        ruleTo: ParseNode,
        condition: ParseNode?,
        exclusion: ParseNode?
    ): ParseNode = UnlinkedRuleExpression(
        text,
        ruleFrom as RuleElement,
        ruleTo as RuleElement,
        when (condition) {
            is ParseNodeList -> condition.elements.map { it as UnlinkedEnvironment }
            is UnlinkedEnvironment -> listOf(condition)
            else -> emptyList()
        },
        when (exclusion) {
            is ParseNodeList -> exclusion.elements.map { it as UnlinkedEnvironment }
            is UnlinkedEnvironment -> listOf(exclusion)
            else -> emptyList()
        }
    )

    private fun walkDoNothingExpression(): ParseNode = DoNothingExpression

    private fun walkRuleEnvironment(
        text: String,
        before: ParseNode?,
        after: ParseNode?,
    ): ParseNode = UnlinkedEnvironment(
        text,
        (before as? RuleElement),
        (after as? RuleElement),
    )

    private fun walkRuleSequence(
        text: String,
        items: List<ParseNode>
    ): ParseNode =
        SequenceElement(
            text,
            items.map { it as RuleElement }
        )

    private fun walkRuleCapture(
        text: String,
        item: ParseNode,
        capture: ParseNode
    ): ParseNode = when (item) {
        is MatrixNode ->
            CaptureElement(
                text,
                MatrixElement(item.text, item.matrix),
                capture as CaptureReferenceElement
            )
        else ->
            CaptureElement(
                text,
                item as RuleElement,
                capture as CaptureReferenceElement
            )
    }

    private fun walkRuleRepeater(
        text: String,
        item: ParseNode,
        repeaterType: ParseNode
    ): ParseNode =
        RepeaterElement(
            text,
            item as RuleElement,
            repeaterType as RepeaterTypeNode
        )

    private fun walkRuleList(
        text: String,
        items: List<ParseNode>,
    ): ParseNode =
        AlternativeElement(
            text,
            items.map { it as RuleElement },
        )

    private fun walkIntersection(
        text: String,
        items: List<ParseNode>,
    ): ParseNode =
        IntersectionElement(
            text,
            items.map { it as RuleElement },
        )

    private fun walkSimpleElement(
        element: ParseNode,
    ): ParseNode = when (element) {
        is TextNode -> TextElement(element.text, element.literalText, element.exact)
        is MatrixNode -> MatrixElement(element.text, element.matrix)
        else -> element
    }

    private fun walkNegatedElement(
        text: String,
        element: ParseNode,
    ): ParseNode = NegatedElement(
        text,
        when (element) {
            is TextNode -> TextElement(element.text, element.literalText, element.exact)
            else -> element as RuleElement
        }
    )

    private fun walkNegatedValue(
        text: String,
        value: ParseNode,
    ): ParseNode =
        MatrixValueNode(
            text,
            NegatedValue((value as NameNode).name)
        )

    private fun walkAbsentFeature(
        text: String,
        feature: ParseNode,
    ): ParseNode =
        MatrixValueNode(
            text,
            SimpleValue.absent((feature as NameNode).name)
        )

    private fun walkFeatureVariable(
        text: String,
        feature: ParseNode,
    ): ParseNode =
        MatrixValueNode(
            text,
            FeatureVariable((feature as NameNode).name)
        )

    private fun walkEmpty(): ParseNode = EmptyElement

    private fun walkBoundary(): ParseNode = WordBoundaryElement

    private fun walkBetweenWords(): ParseNode = BetweenWordsElement

    private fun walkClassReference(
        text: String,
        value: ParseNode
    ): ParseNode =
        ClassReferenceElement(
            text,
            (value as NameNode).name
        )

    private fun walkCaptureReference(
        text: String,
        number: Int,
    ): ParseNode =
        CaptureReferenceElement(text, number)

    private fun walkRepeaterType(
        text: String,
        type: RepeaterType,
    ): ParseNode =
        RepeaterTypeNode(text, type)

    private fun walkMatrix(
        text: String,
        values: List<ParseNode>,
    ): ParseNode =
        MatrixNode(
            text,
            Matrix(values.map { (it as MatrixValueNode).value })
        )

    private fun walkPlusFeatureValue(
        text: String,
        name: ParseNode,
        plusMinus: PlusMinus,
    ): ParseNode =
        SimpleValueNode(text, SimpleValue(plusMinus.string + (name as NameNode).name))

    private fun walkFeatureValue(
        text: String,
        name: ParseNode,
    ): ParseNode = SimpleValueNode(text, SimpleValue((name as NameNode).name))

    private fun walkName(
        text: String,
        name: String,
    ): ParseNode = NameNode(text, name)

    private fun walkText(
        text: String,
        literalText: String,
        exact: Boolean,
    ): ParseNode = TextNode(text, literalText, exact)

    private data class ParseNodeList(
        val elements: List<ParseNode>
    ) : BaseParseNode(elements.joinToString())

    private fun unpackParseNodeList(node: ParseNode): List<ParseNode> = (node as ParseNodeList).elements

    interface ParseNode {
        /**
         * The original text that was parsed to produce this node
         */
        val text: String
    }

    abstract class BaseParseNode(override val text: String) : ParseNode {
        override fun toString(): String = text
    }

    interface SoundChangerNode {
        val soundChanger: SoundChanger
    }

    private class SoundChangerNodeImpl(
        text: String,
        private val featureDeclarations: List<ParseNode>,
        private val diacriticDeclarations: List<ParseNode>,
        private val symbolDeclarations: List<ParseNode>,
        private val classDeclarations: List<ParseNode>,
        private val deromanizer: ParseNode?,
        private val changeRules: List<ParseNode>,
        private val romanizer: ParseNode?,
        private val intermediateRomanizers: List<RomanizerToFollowingRule<ParseNode>>,
    ) : BaseParseNode(text), SoundChangerNode {
        private val declarations = Declarations(
            featureDeclarations.flatMap { sublist ->
                (sublist as ParseNodeList).elements.map { (it as FeatureDeclarationNode).feature }
            },
            diacriticDeclarations.map { (it as DiacriticDeclarationNode).diacritic },
            symbolDeclarations.flatMap { sublist ->
                (sublist as ParseNodeList).elements.map { (it as SymbolDeclarationNode).symbol }
            },
            resolveClasses(classDeclarations)
        )
        private val linkedRules = changeRules.map { (it as UnlinkedPhoneticRule).link(declarations) }
        private val linkedDeromanizer =
            (deromanizer as UnlinkedDeromanizer?)?.link(declarations) ?: Deromanizer.empty(declarations)
        private val linkedRomanizer =
            (romanizer as UnlinkedRomanizer?)?.link(declarations) ?: Romanizer.empty()
        private val linkedIntermediateRomanizers = intermediateRomanizers.groupBy {
            (it.rule as UnlinkedPhoneticRule?)?.name
        }.mapValues { (_, value) ->
            value.map { (it.romanizer as UnlinkedIntermediateRomanizer).link(declarations) }
        }

        override val soundChanger = SoundChanger(
            declarations,
            linkedRules,
            linkedDeromanizer,
            linkedRomanizer,
            linkedIntermediateRomanizers
        )
    }

    private class FeatureDeclarationNode(
        text: String,
        val feature: Feature,
    ) : BaseParseNode(text)

    private class DiacriticDeclarationNode(
        text: String,
        val diacritic: Diacritic,
    ) : BaseParseNode(text)

    private class SymbolDeclarationNode(
        text: String,
        val symbol: Symbol,
    ) : BaseParseNode(text)

    private class ClassDeclarationNode(
        text: String,
        val name: String,
        val elements: List<ParseNode>,
    ) : BaseParseNode(text)

    private interface UnlinkedRule : ParseNode {
        val numExpressions: Int

        fun <I : Segment<I>, O : Segment<O>> link(
            firstExpressionNumber: Int, declarations: Declarations,
            inType: SegmentType<I>, outType: SegmentType<O>,
        ): ChangeRule<I, O>
    }

    private abstract class BaseUnlinkedRule(
        text: String, val subrules: List<UnlinkedRule>
    ) : BaseParseNode(text), UnlinkedRule {

        val cumulativeNumExpressions: List<Int> =
            subrules.scan(0) { acc, cur -> acc + cur.numExpressions }
        override val numExpressions: Int = cumulativeNumExpressions.last()

        fun <I : Segment<I>, O : Segment<O>> linkedSubrules(
            ruleName: String,
            firstExpressionNumber: Int, declarations: Declarations,
            inType: SegmentType<I>, outType: SegmentType<O>,
        ): List<ChangeRule<I, O>> {
            return subrules.mapIndexed { index, subrule ->
                val expressionNumber = cumulativeNumExpressions[index]
                val subFirstExpressionNumber = firstExpressionNumber + expressionNumber
                subrule.link(
                    subFirstExpressionNumber,
                    declarations,
                    inType, outType,
                )
            }
        }
    }

    private class UnlinkedSimpleChangeRule(
        override val text: String,
        expressions: List<UnlinkedRuleExpression>,
    ) : UnlinkedRule {
        override val numExpressions: Int = expressions.size

        override fun <I : Segment<I>, O : Segment<O>> link(
            firstExpressionNumber: Int,
            declarations: Declarations,
            inType: SegmentType<I>,
            outType: SegmentType<O>
        ): ChangeRule<I, O> {
            try {

            } catch (e: UserError) {
                throw LscInvalidRuleExpression(e, ruleName, subrule.text, expressionNumber)
            }
        }
    }

    private class UnlinkedDeromanizer(
        text: String,
        val expressions: List<List<UnlinkedRuleExpression>>,
        val literal: Boolean,
        val name: String = "Deromanizer",
    ) : BaseUnlinkedRule(text) {
        fun link(declarations: Declarations): Deromanizer =
            if (literal) {
                Deromanizer(
                    expressions.first().linkAll(name, 1) {
                        it.outPhonetic(declarations)
                    },
                    expressions.drop(1).linkAll(name, 2) {
                        it.phonetic(declarations, false)
                    },
                    declarations,
                )
            } else {
                Deromanizer(
                    emptyList(),
                    expressions.linkAll(name, 1) {
                        it.phonetic(declarations, false)
                    },
                    declarations,
                )
            }
    }

    private class UnlinkedRomanizer(
        text: String,
        val expressions: List<List<UnlinkedRuleExpression>>,
        val literal: Boolean,
        val name: String = "Romanizer",
    ) : BaseUnlinkedRule(text) {
        fun link(declarations: Declarations): Romanizer =
            if (literal) {
                Romanizer(
                    expressions.dropLast(1).linkAll(name, 1) {
                        it.phonetic(declarations, false)
                    },
                    expressions.last().linkAll(name, expressions.size) {
                        it.inPhonetic(declarations)
                    },
                )
            } else {
                Romanizer(
                    expressions.linkAll(name, 1) {
                        it.phonetic(declarations, false)
                    },
                    emptyList(),
                )
            }
    }

    private class UnlinkedIntermediateRomanizer(
        text: String,
        val name: String,
        val expressions: List<List<UnlinkedRuleExpression>>,
        val literal: Boolean,
    ) : BaseParseNode(text) {
        private val internalRomanizer = UnlinkedRomanizer(text, expressions, literal, name)

        fun link(declarations: Declarations): SoundChanger.IntermediateRomanizer =
            SoundChanger.IntermediateRomanizer(
                name, internalRomanizer.link(declarations)
            )
    }

    private class UnlinkedPhoneticRule(
        text: String,
        val name: String,
        val expressions: List<List<UnlinkedRuleExpression>>,
        val ruleFilter: RuleElement?,
        val propagate: Boolean,
    ) : BaseUnlinkedRule(text) {
        fun link(declarations: Declarations): PhoneticChangeRule =
            PhoneticChangeRule(
                name,
                expressions.linkAll(name, 1) {
                    it.phonetic(declarations, ruleFilter != null)
                },
                ruleFilter?.let { filter ->
                    { segment: PhoneticSegment ->
                        filter.phonetic(RuleContext.aloneInMain(), declarations).claim(
                            declarations, Phonetic.single(segment), 0, Bindings()
                        ) == 1
                    }
                },
                propagate
            )
    }

    private class UnlinkedAllMatchingBlock(
        text: String,
        val subrules: List<UnlinkedRule>,
    ) : BaseUnlinkedRule(text) {
        override fun link(declarations: Declarations, firstExpressionNumber: Int): AllMatchingBlock =
            AllMatchingBlock(
                subrules.mapIndexed { index, subrule ->
                    subrule.link(declarations, firstExpressionNumber + index)
                }
            )
    }

    private class UnlinkedRuleExpression(
        text: String,
        val match: RuleElement,
        val result: RuleElement,
        val condition: List<UnlinkedEnvironment>,
        val exclusion: List<UnlinkedEnvironment>,
    ) : BaseParseNode(text) {
        fun inPhonetic(declarations: Declarations): RuleExpression<PhonS, PlainS> = RuleExpression(
            Phonetic, Plain, declarations,
            match.phonetic(RuleContext.aloneInMain(), declarations),
            castToResultElement(result).inPhoneticEmitter(declarations),
            condition.map { it.phonetic(declarations) },
            exclusion.map { it.phonetic(declarations) }
        )

        fun outPhonetic(declarations: Declarations): RuleExpression<PlainS, PhonS> = RuleExpression(
            Plain, Phonetic, declarations,
            match.plain(RuleContext.aloneInMain()),
            castToResultElement(result).outPhoneticEmitter(declarations),
            condition.map { it.plain() },
            exclusion.map { it.plain() }
        )

        fun phonetic(declarations: Declarations, filtered: Boolean): RuleExpression<PhonS, PhonS> = RuleExpression(
            Phonetic, Phonetic, declarations,
            match.phonetic(RuleContext.aloneInMain(), declarations),
            castToResultElement(result).phoneticEmitter(declarations),
            condition.map { it.phonetic(declarations) },
            exclusion.map { it.phonetic(declarations) },
            filtered
        )
    }

    private object DoNothingExpression : BaseParseNode("unchanged")

    private class UnlinkedEnvironment(
        text: String,
        val before: RuleElement?,
        val after: RuleElement?,
    ) : BaseParseNode(text) {
        fun plain(): Environment<PlainS> = try {
            Environment(
                before?.plain(RuleContext.rightBeforeAnchor()) ?: EmptyMatcher(),
                after?.plain(RuleContext.rightAfterAnchor()) ?: EmptyMatcher()
            )
        } catch (e: LscBadSequence) {
            throw e.initEnvironment(text)
        }

        fun phonetic(declarations: Declarations): Environment<PhonS> = try {
            Environment(
                before?.phonetic(RuleContext.rightBeforeAnchor(), declarations) ?: EmptyMatcher(),
                after?.phonetic(RuleContext.rightAfterAnchor(), declarations) ?: EmptyMatcher()
            )
        } catch (e: LscBadSequence) {
            throw e.initEnvironment(text)
        }
    }

    internal interface RuleElement : ParseNode {
        val publicName: String

        fun plain(context: RuleContext): Matcher<PlainS>

        fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS>
    }

    internal data class RuleContext(
        val section: RuleSection,
        val precedingElement: ContextElement,
        val followingElement: ContextElement,
    ) {
        companion object {
            fun aloneInMain(): RuleContext =
                RuleContext(RuleSection.MAIN, ContextElement.None, ContextElement.None)

            fun rightBeforeAnchor(): RuleContext =
                RuleContext(RuleSection.ENVIRON, ContextElement.None, ContextElement.Anchor)

            fun rightAfterAnchor(): RuleContext =
                RuleContext(RuleSection.ENVIRON, ContextElement.Anchor, ContextElement.None)

            fun nowhere(): RuleContext =
                RuleContext(RuleSection.NOWHERE, ContextElement.None, ContextElement.None)
        }
    }

    internal enum class RuleSection {
        MAIN,
        ENVIRON,
        NOWHERE,
    }

    internal sealed class ContextElement {
        internal object None : ContextElement()

        internal object Anchor : ContextElement()

        internal data class Some(val element: RuleElement) : ContextElement()
    }

    // Base class for elements that don't need to use different logic depending on the word type
    private interface ChameleonRuleElement : RuleElement {
        override fun plain(context: RuleContext): Matcher<PlainS> = link(context)

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> = link(context)

        fun <T : Segment<T>> link(context: RuleContext): Matcher<T>
    }

    private abstract class PhoneticOnlyRuleElement(text: String) :
        BaseParseNode(text),
        RuleElement {
        override fun plain(context: RuleContext): Matcher<PlainS> = foundInPlain()

        // Throw the desired exception
        abstract fun foundInPlain(): Nothing
    }

    private interface ResultElement : RuleElement {
        fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS>

        fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS>

        fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS>
    }

    private fun castToResultElement(element: RuleElement): ResultElement =
        element as? ResultElement ?: throw LscIllegalStructureInOutput(element.publicName, element.text)

    // Base class for elements whose only word type dependency is forwarding to sub-elements
    private abstract class ContainerResultElement(text: String) : BaseParseNode(text), ResultElement {
        override fun plain(context: RuleContext): Matcher<PlainS> =
            matcher(elements.map { it.plain(context) })

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> =
            matcher(elements.map { it.phonetic(context, declarations) })

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> =
            emitter(resultElements.map { it.inPhoneticEmitter(declarations) })

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            emitter(resultElements.map { it.outPhoneticEmitter(declarations) })

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            emitter(resultElements.map { it.phoneticEmitter(declarations) })

        abstract val elements: List<RuleElement>

        val resultElements: List<ResultElement> by lazy { elements.map(::castToResultElement) }

        abstract fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T>

        abstract fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O>
    }

    // Base class for elements that are invalid in plain context, and throw an exception indicating this
    private abstract class PhoneticOnlyResultElement(text: String) :
        PhoneticOnlyRuleElement(text),
        ResultElement {
        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> =
            foundInPlain()

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            foundInPlain()
    }

    private object WordBoundaryElement : BaseParseNode("$"), ChameleonRuleElement {
        override val publicName: String = "a word boundary"

        override fun <T : Segment<T>> link(context: RuleContext): Matcher<T> =
            when {
                context.section == RuleSection.MAIN -> throw LscIllegalStructureInInput(publicName, text)
                context.precedingElement is ContextElement.None -> WordStartMatcher()
                context.followingElement is ContextElement.None -> WordEndMatcher()
                else -> throw LscInteriorWordBoundary()
            }
    }

    private object BetweenWordsElement : BaseParseNode("$$"), ResultElement, ChameleonRuleElement {
        override val publicName: String = "a space between words"

        override fun <T : Segment<T>> link(context: RuleContext): Matcher<T> =
            BetweenWordsMatcher()

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> =
            BetweenWordsEmitter(Plain)

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            BetweenWordsEmitter(Phonetic)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            BetweenWordsEmitter(Phonetic)
    }

    private class SequenceElement(
        text: String,
        override val elements: List<RuleElement>,
    ) : ContainerResultElement(text) {
        override val publicName: String = "a sequence"

        override fun plain(context: RuleContext): Matcher<PlainS> =
            link(context) { plain(it) }

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> =
            link(context) { phonetic(it, declarations) }

        private fun <T : Segment<T>> link(
            context: RuleContext,
            linker: RuleElement.(RuleContext) -> Matcher<T>,
        ): Matcher<T> =
            try {
                SequenceMatcher(
                    (listOf<RuleElement?>(null) + elements + listOf(null)).windowed(3) { window ->
                        val (preceding, current, following) = window
                        current!!.linker(
                            context.copy(
                                precedingElement = preceding?.let { ContextElement.Some(it) } ?: context.precedingElement,
                                followingElement = following?.let { ContextElement.Some(it) } ?: context.followingElement,
                            )
                        )
                    }
                )
            } catch (e: LscBadSequence) {
                throw e.initSequence(text)
            }

        override fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T> = SequenceMatcher(elements)

        override fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O> =
            SequenceEmitter(elements)
    }

    private class CaptureElement(
        text: String,
        val element: RuleElement,
        val capture: CaptureReferenceElement,
    ) : PhoneticOnlyRuleElement(text) {
        override val publicName: String = "a capture"

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> =
            CaptureMatcher(element.phonetic(context, declarations), capture.number)

        override fun foundInPlain(): Nothing = throw LscCaptureInPlain(capture.number)
    }

    private class RepeaterElement(
        text: String,
        val element: RuleElement,
        val repeaterType: RepeaterTypeNode,
    ) : BaseParseNode(text), RuleElement {
        override val publicName: String = when (repeaterType.type) {
            RepeaterType.ZERO_OR_ONE -> "an optional"
            else -> "a repeater"
        }

        override fun plain(context: RuleContext): Matcher<PlainS> {
            checkContext(context)
            return RepeaterMatcher(
                element.plain(context),
                repeaterType.type,
                removeAnchor(context.precedingElement)?.plain(RuleContext.nowhere()),
                removeAnchor(context.followingElement)?.plain(RuleContext.nowhere()),
            )
        }

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> {
            checkContext(context)
            return RepeaterMatcher(
                element.phonetic(context, declarations),
                repeaterType.type,
                removeAnchor(context.precedingElement)?.phonetic(RuleContext.nowhere(), declarations),
                removeAnchor(context.followingElement)?.phonetic(RuleContext.nowhere(), declarations),
            )
        }

        private fun checkContext(context: RuleContext) {
            if (context.section == RuleSection.ENVIRON &&
                (context.precedingElement is ContextElement.None ||
                        context.followingElement is ContextElement.None)
            ) {
                throw LscPeripheralRepeater(text)
            }
        }

        private fun removeAnchor(element: ContextElement): RuleElement? =
            when (element) {
                is ContextElement.Some -> element.element
                else -> null
            }
    }

    private class AlternativeElement(
        text: String,
        override val elements: List<RuleElement>,
    ) : ContainerResultElement(text) {
        override val publicName: String = "an alternative list"

        override fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T> = AlternativeMatcher(elements)

        override fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O> =
            AlternativeEmitter(elements)
    }

    private class IntersectionElement(
        text: String,
        override val elements: List<RuleElement>,
    ) : ContainerResultElement(text) {
        override val publicName: String = "an intersection"

        override fun <T : Segment<T>> matcher(elements: List<Matcher<T>>): Matcher<T> = IntersectionMatcher(elements)

        override fun <I : Segment<I>, O : Segment<O>> emitter(elements: List<Emitter<I, O>>): Emitter<I, O> =
            throw LscIntersectionInOutput(elements)
    }

    private class TextElement(
        text: String,
        val literalText: String,
        val exact: Boolean = false,
    ) : BaseParseNode(text), ResultElement {
        override val publicName: String = "literal text"

        override fun plain(context: RuleContext): Matcher<PlainS> = TextMatcher(PlainWord(literalText))

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> =
            declarations.parsePhonetic(literalText).let {
                if (exact) TextMatcher(it) else SymbolMatcher(it)
            }

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> =
            TextEmitter(PlainWord(literalText))

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> =
            declarations.parsePhonetic(literalText).let {
                if (exact) TextEmitter(it) else SymbolEmitter(it)
            }

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            declarations.parsePhonetic(literalText).let {
                if (exact) TextEmitter(it) else SymbolEmitter(it)
            }
    }

    private class MatrixElement(
        text: String,
        val matrix: Matrix,
    ) : PhoneticOnlyResultElement(text) {
        override val publicName: String = "a matrix"

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> =
            MatrixMatcher(matrix)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = MatrixEmitter(matrix)

        override fun foundInPlain(): Nothing = throw LscMatrixInPlain(matrix)
    }

    private class NegatedElement(
        text: String,
        val element: RuleElement,
    ) : BaseParseNode(text), RuleElement {
        override val publicName: String = "a negated element"

        override fun plain(context: RuleContext): Matcher<PlainS> = NegatedMatcher(element.plain(context))

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> =
            NegatedMatcher(element.phonetic(context, declarations))
    }

    private object EmptyElement : BaseParseNode("*"), ResultElement {
        override val publicName: String = "an empty element"

        override fun plain(context: RuleContext): Matcher<PlainS> = EmptyMatcher()

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> = EmptyMatcher()

        override fun inPhoneticEmitter(declarations: Declarations): Emitter<PhonS, PlainS> = EmptyEmitter(Plain)

        override fun outPhoneticEmitter(declarations: Declarations): Emitter<PlainS, PhonS> = EmptyEmitter(Phonetic)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> = EmptyEmitter(Phonetic)
    }

    private class ClassReferenceElement(
        text: String,
        val name: String,
    ) : PhoneticOnlyResultElement(text) {
        override val publicName: String = "a class reference"

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> =
            with(declarations) {
                AlternativeMatcher(name.toClass().sounds.map {
                    TextElement(it, it).phonetic(context, this)
                })
            }

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            with(declarations) {
                AlternativeEmitter(name.toClass().sounds.map {
                    TextElement(it, it).phoneticEmitter(this)
                })
            }

        override fun foundInPlain(): Nothing = throw LscClassInPlain(name)
    }

    private class CaptureReferenceElement(
        text: String,
        val number: Int,
    ) : PhoneticOnlyResultElement(text) {
        override val publicName: String = "a capture reference"

        override fun phonetic(context: RuleContext, declarations: Declarations): Matcher<PhonS> =
            CaptureReferenceMatcher(number)

        override fun phoneticEmitter(declarations: Declarations): Emitter<PhonS, PhonS> =
            CaptureReferenceEmitter(number)

        override fun foundInPlain(): Nothing = throw LscCaptureInPlain(number)
    }

    private class RepeaterTypeNode(
        text: String,
        val type: RepeaterType,
    ) : BaseParseNode(text)

    private class MatrixNode(
        text: String,
        val matrix: Matrix,
    ) : BaseParseNode(text)

    private open class MatrixValueNode(
        text: String,
        val value: MatrixValue,
    ) : BaseParseNode(text)

    private class SimpleValueNode(
        text: String,
        val simpleValue: SimpleValue,
    ) : MatrixValueNode(text, simpleValue)

    private class NameNode(
        text: String,
        val name: String,
    ) : BaseParseNode(text)

    private class TextNode(
        text: String,
        val literalText: String,
        val exact: Boolean
    ) : BaseParseNode(text)

    private fun listVisit(node: List<ParseTree>): List<ParseNode> = node.map { visit(it) }

    private fun optionalVisit(node: ParseTree?): ParseNode? = node?.let { visit(it) }
}

private class LscErrorListener : CommonAntlrErrorListener() {
    override fun handleSyntaxError(
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        exception: RecognitionException?,
    ): Nothing {
        val offendingToken = (offendingSymbol as? CommonToken)?.getTokenText() ?: offendingSymbol.toString()
        throw LscNotParsable(
            line,
            charPositionInLine,
            offendingToken,
            msg
        )
    }
}

class LscInvalidRuleExpression(
    val reason: UserError,
    val rule: String,
    val expression: String,
    val expressionNumber: Int,
) : LscUserError(
    "Error in expression $expressionNumber (\"$expression\") of rule \"$rule\"\n${reason.message}",
    reason
)

class LscIllegalStructureInInput(
    val invalidNodeType: String,
    val invalidNode: String,
) : LscUserError(
    "${invalidNodeType.capitalize()} like \"$invalidNode\" can't be used in the input of a rule"
)

class LscIllegalStructureInOutput(
    val invalidNodeType: String,
    val invalidNode: String,
) : LscUserError(
    "${invalidNodeType.capitalize()} like \"$invalidNode\" can't be used in the output of a rule"
)

class LscNotParsable(val line: Int, val column: Int, val offendingSymbol: String, val customMessage: String) :
    LscUserError("$customMessage (line $line)")
