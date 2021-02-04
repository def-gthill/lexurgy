package com.meamoria.mpp.antlr

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.BufferedTokenStream
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.InputMismatchException
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.RuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.TokenSource
import org.antlr.v4.runtime.TokenStream
import org.antlr.v4.runtime.WritableToken
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime.misc.IntervalSet
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.TerminalNode
import java.util.*

actual typealias Lexer = Lexer

actual typealias TokenSource = TokenSource

actual typealias Parser = Parser

actual fun Parser.addCommonAntlrErrorListener(listener: CommonAntlrErrorListener) =
    addErrorListener(listener)

actual typealias ParserRuleContext = ParserRuleContext

actual fun ParserRuleContext.getStartLine(): Int = start.line

actual fun ParserRuleContext.getStartColumn(): Int = start.charPositionInLine

actual typealias RuleContext = RuleContext

actual fun RuleContext.getParentContext(): RuleContext? = getParent()

actual typealias RuleNode = RuleNode

actual typealias TerminalNode = TerminalNode

actual fun TerminalNode.getLine(): Int = symbol.line

actual fun TerminalNode.getStartColumn(): Int = symbol.charPositionInLine

actual typealias ParseTree = ParseTree

actual typealias CharStream = CharStream

actual object CharStreams {
    actual fun fromString(s: String): CharStream = CharStreams.fromString(s)
}

actual typealias TokenStream = TokenStream

actual typealias CommonTokenStream = CommonTokenStream

actual typealias BufferedTokenStream = BufferedTokenStream

actual typealias Token = Token

actual fun Token.getTokenText(): String = text

actual fun Token.getTokenType(): Int = type

actual typealias WritableToken = WritableToken

actual typealias CommonToken = CommonToken

actual typealias IntervalSet = IntervalSet

actual abstract class CommonAntlrErrorListener : ANTLRErrorListener {
    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        e: RecognitionException?
    ) = handleSyntaxError(offendingSymbol, line, charPositionInLine, msg, e)

    override fun reportAttemptingFullContext(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        conflictingAlts: BitSet?,
        configs: ATNConfigSet?
    ) {
    }

    override fun reportAmbiguity(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        exact: Boolean,
        ambigAlts: BitSet?,
        configs: ATNConfigSet?
    ) {
    }

    override fun reportContextSensitivity(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        prediction: Int,
        configs: ATNConfigSet?
    ) {
    }

    actual abstract fun handleSyntaxError(
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        exception: RecognitionException?,
    )

    private fun foo(ctx: ParserRuleContext) {
        ctx.stop
    }
}

actual typealias RecognitionException = RecognitionException

actual fun RecognitionException.getContext(): RuleContext? = ctx

actual fun RecognitionException.getMismatchedToken(): Token = offendingToken

actual typealias InputMismatchException = InputMismatchException

actual val EOF: Int = Recognizer.EOF
