package com.hustl.app.ui.gigs

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.hustl.app.databinding.ActivityCreateGigBinding

class CreateGigActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateGigBinding
    private val viewModel: CreateGigViewModel by viewModels()

    private val categories = listOf(
        "Design", "Writing", "Programming", "Marketing",
        "Video", "Music", "Business", "Lifestyle"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGigBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCategoryDropdown()
        setupObservers()
        setupClickListeners()
    }

    private fun setupCategoryDropdown() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, categories)
        binding.actvCategory.setAdapter(adapter)
    }

    private fun setupObservers() {
        viewModel.loading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.btnCreateGig.isEnabled = !isLoading
        }

        viewModel.createResult.observe(this) { result ->
            result.onSuccess {
                Toast.makeText(this, "Gig created successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }.onFailure { error ->
                Toast.makeText(this, "Failed to create gig: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupClickListeners() {
        binding.ivBack.setOnClickListener { finish() }

        binding.btnCreateGig.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val description = binding.etDescription.text.toString().trim()
            val category = binding.actvCategory.text.toString().trim()
            val priceStr = binding.etPrice.text.toString().trim()
            val deliveryDaysStr = binding.etDeliveryDays.text.toString().trim()

            if (title.isEmpty() || description.isEmpty() || category.isEmpty() ||
                priceStr.isEmpty() || deliveryDaysStr.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val price = priceStr.toDoubleOrNull() ?: run {
                Toast.makeText(this, "Invalid price", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val deliveryDays = deliveryDaysStr.toIntOrNull() ?: run {
                Toast.makeText(this, "Invalid delivery days", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val auth = FirebaseAuth.getInstance()
            val currentUser = auth.currentUser ?: return@setOnClickListener

            viewModel.createGig(
                title = title,
                description = description,
                category = category,
                price = price,
                deliveryDays = deliveryDays,
                sellerId = currentUser.uid,
                sellerName = currentUser.displayName ?: "Seller"
            )
        }
    }
}
