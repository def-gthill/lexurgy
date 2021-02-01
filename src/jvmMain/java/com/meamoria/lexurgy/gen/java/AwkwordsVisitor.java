// Generated from Awkwords.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.gen.java;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AwkwordsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AwkwordsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#awkfile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAwkfile(AwkwordsParser.AwkfileContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#numwords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumwords(AwkwordsParser.NumwordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#subpattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpattern(AwkwordsParser.SubpatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(AwkwordsParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#alternative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternative(AwkwordsParser.AlternativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#weightedchoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightedchoice(AwkwordsParser.WeightedchoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#altchoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltchoice(AwkwordsParser.AltchoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#filtered}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFiltered(AwkwordsParser.FilteredContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#filterstring}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterstring(AwkwordsParser.FilterstringContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#optional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptional(AwkwordsParser.OptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(AwkwordsParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(AwkwordsParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#escape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscape(AwkwordsParser.EscapeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#subref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubref(AwkwordsParser.SubrefContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#anychar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnychar(AwkwordsParser.AnycharContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(AwkwordsParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link AwkwordsParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(AwkwordsParser.NumberContext ctx);
}