package com.meamoria.lexurgy.api

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        port = System.getenv("PORT")?.toInt() ?: 8080,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    install(ApiKeyChecking) {
        apiKey = System.getenv("API_KEY")
    }
    configureSerialization()
    configureRouting()
    install(Timeouts) {
        this.singleStepTimeoutSeconds = System.getenv("SINGLE_STEP_TIMEOUT").toDouble()
        this.requestTimeoutSeconds = System.getenv("REQUEST_TIMEOUT").toDouble()
        this.totalTimeoutSeconds = System.getenv("TOTAL_TIMEOUT").toDouble()
    }
}
