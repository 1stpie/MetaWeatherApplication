package com.ironelder.metaweatherproject.ui.splash

import androidx.lifecycle.viewModelScope
import com.ironelder.metaweatherproject.ui.base.BaseWeatherViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : BaseWeatherViewModel<SplashState>() {

    init {
        viewModelScope.launch {
            delay(1000)
            runState(SplashState.GoHome)
        }
    }

}