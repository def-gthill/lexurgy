package com.meamoria.lexurgy.api.sc.v1

import com.meamoria.lexurgy.api.totalTimeoutKey
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

suspend fun ApplicationCall.runScV1() {
    val request = receive<Request>()
    val totalTimeoutSeconds = this.attributes[totalTimeoutKey]
    when (val response = runScv1(request, totalTimeoutSeconds)) {
        is SuccessResponse -> respond(response)
        is RunningInBackgroundResponse -> {
            this.response.status(HttpStatusCode.Accepted)
            respond(response)
        }
        is ErrorResponse -> {
            this.response.status(HttpStatusCode.BadRequest)
            respond(response)
        }
    }
}

suspend fun ApplicationCall.pollScV1(jobId: String) {
    val response = pollScv1(jobId)
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