package com.ironelder.metaweatherproject.domain.model

data class LocationModel (

    val latt_long: String,

    val location_type: String,

    val title: String,

    val woeid: Int

) : MetaDomainModel