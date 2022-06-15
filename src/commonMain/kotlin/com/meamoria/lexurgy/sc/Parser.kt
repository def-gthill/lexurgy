package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import com.meamoria.mpp.antlr.*
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
    ): String =
        if (offendingSymbol == "<EOF>") {
            "The rules are incomplete; more is expected after \"$offendingLine\""
        } else {
            "\"$offendingSymbol\" doesn't make sense in the line \"$offendingLine\""
        }
}

object LscWalker : LscBaseVisitor<LscWalker.ParseNode>() {
    override fun visitLscFile(ctx: LscFileContext): ParseNode {
        val statementContexts = ctx.allStatements().map { it.getChild(0) as ParserRuleContext }
        validateOrder(statementContexts)
        val rulesWithAnchoredStatements = visitRulesWithAnchoredStatements(statementContexts)
        return walkFile(
            ctx.getText(),
            featureDeclarations = listVisit(statementContexts.filterIsInstance<FeatureDeclContext>()),
            diacriticDeclarations = listVisit(statementContexts.filterIsInstance<DiacriticDeclContext>()),
            symbolDeclarations = listVisit(statementContexts.filterIsInstance<SymbolDeclContext>()),
            classDeclarations = listVisit(statementContexts.filterIsInstance<ClassDeclContext>()),
            deromanizer = optionalVisit(statementContexts.filterIsInstance<DeromanizerContext>().singleOrNull()),
            changeRules = rulesWithAnchoredStatements,
            romanizer = optionalVisit(statementContexts.filterIsInstance<RomanizerContext>().singleOrNull()),
        )
    }

    private fun visitRulesWithAnchoredStatements(
        contexts: List<ParserRuleContext>
    ): List<RuleWithAnchoredStatements> {
        val rulesWithAnchoredStatements = mutableListOf<RuleWithAnchoredStatements>()
        var curAnchoredStatements = mutableListOf<ParseNode>()
        for (context in contexts) {
            when (context) {
                is ChangeRuleContext -> {
                    if (context.isCleanupOffRule()) {
                        curAnchoredStatements += UnlinkedCleanupOffStep(
                            context.getText(),
                            context.ruleName().getText(),
                        )
                    } else {
                        val rule = visit(context) as UnlinkedStandardRule
                        if (rule.cleanup) {
                            curAnchoredStatements += rule
                        } else {
                            rulesWithAnchoredStatements += RuleWithAnchoredStatements(
                                rule, curAnchoredStatements
                            )
                            curAnchoredStatements = mutableListOf()
                        }
                    }
                }
                is InterRomanizerContext -> curAnchoredStatements += visit(context)
                is SyllableDeclContext -> curAnchoredStatements += visit(context)
                else -> {}
            }
        }
        rulesWithAnchoredStatements += RuleWithAnchoredStatements(
            null, curAnchoredStatements
        )
        return rulesWithAnchoredStatements
    }

    private fun ChangeRuleContext.isCleanupOffRule(): Boolean =
        block().getText().trim().lowercase() == "off"

    private class UnlinkedCleanupOffStep(
        text: String,
        val ruleName: String,
    ) : BaseParseNode(text)

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
        SyllableDeclContext::class to 50,
        ChangeRuleContext::class to 50,
        InterRomanizerContext::class to 50,
        RomanizerContext::class to 60,
    )

    private val statementNames: Map<KClass<*>, String> = mapOf(
        FeatureDeclContext::class to "feature declarations",
        DiacriticDeclContext::class to "diacritic declarations",
        SymbolDeclContext::class to "symbol declarations",
        ClassDeclContext::class to "class declarations",
        SyllableDeclContext::class to "syllable declarations",
        DeromanizerContext::class to "deromanizer",
        ChangeRuleContext::class to "change rules",
        InterRomanizerContext::class to "intermediate romanizers",
        RomanizerContext::class to "final romanizer",
    )

    /**
     * A change rule, plus all the non-rule statements
     * (e.g. intermediate romanizers) between it and the previous
     * rule, in declaration order. If ``rule`` is null, the non-rule statements
     * are after all the rules.
     */
    private data class RuleWithAnchoredStatements(
        val rule: ParseNode?,
        val statements: List<ParseNode>,
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
                        optionalVisit(ctx.featureModifier())
                    )
                )
            )
        }

    override fun visitFeatureModifier(ctx: FeatureModifierContext): ParseNode =
        FeatureLevelNode(ctx.getText(), WordLevel.SYLLABLE)

    override fun visitPlusFeature(ctx: PlusFeatureContext): ParseNode = walkPlusFeature(
        ctx.getText(),
        visit(ctx.name()),
        ctx.AT_LEAST_ONE() != null,
        optionalVisit(ctx.featureModifier()),
    )

    override fun visitNullAlias(ctx: NullAliasContext): ParseNode = visit(ctx.featureValue())

    override fun visitDiacriticDecl(ctx: DiacriticDeclContext): ParseNode {
        val modifiers = ctx.allDiacriticModifiers()
        val position = when {
            modifiers.any { it.DIA_BEFORE() != null } -> ModifierPosition.BEFORE
            modifiers.any { it.DIA_FIRST() != null } -> ModifierPosition.FIRST
            else -> ModifierPosition.AFTER
        }
        val floating = modifiers.any { it.DIA_FLOATING() != null }
        return walkDiacriticDeclaration(
            ctx.getText(),
            removeEscapes(ctx.text().getText()),
            visit(ctx.matrix()),
            position,
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

    override fun visitSyllableDecl(ctx: SyllableDeclContext): ParseNode =
        walkSyllableDecl(
            ctx.getText(),
            if (ctx.CLEAR_SYLLABLES() != null) null
            else listVisit(ctx.allSyllablePatterns()),
        )

    override fun visitSyllablePattern(ctx: SyllablePatternContext): ParseNode =
        walkSyllablePattern(
            ctx.getText(),
            visit(ctx.unconditionalRuleElement()),
            optionalVisit(ctx.compoundEnvironment()),
            optionalVisit(ctx.matrix()),
        )

    override fun visitDeromanizer(ctx: DeromanizerContext): ParseNode =
        walkDeromanizer(
            ctx.getText(),
            unpackBlock(visit(ctx.block())),
            ctx.LITERAL() != null
        )

    override fun visitRomanizer(ctx: RomanizerContext): ParseNode =
        walkRomanizer(
            ctx.getText(),
            unpackBlock(visit(ctx.block())),
            ctx.LITERAL() != null
        )

    override fun visitInterRomanizer(ctx: InterRomanizerContext): ParseNode =
        walkIntermediateRomanizer(
            ctx.getText(),
            ctx.ruleName().getText(),
            unpackBlock(visit(ctx.block())),
            ctx.LITERAL() != null
        )

    private fun unpackBlock(block: ParseNode): List<ParseNode> =
        when (block) {
            is UnlinkedSequentialBlock -> block.subrules
            else -> listOf(block)
        }

    override fun visitChangeRule(ctx: ChangeRuleContext): ParseNode {
        val ruleName = ctx.ruleName().getText()
        val modifierContexts = ctx.allChangeRuleModifiers()
        if (ctx.RULE_START() == null) {
            noColon(ruleName, modifierContexts, ctx.firstNewline())
        }
        val modifiers = modifierContexts.getModifiers(ruleName)
        return walkChangeRule(
            ctx.getText(),
            ruleName,
            visit(ctx.block()),
            modifiers,
        )
    }

    private fun List<ChangeRuleModifierContext>.getModifiers(ruleName: String): RuleModifiers {
        val filter = getFilter(ruleName)
        val keywordModifiers = mapNotNull { it.keywordModifier() }
        keywordModifiers.validateModifiers(ruleName)
        val matchMode = keywordModifiers.getMatchMode(ruleName)
        val isPropagate = keywordModifiers.any { it.getText() == "propagate" }
        val isCleanup = keywordModifiers.any { it.getText() == "cleanup" }
        return RuleModifiers(
            ruleFilter = filter,
            matchMode = matchMode,
            isPropagate = isPropagate,
            isCleanup = isCleanup,
        )
    }

    private fun List<ChangeRuleModifierContext>.getFilter(ruleName: String): ParseNode? =
        optionalVisit(
            mapNotNull { it.filter() }.let { filters ->
                if (filters.isEmpty()) null
                else filters.singleOrNull() ?: multipleModifiers(
                    ruleName, "filter", filters,
                )
            }
        )

    private fun List<KeywordModifierContext>.validateModifiers(ruleName: String) {
        val allowedModifiers = setOf("ltr", "rtl", "propagate", "cleanup")
        val firstInvalidModifier = find { it.str !in allowedModifiers }
        if (firstInvalidModifier != null) {
            throw LscInvalidModifier(ruleName, firstInvalidModifier.getText())
        }
    }

    private fun List<KeywordModifierContext>.getMatchMode(ruleName: String): MatchMode {
        val matchModes = filter { it.str == "ltr" || it.str == "rtl" }
        return if (matchModes.isEmpty()) MatchMode.SIMULTANEOUS
        else matchModes.singleOrNull()?.let {
            if (it.str == "ltr") MatchMode.LEFT_TO_RIGHT else MatchMode.RIGHT_TO_LEFT
        } ?: multipleModifiers(
            ruleName, "match mode", matchModes,
        )
    }

    private val KeywordModifierContext.str
        get() = getText().lowercase()

    private data class RuleModifiers(
        val ruleFilter: ParseNode?,
        val matchMode: MatchMode,
        val isPropagate: Boolean,
        val isCleanup: Boolean,
    )

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

    private fun multipleModifiers(
        ruleName: String,
        modifierTypeName: String,
        contexts: List<ParserRuleContext>
    ): Nothing =
        throw LscNotParsable(
            contexts[1].getStartLine(),
            contexts[1].getStartColumn(),
            contexts[1].getText(),
            "The rule \"$ruleName\" has more than one $modifierTypeName: " +
                    "${contexts[0].getText()} and ${contexts[1].getText()}"
        )

    override fun visitFilter(ctx: FilterContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitBlock(ctx: BlockContext): ParseNode {
        val blockTypes = ctx.allBlockTypes()
        if (blockTypes.isEmpty()) return visit(ctx.allBlockElements().single())
        val blockType = checkUniformBlockType(blockTypes)
        val allModifierContexts = listOf(emptyList<ChangeRuleModifierContext>()) +
                blockTypes.map { it.allChangeRuleModifiers() }
        val blockElements = listVisit(ctx.allBlockElements()).zip(
            allModifierContexts
        ) { element, modifierContexts ->
            element as UnlinkedRule
            val modifiers = modifierContexts.getModifiers("<$blockType>")
            val block = if (modifiers.isPropagate) {
                UnlinkedPropagateBlock(element)
            } else element
            block.tryWithMatchMode(modifiers.matchMode)
        }
        return walkBlock(ctx.getText(), blockType, blockElements)
    }

    private fun checkUniformBlockType(blockCtxs: List<BlockTypeContext>): BlockType =
        checkUniformType(blockCtxs.map { getBlockType(it) }) { firstType, laterType, _ ->
            throw LscMixedBlock(firstType, laterType)
        }

    private fun getBlockType(ctx: BlockTypeContext) =
        when {
            ctx.ALL_MATCHING() != null -> BlockType.SEQUENTIAL
            ctx.FIRST_MATCHING() != null -> BlockType.FIRST_MATCHING
            else -> throw AssertionError("Block has no block type")
        }

    override fun visitBlockElement(ctx: BlockElementContext): ParseNode =
        if (ctx.block() != null) visit(ctx.block()!!) else visit(ctx.expressionList()!!)

    override fun visitExpressionList(ctx: ExpressionListContext): ParseNode =
        walkExpressionList(ctx.getText(), listVisit(ctx.allExpressions()))

    override fun visitExpression(ctx: ExpressionContext): ParseNode =
        if (ctx.keywordExpression() == null) {
            walkRuleExpression(
                ctx.getText(),
                visit(ctx.from()!!),
                visit(ctx.to()!!),
                optionalVisit(ctx.compoundEnvironment()),
            )
        } else {
            walkDoNothingExpression()
        }

    override fun visitFrom(ctx: FromContext): ParseNode =
        visit(ctx.ruleElement())

    override fun visitTo(ctx: ToContext): ParseNode =
        visit(ctx.unconditionalRuleElement())

    override fun visitRuleElement(ctx: RuleElementContext): ParseNode =
        ctx.compoundEnvironment()?.let { env ->
            walkLookaround(
                ctx.getText(),
                visit(ctx.unconditionalRuleElement()),
                visit(env)
            )
        } ?: visit(ctx.unconditionalRuleElement())

    override fun visitUnconditionalRuleElement(ctx: UnconditionalRuleElementContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitBounded(ctx: BoundedContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitGroup(ctx: GroupContext): ParseNode =
        visit(ctx.ruleElement())

    override fun visitList(ctx: ListContext): ParseNode =
        walkRuleList(
            ctx.getText(),
            listVisit(ctx.allRuleElements()),
        )

    override fun visitSequence(ctx: SequenceContext): ParseNode =
        walkRuleSequence(ctx.getText(), listVisit(ctx.allFreeElements()))

    override fun visitFreeElement(ctx: FreeElementContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitCompoundEnvironment(ctx: CompoundEnvironmentContext): ParseNode =
        walkCompoundEnvironment(
            ctx.getText(),
            optionalVisit(ctx.condition()),
            optionalVisit(ctx.exclusion()),
        )

    override fun visitCondition(ctx: ConditionContext): ParseNode =
        visit(ctx.getChild(1))

    override fun visitExclusion(ctx: ExclusionContext): ParseNode =
        visit(ctx.getChild(1))

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

    override fun visitEnvironmentBefore(ctx: EnvironmentBeforeContext): ParseNode =
        visit(ctx.unconditionalRuleElement())

    override fun visitEnvironmentAfter(ctx: EnvironmentAfterContext): ParseNode =
        visit(ctx.unconditionalRuleElement())

    override fun visitInterfix(ctx: InterfixContext): ParseNode {
        val (interfixType, negations) = checkUniformInterfixType(ctx.allInterfixTypes())
        return walkInterfix(
            ctx.getText(),
            interfixType,
            listVisit(ctx.allInterfixElements()),
            negations,
        )
    }

    private fun checkUniformInterfixType(
        interfixCtxs: List<InterfixTypeContext>
    ): Pair<InterfixType, List<Boolean>> {
        val interfixTypes = interfixCtxs.map { getInterfixType(it) }
        val looseInterfixTypes = interfixTypes.map {
            if (it == InterfixType.INTERSECTION_NOT) InterfixType.INTERSECTION
            else it
        }
        val uniformType = checkUniformType(looseInterfixTypes) { firstType, laterType, laterIndex ->
            val offendingOperator = interfixCtxs[laterIndex]
            throw LscNotParsable(
                offendingOperator.getStartLine(),
                offendingOperator.getStartColumn(),
                laterType.text,
                "Can't mix ${firstType.text} and ${laterType.text}; use parentheses"
            )
        }
        val negations = interfixTypes.map {
            it == InterfixType.INTERSECTION_NOT
        }
        return uniformType to negations
    }

    private fun getInterfixType(ctx: InterfixTypeContext) =
        when {
            ctx.INTERSECTION() != null -> InterfixType.INTERSECTION
            ctx.INTERSECTION_NOT() != null -> InterfixType.INTERSECTION_NOT
            ctx.TRANSFORMING() != null -> InterfixType.TRANSFORMING
            else -> throw AssertionError("Interfix expression has no type")
        }

    private fun <Type> checkUniformType(
        types: List<Type>,
        throwFunction: (Type, Type, Int) -> Nothing
    ): Type {
        val firstType = types.first()
        for ((index, laterType) in types.withIndex().drop(1)) {
            if (laterType != firstType) {
                throwFunction(firstType, laterType, index)
            }
        }
        return firstType
    }

    override fun visitInterfixElement(ctx: InterfixElementContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitNegated(ctx: NegatedContext): ParseNode =
        walkNegatedElement(
            ctx.getText(),
            visit(ctx.getChild(1)),
        )

    override fun visitPostfix(ctx: PostfixContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitCapture(ctx: CaptureContext): ParseNode =
        walkRuleCapture(
            ctx.getText(),
            visit(ctx.getChild(0)),
            visit(ctx.captureRef()),
        )

    override fun visitRepeater(ctx: RepeaterContext): ParseNode =
        walkRuleRepeater(ctx.getText(), visit(ctx.getChild(0)), visit(ctx.repeaterType()))

    override fun visitSimple(ctx: SimpleContext): ParseNode =
        walkSimpleElement(visit(ctx.getChild(0)))

    override fun visitAnySyllable(ctx: AnySyllableContext): ParseNode =
        walkAnySyllable()

    override fun visitClassRef(ctx: ClassRefContext): ParseNode =
        walkClassReference(
            ctx.getText(),
            visit(ctx.name()),
        )

    override fun visitCaptureRef(ctx: CaptureRefContext): ParseNode =
        walkCaptureReference(
            ctx.getText(),
            ctx.NUMBER().toInt(),
            ctx.INEXACT() == null,
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
            visit(ctx.matrixValue()),
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

    override fun visitSylBoundary(ctx: SylBoundaryContext): ParseNode = walkSyllableBoundary()

    override fun visitBoundary(ctx: BoundaryContext): ParseNode = walkBoundary()

    override fun visitBetweenWords(ctx: BetweenWordsContext): ParseNode = walkBetweenWords()

    override fun visitRepeaterType(ctx: RepeaterTypeContext): ParseNode =
        optionalVisit(ctx.repeatRange()) ?: walkRepeaterType(
            ctx.getText(),
            when {
                ctx.AT_LEAST_ONE() != null -> StandardRepeaterType.ONE_OR_MORE
                ctx.NULL() != null -> StandardRepeaterType.ZERO_OR_MORE
                ctx.OPTIONAL() != null -> StandardRepeaterType.ZERO_OR_ONE
                else -> throw AssertionError()
            }
        )

    override fun visitRepeatRange(ctx: RepeatRangeContext): ParseNode =
        walkRepeaterType(
            ctx.getText(),
            ctx.NUMBER()?.let {
                val number = it.toInt()
                FlexibleRepeaterType(number, number)
            } ?: FlexibleRepeaterType(
                ctx.lowerBound()?.toInt() ?: 0,
                ctx.upperBound()?.toInt()
            )
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
        changeRules: List<RuleWithAnchoredStatements>,
        romanizer: ParseNode?,
    ): ParseNode = SoundChangerNodeImpl(
        text,
        featureDeclarations,
        diacriticDeclarations,
        symbolDeclarations,
        classDeclarations,
        deromanizer,
        changeRules,
        romanizer,
    )

    private fun resolveClasses(classDeclarations: List<ClassDeclarationNode>): List<SegmentClass> {
        val definedClasses = mutableMapOf<String, SegmentClass>()
        val allClassNames = classDeclarations.map { it.name }.toSet()
        for (classNode in classDeclarations) {
            val newClassSounds = classNode.elements.flatMap {
                if (it is TextNode) listOf(it.literalText)
                else {
                    val nestedName = (it as ClassReferenceElement).name
                    definedClasses[nestedName]?.sounds ?: throw LscUndefinedName(
                        "class", nestedName, nestedName in allClassNames
                    )
                }
            }
            if (classNode.name in definedClasses) throw LscDuplicateName("class", classNode.name)
            definedClasses[classNode.name] = SegmentClass(classNode.name, newClassSounds)
        }
        return definedClasses.values.toList()
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
        level: ParseNode?,
    ): ParseNode = FeatureDeclarationNode(
        text,
        Feature(
            (featureName as NameNode).name,
            values.map { (it as SimpleValueNode).simpleValue },
            (nullAlias as SimpleValueNode?)?.simpleValue,
            (level as FeatureLevelNode?)?.level ?: WordLevel.SEGMENT,
        )
    )

    private fun walkPlusFeature(
        text: String,
        featureName: ParseNode,
        plusOnly: Boolean,
        level: ParseNode?,
    ): ParseNode {
        val name = (featureName as NameNode).name
        return FeatureDeclarationNode(
            text,
            Feature(
                name,
                listOf(SimpleValue("+$name")) +
                        if (!plusOnly) listOf(SimpleValue("-$name")) else emptyList(),
                if (plusOnly) SimpleValue("-$name") else null,
                (level as FeatureLevelNode?)?.level ?: WordLevel.SEGMENT,
            )
        )
    }

    private fun walkDiacriticDeclaration(
        text: String,
        diacritic: String,
        matrix: ParseNode,
        position: ModifierPosition,
        floating: Boolean,
    ): ParseNode =
        DiacriticDeclarationNode(
            text,
            Diacritic(diacritic, (matrix as MatrixNode).matrix, position, floating),
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

    private fun walkSyllableDecl(
        text: String,
        patterns: List<ParseNode>?,
    ): ParseNode =
        SyllableStructureNode(text, patterns?.map { it as SyllablePatternNode })

    private fun walkSyllablePattern(
        text: String,
        ruleElement: ParseNode,
        environment: ParseNode?,
        matrix: ParseNode?,
    ): ParseNode =
        SyllablePatternNode(
            text,
            (environment?.let {
                walkLookaround(text, ruleElement, it)
            } ?: ruleElement) as RuleElement,
            matrix as MatrixNode?,
        )

    private fun walkDeromanizer(
        text: String,
        subrules: List<ParseNode>,
        literal: Boolean,
    ): ParseNode =
        UnlinkedDeromanizer(
            text,
            subrules.map { it as UnlinkedRule },
            literal
        )

    private fun walkRomanizer(
        text: String,
        subrules: List<ParseNode>,
        literal: Boolean
    ): ParseNode =
        UnlinkedRomanizer(
            text,
            subrules.map { it as UnlinkedRule },
            literal
        )

    private fun walkIntermediateRomanizer(
        text: String,
        ruleName: String,
        subrules: List<ParseNode>,
        literal: Boolean
    ): ParseNode =
        UnlinkedRomanizer(
            text,
            subrules.map { it as UnlinkedRule },
            literal,
            name = ruleName,
        )

    private fun walkChangeRule(
        text: String,
        ruleName: String,
        mainBlock: ParseNode,
        modifiers: RuleModifiers,
    ): ParseNode = UnlinkedStandardRule(
        text,
        ruleName,
        mainBlock as UnlinkedRule,
        ruleFilter = when (modifiers.ruleFilter) {
            is MatrixNode -> MatrixElement(
                modifiers.ruleFilter.text, modifiers.ruleFilter.matrix
            )
            else -> modifiers.ruleFilter as RuleElement?
        },
        matchMode = modifiers.matchMode,
        propagate = modifiers.isPropagate,
        cleanup = modifiers.isCleanup,
    )

    private fun walkBlock(
        text: String,
        blockType: BlockType,
        subrules: List<ParseNode>,
    ): ParseNode =
        when (blockType) {
            BlockType.SEQUENTIAL -> UnlinkedSequentialBlock(
                text,
                subrules.map { it as UnlinkedRule }
            )
            BlockType.FIRST_MATCHING -> UnlinkedFirstMatchingBlock(
                text,
                subrules.map { it as UnlinkedRule }
            )
        }

    private fun walkExpressionList(text: String, expressions: List<ParseNode>): ParseNode =
        UnlinkedSimpleChangeRule(text, expressions.map { it as UnlinkedRuleExpression })

    private fun walkRuleExpression(
        text: String,
        ruleFrom: ParseNode,
        ruleTo: ParseNode,
        compoundEnvironment: ParseNode?,
    ): ParseNode = UnlinkedRuleExpression(
        text,
        ruleFrom as RuleElement,
        ruleTo as RuleElement,
        compoundEnvironment as UnlinkedCompoundEnvironment?,
    )

    private fun walkDoNothingExpression(): ParseNode =
        UnlinkedRuleExpression(
            "unchanged",
            DoNothingElement,
            DoNothingElement,
            UnlinkedCompoundEnvironment("", emptyList(), emptyList())
        )

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

    private fun walkLookaround(
        text: String,
        element: ParseNode,
        environment: ParseNode,
    ): ParseNode =
        EnvironmentElement(
            text,
            element as RuleElement,
            environment as UnlinkedCompoundEnvironment,
        )

    private fun walkCompoundEnvironment(
        text: String,
        positive: ParseNode?,
        negative: ParseNode?,
    ): ParseNode =
        UnlinkedCompoundEnvironment(
            text,
            walkEnvironmentOrEnvironmentList(positive),
            walkEnvironmentOrEnvironmentList(negative),
        )

    private fun walkEnvironmentOrEnvironmentList(node: ParseNode?): List<UnlinkedEnvironment> =
        when (node) {
            null -> emptyList()
            is UnlinkedEnvironment -> listOf(node)
            is ParseNodeList -> node.elements.map { it as UnlinkedEnvironment }
            else -> throw AssertionError()
        }

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

    private fun walkInterfix(
        text: String,
        interfixType: InterfixType,
        items: List<ParseNode>,
        negations: List<Boolean>,
    ): ParseNode =
        when (interfixType) {
            InterfixType.INTERSECTION ->
                IntersectionElement(
                    text,
                    items.first() as RuleElement,
                    items.drop(1).zip(negations) { item, negated ->
                        CheckElement(item as RuleElement, negated)
                    },
                )
            InterfixType.TRANSFORMING ->
                throw LscFutureStructure("Transforming elements")
//                TransformingElement(
//                    text,
//                    items.map { it as ResultElement },
//                )
            else -> throw AssertionError("Invalid interfix type $interfixType")
        }

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
            NegatedValue((value as SimpleValueNode).simpleValue.name)
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

    private fun walkSyllableBoundary(): ParseNode = SyllableBoundaryElement

    private fun walkBoundary(): ParseNode = WordBoundaryElement

    private fun walkBetweenWords(): ParseNode = BetweenWordsElement

    private fun walkAnySyllable(): ParseNode = SyllableElement

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
        exact: Boolean,
    ): ParseNode =
        CaptureReferenceElement(text, number, exact)

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
        private val changeRules: List<RuleWithAnchoredStatements>,
        private val romanizer: ParseNode?,
    ) : BaseParseNode(text), SoundChangerNode {
        private val initialDeclarations = Declarations(
            featureDeclarations.flatMap { sublist ->
                (sublist as ParseNodeList).elements.map { (it as FeatureDeclarationNode).feature }
            },
            diacriticDeclarations.map { (it as DiacriticDeclarationNode).diacritic },
            symbolDeclarations.flatMap { sublist ->
                (sublist as ParseNodeList).elements.map { (it as SymbolDeclarationNode).symbol }
            },
            resolveClasses(classDeclarations.map { it as ClassDeclarationNode }),
        )

        private val firstAnchoredStatement = changeRules.firstOrNull()?.statements?.firstOrNull()
        private val initialSyllabifiedDeclarations =
            if (firstAnchoredStatement is SyllableStructureNode) {
                // Put an implicit "Syllables: explicit" right at the
                // beginning to preserve syllable breaks in the input.
                // We can't use the actual first syllabification rules
                // yet, since the deromanizer hasn't run.
                initialDeclarations.withSyllabifier(
                    Syllabifier(initialDeclarations, emptyList())
                )
            } else {
                initialDeclarations
            }
        private var declarations = initialSyllabifiedDeclarations

        private val linkedDeromanizer = (deromanizer as UnlinkedDeromanizer?)?.let {
            SoundChanger.plainRule(
                it.link(
                    1, declarations, InheritedRuleProperties.none
                ) as NamedRule
            )
        }

        // The deromanizer might change the initial declarations!
        private val realInitialDeclarations = linkedDeromanizer?.rule?.declarations
            ?: initialSyllabifiedDeclarations

        private val linkedRules = changeRules.map { rule ->
            val anchoredSteps = rule.statements.map { anchoredStatement ->
                when (anchoredStatement) {
                    is UnlinkedRomanizer -> SoundChanger.IntermediateRomanizerStep(
                        anchoredStatement.link(
                            1, declarations, InheritedRuleProperties.none
                        ) as NamedRule
                    )
                    is UnlinkedStandardRule -> {
                        SoundChanger.CleanupStep(
                            anchoredStatement.link(
                                1, declarations, InheritedRuleProperties.none
                            ) as NamedRule
                        )
                    }
                    is UnlinkedCleanupOffStep -> {
                        SoundChanger.CleanupOffStep(anchoredStatement.ruleName)
                    }
                    is SyllableStructureNode -> {
                        declarations = initialDeclarations.withSyllabifier(
                            anchoredStatement.syllabifier(initialDeclarations)
                        )
                        SoundChanger.SyllabificationStep(declarations)
                    }
                    else -> throw AssertionError("Unrecognized anchored statement $anchoredStatement")
                }
            }
            val linkedRule = (rule.rule as UnlinkedRule?)?.link(
                1, declarations, InheritedRuleProperties.none
            ) as NamedRule?
            SoundChanger.RuleWithAnchoredSteps(linkedRule, anchoredSteps)
        }

        private val linkedRomanizer = (romanizer as UnlinkedRomanizer?)?.let {
            SoundChanger.plainRule(
                it.link(
                    1, declarations, InheritedRuleProperties.none
                ) as NamedRule
            )
        }

        private val allLinkedRules =
            listOfNotNull(linkedDeromanizer) + linkedRules + listOfNotNull(linkedRomanizer)

        override val soundChanger = SoundChanger(
            realInitialDeclarations,
            allLinkedRules,
        )
    }

    private class FeatureDeclarationNode(
        text: String,
        val feature: Feature,
    ) : BaseParseNode(text)

    private class FeatureLevelNode(
        text: String,
        val level: WordLevel,
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

    private class SyllableStructureNode(
        text: String,
        val patterns: List<SyllablePatternNode>?,
    ) : BaseParseNode(text) {
        fun syllabifier(declarations: Declarations): Syllabifier? =
            patterns?.let { notNullPatterns ->
                Syllabifier(
                    declarations,
                    notNullPatterns.map { it.syllabifierPattern(declarations) }
                )
            }
    }

    private class SyllablePatternNode(
        text: String,
        val element: RuleElement,
        val matrix: MatrixNode?,
    ) : BaseParseNode(text) {
        fun syllabifierPattern(declarations: Declarations): Syllabifier.Pattern =
            Syllabifier.Pattern(
                element.matcher(RuleContext.aloneInMain(), declarations),
                matrix?.matrix,
            )
    }

    private interface UnlinkedRule : ParseNode {
        val numExpressions: Int

        fun link(
            firstExpressionNumber: Int,
            declarations: Declarations,
            inherited: InheritedRuleProperties,
        ): ChangeRule
    }

    data class InheritedRuleProperties(
        val name: String?,
        val filter: ((Segment) -> Boolean)?,
    ) {
        companion object {
            val none: InheritedRuleProperties =
                InheritedRuleProperties(null, null)
        }
    }

    private abstract class BaseUnlinkedRule(
        text: String, val subrules: List<UnlinkedRule>
    ) : BaseParseNode(text), UnlinkedRule {

        val cumulativeNumExpressions: List<Int> =
            subrules.scan(0) { acc, cur -> acc + cur.numExpressions }
        override val numExpressions: Int = cumulativeNumExpressions.last()

        fun linkedSubrules(
            firstExpressionNumber: Int,
            linker: (Int, UnlinkedRule, Int) -> ChangeRule,
        ): List<ChangeRule> {
            return subrules.mapIndexed { index, subrule ->
                val expressionNumber = cumulativeNumExpressions[index]
                val subFirstExpressionNumber = firstExpressionNumber + expressionNumber
                linker(
                    index,
                    subrule,
                    subFirstExpressionNumber,
                )
            }
        }
    }

    private class UnlinkedSimpleChangeRule(
        override val text: String,
        val expressions: List<UnlinkedRuleExpression>,
        val matchMode: MatchMode = MatchMode.SIMULTANEOUS,
    ) : UnlinkedRule {
        override val numExpressions: Int = expressions.size

        override fun link(
            firstExpressionNumber: Int,
            declarations: Declarations,
            inherited: InheritedRuleProperties,
        ): ChangeRule =
            SimpleChangeRule(
                declarations,
                expressions.mapIndexed { index, expression ->
                    expression.link(
                        inherited.name!!,
                        firstExpressionNumber + index,
                        declarations,
                        inherited.filter != null,
                    )
                },
                inherited.filter,
                matchMode,
            )

        fun withMatchMode(matchMode: MatchMode): UnlinkedSimpleChangeRule =
            UnlinkedSimpleChangeRule(text, expressions, matchMode)
    }

    private fun UnlinkedRule.tryWithMatchMode(matchMode: MatchMode): UnlinkedRule =
        if (matchMode == MatchMode.SIMULTANEOUS) this else
        when (this) {
            is UnlinkedSimpleChangeRule -> withMatchMode(matchMode)
            else -> throw LscIllegalNestedModifier(matchMode.string)
        }

    private class UnlinkedDeromanizer(
        text: String,
        subrules: List<UnlinkedRule>,
        val literal: Boolean,
        val name: String = "Deromanizer",
    ) : BaseUnlinkedRule(text, subrules) {

        override fun link(
            firstExpressionNumber: Int,
            declarations: Declarations,
            inherited: InheritedRuleProperties,
        ): ChangeRule {
            val subrules = linkedSubrules(
                firstExpressionNumber,
            ) { index, subrule, subFirstExpressionNumber ->
                if (literal && index == 0) {
                    subrule.link(subFirstExpressionNumber, Declarations.empty, inherited.copy(name = name))
                } else {
                    subrule.link(subFirstExpressionNumber, declarations, inherited.copy(name = name))
                }
            }
            return if (literal) {
                val subrulesWithRedeclaration =
                    listOf(subrules.first()) + Redeclaration(declarations) + subrules.drop(1)
                return StandardNamedRule(
                    name, Declarations.empty, SequentialBlock(subrulesWithRedeclaration), ruleType = RuleType.DEROMANIZER
                )
            } else {
                StandardNamedRule(
                    name, declarations, SequentialBlock(subrules), ruleType = RuleType.DEROMANIZER
                )
            }
        }
    }

    private class UnlinkedRomanizer(
        text: String,
        subrules: List<UnlinkedRule>,
        val literal: Boolean,
        val name: String = "Romanizer",
    ) : BaseUnlinkedRule(text, subrules) {

        override fun link(
            firstExpressionNumber: Int,
            declarations: Declarations,
            inherited: InheritedRuleProperties
        ): ChangeRule {
            val subrules = linkedSubrules(
                firstExpressionNumber,
            ) { index, subrule, subFirstExpressionNumber ->
                if (literal && index == subrules.size - 1) {
                    subrule.link(subFirstExpressionNumber, Declarations.empty, inherited.copy(name = name))
                } else {
                    subrule.link(subFirstExpressionNumber, declarations, inherited.copy(name = name))
                }
            }
            return if (literal) {
                val subrulesWithRedeclaration =
                    subrules.dropLast(1) + Redeclaration(Declarations.empty) + subrules.last()
                return StandardNamedRule(
                    name, declarations, SequentialBlock(subrulesWithRedeclaration), ruleType = RuleType.ROMANIZER
                )
            } else {
                StandardNamedRule(
                    name, declarations, SequentialBlock(subrules), ruleType = RuleType.ROMANIZER
                )
            }
        }
    }

    private class UnlinkedStandardRule(
        text: String,
        val name: String,
        val mainBlock: UnlinkedRule,
        val ruleFilter: RuleElement?,
        val matchMode: MatchMode,
        val propagate: Boolean,
        val cleanup: Boolean,
    ) : BaseUnlinkedRule(text, listOf(mainBlock)) {

        override fun link(
            firstExpressionNumber: Int,
            declarations: Declarations,
            inherited: InheritedRuleProperties
        ): ChangeRule {
            val filter = ruleFilter?.let { filter ->
                { segment: Segment ->
                    filter.matcher(RuleContext.aloneInMain(), declarations).claim(
                        Phrase(StandardWord.single(segment)),
                        PhraseIndex(0, 0),
                        Bindings(),
                    ).any { it.index.segmentIndex == 1 }
                }
            }
            val subrule = linkedSubrules(
                firstExpressionNumber,
            ) { _, subrule, subFirstExpressionNumber ->
                subrule.tryWithMatchMode(matchMode).link(
                    subFirstExpressionNumber,
                    declarations,
                    inherited.copy(
                        name = name,
                        filter = filter,
                    )
                )
            }.single()
            return StandardNamedRule(
                name,
                declarations,
                if (propagate) PropagateBlock(subrule) else subrule,
                filter = filter,
            )
        }
    }

    private class UnlinkedSequentialBlock(
        text: String,
        subrules: List<UnlinkedRule>,
    ) : BaseUnlinkedRule(text, subrules) {
        override fun link(
            firstExpressionNumber: Int,
            declarations: Declarations,
            inherited: InheritedRuleProperties,
        ): ChangeRule =
            SequentialBlock(
                linkedSubrules(
                    firstExpressionNumber,
                ) { _, subrule, subFirstExpressionNumber ->
                    subrule.link(subFirstExpressionNumber, declarations, inherited)
                }
            )
    }

    private class UnlinkedFirstMatchingBlock(
        text: String,
        subrules: List<UnlinkedRule>,
    ) : BaseUnlinkedRule(text, subrules) {
        override fun link(
            firstExpressionNumber: Int,
            declarations: Declarations,
            inherited: InheritedRuleProperties,
        ): ChangeRule =
            WithinWordBlock(
                FirstMatchingBlock(
                    linkedSubrules(
                        firstExpressionNumber,
                    ) { _, subrule, subFirstExpressionNumber ->
                        subrule.link(subFirstExpressionNumber, declarations, inherited)
                    }
                )
            )
    }

    private class UnlinkedPropagateBlock(
        val subrule: UnlinkedRule,
    ) : UnlinkedRule {
        override val numExpressions: Int = subrule.numExpressions

        override fun link(
            firstExpressionNumber: Int,
            declarations: Declarations,
            inherited: InheritedRuleProperties
        ): ChangeRule = PropagateBlock(
            subrule.link(
                firstExpressionNumber,
                declarations,
                inherited,
            )
        )

        override val text: String = subrule.text
    }

    private class UnlinkedRuleExpression(
        text: String,
        val match: RuleElement,
        val result: RuleElement,
        val compoundEnvironment: UnlinkedCompoundEnvironment?,
    ) : BaseParseNode(text) {
        fun link(
            ruleName: String,
            expressionNumber: Int,
            declarations: Declarations,
            filtered: Boolean,
        ): RuleExpression = try {
            val coreMatcher = match.matcher(RuleContext.aloneInMain(), declarations)
            val matcher = compoundEnvironment?.let { env ->
                EnvironmentMatcher(
                    coreMatcher,
                    env.link(declarations),
                )
            } ?: coreMatcher
            RuleExpression(
                declarations,
                matcher.transformerTo(
                    castToResultElement(result).emitter(declarations),
                    filtered,
                )
            )
        } catch (e: UserError) {
            throw LscInvalidRuleExpression(e, ruleName, text, expressionNumber)
        }
    }

    private class UnlinkedCompoundEnvironment(
        text: String,
        val positive: List<UnlinkedEnvironment>,
        val negative: List<UnlinkedEnvironment>,
    ) : BaseParseNode(text) {
        fun link(declarations: Declarations): CompoundEnvironment =
            CompoundEnvironment(
                positive.map { it.link(declarations) },
                negative.map { it.link(declarations) },
            )
    }

    private class UnlinkedEnvironment(
        text: String,
        val before: RuleElement?,
        val after: RuleElement?,
    ) : BaseParseNode(text) {

        fun link(declarations: Declarations): Environment = try {
            Environment(
                before?.matcher(RuleContext.rightBeforeAnchor(), declarations) ?: EmptyMatcher,
                after?.matcher(RuleContext.rightAfterAnchor(), declarations) ?: EmptyMatcher
            )
        } catch (e: LscBadSequence) {
            throw e.initEnvironment(text)
        }
    }

    internal interface RuleElement : ParseNode {
        val publicName: String

        fun matcher(context: RuleContext, declarations: Declarations): Matcher
    }

    internal data class RuleContext(
        val section: RuleSection,
        val precedingElement: ContextElement,
        val followingElement: ContextElement,
    ) {
        fun isAtEdgeOfEnvironment(): Boolean =
            section == RuleSection.ENVIRON &&
                    (precedingElement is ContextElement.None ||
                            followingElement is ContextElement.None)

        companion object {
            fun aloneInMain(): RuleContext =
                RuleContext(RuleSection.MAIN, ContextElement.None, ContextElement.None)

            fun rightBeforeAnchor(): RuleContext =
                RuleContext(RuleSection.ENVIRON, ContextElement.None, ContextElement.Anchor)

            fun rightAfterAnchor(): RuleContext =
                RuleContext(RuleSection.ENVIRON, ContextElement.Anchor, ContextElement.None)
        }
    }

    internal enum class RuleSection {
        MAIN,
        ENVIRON,
    }

    internal sealed class ContextElement {
        internal object None : ContextElement()

        internal object Anchor : ContextElement()

        internal data class Some(val element: RuleElement) : ContextElement()
    }

    private interface ResultElement : RuleElement {
        fun emitter(declarations: Declarations): Emitter
    }

    private fun castToResultElement(element: RuleElement): ResultElement =
        element as? ResultElement ?: throw LscIllegalStructureInOutput(element.publicName, element.text)

    // Base class for elements that simply forward matcher/emitter calls to sub-elements
    private abstract class ContainerResultElement(text: String) : BaseParseNode(text), ResultElement {
        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            combineMatchers(declarations, elements.map { it.matcher(context, declarations) })

        override fun emitter(declarations: Declarations): Emitter =
            combineEmitters(resultElements.map { it.emitter(declarations) })

        abstract val elements: List<RuleElement>

        val resultElements: List<ResultElement> by lazy { elements.map(::castToResultElement) }

        abstract fun combineMatchers(
            declarations: Declarations,
            elements: List<Matcher>,
        ): Matcher

        abstract fun combineEmitters(elements: List<Emitter>): Emitter
    }

    private object DoNothingElement : BaseParseNode("unchanged"), ResultElement {
        override val publicName: String = "an \"unchanged\" element"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            NeverMatcher

        override fun emitter(declarations: Declarations): Emitter =
            NeverEmitter
    }

    private object SyllableBoundaryElement : BaseParseNode("."), ResultElement {
        override val publicName: String = "a syllable boundary"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            if (declarations.syllabifier == null) {
                TextElement(".", ".").matcher(context, declarations)
            } else SyllableBoundaryMatcher

        override fun emitter(declarations: Declarations): Emitter =
            if (declarations.syllabifier == null) {
                TextElement(".", ".").emitter(declarations)
            } else SyllableBoundaryEmitter
    }

    private object WordBoundaryElement : BaseParseNode("$"), RuleElement {
        override val publicName: String = "a word boundary"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            when {
                context.section == RuleSection.MAIN -> throw LscIllegalStructureInInput(publicName, text)
                context.precedingElement is ContextElement.None -> WordStartMatcher
                context.followingElement is ContextElement.None -> WordEndMatcher
                else -> throw LscInteriorWordBoundary()
            }
    }

    private object BetweenWordsElement : BaseParseNode("$$"), ResultElement, RuleElement {
        override val publicName: String = "a space between words"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            BetweenWordsMatcher

        override fun emitter(declarations: Declarations): Emitter =
            BetweenWordsEmitter
    }

    private class EnvironmentElement(
        text: String,
        val element: RuleElement,
        val environment: UnlinkedCompoundEnvironment,
    ) : BaseParseNode(text), RuleElement {
        override val publicName: String = "a nested environment"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            EnvironmentMatcher(
                element.matcher(context, declarations),
                environment.link(declarations),
            )
    }

    private class SequenceElement(
        text: String,
        override val elements: List<RuleElement>,
    ) : ContainerResultElement(text) {
        override val publicName: String = "a sequence"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            try {
                combineMatchers(
                    declarations,
                    (listOf<RuleElement?>(null) + elements + listOf(null)).windowed(3) { window ->
                        val (preceding, current, following) = window
                        current!!.matcher(
                            context.copy(
                                precedingElement = preceding?.let { ContextElement.Some(it) } ?: context.precedingElement,
                                followingElement = following?.let { ContextElement.Some(it) } ?: context.followingElement,
                            ),
                            declarations,
                        )
                    },
                )
            } catch (e: LscBadSequence) {
                throw e.initSequence(text)
            }

        override fun combineMatchers(
            declarations: Declarations,
            elements: List<Matcher>,
        ): Matcher = SequenceMatcher(elements)

        override fun combineEmitters(elements: List<Emitter>): Emitter = SequenceEmitter(elements)
    }

    private class CaptureElement(
        text: String,
        val element: RuleElement,
        val capture: CaptureReferenceElement,
    ) : BaseParseNode(text), RuleElement {
        override val publicName: String = "a capture"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            CaptureMatcher(element.matcher(context, declarations), capture.number)
    }

    private class RepeaterElement(
        text: String,
        val element: RuleElement,
        val repeaterType: RepeaterTypeNode,
    ) : BaseParseNode(text), RuleElement {
        override val publicName: String = when (repeaterType.type) {
            StandardRepeaterType.ZERO_OR_ONE -> "an optional"
            else -> "a repeater"
        }

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher {
            checkContext(context)
            return RepeaterMatcher(
                element.matcher(context, declarations),
                repeaterType.type,
            )
        }

        private fun checkContext(context: RuleContext) {
            if (!repeaterType.type.isSpecificMultiple() &&
                context.isAtEdgeOfEnvironment()
            ) {
                throw LscPeripheralRepeater(text, repeaterType.type)
            }
        }

        private fun RepeaterType.isSpecificMultiple(): Boolean =
            minReps > 1 && minReps == maxReps
    }

    private class AlternativeElement(
        text: String,
        override val elements: List<RuleElement>,
    ) : ContainerResultElement(text) {
        override val publicName: String = "an alternative list"

        override fun combineMatchers(
            declarations: Declarations,
            elements: List<Matcher>
        ): Matcher =
            alternativeMatcher(declarations, elements)

        override fun combineEmitters(elements: List<Emitter>): Emitter =
            alternativeEmitter(elements)
    }

    private class IntersectionElement(
        text: String,
        val initialElement: RuleElement,
        val checkElements: List<CheckElement>,
    ) : BaseParseNode(text), RuleElement {
        override val publicName: String = "an intersection"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            IntersectionMatcher(
                initialElement.matcher(context, declarations),
                checkElements.map { it.matcher(context, declarations) }
            )
    }

    private data class CheckElement(val element: RuleElement, val negated: Boolean) {
        fun matcher(context: RuleContext, declarations: Declarations): CheckMatcher =
            CheckMatcher(element.matcher(context, declarations), negated)
    }

    @Suppress("unused")
    private class TransformingElement(
        text: String,
        val elements: List<ResultElement>,
    ) : BaseParseNode(text), ResultElement {
        override val publicName: String = "a transforming element"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            matcher(declarations, elements.first(), elements.first().emitter(declarations))

        private fun matcher(
            declarations: Declarations,
            element: ResultElement?,
            emitter: Emitter,
        ): Matcher =
            when (emitter) {
                is AlternativeEmitter ->
                    AlternativeMatcher(
                        declarations,
                        (element as? AlternativeElement)?.elements.zipOrThisNull(
                            emitter.elements
                        ) { subElement, subEmitter ->
                            matcher(declarations, subElement as ResultElement?, subEmitter)
                        },
                    )
                is SequenceEmitter ->
                    SequenceMatcher(
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
            declarations: Declarations,
            element: ResultElement?,
            emitter: Emitter,
        ): Matcher {
            val alternatives = remainingElementsAsConditional(
                declarations, "matcher"
            ).map { transformations ->
                EmitterMatcher(
                    TransformingEmitter(
                        castToIndependent(element, emitter),
                        transformations.singleOrNull() ?: MultiConditionalEmitter(transformations),
                    )
                )
            }
            return alternatives.singleOrNull() ?: AlternativeMatcher(
                declarations,
                alternatives
            )
        }

        override fun emitter(declarations: Declarations): Emitter =
            emitter(declarations, elements.first().emitter(declarations))

        private fun emitter(
            declarations: Declarations,
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
                        }
                    )
                else -> singleEmitter(declarations, emitter)
            }

        private fun singleEmitter(
            declarations: Declarations,
            emitter: Emitter,
        ): Emitter {
            val alternatives = remainingElementsAsConditional(
                declarations, "emitter"
            ).map { transformations ->
                if (emitter.isIndependent()) {
                    TransformingEmitter(
                        emitter as IndependentEmitter,
                        transformations.singleOrNull() ?: MultiConditionalEmitter(transformations)
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
            declarations: Declarations,
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
    }

    private class TextElement(
        text: String,
        val literalText: String,
        val exact: Boolean = false,
    ) : BaseParseNode(text), ResultElement {
        override val publicName: String = "literal text"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            declarations.parsePhonetic(literalText, syllabify = false).let {
                if (exact) TextMatcher(it) else SymbolMatcher(declarations, it)
            }

        override fun emitter(declarations: Declarations): Emitter =
            declarations.parsePhonetic(literalText, syllabify = false).let {
                if (exact) TextEmitter(it) else SymbolEmitter(declarations, it)
            }
    }

    private class MatrixElement(
        text: String,
        val matrix: Matrix,
    ) : BaseParseNode(text), ResultElement {
        override val publicName: String = "a matrix"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            with(declarations) {
                val split = matrix.splitByLevel()
                val segmentMatcher = split[WordLevel.SEGMENT]?.let {
                    MatrixMatcher(declarations, it)
                }
                val syllableMatcher = split[WordLevel.SYLLABLE]?.let {
                    SyllableMatrixMatcher(declarations, it)
                }
                if (syllableMatcher == null) {
                    segmentMatcher ?: MatrixMatcher(declarations, Matrix.EMPTY)
                } else {
                    if (segmentMatcher == null) {
                        syllableMatcher
                    } else {
                        IntersectionMatcher(
                            segmentMatcher,
                            listOf(CheckMatcher(syllableMatcher, false))
                        )
                    }
                }
            }

        override fun emitter(declarations: Declarations): Emitter =
            with(declarations) {
                val split = matrix.splitByLevel()
                val segmentEmitter = split[WordLevel.SEGMENT]?.let {
                    MatrixEmitter(declarations, it)
                }
                val syllableEmitter = split[WordLevel.SYLLABLE]?.let {
                    SyllableMatrixEmitter(declarations, it)
                }
                if (syllableEmitter == null) {
                    segmentEmitter ?: MatrixEmitter(declarations, Matrix.EMPTY)
                } else {
                    if (segmentEmitter == null) {
                        syllableEmitter
                    } else {
                        MultiConditionalEmitter(listOf(segmentEmitter, syllableEmitter))
                    }
                }
            }
    }

    private class NegatedElement(
        text: String,
        val element: RuleElement,
    ) : BaseParseNode(text), RuleElement {
        override val publicName: String = "a negated element"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            NegatedMatcher(element.matcher(context, declarations))
    }

    private object EmptyElement : BaseParseNode("*"), ResultElement {
        override val publicName: String = "an empty element"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            EmptyMatcher

        override fun emitter(declarations: Declarations): Emitter = EmptyEmitter
    }

    private object SyllableElement : BaseParseNode("<syl>"), RuleElement {
        override val publicName: String = "a syllable element"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            SyllableMatcher

    }

    private class ClassReferenceElement(
        text: String,
        val name: String,
    ) : BaseParseNode(text), ResultElement {
        override val publicName: String = "a class reference"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            with(declarations) {
                alternativeMatcher(
                    declarations,
                    name.toClass().sounds.map {
                        TextElement(it, it).matcher(context, this)
                    },
                )
            }

        override fun emitter(declarations: Declarations): Emitter =
            with(declarations) {
                alternativeEmitter(name.toClass().sounds.map {
                    TextElement(it, it).emitter(this)
                })
            }
    }

    private fun alternativeMatcher(
        declarations: Declarations,
        elements: List<Matcher>,
    ): Matcher =
        elements.singleOrNull() ?: AlternativeMatcher(declarations, elements)

    private fun alternativeEmitter(elements: List<Emitter>): Emitter =
        elements.singleOrNull() ?: AlternativeEmitter(elements)

    private class CaptureReferenceElement(
        text: String,
        val number: Int,
        val exact: Boolean,
    ) : BaseParseNode(text), ResultElement {
        override val publicName: String = "a capture reference"

        override fun matcher(context: RuleContext, declarations: Declarations): Matcher =
            CaptureReferenceMatcher(declarations, number, exact)

        override fun emitter(declarations: Declarations): Emitter =
            if (!exact) throw LscIllegalStructureInOutput(
                "an inexact capture reference", "~"
            ) else CaptureReferenceEmitter(number)
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

    private fun ParseTree.toInt(): Int = getText().toIntOrNull() ?: throw LscNumberOverflow(getText())
}

enum class BlockType(val text: String) {
    SEQUENTIAL("Then"),
    FIRST_MATCHING("Else"),
}

enum class InterfixType(val text: String) {
    INTERSECTION("&"),
    INTERSECTION_NOT("&!"),
    TRANSFORMING(">"),
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

open class LscIllegalStructure(
    val invalidNodeType: String,
    val invalidNode: String,
    val location: String,
) : LscUserError(
    "${invalidNodeType.capitalize()} like \"$invalidNode\" can't be used $location"
)

private fun String.capitalize(): String = replaceFirstChar { it.uppercase() }

class LscIllegalStructureInInput(
    invalidNodeType: String,
    invalidNode: String,
) : LscIllegalStructure(
    invalidNodeType,
    invalidNode,
    "in the input of a rule",
)

class LscIllegalStructureInOutput(
    invalidNodeType: String,
    invalidNode: String,
) : LscIllegalStructure(
    invalidNodeType,
    invalidNode,
    "in the output of a rule"
)

class LscMixedBlock(
    val firstBlockType: BlockType,
    val conflictingBlockType: BlockType,
) : LscUserError(
    "Can't mix ${firstBlockType.text} and ${conflictingBlockType.text} at the same level"
)

class LscInvalidModifier(
    val ruleName: String,
    val modifierName: String,
) : LscUserError(
    "Invalid modifier \"${modifierName}\" applied to \"${ruleName}\""
)

class LscIllegalNestedModifier(
    val modifierName: String,
) : LscUserError(
    "Blocks with the \"$modifierName\" modifier can't have other blocks inside them"
)

class LscNumberOverflow(val number: String) : LscUserError("$number is too big")

class LscNotParsable(val line: Int, val column: Int, val offendingSymbol: String, val customMessage: String) :
    LscUserError("$customMessage (line $line)")
