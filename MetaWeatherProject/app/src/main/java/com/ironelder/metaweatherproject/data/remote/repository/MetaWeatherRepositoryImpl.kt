package com.ironelder.metaweatherproject.data.remote.repository

import com.ironelder.metaweatherproject.data.mapper.LocationDataMapper
import com.ironelder.metaweatherproject.data.mapper.WeatherDataMapper
import com.ironelder.metaweatherproject.data.remote.source.MetaWeatherDataSource
import com.ironelder.metaweatherproject.domain.model.LocationModel
import com.ironelder.metaweatherproject.domain.model.WeatherModel
import com.ironelder.metaweatherproject.domain.repository.MetaWeatherRepository

class MetaWeatherRepositoryImpl(private val weatherRemoteDataSource: MetaWeatherDataSource) :
    MetaWeatherRepository {
    override suspend fun getLocation(query: String): List<LocationModel> {
        return weatherRemoteDataSource.getLocation(query).map(LocationDataMapper::mapToModel)
    }

    override suspend fun getWeather(locationId: Int): WeatherModel {
        return WeatherDataMapper.mapToModel(weatherRemoteDataSource.getWeather(locationId))
    }
}