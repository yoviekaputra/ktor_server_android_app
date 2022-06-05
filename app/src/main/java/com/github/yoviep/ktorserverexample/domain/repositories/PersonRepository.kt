package com.github.yoviep.ktorserverexample.domain.repositories

import com.github.yoviep.ktorserverexample.domain.model.PersonDomain


/**
 * @created 04-06-2022 22:26
 * @author yoviekaputra
 * @project KtorServerExample
 **/

interface PersonRepository {

    fun getPersons(): List<PersonDomain>

    fun getPerson(id: Int) : PersonDomain?
}