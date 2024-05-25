package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import com.meamoria.lexurgy.sc.element.EnvironmentMatcher
import com.meamoria.lexurgy.sc.java.LscBaseVisitor
import com.meamoria.lexurgy.sc.java.LscLexer
import com.meamoria.lexurgy.sc.java.LscParser
import com.meamoria.lexurgy.sc.parser.*
import com.meamoria.lexurgy.word.*
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.TerminalNode
import java.util.*
import kotlin.reflect.KClass

class LscInterpreter {
    fun parseFile(text: String): AstNode = parseAndWalk(text) { it.lscFile() }

    fun parseFeatureDeclaration(text: String): AstNode = parseAndWalk(text) { it.featureDecl() }

    fun parseDiacriticDeclaration(text: String): AstNode = parseAndWalk(text) { it.diacriticDecl() }

    fun parseSymbolDeclaration(text: String): AstNode = parseAndWalk(text) { it.symbolDecl() }

    fun parseDeromanizer(text: String): AstNode = parseAndWalk(text) { it.deromanizer() }

    fun parseRomanizer(text: String): AstNode = parseAndWalk(text) { it.romanizer() }

    fun parseChangeRule(text: String): AstNode = parseAndWalk(text) { it.changeRule() }

    fun parseMatrix(text: String): AstNode = parseAndWalk(text) { it.matrix() }

    private fun parseAndWalk(text: String, parser: (LscParser) -> ParseTree): AstNode {
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
        parser.addErrorListener(LscErrorListener())
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
        when (offendingSymbol) {
            "<EOF>" ->
                "The rules are incomplete; more is expected after \"$offendingLine\""
            "\n" ->
                "The line \"$offendingLine\" is incomplete"
            else ->
                "\"$offendingSymbol\" doesn't make sense in the line \"$offendingLine\""
        }
}

object LscWalker : LscBaseVisitor<AstNode>() {
    override fun visitLscFile(ctx: LscParser.LscFileContext): AstNode {
        val statementContexts = ctx.statement().map { it.getChild(0) as ParserRuleContext }
        validateOrder(statementContexts)
        validateNoNakedExpressions(statementContexts)
        val rulesWithAnchoredStatements = visitRulesWithAnchoredStatements(statementContexts)
        val deromanizerContext = extractDeromanizerContext(statementContexts)
        val romanizerContext = extractRomanizerContext(statementContexts)
        return walkFile(
            ctx.text,
            featureDeclarations = listVisit(statementContexts.filterIsInstance<LscParser.FeatureDeclContext>()),
            diacriticDeclarations = listVisit(statementContexts.filterIsInstance<LscParser.DiacriticDeclContext>()),
            symbolDeclarations = listVisit(statementContexts.filterIsInstance<LscParser.SymbolDeclContext>()),
            classDeclarations = listVisit(statementContexts.filterIsInstance<LscParser.ClassDeclContext>()),
            elementDeclarations = listVisit(statementContexts.filterIsInstance<LscParser.ElementDeclContext>()),
            deromanizer = optionalVisit(deromanizerContext),
            changeRules = rulesWithAnchoredStatements,
            romanizer = optionalVisit(romanizerContext),
        )
    }

    private fun validateOrder(statements: List<ParserRuleContext>) {
        for ((prev, next) in statements.filter { it::class in allowedStatementPositions }.zipWithNext()) {
            if (allowedStatementPositions.getValue(prev::class) > allowedStatementPositions.getValue(next::class)) {
                throw LscNotParsable(
                    prev.start.line, 0, prev.text,
                    "The ${statementNames.getValue(prev::class)} must come after " +
                            "the ${statementNames.getValue(next::class)}"
                )
            }
        }
    }

    private val allowedStatementPositions: Map<KClass<*>, Int> = mapOf(
        LscParser.FeatureDeclContext::class to 0,
        LscParser.DiacriticDeclContext::class to 10,
        LscParser.SymbolDeclContext::class to 10,
        LscParser.ClassDeclContext::class to 30,
        LscParser.ElementDeclContext:: class to 30,
        LscParser.DeromanizerContext::class to 40,
        LscParser.SyllableDeclContext::class to 50,
        LscParser.ChangeRuleContext::class to 50,
        LscParser.InterRomanizerContext::class to 50,
        LscParser.RomanizerContext::class to 60,
    )

    private val statementNames: Map<KClass<*>, String> = mapOf(
        LscParser.FeatureDeclContext::class to "feature declarations",
        LscParser.DiacriticDeclContext::class to "diacritic declarations",
        LscParser.SymbolDeclContext::class to "symbol declarations",
        LscParser.ClassDeclContext::class to "class declarations",
        LscParser.ElementDeclContext::class to "element declarations",
        LscParser.SyllableDeclContext::class to "syllable declarations",
        LscParser.DeromanizerContext::class to "deromanizer",
        LscParser.ChangeRuleContext::class to "change rules",
        LscParser.InterRomanizerContext::class to "intermediate romanizers",
        LscParser.RomanizerContext::class to "final romanizer",
    )

    private fun validateNoNakedExpressions(statements: List<ParserRuleContext>) {
        val nakedExpression = statements.filterIsInstance<LscParser.StandardExpressionContext>().firstOrNull()
        if (nakedExpression != null) {
            throw ExpressionNotInRule(nakedExpression.text)
        }
    }

    private fun visitRulesWithAnchoredStatements(
        contexts: List<ParserRuleContext>
    ): List<RuleWithAnchoredStatements> {
        val rulesWithAnchoredStatements = mutableListOf<RuleWithAnchoredStatements>()
        var curAnchoredStatements = mutableListOf<AstNode>()
        for (context in contexts) {
            when (context) {
                is LscParser.ChangeRuleContext -> {
                    if (context.isCleanupOffRule()) {
                        curAnchoredStatements += UnlinkedCleanupOffStep(
                            context.text,
                            context.ruleName().text,
                        )
                    } else {
                        val rule = visit(context) as UnlinkedStandardRule
                        if (rule.cleanup) {
                            curAnchoredStatements += rule
                        } else if (rule.deferred) {
                            // Don't anchor anything to a deferred rule!
                            rulesWithAnchoredStatements += RuleWithAnchoredStatements(
                                rule, emptyList()
                            )
                        } else {
                            rulesWithAnchoredStatements += RuleWithAnchoredStatements(
                                rule, curAnchoredStatements
                            )
                            curAnchoredStatements = mutableListOf()
                        }
                    }
                }
                is LscParser.InterRomanizerContext -> curAnchoredStatements += visit(context)
                is LscParser.SyllableDeclContext -> curAnchoredStatements += visit(context)
                else -> {}
            }
        }
        rulesWithAnchoredStatements += RuleWithAnchoredStatements(
            null, curAnchoredStatements
        )
        return rulesWithAnchoredStatements
    }

    private fun LscParser.ChangeRuleContext.isCleanupOffRule(): Boolean =
        block()
            .blockElement()
            .singleOrNull()
            ?.expressionList()
            ?.expression()
            ?.singleOrNull()
            ?.keywordExpression()
            ?.OFF() != null

    private class UnlinkedCleanupOffStep(
        text: String,
        val ruleName: String,
    ) : BaseAstNode(text)


    /**
     * A change rule, plus all the non-rule statements
     * (e.g. intermediate romanizers) between it and the previous
     * rule, in declaration order. If ``rule`` is null, the non-rule statements
     * are after all the rules.
     */
    private data class RuleWithAnchoredStatements(
        val rule: AstNode?,
        val statements: List<AstNode>,
    )

    private fun extractDeromanizerContext(statements: List<ParserRuleContext>): LscParser.DeromanizerContext? =
        statements.filterIsInstance<LscParser.DeromanizerContext>().singleOrNullOrThrow {
            LscDuplicateName("rule", "<deromanizer>")
        }

    private fun extractRomanizerContext(statements: List<ParserRuleContext>): LscParser.RomanizerContext? =
        statements.filterIsInstance<LscParser.RomanizerContext>().singleOrNullOrThrow {
            LscDuplicateName("rule", "<romanizer>")
        }

    override fun visitElementDecl(ctx: LscParser.ElementDeclContext): AstNode = walkElementDeclaration(
        ctx.text,
        visit(ctx.name()),
        visit(ctx.ruleElement()),
    )

    override fun visitClassDecl(ctx: LscParser.ClassDeclContext): AstNode = walkClassDeclaration(
        ctx.text,
        visit(ctx.name()),
        listVisit(ctx.classElement()),
    )

    override fun visitClassElement(ctx: LscParser.ClassElementContext): AstNode = visit(ctx.getChild(0))

    override fun visitFeatureDecl(ctx: LscParser.FeatureDeclContext): AstNode =
        if (ctx.name() == null) {
            AstNodeList(
                listVisit(ctx.plusFeature()),
            )
        } else {
            AstNodeList(
                listOf(
                    walkFeatureDeclaration(
                        ctx.text,
                        visit(ctx.name()!!),
                        optionalVisit(ctx.nullAlias()),
                        listVisit(ctx.featureValue()),
                        optionalVisit(ctx.featureModifier())
                    )
                )
            )
        }

    override fun visitFeatureModifier(ctx: LscParser.FeatureModifierContext): AstNode =
        FeatureLevelNode(ctx.text, WordLevel.SYLLABLE)

    override fun visitPlusFeature(ctx: LscParser.PlusFeatureContext): AstNode = walkPlusFeature(
        ctx.text,
        visit(ctx.name()),
        ctx.AT_LEAST_ONE() != null,
        optionalVisit(ctx.featureModifier()),
    )

    override fun visitNullAlias(ctx: LscParser.NullAliasContext): AstNode = visit(ctx.featureValue())

    override fun visitDiacriticDecl(ctx: LscParser.DiacriticDeclContext): AstNode {
        val modifiers = ctx.diacriticModifier()
        val position = when {
            modifiers.any { it.DIA_BEFORE() != null } -> ModifierPosition.BEFORE
            modifiers.any { it.DIA_FIRST() != null } -> ModifierPosition.FIRST
            else -> ModifierPosition.AFTER
        }
        val floating = modifiers.any { it.DIA_FLOATING() != null }
        return walkDiacriticDeclaration(
            ctx.text,
            removeEscapes(ctx.text().text),
            visit(ctx.matrix()),
            position,
            floating,
        )
    }

    override fun visitSymbolDecl(ctx: LscParser.SymbolDeclContext): AstNode {
        val symbolNames = ctx.symbolName().map { removeEscapes(it.text) }
        val matrix = ctx.matrix()
        return if (matrix == null) AstNodeList(
            symbolNames.map { walkSymbolDeclaration(it, it, null) }
        )
        else AstNodeList(
            listOf(walkSymbolDeclaration(ctx.text, symbolNames.single(), visit(matrix)))
        )
    }

    override fun visitSyllableDecl(ctx: LscParser.SyllableDeclContext): AstNode =
        walkSyllableDecl(
            ctx.text,
            if (ctx.CLEAR_SYLLABLES() != null) null
            else listVisit(ctx.syllableExpression()),
        )

    override fun visitSyllableExpression(ctx: LscParser.SyllableExpressionContext): AstNode =
        walkSyllableExpression(
            ctx.text,
            visit(ctx.syllablePattern()),
            optionalVisit(ctx.compoundEnvironment()),
            optionalVisit(ctx.matrix()),
        )

    override fun visitSyllablePattern(ctx: LscParser.SyllablePatternContext): AstNode =
        visit(ctx.getChild(0))

    override fun visitStructuredPattern(ctx: LscParser.StructuredPatternContext): AstNode =
        walkStructuredPattern(
            ctx.text,
            reluctantOnset = optionalVisit(ctx.reluctantOnset()) as Element?,
            onset = visit(ctx.unconditionalRuleElement(0)) as Element,
            nucleus = visit(ctx.unconditionalRuleElement(1)) as Element,
            coda = optionalVisit(ctx.unconditionalRuleElement(2)) as Element?,
        )

    override fun visitReluctantOnset(ctx: LscParser.ReluctantOnsetContext): AstNode =
        visit(ctx.getChild(0))

    private fun walkStructuredPattern(
        text: String,
        reluctantOnset: Element?,
        onset: Element,
        nucleus: Element,
        coda: Element?,
    ): AstNode = StructuredSyllablePatternNode(
        text,
        reluctantOnset = reluctantOnset,
        onset = onset,
        nucleus = nucleus,
        coda = coda,
    )

    override fun visitDeromanizer(ctx: LscParser.DeromanizerContext): AstNode =
        walkDeromanizer(
            ctx.text,
            unpackBlock(visit(ctx.block())),
            ctx.LITERAL() != null
        )

    override fun visitRomanizer(ctx: LscParser.RomanizerContext): AstNode =
        walkRomanizer(
            ctx.text,
            unpackBlock(visit(ctx.block())),
            ctx.LITERAL() != null
        )

    override fun visitInterRomanizer(ctx: LscParser.InterRomanizerContext): AstNode =
        walkIntermediateRomanizer(
            ctx.text,
            ctx.ruleName().text,
            unpackBlock(visit(ctx.block())),
            ctx.LITERAL() != null
        )

    private fun unpackBlock(block: AstNode): List<AstNode> =
        when (block) {
            is UnlinkedSequentialBlock -> block.subRules
            else -> listOf(block)
        }

    override fun visitChangeRule(ctx: LscParser.ChangeRuleContext): AstNode {
        val ruleName = ctx.ruleName().text
        val modifierContexts = ctx.changeRuleModifier()
        if (ctx.RULE_START() == null) {
            noColon(ruleName, modifierContexts, ctx.NEWLINE(0))
        }
        val modifiers = modifierContexts.getModifiers(ruleName)
        return walkChangeRule(
            ctx.text,
            ruleName,
            visit(ctx.block()),
            modifiers,
        )
    }

    private fun List<LscParser.ChangeRuleModifierContext>.getModifiers(
        ruleName: String,
        isModifierValid: (LscParser.KeywordModifierContext) -> Boolean = { true },
    ): RuleModifiers {
        val filter = getFilter(ruleName)
        val keywordModifiers = mapNotNull { it.keywordModifier() }
        keywordModifiers.validateModifiers(ruleName, isModifierValid)
        val matchMode = keywordModifiers.getMatchMode(ruleName)
        val isPropagate = keywordModifiers.any { it.PROPAGATE() != null }
        val isCleanup = keywordModifiers.any { it.CLEANUP() != null }
        val isDeferred = keywordModifiers.any { it.BLOCK() != null }
        return RuleModifiers(
            ruleFilter = filter,
            matchMode = matchMode,
            isPropagate = isPropagate,
            isCleanup = isCleanup,
            isDeferred = isDeferred,
        )
    }

    private fun List<LscParser.ChangeRuleModifierContext>.getFilter(ruleName: String): AstNode? =
        optionalVisit(
            mapNotNull { it.filter() }.let { filters ->
                if (filters.isEmpty()) null
                else filters.singleOrNull() ?: multipleModifiers(
                    ruleName, "filter", filters,
                )
            }
        )

    private fun List<LscParser.KeywordModifierContext>.validateModifiers(
        ruleName: String,
        isModifierValid: (LscParser.KeywordModifierContext) -> Boolean,
    ) {
        val firstInvalidModifier = find { it.NAME() != null || !isModifierValid(it) }
        if (firstInvalidModifier != null) {
            throw LscInvalidModifier(ruleName, firstInvalidModifier.text)
        }
    }

    private fun List<LscParser.KeywordModifierContext>.getMatchMode(ruleName: String): MatchMode {
        val matchModes = filter { it.LTR() != null || it.RTL() != null }
        return if (matchModes.isEmpty()) MatchMode.SIMULTANEOUS
        else matchModes.singleOrNull()?.let {
            if (it.LTR() != null) MatchMode.LEFT_TO_RIGHT else MatchMode.RIGHT_TO_LEFT
        } ?: multipleModifiers(
            ruleName, "match mode", matchModes,
        )
    }

    private data class RuleModifiers(
        val ruleFilter: AstNode?,
        val matchMode: MatchMode,
        val isPropagate: Boolean,
        val isCleanup: Boolean,
        val isDeferred: Boolean,
    )

    private fun noColon(
        ruleName: String, modifiers: List<LscParser.ChangeRuleModifierContext>, newline: TerminalNode
    ): Nothing =
        throw LscNotParsable(
            newline.symbol.line,
            newline.symbol.charPositionInLine,
            "new line",
            "The rule \"$ruleName\" needs a colon after " +
                    if (modifiers.isEmpty()) "the rule name" else "\"${modifiers.last().text}\""
        )

    private fun multipleModifiers(
        ruleName: String,
        modifierTypeName: String,
        contexts: List<ParserRuleContext>
    ): Nothing =
        throw LscNotParsable(
            contexts[1].start.line,
            contexts[1].start.charPositionInLine,
            contexts[1].text,
            "The rule \"$ruleName\" has more than one $modifierTypeName: " +
                    "${contexts[0].text} and ${contexts[1].text}"
        )

    override fun visitFilter(ctx: LscParser.FilterContext): AstNode =
        visit(ctx.getChild(0))

    override fun visitBlock(ctx: LscParser.BlockContext): AstNode {
        val blockTypes = ctx.blockType()
        if (blockTypes.isEmpty()) return visit(ctx.blockElement().single())
        val blockType = checkUniformBlockType(blockTypes)
        val allModifierContexts = listOf(emptyList<LscParser.ChangeRuleModifierContext>()) +
                blockTypes.map { it.changeRuleModifier() }
        val blockElements = listVisit(ctx.blockElement()).zip(
            allModifierContexts
        ) { element, modifierContexts ->
            element as UnlinkedRule
            val modifiers = modifierContexts.getModifiers("<${blockType.text}>") {
                it.CLEANUP() == null
            }
            val block = if (modifiers.isPropagate) {
                UnlinkedPropagateBlock(element)
            } else element
            block.tryWithMatchMode(modifiers.matchMode)
        }
        return walkBlock(ctx.text, blockType, blockElements)
    }

    private fun checkUniformBlockType(blockCtxs: List<LscParser.BlockTypeContext>): BlockType =
        checkUniformType(blockCtxs.map { getBlockType(it) }) { firstType, laterType, _ ->
            throw LscMixedBlock(firstType, laterType)
        }

    private fun getBlockType(ctx: LscParser.BlockTypeContext) =
        when {
            ctx.ALL_MATCHING() != null -> BlockType.SEQUENTIAL
            ctx.FIRST_MATCHING() != null -> BlockType.FIRST_MATCHING
            else -> throw AssertionError("Block has no block type")
        }

    override fun visitBlockElement(ctx: LscParser.BlockElementContext): AstNode =
        if (ctx.block() != null) visit(ctx.block()!!) else visit(ctx.expressionList()!!)

    override fun visitExpressionList(ctx: LscParser.ExpressionListContext): AstNode =
        walkExpressionList(ctx.text, listVisit(ctx.expression()))

    override fun visitExpression(ctx: LscParser.ExpressionContext): AstNode =
        visit(ctx.getChild(0))

    override fun visitKeywordExpression(ctx: LscParser.KeywordExpressionContext): AstNode =
        if (ctx.UNCHANGED() != null) {
            walkDoNothingExpression()
        } else {
            throw LscNotParsable(
                ctx.start.line,
                ctx.start.charPositionInLine,
                ctx.text,
                "The rule needs an arrow"
            )
        }

    override fun visitBlockRef(ctx: LscParser.BlockRefContext): AstNode =
        walkBlockReference(ctx.ruleName().text)

    override fun visitStandardExpression(ctx: LscParser.StandardExpressionContext): AstNode =
        walkRuleExpression(
            ctx.text,
            visit(ctx.from()),
            visit(ctx.to()),
            optionalVisit(ctx.compoundEnvironment()),
        )

    override fun visitFrom(ctx: LscParser.FromContext): AstNode =
        visit(ctx.ruleElement())

    override fun visitTo(ctx: LscParser.ToContext): AstNode =
        visit(ctx.unconditionalRuleElement())

    override fun visitRuleElement(ctx: LscParser.RuleElementContext): AstNode =
        ctx.compoundEnvironment()?.let { env ->
            walkLookaround(
                ctx.text,
                visit(ctx.unconditionalRuleElement()),
                visit(env)
            )
        } ?: visit(ctx.unconditionalRuleElement())

    override fun visitUnconditionalRuleElement(ctx: LscParser.UnconditionalRuleElementContext): AstNode =
        visit(ctx.getChild(0))

    override fun visitBounded(ctx: LscParser.BoundedContext): AstNode =
        visit(ctx.getChild(0))

    override fun visitGroup(ctx: LscParser.GroupContext): AstNode =
        visit(ctx.ruleElement())

    override fun visitList(ctx: LscParser.ListContext): AstNode =
        walkRuleList(
            ctx.text,
            listVisit(ctx.ruleElement()),
        )

    override fun visitSequence(ctx: LscParser.SequenceContext): AstNode =
        walkRuleSequence(ctx.text, listVisit(ctx.freeElement()))

    override fun visitFreeElement(ctx: LscParser.FreeElementContext): AstNode =
        visit(ctx.getChild(0))

    override fun visitCompoundEnvironment(ctx: LscParser.CompoundEnvironmentContext): AstNode =
        walkCompoundEnvironment(
            ctx.text,
            optionalVisit(ctx.condition()),
            optionalVisit(ctx.exclusion()),
        )

    override fun visitCondition(ctx: LscParser.ConditionContext): AstNode =
        visit(ctx.getChild(1))

    override fun visitExclusion(ctx: LscParser.ExclusionContext): AstNode =
        visit(ctx.getChild(1))

    override fun visitEnvironmentList(ctx: LscParser.EnvironmentListContext): AstNode =
        AstNodeList(listVisit(ctx.environment()))

    override fun visitEnvironment(ctx: LscParser.EnvironmentContext): AstNode {
        if (ctx.ANCHOR() == null) {
            val ruleName = ctx.upToType<LscParser.ChangeRuleContext>().downToType<LscParser.RuleNameContext>()?.text
            throw LscNotParsable(
                ctx.start.line, ctx.start.charPositionInLine + 1, ctx.text,
                "The environment \"${ctx.text}\" in rule $ruleName needs an underscore"
            )
        }
        return walkRuleEnvironment(
            ctx.text,
            optionalVisit(ctx.environmentBefore()),
            optionalVisit(ctx.environmentAfter()),
        )
    }

    override fun visitEnvironmentBefore(ctx: LscParser.EnvironmentBeforeContext): AstNode =
        visit(ctx.unconditionalRuleElement())

    override fun visitEnvironmentAfter(ctx: LscParser.EnvironmentAfterContext): AstNode =
        visit(ctx.unconditionalRuleElement())

    override fun visitInterfix(ctx: LscParser.InterfixContext): AstNode {
        val (interfixType, negations) = checkUniformInterfixType(ctx.interfixType())
        return walkInterfix(
            ctx.text,
            interfixType,
            listVisit(ctx.interfixElement()),
            negations,
        )
    }

    private fun checkUniformInterfixType(
        interfixCtxs: List<LscParser.InterfixTypeContext>
    ): Pair<InterfixType, List<Boolean>> {
        val interfixTypes = interfixCtxs.map { getInterfixType(it) }
        val looseInterfixTypes = interfixTypes.map {
            if (it == InterfixType.INTERSECTION_NOT) InterfixType.INTERSECTION
            else it
        }
        val uniformType = checkUniformType(looseInterfixTypes) { firstType, laterType, laterIndex ->
            val offendingOperator = interfixCtxs[laterIndex]
            throw LscNotParsable(
                offendingOperator.start.line,
                offendingOperator.start.charPositionInLine,
                laterType.text,
                "Can't mix ${firstType.text} and ${laterType.text}; use parentheses"
            )
        }
        val negations = interfixTypes.map {
            it == InterfixType.INTERSECTION_NOT
        }
        return uniformType to negations
    }

    private fun getInterfixType(ctx: LscParser.InterfixTypeContext) =
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

    override fun visitInterfixElement(ctx: LscParser.InterfixElementContext): AstNode =
        visit(ctx.getChild(0))

    override fun visitNegated(ctx: LscParser.NegatedContext): AstNode =
        walkNegatedElement(
            ctx.text,
            visit(ctx.getChild(1)),
        )

    override fun visitPostfix(ctx: LscParser.PostfixContext): AstNode =
        visit(ctx.getChild(0))

    override fun visitCapture(ctx: LscParser.CaptureContext): AstNode =
        walkRuleCapture(
            ctx.text,
            visit(ctx.getChild(0)),
            visit(ctx.captureRef()),
        )

    override fun visitRepeater(ctx: LscParser.RepeaterContext): AstNode =
        walkRuleRepeater(ctx.text, visit(ctx.getChild(0)), visit(ctx.repeaterType()))

    override fun visitSimple(ctx: LscParser.SimpleContext): AstNode =
        walkSimpleElement(visit(ctx.getChild(0)))

    override fun visitAnySyllable(ctx: LscParser.AnySyllableContext): AstNode =
        walkAnySyllable()

    override fun visitElementRef(ctx: LscParser.ElementRefContext): AstNode =
        walkElementReference(
            ctx.text,
            visit(ctx.name()),
        )

    override fun visitCaptureRef(ctx: LscParser.CaptureRefContext): AstNode =
        walkCaptureReference(
            ctx.text,
            ctx.NUMBER().toInt(),
            ctx.INEXACT() == null,
            ctx.SYLLABLE_BOUNDARY() != null,
        )

    override fun visitFancyMatrix(ctx: LscParser.FancyMatrixContext): AstNode =
        walkMatrix(
            ctx.text,
            listVisit(ctx.fancyValue()),
        )

    override fun visitFancyValue(ctx: LscParser.FancyValueContext): AstNode =
        visit(ctx.getChild(0))

    override fun visitNegatedValue(ctx: LscParser.NegatedValueContext): AstNode =
        walkNegatedValue(
            ctx.text,
            visit(ctx.matrixValue()),
        )

    override fun visitAbsentFeature(ctx: LscParser.AbsentFeatureContext): AstNode =
        walkAbsentFeature(
            ctx.text,
            visit(ctx.name()),
        )

    override fun visitFeatureVariable(ctx: LscParser.FeatureVariableContext): AstNode =
        walkFeatureVariable(
            ctx.text,
            visit(ctx.name()),
        )

    override fun visitEmpty(ctx: LscParser.EmptyContext): AstNode = walkEmpty()

    override fun visitSylBoundary(ctx: LscParser.SylBoundaryContext): AstNode = walkSyllableBoundary()

    override fun visitBoundary(ctx: LscParser.BoundaryContext): AstNode = walkBoundary()

    override fun visitBetweenWords(ctx: LscParser.BetweenWordsContext): AstNode = walkBetweenWords()

    override fun visitRepeaterType(ctx: LscParser.RepeaterTypeContext): AstNode =
        optionalVisit(ctx.repeatRange()) ?: walkRepeaterType(
            ctx.text,
            when {
                ctx.AT_LEAST_ONE() != null -> StandardRepeaterType.ONE_OR_MORE
                ctx.NULL() != null -> StandardRepeaterType.ZERO_OR_MORE
                ctx.OPTIONAL() != null -> StandardRepeaterType.ZERO_OR_ONE
                else -> throw AssertionError()
            }
        )

    override fun visitRepeatRange(ctx: LscParser.RepeatRangeContext): AstNode =
        walkRepeaterType(
            ctx.text,
            ctx.NUMBER()?.let {
                val number = it.toInt()
                FlexibleRepeaterType(number, number)
            } ?: FlexibleRepeaterType(
                ctx.lowerBound()?.toInt() ?: 0,
                ctx.upperBound()?.toInt()
            )
        )

    override fun visitMatrix(ctx: LscParser.MatrixContext): AstNode =
        walkMatrix(
            ctx.text,
            listVisit(ctx.matrixValue()),
        )

    override fun visitMatrixValue(ctx: LscParser.MatrixValueContext): AstNode =
        visit(ctx.getChild(0))

    override fun visitPlusFeatureValue(ctx: LscParser.PlusFeatureValueContext): AstNode =
        walkPlusFeatureValue(
            ctx.text,
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

    override fun visitFeatureValue(ctx: LscParser.FeatureValueContext): AstNode =
        walkFeatureValue(
            ctx.text,
            visit(ctx.name()),
        )

    override fun visitName(ctx: LscParser.NameContext): AstNode =
        walkName(
            ctx.text,
            ctx.text,
        )

    override fun visitText(ctx: LscParser.TextContext): AstNode =
        walkText(ctx.text, removeEscapes(ctx.getChild(0).text), ctx.NEGATION() != null)

    private fun removeEscapes(text: String): String =
        text.split("\\\\").joinToString("\\") {
            it.replace("\\", "")
        }

    private fun walkFile(
        text: String,
        featureDeclarations: List<AstNode>,
        diacriticDeclarations: List<AstNode>,
        symbolDeclarations: List<AstNode>,
        classDeclarations: List<AstNode>,
        elementDeclarations: List<AstNode>,
        deromanizer: AstNode?,
        changeRules: List<RuleWithAnchoredStatements>,
        romanizer: AstNode?,
    ): AstNode = SoundChangerNodeImpl(
        text,
        featureDeclarations = featureDeclarations,
        diacriticDeclarations = diacriticDeclarations,
        symbolDeclarations = symbolDeclarations,
        classDeclarations = classDeclarations,
        elementDeclarations = elementDeclarations,
        deromanizer = deromanizer,
        changeRules = changeRules,
        romanizer = romanizer,
    )

    private fun walkElementDeclaration(
        text: String,
        className: AstNode,
        element: AstNode,
    ): AstNode =
        ElementDeclarationNode(
            text,
            (className as NameNode).name,
            element,
        )

    private fun walkClassDeclaration(
        text: String,
        className: AstNode,
        elements: List<AstNode>,
    ): AstNode =
        ClassDeclarationNode(
            text,
            (className as NameNode).name,
            elements,
        )

    private fun walkFeatureDeclaration(
        text: String,
        featureName: AstNode,
        nullAlias: AstNode?,
        values: List<AstNode>,
        level: AstNode?,
    ): AstNode = FeatureDeclarationNode(
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
        featureName: AstNode,
        plusOnly: Boolean,
        level: AstNode?,
    ): AstNode {
        val name = (featureName as NameNode).name
        val featureLevel = (level as FeatureLevelNode?)?.level ?: WordLevel.SEGMENT
        val feature = if (plusOnly) {
            Feature.plusOnly(name, featureLevel)
        } else {
            Feature.plusMinus(name, featureLevel)
        }
        return FeatureDeclarationNode(text, feature)
    }

    private fun walkDiacriticDeclaration(
        text: String,
        diacritic: String,
        matrix: AstNode,
        position: ModifierPosition,
        floating: Boolean,
    ): AstNode =
        DiacriticDeclarationNode(
            text,
            Diacritic(diacritic, (matrix as MatrixNode).matrix, position, floating),
        )

    private fun walkSymbolDeclaration(
        text: String,
        symbol: String,
        matrix: AstNode?,
    ): AstNode =
        SymbolDeclarationNode(
            text,
            Symbol(symbol, (matrix as? MatrixNode)?.matrix),
        )

    private fun walkSyllableDecl(
        text: String,
        patterns: List<AstNode>?,
    ): AstNode =
        SyllableStructureNode(text, patterns?.map { it as SyllableExpressionNode })

    private fun walkSyllableExpression(
        text: String,
        pattern: AstNode,
        environment: AstNode?,
        matrix: AstNode?,
    ): AstNode {
        val patternNode = when (pattern) {
            is Element -> environment?.let {
                SimpleSyllablePatternNode(
                    text,
                    EnvironmentElement(
                        text,
                        pattern,
                        it as CompoundEnvironmentNode
                    )
                )
            } ?: SimpleSyllablePatternNode(text, pattern)
            is StructuredSyllablePatternNode -> environment?.let {
                StructuredSyllablePatternNode(
                    text,
                    reluctantOnset = pattern.reluctantOnset,
                    onset = pattern.onset,
                    nucleus = pattern.nucleus,
                    coda = pattern.coda,
                    environment = it as CompoundEnvironmentNode,
                )
            } ?: pattern
            else -> throw AssertionError("Invalid syllable pattern")
        }
        return SyllableExpressionNode(
            text,
            patternNode,
            matrix as MatrixNode?,
        )
    }

    private fun walkDeromanizer(
        text: String,
        subRules: List<AstNode>,
        literal: Boolean,
    ): AstNode =
        UnlinkedDeromanizer(
            text,
            subRules.map { it as UnlinkedRule },
            literal
        )

    private fun walkRomanizer(
        text: String,
        subRules: List<AstNode>,
        literal: Boolean
    ): AstNode =
        UnlinkedRomanizer(
            text,
            subRules.map { it as UnlinkedRule },
            literal
        )

    private fun walkIntermediateRomanizer(
        text: String,
        ruleName: String,
        subRules: List<AstNode>,
        literal: Boolean
    ): AstNode =
        UnlinkedRomanizer(
            text,
            subRules.map { it as UnlinkedRule },
            literal,
            stageName = ruleName,
        )

    private fun walkChangeRule(
        text: String,
        ruleName: String,
        mainBlock: AstNode,
        modifiers: RuleModifiers,
    ): AstNode = UnlinkedStandardRule(
        text,
        ruleName,
        mainBlock as UnlinkedRule,
        ruleFilter = when (modifiers.ruleFilter) {
            is MatrixNode -> MatrixElement(
                modifiers.ruleFilter.text, modifiers.ruleFilter.matrix
            )
            else -> modifiers.ruleFilter as Element?
        },
        matchMode = modifiers.matchMode,
        propagate = modifiers.isPropagate,
        cleanup = modifiers.isCleanup,
        deferred = modifiers.isDeferred,
    )

    private fun walkBlock(
        text: String,
        blockType: BlockType,
        subRules: List<AstNode>,
    ): AstNode =
        when (blockType) {
            BlockType.SEQUENTIAL -> UnlinkedSequentialBlock(
                text,
                subRules.map { it as UnlinkedRule }
            )
            BlockType.FIRST_MATCHING -> UnlinkedFirstMatchingBlock(
                text,
                subRules.map { it as UnlinkedRule }
            )
        }

    private fun walkExpressionList(text: String, expressions: List<AstNode>): AstNode =
        UnlinkedSimpleChangeRule(text, expressions.map { it as ExpressionNode })

    private fun walkDoNothingExpression(): AstNode =
        UnlinkedRuleExpression(
            "unchanged",
            DoNothingElement,
            DoNothingElement,
            CompoundEnvironmentNode("", emptyList(), emptyList())
        )

    private fun walkBlockReference(name: String): AstNode =
        BlockReference(name)

    private fun walkRuleExpression(
        text: String,
        ruleFrom: AstNode,
        ruleTo: AstNode,
        compoundEnvironment: AstNode?,
    ): AstNode = UnlinkedRuleExpression(
        text,
        ruleFrom as Element,
        ruleTo as Element,
        compoundEnvironment as CompoundEnvironmentNode?,
    )

    private fun walkRuleEnvironment(
        text: String,
        before: AstNode?,
        after: AstNode?,
    ): AstNode = EnvironmentNode(
        text,
        (before as? Element),
        (after as? Element),
    )

    private fun walkRuleSequence(
        text: String,
        items: List<AstNode>
    ): AstNode =
        SequenceElement(
            text,
            items.map { it as Element }
        )

    private fun walkLookaround(
        text: String,
        element: AstNode,
        environment: AstNode,
    ): AstNode =
        EnvironmentElement(
            text,
            element as Element,
            environment as CompoundEnvironmentNode,
        )

    private fun walkCompoundEnvironment(
        text: String,
        positive: AstNode?,
        negative: AstNode?,
    ): AstNode =
        CompoundEnvironmentNode(
            text,
            walkEnvironmentOrEnvironmentList(positive),
            walkEnvironmentOrEnvironmentList(negative),
        )

    private fun walkEnvironmentOrEnvironmentList(node: AstNode?): List<EnvironmentNode> =
        when (node) {
            null -> emptyList()
            is EnvironmentNode -> listOf(node)
            is AstNodeList -> node.elements.map { it as EnvironmentNode }
            else -> throw AssertionError()
        }

    private fun walkRuleCapture(
        text: String,
        item: AstNode,
        capture: AstNode
    ): AstNode = when (item) {
        is MatrixNode ->
            CaptureElement(
                text,
                MatrixElement(item.text, item.matrix),
                capture as CaptureReferenceElement
            )
        else ->
            CaptureElement(
                text,
                item as Element,
                capture as CaptureReferenceElement
            )
    }

    private fun walkRuleRepeater(
        text: String,
        item: AstNode,
        repeaterType: AstNode
    ): AstNode =
        RepeaterElement(
            text,
            item as Element,
            repeaterType as RepeaterTypeNode
        )

    private fun walkRuleList(
        text: String,
        items: List<AstNode>,
    ): AstNode =
        AlternativeElement(
            text,
            items.map { it as Element },
        )

    private fun walkInterfix(
        text: String,
        interfixType: InterfixType,
        items: List<AstNode>,
        negations: List<Boolean>,
    ): AstNode =
        when (interfixType) {
            InterfixType.INTERSECTION ->
                IntersectionElement(
                    text,
                    items.first() as Element,
                    items.drop(1).zip(negations) { item, negated ->
                        MatchVerifierElement(item as Element, negated)
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
        element: AstNode,
    ): AstNode = when (element) {
        is TextNode -> TextElement(element.text, element.literalText, element.isExact)
        is MatrixNode -> MatrixElement(element.text, element.matrix)
        else -> element
    }

    private fun walkNegatedElement(
        text: String,
        element: AstNode,
    ): AstNode = NegatedElement(
        text,
        when (element) {
            is TextNode -> TextElement(element.text, element.literalText, element.isExact)
            else -> element as Element
        }
    )

    private fun walkNegatedValue(
        text: String,
        value: AstNode,
    ): AstNode =
        MatrixValueNode(
            text,
            NegatedValue((value as SimpleValueNode).simpleValue.name)
        )

    private fun walkAbsentFeature(
        text: String,
        feature: AstNode,
    ): AstNode =
        MatrixValueNode(
            text,
            SimpleValue.absent((feature as NameNode).name)
        )

    private fun walkFeatureVariable(
        text: String,
        feature: AstNode,
    ): AstNode =
        MatrixValueNode(
            text,
            FeatureVariable((feature as NameNode).name)
        )

    private fun walkEmpty(): AstNode = EmptyElement

    private fun walkSyllableBoundary(): AstNode = SyllableBoundaryElement

    private fun walkBoundary(): AstNode = WordBoundaryElement

    private fun walkBetweenWords(): AstNode = BetweenWordsElement

    private fun walkAnySyllable(): AstNode = SyllableElement

    private fun walkElementReference(
        text: String,
        value: AstNode
    ): AstNode =
        ElementReferenceElement(
            text,
            (value as NameNode).name
        )

    private fun walkCaptureReference(
        text: String,
        number: Int,
        exact: Boolean,
        captureSyllableStructure: Boolean,
    ): AstNode =
        CaptureReferenceElement(text, number, exact, captureSyllableStructure)

    private fun walkRepeaterType(
        text: String,
        type: RepeaterType,
    ): AstNode =
        RepeaterTypeNode(text, type)

    private fun walkMatrix(
        text: String,
        values: List<AstNode>,
    ): AstNode =
        MatrixNode(
            text,
            Matrix(values.map { (it as MatrixValueNode).value })
        )

    private fun walkPlusFeatureValue(
        text: String,
        name: AstNode,
        plusMinus: PlusMinus,
    ): AstNode =
        SimpleValueNode(text, SimpleValue(plusMinus.string + (name as NameNode).name))

    private fun walkFeatureValue(
        text: String,
        name: AstNode,
    ): AstNode = SimpleValueNode(text, SimpleValue((name as NameNode).name))

    private fun walkName(
        text: String,
        name: String,
    ): AstNode = NameNode(text, name)

    private fun walkText(
        text: String,
        literalText: String,
        exact: Boolean,
    ): AstNode = TextNode(text, literalText, exact)

    private data class AstNodeList(
        val elements: List<AstNode>
    ) : BaseAstNode(elements.joinToString())

    interface SoundChangerNode {
        val soundChanger: SoundChanger
    }

    private class SoundChangerNodeImpl(
        text: String,
        private val featureDeclarations: List<AstNode>,
        private val diacriticDeclarations: List<AstNode>,
        private val symbolDeclarations: List<AstNode>,
        private val classDeclarations: List<AstNode>,
        private val elementDeclarations: List<AstNode>,
        private val deromanizer: AstNode?,
        private val changeRules: List<RuleWithAnchoredStatements>,
        private val romanizer: AstNode?,
    ) : BaseAstNode(text), SoundChangerNode {

        override val soundChanger: SoundChanger
            get() {
                val initialDeclarations = Declarations.create(
                    featureDeclarations.flatMap { sublist ->
                        (sublist as AstNodeList).elements.map { (it as FeatureDeclarationNode).feature }
                    },
                    diacriticDeclarations.map { (it as DiacriticDeclarationNode).diacritic },
                    symbolDeclarations.flatMap { sublist ->
                        (sublist as AstNodeList).elements.map { (it as SymbolDeclarationNode).symbol }
                    },
                )

                val declaredElements = resolveElements(
                    classDeclarations.map { it as ClassDeclarationNode },
                    elementDeclarations.map { it as ElementDeclarationNode },
                )

                val (declaredBlocks, realChangeRules) = resolveBlocks(changeRules)

                fun Declarations.withElements() =
                    ParseTimeDeclarations(declaredElements, declaredBlocks, this)

                val firstAnchoredStatement = realChangeRules.firstOrNull()?.statements?.firstOrNull()

                val initialSyllabifiedDeclarations =
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

                var declarations = initialSyllabifiedDeclarations

                val linkedDeromanizer = (deromanizer as UnlinkedDeromanizer?)?.let {
                    SoundChanger.plainRule(
                        it.link(
                            firstExpressionNumber = 1,
                            declarations.withElements(),
                            InheritedRuleProperties.none,
                        ) as NamedRule
                    )
                }

                val realInitialDeclarations = linkedDeromanizer?.rule?.declarations
                    ?: initialSyllabifiedDeclarations

                val linkedRules = realChangeRules.map { rule ->
                    val anchoredSteps = rule.statements.map { anchoredStatement ->
                        when (anchoredStatement) {
                            is UnlinkedRomanizer -> IntermediateRomanizerStep(
                                anchoredStatement.link(
                                    1, declarations.withElements(), InheritedRuleProperties.none
                                ) as IntermediateRomanizer
                            )
                            is UnlinkedStandardRule -> {
                                CleanupStep(
                                    anchoredStatement.link(
                                        1, declarations.withElements(), InheritedRuleProperties.none
                                    ) as NamedRule
                                )
                            }
                            is UnlinkedCleanupOffStep -> {
                                CleanupOffStep(anchoredStatement.ruleName)
                            }
                            is SyllableStructureNode -> {
                                declarations = initialDeclarations.withSyllabifier(
                                    anchoredStatement.syllabifier(initialDeclarations.withElements())
                                )
                                SyllabificationStep(declarations)
                            }
                            else -> throw AssertionError("Unrecognized anchored statement $anchoredStatement")
                        }
                    }
                    val linkedRule = (rule.rule as UnlinkedRule?)?.link(
                        1, declarations.withElements(), InheritedRuleProperties.none
                    ) as NamedRule?
                    RuleWithAnchoredSteps(linkedRule, anchoredSteps)
                }

                val linkedRomanizer = (romanizer as UnlinkedRomanizer?)?.let {
                    SoundChanger.plainRule(
                        it.link(
                            1, declarations.withElements(), InheritedRuleProperties.none
                        ) as NamedRule
                    )
                }

                val allLinkedRules =
                    listOfNotNull(linkedDeromanizer) + linkedRules + listOfNotNull(linkedRomanizer)

                return SoundChanger(
                    realInitialDeclarations,
                    allLinkedRules,
                )
            }

        private fun resolveElements(
            classDeclarations: List<ClassDeclarationNode>,
            elementDeclarations: List<ElementDeclarationNode>,
        ): Map<String, Element> {
            val definedClassSounds = mutableMapOf<String, List<String>>()
            val definedClasses = mutableMapOf<String, AlternativeElement>()
            val allClassNames = classDeclarations.map { it.name }.toSet()

            val definedElements = mutableMapOf<String, Element>()
            val allNonClassElementNames = elementDeclarations.map { it.name }.toSet()
            val allElementNames = allNonClassElementNames + allClassNames

            for (classNode in classDeclarations) {
                val newClassSounds = classNode.elements.flatMap {
                    if (it is TextNode) listOf(it.literalText)
                    else {
                        val nestedName = (it as ElementReferenceElement).name
                        definedClassSounds[nestedName] ?: if (nestedName in allNonClassElementNames) {
                            throw LscIllegalStructure(
                                "non-class elements",
                                nestedName,
                                "in class declarations like \"${classNode.name}\"",
                            )
                        } else {
                            throw LscUndefinedName(
                                "class", nestedName, nestedName in allClassNames
                            )
                        }
                    }
                }
                if (classNode.name in definedClasses) throw LscDuplicateName("class", classNode.name)
                definedClassSounds[classNode.name] = newClassSounds
                definedClasses[classNode.name] = AlternativeElement(
                    classNode.text,
                    newClassSounds.map { TextElement(it, it) }
                )
            }

            val definedElementNames = mutableSetOf<String>().also {
                it.addAll(definedClasses.keys)
            }
            for (elementNode in elementDeclarations) {
                val elementDefinition = elementNode.element as Element
                checkElementsDefined(elementDefinition, definedElementNames, allElementNames)
                definedElements[elementNode.name] = elementDefinition
                definedElementNames += elementNode.name
            }
            return definedClasses + definedElements
        }

        private fun checkElementsDefined(
            element: Element,
            definedElementNames: Set<String>,
            allElementNames: Set<String>,
        ) {
            if (element is ElementReferenceElement) {
                val name = element.name
                if (name !in definedElementNames) {
                    throw LscUndefinedName("element", name, name in allElementNames)
                }
            } else {
                for (subElement in element.subElements) {
                    checkElementsDefined(subElement, definedElementNames, allElementNames)
                }
            }
        }

        private fun resolveBlocks(
            rules: List<RuleWithAnchoredStatements>,
        ): Pair<Map<String, UnlinkedStandardRule>, List<RuleWithAnchoredStatements>> {
            val (blocks, realRules) = rules.partition {
                it.rule is UnlinkedStandardRule && it.rule.deferred
            }

            val definedBlockNames = mutableSetOf<String>()
            val allBlockNames = blocks.map { (it.rule as UnlinkedStandardRule).name }.toSet()

            for (rule in rules) {
                val coreRule = rule.rule
                if (coreRule is UnlinkedStandardRule && coreRule.deferred) {
                    definedBlockNames += coreRule.name
                }
                if (coreRule != null) {
                    checkBlocksDefined(coreRule as UnlinkedRule, definedBlockNames, allBlockNames)
                }
                for (anchoredStatement in rule.statements) {
                    if (anchoredStatement is UnlinkedRule) {
                        checkBlocksDefined(anchoredStatement, definedBlockNames, allBlockNames)
                    }
                }
            }

            val declaredBlocks = blocks.associate {
                it.rule as UnlinkedStandardRule
                it.rule.name to it.rule
            }

            return declaredBlocks to realRules
        }

        private fun checkBlocksDefined(
            rule: UnlinkedRule,
            definedBlockNames: Set<String>,
            allBlockNames: Set<String>,
        ) {
            when (rule) {
                is BlockReference -> {
                    val name = rule.name
                    if (name !in definedBlockNames) {
                        throw LscUndefinedName("block", name, name in allBlockNames)
                    }
                }
                is UnlinkedSimpleChangeRule ->
                    for (expression in rule.expressions) {
                        if (expression is BlockReference) {
                            val name = expression.name
                            if (name !in definedBlockNames) {
                                throw LscUndefinedName("block", name, name in allBlockNames)
                            }
                        }
                    }
                else -> for (subRule in rule.subRules) {
                    checkBlocksDefined(subRule, definedBlockNames, allBlockNames)
                }
            }
        }
    }

    private class FeatureDeclarationNode(
        text: String,
        val feature: Feature,
    ) : BaseAstNode(text)

    private class FeatureLevelNode(
        text: String,
        val level: WordLevel,
    ) : BaseAstNode(text)

    private class DiacriticDeclarationNode(
        text: String,
        val diacritic: Diacritic,
    ) : BaseAstNode(text)

    private class SymbolDeclarationNode(
        text: String,
        val symbol: Symbol,
    ) : BaseAstNode(text)

    private class ClassDeclarationNode(
        text: String,
        val name: String,
        val elements: List<AstNode>,
    ) : BaseAstNode(text)

    private class ElementDeclarationNode(
        text: String,
        val name: String,
        val element: AstNode,
    ) : BaseAstNode(text)

    private class SyllableStructureNode(
        text: String,
        val patterns: List<SyllableExpressionNode>?,
    ) : BaseAstNode(text) {
        fun syllabifier(declarations: ParseTimeDeclarations): Syllabifier? =
            patterns?.let { notNullPatterns ->
                Syllabifier(
                    declarations.runtime,
                    notNullPatterns.map { it.syllabifierPattern(declarations) }
                )
            }
    }

    private class SyllableExpressionNode(
        text: String,
        val pattern: SyllablePatternNode,
        val matrix: MatrixNode?,
    ) : BaseAstNode(text) {
        fun syllabifierPattern(declarations: ParseTimeDeclarations): Syllabifier.Pattern =
            pattern.syllabifierPattern(declarations, matrix?.matrix)
    }

    private interface SyllablePatternNode {
        fun syllabifierPattern(
            declarations: ParseTimeDeclarations,
            matrix: Matrix?
        ): Syllabifier.Pattern
    }

    private class SimpleSyllablePatternNode(
        text: String,
        val element: Element,
    ) : BaseAstNode(text), SyllablePatternNode {
        override fun syllabifierPattern(
            declarations: ParseTimeDeclarations,
            matrix: Matrix?
        ): Syllabifier.SimplePattern =
            Syllabifier.SimplePattern(
                element.matcher(ElementContext.aloneInMain(), declarations),
                matrix,
            )
    }

    private class StructuredSyllablePatternNode(
        text: String,
        val reluctantOnset: Element?,
        val onset: Element,
        val nucleus: Element,
        val coda: Element?,
        val environment: CompoundEnvironmentNode? = null,
    ) : BaseAstNode(text), SyllablePatternNode {
        override fun syllabifierPattern(
            declarations: ParseTimeDeclarations,
            matrix: Matrix?
        ): Syllabifier.StructuredPattern =
            Syllabifier.StructuredPattern(
                onset.matcher(ElementContext.aloneInMain(), declarations),
                nucleus.matcher(ElementContext.aloneInMain(), declarations),
                coda?.matcher(ElementContext.aloneInMain(), declarations),
                reluctantOnset = reluctantOnset?.matcher(ElementContext.aloneInMain(), declarations),
                environment = environment?.link(declarations),
                assignedMatrix = matrix,
            )
    }

    internal interface UnlinkedRule : AstNode {
        val numExpressions: Int

        fun link(
            firstExpressionNumber: Int,
            declarations: ParseTimeDeclarations,
            inherited: InheritedRuleProperties,
        ): ChangeRule

        val subRules: List<UnlinkedRule>
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

    internal abstract class BaseUnlinkedRule(
        text: String,
        final override val subRules: List<UnlinkedRule>,
    ) : BaseAstNode(text), UnlinkedRule {

        val cumulativeNumExpressions: List<Int> =
            subRules.scan(0) { acc, cur -> acc + cur.numExpressions }
        override val numExpressions: Int = cumulativeNumExpressions.last()

        fun linkSubRules(
            firstExpressionNumber: Int,
            linker: (Int, UnlinkedRule, Int) -> ChangeRule,
        ): List<ChangeRule> {
            return subRules.mapIndexed { index, subRule ->
                val expressionNumber = cumulativeNumExpressions[index]
                val subFirstExpressionNumber = firstExpressionNumber + expressionNumber
                linker(
                    index,
                    subRule,
                    subFirstExpressionNumber,
                )
            }
        }
    }

    private class UnlinkedSimpleChangeRule(
        override val text: String,
        val expressions: List<ExpressionNode>,
        val matchMode: MatchMode = MatchMode.SIMULTANEOUS,
    ) : UnlinkedRule {
        override val numExpressions: Int = expressions.size

        override fun link(
            firstExpressionNumber: Int,
            declarations: ParseTimeDeclarations,
            inherited: InheritedRuleProperties,
        ): ChangeRule =
            if (expressions.singleOrNull() is BlockReference) {
                (expressions.single() as BlockReference).link(
                    firstExpressionNumber, declarations, inherited
                )
            } else {
                SimpleChangeRule(
                    declarations.runtime,
                    expressions.flatMapIndexed { index, expression ->
                        inlineBlockReferences(declarations, expression).map {
                            it.link(
                                inherited.name!!,
                                firstExpressionNumber + index,
                                declarations,
                                inherited.filter != null,
                            )
                        }
                    },
                    inherited.filter,
                    matchMode,
                )
            }

        private fun inlineBlockReferences(
            declarations: ParseTimeDeclarations,
            expression: ExpressionNode,
        ): List<UnlinkedRuleExpression> =
            when (expression) {
                is UnlinkedRuleExpression -> listOf(expression)
                is BlockReference -> {
                    val block = declarations.dereferenceBlock(expression.name).mainBlock
                    if (block !is UnlinkedSimpleChangeRule) {
                        throw LscIllegalStructure(
                            "complex block reference",
                            expression.text,
                            "in a group of simultaneous expressions"
                        )
                    }
                    block.expressions.flatMap { inlineBlockReferences(declarations, it) }
                }
            }

        fun withMatchMode(matchMode: MatchMode): UnlinkedSimpleChangeRule =
            UnlinkedSimpleChangeRule(text, expressions, matchMode)

        override val subRules: List<UnlinkedRule>
            get() = emptyList()
    }

    private fun UnlinkedRule.tryWithMatchMode(matchMode: MatchMode): UnlinkedRule =
        if (matchMode == MatchMode.SIMULTANEOUS) this else
        when (this) {
            is UnlinkedSimpleChangeRule -> withMatchMode(matchMode)
            else -> throw LscIllegalNestedModifier(matchMode.string)
        }

    private class UnlinkedDeromanizer(
        text: String,
        subRules: List<UnlinkedRule>,
        val literal: Boolean,
    ) : BaseUnlinkedRule(text, subRules) {

        val name: String = "<deromanizer>"

        override fun link(
            firstExpressionNumber: Int,
            declarations: ParseTimeDeclarations,
            inherited: InheritedRuleProperties,
        ): ChangeRule {
            val linkedSubRules = linkSubRules(
                firstExpressionNumber,
            ) { index, subRule, subFirstExpressionNumber ->
                if (literal && index == 0) {
                    subRule.link(subFirstExpressionNumber, ParseTimeDeclarations.empty, inherited.copy(name = name))
                } else {
                    subRule.link(subFirstExpressionNumber, declarations, inherited.copy(name = name))
                }
            }
            return if (literal) {
                val subRulesWithRedeclaration =
                    listOf(linkedSubRules.first()) + Redeclaration(declarations.runtime) + linkedSubRules.drop(1)
                return StandardNamedRule(
                    name,
                    Declarations.empty,
                    SequentialBlock(subRulesWithRedeclaration),
                    ruleType = RuleType.DEROMANIZER,
                )
            } else {
                StandardNamedRule(
                    name,
                    declarations.runtime,
                    SequentialBlock(linkedSubRules),
                    ruleType = RuleType.DEROMANIZER,
                )
            }
        }
    }

    private class UnlinkedRomanizer(
        text: String,
        subRules: List<UnlinkedRule>,
        val literal: Boolean,
        val stageName: String? = null,
    ) : BaseUnlinkedRule(text, subRules) {

        val name: String = stageName?.let { "<romanizer>-$it" } ?: "<romanizer>"

        override fun link(
            firstExpressionNumber: Int,
            declarations: ParseTimeDeclarations,
            inherited: InheritedRuleProperties
        ): ChangeRule {
            val linkedSubRules = linkSubRules(
                firstExpressionNumber,
            ) { index, subRule, subFirstExpressionNumber ->
                if (literal && index == subRules.size - 1) {
                    subRule.link(subFirstExpressionNumber, ParseTimeDeclarations.empty, inherited.copy(name = name))
                } else {
                    subRule.link(subFirstExpressionNumber, declarations, inherited.copy(name = name))
                }
            }
            val block = if (literal) {
                val subRulesWithRedeclaration =
                    linkedSubRules.dropLast(1) + Redeclaration(Declarations.empty) + linkedSubRules.last()
                SequentialBlock(subRulesWithRedeclaration)
            } else {
                SequentialBlock(linkedSubRules)
            }
            return if (stageName == null) {
                StandardNamedRule(
                    name,
                    declarations.runtime,
                    block,
                    ruleType = RuleType.ROMANIZER
                )
            } else {
                IntermediateRomanizer(
                    name,
                    stageName,
                    declarations.runtime,
                    block,
                    ruleType = RuleType.ROMANIZER
                )
            }
        }
    }

    internal class UnlinkedStandardRule(
        text: String,
        val name: String,
        val mainBlock: UnlinkedRule,
        val ruleFilter: Element?,
        val matchMode: MatchMode,
        val propagate: Boolean,
        val cleanup: Boolean,
        val deferred: Boolean,
    ) : BaseUnlinkedRule(text, listOf(mainBlock)) {

        override fun link(
            firstExpressionNumber: Int,
            declarations: ParseTimeDeclarations,
            inherited: InheritedRuleProperties
        ): ChangeRule {
            val filter = if (ruleFilter != null || inherited.filter != null) {
                val thisFilter = ruleFilter?.let { filter ->
                    { segment: Segment ->
                        filter.matcher(ElementContext.aloneInMain(), declarations).claim(
                            Phrase(StandardWord.single(segment)),
                            PhraseIndex(0, 0),
                            Bindings(),
                        ).any { it.index.segmentIndex == 1 }
                    }
                } ?: { true }
                val inheritedFilter = inherited.filter ?: { true }
                { segment: Segment ->
                    thisFilter(segment) && inheritedFilter(segment)
                }
            } else null

            val subRule = linkSubRules(
                firstExpressionNumber,
            ) { _, subRule, subFirstExpressionNumber ->
                subRule.tryWithMatchMode(matchMode).link(
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
                declarations.runtime,
                if (propagate) PropagateBlock(subRule) else subRule,
                filter = filter,
            )
        }
    }

    private class UnlinkedSequentialBlock(
        text: String,
        subRules: List<UnlinkedRule>,
    ) : BaseUnlinkedRule(text, subRules) {
        override fun link(
            firstExpressionNumber: Int,
            declarations: ParseTimeDeclarations,
            inherited: InheritedRuleProperties,
        ): ChangeRule =
            SequentialBlock(
                linkSubRules(
                    firstExpressionNumber,
                ) { _, subRule, subFirstExpressionNumber ->
                    subRule.link(subFirstExpressionNumber, declarations, inherited)
                }
            )
    }

    private class UnlinkedFirstMatchingBlock(
        text: String,
        subRules: List<UnlinkedRule>,
    ) : BaseUnlinkedRule(text, subRules) {
        override fun link(
            firstExpressionNumber: Int,
            declarations: ParseTimeDeclarations,
            inherited: InheritedRuleProperties,
        ): ChangeRule =
            WithinWordBlock(
                FirstMatchingBlock(
                    linkSubRules(
                        firstExpressionNumber,
                    ) { _, subRule, subFirstExpressionNumber ->
                        subRule.link(subFirstExpressionNumber, declarations, inherited)
                    }
                )
            )
    }

    private class UnlinkedPropagateBlock(
        val subRule: UnlinkedRule,
    ) : UnlinkedRule {
        override val numExpressions: Int = subRule.numExpressions

        override fun link(
            firstExpressionNumber: Int,
            declarations: ParseTimeDeclarations,
            inherited: InheritedRuleProperties
        ): ChangeRule = PropagateBlock(
            subRule.link(
                firstExpressionNumber,
                declarations,
                inherited,
            )
        )

        override val text: String = subRule.text

        override val subRules: List<UnlinkedRule> = listOf(subRule)
    }

    private class BlockReference(val name: String) : UnlinkedRule, ExpressionNode {
        override val numExpressions: Int = 1

        override fun link(
            firstExpressionNumber: Int,
            declarations: ParseTimeDeclarations,
            inherited: InheritedRuleProperties
        ): ChangeRule =
            declarations.dereferenceBlock(name).link(
                firstExpressionNumber, declarations, inherited
            )

        override val text: String = ":$name"

        override val subRules: List<UnlinkedRule> = emptyList()
    }

    private sealed interface ExpressionNode

    private class UnlinkedRuleExpression(
        text: String,
        val match: Element,
        val result: Element,
        val compoundEnvironment: CompoundEnvironmentNode?,
    ) : BaseAstNode(text), ExpressionNode {
        fun link(
            ruleName: String,
            expressionNumber: Int,
            declarations: ParseTimeDeclarations,
            filtered: Boolean,
        ): RuleExpression = try {
            val coreMatcher = match.matcher(ElementContext.aloneInMain(), declarations)
            val matcher = compoundEnvironment?.let { env ->
                EnvironmentMatcher(
                    coreMatcher,
                    env.link(declarations),
                )
            } ?: coreMatcher
            RuleExpression(
                declarations.runtime,
                matcher.transformerTo(
                    castToResultElement(result).emitter(declarations),
                    filtered,
                )
            )
        } catch (e: UserError) {
            throw LscInvalidRuleExpression(e, ruleName, text, expressionNumber)
        }
    }

    private fun listVisit(node: List<ParseTree>): List<AstNode> = node.map { visit(it) }

    private fun optionalVisit(node: ParseTree?): AstNode? = node?.let { visit(it) }

    private fun ParseTree.toInt(): Int = text.toIntOrNull() ?: throw LscNumberOverflow(text)
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

private class LscErrorListener : ANTLRErrorListener {
    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        e: RecognitionException?
    ): Nothing {
        val offendingToken = (offendingSymbol as? CommonToken)?.text ?: offendingSymbol.toString()
        throw LscNotParsable(
            line,
            charPositionInLine,
            offendingToken,
            msg
        )
    }

    override fun reportAttemptingFullContext(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        conflictingAlts: BitSet?,
        configs: ATNConfigSet?
    ) {
    }

    override fun reportAmbiguity(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        exact: Boolean,
        ambigAlts: BitSet?,
        configs: ATNConfigSet?
    ) {
    }

    override fun reportContextSensitivity(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        prediction: Int,
        configs: ATNConfigSet?
    ) {
    }
}

class ExpressionNotInRule(
    val expression: String,
) : LscUserError(
    "The expression \"${expression}\" isn't in a rule; put it after a line like \"rule-name:\""
)

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

class LscFutureStructure(val structureName: String) :
    LscUserError(
        "$structureName aren't implemented yet"
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

class LscIllegalStructureInFilteredRuleInput(
    invalidNodeType: String,
    invalidNode: String,
) : LscIllegalStructure(
    invalidNodeType,
    invalidNode,
    "on the match side of filtered rules"
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
