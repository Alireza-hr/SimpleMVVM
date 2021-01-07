package com.alireza.simplemvvm.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding>(
    private val classViewModel: Class<VM>
) : Fragment(), ViewContract {

    private val viewModel: VM by lazy {
        getViewM()
    }

    private lateinit var dataBinding: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<DB>(
            inflater,
            getLayoutResourceId(),
            container,
            false
        ).apply {
            setLifecycleOwner { lifecycle }
        }

        onCreateView(savedInstanceState, binding, viewModel)

        return binding.root
    }

    private fun getViewM(): VM = ViewModelProvider(this).get(classViewModel)

    protected abstract fun onCreateView(
        savedInstanceState: Bundle?,
        dataBinding: DB,
        viewModel: VM
    )

    protected fun toast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}