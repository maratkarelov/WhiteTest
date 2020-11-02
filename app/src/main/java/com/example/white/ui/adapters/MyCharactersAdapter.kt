package com.example.white.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.white.R
import com.example.white.core.ItemClickCallback
import com.example.white.data.entities.MyCharacter
import kotlinx.android.synthetic.main.item_character.view.*

class MyCharactersAdapter(
    private val itemClickCallback: ItemClickCallback<MyCharacter>
    ) :
    RecyclerView.Adapter<MyCharactersAdapter.ViewHolder>() {
    private val items: MutableList<MyCharacter> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_character,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myCharacter = items[position]
        Glide.with(holder.itemView.context).load(myCharacter.img).centerCrop().into(holder.iv_avatar)
        holder.tv_name.text = myCharacter.name
        holder.tv_id.text = myCharacter.char_id.toString()
        holder.itemView.setOnClickListener {
            itemClickCallback.OnItemClick(
                myCharacter,
                holder.adapterPosition
            )
        }
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val iv_avatar: ImageView = itemView.iv_avatar
        val tv_name: TextView = itemView.tv_name
        val tv_id: TextView = itemView.tv_id
    }

    fun addItems(list: List<MyCharacter>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }


}
