package com.meamoria.lexurgy.api

import io.ktor.server.application.*
import io.ktor.util.*
import kotlinx.serialization.Serializable

val affinityHeaders = AttributeKey<Map<String, String>>("affinityHeaders")

val SessionAffinity = createApplicationPlugin(
    name = "SessionAffinity",
    createConfiguration = ::SessionAffinityConfiguration
) {
    onCall { call ->
        call.attributes.put(affinityHeaders, pluginConfig.affinityHeaders)
    }
}

class SessionAffinityConfiguration {
    var affinityHeaders: Map<String, String> = emptyMap()
}

@Serializable
data class RunningInBackgroundWithSessionAffinityResponse(
    val url: String,
    val affinityHeaders: Map<String, String>,
)
