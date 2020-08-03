package com.ironelder.metaweatherproject.di

import com.ironelder.metaweatherproject.ui.home.HomeViewModel
import com.ironelder.metaweatherproject.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel {SplashViewModel() }

    viewModel { HomeViewModel() }

}