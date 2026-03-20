package com.hustl.app.ui.chat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.hustl.app.adapters.ChatListAdapter
import com.hustl.app.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {

    private var _binding: FragmentInboxBinding? = null
    private val binding get() = _binding!!
    private val viewModel: InboxViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentInboxBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ChatListAdapter { chat ->
            val intent = Intent(requireContext(), ChatActivity::class.java)
            intent.putExtra("chatId", chat.chatId)
            intent.putExtra("gigTitle", chat.gigTitle)
            startActivity(intent)
        }

        binding.rvChats.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChats.adapter = adapter

        viewModel.chats.observe(viewLifecycleOwner) { chats ->
            adapter.submitList(chats)
            binding.tvEmpty.visibility = if (chats.isEmpty()) View.VISIBLE else View.GONE
        }

        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return
        viewModel.loadChats(userId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
