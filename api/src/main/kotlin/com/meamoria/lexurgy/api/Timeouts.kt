package com.meamoria.lexurgy.api

import io.ktor.server.application.*
import io.ktor.util.*

val requestTimeoutKey = AttributeKey<Double>("requestTimeoutSeconds")

val Timeouts = createApplicationPlugin(
    name = "Timeouts",
    createConfiguration = ::TimeoutConfiguration,
) {
    onCall { call ->
        call.attributes.put(requestTimeoutKey, pluginConfig.requestTimeoutSeconds)
    }
}

class TimeoutConfiguration {
    var requestTimeoutSeconds: Double = 0.5
}
