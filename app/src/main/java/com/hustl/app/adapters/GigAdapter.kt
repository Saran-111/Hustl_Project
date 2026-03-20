package com.hustl.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hustl.app.R
import com.hustl.app.data.model.Gig
import com.hustl.app.databinding.ItemGigBinding

class GigAdapter(private val onClick: (Gig) -> Unit) :
    ListAdapter<Gig, GigAdapter.GigViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GigViewHolder {
        val binding = ItemGigBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GigViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GigViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class GigViewHolder(private val binding: ItemGigBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(gig: Gig) {
            binding.tvTitle.text = gig.title
            binding.tvSellerName.text = gig.sellerName
            binding.tvPrice.text = "From $${gig.price}"
            binding.ratingBar.rating = gig.rating
            binding.tvRating.text = "(${gig.totalReviews})"

            if (gig.images.isNotEmpty()) {
                Glide.with(binding.root.context)
                    .load(gig.images[0])
                    .placeholder(R.drawable.ic_placeholder)
                    .centerCrop()
                    .into(binding.ivGigImage)
            } else {
                binding.ivGigImage.setImageResource(R.drawable.ic_placeholder)
            }

            binding.root.setOnClickListener { onClick(gig) }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Gig>() {
        override fun areItemsTheSame(oldItem: Gig, newItem: Gig) = oldItem.gigId == newItem.gigId
        override fun areContentsTheSame(oldItem: Gig, newItem: Gig) = oldItem == newItem
    }
}
