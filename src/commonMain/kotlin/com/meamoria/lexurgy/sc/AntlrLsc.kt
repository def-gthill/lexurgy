@file:Suppress("FunctionName")

package com.meamoria.lexurgy.sc

import com.meamoria.mpp.antlr.*

expect class LscLexer(input: CharStream) : Lexer

expect class LscParser(input: TokenStream) : Parser {
    fun lscFile(): LscFileContext
    fun featureDecl(): FeatureDeclContext
    fun diacriticDecl(): DiacriticDeclContext
    fun symbolDecl(): SymbolDeclContext
    fun deromanizer(): DeromanizerContext
    fun romanizer(): RomanizerContext
    fun changeRule(): ChangeRuleContext
    fun matrix(): MatrixContext
    fun feature(): FeatureContext
    fun value(): ValueContext
}

expect open class LscBaseVisitor<T>() {
    fun visit(tree: ParseTree): T

    open fun visitLscFile(ctx: LscFileContext): T
    open fun visitClassDecl(ctx: ClassDeclContext): T
    open fun visitClassElement(ctx: ClassElementContext): T
    open fun visitFeatureDecl(ctx: FeatureDeclContext): T
    open fun visitNullAlias(ctx: NullAliasContext): T
    open fun visitDiacriticDecl(ctx: DiacriticDeclContext): T
    open fun visitSymbolDecl(ctx: SymbolDeclContext): T
    open fun visitSymbolName(ctx: SymbolNameContext): T
    open fun visitDeromanizer(ctx: DeromanizerContext): T
    open fun visitRomanizer(ctx: RomanizerContext): T
    open fun visitInterRomanizer(ctx: InterRomanizerContext): T
    open fun visitChangeRule(ctx: ChangeRuleContext): T
    open fun visitFilter(ctx: FilterContext): T
    open fun visitSubrules(ctx: SubrulesContext): T
    open fun visitSubrule(ctx: SubruleContext): T
    open fun visitRuleName(ctx: RuleNameContext): T
    open fun visitExpression(ctx: ExpressionContext): T
    open fun visitCondition(ctx: ConditionContext): T
    open fun visitExclusion(ctx: ExclusionContext): T
    open fun visitFrom(ctx: FromContext): T
    open fun visitTo(ctx: ToContext): T
    open fun visitEnvironmentList(ctx: EnvironmentListContext): T
    open fun visitEnvironment(ctx: EnvironmentContext): T
    open fun visitEnvironmentBefore(ctx: EnvironmentBeforeContext): T
    open fun visitEnvironmentAfter(ctx: EnvironmentAfterContext): T
    open fun visitRuleElement(ctx: RuleElementContext): T
    open fun visitSequence(ctx: SequenceContext): T
    open fun visitSequenceElement(ctx: SequenceElementContext): T
    open fun visitCapture(ctx: CaptureContext): T
    open fun visitRepeater(ctx: RepeaterContext): T
    open fun visitGroup(ctx: GroupContext): T
    open fun visitList(ctx: ListContext): T
    open fun visitSimple(ctx: SimpleContext): T
    open fun visitNegated(ctx: NegatedContext): T
    open fun visitClassRef(ctx: ClassRefContext): T
    open fun visitCaptureRef(ctx: CaptureRefContext): T
    open fun visitFancyMatrix(ctx: FancyMatrixContext): T
    open fun visitFancyValue(ctx: FancyValueContext): T
    open fun visitNegatedValue(ctx: NegatedValueContext): T
    open fun visitAbsentFeature(ctx: AbsentFeatureContext): T
    open fun visitFeatureVariable(ctx: FeatureVariableContext): T
    open fun visitEmpty(ctx: EmptyContext): T
    open fun visitBoundary(ctx: BoundaryContext): T
    open fun visitRepeaterType(ctx: RepeaterTypeContext): T
    open fun visitMatrix(ctx: MatrixContext): T
    open fun visitFeature(ctx: FeatureContext): T
    open fun visitValue(ctx: ValueContext): T
    open fun visitText(ctx: TextContext): T
}

expect class LscFileContext : ParserRuleContext

expect fun LscFileContext.allStatements(): List<StatementContext>

expect class StatementContext : ParserRuleContext

expect class ClassDeclContext : ParserRuleContext {
    fun value(): ValueContext
}

expect fun ClassDeclContext.allClassElements(): List<ClassElementContext>

expect class ClassElementContext : ParserRuleContext

expect class FeatureDeclContext : ParserRuleContext {
    fun feature(): FeatureContext
    fun nullAlias(): NullAliasContext?
    fun matrix(): MatrixContext?
}

expect fun FeatureDeclContext.allValues(): List<ValueContext>

expect class NullAliasContext : ParserRuleContext {
    fun value(): ValueContext
}

expect class DiacriticDeclContext : ParserRuleContext {
    fun STR1(): TerminalNode
    fun matrix(): MatrixContext
    fun DIA_BEFORE(): TerminalNode?
    fun DIA_FLOATING(): TerminalNode?
}

expect class SymbolDeclContext : ParserRuleContext {
    fun matrix(): MatrixContext?
}

expect fun SymbolDeclContext.allSymbolNames(): List<SymbolNameContext>

expect class SymbolNameContext : ParserRuleContext

expect class DeromanizerContext : ParserRuleContext {
    fun LITERAL(): TerminalNode?
    fun subrules(): SubrulesContext
}

expect class RomanizerContext : ParserRuleContext {
    fun LITERAL(): TerminalNode?
    fun subrules(): SubrulesContext
}

expect class InterRomanizerContext : ParserRuleContext {
    fun LITERAL(): TerminalNode?
    fun ruleName(): RuleNameContext
    fun subrules(): SubrulesContext
}

expect class ChangeRuleContext : ParserRuleContext {
    fun ruleName(): RuleNameContext
    fun subrules(): SubrulesContext
    fun filter(): FilterContext?
    fun PROPAGATE(): TerminalNode?
}

expect class FilterContext : ParserRuleContext

expect class SubrulesContext : ParserRuleContext

expect fun SubrulesContext.allSubrules(): List<SubruleContext>

expect class SubruleContext : ParserRuleContext

expect fun SubruleContext.allExpressions(): List<ExpressionContext>

expect class RuleNameContext : ParserRuleContext

expect class ExpressionContext : ParserRuleContext {
    fun UNCHANGED(): TerminalNode?
    fun from(): FromContext?
    fun to(): ToContext?
    fun condition(): ConditionContext?
    fun exclusion(): ExclusionContext?
}

expect class ConditionContext : ParserRuleContext

expect class ExclusionContext : ParserRuleContext

expect class FromContext : ParserRuleContext {
    fun ruleElement(): RuleElementContext
}

expect class ToContext : ParserRuleContext {
    fun ruleElement(): RuleElementContext
}

expect class EnvironmentListContext : ParserRuleContext

expect fun EnvironmentListContext.allEnvironments(): List<EnvironmentContext>

expect class EnvironmentContext : ParserRuleContext {
    fun environmentBefore(): EnvironmentBeforeContext?
    fun environmentAfter(): EnvironmentAfterContext?
    fun ANCHOR(): TerminalNode?
}

expect class EnvironmentBeforeContext : ParserRuleContext {
    fun ruleElement(): RuleElementContext
}

expect class EnvironmentAfterContext : ParserRuleContext {
    fun ruleElement(): RuleElementContext
}

expect class RuleElementContext : ParserRuleContext

expect class SequenceContext : ParserRuleContext

expect fun SequenceContext.allSequenceElements(): List<SequenceElementContext>

expect class SequenceElementContext : ParserRuleContext

expect class CaptureContext : ParserRuleContext {
    fun captureRef(): CaptureRefContext
}

expect class RepeaterContext : ParserRuleContext {
    fun repeaterType(): RepeaterTypeContext
}

expect class GroupContext : ParserRuleContext {
    fun ruleElement(): RuleElementContext
}

expect class ListContext : ParserRuleContext

expect fun ListContext.allRuleElements(): List<RuleElementContext>

expect class SimpleContext : ParserRuleContext

expect class NegatedContext : ParserRuleContext

expect class ClassRefContext : ParserRuleContext {
    fun value(): ValueContext
}

expect class CaptureRefContext : ParserRuleContext {
    fun NUMBER(): TerminalNode
}

expect class FancyMatrixContext : ParserRuleContext

expect fun FancyMatrixContext.allFancyValues(): List<FancyValueContext>

expect class FancyValueContext : ParserRuleContext

expect class NegatedValueContext : ParserRuleContext {
    fun value(): ValueContext
}

expect class AbsentFeatureContext : ParserRuleContext {
    fun feature(): FeatureContext
}

expect class FeatureVariableContext : ParserRuleContext {
    fun feature(): FeatureContext
}

expect class EmptyContext : ParserRuleContext

expect class BoundaryContext : ParserRuleContext

expect class RepeaterTypeContext : ParserRuleContext {
    fun AT_LEAST_ONE(): TerminalNode?
    fun NULL(): TerminalNode?
    fun OPTIONAL(): TerminalNode?
}

expect class MatrixContext : ParserRuleContext

expect fun MatrixContext.allValues(): List<ValueContext>

expect class FeatureContext : ParserRuleContext {
    fun FEATURE(): TerminalNode
}

expect class ValueContext : ParserRuleContext {
    fun VALUE(): TerminalNode
}

expect class TextContext : ParserRuleContext {
    fun NEGATION(): TerminalNode?
}

expect val LSC_NEWLINE: Int
expect val LSC_FEATURE: Int
expect val LSC_VALUE: Int
