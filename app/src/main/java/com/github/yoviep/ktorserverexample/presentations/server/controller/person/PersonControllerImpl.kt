package com.github.yoviep.ktorserverexample.presentations.server.controller.person

import com.github.yoviep.ktorserverexample.domain.usecases.GetPersonUseCase
import com.github.yoviep.ktorserverexample.domain.usecases.GetPersonsUseCase
import com.github.yoviep.ktorserverexample.presentations.server.base.ResponseProvider
import com.github.yoviep.ktorserverexample.presentations.server.controller.person.models.asResponse
import io.ktor.server.application.*
import io.ktor.server.util.*
import javax.inject.Inject


/**
 * @created 04-06-2022 22:10
 * @author yoviekaputra
 * @project KtorServerExample
 **/

class PersonControllerImpl @Inject constructor(
    private val getPersons: GetPersonsUseCase,
    private val getPerson: GetPersonUseCase
) : PersonController, ResponseProvider() {

    override suspend fun getPersons(call: ApplicationCall) {
        success(
            call = call,
            data = getPersons.invoke().asResponse()
        )
    }

    override suspend fun getPersonById(call: ApplicationCall) {
        val id = call.parameters.getOrFail<Int>("id").toInt()
        val persons = getPerson.invoke(id = id)

        if (persons == null) {
            error<String>(
                call = call,
                errorMessage = "Data tidak ditemukan"
            )
        } else {
            success(call = call, data = persons.asResponse())
        }
    }
}