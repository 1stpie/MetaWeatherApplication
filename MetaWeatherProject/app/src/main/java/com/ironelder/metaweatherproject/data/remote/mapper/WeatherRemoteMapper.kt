package com.ironelder.metaweatherproject.data.remote.mapper

import com.ironelder.metaweatherproject.data.model.ConsolidatedWeatherData
import com.ironelder.metaweatherproject.data.model.ParentData
import com.ironelder.metaweatherproject.data.model.SourceData
import com.ironelder.metaweatherproject.data.model.WeatherData
import com.ironelder.metaweatherproject.data.remote.model.ConsolidatedWeatherModel
import com.ironelder.metaweatherproject.data.remote.model.ParentModel
import com.ironelder.metaweatherproject.data.remote.model.SourceModel
import com.ironelder.metaweatherproject.data.remote.model.WeatherModel as WeatherRemoteModel

object WeatherRemoteMapper : MetaRemoteMapper<WeatherRemoteModel, WeatherData> {
    override fun mapToRemote(from: WeatherData): WeatherRemoteModel {
        return WeatherRemoteModel(
            consolidated_weatherData = from.consolidated_weatherData.map { it ->
                ConsolidatedWeatherModel(
                    air_pressure = it.air_pressure,
                    applicable_date = it.applicable_date,
                    created = it.created,
                    humidity = it.humidity,
                    id = it.id,
                    max_temp = it.max_temp,
                    min_temp = it.min_temp,
                    predictability = it.predictability,
                    the_temp = it.the_temp,
                    visibility = it.visibility,
                    weather_state_abbr = it.weather_state_abbr,
                    weather_state_name = it.weather_state_name,
                    wind_direction = it.wind_direction,
                    wind_direction_compass = it.wind_direction_compass,
                    wind_speed = it.wind_speed
                )
            },
            latt_long = from.latt_long,
            location_type = from.location_type,
            parentData = ParentModel(
                from.parentData.latt_long,
                from.location_type,
                from.title,
                from.woeid
            ),
            sourceData = from.sourceData.map { it ->
                SourceModel(
                    crawl_rate = it.crawl_rate,
                    slug = it.slug,
                    title = it.title,
                    url = it.url
                )
            },
            sun_rise = from.sun_rise,
            sun_set = from.sun_set,
            time = from.time,
            timezone = from.timezone,
            timezone_name = from.timezone_name,
            title = from.title,
            woeid = from.woeid
        )
    }

    override fun mapToData(from: WeatherRemoteModel): WeatherData {
        return WeatherData(
            consolidated_weatherData = from.consolidated_weatherData.map { it ->
                ConsolidatedWeatherData(
                    air_pressure = it.air_pressure,
                    applicable_date = it.applicable_date,
                    created = it.created,
                    humidity = it.humidity,
                    id = it.id,
                    max_temp = it.max_temp,
                    min_temp = it.min_temp,
                    predictability = it.predictability,
                    the_temp = it.the_temp,
                    visibility = it.visibility,
                    weather_state_abbr = it.weather_state_abbr,
                    weather_state_name = it.weather_state_name,
                    wind_direction = it.wind_direction,
                    wind_direction_compass = it.wind_direction_compass,
                    wind_speed = it.wind_speed
                )
            },
            latt_long = from.latt_long,
            location_type = from.location_type,
            parentData = ParentData(
                from.parentData.latt_long,
                from.location_type,
                from.title,
                from.woeid
            ),
            sourceData = from.sourceData.map { it ->
                SourceData(
                    crawl_rate = it.crawl_rate,
                    slug = it.slug,
                    title = it.title,
                    url = it.url
                )
            },
            sun_rise = from.sun_rise,
            sun_set = from.sun_set,
            time = from.time,
            timezone = from.timezone,
            timezone_name = from.timezone_name,
            title = from.title,
            woeid = from.woeid
        )
    }
}