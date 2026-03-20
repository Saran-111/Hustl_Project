package com.hustl.app.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.hustl.app.data.model.User
import kotlinx.coroutines.tasks.await

class AuthRepository {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    val currentUser get() = auth.currentUser

    suspend fun login(email: String, password: String): Result<User> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val user = getUserById(result.user!!.uid)
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun register(name: String, email: String, password: String, role: String): Result<User> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val user = User(
                userId = result.user!!.uid,
                name = name,
                email = email,
                role = role
            )
            db.collection("users").document(user.userId).set(user).await()
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUserById(userId: String): User {
        val doc = db.collection("users").document(userId).get().await()
        return doc.toObject(User::class.java) ?: User()
    }

    fun logout() = auth.signOut()

    fun isLoggedIn() = auth.currentUser != null
}
