package com.ironelder.metaweatherproject.domain.repository

import com.ironelder.metaweatherproject.domain.model.LocationModel
import com.ironelder.metaweatherproject.domain.model.WeatherModel

interface MetaWeatherRepository : MetaRepository {
    suspend fun getLocation(query: String): List<LocationModel>
    suspend fun getWeather(locationId: String): WeatherModel
}