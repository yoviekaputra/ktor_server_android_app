package com.github.yoviep.ktorserverexample.server.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.github.yoviep.ktorserverexample.helper.NotificationHelper
import com.github.yoviep.ktorserverexample.server.plugins.configureRouting
import com.github.yoviep.ktorserverexample.server.plugins.configureSerialization
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.ktor.server.engine.*
import io.ktor.server.netty.*


/**
 * @created 27-05-2022 08:16
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@HiltWorker
class ServerWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted params: WorkerParameters
) : CoroutineWorker(context, params) {

    private val server by lazy {
        embeddedServer(Netty, port = 9650) {
            configureRouting()
            configureSerialization()
        }
    }

    override suspend fun doWork(): Result {
        return try {
            val notification = createForeground()
            setForeground(notification)

            server.start(wait = true)

            Result.success()
        } catch (e: Throwable) {
            Log.e(ServerWorker::class.simpleName, e.message, e)
            Result.failure(workDataOf("error" to e))
        }
    }

    private fun createForeground(): ForegroundInfo =
        NotificationHelper.create(
            context,
            NotificationHelper.Option(
                "Ktor Server App",
                "Ktor Server is running",
                NotificationHelper.Channel(
                    ServerWorker::class.java.name,
                    "KtorServerApp: Server mode is running",
                    "Notification Channel for Android When Server Online"
                ),
                ongoing = true,
                showWhen = true
            )
        ).run {
            ForegroundInfo(1, this)
        }
}