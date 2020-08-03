package com.ironelder.metaweatherproject.ui.splash

import com.ironelder.metaweatherproject.ui.base.BaseState

sealed class SplashState : BaseState {

    object GoHome : SplashState()

}