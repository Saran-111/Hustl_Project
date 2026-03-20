package com.hustl.app.ui.gigs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.hustl.app.R
import com.hustl.app.adapters.ReviewAdapter
import com.hustl.app.databinding.ActivityGigDetailBinding
import com.hustl.app.ui.chat.ChatActivity
import com.hustl.app.ui.orders.PlaceOrderActivity

class GigDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGigDetailBinding
    private val viewModel: GigDetailViewModel by viewModels()
    private lateinit var gigId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGigDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gigId = intent.getStringExtra("gigId") ?: run { finish(); return }

        setupObservers()
        viewModel.loadGig(gigId)

        binding.ivBack.setOnClickListener { finish() }
    }

    private fun setupObservers() {
        viewModel.gig.observe(this) { result ->
            result.onSuccess { gig ->
                binding.tvTitle.text = gig.title
                binding.tvDescription.text = gig.description
                binding.tvPrice.text = "From $${gig.price}"
                binding.tvDelivery.text = "Delivery in ${gig.deliveryDays} day(s)"
                binding.tvSellerName.text = gig.sellerName
                binding.tvCategory.text = gig.category
                binding.ratingBar.rating = gig.rating
                binding.tvRating.text = "${gig.rating} (${gig.totalReviews} reviews)"

                if (gig.images.isNotEmpty()) {
                    Glide.with(this)
                        .load(gig.images[0])
                        .placeholder(R.drawable.ic_placeholder)
                        .into(binding.ivGigImage)
                }

                val currentUserId = FirebaseAuth.getInstance().currentUser?.uid
                val isOwner = currentUserId == gig.sellerId

                if (isOwner) {
                    binding.btnOrderNow.visibility = View.GONE
                    binding.btnContactSeller.text = "Edit Gig"
                    binding.btnContactSeller.setOnClickListener {
                        val intent = Intent(this, CreateGigActivity::class.java)
                        intent.putExtra("gigId", gigId)
                        startActivity(intent)
                    }
                } else {
                    binding.btnOrderNow.setOnClickListener {
                        val intent = Intent(this, PlaceOrderActivity::class.java)
                        intent.putExtra("gigId", gigId)
                        startActivity(intent)
                    }

                    binding.btnContactSeller.setOnClickListener {
                        val intent = Intent(this, ChatActivity::class.java)
                        intent.putExtra("sellerId", gig.sellerId)
                        intent.putExtra("sellerName", gig.sellerName)
                        intent.putExtra("gigId", gigId)
                        intent.putExtra("gigTitle", gig.title)
                        startActivity(intent)
                    }
                }
            }.onFailure {
                Toast.makeText(this, "Failed to load gig", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        viewModel.reviews.observe(this) { reviews ->
            val adapter = ReviewAdapter(reviews)
            binding.rvReviews.layoutManager = LinearLayoutManager(this)
            binding.rvReviews.adapter = adapter
        }
    }
}
