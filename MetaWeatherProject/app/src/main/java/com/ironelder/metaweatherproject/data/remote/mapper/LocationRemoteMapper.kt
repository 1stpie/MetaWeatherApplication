package com.ironelder.metaweatherproject.data.remote.mapper

import com.ironelder.metaweatherproject.data.model.LocationData
import com.ironelder.metaweatherproject.data.remote.model.LocationModel as LocationRemoteModel

object LocationRemoteMapper : MetaRemoteMapper<LocationRemoteModel, LocationData> {
    override fun mapToRemote(from: LocationData): LocationRemoteModel {
        return LocationRemoteModel(
            latt_long = from.latt_long,
            location_type = from.location_type,
            title = from.title,
            woeid = from.woeid
        )
    }

    override fun mapToData(from: LocationRemoteModel): LocationData {
        return LocationData(
            latt_long = from.latt_long,
            location_type = from.location_type,
            title = from.title,
            woeid = from.woeid
        )
    }
}