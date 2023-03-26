package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.Phrase
import com.meamoria.lexurgy.PhraseIndex
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