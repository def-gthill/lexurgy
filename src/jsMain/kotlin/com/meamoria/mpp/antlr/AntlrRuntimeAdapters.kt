@file:Suppress("unused", "UNUSED_PARAMETER")

package com.meamoria.mpp.antlr

actual fun ParserRuleContext.getStartLine(): Int = start.line

actual fun ParserRuleContext.getStartColumn(): Int = start.column

actual fun RuleContext.getParentContext(): RuleContext? = parentCtx

actual object CharStreams {
    actual fun fromString(s: String): CharStream = InputStream(s)
}

actual fun Token.getTokenText(): String = text

actual fun Token.getTokenType(): Int = type

actual fun Parser.addCommonAntlrErrorListener(listener: CommonAntlrErrorListener)=
    addErrorListener(listener)

actual abstract class CommonAntlrErrorListener {
    @JsName("syntaxError")
    fun syntaxError(
        recognizer: Any?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        e: RecognitionException?
    )= handleSyntaxError(offendingSymbol, line, charPositionInLine, msg, e)

    @JsName("reportAttemptingFullContext")
    fun reportAttemptingFullContext(
        recognizer: Parser?,
        dfa: Any?,
        startIndex: Int,
        stopIndex: Int,
        conflictingAlts: Any?,
        configs: Any?
    ) {
    }

    @JsName("reportAmbiguity")
    fun reportAmbiguity(
        recognizer: Parser?,
        dfa: Any?,
        startIndex: Int,
        stopIndex: Int,
        exact: Boolean,
        ambigAlts: Any?,
        configs: Any?
    ) {
    }

    @JsName("reportContextSensitivity")
    fun reportContextSensitivity(
        recognizer: Parser?,
        dfa: Any?,
        startIndex: Int,
        stopIndex: Int,
        prediction: Int,
        configs: Any?
    ) {
    }

    actual abstract fun handleSyntaxError(
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        exception: RecognitionException?,
    )
}

actual fun RecognitionException.getContext(): RuleContext? = ctx

actual fun RecognitionException.getMismatchedToken(): Token = offendingToken

actual val EOF: Int = TokenClass.EOF
