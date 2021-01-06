package com.alireza.simplemvvm.view.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<DB : ViewDataBinding>() : AppCompatActivity() ,ViewContract{

    private lateinit var dataBinding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, getLayoutResourceId())

        setContentView(dataBinding.root)

        onCreate(savedInstanceState, dataBinding)
    }

    protected abstract fun onCreate(
        savedInstanceState: Bundle?,
        viewDataBinding: ViewDataBinding
    )
}