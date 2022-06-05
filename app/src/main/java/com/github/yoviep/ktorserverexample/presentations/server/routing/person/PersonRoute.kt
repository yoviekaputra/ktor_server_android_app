package com.github.yoviep.ktorserverexample.presentations.server.routing.person

import com.github.yoviep.ktorserverexample.presentations.server.controller.person.PersonController
import io.ktor.server.application.*
import io.ktor.server.routing.*


/**
 * @created 25-05-2022 10:47
 * @author yoviekaputra
 * @project KtorServerExample
 **/


fun Routing.personRoute(personController: PersonController) {

    route("person") {
        get {
            personController.getPersons(call = call)
        }

        get("{id}") {
            personController.getPersonById(call = call)
        }
    }
}