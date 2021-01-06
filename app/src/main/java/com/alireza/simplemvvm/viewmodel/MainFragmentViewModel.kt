package com.alireza.simplemvvm.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.alireza.simplemvvm.view.base.BaseViewModel

class MainFragmentViewModel : BaseViewModel() {
    val text = ObservableField<String>()
    init {
        text.set("alireza")
    }
}