package com.ironelder.metaweatherproject.data.remote.api

import com.ironelder.metaweatherproject.data.remote.model.LocationModel
import com.ironelder.metaweatherproject.data.remote.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MetaWeatherApi {
    @GET("api/location/search/")
    suspend fun getLocation(@Query("query") query: String): List<LocationModel>

    @GET("api/location/{locationId}/")
    suspend fun getWeather(@Path("locationId") locationId: String): WeatherModel
}