package com.github.yoviep.ktorserverexample

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


/**
 * @created 27-05-2022 08:26
 * @author yoviekaputra
 * @project KtorServerExample
 **/

@HiltAndroidApp
class KtorServerApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workWorkerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun getWorkManagerConfiguration() = Configuration.Builder()
        .setWorkerFactory(workWorkerFactory)
        .build()
}