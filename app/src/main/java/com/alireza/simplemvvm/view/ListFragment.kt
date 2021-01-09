package com.alireza.simplemvvm.view

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
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

            when (it.status) {
                Resource.Status.LOADING -> {
                    viewModel.isLoading.set(!viewModel.isLoading.get()!!)
                }
                Resource.Status.SUCCESS -> {
                    if (it.data != null) {
                        charactersAdapter.submitItem(it.data)
                    }
                }
                Resource.Status.ERROR -> {
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

    override fun onClickedCharacter(characterId: Int, view: View) {

        toast(characterId.toString())

        val detailCharacter = DetailOneCharacterFragment()
        detailCharacter.arguments = bundleOf("id" to characterId)

        ((activity as MainActivity)).replaceFragment(
            detailCharacter,
            DetailOneCharacterFragment.DETAIL_ONE_CHARACTER_FRAGMENT,
            false
        )
    }
}
