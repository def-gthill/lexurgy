package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.Word

/**
 * An emitter whose result depends on a connected ``Matcher``.
 */
interface ConditionalEmitter : Emitter {
    fun result(
        matcher: SimpleMatcher,
        original: Phrase
    ): UnboundResult = result(matcher, original.first())

    fun result(
        matcher: SimpleMatcher,
        original: Word
    ): UnboundResult

    override fun isConditional(): Boolean = true

    override fun isIndependent(): Boolean = false
}