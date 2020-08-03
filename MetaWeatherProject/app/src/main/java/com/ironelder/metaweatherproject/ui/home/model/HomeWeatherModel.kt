package com.ironelder.metaweatherproject.ui.home.model

data class HomeWeatherModel(

    val title: String,
    val detailId: Int,
    val todayHumidity: Int,
    val todayTemp: Double,
    val todayWeatherName: String,
    val todayImageUrl: String,
    val tomorrowHumidity: Int,
    val tomorrowTemp: Double,
    val tomorrowWeatherName: String,
    val tomorrowImageUrl: String

) : MetaHomeModel