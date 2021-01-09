package com.alireza.simplemvvm.viewmodel

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alireza.simplemvvm.model.data.entities.Character
import com.alireza.simplemvvm.model.data.repository.CharacterRepository
import com.alireza.simplemvvm.view.base.BaseViewModel

class DetailOneCharacterViewModel @ViewModelInject constructor(
    private val repository: CharacterRepository,
    @Assisted private val savedState: SavedStateHandle
) : BaseViewModel() {

    val onBackClicked = MutableLiveData<View>()

    fun getOneCharacter(id: Int) =
        repository.getOneCharacter(id)

    val bindCharacterData = ObservableField<Character>()

    fun onBackClicked(view: View) {
        onBackClicked.postValue(view)
    }
}