package com.alireza.simplemvvm.view

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.alireza.simplemvvm.R
import com.alireza.simplemvvm.adapters.CharactersListAdapter
import com.alireza.simplemvvm.databinding.FragmentListBinding
import com.alireza.simplemvvm.model.data.remote.base.Resource
import com.alireza.simplemvvm.view.base.BaseFragment
import com.alireza.simplemvvm.viewmodel.ListFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment :
    BaseFragment<ListFragmentViewModel,
            FragmentListBinding>(ListFragmentViewModel::class.java),
    CharactersListAdapter.CharacterItemListener {

    private lateinit var charactersAdapter: CharactersListAdapter

    override fun getLayoutResourceId() = R.layout.fragment_list

    override fun onCreateView(
        savedInstanceState: Bundle?,
        dataBinding: FragmentListBinding,
        viewModel: ListFragmentViewModel
    ) {
        dataBinding.viewModel = viewModel

        setUpRecyclerView(dataBinding)

        viewModel.getAllCharacters.observe(viewLifecycleOwner, Observer {

            when (it) {
                is Resource.Loading -> {
                    viewModel.isLoading.set(it.isLoading)
                }

                is Resource.Success -> {
                    if (it.data != null) {
                        charactersAdapter.submitItem(ArrayList(it.data.results))
                    }
                }

                is Resource.Error -> {
                    toast(it.message!!)
                }
            }
        })
    }

    private fun setUpRecyclerView(dataBinding: FragmentListBinding) {
        charactersAdapter = CharactersListAdapter(this)
        dataBinding.recyclerview.apply {
            layoutManager = GridLayoutManager(requireContext(), 4)
            adapter = charactersAdapter
        }

    }

    override fun onClickedCharacter(characterId: Int) {
        toast(characterId.toString())
    }
}
