package com.alireza.simplemvvm.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alireza.simplemvvm.view.InterestFragment
import com.alireza.simplemvvm.view.ListFragment

const val INTEREST_PAGE_INDEX = 1
const val LIST_PAGE_INDEX = 0

class SimplePageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        LIST_PAGE_INDEX to { ListFragment() },
        INTEREST_PAGE_INDEX to { InterestFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}