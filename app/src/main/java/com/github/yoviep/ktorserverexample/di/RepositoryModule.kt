package com.github.yoviep.ktorserverexample.di

import com.github.yoviep.ktorserverexample.data.repository.PersonRepositoryImpl
import com.github.yoviep.ktorserverexample.domain.repositories.PersonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 04-06-2022 22:43
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPersonRepository(
        personRepositoryImpl: PersonRepositoryImpl
    ): PersonRepository
}