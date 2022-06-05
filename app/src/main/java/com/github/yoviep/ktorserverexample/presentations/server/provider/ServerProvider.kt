package com.github.yoviep.ktorserverexample.presentations.server.provider

import com.github.yoviep.ktorserverexample.presentations.server.controller.main.MainController
import com.github.yoviep.ktorserverexample.presentations.server.controller.person.PersonController
import com.github.yoviep.ktorserverexample.presentations.server.plugins.RequestLoggingPlugin
import com.github.yoviep.ktorserverexample.presentations.server.plugins.configureSerialization
import com.github.yoviep.ktorserverexample.presentations.server.plugins.configureTerminalLogger
import com.github.yoviep.ktorserverexample.presentations.server.routing.main.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @created 04-06-2022 21:42
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@Singleton
class ServerProvider @Inject constructor(
    mainController: MainController,
    personController: PersonController
) {

    private val server by lazy {
        embeddedServer(Netty, port = 9650) {
            configureRouting(
                mainController = mainController,
                personController = personController
            )
            configureSerialization()
            configureTerminalLogger()
        }
    }

    fun start() {
        server.start(wait = true)
    }

    fun restart() {
        server.stopServerOnCancellation().invokeOnCompletion {
            server.start(wait = true)
        }
    }

    fun stop() {
        server.stop()
    }
}