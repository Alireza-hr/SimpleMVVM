package com.alireza.simplemvvm.view

import android.os.Bundle

import androidx.databinding.ViewDataBinding
import com.alireza.simplemvvm.R
import com.alireza.simplemvvm.databinding.ActivityMainBinding
import com.alireza.simplemvvm.view.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun onCreate(
        savedInstanceState: Bundle?,
        viewDataBinding: ViewDataBinding
    ) {}
}