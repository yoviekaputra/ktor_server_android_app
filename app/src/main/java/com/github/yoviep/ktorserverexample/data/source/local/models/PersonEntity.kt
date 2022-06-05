package com.github.yoviep.ktorserverexample.data.source.local.models

import com.github.yoviep.ktorserverexample.domain.model.PersonDomain

data class PersonEntity(
    val name: String,
    val age: Int
)

fun PersonEntity.asDomain() = PersonDomain(name = name, age = age)

fun List<PersonEntity>.asDomain() = map {
    it.asDomain()
}