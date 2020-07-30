package com.ironelder.metaweatherproject.data.remote.source

import io.reactivex.Single

interface MetaWeatherDataSource:MetaRemoteDataSource {
    fun getLocation(query:String) : Single<Any>
    fun getWeather(locationId:String) : Single<Any>
}