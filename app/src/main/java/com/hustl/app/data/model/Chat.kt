package com.hustl.app.data.model

data class Chat(
    val chatId: String = "",
    val participants: List<String> = emptyList(),
    val buyerId: String = "",
    val sellerId: String = "",
    val sellerName: String = "",
    val gigId: String = "",
    val gigTitle: String = "",
    val lastMessage: String = "",
    val lastMessageTime: Long = 0L,
    val unreadCount: Int = 0
)
