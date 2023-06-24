package com.meamoria.lexurgy.server

import com.meamoria.lexurgy.sc.soundChangerFromLscFile
import java.nio.file.Path
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class ServerRequest(
    val words: List<String>,
    val startAt: String? = null,
    val stopBefore: String? = null,
    val traceWords: List<String> = emptyList(),
    val romanize: Boolean = true
)

@Serializable
data class ServerResponse(
    val words: List<String>,
    val intermediates: Map<String, List<String>>,
    val traceLines: List<String>
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
            val intermediates = changer.changeWithIntermediates(
                query.words, query.startAt, query.stopBefore, query.traceWords, query.romanize, collector
            )
            val words = intermediates[null]!!

            val trueIntermediates: Map<String, List<String>> = intermediates.filterKeys { it != null }.mapKeys { it.key!! }
            println(Json.encodeToString(ServerResponse(words, trueIntermediates, collector.strings)))
        } catch (e: Exception) {
            val message = e.message.toString()
            val stackTrace = e.stackTrace.map { it.toString() }
            println(Json.encodeToString(ServerErrorResponse(message, stackTrace)))
        }
    }
}