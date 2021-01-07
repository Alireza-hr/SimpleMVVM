package com.alireza.simplemvvm.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.alireza.simplemvvm.R
import com.alireza.simplemvvm.databinding.FragmentListBinding
import com.alireza.simplemvvm.model.data.remote.base.Resource
import com.alireza.simplemvvm.view.base.BaseFragment
import com.alireza.simplemvvm.viewmodel.ListFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment :
    BaseFragment<ListFragmentViewModel,
            FragmentListBinding>(ListFragmentViewModel::class.java) {

    override fun getLayoutResourceId() = R.layout.fragment_list

    override fun onCreateView(
        savedInstanceState: Bundle?,
        dataBinding: FragmentListBinding,
        viewModel: ListFragmentViewModel
    ) {
        dataBinding.viewModel = viewModel

        viewModel.getAllCharacters.observe(viewLifecycleOwner, Observer {

            when (it) {
                is Resource.Loading -> {
                    viewModel.isLoading.set(true)
                    Log.d("TAG_LIST_FRAGMET", "2")

                }

                is Resource.Success -> {
                    viewModel.isLoading.set(false)
                    Log.d("TAG_LIST_FRAGMET", "1")
                }

                is Resource.Error -> {
                    viewModel.isLoading.set(false)
                    Log.d("TAG_LIST_FRAGMET", "3")

                    toast(it.message!!)
                }
            }
        })
    }
}
