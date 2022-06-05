package com.github.yoviep.ktorserverexample.presentations.server.controller.person.usecases

import com.github.yoviep.ktorserverexample.domain.model.PersonDomain
import com.github.yoviep.ktorserverexample.domain.repositories.PersonRepository
import com.github.yoviep.ktorserverexample.domain.usecases.GetPersonUseCase
import javax.inject.Inject


/**
 * @created 04-06-2022 22:47
 * @author yoviekaputra
 * @project KtorServerExample
 **/

class GetPersonUseCaseImpl @Inject constructor(
    private val personRepository: PersonRepository
) : GetPersonUseCase {

    override fun invoke(id: Int): PersonDomain? {
        return personRepository.getPerson(id = id)
    }
}