package com.meamoria.lexurgy.cli

import com.meamoria.lexurgy.cli.server.*
import com.sun.jna.Platform
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.serialization.json.Json
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.file.FileSystems
import java.nio.file.Path
import kotlin.io.path.readText
import kotlin.time.ExperimentalTime

@Suppress("unused")
@ExperimentalTime
class TestServerModeCLI : StringSpec({
    fun pathOf(vararg pathComponents: String): Path = FileSystems.getDefault().getPath("test", *pathComponents)

    fun listFrom(vararg pathComponents: String): List<String> = loadList(pathOf(*pathComponents))

    fun withStd(input: String, block: () -> Unit): String {
        val oldOut = System.out
        val oldIn = System.`in`
        val outStream = ByteArrayOutputStream()
        val inStream = ByteArrayInputStream(input.toByteArray())
        outStream.use { openedOut ->
            PrintStream(openedOut).use { printOut ->
                System.setOut(printOut)
                inStream.use {
                    System.setIn(it)
                    block()
                    System.setIn(oldIn)
                }
                System.setOut(oldOut)
            }
        }
        return outStream.toString()
    }

    fun runServer(changes: String, request: String): ServerResponse {
        val response = withStd(request) { lexurgyCommand.parse(arrayOf("server", changes)) }
        return Json.decodeFromString<ServerResponse>(response)
    }

    fun runRequests(vararg requests: ServerRequest): List<ServerResponse> {
        val responses = withStd(requests.joinToString("\n") { it.encode() }) { lexurgyCommand.parse(arrayOf("server")) }
        return responses.split("\n").filter { it.isNotEmpty() }.map { Json.decodeFromString<ServerResponse>(it) }
    }

    fun checkWords(response: ServerResponse, file: String) {
        response.shouldBeInstanceOf<ServerResponse.Changed>()
        response.words shouldBe listFrom(file)
    }


    "Server mode can do sound changes from a request".config(enabled = !Platform.isWindows()) {
        val response = runServer(
            "test/muipidan.lsc",
            ApplyChangesRequest(listFrom("ptr_test_1.wli")).encode()
        )

        checkWords(response, "ptr_test_1_ev_expected.wli")
    }

    "Server mode supports legacy request format".config(enabled = !Platform.isWindows()) {
        val response = runServer(
            "test/muipidan.lsc",
            Json.encodeToString(
                // Use this here so the `type` field is omitted.
                ApplyChangesRequest.serializer(),
                ApplyChangesRequest(listFrom("ptr_test_1.wli"))
            )
        )
        checkWords(response, "ptr_test_1_ev_expected.wli")
    }

    "Server mode returns an error if rule application failed".config(enabled = !Platform.isWindows()) {
        val response = runServer(
            "test/test_all_errors.lsc",
            ApplyChangesRequest(listFrom("test_all_errors.wli")).encode()
        )
        response.shouldBeInstanceOf<ServerResponse.Error>()
    }

    "Server mode supports loading changes from file".config(enabled = !Platform.isWindows()) {
        val responses = runRequests(
            LoadChangesFromFileRequest("test/empty.lsc"),
            ApplyChangesRequest(listFrom("ptr_test_1.wli")),
            LoadChangesFromFileRequest("test/muipidan.lsc"),
            ApplyChangesRequest(listFrom("ptr_test_1.wli")),
            ApplyChangesRequest(listFrom("ptr_test_2.wli"))
        )
        responses[0].shouldBeInstanceOf<ServerResponse.Ok>()
        checkWords(responses[1], "ptr_test_1.wli")
        responses[2].shouldBeInstanceOf<ServerResponse.Ok>()
        checkWords(responses[3], "ptr_test_1_ev_expected.wli")
        checkWords(responses[4], "ptr_test_2_ev_expected.wli")
    }

    "Server mode supports loading changes from a string".config(enabled = !Platform.isWindows()) {
        val responses = runRequests(
            LoadChangesFromStringRequest(Path.of("test/empty.lsc").readText()),
            ApplyChangesRequest(listFrom("ptr_test_1.wli")),
            LoadChangesFromStringRequest(Path.of("test/muipidan.lsc").readText()),
            ApplyChangesRequest(listFrom("ptr_test_1.wli")),
            ApplyChangesRequest(listFrom("ptr_test_2.wli"))
        )
        responses[0].shouldBeInstanceOf<ServerResponse.Ok>()
        checkWords(responses[1], "ptr_test_1.wli")
        responses[2].shouldBeInstanceOf<ServerResponse.Ok>()
        checkWords(responses[3], "ptr_test_1_ev_expected.wli")
        checkWords(responses[4], "ptr_test_2_ev_expected.wli")
    }

    "Server mode errors on invalid lsc file".config(enabled = !Platform.isWindows()) {
        val responses = runRequests(LoadChangesFromStringRequest("garbage"))
        responses[0].shouldBeInstanceOf<ServerResponse.Error>()
    }

    "Server mode errors on invalid request type".config(enabled = !Platform.isWindows()) {
        val response = runServer("", """{"type": "garbage", "data": {}}""")
        response.shouldBeInstanceOf<ServerResponse.Error>()
    }

    "Server mode errors on missing request data".config(enabled = !Platform.isWindows()) {
        val response = runServer("", """{"type": "apply"}""")
        response.shouldBeInstanceOf<ServerResponse.Error>()
    }

    "Server mode errors on #include directives in a load_string request".config(enabled = !Platform.isWindows()) {
        val responses = runRequests(LoadChangesFromStringRequest("#include \"empty.lsc\""))
        val err = responses[0].shouldBeInstanceOf<ServerResponse.Error>()
        err.message shouldBe LscUnsupportedDirective().message
    }

    "Server mode can do tracing".config(enabled = !Platform.isWindows()) {
        val response = runServer(
            "test/muipidan.lsc",
            ApplyChangesRequest(listOf("manaka"), traceWords = listOf("manaka")).encode(),
        )
        response.shouldBeInstanceOf<ServerResponse.Changed>()
        response.words shouldBe listOf("manga")
        response.traceLines shouldBe listOf(
            "Tracing manaka",
            "Applied first-syllable-stress: manaka -> mˈanaka",
            "Applied syncope: mˈanaka -> mˈanka",
            "Applied remove-stress: mˈanka -> manka",
            "Applied consonant-coalescence: manka -> maᵑga",
            "Applied Romanizer: maᵑga -> manga"
        )
    }
})
