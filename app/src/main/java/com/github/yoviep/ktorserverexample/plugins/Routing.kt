package com.github.yoviep.ktorserverexample.plugins

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
            call.respondText("Congratulation... you access ktor server")
        }
    }
}