package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

interface Transformer {
    fun transform(
        order: Int,
        phrase: Phrase,
        start: PhraseIndex,
        bindings: Bindings,
    ): List<UnboundTransformation>

    fun <T> List<T>.checkTooManyOptions(): List<T> =
        checkTooManyOptions(this@Transformer, this)
}