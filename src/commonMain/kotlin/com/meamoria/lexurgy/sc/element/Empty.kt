package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
import com.meamoria.lexurgy.StandardWord
import com.meamoria.lexurgy.sc.Bindings
import com.meamoria.lexurgy.sc.LscIllegalStructureInFilteredRuleInput

object EmptyMatcher : SimpleMatcher() {
    override fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
        partial: Boolean,
    ): List<PhraseMatchEnd> =
        listOf(PhraseMatchEnd(start, bindings))

    override fun reversed(): Matcher = this

    override fun checkValidInFilterIfEmitterIs(result: Emitter) =
        throw LscIllegalStructureInFilteredRuleInput(
            "an empty element",
            "*"
        )

    override fun toString(): String = "*"
}

object EmptyEmitter : IndependentEmitter {
    override fun result(): UnboundResult =
        UnboundResult.fromPhrase(Phrase(StandardWord.EMPTY))

    override fun toString(): String = "*"
}