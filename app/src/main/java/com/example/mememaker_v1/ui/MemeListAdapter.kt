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


class MemeListAdapter(var data: MutableList<Meme>, val clickListener: (meme: Meme) -> Unit): RecyclerView.Adapter<MemeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        return   MemeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        holder.bind(data[position], clickListener)
    }

    override fun getItemCount() = data.size


}

class MemeViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(meme: Meme, clickListener: (meme: Meme) -> Unit) {

        val unwrappedDrawable = itemView.background
        val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable)
        DrawableCompat.setTint(wrappedDrawable, getRandomColor())

        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val thumbnail = itemView.findViewById<ImageView>(R.id.iv_thumbnail)
        name.text = meme.name.trim()
        Glide.with(thumbnail)
            .load(meme.image)
            .centerCrop()
            .thumbnail(0.05f)
            .into(thumbnail)

        itemView.setOnClickListener {
            clickListener.invoke(meme)
        }

    }

    companion object {

        fun from(parent: ViewGroup): MemeViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meme_list, parent, false)
            val binding = ItemMemeListBinding.inflate(LayoutInflater.from(parent.context))
            return MemeViewHolder((view))
        }

    }
}

