package com.ironelder.metaweatherproject.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.ironelder.metaweatherproject.R
import com.ironelder.metaweatherproject.databinding.FragmentHomeBinding
import com.ironelder.metaweatherproject.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel, HomeState>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        viewDataBinding.rvWeatherResult.adapter
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {isLoading->
            viewDataBinding.pgbLoading.visibility = if(isLoading) View.VISIBLE else View.GONE
        })
    }

    override fun onStateChanged(changedState: HomeState) {
        super.onStateChanged(changedState)
    }

}
