package com.hustl.app.ui.chat

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.hustl.app.adapters.MessageAdapter
import com.hustl.app.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private val viewModel: ChatViewModel by viewModels()
    private lateinit var messageAdapter: MessageAdapter
    private var chatId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sellerId = intent.getStringExtra("sellerId") ?: run { finish(); return }
        val sellerName = intent.getStringExtra("sellerName") ?: "Seller"
        val gigId = intent.getStringExtra("gigId") ?: ""
        val gigTitle = intent.getStringExtra("gigTitle") ?: ""

        binding.tvSellerName.text = sellerName
        binding.tvGigTitle.text = gigTitle

        val currentUserId = FirebaseAuth.getInstance().currentUser?.uid ?: run { finish(); return }
        val currentUserName = FirebaseAuth.getInstance().currentUser?.displayName ?: "Buyer"

        setupRecycler()

        viewModel.initChat(currentUserId, sellerId, gigId, gigTitle)

        viewModel.chatId.observe(this) { id ->
            chatId = id
            viewModel.loadMessages(id)
        }

        viewModel.messages.observe(this) { messages ->
            messageAdapter.submitList(messages)
            if (messages.isNotEmpty()) {
                binding.rvMessages.scrollToPosition(messages.size - 1)
            }
        }

        binding.btnSend.setOnClickListener {
            val text = binding.etMessage.text.toString().trim()
            if (text.isNotEmpty()) {
                chatId?.let { id ->
                    viewModel.sendMessage(id, currentUserId, currentUserName, text)
                    binding.etMessage.text?.clear()
                }
            }
        }

        binding.ivBack.setOnClickListener { finish() }
    }

    private fun setupRecycler() {
        val currentUserId = FirebaseAuth.getInstance().currentUser?.uid ?: ""
        messageAdapter = MessageAdapter(currentUserId)
        binding.rvMessages.layoutManager = LinearLayoutManager(this).apply {
            stackFromEnd = true
        }
        binding.rvMessages.adapter = messageAdapter
    }
}
