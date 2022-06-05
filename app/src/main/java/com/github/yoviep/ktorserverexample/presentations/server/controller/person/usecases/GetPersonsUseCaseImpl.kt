package com.github.yoviep.ktorserverexample.presentations.server.controller.person.usecases

import com.github.yoviep.ktorserverexample.domain.model.PersonDomain
import com.github.yoviep.ktorserverexample.domain.repositories.PersonRepository
import com.github.yoviep.ktorserverexample.domain.usecases.GetPersonsUseCase
import javax.inject.Inject


/**
 * @created 04-06-2022 22:47
 * @author yoviekaputra
 * @project KtorServerExample
 **/

class GetPersonsUseCaseImpl @Inject constructor(
    private val personRepository: PersonRepository
) : GetPersonsUseCase {

    override fun invoke(): List<PersonDomain> {
        return personRepository.getPersons()
    }
}