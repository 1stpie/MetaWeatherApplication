package com.ironelder.metaweatherproject.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity(
    private val layoutResourceId: Int
) : AppCompatActivity(layoutResourceId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
