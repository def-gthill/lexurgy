// Generated from Lsc.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.sc;
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
	 * Visit a parse tree produced by {@link LscParser#lscfile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLscfile(LscParser.LscfileContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#classdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdecl(LscParser.ClassdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#classelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClasselement(LscParser.ClasselementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#featuredecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeaturedecl(LscParser.FeaturedeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#nullalias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullalias(LscParser.NullaliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#diacritic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiacritic(LscParser.DiacriticContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(LscParser.SymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#symbolname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolname(LscParser.SymbolnameContext ctx);
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
	 * Visit a parse tree produced by {@link LscParser#interromanizer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterromanizer(LscParser.InterromanizerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#changerule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangerule(LscParser.ChangeruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(LscParser.FilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#subrules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubrules(LscParser.SubrulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#subrule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubrule(LscParser.SubruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#rulename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulename(LscParser.RulenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#ruleexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleexpression(LscParser.RuleexpressionContext ctx);
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
	 * Visit a parse tree produced by {@link LscParser#rulefrom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulefrom(LscParser.RulefromContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#ruleto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleto(LscParser.RuletoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#environlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironlist(LscParser.EnvironlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#ruleenviron}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleenviron(LscParser.RuleenvironContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#boundarybefore}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundarybefore(LscParser.BoundarybeforeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#boundaryafter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundaryafter(LscParser.BoundaryafterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#rulebefore}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulebefore(LscParser.RulebeforeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#ruleafter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleafter(LscParser.RuleafterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#ruleelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleelement(LscParser.RuleelementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#rulesequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulesequence(LscParser.RulesequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#sequenceelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceelement(LscParser.SequenceelementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#rulecapture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulecapture(LscParser.RulecaptureContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#rulerepeater}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulerepeater(LscParser.RulerepeaterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#rulegroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulegroup(LscParser.RulegroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#rulelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulelist(LscParser.RulelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#simpleelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleelement(LscParser.SimpleelementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#negelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegelement(LscParser.NegelementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#classref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassref(LscParser.ClassrefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#captureref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaptureref(LscParser.CapturerefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#fancymatrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFancymatrix(LscParser.FancymatrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#fancyvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFancyvalue(LscParser.FancyvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#negvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegvalue(LscParser.NegvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#absentfeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsentfeature(LscParser.AbsentfeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#featurevariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeaturevariable(LscParser.FeaturevariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(LscParser.EmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#repeatertype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatertype(LscParser.RepeatertypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#matrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrix(LscParser.MatrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(LscParser.FeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(LscParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LscParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(LscParser.TextContext ctx);
}