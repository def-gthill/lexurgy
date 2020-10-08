// Generated from Lgn.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LgnParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LgnVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LgnParser#classdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdecl(LgnParser.ClassdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LgnParser#classelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClasselement(LgnParser.ClasselementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LgnParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(LgnParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LgnParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(LgnParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LgnParser#sequenceelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceelement(LgnParser.SequenceelementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LgnParser#optional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptional(LgnParser.OptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LgnParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(LgnParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LgnParser#simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple(LgnParser.SimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LgnParser#classref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassref(LgnParser.ClassrefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LgnParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(LgnParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LgnParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(LgnParser.TextContext ctx);
}