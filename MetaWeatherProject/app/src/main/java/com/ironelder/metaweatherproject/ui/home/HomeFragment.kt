package com.ironelder.metaweatherproject.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.ironelder.metaweatherproject.R
import com.ironelder.metaweatherproject.databinding.FragmentHomeBinding
import com.ironelder.metaweatherproject.ui.base.BaseFragment
import com.ironelder.metaweatherproject.ui.home.adapter.WeatherAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel, HomeState>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        viewDataBinding.rvWeatherResult.adapter
        viewDataBinding.rvWeatherResult.adapter = WeatherAdapter()
        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            viewDataBinding.pgbLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
        })
        viewModel.weatherDataList.observe(viewLifecycleOwner, Observer { datalist ->
            println("datalist = $datalist")
            if (datalist.isNotEmpty()) {
                (viewDataBinding.rvWeatherResult.adapter as WeatherAdapter).setWeatherList(datalist)
            }
        })
    }

    override fun onStateChanged(changedState: HomeState) {
        super.onStateChanged(changedState)
    }

}
