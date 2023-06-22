package com.meamoria.lexurgy.server

import com.meamoria.lexurgy.ConsoleWriter
import com.meamoria.lexurgy.console
import com.meamoria.lexurgy.sc.LscRuleCrashed
import com.meamoria.lexurgy.sc.soundChangerFromLscFile
import kotlinx.serialization.Contextual
import java.nio.file.Path
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.PrintWriter
import java.io.StringWriter

@Serializable
data class ServerRequest(
    val words: List<String>,
    val startAt: String? = null,
    val stopBefore: String? = null,
    val debugWords: List<String> = emptyList(),
    val romanize: Boolean = true
)

@Serializable
data class ServerResponse(
    val words: List<String>, val traceLines: List<String>
)

@Serializable
data class ServerErrorResponse(
    val message: String, val stackTrace: List<String>
)

data class StringCollector(val strings: MutableList<String> = mutableListOf()) : (String) -> Unit {
    override fun invoke(string: String) {
        strings.add(string)
    }
}

fun runServer(changes: Path) {
    val changer = soundChangerFromLscFile(changes)

    while (true) {
        val line = readlnOrNull() ?: break
        val query = Json.decodeFromString<ServerRequest>(line)
        val collector = StringCollector()
        try {
            val words = changer.change(
                query.words, query.startAt, query.stopBefore, query.debugWords, query.romanize, collector
            )
            println(Json.encodeToString(ServerResponse(words, collector.strings)))
        } catch (e: Exception) {
            val message = e.message.toString()
            val stackTrace = e.stackTrace.map { it.toString() }
            println(Json.encodeToString(ServerErrorResponse(message, stackTrace)))
        }
    }
}