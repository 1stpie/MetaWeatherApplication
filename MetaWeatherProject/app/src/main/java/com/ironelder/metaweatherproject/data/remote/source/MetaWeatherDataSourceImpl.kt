package com.ironelder.metaweatherproject.data.remote.source

import com.ironelder.metaweatherproject.data.model.LocationData
import com.ironelder.metaweatherproject.data.model.WeatherData
import com.ironelder.metaweatherproject.data.remote.api.MetaWeatherApi
import com.ironelder.metaweatherproject.data.remote.mapper.LocationRemoteMapper
import com.ironelder.metaweatherproject.data.remote.mapper.WeatherRemoteMapper

class MetaWeatherDataSourceImpl(private val weatherApi: MetaWeatherApi) : MetaWeatherDataSource {
    override suspend fun getLocation(query: String): List<LocationData> {
        return weatherApi.getLocation(query).map(LocationRemoteMapper::mapToData)
    }

    override suspend fun getWeather(locationId: String): WeatherData {
        return WeatherRemoteMapper.mapToData(weatherApi.getWeather(locationId))
    }
}