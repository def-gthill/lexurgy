package com.meamoria.lexurgy.api

import com.meamoria.lexurgy.api.inflect.v1.runInflectV1
import com.meamoria.lexurgy.api.sc.v1.pollScV1
import com.meamoria.lexurgy.api.sc.v1.runScV1
import com.meamoria.lexurgy.api.sc.v1.runScV1Validate
import com.meamoria.lexurgy.sc.SoundChanger
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import java.util.concurrent.atomic.AtomicInteger

fun Application.configureRouting() {
    val backgroundCounter = AtomicInteger()
    routing {
        get("/") {
            call.respondText("You've reached the Lexurgy API! The root doesn't do anything though.")
        }
        get("/version") {
            call.respondText((SoundChanger::class).java.`package`.implementationVersion)
        }
        post("/background") {
            val thread = Thread {
                backgroundCounter.set(0)
                for (i in 1..20) {
                    Thread.sleep(10)
                    val counter = backgroundCounter.incrementAndGet()
                    println("Working, counter = $counter")
                }
            }
            thread.start()
            call.response.status(HttpStatusCode.Accepted)
            call.respond(buildJsonObject {
                put("url", "/background/placeholderForJobId")
            })
        }
        get("/background/placeholderForJobId") {
            val counter = backgroundCounter.get()
            if (counter >= 20) {
                call.respond(buildJsonObject {
                    put("status", "working")
                })
            } else {
                call.respond(buildJsonObject {
                    put("status", "done")
                    put("result", 42)
                })
            }
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
