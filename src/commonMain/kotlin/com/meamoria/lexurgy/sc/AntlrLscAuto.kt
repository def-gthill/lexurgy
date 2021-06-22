// This file is automatically generated from Lsc.g4. Don't modify it!

@file:Suppress("FunctionName", "unused", "RemoveEmptyClassBody")

package com.meamoria.lexurgy.sc

import com.meamoria.mpp.antlr.*

expect class LscLexer(input: CharStream) : Lexer

expect class LscParser(input: TokenStream) : Parser {
    fun lscFile(): LscFileContext
    fun statement(): StatementContext
    fun classDecl(): ClassDeclContext
    fun classElement(): ClassElementContext
    fun featureDecl(): FeatureDeclContext
    fun plusFeature(): PlusFeatureContext
    fun nullAlias(): NullAliasContext
    fun diacriticDecl(): DiacriticDeclContext
    fun diacriticModifier(): DiacriticModifierContext
    fun symbolDecl(): SymbolDeclContext
    fun symbolName(): SymbolNameContext
    fun syllableDecl(): SyllableDeclContext
    fun syllablePattern(): SyllablePatternContext
    fun deromanizer(): DeromanizerContext
    fun romanizer(): RomanizerContext
    fun interRomanizer(): InterRomanizerContext
    fun changeRule(): ChangeRuleContext
    fun changeRuleModifier(): ChangeRuleModifierContext
    fun filter(): FilterContext
    fun block(): BlockContext
    fun blockElement(): BlockElementContext
    fun blockType(): BlockTypeContext
    fun expressionList(): ExpressionListContext
    fun ruleName(): RuleNameContext
    fun expression(): ExpressionContext
    fun from(): FromContext
    fun to(): ToContext
    fun ruleElement(): RuleElementContext
    fun bounded(): BoundedContext
    fun group(): GroupContext
    fun list(): ListContext
    fun sequence(): SequenceContext
    fun lookaround(): LookaroundContext
    fun freeElement(): FreeElementContext
    fun compoundEnvironment(): CompoundEnvironmentContext
    fun condition(): ConditionContext
    fun exclusion(): ExclusionContext
    fun environmentList(): EnvironmentListContext
    fun environment(): EnvironmentContext
    fun environmentBefore(): EnvironmentBeforeContext
    fun environmentAfter(): EnvironmentAfterContext
    fun intersection(): IntersectionContext
    fun interfixElement(): InterfixElementContext
    fun negated(): NegatedContext
    fun postfix(): PostfixContext
    fun capture(): CaptureContext
    fun repeater(): RepeaterContext
    fun simple(): SimpleContext
    fun classRef(): ClassRefContext
    fun captureRef(): CaptureRefContext
    fun fancyMatrix(): FancyMatrixContext
    fun fancyValue(): FancyValueContext
    fun negatedValue(): NegatedValueContext
    fun absentFeature(): AbsentFeatureContext
    fun featureVariable(): FeatureVariableContext
    fun empty(): EmptyContext
    fun boundary(): BoundaryContext
    fun betweenWords(): BetweenWordsContext
    fun repeaterType(): RepeaterTypeContext
    fun matrix(): MatrixContext
    fun matrixValue(): MatrixValueContext
    fun plusFeatureValue(): PlusFeatureValueContext
    fun featureValue(): FeatureValueContext
    fun name(): NameContext
    fun text(): TextContext
}

expect open class LscBaseVisitor<T>(){
    fun visit(tree: ParseTree): T

    open fun visitLscFile(ctx: LscFileContext): T
    open fun visitStatement(ctx: StatementContext): T
    open fun visitClassDecl(ctx: ClassDeclContext): T
    open fun visitClassElement(ctx: ClassElementContext): T
    open fun visitFeatureDecl(ctx: FeatureDeclContext): T
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
    open fun visitChangeRuleModifier(ctx: ChangeRuleModifierContext): T
    open fun visitFilter(ctx: FilterContext): T
    open fun visitBlock(ctx: BlockContext): T
    open fun visitBlockElement(ctx: BlockElementContext): T
    open fun visitBlockType(ctx: BlockTypeContext): T
    open fun visitExpressionList(ctx: ExpressionListContext): T
    open fun visitRuleName(ctx: RuleNameContext): T
    open fun visitExpression(ctx: ExpressionContext): T
    open fun visitFrom(ctx: FromContext): T
    open fun visitTo(ctx: ToContext): T
    open fun visitRuleElement(ctx: RuleElementContext): T
    open fun visitBounded(ctx: BoundedContext): T
    open fun visitGroup(ctx: GroupContext): T
    open fun visitList(ctx: ListContext): T
    open fun visitSequence(ctx: SequenceContext): T
    open fun visitLookaround(ctx: LookaroundContext): T
    open fun visitFreeElement(ctx: FreeElementContext): T
    open fun visitCompoundEnvironment(ctx: CompoundEnvironmentContext): T
    open fun visitCondition(ctx: ConditionContext): T
    open fun visitExclusion(ctx: ExclusionContext): T
    open fun visitEnvironmentList(ctx: EnvironmentListContext): T
    open fun visitEnvironment(ctx: EnvironmentContext): T
    open fun visitEnvironmentBefore(ctx: EnvironmentBeforeContext): T
    open fun visitEnvironmentAfter(ctx: EnvironmentAfterContext): T
    open fun visitIntersection(ctx: IntersectionContext): T
    open fun visitInterfixElement(ctx: InterfixElementContext): T
    open fun visitNegated(ctx: NegatedContext): T
    open fun visitPostfix(ctx: PostfixContext): T
    open fun visitCapture(ctx: CaptureContext): T
    open fun visitRepeater(ctx: RepeaterContext): T
    open fun visitSimple(ctx: SimpleContext): T
    open fun visitClassRef(ctx: ClassRefContext): T
    open fun visitCaptureRef(ctx: CaptureRefContext): T
    open fun visitFancyMatrix(ctx: FancyMatrixContext): T
    open fun visitFancyValue(ctx: FancyValueContext): T
    open fun visitNegatedValue(ctx: NegatedValueContext): T
    open fun visitAbsentFeature(ctx: AbsentFeatureContext): T
    open fun visitFeatureVariable(ctx: FeatureVariableContext): T
    open fun visitEmpty(ctx: EmptyContext): T
    open fun visitBoundary(ctx: BoundaryContext): T
    open fun visitBetweenWords(ctx: BetweenWordsContext): T
    open fun visitRepeaterType(ctx: RepeaterTypeContext): T
    open fun visitMatrix(ctx: MatrixContext): T
    open fun visitMatrixValue(ctx: MatrixValueContext): T
    open fun visitPlusFeatureValue(ctx: PlusFeatureValueContext): T
    open fun visitFeatureValue(ctx: FeatureValueContext): T
    open fun visitName(ctx: NameContext): T
    open fun visitText(ctx: TextContext): T
}

expect class LscFileContext : ParserRuleContext {
    fun WHITESPACE(): TerminalNode?
    fun EOF(): TerminalNode?
}

expect fun LscFileContext.allStatements(): List<StatementContext>

expect class StatementContext : ParserRuleContext {
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


expect class ClassDeclContext : ParserRuleContext {
    fun CLASS_DECL(): TerminalNode
    fun name(): NameContext
    fun LIST_START(): TerminalNode
    fun LIST_END(): TerminalNode
}

expect fun ClassDeclContext.allClassElements(): List<ClassElementContext>

expect class ClassElementContext : ParserRuleContext {
    fun classRef(): ClassRefContext?
    fun text(): TextContext?
}


expect class FeatureDeclContext : ParserRuleContext {
    fun FEATURE_DECL(): TerminalNode
    fun name(): NameContext?
    fun O_PAREN(): TerminalNode?
    fun nullAlias(): NullAliasContext?
    fun C_PAREN(): TerminalNode?
}

expect fun FeatureDeclContext.allPlusFeatures(): List<PlusFeatureContext>

expect fun FeatureDeclContext.allFeatureValues(): List<FeatureValueContext>

expect class PlusFeatureContext : ParserRuleContext {
    fun AT_LEAST_ONE(): TerminalNode?
    fun name(): NameContext
}


expect class NullAliasContext : ParserRuleContext {
    fun NULL(): TerminalNode
    fun featureValue(): FeatureValueContext
}


expect class DiacriticDeclContext : ParserRuleContext {
    fun DIACRITIC(): TerminalNode
    fun text(): TextContext
    fun matrix(): MatrixContext
}

expect fun DiacriticDeclContext.allDiacriticModifiers(): List<DiacriticModifierContext>

expect class DiacriticModifierContext : ParserRuleContext {
    fun DIA_BEFORE(): TerminalNode?
    fun DIA_FLOATING(): TerminalNode?
}


expect class SymbolDeclContext : ParserRuleContext {
    fun SYMBOL(): TerminalNode
    fun matrix(): MatrixContext?
}

expect fun SymbolDeclContext.allSymbolNames(): List<SymbolNameContext>

expect class SymbolNameContext : ParserRuleContext {
    fun text(): TextContext
}


expect class SyllableDeclContext : ParserRuleContext {
    fun SYLLABLE_DECL(): TerminalNode
    fun RULE_START(): TerminalNode
    fun EXPLICIT_SYLLABLES(): TerminalNode?
}

expect fun SyllableDeclContext.allSyllablePatterns(): List<SyllablePatternContext>

expect class SyllablePatternContext : ParserRuleContext {
    fun ruleElement(): RuleElementContext
    fun compoundEnvironment(): CompoundEnvironmentContext
}


expect class DeromanizerContext : ParserRuleContext {
    fun DEROMANIZER(): TerminalNode
    fun WHITESPACE(): TerminalNode?
    fun LITERAL(): TerminalNode?
    fun RULE_START(): TerminalNode
    fun block(): BlockContext
}


expect class RomanizerContext : ParserRuleContext {
    fun ROMANIZER(): TerminalNode
    fun WHITESPACE(): TerminalNode?
    fun LITERAL(): TerminalNode?
    fun RULE_START(): TerminalNode
    fun block(): BlockContext
}


expect class InterRomanizerContext : ParserRuleContext {
    fun ROMANIZER(): TerminalNode
    fun HYPHEN(): TerminalNode
    fun ruleName(): RuleNameContext
    fun WHITESPACE(): TerminalNode?
    fun LITERAL(): TerminalNode?
    fun RULE_START(): TerminalNode
    fun block(): BlockContext
}


expect class ChangeRuleContext : ParserRuleContext {
    fun ruleName(): RuleNameContext
    fun RULE_START(): TerminalNode?
    fun block(): BlockContext
}

expect fun ChangeRuleContext.allChangeRuleModifiers(): List<ChangeRuleModifierContext>

expect class ChangeRuleModifierContext : ParserRuleContext {
    fun filter(): FilterContext?
    fun PROPAGATE(): TerminalNode?
}


expect class FilterContext : ParserRuleContext {
    fun classRef(): ClassRefContext?
    fun fancyMatrix(): FancyMatrixContext?
}


expect class BlockContext : ParserRuleContext {

}

expect fun BlockContext.allBlockElements(): List<BlockElementContext>

expect fun BlockContext.allBlockTypes(): List<BlockTypeContext>

expect class BlockElementContext : ParserRuleContext {
    fun expressionList(): ExpressionListContext?
    fun O_PAREN(): TerminalNode?
    fun block(): BlockContext?
    fun C_PAREN(): TerminalNode?
}


expect class BlockTypeContext : ParserRuleContext {
    fun ALL_MATCHING(): TerminalNode?
    fun FIRST_MATCHING(): TerminalNode?
}


expect class ExpressionListContext : ParserRuleContext {

}

expect fun ExpressionListContext.allExpressions(): List<ExpressionContext>

expect class RuleNameContext : ParserRuleContext {

}


expect class ExpressionContext : ParserRuleContext {
    fun UNCHANGED(): TerminalNode?
    fun from(): FromContext?
    fun CHANGE(): TerminalNode?
    fun to(): ToContext?
    fun compoundEnvironment(): CompoundEnvironmentContext?
}


expect class FromContext : ParserRuleContext {
    fun ruleElement(): RuleElementContext
}


expect class ToContext : ParserRuleContext {
    fun ruleElement(): RuleElementContext
}


expect class RuleElementContext : ParserRuleContext {
    fun bounded(): BoundedContext?
    fun intersection(): IntersectionContext?
    fun negated(): NegatedContext?
    fun postfix(): PostfixContext?
    fun simple(): SimpleContext?
    fun sequence(): SequenceContext?
    fun lookaround(): LookaroundContext?
}


expect class BoundedContext : ParserRuleContext {
    fun group(): GroupContext?
    fun list(): ListContext?
}


expect class GroupContext : ParserRuleContext {
    fun O_PAREN(): TerminalNode
    fun ruleElement(): RuleElementContext
    fun C_PAREN(): TerminalNode
}


expect class ListContext : ParserRuleContext {
    fun LIST_START(): TerminalNode
    fun LIST_END(): TerminalNode
}

expect fun ListContext.allRuleElements(): List<RuleElementContext>

expect class SequenceContext : ParserRuleContext {

}

expect fun SequenceContext.allFreeElements(): List<FreeElementContext>

expect class LookaroundContext : ParserRuleContext {
    fun O_PAREN(): TerminalNode
    fun freeElement(): FreeElementContext
    fun compoundEnvironment(): CompoundEnvironmentContext
    fun C_PAREN(): TerminalNode
}


expect class FreeElementContext : ParserRuleContext {
    fun bounded(): BoundedContext?
    fun intersection(): IntersectionContext?
    fun negated(): NegatedContext?
    fun postfix(): PostfixContext?
    fun simple(): SimpleContext?
}


expect class CompoundEnvironmentContext : ParserRuleContext {
    fun CONDITION(): TerminalNode?
    fun condition(): ConditionContext?
    fun EXCLUSION(): TerminalNode?
    fun exclusion(): ExclusionContext?
}


expect class ConditionContext : ParserRuleContext {
    fun environment(): EnvironmentContext?
    fun environmentList(): EnvironmentListContext?
}


expect class ExclusionContext : ParserRuleContext {
    fun environment(): EnvironmentContext?
    fun environmentList(): EnvironmentListContext?
}


expect class EnvironmentListContext : ParserRuleContext {
    fun LIST_START(): TerminalNode
    fun LIST_END(): TerminalNode
}

expect fun EnvironmentListContext.allEnvironments(): List<EnvironmentContext>

expect class EnvironmentContext : ParserRuleContext {
    fun environmentBefore(): EnvironmentBeforeContext?
    fun ANCHOR(): TerminalNode?
    fun environmentAfter(): EnvironmentAfterContext?
}


expect class EnvironmentBeforeContext : ParserRuleContext {
    fun ruleElement(): RuleElementContext
}


expect class EnvironmentAfterContext : ParserRuleContext {
    fun ruleElement(): RuleElementContext
}


expect class IntersectionContext : ParserRuleContext {

}

expect fun IntersectionContext.allInterfixElements(): List<InterfixElementContext>

expect class InterfixElementContext : ParserRuleContext {
    fun bounded(): BoundedContext?
    fun negated(): NegatedContext?
    fun postfix(): PostfixContext?
    fun simple(): SimpleContext?
}


expect class NegatedContext : ParserRuleContext {
    fun NEGATION(): TerminalNode
    fun simple(): SimpleContext
}


expect class PostfixContext : ParserRuleContext {
    fun capture(): CaptureContext?
    fun repeater(): RepeaterContext?
}


expect class CaptureContext : ParserRuleContext {
    fun bounded(): BoundedContext?
    fun negated(): NegatedContext?
    fun simple(): SimpleContext?
    fun captureRef(): CaptureRefContext
}


expect class RepeaterContext : ParserRuleContext {
    fun bounded(): BoundedContext?
    fun simple(): SimpleContext?
    fun repeaterType(): RepeaterTypeContext
}


expect class SimpleContext : ParserRuleContext {
    fun classRef(): ClassRefContext?
    fun captureRef(): CaptureRefContext?
    fun fancyMatrix(): FancyMatrixContext?
    fun empty(): EmptyContext?
    fun boundary(): BoundaryContext?
    fun betweenWords(): BetweenWordsContext?
    fun text(): TextContext?
}


expect class ClassRefContext : ParserRuleContext {
    fun CLASSREF(): TerminalNode
    fun name(): NameContext
}


expect class CaptureRefContext : ParserRuleContext {
    fun WORD_BOUNDARY(): TerminalNode
    fun NUMBER(): TerminalNode
}


expect class FancyMatrixContext : ParserRuleContext {
    fun MATRIX_START(): TerminalNode
    fun MATRIX_END(): TerminalNode
}

expect fun FancyMatrixContext.allFancyValues(): List<FancyValueContext>

expect class FancyValueContext : ParserRuleContext {
    fun plusFeatureValue(): PlusFeatureValueContext?
    fun featureValue(): FeatureValueContext?
    fun negatedValue(): NegatedValueContext?
    fun absentFeature(): AbsentFeatureContext?
    fun featureVariable(): FeatureVariableContext?
}


expect class NegatedValueContext : ParserRuleContext {
    fun NEGATION(): TerminalNode
    fun name(): NameContext
}


expect class AbsentFeatureContext : ParserRuleContext {
    fun NULL(): TerminalNode
    fun name(): NameContext
}


expect class FeatureVariableContext : ParserRuleContext {
    fun WORD_BOUNDARY(): TerminalNode
    fun name(): NameContext
}


expect class EmptyContext : ParserRuleContext {
    fun NULL(): TerminalNode
}


expect class BoundaryContext : ParserRuleContext {
    fun WORD_BOUNDARY(): TerminalNode
}


expect class BetweenWordsContext : ParserRuleContext {
    fun BETWEEN_WORDS(): TerminalNode
}


expect class RepeaterTypeContext : ParserRuleContext {
    fun AT_LEAST_ONE(): TerminalNode?
    fun NULL(): TerminalNode?
    fun OPTIONAL(): TerminalNode?
}


expect class MatrixContext : ParserRuleContext {
    fun MATRIX_START(): TerminalNode
    fun MATRIX_END(): TerminalNode
}

expect fun MatrixContext.allMatrixValues(): List<MatrixValueContext>

expect class MatrixValueContext : ParserRuleContext {
    fun plusFeatureValue(): PlusFeatureValueContext?
    fun featureValue(): FeatureValueContext?
}


expect class PlusFeatureValueContext : ParserRuleContext {
    fun AT_LEAST_ONE(): TerminalNode?
    fun HYPHEN(): TerminalNode?
    fun name(): NameContext
}


expect class FeatureValueContext : ParserRuleContext {
    fun name(): NameContext
}


expect class NameContext : ParserRuleContext {
    fun NAME(): TerminalNode
}


expect class TextContext : ParserRuleContext {
    fun NAME(): TerminalNode?
    fun STR1(): TerminalNode?
    fun STR(): TerminalNode?
    fun NEGATION(): TerminalNode?
}


