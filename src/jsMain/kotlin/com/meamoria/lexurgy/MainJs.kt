package com.meamoria.lexurgy

import com.meamoria.lexurgy.sc.SoundChanger
import com.meamoria.lexurgy.sc.makeStageComparisons
import kotlinx.browser.document
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.events.Event

fun main() {
    try {
        if (document.title.isEmpty()) return
    } catch (e: Throwable) {
        return
    }

    val inputField = document.getElementById("input") as HTMLTextAreaElement
    val changeField = document.getElementById("changes") as HTMLTextAreaElement
    val outputField = document.getElementById("output") as HTMLTextAreaElement
    val historyField = document.getElementById("history") as? HTMLTextAreaElement
    val errorField = document.getElementById("error") as? HTMLTextAreaElement

    val startAtCheckbox = document.getElementById("start_at_enabled") as? HTMLInputElement
    val startAtField = document.getElementById("start_at") as? HTMLInputElement

    val stopBeforeCheckbox = document.getElementById("stop_before_enabled") as? HTMLInputElement
    val stopBeforeField = document.getElementById("stop_before") as? HTMLInputElement

    val traceWordCheckbox = document.getElementById("trace_word_enabled") as? HTMLInputElement
    val traceWordField = document.getElementById("trace_word") as? HTMLInputElement
    val traceOutputField = document.getElementById("trace_output") as? HTMLTextAreaElement

    fun output(element: HTMLTextAreaElement, text: String) {
        element.value = text
        element.dispatchEvent(Event("input"))
    }

    val button = document.getElementById("apply") as HTMLButtonElement
    button.addEventListener("click", {
        val debugBuffer = StringBuilder()

        try {
            val inputWords = inputField.value.lines()
            val changes = changeField.value
            val startAtRule = startAtField?.value.takeIf { startAtCheckbox?.checked == true }
            val stopBeforeRule = stopBeforeField?.value.takeIf { stopBeforeCheckbox?.checked == true }
            val soundChanger = SoundChanger.fromLsc(changes)
            val stages =
                soundChanger.changeWithIntermediates(
                    inputWords,
                    startAt = startAtRule,
                    stopBefore = stopBeforeRule,
                    debugWords = listOfNotNull(traceWordField?.value.takeIf { traceWordCheckbox?.checked == true }),
                    debug = { debugBuffer.append(it + "\n") }
                )
            val outputWords = stages.getValue(null)
            val intermediates = unpackIntermediates(inputWords, stages)
            if (historyField == null) {
                output(
                    outputField,
                    intermediates.zip(outputWords) {
                            intermediate, outputWord -> intermediate + outputWord
                    }.joinToString("\n")
                )
            } else {
                output(historyField, intermediates.joinToString("\n"))
                output(outputField, outputWords.joinToString("\n"))
            }
            traceOutputField?.value = debugBuffer.toString()
        } catch (e: Exception) {
            output(errorField ?: outputField, e.message.toString())
        }
    })
}

private fun unpackIntermediates(inputWords: List<String>, stages: Map<String?, List<String>>): List<String> =
    makeStageComparisons(
        listOf(inputWords) + stages.filterKeys { it != null }.values + listOf(inputWords.map { "" })
    )
