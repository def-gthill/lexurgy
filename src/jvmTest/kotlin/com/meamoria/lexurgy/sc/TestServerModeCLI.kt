package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.lexurgyCommand
import com.meamoria.lexurgy.loadList
import com.meamoria.lexurgy.server.ServerRequest
import com.meamoria.lexurgy.server.ServerResponse
import kotlinx.serialization.json.Json
import com.meamoria.mpp.kotest.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.serialization.encodeToString
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.file.FileSystems
import java.nio.file.Path
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

    fun runServer(changes: String, request: ServerRequest): ServerResponse {
        val response = withStd(Json.encodeToString(request)) {
            lexurgyCommand.parse(arrayOf("server", changes))
        }
        return Json.decodeFromString<ServerResponse>(response)
    }

    "Server mode can do sound changes from a request" {
        val response = runServer("test/muipidan.lsc", ServerRequest(listFrom("ptr_test_1.wli")))
        response.shouldBeInstanceOf<ServerResponse.Changed>()
        response.words shouldBe listFrom("ptr_test_1_ev_expected.wli")
    }

    "Server mode returns an error if rule application failed" {
        val response = runServer("test/test_all_errors.lsc", ServerRequest(listFrom("test_all_errors.wli")))
        response.shouldBeInstanceOf<ServerResponse.Error>()
    }

    "Server mode can do tracing" {
        val response = runServer(
            "test/muipidan.lsc", ServerRequest(listOf("manaka"), traceWords = listOf("manaka"))
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
