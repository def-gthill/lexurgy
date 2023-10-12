package com.meamoria.lexurgy.api.sc.v1

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("status")
sealed interface PollResponse

@Serializable
@SerialName("working")
object WorkingResponse : PollResponse

@Serializable
@SerialName("done")
data class DoneResponse(val result: SuccessResponse) : PollResponse
