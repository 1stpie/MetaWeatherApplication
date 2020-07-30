package com.ironelder.metaweatherproject.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherModel(

    @SerializedName("consolidated_weather")
    @Expose
    val consolidated_weatherData: List<ConsolidatedWeatherModel>,

    @SerializedName("latt_long")
    @Expose
    val latt_long: String,

    @SerializedName("location_type")
    @Expose
    val location_type: String,

    @SerializedName("parent")
    @Expose
    val parentData: ParentModel,

    @SerializedName("sources")
    @Expose
    val sourceData: List<SourceModel>,

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
) : MetaWeatherModel

data class SourceModel(

    @SerializedName("crawl_rate")
    @Expose
    val crawl_rate: Int,

    @SerializedName("slug")
    @Expose
    val slug: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("url")
    @Expose
    val url: String
)


data class ParentModel(

    @SerializedName("latt_long")
    @Expose
    val latt_long: String,

    @SerializedName("location_type")
    @Expose
    val location_type: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("woeid")
    @Expose
    val woeid: Int

)


data class ConsolidatedWeatherModel(

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