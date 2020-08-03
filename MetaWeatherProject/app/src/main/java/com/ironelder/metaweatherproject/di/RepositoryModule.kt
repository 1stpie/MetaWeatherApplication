package com.ironelder.metaweatherproject.di

import com.ironelder.metaweatherproject.data.remote.repository.MetaWeatherRepositoryImpl
import com.ironelder.metaweatherproject.domain.repository.MetaWeatherRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<MetaWeatherRepository> {
        MetaWeatherRepositoryImpl(
            get()
        )
    }

}