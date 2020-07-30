package com.ironelder.metaweatherproject.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ironelder.metaweatherproject.R
import com.ironelder.metaweatherproject.ui.base.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }

}
