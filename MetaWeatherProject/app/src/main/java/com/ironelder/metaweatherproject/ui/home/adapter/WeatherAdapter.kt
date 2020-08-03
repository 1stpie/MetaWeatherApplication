package com.ironelder.metaweatherproject.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ironelder.metaweatherproject.R
import com.ironelder.metaweatherproject.ui.home.HomeFragment
import com.ironelder.metaweatherproject.ui.home.model.HomeWeatherModel
import kotlinx.android.synthetic.main.item_weather_list.view.*
import kotlin.math.floor

class WeatherAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mWeatherModelList: MutableList<HomeWeatherModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holder: RecyclerView.ViewHolder
//        val binding: ViewDataBinding =
//            DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        when (viewType) {
            R.layout.item_weather_list_header -> holder = LocationHeaderHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_weather_list_header, parent, false)
            )
            else -> holder = LocationHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_weather_list, parent, false)
            )
        }
        return holder
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            R.layout.item_weather_list_header
        } else {
            R.layout.item_weather_list
        }
    }

    override fun getItemCount(): Int {
        return if (mWeatherModelList.isEmpty()) {
            0
        } else {
            mWeatherModelList.size + 1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LocationHeaderHolder -> {
                val locationHeader: LocationHeaderHolder = holder as LocationHeaderHolder
            }
            is LocationHolder -> {
                println("position = $position")
                val locationHolder: LocationHolder = holder as LocationHolder
                locationHolder.onBind(mWeatherModelList[position - 1])
            }
        }
    }

    fun setWeatherList(weatherList: List<HomeWeatherModel>) {
        if (mWeatherModelList.isNotEmpty()) {
            mWeatherModelList.clear()
        }
        mWeatherModelList.addAll(weatherList)
        notifyDataSetChanged()
    }
}


class LocationHeaderHolder(val view: View) : RecyclerView.ViewHolder(view)

class LocationHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun onBind(item: HomeWeatherModel) {
        println("url = ${item.todayImageUrl}")
        view.tv_local_title.text = item.title
        view.tv_today_weather.text = item.todayWeatherName
        Glide.with(view.context.applicationContext).load(item.todayImageUrl).fitCenter().into(view.iv_today)
        view.tv_today_temp.text = floor(item.todayTemp).toString()
        view.tv_today_humidity.text = item.todayHumidity.toString()
        view.tv_tomorrow_weather.text = item.tomorrowWeatherName
        Glide.with(view.context.applicationContext).load(item.tomorrowImageUrl).fitCenter().into(view.iv_tomorrow)
        view.tv_tomorrow_temp.text = floor(item.tomorrowTemp).toString()
        view.tv_tomorrow_humidity.text = item.tomorrowHumidity.toString()
    }
}