package com.github.yoviep.ktorserverexample.server.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*


/**
 * @created 25-05-2022 19:44
 * @author yoviekaputra
 * @project KtorServerExample
 **/

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}