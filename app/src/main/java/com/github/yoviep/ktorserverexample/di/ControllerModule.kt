package com.github.yoviep.ktorserverexample.di

import com.github.yoviep.ktorserverexample.presentations.server.controller.main.MainController
import com.github.yoviep.ktorserverexample.presentations.server.controller.main.MainControllerImpl
import com.github.yoviep.ktorserverexample.presentations.server.controller.person.PersonController
import com.github.yoviep.ktorserverexample.presentations.server.controller.person.PersonControllerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 04-06-2022 22:13
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class ControllerModule {

    @Binds
    @Singleton
    abstract fun bindMainController(
        mainControllerImpl: MainControllerImpl
    ): MainController

    @Binds
    @Singleton
    abstract fun bindPersonController(
        personControllerImpl: PersonControllerImpl
    ): PersonController
}