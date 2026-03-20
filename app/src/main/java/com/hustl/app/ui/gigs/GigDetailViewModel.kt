package com.hustl.app.ui.gigs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hustl.app.data.model.Gig
import com.hustl.app.data.model.Review
import com.hustl.app.data.repository.GigRepository
import kotlinx.coroutines.launch

class GigDetailViewModel : ViewModel() {
    private val repository = GigRepository()

    private val _gig = MutableLiveData<Result<Gig>>()
    val gig: LiveData<Result<Gig>> = _gig

    private val _reviews = MutableLiveData<List<Review>>()
    val reviews: LiveData<List<Review>> = _reviews

    fun loadGig(gigId: String) {
        viewModelScope.launch {
            _gig.value = repository.getGigById(gigId)
            val reviewResult = repository.getReviewsForGig(gigId)
            reviewResult.onSuccess { _reviews.value = it }
        }
    }
}
