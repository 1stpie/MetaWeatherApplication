package com.ironelder.metaweatherproject.util.ext

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

fun <E : Any> ViewModel.liveOf(defaultValue: E? = null) = lazy {
    MutableLiveData<E>(defaultValue)
}

