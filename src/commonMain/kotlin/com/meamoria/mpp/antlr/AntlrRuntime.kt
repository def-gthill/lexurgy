package com.meamoria.mpp.antlr

expect abstract class Lexer : TokenSource

expect interface TokenSource

expect abstract class Parser {
    fun removeErrorListeners()
}

expect fun Parser.addCommonAntlrErrorListener(listener: CommonAntlrErrorListener)

expect open class ParserRuleContext : RuleContext

expect open class RuleContext : RuleNode

expect interface RuleNode : ParseTree

expect interface TerminalNode : ParseTree

expect interface ParseTree {
    fun getText(): String

    fun getChild(i: Int): ParseTree

    fun getChildCount(): Int
}

val ParseTree.children
    get() = (0 until getChildCount()).map { getChild(it) }

expect interface CharStream

expect object CharStreams {
    fun fromString(s: String): CharStream
}

expect interface TokenStream

expect class CommonTokenStream(tokenSource: TokenSource) : BufferedTokenStream

expect open class BufferedTokenStream : TokenStream

expect abstract class CommonAntlrErrorListener() {
    abstract fun handleSyntaxError(
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
    )
}

