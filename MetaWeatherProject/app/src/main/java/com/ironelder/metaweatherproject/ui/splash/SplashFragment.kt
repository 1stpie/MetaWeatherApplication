package com.ironelder.metaweatherproject.ui.splash

import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import com.ironelder.metaweatherproject.R
import com.ironelder.metaweatherproject.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment :
    BaseFragment<ViewDataBinding, SplashViewModel, SplashState>(R.layout.fragment_splash) {

    override val viewModel: SplashViewModel by viewModel()

    override fun onStateChanged(changedState: SplashState) {
        when (changedState) {
            SplashState.GoHome -> {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }
        }
    }

}
