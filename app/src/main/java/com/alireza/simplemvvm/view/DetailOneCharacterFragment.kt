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
            viewModel.getOneCharacter(it.getInt("id")).observe(viewLifecycleOwner, Observer {data->

                when (data) {
                    is Resource.Loading -> {
                        viewModel.isLoading.set(data.isLoading)
                    }

                    is Resource.Success -> {
                        Log.d("AAACCC",data.data.toString()+ "999 ")
                        viewModel.bindCharacterData.set(data.data)
                    }

                    is Resource.Error -> {
                        toast(data.message!!)
                    }
                }

            })
        }
    }
}