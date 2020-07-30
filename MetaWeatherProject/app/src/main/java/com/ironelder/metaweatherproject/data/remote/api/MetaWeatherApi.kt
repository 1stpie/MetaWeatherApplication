package com.ironelder.metaweatherproject.data.remote.api

import com.ironelder.metaweatherproject.data.model.LocationDataModel
import com.ironelder.metaweatherproject.data.model.WeatherDataModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MetaWeatherApi {
    @GET("api/location/search/")
    fun getLocation(@Query("query") query: String): Single<List<LocationDataModel>>

    @GET("api/location/{locationId}/")
    fun getWeather(@Path("locationId") locationId: String): Single<WeatherDataModel>
}