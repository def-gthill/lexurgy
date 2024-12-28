package com.meamoria.lexurgy.api

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.callloging.*

fun main() {
    embeddedServer(
        Netty,
        port = System.getenv("PORT")?.toInt() ?: 8080,
        host = "0.0.0.0",
        module = Application::module,
        configure = {
            callGroupSize = 20
        }
    ).start(wait = true)
}

fun Application.module() {
    install(ApiKeyChecking) {
        apiKey = System.getenv("API_KEY")
    }
    configureSerialization()
    configureRouting()
    install(CallLogging)
    install(Timeouts) {
        this.singleStepTimeoutSeconds = System.getenv("SINGLE_STEP_TIMEOUT").toDouble()
        this.requestTimeoutSeconds = System.getenv("REQUEST_TIMEOUT").toDouble()
        this.totalTimeoutSeconds = System.getenv("TOTAL_TIMEOUT").toDouble()
    }
    install(SessionAffinity) {
        this.affinityHeaders = System.getenv("AFFINITY_HEADERS").parseMap()
    }
}

fun String.parseMap(): Map<String, String> =
    split(",").map {
        val entry = it.split(":")
        Pair(entry[0], entry[1])
    }.toMap()
