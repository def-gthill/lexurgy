package com.meamoria.mpp.antlr

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.BufferedTokenStream
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
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

actual typealias RuleContext = RuleContext

actual typealias RuleNode = RuleNode

actual typealias TerminalNode = TerminalNode

actual typealias ParseTree = ParseTree

actual typealias CharStream = CharStream

actual object CharStreams {
    actual fun fromString(s: String): CharStream = CharStreams.fromString(s)
}

actual typealias TokenStream = TokenStream

actual typealias CommonTokenStream = CommonTokenStream

actual typealias BufferedTokenStream = BufferedTokenStream

actual typealias Token = Token

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

    private fun foo(e: RecognitionException) {
        e.expectedTokens
        com.meamoria.lexurgy.sc.java.LscParser.FEATURE
    }
}

actual typealias RecognitionException = RecognitionException

actual typealias InputMismatchException = InputMismatchException

actual val EOF: Int = Recognizer.EOF
