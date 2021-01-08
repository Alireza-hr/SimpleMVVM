package com.alireza.simplemvvm.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
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


    override fun getLayoutResourceId() = R.layout.fragment_detail_one_character

    override fun onCreateView(
        savedInstanceState: Bundle?,
        dataBinding: FragmentDetailOneCharacterBinding,
        viewModel: DetailOneCharacterViewModel
    ) {
        dataBinding.viewModel = viewModel

        viewModel.onBackClicked.observe(viewLifecycleOwner, Observer {
            it.findNavController().navigateUp()
        })

        arguments?.let {
            viewModel.getOneCharacter(it.getInt("id")).observe(viewLifecycleOwner, Observer {

                when (it) {
                    is Resource.Loading -> {
                        viewModel.isLoading.set(it.isLoading)
                    }

                    is Resource.Success -> {
                        viewModel.bindCharacterData.set(it.data)
                    }

                    is Resource.Error -> {
                        toast(it.message!!)
                    }
                }

            })
        }
    }
}