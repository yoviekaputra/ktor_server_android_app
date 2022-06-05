package com.github.yoviep.ktorserverexample.presentations.server.controller.person.models

import com.github.yoviep.ktorserverexample.domain.model.PersonDomain
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonResponse(
    @SerialName("name")
    val name: String,
    @SerialName("age")
    val age: Int
)

fun PersonDomain.asResponse() = PersonResponse(
    name = name,
    age = age
)

fun List<PersonDomain>.asResponse() = map {
    it.asResponse()
}