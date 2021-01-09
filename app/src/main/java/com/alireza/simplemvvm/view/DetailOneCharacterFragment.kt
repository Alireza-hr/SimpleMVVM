package com.alireza.simplemvvm.view

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.alireza.simplemvvm.R
import com.alireza.simplemvvm.databinding.FragmentDetailOneCharacterBinding
import com.alireza.simplemvvm.model.data.remote.base.Resource
import com.alireza.simplemvvm.view.base.BaseFragment
import com.alireza.simplemvvm.viewmodel.DetailOneCharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailOneCharacterFragment
    : BaseFragment<DetailOneCharacterViewModel,
        FragmentDetailOneCharacterBinding>
    (DetailOneCharacterViewModel::class.java) {

    companion object {
        const val DETAIL_ONE_CHARACTER_FRAGMENT = "DetailOneCharacterFragment"
    }

    override fun getLayoutResourceId() = R.layout.fragment_detail_one_character

    override fun onCreateView(
        savedInstanceState: Bundle?,
        dataBinding: FragmentDetailOneCharacterBinding,
        viewModel: DetailOneCharacterViewModel
    ) {
        dataBinding.viewModel = viewModel

        viewModel.onBackClicked.observe(viewLifecycleOwner, Observer {
            ((activity as MainActivity)).onBackPressed()
        })

        arguments?.let { it ->
            viewModel.getOneCharacter(it.getInt("id")).observe(viewLifecycleOwner, Observer {

                when (it.status) {
                    Resource.Status.LOADING -> {
                        viewModel.isLoading.set(!viewModel.isLoading.get()!!)
                    }
                    Resource.Status.SUCCESS -> {
                        if (it.data != null) {
                            viewModel.bindCharacterData.set(it.data)
                        }
                    }
                    Resource.Status.ERROR -> {
                        toast(it.message!!)
                    }
                }
            })
        }
    }
}