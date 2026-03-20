package com.hustl.app.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hustl.app.data.model.Message
import com.hustl.app.data.repository.ChatRepository
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val repository = ChatRepository()

    private val _chatId = MutableLiveData<String>()
    val chatId: LiveData<String> = _chatId

    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> = _messages

    fun initChat(buyerId: String, sellerId: String, gigId: String, gigTitle: String) {
        viewModelScope.launch {
            repository.getOrCreateChat(buyerId, sellerId, gigId, gigTitle).onSuccess {
                _chatId.value = it
            }
        }
    }

    fun loadMessages(chatId: String) {
        repository.listenToMessages(chatId) { messages ->
            _messages.postValue(messages)
        }
    }

    fun sendMessage(chatId: String, senderId: String, senderName: String, text: String) {
        viewModelScope.launch {
            val message = Message(
                chatId = chatId,
                senderId = senderId,
                senderName = senderName,
                text = text
            )
            repository.sendMessage(chatId, message)
        }
    }
}
