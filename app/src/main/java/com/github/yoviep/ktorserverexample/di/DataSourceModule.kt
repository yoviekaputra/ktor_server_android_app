package com.github.yoviep.ktorserverexample.di

import com.github.yoviep.ktorserverexample.data.source.PersonDataSource
import com.github.yoviep.ktorserverexample.data.source.local.PersonLocalDataSourceImpl
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
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindPersonDataSource(
        personLocalDataSourceImpl: PersonLocalDataSourceImpl
    ): PersonDataSource
}