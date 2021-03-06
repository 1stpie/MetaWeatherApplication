package com.ironelder.metaweatherproject.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ironelder.metaweatherproject.R

abstract class BaseFragment(
    private val layoutResourceId: Int
) : Fragment(layoutResourceId) {

}
