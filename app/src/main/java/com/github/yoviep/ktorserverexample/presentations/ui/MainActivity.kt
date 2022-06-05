package com.github.yoviep.ktorserverexample.presentations.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import com.github.yoviep.ktorserverexample.presentations.ui.models.EventState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val uiState = viewModel.uiState.collectAsState()

            MainContent(
                uiState = uiState.value,
                onServerStartup = {
                    viewModel.onEventState(EventState.OnServerStater)
                }
            )
        }
    }
}