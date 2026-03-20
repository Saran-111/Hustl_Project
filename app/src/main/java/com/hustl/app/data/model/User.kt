package com.hustl.app.data.model

data class User(
    val userId: String = "",
    val name: String = "",
    val email: String = "",
    val role: String = "buyer", // "buyer" or "seller"
    val profileImage: String = "",
    val bio: String = "",
    val skills: List<String> = emptyList(),
    val rating: Float = 0f,
    val totalReviews: Int = 0,
    val createdAt: Long = System.currentTimeMillis()
)
