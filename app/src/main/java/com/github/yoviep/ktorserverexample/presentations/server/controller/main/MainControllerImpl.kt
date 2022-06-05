package com.github.yoviep.ktorserverexample.presentations.server.controller.main

import com.github.yoviep.ktorserverexample.presentations.server.base.ResponseProvider
import io.ktor.server.application.*
import javax.inject.Inject


/**
 * @created 04-06-2022 22:20
 * @author yoviekaputra
 * @project KtorServerExample
 **/

class MainControllerImpl @Inject constructor(

) : MainController, ResponseProvider() {

    override suspend fun main(call: ApplicationCall) {
        success(call = call, data = "Welcome in my ktor server")
    }
}