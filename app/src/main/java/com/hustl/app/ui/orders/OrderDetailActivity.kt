package com.hustl.app.ui.orders

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hustl.app.databinding.ActivityOrderDetailBinding

class OrderDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderDetailBinding
    private val viewModel: OrderViewModel by viewModels()
    private lateinit var orderId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        orderId = intent.getStringExtra("orderId") ?: run { finish(); return }

        setupObservers()
        viewModel.loadOrder(orderId)

        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    private fun setupObservers() {
        viewModel.order.observe(this) { order ->
            binding.tvGigTitle.text = order.gigTitle
            binding.tvOrderId.text = "Order ID: ${order.orderId}"
            binding.tvRequirements.text = order.requirements
            binding.tvStatus.text = order.status.uppercase()
        }

        viewModel.loading.observe(this) { isLoading ->
            // Handle loading
        }
    }
}
