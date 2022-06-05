package com.github.yoviep.ktorserverexample.presentations.server.routing.main

import com.github.yoviep.ktorserverexample.presentations.server.controller.main.MainController
import com.github.yoviep.ktorserverexample.presentations.server.controller.person.PersonController
import com.github.yoviep.ktorserverexample.presentations.server.routing.person.personRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    mainController: MainController,
    personController: PersonController
) {
    routing {
        get {
            mainController.main(call = call)
        }

        personRoute(personController = personController)
    }
}