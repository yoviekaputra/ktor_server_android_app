package com.github.yoviep.ktorserverexample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.yoviep.ktorserverexample.ui.models.UiState


/**
 * @created 25-05-2022 10:45
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@Composable
fun MainContent(
    uiState: UiState,
    onServerStartup: () -> Unit
) {
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            content = {

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = onServerStartup,
                    content = {
                        Text(
                            text = if (uiState.serverStarted) {
                                "Stop Server"
                            } else {
                                "Start Server"
                            }
                        )
                    }
                )
            }
        )
    }
}