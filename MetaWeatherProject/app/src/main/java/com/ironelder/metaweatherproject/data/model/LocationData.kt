package com.ironelder.metaweatherproject.data.model

data class LocationData(

    val latt_long: String,

    val location_type: String,

    val title: String,

    val woeid: Int

) : MetaWeatherData