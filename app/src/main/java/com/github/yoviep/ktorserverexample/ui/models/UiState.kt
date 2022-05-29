package com.github.yoviep.ktorserverexample.ui.models

import androidx.compose.runtime.Immutable

@Immutable
data class UiState(
    val serverStarted: Boolean = false
)
