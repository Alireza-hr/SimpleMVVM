package com.alireza.simplemvvm.view

import android.os.Bundle
import android.widget.Toolbar
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.alireza.simplemvvm.R
import androidx.navigation.ui.setupWithNavController
import com.alireza.simplemvvm.databinding.ActivityMainBinding
import com.alireza.simplemvvm.view.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun onCreate(
        savedInstanceState: Bundle?,
        dataBinding: ActivityMainBinding
    ) {

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration(navController.graph)
        dataBinding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}