package com.github.yoviep.ktorserverexample.presentations.server.plugins

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.ktor.server.application.*
import io.ktor.server.plugins.*


/**
 * @created 05-06-2022 20:46
 * @author yoviekaputra
 * @project KtorServerExample
 **/

private val _uiLogger = MutableLiveData<String>()
val uiLogger: LiveData<String> get() = _uiLogger

val RequestLoggingPlugin = createApplicationPlugin(name = "RequestLoggingPlugin") {
    onCall {  call ->
        call.request.apply {
            val log = StringBuilder()

            with(origin) {
                log.appendLine("-->> [${method.value}] ${scheme}://${host}:${port}${uri}")
            }

            if (!headers.isEmpty()) {
                log.appendLine("-- Headers --")
                headers.forEach { key, value ->
                    log.appendLine("$key : ${value.joinToString(",")}")
                }
                log.appendLine("-- End Headers --")
            }

            if (!call.parameters.isEmpty()) {
                log.appendLine("-- Parameters --")
                call.parameters.forEach { key, value ->
                    log.appendLine("$key : ${value.joinToString(",")}")
                }
                log.appendLine("-- End Parameters --")
            }

            println(log.toString())
            _uiLogger.postValue(log.toString())
        }
    }

    onCallRespond { call ->
        call.response.apply {
            val log = StringBuilder()

            with(call.request.origin) {
                log.appendLine("<<-- [${call.response.status()?.value}] ${scheme}://${host}:${port}${uri}")
            }

            if (!headers.allValues().isEmpty()) {
                log.appendLine("-- Headers --")
                headers.allValues().forEach { key, value ->
                    log.appendLine("$key : ${value.joinToString(",")}")
                }
                log.appendLine("-- End Headers --")
            }


            transformBody { data ->
                log.appendLine("-- Body --")
                log.appendLine(data)
                log.appendLine("-- End Body --")
                data
            }

            println(log.toString())
            _uiLogger.postValue(log.toString())
        }
    }
}

fun Application.configureTerminalLogger() {
    install(RequestLoggingPlugin)
}