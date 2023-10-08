package com.meamoria.lexurgy.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.delay
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonPrimitive
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun root_CanBePolledToCheckServerIsRunning() = testApi {
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun root_WithApiKeyChecking_DoesNotRequireApiKey() = testApiWithKey {
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun pollingTest_RunsInTheBackground() = testApi {
        var pollingUrl: String
        client.post("/background").apply {
            assertEquals(HttpStatusCode.Accepted, status)
            pollingUrl = bodyAsJson().getValue("url").jsonPrimitive.content
        }
        var done = false
        while (!done) {
            client.get(pollingUrl).apply {
                assertEquals(HttpStatusCode.OK, status)
                val status = bodyAsJson().getValue("status").jsonPrimitive.content
                if (status == "done") {
                    done = true
                    val result = bodyAsJson().getValue("result").jsonPrimitive.int
                    assertEquals(42, result)
                }
            }
            delay(50)
        }
    }

    suspend fun HttpResponse.bodyAsJson(): JsonObject =
        Json.decodeFromString<JsonObject>(bodyAsText())
}
