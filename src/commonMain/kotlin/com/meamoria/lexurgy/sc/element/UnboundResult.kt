package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
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