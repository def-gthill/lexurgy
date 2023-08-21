package com.meamoria.lexurgy.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
import kotlin.test.assertEquals

fun testApi(block: suspend ApplicationTestBuilder.() -> Unit) {
    testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        block()
    }
}

fun testApiWithKey(block: suspend ApplicationTestBuilder.() -> Unit) {
    testApi {
        application {
            install(ApiKeyChecking) {
                apiKey = "myExampleKey"
            }
        }
        block()
    }
}

suspend fun HttpClient.postJson(
    urlString: String,
    body: String? = null,
    authorization: String? = null,
): HttpResponse =
    post(urlString) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
        if (authorization != null) {
            header(HttpHeaders.Authorization, authorization)
        }
        if (body != null) {
            setBody(body)
        }
    }

suspend fun HttpResponse.assertOkResponseIsJson(expected: String) {
    assertEquals(HttpStatusCode.OK, status)
    assertEquals(expected, bodyAsText())
}
