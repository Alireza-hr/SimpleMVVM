package com.alireza.simplemvvm.view.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<DB : ViewDataBinding>() : AppCompatActivity(), ViewContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<DB>(this, getLayoutResourceId())

        setContentView(binding.root)

        onCreate(savedInstanceState, binding)
    }

    protected abstract fun onCreate(
        savedInstanceState: Bundle?,
        dataBinding: DB
    )
}