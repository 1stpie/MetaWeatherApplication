package com.ironelder.metaweatherproject.data.model

data class WeatherData(

    val consolidated_weatherData: List<ConsolidatedWeatherData>,

    val latt_long: String,

    val location_type: String,

    val parentData: ParentData,

    val sourceData: List<SourceData>,

    val sun_rise: String,

    val sun_set: String,

    val time: String,

    val timezone: String,

    val timezone_name: String,

    val title: String,

    val woeid: Int
) : MetaWeatherData

data class SourceData(

    val crawl_rate: Int,

    val slug: String,

    val title: String,

    val url: String
)


data class ParentData(

    val latt_long: String,

    val location_type: String,

    val title: String,

    val woeid: Int

)


data class ConsolidatedWeatherData(

    val air_pressure: Double,

    val applicable_date: String,

    val created: String,

    val humidity: Int,

    val id: Long,

    val max_temp: Double,

    val min_temp: Double,

    val predictability: Int,

    val the_temp: Double,

    val visibility: Double,

    val weather_state_abbr: String,

    val weather_state_name: String,

    val wind_direction: Double,

    val wind_direction_compass: String,

    val wind_speed: Double
)