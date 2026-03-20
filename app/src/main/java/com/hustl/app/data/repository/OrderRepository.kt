package com.hustl.app.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.hustl.app.data.model.Order
import com.hustl.app.data.model.Review
import kotlinx.coroutines.tasks.await

class OrderRepository {
    private val db = FirebaseFirestore.getInstance()
    private val ordersRef = db.collection("orders")

    suspend fun createOrder(order: Order): Result<String> {
        return try {
            val docRef = ordersRef.document()
            val newOrder = order.copy(orderId = docRef.id)
            docRef.set(newOrder).await()
            Result.success(docRef.id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getOrdersForBuyer(buyerId: String): Result<List<Order>> {
        return try {
            val snapshot = ordersRef
                .whereEqualTo("buyerId", buyerId)
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .get().await()
            Result.success(snapshot.toObjects(Order::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getOrdersForSeller(sellerId: String): Result<List<Order>> {
        return try {
            val snapshot = ordersRef
                .whereEqualTo("sellerId", sellerId)
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .get().await()
            Result.success(snapshot.toObjects(Order::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateOrderStatus(orderId: String, status: String): Result<Unit> {
        return try {
            ordersRef.document(orderId).update("status", status).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun submitReview(review: Review): Result<Unit> {
        return try {
            val docRef = db.collection("reviews").document()
            val newReview = review.copy(reviewId = docRef.id)
            docRef.set(newReview).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getOrderById(orderId: String): Result<Order> {
        return try {
            val doc = ordersRef.document(orderId).get().await()
            val order = doc.toObject(Order::class.java)
            if (order != null) Result.success(order) else Result.failure(Exception("Order not found"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
