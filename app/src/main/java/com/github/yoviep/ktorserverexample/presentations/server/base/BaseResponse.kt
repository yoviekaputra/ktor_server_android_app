package com.github.yoviep.ktorserverexample.presentations.server.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T: Any>(
    @SerialName("status")
    val status: Boolean,
    @SerialName("data")
    val data: T?,
    @SerialName("message")
    val message: String
)
