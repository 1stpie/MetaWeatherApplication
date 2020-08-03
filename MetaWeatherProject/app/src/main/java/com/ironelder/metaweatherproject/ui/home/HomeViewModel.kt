package com.ironelder.metaweatherproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ironelder.metaweatherproject.domain.repository.MetaWeatherRepository
import com.ironelder.metaweatherproject.ui.base.BaseWeatherViewModel
import com.ironelder.metaweatherproject.ui.home.model.HomeWeatherModel
import com.ironelder.metaweatherproject.util.NotNullMutableLiveData
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

class HomeViewModel(private val repository: MetaWeatherRepository) :
    BaseWeatherViewModel<HomeState>() {

    private val _refreshing = NotNullMutableLiveData<Boolean>(false)
    val refreshing: LiveData<Boolean> get() = _refreshing

    private val _isLoading: NotNullMutableLiveData<Boolean> = NotNullMutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _weatherDataList: NotNullMutableLiveData<List<HomeWeatherModel>> =
        NotNullMutableLiveData(
            emptyList()
        )
    val weatherDataList: LiveData<List<HomeWeatherModel>> get() = _weatherDataList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                println("showLoading")
                showLoading()
            }
            val simpleDateFormat = SimpleDateFormat("YYYY-MM-dd", Locale.getDefault())
            val calendar = Calendar.getInstance()
            val today: String = simpleDateFormat.format(calendar.time)
            calendar.add(Calendar.DAY_OF_YEAR, 1)
            val tomorrow: String = simpleDateFormat.format(calendar.time)
            val weatherDataList: MutableList<HomeWeatherModel> = mutableListOf()
            withContext(Dispatchers.IO) {
                val local = repository.getLocation("se")
                local.map {
                    async {
                        val weather = repository.getWeather(it.woeid)
                        val todayWeather =
                            weather.consolidated_weatherData.first { it.applicable_date == today }
                        val tomorrowWeather =
                            weather.consolidated_weatherData.first { it.applicable_date == tomorrow }
                        weatherDataList.add(
                            HomeWeatherModel(
                                title = weather.title,
                                detailId = weather.woeid,
                                todayHumidity = todayWeather.humidity,
                                todayTemp = todayWeather.the_temp,
                                todayWeatherName = todayWeather.weather_state_name,
                                todayImageUrl = todayWeather.weather_state_abbr,
                                tomorrowHumidity = tomorrowWeather.humidity,
                                tomorrowTemp = tomorrowWeather.the_temp,
                                tomorrowWeatherName = tomorrowWeather.weather_state_name,
                                tomorrowImageUrl = tomorrowWeather.weather_state_abbr
                            )
                        )
                    }
                }.awaitAll()
                println("weatherDataList = $weatherDataList")
            }
            withContext(Dispatchers.Main) {
                println("hideLoading")
                hideLoading()
            }
        }
    }

    private fun showLoading() {
        _isLoading.value = true
        _refreshing.value = false
    }

    private fun hideLoading() {
        _isLoading.value = false
        _refreshing.value = true
    }

}