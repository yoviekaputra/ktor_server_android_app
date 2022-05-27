package com.github.yoviep.ktorserverexample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


/**
 * @created 25-05-2022 10:45
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@Composable
fun MainContent(
    onServerStartup: () -> Unit
) {
    Scaffold {
        Column(
            content = {

                Button(
                    onClick = onServerStartup,
                    content = {
                        Text(
                            text = "Start Server"
                        )
                    }
                )
            }
        )
    }
}