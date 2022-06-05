package com.github.yoviep.ktorserverexample.data.source

import com.github.yoviep.ktorserverexample.data.source.local.models.PersonEntity


/**
 * @created 04-06-2022 17:11
 * @author yoviekaputra
 * @project KtorServerExample
 **/

interface PersonDataSource {

    fun getPersons(): List<PersonEntity>

    fun getPerson(id: Int): PersonEntity?
}