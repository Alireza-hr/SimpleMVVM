package com.alireza.simplemvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment

import com.alireza.simplemvvm.R
import com.alireza.simplemvvm.databinding.ActivityMainBinding
import com.alireza.simplemvvm.view.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var dataBinding: ActivityMainBinding

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun onCreate(
        savedInstanceState: Bundle?,
        dataBinding: ActivityMainBinding
    ) {
        this.dataBinding = dataBinding

        if (savedInstanceState == null) {
            replaceFragment(
                dataBinding.containFragment.id,
                ListFragment(),
                ListFragment.LIST_FRAGMENT_TAG,
                true
            )
        }
    }

    fun replaceFragment(
        fragmentObject: Fragment,
        fragmentTag: String,
        wantAddToBackStack: Boolean
    ) {
        super.replaceFragment(
            dataBinding.containFragment.id,
            fragmentObject,
            fragmentTag,
            wantAddToBackStack
        )
    }

   public override fun onBackPressed() {
        super.onBackPressed()
    }
}