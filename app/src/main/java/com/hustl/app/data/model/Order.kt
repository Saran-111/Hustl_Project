package com.hustl.app.data.model

data class Order(
    val orderId: String = "",
    val gigId: String = "",
    val gigTitle: String = "",
    val gigImage: String = "",
    val buyerId: String = "",
    val buyerName: String = "",
    val sellerId: String = "",
    val sellerName: String = "",
    val price: Double = 0.0,
    val deliveryDays: Int = 1,
    val status: String = "pending", // pending, in_progress, delivered, completed, cancelled
    val requirements: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val deliveredAt: Long = 0L
)
