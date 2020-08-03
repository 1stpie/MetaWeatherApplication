package com.ironelder.metaweatherproject.util.ext

import android.view.View
import androidx.databinding.BindingAdapter
import io.reactivex.subjects.Subject

@BindingAdapter("visibleOrInvisible")
fun View.bindVisibleOrInvisible(isVisible: Boolean) {
    println("visibleOrInvisible = $isVisible")
    this.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("onClick")
fun View.bindClick(onClick: Subject<Unit>) {
    this.setOnClickListener {
        onClick.onNext(Unit)
    }
}