package com.github.yoviep.ktorserverexample.presentations.server.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.ForegroundInfo
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.github.yoviep.ktorserverexample.utils.NotificationHelper
import com.github.yoviep.ktorserverexample.presentations.server.provider.ServerProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.net.BindException
import javax.inject.Inject


/**
 * @created 27-05-2022 08:16
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@HiltWorker
class ServerWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted private val workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    @Inject
    lateinit var server: ServerProvider

    private val tag = ServerWorker::class.simpleName

    override fun doWork(): Result = runCatching {
        val notification = createForeground()
        setForegroundAsync(notification)

        try {
            server.start()
        } catch (e: Throwable) {
            when (e) {
                is BindException -> {
                    server.restart()
                }
                else -> throw e
            }
        }

        Result.success()
    }.getOrElse { e ->
        Log.e(tag, e.message, e)
        server.stop()
        Result.failure(workDataOf("error" to e))
    }

    override fun onStopped() {
        super.onStopped()
        server.stop()
    }

    private fun createForeground(): ForegroundInfo =
        NotificationHelper.create(
            context = context,
            option = NotificationHelper.Option(
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