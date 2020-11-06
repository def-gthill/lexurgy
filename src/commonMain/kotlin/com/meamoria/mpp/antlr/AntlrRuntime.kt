package com.meamoria.mpp.antlr

expect abstract class Lexer : TokenSource

expect interface TokenSource

expect abstract class Parser {
    fun removeErrorListeners()
}

expect fun Parser.addCommonAntlrErrorListener(listener: CommonAntlrErrorListener)

expect open class ParserRuleContext : RuleContext

expect open class RuleContext : RuleNode

expect fun RuleContext.getParentContext(): RuleContext?

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

expect interface Token

expect fun Token.getTokenText(): String

expect fun Token.getTokenType(): Int

expect class IntervalSet {
    fun contains(el: Int): Boolean
}

expect abstract class CommonAntlrErrorListener() {
    abstract fun handleSyntaxError(
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        exception: RecognitionException?,
    )
}

expect open class RecognitionException {
    fun getExpectedTokens(): IntervalSet
}

expect fun RecognitionException.getContext(): RuleContext?

expect fun RecognitionException.getMismatchedToken(): Token

expect class InputMismatchException : RecognitionException

expect val EOF: Int
