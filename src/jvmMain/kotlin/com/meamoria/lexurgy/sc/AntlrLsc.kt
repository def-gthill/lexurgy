package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.java.LscBaseVisitor
import com.meamoria.lexurgy.sc.java.LscLexer
import com.meamoria.lexurgy.sc.java.LscParser
import org.antlr.v4.runtime.ANTLRErrorListener

actual typealias LscLexer = LscLexer

actual typealias LscParser = LscParser

actual typealias LscBaseVisitor<T> = LscBaseVisitor<T>

actual typealias LscFileContext = LscParser.LscFileContext

actual fun LscFileContext.allFeatureDecls(): List<FeatureDeclContext> = featureDecl()
actual fun LscFileContext.allDiacriticDecls(): List<DiacriticDeclContext> = diacriticDecl()
actual fun LscFileContext.allSymbolDecls(): List<SymbolDeclContext> = symbolDecl()
actual fun LscFileContext.allClassDecls(): List<ClassDeclContext> = classDecl()
actual fun LscFileContext.allChangeRules(): List<ChangeRuleContext> = changeRule()
actual fun LscFileContext.allInterRomanizers(): List<InterRomanizerContext> = interRomanizer()

actual typealias ClassDeclContext = LscParser.ClassDeclContext

actual fun ClassDeclContext.allClassElements(): List<ClassElementContext> = classElement()

actual typealias ClassElementContext = LscParser.ClassElementContext

actual typealias FeatureDeclContext = LscParser.FeatureDeclContext

actual fun FeatureDeclContext.allValues(): List<ValueContext> = value()

actual typealias NullAliasContext = LscParser.NullAliasContext

actual typealias DiacriticDeclContext = LscParser.DiacriticDeclContext

actual typealias SymbolDeclContext = LscParser.SymbolDeclContext

actual fun SymbolDeclContext.allSymbolNames(): List<SymbolNameContext> = symbolName()

actual typealias SymbolNameContext = LscParser.SymbolNameContext

actual typealias DeromanizerContext = LscParser.DeromanizerContext

actual typealias RomanizerContext = LscParser.RomanizerContext

actual typealias InterRomanizerContext = LscParser.InterRomanizerContext

actual typealias ChangeRuleContext = LscParser.ChangeRuleContext

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

actual typealias BoundaryBeforeContext = LscParser.BoundaryBeforeContext

actual typealias BoundaryAfterContext = LscParser.BoundaryAfterContext

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

actual typealias RepeaterTypeContext = LscParser.RepeaterTypeContext

actual typealias MatrixContext = LscParser.MatrixContext

actual fun MatrixContext.allValues(): List<ValueContext> = value()

actual typealias FeatureContext = LscParser.FeatureContext

actual typealias ValueContext = LscParser.ValueContext

actual typealias TextContext = LscParser.TextContext
