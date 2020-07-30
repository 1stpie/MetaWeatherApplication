package com.ironelder.metaweatherproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ConsolidatedWeather(

    @SerializedName("air_pressure")
    @Expose
    val air_pressure: Double,

    @SerializedName("applicable_date")
    @Expose
    val applicable_date: String,

    @SerializedName("created")
    @Expose
    val created: String,

    @SerializedName("humidity")
    @Expose
    val humidity: Int,

    @SerializedName("id")
    @Expose
    val id: Long,

    @SerializedName("max_temp")
    @Expose
    val max_temp: Double,

    @SerializedName("min_temp")
    @Expose
    val min_temp: Double,

    @SerializedName("predictability")
    @Expose
    val predictability: Int,

    @SerializedName("the_temp")
    @Expose
    val the_temp: Double,

    @SerializedName("visibility")
    @Expose
    val visibility: Double,

    @SerializedName("weather_state_abbr")
    @Expose
    val weather_state_abbr: String,

    @SerializedName("weather_state_name")
    @Expose
    val weather_state_name: String,

    @SerializedName("wind_direction")
    @Expose
    val wind_direction: Double,

    @SerializedName("wind_direction_compass")
    @Expose
    val wind_direction_compass: String,

    @SerializedName("wind_speed")
    @Expose
    val wind_speed: Double
)