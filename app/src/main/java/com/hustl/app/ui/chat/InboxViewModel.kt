package com.hustl.app.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hustl.app.data.model.Chat
import com.hustl.app.data.repository.ChatRepository
import kotlinx.coroutines.launch

class InboxViewModel : ViewModel() {
    private val repository = ChatRepository()

    private val _chats = MutableLiveData<List<Chat>>()
    val chats: LiveData<List<Chat>> = _chats

    fun loadChats(userId: String) {
        viewModelScope.launch {
            repository.getChatsForUser(userId).onSuccess { _chats.value = it }
        }
    }
}
