package com.alireza.simplemvvm.view.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.alireza.simplemvvm.view.DetailOneCharacterFragment
import com.alireza.simplemvvm.view.ListFragment


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

    protected open fun replaceFragment(
        @IdRes containerViewId: Int,
        fragment: Fragment,
        fragmentTag: String,
        wantAddToBackStack: Boolean
    ) {
        if (wantAddToBackStack) {
            if (supportFragmentManager.findFragmentByTag(fragmentTag) == null) {
                supportFragmentManager
                    .beginTransaction()
                    .add(containerViewId, fragment, fragmentTag)
                    .commit()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .show(supportFragmentManager.findFragmentByTag(fragmentTag)!!)
                    .commit()
            }
        } else {
            supportFragmentManager
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .commit()

            supportFragmentManager
                .beginTransaction()
                .hide(supportFragmentManager.findFragmentByTag(ListFragment.LIST_FRAGMENT_TAG)!!)
                .commit()
        }
    }

    override fun onBackPressed() {
        val supportFragmentManager = supportFragmentManager

        if (supportFragmentManager.findFragmentByTag(ListFragment.LIST_FRAGMENT_TAG) != null) {
            if (supportFragmentManager
                    .findFragmentByTag(ListFragment.LIST_FRAGMENT_TAG)!!.isHidden
            ) {
                if (supportFragmentManager
                        .findFragmentByTag(DetailOneCharacterFragment.DETAIL_ONE_CHARACTER_FRAGMENT) != null
                ) {
                    if (supportFragmentManager
                            .findFragmentByTag(DetailOneCharacterFragment.DETAIL_ONE_CHARACTER_FRAGMENT)!!.isAdded
                    ) {
                        supportFragmentManager
                            .beginTransaction()
                            .remove(
                                supportFragmentManager.findFragmentByTag(
                                    DetailOneCharacterFragment.DETAIL_ONE_CHARACTER_FRAGMENT
                                )!!
                            )
                            .commit()
                    }
                }
                supportFragmentManager
                    .beginTransaction()
                    .show(
                        supportFragmentManager.findFragmentByTag(
                            ListFragment.LIST_FRAGMENT_TAG
                        )!!
                    )
                    .commit()
            } else if (supportFragmentManager
                    .findFragmentByTag(ListFragment.LIST_FRAGMENT_TAG)!!.isVisible
            ) {
                super.onBackPressed()
            }
        }
    }
}