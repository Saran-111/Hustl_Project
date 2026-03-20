package com.hustl.app.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hustl.app.data.model.User
import com.hustl.app.data.repository.AuthRepository
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val repository = AuthRepository()

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun loadUser(userId: String) {
        viewModelScope.launch {
            _user.value = repository.getUserById(userId)
        }
    }
}
