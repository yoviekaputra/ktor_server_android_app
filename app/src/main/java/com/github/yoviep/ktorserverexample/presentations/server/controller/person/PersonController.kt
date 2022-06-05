package com.github.yoviep.ktorserverexample.presentations.server.controller.person

import io.ktor.server.application.*


/**
 * @created 04-06-2022 22:09
 * @author yoviekaputra
 * @project KtorServerExample
 **/

interface PersonController {

    suspend fun getPersons(call: ApplicationCall)

    suspend fun getPersonById(call: ApplicationCall)
}