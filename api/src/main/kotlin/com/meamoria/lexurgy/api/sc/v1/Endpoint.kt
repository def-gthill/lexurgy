package com.meamoria.lexurgy.api.sc.v1

import com.meamoria.lexurgy.api.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

suspend fun ApplicationCall.runScV1() {
    val request = receive<Request>()
    val totalTimeoutSeconds = this.attributes[totalTimeoutSeconds]
    val requestTimeoutSeconds = this.attributes[requestTimeoutKey]
    val singleStepTimeoutSeconds = this.attributes[singleStepTimeoutSeconds]
    val affinityHeaders = this.attributes[affinityHeaders]
    val response = runScv1(
        request,
        timeoutSettings = TimeoutSettings(
            totalTimeoutSeconds = totalTimeoutSeconds,
            requestTimeoutSeconds = requestTimeoutSeconds,
            singleStepTimeoutSeconds = singleStepTimeoutSeconds,
        )
    )
    when (response) {
        is SuccessResponse -> respond(response)
        is RunningInBackgroundResponse -> {
            this.response.status(HttpStatusCode.Accepted)
            respond(
                RunningInBackgroundWithSessionAffinityResponse(
                    response.url,
                    affinityHeaders,
                )
            )
        }
        is ErrorResponse -> {
            this.response.status(HttpStatusCode.BadRequest)
            respond(response)
        }
    }
}

suspend fun ApplicationCall.pollScV1(jobId: String) {
    val response = pollScv1(jobId)
    if (response is DoneWithErrorResponse) {
        this.response.status(HttpStatusCode.BadRequest)
    } else if (response is ExpiredResponse) {
        this.response.status(HttpStatusCode.InternalServerError)
    }
    respond(response)
}

suspend fun ApplicationCall.runScV1Validate() {
    val request = receive<ValidateRequest>()
    when (val response = runScv1Validate(request)) {
        is ValidateSuccessResponse -> respond(response)
        is ValidateErrorResponse -> {
            this.response.status(HttpStatusCode.BadRequest)
            respond(response)
        }
    }
}