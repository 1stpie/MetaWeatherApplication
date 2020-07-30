package com.ironelder.metaweatherproject.data.remote.source

import com.ironelder.metaweatherproject.data.model.LocationData
import com.ironelder.metaweatherproject.data.model.WeatherData

interface MetaWeatherDataSource : MetaRemoteDataSource {
    suspend fun getLocation(query: String): List<LocationData>
    suspend fun getWeather(locationId: String): WeatherData
}