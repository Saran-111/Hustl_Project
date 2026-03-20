package com.hustl.app.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hustl.app.data.model.User
import com.hustl.app.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val repository = AuthRepository()

    private val _loginResult = MutableLiveData<Result<User>>()
    val loginResult: LiveData<Result<User>> = _loginResult

    private val _registerResult = MutableLiveData<Result<User>>()
    val registerResult: LiveData<Result<User>> = _registerResult

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun login(email: String, password: String) {
        _loading.value = true
        viewModelScope.launch {
            _loginResult.value = repository.login(email, password)
            _loading.value = false
        }
    }

    fun register(name: String, email: String, password: String, role: String) {
        _loading.value = true
        viewModelScope.launch {
            _registerResult.value = repository.register(name, email, password, role)
            _loading.value = false
        }
    }

    fun isLoggedIn() = repository.isLoggedIn()
}
