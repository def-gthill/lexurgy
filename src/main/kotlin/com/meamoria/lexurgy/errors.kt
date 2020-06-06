package com.meamoria.lexurgy

import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import java.util.*


/**
 * Base for Lexurgy errors caused by user mistakes.
 */
abstract class UserError(msg: String, cause: Throwable? = null) : Exception(msg, cause)

/**
 * Base for Lexurgy SC errors caused by user mistakes.
 */
abstract class LscUserError(msg: String, cause: Throwable? = null) : UserError(msg, cause)

internal abstract class BoringErrorListener : ANTLRErrorListener {
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
}
