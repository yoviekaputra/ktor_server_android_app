package com.github.yoviep.ktorserverexample.presentations.ui

import androidx.lifecycle.ViewModel
import androidx.work.*
import com.github.yoviep.ktorserverexample.presentations.server.worker.ServerWorker
import com.github.yoviep.ktorserverexample.presentations.ui.models.EventState
import com.github.yoviep.ktorserverexample.presentations.ui.models.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    private val workerName = "server_worker"

    private val _uiState = MutableStateFlow(UiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        val worker = workerManager.getWorkInfosForUniqueWork(workerName)
        val state = worker.get().firstOrNull()?.state

        if (state == WorkInfo.State.RUNNING) {
            _uiState.update {
                it.copy(serverStarted = true)
            }
        }
    }

    fun onEventState(eventState: EventState) {
        when (eventState) {
            is EventState.OnServerStater -> {
                onServerStater()
            }
        }
    }

    private fun onServerStater() {
        if (_uiState.value.serverStarted) {
            onStopServer()
        } else {
            onStartServer()
        }
    }

    private fun onStopServer() {
        workerManager.cancelUniqueWork(workerName)
        _uiState.update {
            it.copy(serverStarted = false)
        }
    }

    private fun onStartServer() {
        val constraints = Constraints.Builder().build()
        val worker = OneTimeWorkRequestBuilder<ServerWorker>()
            .setConstraints(constraints)
            .build()

        workerManager.enqueueUniqueWork(
            workerName,
            ExistingWorkPolicy.KEEP,
            worker
        )

        _uiState.update {
            it.copy(serverStarted = true)
        }
    }
}