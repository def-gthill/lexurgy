// Generated from Meta.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.meta.java;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MetaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MetaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MetaParser#g4File}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG4File(MetaParser.G4FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#antlrRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAntlrRule(MetaParser.AntlrRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MetaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(MetaParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#sequenceElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceElement(MetaParser.SequenceElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#alts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlts(MetaParser.AltsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#altElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltElement(MetaParser.AltElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(MetaParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#repeater}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeater(MetaParser.RepeaterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#repeaterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeaterType(MetaParser.RepeaterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple(MetaParser.SimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#ruleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleName(MetaParser.RuleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaParser#tokenName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenName(MetaParser.TokenNameContext ctx);
}