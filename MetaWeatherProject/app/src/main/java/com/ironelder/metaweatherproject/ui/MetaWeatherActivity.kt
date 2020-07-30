package com.ironelder.metaweatherproject.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.ironelder.metaweatherproject.R
import com.ironelder.metaweatherproject.ui.base.BaseActivity

class MetaWeatherActivity : BaseActivity(R.layout.activity_meta_weather) {

    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
