package com.alireza.simplemvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alireza.simplemvvm.R
import com.alireza.simplemvvm.databinding.FragmentListBinding
import com.alireza.simplemvvm.view.base.BaseFragment
import com.alireza.simplemvvm.viewmodel.ListFragmentViewModel

class ListFragment :
    BaseFragment<ListFragmentViewModel , FragmentListBinding>(ListFragmentViewModel::class.java) {

    override fun getLayoutResourceId() = R.layout.fragment_list

    override fun onCreateView(
        savedInstanceState: Bundle?,
        dataBinding: FragmentListBinding,
        viewModel: ListFragmentViewModel
    ) {
    }

}
