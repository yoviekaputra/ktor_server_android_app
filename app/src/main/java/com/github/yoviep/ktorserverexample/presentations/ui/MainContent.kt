package com.github.yoviep.ktorserverexample.presentations.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yoviep.ktorserverexample.presentations.ui.models.UiState


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
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = scrollState.maxValue) {
        scrollState.animateScrollTo(scrollState.maxValue)
    }

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

                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .verticalScroll(scrollState),
                    text = uiState.logging
                )
            }
        )
    }
}