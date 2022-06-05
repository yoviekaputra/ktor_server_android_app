package com.github.yoviep.ktorserverexample.presentations.server.base

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

abstract class ResponseProvider {

    suspend inline fun <reified T: Any> success(
        call: ApplicationCall,
        data: T?,
        statusCode: HttpStatusCode = HttpStatusCode.OK
    ) {
        val response = BaseResponse(
            status = true,
            data = data,
            message = "Success"
        )

        call.respond(
            status = statusCode,
            message = response
        )
    }

    suspend inline fun <reified T: Any> error(
        call: ApplicationCall,
        data: T? = null,
        errorMessage: String,
        statusCode: HttpStatusCode = HttpStatusCode.OK
    ) {
        val response = BaseResponse(
            status = false,
            data = data,
            message = errorMessage
        )

        call.respond(
            status = statusCode,
            message = response
        )
    }
}