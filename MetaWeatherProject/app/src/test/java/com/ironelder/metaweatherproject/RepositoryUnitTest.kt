package com.ironelder.metaweatherproject

import com.ironelder.metaweatherproject.data.remote.MetaWeatherRepositoryImpl
import com.ironelder.metaweatherproject.data.remote.api.MetaWeatherApi
import com.ironelder.metaweatherproject.data.remote.source.MetaWeatherDataSourceImpl
import com.ironelder.metaweatherproject.di.NetworkApi
import junit.framework.Assert
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RepositoryUnitTest {
    private val api : MetaWeatherApi by lazy {
        val retrofit= Retrofit.Builder()
            .baseUrl(BuildConfig.WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return@lazy retrofit.create(MetaWeatherApi::class.java)
    }

    private val okHttpClient: OkHttpClient by lazy {
        val httpClient = OkHttpClient.Builder().apply {
            connectTimeout(30L, TimeUnit.SECONDS)
            readTimeout(30L, TimeUnit.SECONDS)
            addNetworkInterceptor(HttpLoggingInterceptor())
        }
        return@lazy httpClient.build()
    }

    private val dataSource by lazy {
        MetaWeatherDataSourceImpl(NetworkApi.api)
    }

    private val repository by lazy {
        MetaWeatherRepositoryImpl(dataSource)
    }

    @Before
    fun before() {
        println("before")
    }

    @Test
    fun repositoryModuleTest() {
        runBlocking {
            val locationList = repository.getLocation("se")
            assertNotNull(locationList)
            println("location = $locationList")
        }
    }

    @After
    fun after() {
        println("after")
    }
}
