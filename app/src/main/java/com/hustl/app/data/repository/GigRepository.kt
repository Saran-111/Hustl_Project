package com.hustl.app.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.hustl.app.data.model.Gig
import com.hustl.app.data.model.Review
import kotlinx.coroutines.tasks.await

class GigRepository {
    private val db = FirebaseFirestore.getInstance()
    private val gigsRef = db.collection("gigs")

    suspend fun getAllGigs(): Result<List<Gig>> {
        return try {
            val snapshot = gigsRef
                .whereEqualTo("isActive", true)
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .get().await()
            val gigs = snapshot.toObjects(Gig::class.java)
            Result.success(gigs)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getGigsByCategory(category: String): Result<List<Gig>> {
        return try {
            val snapshot = gigsRef
                .whereEqualTo("category", category)
                .whereEqualTo("isActive", true)
                .get().await()
            Result.success(snapshot.toObjects(Gig::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getGigsBySeller(sellerId: String): Result<List<Gig>> {
        return try {
            val snapshot = gigsRef.whereEqualTo("sellerId", sellerId).get().await()
            Result.success(snapshot.toObjects(Gig::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getGigById(gigId: String): Result<Gig> {
        return try {
            val doc = gigsRef.document(gigId).get().await()
            val gig = doc.toObject(Gig::class.java)
            if (gig != null) Result.success(gig) else Result.failure(Exception("Gig not found"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun createGig(gig: Gig): Result<String> {
        return try {
            val docRef = gigsRef.document()
            val newGig = gig.copy(gigId = docRef.id)
            docRef.set(newGig).await()
            Result.success(docRef.id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateGig(gig: Gig): Result<Unit> {
        return try {
            gigsRef.document(gig.gigId).set(gig).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteGig(gigId: String): Result<Unit> {
        return try {
            gigsRef.document(gigId).update("isActive", false).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun searchGigs(query: String): Result<List<Gig>> {
        return try {
            val snapshot = gigsRef.get().await()
            val gigs = snapshot.toObjects(Gig::class.java).filter { gig ->
                gig.title.contains(query, ignoreCase = true) ||
                        gig.description.contains(query, ignoreCase = true) ||
                        gig.category.contains(query, ignoreCase = true)
            }
            Result.success(gigs)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getReviewsForGig(gigId: String): Result<List<Review>> {
        return try {
            val snapshot = db.collection("reviews")
                .whereEqualTo("gigId", gigId)
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .get().await()
            Result.success(snapshot.toObjects(Review::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
