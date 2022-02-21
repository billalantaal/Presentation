package com.example.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.databinding.ArticleListFragmentBinding
import com.example.presentation.ui.adapter.CustomAdapter
import com.example.presentation.ui.network.ApiResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ArticleListFragment : Fragment() {

    companion object {
        fun newInstance() = ArticleListFragment()
    }

    private lateinit var viewModel: ArticleListViewModel
    private var _binding: ArticleListFragmentBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ArticleListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CustomAdapter()
        _binding?.recyclerView?.layoutManager =
            LinearLayoutManager(requireContext())
        _binding?.recyclerView?.adapter = adapter
        adapter.onItemClick =  { result ->
            val action =  ArticleListFragmentDirections.actionArticleListFragmentToArticleDetailFragment(
                result
            )
            binding.root.findNavController().navigate(action)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ArticleListViewModel::class.java]
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.getArticles("viewed", "7.json", "nF6RhjZaBvc3OXfGjuV6AeDTFJS3zZti")
                    .collect {
                        when (it) {
                            is ApiResponse.ApiFailure -> {
                                it.message
                            }
                            is ApiResponse.ApiSuccess -> {
                                it.data?.networkResults?.let { data ->
                                    adapter.setData(data)
                                }
                            }
                        }
                    }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }

}