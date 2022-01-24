package com.example.mememaker_v1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mememaker_v1.Meme
import com.example.mememaker_v1.viewmodel.MemeViewModel
import com.example.mememaker_v1.R
import com.example.mememaker_v1.databinding.FragmentMemeListBinding

class MemeListFragment: Fragment() {

    private lateinit var binding : FragmentMemeListBinding
    private val viewModel: MemeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMemeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvMemeList.addItemDecoration(SpaceItemDecoration(16))


        binding.btnRefreshMemes.setOnClickListener {
            viewModel.refreshMemesList()
        }

        viewModel.memeList.observe(viewLifecycleOwner, { list ->
            //TODO - populate meme list
        })

        viewModel.refreshBtnClicked.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), "fetching new memes", Toast.LENGTH_SHORT).show()
            viewModel.fetchMemes()
        })
    }

    private fun onMemeClicked(meme: Meme) {
        //TODO - Navigate to MemeDetailsFragment class with selected meme id
        requireActivity().supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragment_container_view, MemeDetailFragment::class.java, null)
            .commit()
    }
}