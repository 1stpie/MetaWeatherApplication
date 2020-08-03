package com.ironelder.metaweatherproject.ui.application

import android.app.Application
import com.ironelder.metaweatherproject.BuildConfig
import com.ironelder.metaweatherproject.di.remoteModule
import com.ironelder.metaweatherproject.di.repositoryModule
import com.ironelder.metaweatherproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MetaWeatherApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.NONE)
            androidContext(this@MetaWeatherApplication)
            modules(
                remoteModule,
                repositoryModule,
                viewModelModule
            )
        }
    }

}