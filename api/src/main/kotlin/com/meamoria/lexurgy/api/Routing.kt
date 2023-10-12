package com.meamoria.lexurgy.api

import com.meamoria.lexurgy.api.inflect.v1.runInflectV1
import com.meamoria.lexurgy.api.sc.v1.pollScV1
import com.meamoria.lexurgy.api.sc.v1.runScV1
import com.meamoria.lexurgy.api.sc.v1.runScV1Validate
import com.meamoria.lexurgy.sc.SoundChanger
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("You've reached the Lexurgy API! The root doesn't do anything though.")
        }
        get("/version") {
            call.respondText((SoundChanger::class).java.`package`.implementationVersion)
        }
        post("/scv1") {
            call.runScV1()
        }
        get("/scv1/poll/{jobId}") {
            call.pollScV1(call.parameters["jobId"]!!)
        }
        post("/scv1/validate") {
            call.runScV1Validate()
        }
        post("/inflectv1") {
            call.runInflectV1()
        }
    }
}
