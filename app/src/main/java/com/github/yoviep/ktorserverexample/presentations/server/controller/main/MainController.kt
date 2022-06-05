package com.github.yoviep.ktorserverexample.presentations.server.controller.main

import io.ktor.server.application.*


/**
 * @created 04-06-2022 22:20
 * @author yoviekaputra
 * @project KtorServerExample
 **/

interface MainController {

    suspend fun main(call: ApplicationCall)
}