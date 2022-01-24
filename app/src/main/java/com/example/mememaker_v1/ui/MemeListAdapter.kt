package com.example.mememaker_v1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mememaker_v1.databinding.ItemMemeListBinding
import androidx.core.graphics.drawable.DrawableCompat
import com.example.mememaker_v1.util.getRandomColor


//TODO - Implement RecyclerView adapter "MemeListAdapter"


class MemeViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(meme: Meme, clickListener: (meme: Meme) -> Unit) {
    }

    companion object {

        fun from(parent: ViewGroup): MemeViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meme_list, parent, false)
            val binding = ItemMemeListBinding.inflate(LayoutInflater.from(parent.context))
            return MemeViewHolder((view))
        }

    }
}

