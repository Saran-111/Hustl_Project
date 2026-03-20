package com.hustl.app.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.hustl.app.data.model.Chat
import com.hustl.app.data.model.Message
import kotlinx.coroutines.tasks.await

class ChatRepository {
    private val db = FirebaseFirestore.getInstance()
    private val chatsRef = db.collection("chats")

    suspend fun getOrCreateChat(buyerId: String, sellerId: String, gigId: String, gigTitle: String): Result<String> {
        return try {
            val snapshot = chatsRef
                .whereArrayContains("participants", buyerId)
                .whereEqualTo("gigId", gigId)
                .get().await()

            val existing = snapshot.documents.firstOrNull {
                val participants = it.get("participants") as? List<*>
                participants?.contains(sellerId) == true
            }

            if (existing != null) {
                Result.success(existing.id)
            } else {
                val docRef = chatsRef.document()
                val chat = Chat(
                    chatId = docRef.id,
                    participants = listOf(buyerId, sellerId),
                    gigId = gigId,
                    gigTitle = gigTitle
                )
                docRef.set(chat).await()
                Result.success(docRef.id)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getChatsForUser(userId: String): Result<List<Chat>> {
        return try {
            val snapshot = chatsRef
                .whereArrayContains("participants", userId)
                .orderBy("lastMessageTime", Query.Direction.DESCENDING)
                .get().await()
            Result.success(snapshot.toObjects(Chat::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun listenToMessages(chatId: String, onMessages: (List<Message>) -> Unit) {
        chatsRef.document(chatId).collection("messages")
            .orderBy("timestamp", Query.Direction.ASCENDING)
            .addSnapshotListener { snapshot, _ ->
                snapshot?.let {
                    onMessages(it.toObjects(Message::class.java))
                }
            }
    }

    suspend fun sendMessage(chatId: String, message: Message): Result<Unit> {
        return try {
            val msgRef = chatsRef.document(chatId).collection("messages").document()
            val newMsg = message.copy(messageId = msgRef.id)
            msgRef.set(newMsg).await()

            // Update last message in chat
            chatsRef.document(chatId).update(
                mapOf(
                    "lastMessage" to message.text,
                    "lastMessageTime" to message.timestamp
                )
            ).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
