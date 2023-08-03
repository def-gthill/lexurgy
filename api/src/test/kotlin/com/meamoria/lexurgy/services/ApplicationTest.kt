package com.meamoria.lexurgy.services

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
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
}
