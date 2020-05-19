package com.meamoria.lexurgy

import com.github.ajalt.clikt.output.TermUi.echo
import java.io.File
import java.nio.file.Path

fun console(message: String) = echo(message)

fun debug(message: String) {
    echo(message)
    DebugLogger.debugFilePath.toFile().appendText(message + System.lineSeparator())
}

object DebugLogger {
    lateinit var debugFilePath: Path

    val debugFilePathIsInitialized
        get() = this::debugFilePath.isInitialized
}

/**
 * Puts the number in front of the word, with the word correctly marked for singular/plural.
 * For example:
 *
 * - ``enpl(1, "cat")`` yields ``"1 cat"``.
 * - ``enpl(3, "cat")`` yields ``"3 cats"``.
 * - ``enpl(3, "box")`` yields ``"3 boxs"``; use the ``plural`` argument to specify the plural manually.
 * - ``enpl(3, "box", "boxes")`` correctly yields ``"3 boxes"``.
 */
fun enpl(number: Int, word: String, plural: String? = null): String {
    val form = if (number == 1) word else plural ?: word + "s"
    return "$number $form"
}