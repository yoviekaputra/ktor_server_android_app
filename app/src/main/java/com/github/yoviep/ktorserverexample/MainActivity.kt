package com.github.yoviep.ktorserverexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.github.yoviep.ktorserverexample.plugins.configureRouting
import com.github.yoviep.ktorserverexample.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainContent(
                onServerStartup = {
                    configServer()
                }
            )
        }
    }

    private fun configServer() {
        Thread {
            embeddedServer(Netty, port = 9650, host = "0.0.0.0") {
                configureRouting()
                configureSerialization()
            }.start(wait = true)
        }.start()
    }
}