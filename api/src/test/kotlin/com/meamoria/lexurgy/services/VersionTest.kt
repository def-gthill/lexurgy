package com.meamoria.lexurgy.services

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class VersionTest {
    @Test
    fun retrievesValidVerionNumber() = testApi {
        val response = client.get("/version")
        assertEquals(HttpStatusCode.OK, response.status)
        assertTrue(response.bodyAsText().matches(Regex("""\d+\.\d+\.\d+""")))
    }
}