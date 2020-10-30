package com.meamoria.lexurgy

import com.meamoria.lexurgy.sc.SoundChanger
import com.meamoria.lexurgy.sc.makeStageComparisons
import kotlinx.browser.document
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLTextAreaElement

fun main() {
    if (document.title.isEmpty()) return

    val inputField = document.getElementById("input") as HTMLTextAreaElement
    val changeField = document.getElementById("changes") as HTMLTextAreaElement
    val outputField = document.getElementById("output") as HTMLTextAreaElement

    fun output(text: String) { outputField.value = text }

    val button = document.getElementById("apply") as HTMLButtonElement
    button.addEventListener("click", {
        try {
            val inputWords = inputField.value.lines()
            val changes = changeField.value
            val soundChanger = SoundChanger.fromLsc(changes)
            val outputWords = unpackIntermediates(inputWords, soundChanger.changeWithIntermediates(inputWords))
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
