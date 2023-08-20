package com.meamoria.lexurgy.api

import io.ktor.client.request.*
import io.ktor.http.*
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
