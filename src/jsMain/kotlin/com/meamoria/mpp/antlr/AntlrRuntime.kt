@file:JsModule("antlr4")
@file:JsNonModule

package com.meamoria.mpp.antlr

actual abstract external class Lexer : TokenSource

actual external interface TokenSource

actual abstract external class Parser {
    fun addErrorListener(listener: CommonAntlrErrorListener)

    actual fun removeErrorListeners()
}

actual open external class ParserRuleContext : RuleContext

actual open external class RuleContext : RuleNode {
    override fun getText(): String

    override fun getChild(i: Int): ParseTree

    override fun getChildCount(): Int
}

actual external interface RuleNode : ParseTree

actual external interface TerminalNode : ParseTree

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
