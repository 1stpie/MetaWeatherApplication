package com.ironelder.metaweatherproject.ui.home.model

data class HomeWeatherModel(

    val title: String,
    val detailId: Int,
    val todayHumidity: String,
    val todayTemp: String,
    val todayWeatherName: String,
    val todayImageUrl: String,
    val tomorrowHumidity: String,
    val tomorrowTemp: String,
    val tomorrowWeatherName: String,
    val tomorrowImageUrl: String

) : MetaHomeModel