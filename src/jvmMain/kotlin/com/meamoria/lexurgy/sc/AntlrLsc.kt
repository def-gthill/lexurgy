package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.java.LscBaseVisitor
import com.meamoria.lexurgy.sc.java.LscLexer
import com.meamoria.lexurgy.sc.java.LscParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.tree.TerminalNode

actual typealias LscLexer = LscLexer

actual typealias LscParser = LscParser

actual typealias LscBaseVisitor<T> = LscBaseVisitor<T>

actual typealias LscFileContext = LscParser.LscFileContext

actual fun LscFileContext.allStatements(): List<StatementContext> = statement()

actual typealias StatementContext = LscParser.StatementContext

actual typealias ClassDeclContext = LscParser.ClassDeclContext

actual fun ClassDeclContext.allClassElements(): List<ClassElementContext> = classElement()

actual typealias ClassElementContext = LscParser.ClassElementContext

actual typealias FeatureDeclContext = LscParser.FeatureDeclContext

actual fun FeatureDeclContext.allValues(): List<ValueContext> = value()

actual typealias NullAliasContext = LscParser.NullAliasContext

actual typealias DiacriticDeclContext = LscParser.DiacriticDeclContext

actual fun DiacriticDeclContext.allDiacriticModifiers(): List<DiacriticModifierContext> = diacriticModifier()

actual typealias DiacriticModifierContext = LscParser.DiacriticModifierContext

actual typealias SymbolDeclContext = LscParser.SymbolDeclContext

actual fun SymbolDeclContext.allSymbolNames(): List<SymbolNameContext> = symbolName()

actual typealias SymbolNameContext = LscParser.SymbolNameContext

actual typealias DeromanizerContext = LscParser.DeromanizerContext

actual typealias RomanizerContext = LscParser.RomanizerContext

actual typealias InterRomanizerContext = LscParser.InterRomanizerContext

actual typealias ChangeRuleContext = LscParser.ChangeRuleContext

actual fun ChangeRuleContext.allChangeRuleModifiers(): List<ChangeRuleModifierContext> = changeRuleModifier()

actual fun ChangeRuleContext.firstNewline(): TerminalNode = NEWLINE(0)

actual typealias ChangeRuleModifierContext = LscParser.ChangeRuleModifierContext

actual typealias FilterContext = LscParser.FilterContext

actual typealias SubrulesContext = LscParser.SubrulesContext

actual fun SubrulesContext.allSubrules(): List<SubruleContext> = subrule()

actual typealias SubruleContext = LscParser.SubruleContext

actual fun SubruleContext.allExpressions(): List<ExpressionContext> = expression()

actual typealias RuleNameContext = LscParser.RuleNameContext

actual typealias ExpressionContext = LscParser.ExpressionContext

actual typealias ConditionContext = LscParser.ConditionContext

actual typealias ExclusionContext = LscParser.ExclusionContext

actual typealias FromContext = LscParser.FromContext

actual typealias ToContext = LscParser.ToContext

actual typealias EnvironmentListContext = LscParser.EnvironmentListContext

actual fun EnvironmentListContext.allEnvironments(): List<EnvironmentContext> = environment()

actual typealias EnvironmentContext = LscParser.EnvironmentContext

actual typealias EnvironmentBeforeContext = LscParser.EnvironmentBeforeContext

actual typealias EnvironmentAfterContext = LscParser.EnvironmentAfterContext

actual typealias RuleElementContext = LscParser.RuleElementContext

actual typealias SequenceContext = LscParser.SequenceContext

actual fun SequenceContext.allSequenceElements(): List<SequenceElementContext> = sequenceElement()

actual typealias SequenceElementContext = LscParser.SequenceElementContext

actual typealias CaptureContext = LscParser.CaptureContext

actual typealias RepeaterContext = LscParser.RepeaterContext

actual typealias GroupContext = LscParser.GroupContext

actual typealias ListContext = LscParser.ListContext

actual fun ListContext.allRuleElements(): List<RuleElementContext> = ruleElement()

actual typealias SimpleContext = LscParser.SimpleContext

actual typealias NegatedContext = LscParser.NegatedContext

actual typealias ClassRefContext = LscParser.ClassRefContext

actual typealias CaptureRefContext = LscParser.CaptureRefContext

actual typealias FancyMatrixContext = LscParser.FancyMatrixContext

actual fun FancyMatrixContext.allFancyValues(): List<FancyValueContext> = fancyValue()

actual typealias FancyValueContext = LscParser.FancyValueContext

actual typealias NegatedValueContext = LscParser.NegatedValueContext

actual typealias AbsentFeatureContext = LscParser.AbsentFeatureContext

actual typealias FeatureVariableContext = LscParser.FeatureVariableContext

actual typealias EmptyContext = LscParser.EmptyContext

actual typealias BoundaryContext = LscParser.BoundaryContext

actual typealias RepeaterTypeContext = LscParser.RepeaterTypeContext

actual typealias MatrixContext = LscParser.MatrixContext

actual fun MatrixContext.allValues(): List<ValueContext> = value()

actual typealias FeatureContext = LscParser.FeatureContext

actual typealias ValueContext = LscParser.ValueContext

actual typealias TextContext = LscParser.TextContext

actual val LSC_NEWLINE: Int = LscParser.NEWLINE
actual val LSC_FEATURE: Int = LscParser.FEATURE
actual val LSC_VALUE: Int = LscParser.VALUE
actual val LSC_RULE_START: Int = LscParser.RULE_START
actual val LSC_PROPAGATE: Int = LscParser.PROPAGATE
actual val LSC_O_PAREN: Int = LscParser.O_PAREN
