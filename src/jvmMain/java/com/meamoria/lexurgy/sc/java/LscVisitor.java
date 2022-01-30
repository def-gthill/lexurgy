// Generated from Lsc.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.sc.java;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LscParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LscVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LscParser#lscFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLscFile(LscParser.LscFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LscParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(LscParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#classElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassElement(LscParser.ClassElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#featureDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureDecl(LscParser.FeatureDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#featureModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureModifier(LscParser.FeatureModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#plusFeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusFeature(LscParser.PlusFeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#nullAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullAlias(LscParser.NullAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#diacriticDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiacriticDecl(LscParser.DiacriticDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#diacriticModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiacriticModifier(LscParser.DiacriticModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#symbolDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolDecl(LscParser.SymbolDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#symbolName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolName(LscParser.SymbolNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#syllableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyllableDecl(LscParser.SyllableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#syllablePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyllablePattern(LscParser.SyllablePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#deromanizer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeromanizer(LscParser.DeromanizerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#romanizer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRomanizer(LscParser.RomanizerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#interRomanizer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterRomanizer(LscParser.InterRomanizerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#changeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeRule(LscParser.ChangeRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(LscParser.FilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LscParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#blockElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockElement(LscParser.BlockElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#blockType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockType(LscParser.BlockTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#changeRuleModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeRuleModifier(LscParser.ChangeRuleModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#matchMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchMode(LscParser.MatchModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(LscParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#ruleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleName(LscParser.RuleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LscParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom(LscParser.FromContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#to}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTo(LscParser.ToContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#ruleElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleElement(LscParser.RuleElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#unconditionalRuleElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnconditionalRuleElement(LscParser.UnconditionalRuleElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#bounded}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBounded(LscParser.BoundedContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(LscParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(LscParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(LscParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#freeElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFreeElement(LscParser.FreeElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#compoundEnvironment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundEnvironment(LscParser.CompoundEnvironmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(LscParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#exclusion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusion(LscParser.ExclusionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#environmentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironmentList(LscParser.EnvironmentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#environment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironment(LscParser.EnvironmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#environmentBefore}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironmentBefore(LscParser.EnvironmentBeforeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#environmentAfter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironmentAfter(LscParser.EnvironmentAfterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#interfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfix(LscParser.InterfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#interfixType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfixType(LscParser.InterfixTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#interfixElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfixElement(LscParser.InterfixElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#negated}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegated(LscParser.NegatedContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix(LscParser.PostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#capture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCapture(LscParser.CaptureContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#repeater}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeater(LscParser.RepeaterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple(LscParser.SimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#anySyllable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnySyllable(LscParser.AnySyllableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#classRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassRef(LscParser.ClassRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#captureRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaptureRef(LscParser.CaptureRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#fancyMatrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFancyMatrix(LscParser.FancyMatrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#fancyValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFancyValue(LscParser.FancyValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#negatedValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegatedValue(LscParser.NegatedValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#absentFeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsentFeature(LscParser.AbsentFeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#featureVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureVariable(LscParser.FeatureVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(LscParser.EmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#sylBoundary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSylBoundary(LscParser.SylBoundaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#boundary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundary(LscParser.BoundaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#betweenWords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenWords(LscParser.BetweenWordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#repeaterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeaterType(LscParser.RepeaterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#repeatRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatRange(LscParser.RepeatRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#lowerBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowerBound(LscParser.LowerBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#upperBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpperBound(LscParser.UpperBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#matrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrix(LscParser.MatrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#matrixValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixValue(LscParser.MatrixValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#plusFeatureValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusFeatureValue(LscParser.PlusFeatureValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#featureValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureValue(LscParser.FeatureValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(LscParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(LscParser.TextContext ctx);
}