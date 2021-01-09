package com.alireza.simplemvvm.viewmodel

import androidx.databinding.ObservableField
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.alireza.simplemvvm.model.data.repository.CharacterRepository
import com.alireza.simplemvvm.view.base.BaseViewModel

class ListFragmentViewModel @ViewModelInject constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {

    val getAllCharacters = repository.getAllCharacters()
}