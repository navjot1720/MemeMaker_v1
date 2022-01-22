package com.example.mememaker_v1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.mememaker_v1.viewmodel.MemeViewModel
import com.example.mememaker_v1.R
import com.example.mememaker_v1.databinding.FragmentLayoutDetailBinding

class MemeDetailFragment: Fragment(R.layout.fragment_layout_detail) {

    val viewModel: MemeViewModel by activityViewModels<MemeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLayoutDetailBinding.inflate(inflater, container, false)

        val memeId = requireArguments().getInt("meme_Id")

        val selectedMeme = viewModel.getMeme(memeId)

        if (selectedMeme != null) {
            Glide.with(binding.ivMemeImage.context)
                .load(selectedMeme.image)
                .centerCrop()
                .into(binding.ivMemeImage)

            binding.tvTop.text = selectedMeme.topText ?: "".trim()
            binding.tvBottom.text = selectedMeme.bottomText ?: "".trim()
        }

        return binding.root
    }

}