package com.github.yoviep.ktorserverexample.ui

import androidx.lifecycle.ViewModel
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.github.yoviep.ktorserverexample.server.worker.ServerWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * @created 27-05-2022 08:30
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@HiltViewModel
class MainViewModel @Inject constructor(
    private val workerManager: WorkManager
) : ViewModel() {

    fun onServerStart() {
        val constraints = Constraints.Builder().build()
        val worker = OneTimeWorkRequestBuilder<ServerWorker>()
            .setConstraints(constraints)
            .build()

        workerManager.enqueueUniqueWork(
            "server_worker",
            ExistingWorkPolicy.KEEP,
            worker
        )
    }
}