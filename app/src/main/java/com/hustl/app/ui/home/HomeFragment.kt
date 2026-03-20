package com.hustl.app.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hustl.app.adapters.CategoryAdapter
import com.hustl.app.adapters.GigAdapter
import com.hustl.app.databinding.FragmentHomeBinding
import com.hustl.app.ui.gigs.GigDetailActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var gigAdapter: GigAdapter

    private val categories = listOf(
        "All", "Design", "Writing", "Programming", "Marketing",
        "Video", "Music", "Business", "Lifestyle"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCategoryRecycler()
        setupGigRecycler()
        setupSearchView()
        setupObservers()
        setupSwipeRefresh()

        viewModel.loadGigs()
    }

    private fun setupCategoryRecycler() {
        val categoryAdapter = CategoryAdapter(categories) { category ->
            if (category == "All") viewModel.loadGigs()
            else viewModel.loadGigsByCategory(category)
        }
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = categoryAdapter
    }

    private fun setupGigRecycler() {
        gigAdapter = GigAdapter { gig ->
            val intent = Intent(requireContext(), GigDetailActivity::class.java)
            intent.putExtra("gigId", gig.gigId)
            startActivity(intent)
        }
        binding.rvGigs.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvGigs.adapter = gigAdapter
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.searchGigs(it) }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    private fun setupObservers() {
        viewModel.gigs.observe(viewLifecycleOwner) { result ->
            result.onSuccess { gigs ->
                gigAdapter.submitList(gigs)
                binding.tvEmpty.visibility = if (gigs.isEmpty()) View.VISIBLE else View.GONE
            }.onFailure {
                Toast.makeText(requireContext(), "Failed to load gigs", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.swipeRefresh.isRefreshing = isLoading
            binding.progressBar.visibility = if (isLoading && !binding.swipeRefresh.isRefreshing) View.VISIBLE else View.GONE
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadGigs()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
