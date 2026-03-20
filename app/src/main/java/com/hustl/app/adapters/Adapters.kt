package com.hustl.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hustl.app.R
import com.hustl.app.data.model.Chat
import com.hustl.app.data.model.Message
import com.hustl.app.data.model.Order
import com.hustl.app.data.model.Review
import com.hustl.app.databinding.*
import java.text.SimpleDateFormat
import java.util.*

// ---- ORDER ADAPTER ----
class OrderAdapter(private val onClick: (Order) -> Unit) :
    ListAdapter<Order, OrderAdapter.ViewHolder>(OrderDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    inner class ViewHolder(private val binding: ItemOrderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(order: Order) {
            binding.tvGigTitle.text = order.gigTitle
            binding.tvPrice.text = "$${order.price}"
            binding.tvStatus.text = order.status.replace("_", " ").uppercase()
            binding.tvSellerName.text = "Seller: ${order.sellerName}"
            binding.root.setOnClickListener { onClick(order) }
        }
    }

    class OrderDiff : DiffUtil.ItemCallback<Order>() {
        override fun areItemsTheSame(o: Order, n: Order) = o.orderId == n.orderId
        override fun areContentsTheSame(o: Order, n: Order) = o == n
    }
}

// ---- REVIEW ADAPTER ----
class ReviewAdapter(private val reviews: List<Review>) :
    RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(reviews[position])
    override fun getItemCount() = reviews.size

    inner class ViewHolder(private val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(review: Review) {
            binding.tvBuyerName.text = review.buyerName
            binding.tvComment.text = review.comment
            binding.ratingBar.rating = review.rating
        }
    }
}

// ---- MESSAGE ADAPTER ----
class MessageAdapter(private val currentUserId: String) :
    ListAdapter<Message, MessageAdapter.ViewHolder>(MsgDiff()) {

    private val VIEW_TYPE_SENT = 1
    private val VIEW_TYPE_RECEIVED = 2

    override fun getItemViewType(position: Int) =
        if (getItem(position).senderId == currentUserId) VIEW_TYPE_SENT else VIEW_TYPE_RECEIVED

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == VIEW_TYPE_SENT) {
            ViewHolder(ItemMessageSentBinding.inflate(LayoutInflater.from(parent.context), parent, false), true)
        } else {
            ViewHolder(ItemMessageReceivedBinding.inflate(LayoutInflater.from(parent.context), parent, false), false)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    inner class ViewHolder(private val view: android.view.View, private val isSent: Boolean) :
        RecyclerView.ViewHolder(view) {
        fun bind(message: Message) {
            val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
            val time = sdf.format(Date(message.timestamp))
            if (isSent) {
                val b = ItemMessageSentBinding.bind(view)
                b.tvMessage.text = message.text
                b.tvTime.text = time
            } else {
                val b = ItemMessageReceivedBinding.bind(view)
                b.tvMessage.text = message.text
                b.tvTime.text = time
                b.tvSenderName.text = message.senderName
            }
        }
    }

    class MsgDiff : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(o: Message, n: Message) = o.messageId == n.messageId
        override fun areContentsTheSame(o: Message, n: Message) = o == n
    }
}

// ---- CHAT LIST ADAPTER ----
class ChatListAdapter(private val onClick: (Chat) -> Unit) :
    ListAdapter<Chat, ChatListAdapter.ViewHolder>(ChatDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    inner class ViewHolder(private val binding: ItemChatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            binding.tvGigTitle.text = chat.gigTitle
            binding.tvLastMessage.text = chat.lastMessage
            val sdf = SimpleDateFormat("MMM dd", Locale.getDefault())
            binding.tvTime.text = if (chat.lastMessageTime > 0) sdf.format(Date(chat.lastMessageTime)) else ""
            binding.root.setOnClickListener { onClick(chat) }
        }
    }

    class ChatDiff : DiffUtil.ItemCallback<Chat>() {
        override fun areItemsTheSame(o: Chat, n: Chat) = o.chatId == n.chatId
        override fun areContentsTheSame(o: Chat, n: Chat) = o == n
    }
}
