package com.meamoria.lexurgy

import com.meamoria.lexurgy.sc.SoundChanger
import com.meamoria.lexurgy.sc.makeStageComparisons
import kotlinx.browser.document
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement

fun main() {
    if (document.title.isEmpty()) return

    val inputField = document.getElementById("input") as HTMLTextAreaElement
    val changeField = document.getElementById("changes") as HTMLTextAreaElement
    val outputField = document.getElementById("output") as HTMLTextAreaElement

    val startAtCheckbox = document.getElementById("start_at_enabled") as? HTMLInputElement
    val startAtField = document.getElementById("start_at") as? HTMLInputElement

    val stopBeforeCheckbox = document.getElementById("stop_before_enabled") as? HTMLInputElement
    val stopBeforeField = document.getElementById("stop_before") as? HTMLInputElement

    fun output(text: String) { outputField.value = text }

    val button = document.getElementById("apply") as HTMLButtonElement
    button.addEventListener("click", {
        try {
            val inputWords = inputField.value.lines()
            val changes = changeField.value
            val startAtRule = startAtField?.value.takeIf { startAtCheckbox?.checked == true }
            val stopBeforeRule = stopBeforeField?.value.takeIf { stopBeforeCheckbox?.checked == true }
            val soundChanger = SoundChanger.fromLsc(changes)
            val outputWords = unpackIntermediates(
                inputWords,
                soundChanger.changeWithIntermediates(
                    inputWords,
                    startAt = startAtRule,
                    stopBefore = stopBeforeRule,
                )
            )
            output(outputWords.joinToString("\n"))
        } catch (e: Exception) {
            output(e.message.toString())
        }
    })
}

private fun unpackIntermediates(inputWords: List<String>, stages: Map<String?, List<String>>): List<String> =
    makeStageComparisons(
        listOf(inputWords) + stages.filterKeys { it != null }.values + listOf(stages.getValue(null))
    )
