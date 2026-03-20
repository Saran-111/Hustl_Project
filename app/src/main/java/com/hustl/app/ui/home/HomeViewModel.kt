package com.hustl.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hustl.app.data.model.Gig
import com.hustl.app.data.repository.GigRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = GigRepository()

    private val _gigs = MutableLiveData<Result<List<Gig>>>()
    val gigs: LiveData<Result<List<Gig>>> = _gigs

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun loadGigs() {
        _loading.value = true
        viewModelScope.launch {
            _gigs.value = repository.getAllGigs()
            _loading.value = false
        }
    }

    fun loadGigsByCategory(category: String) {
        _loading.value = true
        viewModelScope.launch {
            _gigs.value = repository.getGigsByCategory(category)
            _loading.value = false
        }
    }

    fun searchGigs(query: String) {
        _loading.value = true
        viewModelScope.launch {
            _gigs.value = repository.searchGigs(query)
            _loading.value = false
        }
    }
}
