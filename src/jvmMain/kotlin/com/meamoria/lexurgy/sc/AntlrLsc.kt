package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.java.LscBaseVisitor
import com.meamoria.lexurgy.sc.java.LscLexer
import com.meamoria.lexurgy.sc.java.LscParser
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

actual fun FeatureDeclContext.allPlusFeatures(): List<PlusFeatureContext> = plusFeature()

actual fun FeatureDeclContext.allFeatureValues(): List<FeatureValueContext> = featureValue()

actual typealias PlusFeatureContext = LscParser.PlusFeatureContext

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

actual typealias IntersectionContext = LscParser.IntersectionContext

actual fun IntersectionContext.allIntersectionElements(): List<IntersectionElementContext> = intersectionElement()

actual typealias IntersectionElementContext = LscParser.IntersectionElementContext

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

actual typealias BetweenWordsContext = LscParser.BetweenWordsContext

actual typealias RepeaterTypeContext = LscParser.RepeaterTypeContext

actual typealias MatrixContext = LscParser.MatrixContext

actual fun MatrixContext.allMatrixValues(): List<MatrixValueContext> = matrixValue()

actual typealias MatrixValueContext = LscParser.MatrixValueContext

actual typealias PlusFeatureValueContext = LscParser.PlusFeatureValueContext

actual typealias FeatureValueContext = LscParser.FeatureValueContext

actual typealias NameContext = LscParser.NameContext

actual typealias TextContext = LscParser.TextContext
