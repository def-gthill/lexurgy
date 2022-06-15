// This file is automatically generated from Lsc.g4. Don't modify it!

@file:Suppress("FunctionName", "unused", "PropertyName", "RemoveEmptyClassBody")

package com.meamoria.lexurgy.sc

import com.meamoria.mpp.antlr.*

actual external class LscLexer actual constructor(input: CharStream): Lexer

actual external class LscParser actual constructor(input: TokenStream) : Parser {
    actual fun lscFile(): LscFileContext
    actual fun statement(): StatementContext
    actual fun classDecl(): ClassDeclContext
    actual fun classElement(): ClassElementContext
    actual fun featureDecl(): FeatureDeclContext
    actual fun featureModifier(): FeatureModifierContext
    actual fun plusFeature(): PlusFeatureContext
    actual fun nullAlias(): NullAliasContext
    actual fun diacriticDecl(): DiacriticDeclContext
    actual fun diacriticModifier(): DiacriticModifierContext
    actual fun symbolDecl(): SymbolDeclContext
    actual fun symbolName(): SymbolNameContext
    actual fun syllableDecl(): SyllableDeclContext
    actual fun syllablePattern(): SyllablePatternContext
    actual fun deromanizer(): DeromanizerContext
    actual fun romanizer(): RomanizerContext
    actual fun interRomanizer(): InterRomanizerContext
    actual fun changeRule(): ChangeRuleContext
    actual fun filter(): FilterContext
    actual fun block(): BlockContext
    actual fun blockElement(): BlockElementContext
    actual fun blockType(): BlockTypeContext
    actual fun changeRuleModifier(): ChangeRuleModifierContext
    actual fun keywordModifier(): KeywordModifierContext
    actual fun expressionList(): ExpressionListContext
    actual fun ruleName(): RuleNameContext
    actual fun expression(): ExpressionContext
    actual fun keywordExpression(): KeywordExpressionContext
    actual fun from(): FromContext
    actual fun to(): ToContext
    actual fun ruleElement(): RuleElementContext
    actual fun unconditionalRuleElement(): UnconditionalRuleElementContext
    actual fun bounded(): BoundedContext
    actual fun group(): GroupContext
    actual fun list(): ListContext
    actual fun sequence(): SequenceContext
    actual fun freeElement(): FreeElementContext
    actual fun compoundEnvironment(): CompoundEnvironmentContext
    actual fun condition(): ConditionContext
    actual fun exclusion(): ExclusionContext
    actual fun environmentList(): EnvironmentListContext
    actual fun environment(): EnvironmentContext
    actual fun environmentBefore(): EnvironmentBeforeContext
    actual fun environmentAfter(): EnvironmentAfterContext
    actual fun interfix(): InterfixContext
    actual fun interfixType(): InterfixTypeContext
    actual fun interfixElement(): InterfixElementContext
    actual fun negated(): NegatedContext
    actual fun postfix(): PostfixContext
    actual fun capture(): CaptureContext
    actual fun repeater(): RepeaterContext
    actual fun simple(): SimpleContext
    actual fun anySyllable(): AnySyllableContext
    actual fun classRef(): ClassRefContext
    actual fun captureRef(): CaptureRefContext
    actual fun fancyMatrix(): FancyMatrixContext
    actual fun fancyValue(): FancyValueContext
    actual fun negatedValue(): NegatedValueContext
    actual fun absentFeature(): AbsentFeatureContext
    actual fun featureVariable(): FeatureVariableContext
    actual fun empty(): EmptyContext
    actual fun sylBoundary(): SylBoundaryContext
    actual fun boundary(): BoundaryContext
    actual fun betweenWords(): BetweenWordsContext
    actual fun repeaterType(): RepeaterTypeContext
    actual fun repeatRange(): RepeatRangeContext
    actual fun lowerBound(): LowerBoundContext
    actual fun upperBound(): UpperBoundContext
    actual fun matrix(): MatrixContext
    actual fun matrixValue(): MatrixValueContext
    actual fun plusFeatureValue(): PlusFeatureValueContext
    actual fun featureValue(): FeatureValueContext
    actual fun name(): NameContext
    actual fun text(): TextContext

    class LscFileContext : ParserRuleContext {
        fun WHITESPACE(): TerminalNode?
        fun NEWLINE(): Array<TerminalNode>
        fun statement(): Array<StatementContext>
        fun EOF(): TerminalNode?
    }

    class StatementContext : ParserRuleContext {
        fun featureDecl(): FeatureDeclContext?
        fun diacriticDecl(): DiacriticDeclContext?
        fun symbolDecl(): SymbolDeclContext?
        fun classDecl(): ClassDeclContext?
        fun syllableDecl(): SyllableDeclContext?
        fun deromanizer(): DeromanizerContext?
        fun changeRule(): ChangeRuleContext?
        fun interRomanizer(): InterRomanizerContext?
        fun romanizer(): RomanizerContext?
    }

    class ClassDeclContext : ParserRuleContext {
        fun CLASS_DECL(): TerminalNode
        fun WHITESPACE(): Array<TerminalNode>
        fun name(): NameContext
        fun LIST_START(): TerminalNode
        fun classElement(): Array<ClassElementContext>
        fun SEP(): Array<TerminalNode>
        fun LIST_END(): TerminalNode
    }

    class ClassElementContext : ParserRuleContext {
        fun classRef(): ClassRefContext?
        fun text(): TextContext?
    }

    class FeatureDeclContext : ParserRuleContext {
        fun FEATURE_DECL(): TerminalNode
        fun WHITESPACE(): Array<TerminalNode>
        fun plusFeature(): Array<PlusFeatureContext>
        fun SEP(): Array<TerminalNode>
        fun featureModifier(): FeatureModifierContext?
        fun name(): NameContext?
        fun O_PAREN(): TerminalNode?
        fun nullAlias(): NullAliasContext?
        fun featureValue(): Array<FeatureValueContext>
        fun C_PAREN(): TerminalNode?
    }

    class FeatureModifierContext : ParserRuleContext {
        fun SYLLABLE_FEATURE(): TerminalNode
    }

    class PlusFeatureContext : ParserRuleContext {
        fun featureModifier(): FeatureModifierContext?
        fun WHITESPACE(): TerminalNode?
        fun AT_LEAST_ONE(): TerminalNode?
        fun name(): NameContext
    }

    class NullAliasContext : ParserRuleContext {
        fun NULL(): TerminalNode
        fun featureValue(): FeatureValueContext
    }

    class DiacriticDeclContext : ParserRuleContext {
        fun DIACRITIC(): TerminalNode
        fun WHITESPACE(): Array<TerminalNode>
        fun text(): TextContext
        fun diacriticModifier(): Array<DiacriticModifierContext>
        fun matrix(): MatrixContext
    }

    class DiacriticModifierContext : ParserRuleContext {
        fun DIA_BEFORE(): TerminalNode?
        fun DIA_FIRST(): TerminalNode?
        fun DIA_FLOATING(): TerminalNode?
    }

    class SymbolDeclContext : ParserRuleContext {
        fun SYMBOL(): TerminalNode
        fun WHITESPACE(): Array<TerminalNode>
        fun symbolName(): Array<SymbolNameContext>
        fun SEP(): Array<TerminalNode>
        fun matrix(): MatrixContext?
    }

    class SymbolNameContext : ParserRuleContext {
        fun text(): TextContext
    }

    class SyllableDeclContext : ParserRuleContext {
        fun SYLLABLE_DECL(): TerminalNode
        fun RULE_START(): TerminalNode
        fun NEWLINE(): Array<TerminalNode>
        fun EXPLICIT_SYLLABLES(): TerminalNode?
        fun CLEAR_SYLLABLES(): TerminalNode?
        fun syllablePattern(): Array<SyllablePatternContext>
    }

    class SyllablePatternContext : ParserRuleContext {
        fun unconditionalRuleElement(): UnconditionalRuleElementContext
        fun CHANGE(): TerminalNode?
        fun matrix(): MatrixContext?
        fun compoundEnvironment(): CompoundEnvironmentContext?
    }

    class DeromanizerContext : ParserRuleContext {
        fun DEROMANIZER(): TerminalNode
        fun WHITESPACE(): TerminalNode?
        fun LITERAL(): TerminalNode?
        fun RULE_START(): TerminalNode
        fun NEWLINE(): Array<TerminalNode>
        fun block(): BlockContext
    }

    class RomanizerContext : ParserRuleContext {
        fun ROMANIZER(): TerminalNode
        fun WHITESPACE(): TerminalNode?
        fun LITERAL(): TerminalNode?
        fun RULE_START(): TerminalNode
        fun NEWLINE(): Array<TerminalNode>
        fun block(): BlockContext
    }

    class InterRomanizerContext : ParserRuleContext {
        fun ROMANIZER(): TerminalNode
        fun HYPHEN(): TerminalNode
        fun ruleName(): RuleNameContext
        fun WHITESPACE(): TerminalNode?
        fun LITERAL(): TerminalNode?
        fun RULE_START(): TerminalNode
        fun NEWLINE(): Array<TerminalNode>
        fun block(): BlockContext
    }

    class ChangeRuleContext : ParserRuleContext {
        fun ruleName(): RuleNameContext
        fun WHITESPACE(): Array<TerminalNode>
        fun changeRuleModifier(): Array<ChangeRuleModifierContext>
        fun RULE_START(): TerminalNode?
        fun NEWLINE(): Array<TerminalNode>
        fun block(): BlockContext
    }

    class FilterContext : ParserRuleContext {
        fun classRef(): ClassRefContext?
        fun fancyMatrix(): FancyMatrixContext?
    }

    class BlockContext : ParserRuleContext {
        fun blockElement(): Array<BlockElementContext>
        fun NEWLINE(): Array<TerminalNode>
        fun blockType(): Array<BlockTypeContext>
        fun RULE_START(): Array<TerminalNode>
        fun WHITESPACE(): Array<TerminalNode>
    }

    class BlockElementContext : ParserRuleContext {
        fun expressionList(): ExpressionListContext?
        fun O_PAREN(): TerminalNode?
        fun NEWLINE(): Array<TerminalNode>
        fun block(): BlockContext?
        fun C_PAREN(): TerminalNode?
    }

    class BlockTypeContext : ParserRuleContext {
        fun ALL_MATCHING(): TerminalNode?
        fun FIRST_MATCHING(): TerminalNode?
        fun WHITESPACE(): Array<TerminalNode>
        fun changeRuleModifier(): Array<ChangeRuleModifierContext>
    }

    class ChangeRuleModifierContext : ParserRuleContext {
        fun filter(): FilterContext?
        fun keywordModifier(): KeywordModifierContext?
    }

    class KeywordModifierContext : ParserRuleContext {
        fun NAME(): TerminalNode
    }

    class ExpressionListContext : ParserRuleContext {
        fun expression(): Array<ExpressionContext>
        fun NEWLINE(): Array<TerminalNode>
    }

    class RuleNameContext : ParserRuleContext {
        fun NAME(): Array<TerminalNode>
        fun HYPHEN(): Array<TerminalNode>
        fun NUMBER(): Array<TerminalNode>
    }

    class ExpressionContext : ParserRuleContext {
        fun keywordExpression(): KeywordExpressionContext?
        fun from(): FromContext?
        fun CHANGE(): TerminalNode?
        fun to(): ToContext?
        fun compoundEnvironment(): CompoundEnvironmentContext?
    }

    class KeywordExpressionContext : ParserRuleContext {
        fun NAME(): TerminalNode
    }

    class FromContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class ToContext : ParserRuleContext {
        fun unconditionalRuleElement(): UnconditionalRuleElementContext
    }

    class RuleElementContext : ParserRuleContext {
        fun unconditionalRuleElement(): UnconditionalRuleElementContext
        fun compoundEnvironment(): CompoundEnvironmentContext?
    }

    class UnconditionalRuleElementContext : ParserRuleContext {
        fun bounded(): BoundedContext?
        fun interfix(): InterfixContext?
        fun negated(): NegatedContext?
        fun postfix(): PostfixContext?
        fun simple(): SimpleContext?
        fun sequence(): SequenceContext?
    }

    class BoundedContext : ParserRuleContext {
        fun group(): GroupContext?
        fun list(): ListContext?
    }

    class GroupContext : ParserRuleContext {
        fun O_PAREN(): TerminalNode
        fun ruleElement(): RuleElementContext
        fun C_PAREN(): TerminalNode
    }

    class ListContext : ParserRuleContext {
        fun LIST_START(): TerminalNode
        fun ruleElement(): Array<RuleElementContext>
        fun SEP(): Array<TerminalNode>
        fun LIST_END(): TerminalNode
    }

    class SequenceContext : ParserRuleContext {
        fun freeElement(): Array<FreeElementContext>
        fun WHITESPACE(): Array<TerminalNode>
    }

    class FreeElementContext : ParserRuleContext {
        fun bounded(): BoundedContext?
        fun interfix(): InterfixContext?
        fun negated(): NegatedContext?
        fun postfix(): PostfixContext?
        fun simple(): SimpleContext?
    }

    class CompoundEnvironmentContext : ParserRuleContext {
        fun condition(): ConditionContext?
        fun exclusion(): ExclusionContext?
    }

    class ConditionContext : ParserRuleContext {
        fun CONDITION(): TerminalNode
        fun environment(): EnvironmentContext?
        fun environmentList(): EnvironmentListContext?
    }

    class ExclusionContext : ParserRuleContext {
        fun EXCLUSION(): TerminalNode
        fun environment(): EnvironmentContext?
        fun environmentList(): EnvironmentListContext?
    }

    class EnvironmentListContext : ParserRuleContext {
        fun LIST_START(): TerminalNode
        fun environment(): Array<EnvironmentContext>
        fun SEP(): Array<TerminalNode>
        fun LIST_END(): TerminalNode
    }

    class EnvironmentContext : ParserRuleContext {
        fun environmentBefore(): EnvironmentBeforeContext?
        fun WHITESPACE(): Array<TerminalNode>
        fun ANCHOR(): TerminalNode?
        fun environmentAfter(): EnvironmentAfterContext?
    }

    class EnvironmentBeforeContext : ParserRuleContext {
        fun unconditionalRuleElement(): UnconditionalRuleElementContext
    }

    class EnvironmentAfterContext : ParserRuleContext {
        fun unconditionalRuleElement(): UnconditionalRuleElementContext
    }

    class InterfixContext : ParserRuleContext {
        fun interfixElement(): Array<InterfixElementContext>
        fun interfixType(): Array<InterfixTypeContext>
    }

    class InterfixTypeContext : ParserRuleContext {
        fun INTERSECTION(): TerminalNode?
        fun INTERSECTION_NOT(): TerminalNode?
        fun TRANSFORMING(): TerminalNode?
    }

    class InterfixElementContext : ParserRuleContext {
        fun bounded(): BoundedContext?
        fun negated(): NegatedContext?
        fun postfix(): PostfixContext?
        fun simple(): SimpleContext?
    }

    class NegatedContext : ParserRuleContext {
        fun NEGATION(): TerminalNode
        fun simple(): SimpleContext
    }

    class PostfixContext : ParserRuleContext {
        fun capture(): CaptureContext?
        fun repeater(): RepeaterContext?
    }

    class CaptureContext : ParserRuleContext {
        fun bounded(): BoundedContext?
        fun negated(): NegatedContext?
        fun simple(): SimpleContext?
        fun captureRef(): CaptureRefContext
    }

    class RepeaterContext : ParserRuleContext {
        fun bounded(): BoundedContext?
        fun simple(): SimpleContext?
        fun repeaterType(): RepeaterTypeContext
    }

    class SimpleContext : ParserRuleContext {
        fun anySyllable(): AnySyllableContext?
        fun classRef(): ClassRefContext?
        fun captureRef(): CaptureRefContext?
        fun fancyMatrix(): FancyMatrixContext?
        fun empty(): EmptyContext?
        fun sylBoundary(): SylBoundaryContext?
        fun boundary(): BoundaryContext?
        fun betweenWords(): BetweenWordsContext?
        fun text(): TextContext?
    }

    class AnySyllableContext : ParserRuleContext {
        fun ANY_SYLLABLE(): TerminalNode
    }

    class ClassRefContext : ParserRuleContext {
        fun CLASSREF(): TerminalNode
        fun name(): NameContext
    }

    class CaptureRefContext : ParserRuleContext {
        fun INEXACT(): TerminalNode?
        fun WORD_BOUNDARY(): TerminalNode
        fun NUMBER(): TerminalNode
    }

    class FancyMatrixContext : ParserRuleContext {
        fun MATRIX_START(): TerminalNode
        fun fancyValue(): Array<FancyValueContext>
        fun WHITESPACE(): Array<TerminalNode>
        fun MATRIX_END(): TerminalNode
    }

    class FancyValueContext : ParserRuleContext {
        fun matrixValue(): MatrixValueContext?
        fun negatedValue(): NegatedValueContext?
        fun absentFeature(): AbsentFeatureContext?
        fun featureVariable(): FeatureVariableContext?
    }

    class NegatedValueContext : ParserRuleContext {
        fun NEGATION(): TerminalNode
        fun matrixValue(): MatrixValueContext
    }

    class AbsentFeatureContext : ParserRuleContext {
        fun NULL(): TerminalNode
        fun name(): NameContext
    }

    class FeatureVariableContext : ParserRuleContext {
        fun WORD_BOUNDARY(): TerminalNode
        fun name(): NameContext
    }

    class EmptyContext : ParserRuleContext {
        fun NULL(): TerminalNode
    }

    class SylBoundaryContext : ParserRuleContext {
        fun SYLLABLE_BOUNDARY(): TerminalNode
    }

    class BoundaryContext : ParserRuleContext {
        fun WORD_BOUNDARY(): TerminalNode
    }

    class BetweenWordsContext : ParserRuleContext {
        fun BETWEEN_WORDS(): TerminalNode
    }

    class RepeaterTypeContext : ParserRuleContext {
        fun repeatRange(): RepeatRangeContext?
        fun AT_LEAST_ONE(): TerminalNode?
        fun NULL(): TerminalNode?
        fun OPTIONAL(): TerminalNode?
    }

    class RepeatRangeContext : ParserRuleContext {
        fun NULL(): TerminalNode
        fun NUMBER(): TerminalNode?
        fun O_PAREN(): TerminalNode?
        fun lowerBound(): LowerBoundContext?
        fun HYPHEN(): TerminalNode?
        fun upperBound(): UpperBoundContext?
        fun C_PAREN(): TerminalNode?
    }

    class LowerBoundContext : ParserRuleContext {
        fun NUMBER(): TerminalNode
    }

    class UpperBoundContext : ParserRuleContext {
        fun NUMBER(): TerminalNode
    }

    class MatrixContext : ParserRuleContext {
        fun MATRIX_START(): TerminalNode
        fun matrixValue(): Array<MatrixValueContext>
        fun WHITESPACE(): Array<TerminalNode>
        fun MATRIX_END(): TerminalNode
    }

    class MatrixValueContext : ParserRuleContext {
        fun plusFeatureValue(): PlusFeatureValueContext?
        fun featureValue(): FeatureValueContext?
    }

    class PlusFeatureValueContext : ParserRuleContext {
        fun AT_LEAST_ONE(): TerminalNode?
        fun HYPHEN(): TerminalNode?
        fun name(): NameContext
    }

    class FeatureValueContext : ParserRuleContext {
        fun name(): NameContext
    }

    class NameContext : ParserRuleContext {
        fun NAME(): TerminalNode
    }

    class TextContext : ParserRuleContext {
        fun NAME(): TerminalNode?
        fun STR1(): TerminalNode?
        fun STR(): TerminalNode?
        fun NEGATION(): TerminalNode?
    }
}

open external class LscVisitor<T>{
    fun visit(tree: ParseTree): T

    open fun visitLscFile(ctx: LscFileContext): T
    open fun visitStatement(ctx: StatementContext): T
    open fun visitClassDecl(ctx: ClassDeclContext): T
    open fun visitClassElement(ctx: ClassElementContext): T
    open fun visitFeatureDecl(ctx: FeatureDeclContext): T
    open fun visitFeatureModifier(ctx: FeatureModifierContext): T
    open fun visitPlusFeature(ctx: PlusFeatureContext): T
    open fun visitNullAlias(ctx: NullAliasContext): T
    open fun visitDiacriticDecl(ctx: DiacriticDeclContext): T
    open fun visitDiacriticModifier(ctx: DiacriticModifierContext): T
    open fun visitSymbolDecl(ctx: SymbolDeclContext): T
    open fun visitSymbolName(ctx: SymbolNameContext): T
    open fun visitSyllableDecl(ctx: SyllableDeclContext): T
    open fun visitSyllablePattern(ctx: SyllablePatternContext): T
    open fun visitDeromanizer(ctx: DeromanizerContext): T
    open fun visitRomanizer(ctx: RomanizerContext): T
    open fun visitInterRomanizer(ctx: InterRomanizerContext): T
    open fun visitChangeRule(ctx: ChangeRuleContext): T
    open fun visitFilter(ctx: FilterContext): T
    open fun visitBlock(ctx: BlockContext): T
    open fun visitBlockElement(ctx: BlockElementContext): T
    open fun visitBlockType(ctx: BlockTypeContext): T
    open fun visitChangeRuleModifier(ctx: ChangeRuleModifierContext): T
    open fun visitKeywordModifier(ctx: KeywordModifierContext): T
    open fun visitExpressionList(ctx: ExpressionListContext): T
    open fun visitRuleName(ctx: RuleNameContext): T
    open fun visitExpression(ctx: ExpressionContext): T
    open fun visitKeywordExpression(ctx: KeywordExpressionContext): T
    open fun visitFrom(ctx: FromContext): T
    open fun visitTo(ctx: ToContext): T
    open fun visitRuleElement(ctx: RuleElementContext): T
    open fun visitUnconditionalRuleElement(ctx: UnconditionalRuleElementContext): T
    open fun visitBounded(ctx: BoundedContext): T
    open fun visitGroup(ctx: GroupContext): T
    open fun visitList(ctx: ListContext): T
    open fun visitSequence(ctx: SequenceContext): T
    open fun visitFreeElement(ctx: FreeElementContext): T
    open fun visitCompoundEnvironment(ctx: CompoundEnvironmentContext): T
    open fun visitCondition(ctx: ConditionContext): T
    open fun visitExclusion(ctx: ExclusionContext): T
    open fun visitEnvironmentList(ctx: EnvironmentListContext): T
    open fun visitEnvironment(ctx: EnvironmentContext): T
    open fun visitEnvironmentBefore(ctx: EnvironmentBeforeContext): T
    open fun visitEnvironmentAfter(ctx: EnvironmentAfterContext): T
    open fun visitInterfix(ctx: InterfixContext): T
    open fun visitInterfixType(ctx: InterfixTypeContext): T
    open fun visitInterfixElement(ctx: InterfixElementContext): T
    open fun visitNegated(ctx: NegatedContext): T
    open fun visitPostfix(ctx: PostfixContext): T
    open fun visitCapture(ctx: CaptureContext): T
    open fun visitRepeater(ctx: RepeaterContext): T
    open fun visitSimple(ctx: SimpleContext): T
    open fun visitAnySyllable(ctx: AnySyllableContext): T
    open fun visitClassRef(ctx: ClassRefContext): T
    open fun visitCaptureRef(ctx: CaptureRefContext): T
    open fun visitFancyMatrix(ctx: FancyMatrixContext): T
    open fun visitFancyValue(ctx: FancyValueContext): T
    open fun visitNegatedValue(ctx: NegatedValueContext): T
    open fun visitAbsentFeature(ctx: AbsentFeatureContext): T
    open fun visitFeatureVariable(ctx: FeatureVariableContext): T
    open fun visitEmpty(ctx: EmptyContext): T
    open fun visitSylBoundary(ctx: SylBoundaryContext): T
    open fun visitBoundary(ctx: BoundaryContext): T
    open fun visitBetweenWords(ctx: BetweenWordsContext): T
    open fun visitRepeaterType(ctx: RepeaterTypeContext): T
    open fun visitRepeatRange(ctx: RepeatRangeContext): T
    open fun visitLowerBound(ctx: LowerBoundContext): T
    open fun visitUpperBound(ctx: UpperBoundContext): T
    open fun visitMatrix(ctx: MatrixContext): T
    open fun visitMatrixValue(ctx: MatrixValueContext): T
    open fun visitPlusFeatureValue(ctx: PlusFeatureValueContext): T
    open fun visitFeatureValue(ctx: FeatureValueContext): T
    open fun visitName(ctx: NameContext): T
    open fun visitText(ctx: TextContext): T
}

actual typealias LscBaseVisitor<T> = LscVisitor<T>

actual typealias LscFileContext = LscParser.LscFileContext

actual fun LscFileContext.allStatements(): List<StatementContext> = statement().toList()

actual typealias StatementContext = LscParser.StatementContext

actual typealias ClassDeclContext = LscParser.ClassDeclContext

actual fun ClassDeclContext.allClassElements(): List<ClassElementContext> = classElement().toList()

actual typealias ClassElementContext = LscParser.ClassElementContext

actual typealias FeatureDeclContext = LscParser.FeatureDeclContext

actual fun FeatureDeclContext.allPlusFeatures(): List<PlusFeatureContext> = plusFeature().toList()

actual fun FeatureDeclContext.allFeatureValues(): List<FeatureValueContext> = featureValue().toList()

actual typealias FeatureModifierContext = LscParser.FeatureModifierContext

actual typealias PlusFeatureContext = LscParser.PlusFeatureContext

actual typealias NullAliasContext = LscParser.NullAliasContext

actual typealias DiacriticDeclContext = LscParser.DiacriticDeclContext

actual fun DiacriticDeclContext.allDiacriticModifiers(): List<DiacriticModifierContext> = diacriticModifier().toList()

actual typealias DiacriticModifierContext = LscParser.DiacriticModifierContext

actual typealias SymbolDeclContext = LscParser.SymbolDeclContext

actual fun SymbolDeclContext.allSymbolNames(): List<SymbolNameContext> = symbolName().toList()

actual typealias SymbolNameContext = LscParser.SymbolNameContext

actual typealias SyllableDeclContext = LscParser.SyllableDeclContext

actual fun SyllableDeclContext.allSyllablePatterns(): List<SyllablePatternContext> = syllablePattern().toList()

actual typealias SyllablePatternContext = LscParser.SyllablePatternContext

actual typealias DeromanizerContext = LscParser.DeromanizerContext

actual typealias RomanizerContext = LscParser.RomanizerContext

actual typealias InterRomanizerContext = LscParser.InterRomanizerContext

actual typealias ChangeRuleContext = LscParser.ChangeRuleContext

actual fun ChangeRuleContext.allChangeRuleModifiers(): List<ChangeRuleModifierContext> = changeRuleModifier().toList()

actual typealias FilterContext = LscParser.FilterContext

actual typealias BlockContext = LscParser.BlockContext

actual fun BlockContext.allBlockElements(): List<BlockElementContext> = blockElement().toList()

actual fun BlockContext.allBlockTypes(): List<BlockTypeContext> = blockType().toList()

actual typealias BlockElementContext = LscParser.BlockElementContext

actual typealias BlockTypeContext = LscParser.BlockTypeContext

actual fun BlockTypeContext.allChangeRuleModifiers(): List<ChangeRuleModifierContext> = changeRuleModifier().toList()

actual typealias ChangeRuleModifierContext = LscParser.ChangeRuleModifierContext

actual typealias KeywordModifierContext = LscParser.KeywordModifierContext

actual typealias ExpressionListContext = LscParser.ExpressionListContext

actual fun ExpressionListContext.allExpressions(): List<ExpressionContext> = expression().toList()

actual typealias RuleNameContext = LscParser.RuleNameContext

actual typealias ExpressionContext = LscParser.ExpressionContext

actual typealias KeywordExpressionContext = LscParser.KeywordExpressionContext

actual typealias FromContext = LscParser.FromContext

actual typealias ToContext = LscParser.ToContext

actual typealias RuleElementContext = LscParser.RuleElementContext

actual typealias UnconditionalRuleElementContext = LscParser.UnconditionalRuleElementContext

actual typealias BoundedContext = LscParser.BoundedContext

actual typealias GroupContext = LscParser.GroupContext

actual typealias ListContext = LscParser.ListContext

actual fun ListContext.allRuleElements(): List<RuleElementContext> = ruleElement().toList()

actual typealias SequenceContext = LscParser.SequenceContext

actual fun SequenceContext.allFreeElements(): List<FreeElementContext> = freeElement().toList()

actual typealias FreeElementContext = LscParser.FreeElementContext

actual typealias CompoundEnvironmentContext = LscParser.CompoundEnvironmentContext

actual typealias ConditionContext = LscParser.ConditionContext

actual typealias ExclusionContext = LscParser.ExclusionContext

actual typealias EnvironmentListContext = LscParser.EnvironmentListContext

actual fun EnvironmentListContext.allEnvironments(): List<EnvironmentContext> = environment().toList()

actual typealias EnvironmentContext = LscParser.EnvironmentContext

actual typealias EnvironmentBeforeContext = LscParser.EnvironmentBeforeContext

actual typealias EnvironmentAfterContext = LscParser.EnvironmentAfterContext

actual typealias InterfixContext = LscParser.InterfixContext

actual fun InterfixContext.allInterfixElements(): List<InterfixElementContext> = interfixElement().toList()

actual fun InterfixContext.allInterfixTypes(): List<InterfixTypeContext> = interfixType().toList()

actual typealias InterfixTypeContext = LscParser.InterfixTypeContext

actual typealias InterfixElementContext = LscParser.InterfixElementContext

actual typealias NegatedContext = LscParser.NegatedContext

actual typealias PostfixContext = LscParser.PostfixContext

actual typealias CaptureContext = LscParser.CaptureContext

actual typealias RepeaterContext = LscParser.RepeaterContext

actual typealias SimpleContext = LscParser.SimpleContext

actual typealias AnySyllableContext = LscParser.AnySyllableContext

actual typealias ClassRefContext = LscParser.ClassRefContext

actual typealias CaptureRefContext = LscParser.CaptureRefContext

actual typealias FancyMatrixContext = LscParser.FancyMatrixContext

actual fun FancyMatrixContext.allFancyValues(): List<FancyValueContext> = fancyValue().toList()

actual typealias FancyValueContext = LscParser.FancyValueContext

actual typealias NegatedValueContext = LscParser.NegatedValueContext

actual typealias AbsentFeatureContext = LscParser.AbsentFeatureContext

actual typealias FeatureVariableContext = LscParser.FeatureVariableContext

actual typealias EmptyContext = LscParser.EmptyContext

actual typealias SylBoundaryContext = LscParser.SylBoundaryContext

actual typealias BoundaryContext = LscParser.BoundaryContext

actual typealias BetweenWordsContext = LscParser.BetweenWordsContext

actual typealias RepeaterTypeContext = LscParser.RepeaterTypeContext

actual typealias RepeatRangeContext = LscParser.RepeatRangeContext

actual typealias LowerBoundContext = LscParser.LowerBoundContext

actual typealias UpperBoundContext = LscParser.UpperBoundContext

actual typealias MatrixContext = LscParser.MatrixContext

actual fun MatrixContext.allMatrixValues(): List<MatrixValueContext> = matrixValue().toList()

actual typealias MatrixValueContext = LscParser.MatrixValueContext

actual typealias PlusFeatureValueContext = LscParser.PlusFeatureValueContext

actual typealias FeatureValueContext = LscParser.FeatureValueContext

actual typealias NameContext = LscParser.NameContext

actual typealias TextContext = LscParser.TextContext
