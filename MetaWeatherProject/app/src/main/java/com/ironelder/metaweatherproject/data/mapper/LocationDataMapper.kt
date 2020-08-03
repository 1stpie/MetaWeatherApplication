package com.ironelder.metaweatherproject.data.mapper

import com.ironelder.metaweatherproject.data.model.LocationData
import com.ironelder.metaweatherproject.domain.model.LocationModel
import com.ironelder.metaweatherproject.domain.model.MetaDomainModel

object LocationDataMapper : MetaDataMapper<LocationData, LocationModel> {
    override fun mapToModel(from: LocationData): LocationModel {
        return LocationModel(
            latt_long = from.latt_long,
            location_type = from.location_type,
            title = from.title,
            woeid = from.woeid
        )
    }

    override fun mapToData(from: LocationModel): LocationData {
        return LocationData(
            latt_long = from.latt_long,
            location_type = from.location_type,
            title = from.title,
            woeid = from.woeid
        )
    }
}