package com.github.yoviep.ktorserverexample.di

import android.app.Application
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 27-05-2022 08:29
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@Module
@InstallIn(SingletonComponent::class)
class WorkerModule {

    @Provides
    @Singleton
    fun provideWorkManager(
        applicationContext: Application
    ): WorkManager = WorkManager.getInstance(applicationContext)
}