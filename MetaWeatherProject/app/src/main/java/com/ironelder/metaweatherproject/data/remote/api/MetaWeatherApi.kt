package com.ironelder.metaweatherproject.data.remote.api

import com.ironelder.metaweatherproject.data.model.LocationData
import com.ironelder.metaweatherproject.data.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MetaWeatherApi {
    @GET("api/location/search/")
    suspend fun getLocation(@Query("query") query: String): List<LocationData>

    @GET("api/location/{locationId}/")
    suspend fun getWeather(@Path("locationId") locationId: String): WeatherData
}