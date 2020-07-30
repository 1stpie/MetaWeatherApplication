package com.ironelder.metaweatherproject.data.remote.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MetaWeatherApi {
    @GET("api/location/search/")
    fun getLocation(@Query("query") query: String): Single<Any>

    @GET("api/location/{locationId}/")
    fun getWeather(@Path("locationId") locationId: String): Single<Any>
}