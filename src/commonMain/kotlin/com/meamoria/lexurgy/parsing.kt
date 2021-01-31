package com.meamoria.lexurgy

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.ParseTreeVisitor

abstract class Interpreter<T, Parser>(val visitor: ParseTreeVisitor<T>) {
    protected fun parseAndWalk(text: String, parser: (Parser) -> ParseTree): T {
        val inputStream = CharStreams.fromString(text)
        val lexer = lexerFor(inputStream)
        val tokenStream = CommonTokenStream(lexer)
        val tree = parser(parserFor(tokenStream))
        return visitor.visit(tree)!!
    }

    abstract fun lexerFor(inputStream: CharStream): Lexer

    abstract fun parserFor(tokenStream: TokenStream): Parser
}

interface Walker<T> : ParseTreeVisitor<T> {
    fun listVisit(node: List<ParseTree>): List<T> = node.map { visit(it) }

    fun optionalVisit(node: ParseTree?): T? = node?.let { visit(it) }
}
