package com.github.yoviep.ktorserverexample.server.plugins

import com.github.yoviep.ktorserverexample.server.models.Person
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


/**
 * @created 25-05-2022 10:47
 * @author yoviekaputra
 * @project KtorServerExample
 **/

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText(
                text = "Congratulation... you access ktor server",
                status = HttpStatusCode.OK
            )
        }

        for (i in 0 until 5) {
            get("/person/${i}") {
                call.respond(
                    Person(name = "Person $i", age = 29)
                )
            }
        }
    }
}

