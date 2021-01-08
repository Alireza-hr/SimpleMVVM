package com.alireza.simplemvvm.adapters

import android.view.View
import com.alireza.simplemvvm.R
import com.alireza.simplemvvm.adapters.base.BaseRecyclerAdapter
import com.alireza.simplemvvm.adapters.base.BaseViewHolder
import com.alireza.simplemvvm.model.data.entities.Character
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.character_list.view.*
import java.lang.StringBuilder

class CharactersListAdapter(
    private val characterItemListener: CharacterItemListener
) : BaseRecyclerAdapter<Character>() {

    interface CharacterItemListener {
        fun onClickedCharacter(characterId: Int, view: View)
    }

    override fun getItemLayoutId() = R.layout.character_list

    override fun onBindViewHolder(holder: BaseViewHolder<Character>, item: Character) {

        holder.itemView.name.text = item.name

        holder.itemView.species_and_status.text =
            StringBuilder().append(item.species).append(item.status)

        Glide.with(holder.itemView.context)
            .load(item.image)
            .transform(CircleCrop())
            .into(holder.itemView.image)
    }

    override fun onItemClicked(position: Int, item: Character, view: View) =
        characterItemListener.onClickedCharacter(item.id, view)

    fun submitItem(items: ArrayList<Character>) {
        addNewItem(items)
    }
}


