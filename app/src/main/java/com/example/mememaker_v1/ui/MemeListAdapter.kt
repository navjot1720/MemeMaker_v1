package com.example.mememaker_v1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//TODO - Implement RecyclerView adapter "MemeListAdapter"



class MemeViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {

    companion object {

        fun from(parent: ViewGroup): MemeViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meme_list, parent, false)
            return MemeViewHolder((view))
        }
    }
}

