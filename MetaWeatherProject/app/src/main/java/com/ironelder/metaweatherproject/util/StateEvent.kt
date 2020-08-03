package com.ironelder.metaweatherproject.util

import java.util.concurrent.atomic.AtomicBoolean

data class StateEvent<E>(
    val event: E,
    val isUsed: AtomicBoolean = AtomicBoolean(false)
)