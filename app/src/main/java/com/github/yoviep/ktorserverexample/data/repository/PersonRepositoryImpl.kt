package com.github.yoviep.ktorserverexample.data.repository

import com.github.yoviep.ktorserverexample.data.source.PersonDataSource
import com.github.yoviep.ktorserverexample.data.source.local.models.asDomain
import com.github.yoviep.ktorserverexample.domain.model.PersonDomain
import com.github.yoviep.ktorserverexample.domain.repositories.PersonRepository
import javax.inject.Inject


/**
 * @created 04-06-2022 22:34
 * @author yoviekaputra
 * @project KtorServerExample
 **/

class PersonRepositoryImpl @Inject constructor(
    private val localDataSource: PersonDataSource
) : PersonRepository {

    override fun getPersons(): List<PersonDomain> {
        return localDataSource.getPersons().asDomain()
    }

    override fun getPerson(id: Int): PersonDomain? {
        return localDataSource.getPerson(id = id)?.asDomain()
    }
}