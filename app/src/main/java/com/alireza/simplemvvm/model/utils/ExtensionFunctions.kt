package com.alireza.simplemvvm.model.utils

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter


class ExtensionFunctions {

    companion object {
        @BindingAdapter("android:setVisibilityProgress")
        @JvmStatic
        fun setVisibilityProgress(view: View, value: Boolean) {
            view.visibility = if (value) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        @BindingAdapter("android:setVisibilityRecyclerView")
        @JvmStatic
        fun setVisibilityRecyclerView(view: View, value: Boolean) {
            view.visibility = if (value) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }
    }
}