package com.hustl.app.ui.orders

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.hustl.app.adapters.OrderAdapter
import com.hustl.app.databinding.FragmentOrdersBinding

class OrdersFragment : Fragment() {

    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: OrderViewModel by viewModels()
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
        setupObservers()
        loadOrders()
    }

    private fun setupRecycler() {
        orderAdapter = OrderAdapter { order ->
            val intent = Intent(requireContext(), OrderDetailActivity::class.java)
            intent.putExtra("orderId", order.orderId)
            startActivity(intent)
        }
        binding.rvOrders.layoutManager = LinearLayoutManager(requireContext())
        binding.rvOrders.adapter = orderAdapter
    }

    private fun setupObservers() {
        viewModel.orders.observe(viewLifecycleOwner) { orders ->
            orderAdapter.submitList(orders)
            binding.tvEmpty.visibility = if (orders.isEmpty()) View.VISIBLE else View.GONE
        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }

    private fun loadOrders() {
        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return
        viewModel.loadBuyerOrders(userId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
