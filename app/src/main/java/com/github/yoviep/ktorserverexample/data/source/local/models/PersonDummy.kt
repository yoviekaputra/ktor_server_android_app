package com.github.yoviep.ktorserverexample.data.source.local.models

import javax.inject.Inject
import kotlin.random.Random

class PersonDummy @Inject constructor() {

    val all = (0..10).map { index ->
        PersonEntity("Person $index", Random.nextInt(17, 30))
    }
}