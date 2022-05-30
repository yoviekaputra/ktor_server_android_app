package com.github.yoviep.ktorserverexample.server.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    @SerialName("name")
    val name: String,
    @SerialName("age")
    val age: Int
)