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

    actual fun feature(): FeatureContext

    actual fun value(): ValueContext

    class LscFileContext : ParserRuleContext {
        fun deromanizer(): DeromanizerContext?
        fun romanizer(): RomanizerContext?
        fun featureDecl(): Array<FeatureDeclContext>
        fun diacriticDecl(): Array<DiacriticDeclContext>
        fun symbolDecl(): Array<SymbolDeclContext>
        fun classDecl(): Array<ClassDeclContext>
        fun changeRule(): Array<ChangeRuleContext>
        fun interRomanizer(): Array<InterRomanizerContext>
    }

    class ClassDeclContext : ParserRuleContext {
        fun value(): ValueContext
        fun classElement(): Array<ClassElementContext>
    }

    class ClassElementContext : ParserRuleContext

    class FeatureDeclContext : ParserRuleContext {
        fun feature(): FeatureContext
        fun nullAlias(): NullAliasContext?
        fun matrix(): MatrixContext?
        fun value(): Array<ValueContext>
    }

    class NullAliasContext : ParserRuleContext {
        fun value(): ValueContext
    }

    class DiacriticDeclContext : ParserRuleContext {
        fun STR1(): TerminalNode
        fun matrix(): MatrixContext
        fun DIA_BEFORE(): TerminalNode?
        fun DIA_FLOATING(): TerminalNode?
    }

    class SymbolDeclContext : ParserRuleContext {
        fun matrix(): MatrixContext?
        fun symbolName(): Array<SymbolNameContext>
    }

    class SymbolNameContext : ParserRuleContext

    class DeromanizerContext : ParserRuleContext {
        fun subrules(): SubrulesContext
    }

    class RomanizerContext : ParserRuleContext {
        fun subrules(): SubrulesContext
    }

    class InterRomanizerContext : ParserRuleContext {
        fun ruleName(): RuleNameContext
        fun subrules(): SubrulesContext
    }

    class ChangeRuleContext : ParserRuleContext {
        fun ruleName(): RuleNameContext
        fun subrules(): SubrulesContext
        fun filter(): FilterContext?
        fun PROPAGATE(): TerminalNode?
    }

    class FilterContext : ParserRuleContext

    class SubrulesContext : ParserRuleContext {
        fun subrule(): Array<SubruleContext>
    }

    class SubruleContext : ParserRuleContext {
        fun expression(): Array<ExpressionContext>
    }

    class RuleNameContext : ParserRuleContext

    class ExpressionContext : ParserRuleContext {
        fun from(): FromContext
        fun to(): ToContext
        fun condition(): ConditionContext?
        fun exclusion(): ExclusionContext?
    }

    class ConditionContext : ParserRuleContext

    class ExclusionContext : ParserRuleContext

    class FromContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class ToContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class EnvironmentListContext : ParserRuleContext {
        fun environment(): Array<EnvironmentContext>
    }

    class EnvironmentContext : ParserRuleContext {
        fun environmentBefore(): EnvironmentBeforeContext?
        fun environmentAfter(): EnvironmentAfterContext?
        fun ANCHOR(): TerminalNode?
        fun boundaryBefore(): BoundaryBeforeContext?
        fun boundaryAfter(): BoundaryAfterContext?
    }

    class BoundaryBeforeContext : ParserRuleContext

    class BoundaryAfterContext : ParserRuleContext

    class EnvironmentBeforeContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class EnvironmentAfterContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class RuleElementContext : ParserRuleContext

    class SequenceContext : ParserRuleContext {
        fun sequenceElement(): Array<SequenceElementContext>
    }

    class SequenceElementContext : ParserRuleContext

    class CaptureContext : ParserRuleContext {
        fun captureRef(): CaptureRefContext
    }

    class RepeaterContext : ParserRuleContext {
        fun repeaterType(): RepeaterTypeContext
    }

    class GroupContext : ParserRuleContext {
        fun ruleElement(): RuleElementContext
    }

    class ListContext : ParserRuleContext {
        fun ruleElement(): Array<RuleElementContext>
    }

    class SimpleContext : ParserRuleContext

    class NegatedContext : ParserRuleContext

    class ClassRefContext : ParserRuleContext {
        fun value(): ValueContext
    }

    class CaptureRefContext : ParserRuleContext {
        fun NUMBER(): TerminalNode
    }

    class FancyMatrixContext : ParserRuleContext {
        fun fancyValue(): Array<FancyValueContext>
    }

    class FancyValueContext : ParserRuleContext

    class NegatedValueContext : ParserRuleContext {
        fun value(): ValueContext
    }

    class AbsentFeatureContext : ParserRuleContext {
        fun feature(): FeatureContext
    }

    class FeatureVariableContext : ParserRuleContext {
        fun feature(): FeatureContext
    }

    class EmptyContext : ParserRuleContext

    class RepeaterTypeContext : ParserRuleContext {
        fun AT_LEAST_ONE(): TerminalNode?
        fun NULL(): TerminalNode?
        fun OPTIONAL(): TerminalNode?
    }

    class MatrixContext : ParserRuleContext {
        fun value(): Array<ValueContext>
    }

    class FeatureContext : ParserRuleContext {
        fun FEATURE(): TerminalNode
    }

    class ValueContext : ParserRuleContext {
        fun VALUE(): TerminalNode
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

    open fun visitBoundaryBefore(ctx: BoundaryBeforeContext): T

    open fun visitBoundaryAfter(ctx: BoundaryAfterContext): T

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

    open fun visitRepeaterType(ctx: RepeaterTypeContext): T

    open fun visitMatrix(ctx: MatrixContext): T

    open fun visitFeature(ctx: FeatureContext): T

    open fun visitValue(ctx: ValueContext): T

    open fun visitText(ctx: TextContext): T
}

actual typealias LscBaseVisitor<T> = LscVisitor<T>

actual typealias LscFileContext = LscParser.LscFileContext

actual fun LscFileContext.allFeatureDecls(): List<FeatureDeclContext> = featureDecl().toList()
actual fun LscFileContext.allDiacriticDecls(): List<DiacriticDeclContext> = diacriticDecl().toList()
actual fun LscFileContext.allSymbolDecls(): List<SymbolDeclContext> = symbolDecl().toList()
actual fun LscFileContext.allClassDecls(): List<ClassDeclContext> = classDecl().toList()
actual fun LscFileContext.allChangeRules(): List<ChangeRuleContext> = changeRule().toList()
actual fun LscFileContext.allInterRomanizers(): List<InterRomanizerContext> = interRomanizer().toList()

actual typealias ClassDeclContext = LscParser.ClassDeclContext

actual fun ClassDeclContext.allClassElements(): List<ClassElementContext> = classElement().toList()

actual typealias ClassElementContext = LscParser.ClassElementContext

actual typealias FeatureDeclContext = LscParser.FeatureDeclContext

actual fun FeatureDeclContext.allValues(): List<ValueContext> = value().toList()

actual typealias NullAliasContext = LscParser.NullAliasContext

actual typealias DiacriticDeclContext = LscParser.DiacriticDeclContext

actual typealias SymbolDeclContext = LscParser.SymbolDeclContext

actual fun SymbolDeclContext.allSymbolNames(): List<SymbolNameContext> = symbolName().toList()

actual typealias SymbolNameContext = LscParser.SymbolNameContext

actual typealias DeromanizerContext = LscParser.DeromanizerContext

actual typealias RomanizerContext = LscParser.RomanizerContext

actual typealias InterRomanizerContext = LscParser.InterRomanizerContext

actual typealias ChangeRuleContext = LscParser.ChangeRuleContext

actual typealias FilterContext = LscParser.FilterContext

actual typealias SubrulesContext = LscParser.SubrulesContext

actual fun SubrulesContext.allSubrules(): List<SubruleContext> = subrule().toList()

actual typealias SubruleContext = LscParser.SubruleContext

actual fun SubruleContext.allExpressions(): List<ExpressionContext> = expression().toList()

actual typealias RuleNameContext = LscParser.RuleNameContext

actual typealias ExpressionContext = LscParser.ExpressionContext

actual typealias ConditionContext = LscParser.ConditionContext

actual typealias ExclusionContext = LscParser.ExclusionContext

actual typealias FromContext = LscParser.FromContext

actual typealias ToContext = LscParser.ToContext

actual typealias EnvironmentListContext = LscParser.EnvironmentListContext

actual fun EnvironmentListContext.allEnvironments(): List<EnvironmentContext> = environment().toList()

actual typealias EnvironmentContext = LscParser.EnvironmentContext

actual typealias BoundaryBeforeContext = LscParser.BoundaryBeforeContext

actual typealias BoundaryAfterContext = LscParser.BoundaryAfterContext

actual typealias EnvironmentBeforeContext = LscParser.EnvironmentBeforeContext

actual typealias EnvironmentAfterContext = LscParser.EnvironmentAfterContext

actual typealias RuleElementContext = LscParser.RuleElementContext

actual typealias SequenceContext = LscParser.SequenceContext

actual fun SequenceContext.allSequenceElements(): List<SequenceElementContext> = sequenceElement().toList()

actual typealias SequenceElementContext = LscParser.SequenceElementContext

actual typealias CaptureContext = LscParser.CaptureContext

actual typealias RepeaterContext = LscParser.RepeaterContext

actual typealias GroupContext = LscParser.GroupContext

actual typealias ListContext = LscParser.ListContext

actual fun ListContext.allRuleElements(): List<RuleElementContext> = ruleElement().toList()

actual typealias SimpleContext = LscParser.SimpleContext

actual typealias NegatedContext = LscParser.NegatedContext

actual typealias ClassRefContext = LscParser.ClassRefContext

actual typealias CaptureRefContext = LscParser.CaptureRefContext

actual typealias FancyMatrixContext = LscParser.FancyMatrixContext

actual fun FancyMatrixContext.allFancyValues(): List<FancyValueContext> = fancyValue().toList()

actual typealias FancyValueContext = LscParser.FancyValueContext

actual typealias NegatedValueContext = LscParser.NegatedValueContext

actual typealias AbsentFeatureContext = LscParser.AbsentFeatureContext

actual typealias FeatureVariableContext = LscParser.FeatureVariableContext

actual typealias EmptyContext = LscParser.EmptyContext

actual typealias RepeaterTypeContext = LscParser.RepeaterTypeContext

actual typealias MatrixContext = LscParser.MatrixContext

actual fun MatrixContext.allValues(): List<ValueContext> = value().toList()

actual typealias FeatureContext = LscParser.FeatureContext

actual typealias ValueContext = LscParser.ValueContext

actual typealias TextContext = LscParser.TextContext

actual val LSC_NEWLINE: Int = js("LscParser.NEWLINE") as Int
actual val LSC_FEATURE: Int = js("LscParser.FEATURE") as Int
actual val LSC_VALUE: Int = js("LscParser.VALUE") as Int