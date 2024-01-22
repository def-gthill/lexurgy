package com.meamoria.lexurgy.cli.server

import com.meamoria.lexurgy.LscUserError
import com.meamoria.lexurgy.cli.soundChangerFromLscFile
import com.meamoria.lexurgy.cli.soundChangerFromString
import com.meamoria.lexurgy.sc.SoundChanger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import java.nio.file.Path
import java.nio.file.Paths

class LscNoSoundChangesLoaded : LscUserError("No sound changer loaded.")

@Serializable
sealed class ServerRequest {
    fun encode() = Json.encodeToString(this)
}

@Serializable
@SerialName("apply")
data class ApplyChangesRequest(
    val words: List<String>,
    val startAt: String? = null,
    val stopBefore: String? = null,
    val traceWords: List<String> = emptyList(),
    val romanize: Boolean = true
) : ServerRequest()

@Serializable
@SerialName("load_file")
data class LoadChangesFromFileRequest(
    val path: String
) : ServerRequest()

@Serializable
@SerialName("load_string")
data class LoadChangesFromStringRequest(
    val changes: String
) : ServerRequest()

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

    @Serializable
    @SerialName("ok")
    object Ok : ServerResponse()
}

data class StringCollector(val strings: MutableList<String> = mutableListOf()) : (String) -> Unit {
    override fun invoke(string: String) {
        strings.add(string)
    }
}

fun applyChanges(changer: SoundChanger?, request: ApplyChangesRequest) {
    if (changer == null) throw LscNoSoundChangesLoaded()
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

    printResponse(ServerResponse.Changed(words, trueIntermediates, collector.strings))
}

fun printResponse(response: ServerResponse) {
    println(Json.encodeToString(ServerResponse.serializer(), response))
}

fun runServer(changes: Path?) {
    var changer = changes?.let { soundChangerFromLscFile(it) }
    while (true) {
        try {
            val line = readlnOrNull() ?: break
            val request = Json.parseToJsonElement(line)

            // For backwards-compatibility, allow the request type to be omitted. We
            // default to a request type of APPLY_CHANGES in that case.
            if (request.jsonObject["type"] == null) {
                applyChanges(
                    changer,
                    Json.decodeFromJsonElement(ApplyChangesRequest.serializer(), request)
                )
                continue
            }

            when (val req = Json.decodeFromJsonElement(ServerRequest.serializer(), request)) {
                is ApplyChangesRequest -> applyChanges(changer, req)

                is LoadChangesFromFileRequest -> {
                    changer = soundChangerFromLscFile(Paths.get(req.path))
                    printResponse(ServerResponse.Ok)
                }

                is LoadChangesFromStringRequest -> {
                    changer = soundChangerFromString(req.changes)
                    printResponse(ServerResponse.Ok)
                }
            }
        } catch (e: Exception) {
            val message = e.message.toString()
            val stackTrace = e.stackTrace.map { it.toString() }
            printResponse(ServerResponse.Error(message, stackTrace))
        }
    }
}