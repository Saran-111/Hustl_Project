package com.hustl.app.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.hustl.app.R
import com.hustl.app.databinding.FragmentProfileBinding
import com.hustl.app.ui.auth.LoginActivity
import com.hustl.app.ui.gigs.CreateGigActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return

        viewModel.user.observe(viewLifecycleOwner) { user ->
            binding.tvName.text = user.name
            binding.tvEmail.text = user.email
            binding.tvBio.text = user.bio.ifEmpty { "No bio yet" }
            binding.tvRole.text = if (user.role == "seller") "⭐ Seller" else "🛒 Buyer"
            binding.ratingBar.rating = user.rating
            binding.tvRating.text = "${user.rating} (${user.totalReviews} reviews)"

            if (user.profileImage.isNotEmpty()) {
                Glide.with(this)
                    .load(user.profileImage)
                    .placeholder(R.drawable.ic_profile_placeholder)
                    .into(binding.ivProfile)
            }

            // Show "Create Gig" button only for sellers
            binding.btnCreateGig.visibility = if (user.role == "seller") View.VISIBLE else View.GONE
        }

        viewModel.loadUser(userId)

        binding.btnCreateGig.setOnClickListener {
            startActivity(Intent(requireContext(), CreateGigActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(requireContext(), LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
