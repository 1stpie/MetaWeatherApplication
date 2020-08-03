package com.ironelder.metaweatherproject.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseWeatherViewModel<*>, S:BaseState>(
    @LayoutRes
    protected val layoutResourceId: Int = 0
) : Fragment() {

    protected lateinit var viewDataBinding: VDB
    protected abstract val viewModel: VM

    init {

        lifecycle.addObserver(
            object : LifecycleEventObserver {
                override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                    when (event) {
                        Lifecycle.Event.ON_CREATE -> {
                            viewModel.create()
                        }
                        Lifecycle.Event.ON_START -> {
                            viewModel.start()
                        }
                        Lifecycle.Event.ON_RESUME -> {
                            viewModel.resume()
                        }
                        Lifecycle.Event.ON_PAUSE -> {
                            viewModel.pause()
                        }
                        Lifecycle.Event.ON_STOP -> {
                            viewModel.stop()
                        }
                        Lifecycle.Event.ON_DESTROY -> {
                            lifecycle.removeObserver(this)
                        }
                        else -> {
                        }
                    }
                }
            }
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = DataBindingUtil.inflate<VDB>(inflater, layoutResourceId, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return viewDataBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, Observer {
            if (it != null && it.isUsed.compareAndSet(false, true)) {
                @Suppress("UNCHECKED_CAST")
                onStateChanged(it.event as S)
            }
        })

    }

    protected open fun onStateChanged(changedState: S) {

    }

}
