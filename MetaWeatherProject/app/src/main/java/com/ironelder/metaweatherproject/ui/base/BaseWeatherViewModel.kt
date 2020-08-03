package com.ironelder.metaweatherproject.ui.base

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ironelder.metaweatherproject.util.StateEvent
import com.ironelder.metaweatherproject.util.ext.liveOf

open class BaseWeatherViewModel<S : BaseState> : ViewModel(), BaseViewModelLifeCycle {

    private val _state: MutableLiveData<StateEvent<S>> by liveOf()
    val state: LiveData<StateEvent<S>> = _state

    @MainThread
    protected fun runState(state: S) {
        _state.value = StateEvent(state)
    }

    protected fun postState(state: S) {
        _state.postValue(StateEvent(state))
    }
}