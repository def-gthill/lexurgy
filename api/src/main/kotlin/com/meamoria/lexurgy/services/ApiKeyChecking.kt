package com.meamoria.lexurgy.services

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

val ApiKeyChecking = createApplicationPlugin(
    name = "ApiKeyChecking",
    createConfiguration = ::ApiKeyCheckingConfiguration,
) {
    onCall { call ->
        if (call.request.path() !in listOf("/", "/version")) {
            val apiKey = call.request.headers[HttpHeaders.Authorization]
            if (apiKey == null) {
                call.respondText("API key missing", status = HttpStatusCode.Unauthorized)
            } else if (apiKey != pluginConfig.apiKey) {
                call.respondText("API key is incorrect", status = HttpStatusCode.Forbidden)
            }
        }
    }
}

class ApiKeyCheckingConfiguration {
    var apiKey: String? = null
}
