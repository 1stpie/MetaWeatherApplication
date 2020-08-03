package com.ironelder.metaweatherproject.di

import com.google.gson.GsonBuilder
import com.ironelder.metaweatherproject.BuildConfig
import com.ironelder.metaweatherproject.data.remote.api.MetaWeatherApi
import com.ironelder.metaweatherproject.data.remote.source.MetaWeatherDataSource
import com.ironelder.metaweatherproject.data.remote.source.MetaWeatherDataSourceImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val GSON_DATE_FORMAT = "E, dd MMM yyyy HH:mm:ss Z"

val remoteModule = module {

    single {
        OkHttpClient.Builder()
            .connectTimeout(30L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        GsonBuilder()
            .setDateFormat(GSON_DATE_FORMAT)
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    single { GsonConverterFactory.create(get()) }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.WEATHER_BASE_URL)
            .client(get())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }

    single { get<Retrofit>().create(MetaWeatherApi::class.java) }

    single<MetaWeatherDataSource> { MetaWeatherDataSourceImpl(get()) }

}