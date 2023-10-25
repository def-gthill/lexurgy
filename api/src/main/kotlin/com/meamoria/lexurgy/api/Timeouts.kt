package com.meamoria.lexurgy.api

import io.ktor.server.application.*
import io.ktor.util.*

val singleStepTimeoutSeconds = AttributeKey<Double>("singleStepTimeoutSeconds")
val requestTimeoutKey = AttributeKey<Double>("requestTimeoutSeconds")
val totalTimeoutSeconds = AttributeKey<Double>("totalTimeoutSeconds")

val Timeouts = createApplicationPlugin(
    name = "Timeouts",
    createConfiguration = ::TimeoutConfiguration,
) {
    onCall { call ->
        call.attributes.put(singleStepTimeoutSeconds, pluginConfig.singleStepTimeoutSeconds)
        call.attributes.put(requestTimeoutKey, pluginConfig.requestTimeoutSeconds)
        call.attributes.put(totalTimeoutSeconds, pluginConfig.totalTimeoutSeconds)
    }
}

class TimeoutConfiguration {
    var singleStepTimeoutSeconds: Double = 0.1
    var requestTimeoutSeconds: Double = 0.2
    var totalTimeoutSeconds: Double = 0.5
}
