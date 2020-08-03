package com.ironelder.metaweatherproject.ui.home

import com.ironelder.metaweatherproject.ui.base.BaseState

sealed class HomeState : BaseState {
    data class goDatail(val woeId: String, val date: String) : HomeState()
}