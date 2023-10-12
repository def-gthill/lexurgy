package com.meamoria.lexurgy.api

import io.ktor.server.application.*
import io.ktor.util.*

val totalTimeoutKey = AttributeKey<Double>("totalTimeoutSeconds")

val Timeouts = createApplicationPlugin(
    name = "Timeouts",
    createConfiguration = ::TimeoutConfiguration,
) {
    onCall { call ->
        call.attributes.put(totalTimeoutKey, pluginConfig.totalTimeoutSeconds)
    }
}

class TimeoutConfiguration {
    var totalTimeoutSeconds: Double = 0.5
}
