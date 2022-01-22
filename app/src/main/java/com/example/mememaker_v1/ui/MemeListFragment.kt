package com.example.mememaker_v1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mememaker_v1.Meme
import com.example.mememaker_v1.MemeListAdapter
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

        val listAdapter = MemeListAdapter(mutableListOf(), ::onMemeClicked)
        val layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvMemeList.layoutManager = layoutManager
        binding.rvMemeList.addItemDecoration(SpaceItemDecoration(16))

        binding.rvMemeList.adapter = listAdapter


        binding.btnRefreshMemes.setOnClickListener {
            viewModel.refreshMemesList()
        }

        viewModel.memeList.observe(viewLifecycleOwner, { list ->
            listAdapter.data.clear()
            listAdapter.data.addAll(list)
            listAdapter.notifyDataSetChanged()
        })

        viewModel.refreshBtnClicked.observe(viewLifecycleOwner, { clicked ->
            if (clicked) {
                viewModel.fetchMemes()
                viewModel.refreshEventDone()
            }
        })
    }

    private fun onMemeClicked(meme: Meme) {
        val bundle = bundleOf("meme_Id" to meme.ID)
        requireActivity().supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .addToBackStack("meme_detail")
            .add(R.id.fragment_container_view, MemeDetailFragment::class.java, bundle)
            .commit()
    }
}