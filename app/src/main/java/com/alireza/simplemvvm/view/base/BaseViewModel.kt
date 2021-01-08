package com.alireza.simplemvvm.view.base

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    var isLoading = ObservableField<Boolean>()
}