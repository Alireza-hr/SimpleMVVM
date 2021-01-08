package com.alireza.simplemvvm.adapters.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private val items: ArrayList<T> = ArrayList<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return BaseViewHolder(parent, getItemLayoutId()) { pos, view ->
            onItemClicked(
                pos, items[pos], view
            )
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        onBindViewHolder(holder, items[position])
    }

    override fun getItemCount(): Int = items.size

    abstract fun onBindViewHolder(holder: BaseViewHolder<T>, item: T)

    abstract fun onItemClicked(position: Int, item: T, view: View)

    protected abstract fun getItemLayoutId(): Int

    protected fun addNewItem(newItem: ArrayList<T>) {
        items.apply {
            clear()
            addAll(newItem)
        }
        notifyDataSetChanged()
    }
}