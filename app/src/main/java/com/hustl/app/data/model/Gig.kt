package com.hustl.app.data.model

data class Gig(
    val gigId: String = "",
    val sellerId: String = "",
    val sellerName: String = "",
    val sellerImage: String = "",
    val title: String = "",
    val description: String = "",
    val category: String = "",
    val price: Double = 0.0,
    val deliveryDays: Int = 1,
    val images: List<String> = emptyList(),
    val rating: Float = 0f,
    val totalReviews: Int = 0,
    val tags: List<String> = emptyList(),
    val isActive: Boolean = true,
    val createdAt: Long = System.currentTimeMillis()
)
