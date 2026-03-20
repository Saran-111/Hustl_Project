package com.hustl.app.data.model

data class Review(
    val reviewId: String = "",
    val gigId: String = "",
    val orderId: String = "",
    val buyerId: String = "",
    val buyerName: String = "",
    val buyerImage: String = "",
    val rating: Float = 0f,
    val comment: String = "",
    val createdAt: Long = System.currentTimeMillis()
)
