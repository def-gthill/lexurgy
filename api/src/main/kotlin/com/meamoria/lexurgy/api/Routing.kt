package com.meamoria.lexurgy.api

import com.meamoria.lexurgy.api.sc.v1.*
import com.meamoria.lexurgy.api.inflect.v1.Request as InflectV1Request
import com.meamoria.lexurgy.api.inflect.v1.runInflect as runInflectV1
import com.meamoria.lexurgy.api.inflect.v1.SuccessResponse as InflectV1SuccessResponse
import com.meamoria.lexurgy.api.inflect.v1.ErrorResponse as InflectV1ErrorResponse
import com.meamoria.lexurgy.sc.SoundChanger
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("You've reached the Lexurgy API! The root doesn't do anything though.")
        }
        get("/version") {
            call.respondText((SoundChanger::class).java.`package`.implementationVersion)
        }
        post("/scv1") {
            val request = call.receive<Scv1Request>()
            when (val response = runScv1(request)) {
                is Scv1SuccessResponse -> call.respond(response)
                is Scv1ErrorResponse -> {
                    call.response.status(HttpStatusCode.BadRequest)
                    call.respond(response)
                }
            }
        }
        post("/scv1/validate") {
            val request = call.receive<Scv1ValidateRequest>()
            when (val response = runScv1Validate(request)) {
                is Scv1ValidateSuccessResponse -> call.respond(response)
                is Scv1ValidateErrorResponse -> {
                    call.response.status(HttpStatusCode.BadRequest)
                    call.respond(response)
                }
            }
        }
        post("/inflectv1") {
            val request = call.receive<InflectV1Request>()
            when (val response = runInflectV1(request)) {
                is InflectV1SuccessResponse -> call.respond(response)
                is InflectV1ErrorResponse -> {
                    call.response.status(HttpStatusCode.BadRequest)
                    call.respond(response)
                }
            }
        }
    }
}
