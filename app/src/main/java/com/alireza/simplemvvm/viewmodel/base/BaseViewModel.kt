package com.alireza.simplemvvm.viewmodel.base

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    var isLoading = ObservableField<Boolean>(false)
}