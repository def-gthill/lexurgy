package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

/**
 * A matcher that may change its behaviour if given a specific
 * number of segments to try to match.
 */
interface LengthHintedMatcher {
    fun claim(
        phrase: Phrase,
        start: PhraseIndex,
        expectedEnd: PhraseIndex,
        bindings: Bindings
    ): Bindings?
}