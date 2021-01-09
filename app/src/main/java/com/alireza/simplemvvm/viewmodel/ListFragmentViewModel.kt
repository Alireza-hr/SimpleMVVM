package com.alireza.simplemvvm.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import com.alireza.simplemvvm.model.data.repository.CharacterRepository
import com.alireza.simplemvvm.viewmodel.base.BaseViewModel

class ListFragmentViewModel @ViewModelInject constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {

    val getAllCharacters = repository.getAllCharacters()
}