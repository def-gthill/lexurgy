@file:Suppress("unused")

package com.meamoria.lexurgy

import com.meamoria.lexurgy.sc.SoundChanger
import com.meamoria.lexurgy.sc.makeStageComparisons

@JsName("SoundChanger")
class JsSoundChanger(val sc: SoundChanger) {
    @JsName("change")
    fun change(
        words: Array<String>,
        startAt: String? = null,
        stopBefore: String? = null,
        debugWords: Array<String> = emptyArray(),
        romanize: Boolean = true,
        debugCallback: (String) -> Unit = {},
    ): Array<SoundChangerResult> =
        sc.changeWithIntermediates(
            words.asList(),
            startAt,
            stopBefore,
            debugWords.asList(),
            romanize,
            debugCallback,
        ).map { (name, words) ->
            SoundChangerResult(name, words.toTypedArray())
        }.toTypedArray()

    val ruleNames: Array<String>
        get() = sc.rules.map { it.name }.toTypedArray()

    companion object {
        @JsName("fromLsc")
        fun fromLsc(code: String): JsSoundChanger =
            JsSoundChanger(SoundChanger.fromLsc(code))
    }
}

class SoundChangerResult(val name: String?, val words: Array<String>)

@JsName("scMakeStageComparisons")
fun scMakeStageComparisons(wordListSequence: Array<Array<String>>): Array<String> =
    makeStageComparisons(wordListSequence.map { it.asList() }).toTypedArray()
