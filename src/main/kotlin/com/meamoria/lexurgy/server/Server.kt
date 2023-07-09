package com.meamoria.lexurgy.server

import com.meamoria.lexurgy.sc.soundChangerFromLscFile
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.nio.file.Path


@Serializable
data class ServerRequest(
    val words: List<String>,
    val startAt: String? = null,
    val stopBefore: String? = null,
    val traceWords: List<String> = emptyList(),
    val romanize: Boolean = true
)

@Serializable
sealed class ServerResponse {
    @Serializable
    @SerialName("changed")
    data class Changed(
        val words: List<String>, val intermediates: Map<String, List<String>>, val traceLines: List<String>
    ) : ServerResponse()

    @Serializable
    @SerialName("error")
    data class Error(
        val message: String, val stackTrace: List<String>
    ) : ServerResponse()


}

data class StringCollector(val strings: MutableList<String> = mutableListOf()) : (String) -> Unit {
    override fun invoke(string: String) {
        strings.add(string)
    }
}

fun runServer(changes: Path) {
    val changer = soundChangerFromLscFile(changes)

    while (true) {
        try {
            val line = readlnOrNull() ?: break
            val request = Json.decodeFromString<ServerRequest>(line)
            val collector = StringCollector()
            val intermediates = changer.changeWithIntermediates(
                request.words,
                request.startAt,
                request.stopBefore,
                request.traceWords,
                request.romanize,
                collector
            )
            val words = intermediates[null]!!

            val trueIntermediates: Map<String, List<String>> =
                intermediates.filterKeys { it != null }.mapKeys { it.key!! }
            println(
                Json.encodeToString(
                    ServerResponse.serializer(),
                    ServerResponse.Changed(words, trueIntermediates, collector.strings)
                )
            )
        } catch (e: Exception) {
            val message = e.message.toString()
            val stackTrace = e.stackTrace.map { it.toString() }
            println(Json.encodeToString(ServerResponse.serializer(), ServerResponse.Error(message, stackTrace)))
        }
    }
}