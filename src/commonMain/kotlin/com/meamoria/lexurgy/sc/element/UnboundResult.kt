package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.sc.Bindings

data class UnboundResult(val bind: (Bindings) -> ChangeResult) {
    companion object {
        fun fromPhrase(phrase: Phrase) = UnboundResult {
            ChangeResult(phrase, emptyList(), emptyMap())
        }

        fun fromPhraseBinder(bind: (Bindings) -> Phrase) = UnboundResult { bindings ->
            ChangeResult(bind(bindings), emptyList(), emptyMap())
        }
    }
}