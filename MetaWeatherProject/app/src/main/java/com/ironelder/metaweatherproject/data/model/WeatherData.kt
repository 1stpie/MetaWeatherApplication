package com.ironelder.metaweatherproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherData(

    @SerializedName("consolidated_weather")
    @Expose
    val consolidated_weatherData: List<ConsolidatedWeatherData>,

    @SerializedName("latt_long")
    @Expose
    val latt_long: String,

    @SerializedName("location_type")
    @Expose
    val location_type: String,

    @SerializedName("parent")
    @Expose
    val parentData: ParentData,

    @SerializedName("sources")
    @Expose
    val sourceData: List<SourceData>,

    @SerializedName("sun_rise")
    @Expose
    val sun_rise: String,

    @SerializedName("sun_set")
    @Expose
    val sun_set: String,

    @SerializedName("time")
    @Expose
    val time: String,

    @SerializedName("timezone")
    @Expose
    val timezone: String,

    @SerializedName("timezone_name")
    @Expose
    val timezone_name: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("woeid")
    @Expose
    val woeid: Int
) : MetaWeatherData