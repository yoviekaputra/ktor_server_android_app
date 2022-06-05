package com.github.yoviep.ktorserverexample.domain.usecases

import com.github.yoviep.ktorserverexample.domain.model.PersonDomain


/**
 * @created 04-06-2022 22:24
 * @author yoviekaputra
 * @project KtorServerExample
 **/

interface GetPersonUseCase {

    operator fun invoke(id: Int): PersonDomain?
}