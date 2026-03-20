package com.hustl.app.ui.orders

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.hustl.app.databinding.ActivityPlaceOrderBinding

class PlaceOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaceOrderBinding
    private val viewModel: OrderViewModel by viewModels()
    private lateinit var gigId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gigId = intent.getStringExtra("gigId") ?: run { finish(); return }

        setupObservers()
        viewModel.loadGig(gigId)

        binding.ivBack.setOnClickListener { finish() }
        binding.btnPlaceOrder.setOnClickListener { placeOrder() }
    }

    private fun setupObservers() {
        viewModel.gig.observe(this) { gig ->
            binding.tvGigTitle.text = gig.title
            binding.tvPrice.text = "$${gig.price}"
            binding.tvDelivery.text = "Delivery: ${gig.deliveryDays} day(s)"
        }

        viewModel.loading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.btnPlaceOrder.isEnabled = !isLoading
        }

        viewModel.orderResult.observe(this) { result ->
            result.onSuccess {
                Toast.makeText(this, "Order placed successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }.onFailure { error ->
                Toast.makeText(this, "Failed to place order: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun placeOrder() {
        val requirements = binding.etRequirements.text.toString().trim()
        if (requirements.isEmpty()) {
            Toast.makeText(this, "Please describe your requirements", Toast.LENGTH_SHORT).show()
            return
        }

        val currentUser = FirebaseAuth.getInstance().currentUser ?: return
        viewModel.placeOrder(gigId, currentUser.uid, currentUser.displayName ?: "Buyer", requirements)
    }
}
