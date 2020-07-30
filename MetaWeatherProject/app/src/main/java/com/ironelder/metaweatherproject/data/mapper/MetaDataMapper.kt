package com.ironelder.metaweatherproject.data.mapper

import com.ironelder.metaweatherproject.data.model.MetaWeatherData
import com.ironelder.metaweatherproject.domain.model.MetaDomainModel

interface MetaDataMapper<D : MetaWeatherData, M : MetaDomainModel> {

    fun mapToModel(from: D): M

    fun mapToData(from: M): D

}