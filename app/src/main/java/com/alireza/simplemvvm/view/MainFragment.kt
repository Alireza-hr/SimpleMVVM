package com.alireza.simplemvvm.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alireza.simplemvvm.R
import com.alireza.simplemvvm.adapters.INTEREST_PAGE_INDEX
import com.alireza.simplemvvm.adapters.LIST_PAGE_INDEX
import com.alireza.simplemvvm.adapters.SimplePageAdapter
import com.alireza.simplemvvm.databinding.FragmentMainBinding
import com.alireza.simplemvvm.view.base.BaseFragment
import com.alireza.simplemvvm.viewmodel.MainFragmentViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment() :
    BaseFragment<MainFragmentViewModel, FragmentMainBinding>(MainFragmentViewModel::class.java) {

    companion object {
        const val MAIN_FRAGMENT_TAG = "MainFragment"
    }

    override fun getLayoutResourceId() = R.layout.fragment_main

    override fun onCreateView(
        savedInstanceState: Bundle?,
        dataBinding: FragmentMainBinding,
        viewModel: MainFragmentViewModel
    ) {
        dataBinding.viewModel = viewModel

        val tabLayout = dataBinding.tabs
        val viewPager = dataBinding.viewPager

        viewPager.adapter = SimplePageAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcons(position))
            tab.text = getTabTitles(position)
        }.attach()
    }

    private fun getTabIcons(position: Int): Int {
        return when (position) {
            LIST_PAGE_INDEX -> R.drawable.ic_list
            INTEREST_PAGE_INDEX -> R.drawable.ic_interest
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitles(position: Int): String? {
        return when (position) {
            LIST_PAGE_INDEX -> getString(R.string.main_tab_list_text)
            INTEREST_PAGE_INDEX -> getString(R.string.main_tab_interest_text)
            else -> null
        }
    }
}