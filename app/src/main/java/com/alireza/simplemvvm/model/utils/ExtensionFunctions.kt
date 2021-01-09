package com.alireza.simplemvvm.model.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.alireza.simplemvvm.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.character_list.view.*


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

        @BindingAdapter("android:setVisibilityContain")
        @JvmStatic
        fun setVisibilityContain(view: View, value: Boolean) {
            view.visibility = if (value) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }

        @BindingAdapter("android:setText")
        @JvmStatic
        fun setText(textView: TextView, text: String?) {


            if (text.isNullOrEmpty()) {
                textView.text = textView.context.getString(R.string.unknown_text)
            } else {
                textView.text = text
            }
        }

        @BindingAdapter("android:imageUrl")
        @JvmStatic
        fun imageUrl(view: ImageView, addressLink: String?) {
            Glide.with(view.context)
                .load(addressLink)
                .transform(CircleCrop())
                .into(view)
        }
    }
}