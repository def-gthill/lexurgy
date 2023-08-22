package com.meamoria.lexurgy.api.inflect.v1

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

suspend fun ApplicationCall.runInflectV1() {
    val request = receive<Request>()
    when (val response = runInflect(request)) {
        is SuccessResponse -> respond(response)
        is ErrorResponse -> {
            this.response.status(HttpStatusCode.BadRequest)
            respond(response)
        }
    }
}
