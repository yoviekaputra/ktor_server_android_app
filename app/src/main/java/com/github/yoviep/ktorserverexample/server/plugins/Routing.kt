package com.github.yoviep.ktorserverexample.server.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable


/**
 * @created 25-05-2022 10:47
 * @author yoviekaputra
 * @project KtorServerExample
 **/

fun Application.configureRouting() {

    install(ShutDownUrl.ApplicationCallPlugin) {
        shutDownUrl = "/shutdown"
        //exitCodeSupplier = { 0 }
    }

    routing {

        get("/") {
            call.respondText(
                text = "Congratulation... you access ktor server",
                status = HttpStatusCode.OK
            )
        }
    }
}

@Serializable
data class Person(val name: String)