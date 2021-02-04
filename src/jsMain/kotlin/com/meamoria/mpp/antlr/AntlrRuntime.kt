@file:JsModule("antlr4")
@file:JsNonModule

package com.meamoria.mpp.antlr

actual abstract external class Lexer : TokenSource

actual external interface TokenSource

actual abstract external class Parser {
    fun addErrorListener(listener: CommonAntlrErrorListener)

    actual fun removeErrorListeners()
}

actual open external class ParserRuleContext : RuleContext {
    val start: Token
}

actual open external class RuleContext : RuleNode {
    val parentCtx: RuleContext?

    override fun getText(): String

    override fun getChild(i: Int): ParseTree

    override fun getChildCount(): Int
}

actual external interface RuleNode : ParseTree

actual external interface TerminalNode : ParseTree {
    val symbol: Token
}

actual external interface ParseTree {
    actual fun getText(): String

    actual fun getChild(i: Int): ParseTree

    actual fun getChildCount(): Int
}

actual external interface CharStream

external class InputStream(input: String): CharStream

actual external interface TokenStream

actual external class CommonTokenStream actual constructor(tokenSource: TokenSource) : BufferedTokenStream

actual open external class BufferedTokenStream : TokenStream

actual external interface Token {
    val text: String
    val type: Int
    val line: Int
    val column: Int
}

@JsName("Token")
external class TokenClass {
    companion object {
        val EOF: Int
    }
}

actual external interface WritableToken : Token

actual external class CommonToken : WritableToken {
    override val text: String
    override val type: Int
    override val line: Int
    override val column: Int
}

actual external class IntervalSet {
    actual fun contains(el: Int): Boolean
}

actual open external class RecognitionException {
    val ctx: RuleContext?
    val offendingToken: Token
    actual fun getExpectedTokens(): IntervalSet
}

actual external class InputMismatchException : RecognitionException
