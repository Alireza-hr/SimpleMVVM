package com.alireza.simplemvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alireza.simplemvvm.R
import com.alireza.simplemvvm.databinding.FragmentInterestBinding
import com.alireza.simplemvvm.view.base.BaseFragment
import com.alireza.simplemvvm.viewmodel.InterestViewModel


class InterestFragment :
    BaseFragment<InterestViewModel,FragmentInterestBinding>(InterestViewModel::class.java) {

    override fun getLayoutResourceId() = R.layout.fragment_interest

    override fun onCreateView(
        savedInstanceState: Bundle?,
        dataBinding: FragmentInterestBinding,
        viewModel: InterestViewModel
    ) {
    }

}