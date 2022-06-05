package com.github.yoviep.ktorserverexample.data.source.local

import com.github.yoviep.ktorserverexample.data.source.PersonDataSource
import com.github.yoviep.ktorserverexample.data.source.local.models.PersonDummy
import com.github.yoviep.ktorserverexample.data.source.local.models.PersonEntity
import javax.inject.Inject


/**
 * @created 04-06-2022 22:27
 * @author yoviekaputra
 * @project KtorServerExample
 **/

class PersonLocalDataSourceImpl @Inject constructor(
    private val dummy: PersonDummy
) : PersonDataSource {

    override fun getPersons(): List<PersonEntity> = dummy.all

    override fun getPerson(id: Int): PersonEntity? = dummy.all.getOrNull(id)
}