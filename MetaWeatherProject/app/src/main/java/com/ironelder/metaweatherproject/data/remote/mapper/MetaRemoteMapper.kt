package com.ironelder.metaweatherproject.data.remote.mapper

import com.ironelder.metaweatherproject.data.model.MetaWeatherData
import com.ironelder.metaweatherproject.data.remote.model.MetaWeatherModel

interface MetaRemoteMapper <RM : MetaWeatherModel, D : MetaWeatherData> {

    fun mapToRemote(from: D): RM

    fun mapToData(from: RM): D

}