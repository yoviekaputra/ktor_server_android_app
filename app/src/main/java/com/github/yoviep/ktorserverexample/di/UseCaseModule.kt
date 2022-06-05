package com.github.yoviep.ktorserverexample.di

import com.github.yoviep.ktorserverexample.domain.usecases.GetPersonUseCase
import com.github.yoviep.ktorserverexample.domain.usecases.GetPersonsUseCase
import com.github.yoviep.ktorserverexample.presentations.server.controller.person.usecases.GetPersonUseCaseImpl
import com.github.yoviep.ktorserverexample.presentations.server.controller.person.usecases.GetPersonsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 04-06-2022 22:45
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindGetPersonsUseCase(
        getPersonsUseCaseImpl: GetPersonsUseCaseImpl
    ): GetPersonsUseCase

    @Binds
    @Singleton
    abstract fun bindGetPersonUseCase(
        getPersonUseCaseImpl: GetPersonUseCaseImpl
    ): GetPersonUseCase
}