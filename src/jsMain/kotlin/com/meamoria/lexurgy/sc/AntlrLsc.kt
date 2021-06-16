@file:Suppress("FunctionName", "unused", "PropertyName")

package com.meamoria.lexurgy.sc

import com.meamoria.mpp.antlr.*

actual external class LscLexer actual constructor(input: CharStream) : Lexer

actual external class LscParser actual constructor(input: TokenStream) : Parser {
    actual fun lscFile(): LscFileContext

    actual fun featureDecl(): FeatureDeclContext

    actual fun diacriticDecl(): DiacriticDeclContext

    actual fun symbolDecl(): SymbolDeclContext

    actual fun deromanizer(): DeromanizerContext

    actual fun romanizer(): RomanizerContext

    actual fun changeRule(): ChangeRuleContext

    actual fun matrix(): MatrixContext

    actual fun name(): NameContext

    class LscFileContext : ParserRuleContext {
        fun statement(): Array<StatementContext>
    }

    class StatementContext : ParserRuleContext

    class ClassDeclContext : ParserRuleContext {
        fun name(): NameContext
        fun classElement(): Array<ClassElementContext>
    }

    class ClassElementContext : ParserRuleContext

    class FeatureDeclContext : ParserRuleContext {
        fun plusFeature(): Array<PlusFeatureContext>
        fun name(): NameContext?
        fun featureValue(): Array<FeatureValueContext>
        fun nullAlias(): NullAliasContext?
    }

    class PlusFeatureContext : ParserRuleContext {
        fun AT_LEAST_ONE(): TerminalNode?
        fun name(): NameContext
    }

    class NullAliasContext : ParserRuleContext {
        fun featureValue(): FeatureValueContext
    }

    class DiacriticDeclContext : ParserRuleContext {
        fun text(): TextContext
        fun matrix(): MatrixContext
        fun diacriticModifier(): Array<DiacriticModifierContext>
    }

    class DiacriticModifierContext : ParserRuleContext {
        fun DIA_BEFORE(): TerminalNode?
        fun DIA_FLOATING(): TerminalNode?
    }

    class SymbolDeclContext : ParserRuleContext {
        fun matrix(): MatrixContext?
        fun symbolName(): Array<SymbolNameContext>
    }

    class SymbolNameContext : ParserRuleContext

    class SyllableDeclContext : ParserRuleContext {
        fun syllablePattern(): Array<SyllablePatternContext>
    }

    class SyllablePatternContext : ParserRuleContext {
        fun syllableElement(): Array<SyllableElementContext>
    }

    class SyllableElementContext : ParserRuleContext

    class DeromanizerContext : ParserRuleContext {
        fun LITERAL(): TerminalNode?
        fun block(): BlockContext
    }

    class RomanizerContext : ParserRuleContext {
        fun LITERAL(): TerminalNode?
        fun block(): BlockContext
    }

    class InterRomanizerContext : ParserRuleContext {
        fun LITERAL(): TerminalNode?
        fun ruleName(): RuleNameContext
        fun block(): BlockContext
    }

    class ChangeRuleContext : ParserRuleContext {
        fun ruleName(): RuleNameContext
        fun RULE_START(): TerminalNode?
        fun NEWLINE(): Array<TerminalNode>
        fun block(): BlockContext
        fun changeRuleModifier(): Array<ChangeRuleModifierContext>
    }

    class ChangeRuleModifierContext : ParserRuleContext {
        fun filter(): FilterContext?
        fun PROPAGATE(): TerminalNode?
    }

    class FilterContext : ParserRuleContext

    class BlockContext : ParserRuleContext {
        fun blockType(): Array<BlockTypeContext>
        fun blockElement(): Array<BlockElementContext>
    }

    class BlockElementContext : ParserRuleContext {
        fun block(): BlockContext?
        fun expressionList(): ExpressionListContext?
    }

    class BlockTypeContext : ParserRuleContext {
        fun ALL_MATCHING(): TerminalNode?
        fun FIRST_MATCHING(): TerminalNode?
    }

    class ExpressionListContext : ParserRuleContext {
        fun expression(): Array<ExpressionContext>
    }

    class RuleNameContext : ParserRuleContext

    class ExpressionContext : ParserRuleContext {
        fun UNCHANGED(): TerminalNode?
        fun from(): FromContext?
        fun to(): ToContext?
        fun compoundEnvironment(): CompoundEnvironmentContext
    }

    class FromContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class ToContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class RuleElementContext : ParserRuleContext

    class BoundedContext : ParserRuleContext

    class GroupContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class ListContext : ParserRuleContext {
        fun ruleElement(): Array<RuleElementContext>
    }

    class FreeContext : ParserRuleContext

    class SequenceContext : ParserRuleContext {
        fun freeElement(): Array<FreeElementContext>
    }

    class LookaroundContext : ParserRuleContext {
        fun freeElement(): FreeElementContext
        fun compoundEnvironment(): CompoundEnvironmentContext
    }

    class FreeElementContext : ParserRuleContext

    class CompoundEnvironmentContext : ParserRuleContext {
        fun condition(): ConditionContext?
        fun exclusion(): ExclusionContext?
    }

    class ConditionContext : ParserRuleContext

    class ExclusionContext : ParserRuleContext

    class EnvironmentListContext : ParserRuleContext {
        fun environment(): Array<EnvironmentContext>
    }

    class EnvironmentContext : ParserRuleContext {
        fun environmentBefore(): EnvironmentBeforeContext?
        fun environmentAfter(): EnvironmentAfterContext?
        fun ANCHOR(): TerminalNode?
    }

    class EnvironmentBeforeContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class EnvironmentAfterContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class InterfixContext : ParserRuleContext

    class IntersectionContext : ParserRuleContext {
        fun interfixElement(): Array<InterfixElementContext>
    }

    class InterfixElementContext : ParserRuleContext

    class PrefixContext : ParserRuleContext

    class NegatedContext : ParserRuleContext

    class PostfixContext : ParserRuleContext

    class CaptureContext : ParserRuleContext {
        fun captureRef(): CaptureRefContext
    }

    class RepeaterContext : ParserRuleContext {
        fun repeaterType(): RepeaterTypeContext
    }

    class SimpleContext : ParserRuleContext

    class ClassRefContext : ParserRuleContext {
        fun name(): NameContext
    }

    class CaptureRefContext : ParserRuleContext {
        fun NUMBER(): TerminalNode
    }

    class FancyMatrixContext : ParserRuleContext {
        fun fancyValue(): Array<FancyValueContext>
    }

    class FancyValueContext : ParserRuleContext

    class NegatedValueContext : ParserRuleContext {
        fun name(): NameContext
    }

    class AbsentFeatureContext : ParserRuleContext {
        fun name(): NameContext
    }

    class FeatureVariableContext : ParserRuleContext {
        fun name(): NameContext
    }

    class EmptyContext : ParserRuleContext

    class BoundaryContext : ParserRuleContext

    class BetweenWordsContext : ParserRuleContext

    class RepeaterTypeContext : ParserRuleContext {
        fun AT_LEAST_ONE(): TerminalNode?
        fun NULL(): TerminalNode?
        fun OPTIONAL(): TerminalNode?
    }

    class MatrixContext : ParserRuleContext {
        fun matrixValue(): Array<MatrixValueContext>
    }

    class MatrixValueContext : ParserRuleContext

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
        fun NEGATION(): TerminalNode?
    }
}

@Suppress("unused")
open external class LscVisitor<T> {
    fun visit(tree: ParseTree): T

    open fun visitLscFile(ctx: LscFileContext): T

    open fun visitClassDecl(ctx: ClassDeclContext): T

    open fun visitClassElement(ctx: ClassElementContext): T

    open fun visitFeatureDecl(ctx: FeatureDeclContext): T

    open fun visitPlusFeature(ctx: PlusFeatureContext): T

    open fun visitNullAlias(ctx: NullAliasContext): T

    open fun visitDiacriticDecl(ctx: DiacriticDeclContext): T

    open fun visitSymbolDecl(ctx: SymbolDeclContext): T

    open fun visitSymbolName(ctx: SymbolNameContext): T

    open fun visitSyllableDecl(ctx: SyllableDeclContext): T

    open fun visitSyllablePattern(ctx: SyllablePatternContext): T

    open fun visitSyllableElement(ctx: SyllableElementContext): T

    open fun visitDeromanizer(ctx: DeromanizerContext): T

    open fun visitRomanizer(ctx: RomanizerContext): T

    open fun visitInterRomanizer(ctx: InterRomanizerContext): T

    open fun visitChangeRule(ctx: ChangeRuleContext): T

    open fun visitFilter(ctx: FilterContext): T

    open fun visitBlock(ctx: BlockContext): T

    open fun visitBlockElement(ctx: BlockElementContext): T

    open fun visitExpressionList(ctx: ExpressionListContext): T

    open fun visitRuleName(ctx: RuleNameContext): T

    open fun visitExpression(ctx: ExpressionContext): T

    open fun visitFrom(ctx: FromContext): T

    open fun visitTo(ctx: ToContext): T

    open fun visitRuleElement(ctx: RuleElementContext): T

    open fun visitBounded(ctx: BoundedContext): T

    open fun visitGroup(ctx: GroupContext): T

    open fun visitList(ctx: ListContext): T

    open fun visitFree(ctx: FreeContext): T

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

    open fun visitInterfix(ctx: InterfixContext): T

    open fun visitIntersection(ctx: IntersectionContext): T

    open fun visitInterfixElement(ctx: InterfixElementContext): T

    open fun visitPrefix(ctx: PrefixContext): T

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

actual typealias PlusFeatureContext = LscParser.PlusFeatureContext

actual typealias NullAliasContext = LscParser.NullAliasContext

actual typealias DiacriticDeclContext = LscParser.DiacriticDeclContext

actual fun DiacriticDeclContext.allDiacriticModifiers(): List<DiacriticModifierContext> = diacriticModifier().toList()

actual typealias DiacriticModifierContext = LscParser.DiacriticModifierContext

actual typealias SymbolDeclContext = LscParser.SymbolDeclContext

actual fun SymbolDeclContext.allSymbolNames(): List<SymbolNameContext> = symbolName().toList()

actual typealias SymbolNameContext = LscParser.SymbolNameContext

actual typealias SyllableDeclContext = LscParser.SyllableDeclContext

actual fun SyllableDeclContext.allSyllablePatterns(): List<SyllablePatternContext> =
    syllablePattern().toList()

actual typealias SyllablePatternContext = LscParser.SyllablePatternContext

actual fun SyllablePatternContext.allSyllableElements(): List<SyllableElementContext> =
    syllableElement().toList()

actual typealias SyllableElementContext = LscParser.SyllableElementContext

actual typealias DeromanizerContext = LscParser.DeromanizerContext

actual typealias RomanizerContext = LscParser.RomanizerContext

actual typealias InterRomanizerContext = LscParser.InterRomanizerContext

actual typealias ChangeRuleContext = LscParser.ChangeRuleContext

actual fun ChangeRuleContext.allChangeRuleModifiers(): List<ChangeRuleModifierContext> = changeRuleModifier().toList()

actual fun ChangeRuleContext.firstNewline(): TerminalNode = NEWLINE().first()

actual typealias ChangeRuleModifierContext = LscParser.ChangeRuleModifierContext

actual typealias FilterContext = LscParser.FilterContext

actual typealias BlockContext = LscParser.BlockContext

actual fun BlockContext.allBlockTypes(): List<BlockTypeContext> = blockType().toList()

actual fun BlockContext.allBlockElements(): List<BlockElementContext> = blockElement().toList()

actual typealias BlockElementContext = LscParser.BlockElementContext

actual typealias BlockTypeContext = LscParser.BlockTypeContext

actual typealias ExpressionListContext = LscParser.ExpressionListContext

actual fun ExpressionListContext.allExpressions(): List<ExpressionContext> = expression().toList()

actual typealias RuleNameContext = LscParser.RuleNameContext

actual typealias ExpressionContext = LscParser.ExpressionContext

actual typealias FromContext = LscParser.FromContext

actual typealias ToContext = LscParser.ToContext

actual typealias RuleElementContext = LscParser.RuleElementContext

actual typealias BoundedContext = LscParser.BoundedContext

actual typealias GroupContext = LscParser.GroupContext

actual typealias ListContext = LscParser.ListContext

actual fun ListContext.allRuleElements(): List<RuleElementContext> = ruleElement().toList()

actual typealias FreeContext = LscParser.FreeContext

actual typealias SequenceContext = LscParser.SequenceContext

actual fun SequenceContext.allFreeElements(): List<FreeElementContext> = freeElement().toList()

actual typealias LookaroundContext = LscParser.LookaroundContext

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

actual typealias IntersectionContext = LscParser.IntersectionContext

actual fun IntersectionContext.allInterfixElements(): List<InterfixElementContext> =
    interfixElement().toList()

actual typealias InterfixElementContext = LscParser.InterfixElementContext

actual typealias PrefixContext = LscParser.PrefixContext

actual typealias NegatedContext = LscParser.NegatedContext

actual typealias PostfixContext = LscParser.PostfixContext

actual typealias CaptureContext = LscParser.CaptureContext

actual typealias RepeaterContext = LscParser.RepeaterContext

actual typealias SimpleContext = LscParser.SimpleContext

actual typealias ClassRefContext = LscParser.ClassRefContext

actual typealias CaptureRefContext = LscParser.CaptureRefContext

actual typealias FancyMatrixContext = LscParser.FancyMatrixContext

actual fun FancyMatrixContext.allFancyValues(): List<FancyValueContext> = fancyValue().toList()

actual typealias FancyValueContext = LscParser.FancyValueContext

actual typealias NegatedValueContext = LscParser.NegatedValueContext

actual typealias AbsentFeatureContext = LscParser.AbsentFeatureContext

actual typealias FeatureVariableContext = LscParser.FeatureVariableContext

actual typealias EmptyContext = LscParser.EmptyContext

actual typealias BoundaryContext = LscParser.BoundaryContext

actual typealias BetweenWordsContext = LscParser.BetweenWordsContext

actual typealias RepeaterTypeContext = LscParser.RepeaterTypeContext

actual typealias MatrixContext = LscParser.MatrixContext

actual fun MatrixContext.allMatrixValues(): List<MatrixValueContext> = matrixValue().toList()

actual typealias MatrixValueContext = LscParser.MatrixValueContext

actual typealias PlusFeatureValueContext = LscParser.PlusFeatureValueContext

actual typealias FeatureValueContext = LscParser.FeatureValueContext

actual typealias NameContext = LscParser.NameContext

actual typealias TextContext = LscParser.TextContext
