package com.hustl.app.ui.gigs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hustl.app.data.model.Gig
import com.hustl.app.data.repository.GigRepository
import kotlinx.coroutines.launch

class CreateGigViewModel : ViewModel() {
    private val repository = GigRepository()

    private val _createResult = MutableLiveData<Result<String>>()
    val createResult: LiveData<Result<String>> = _createResult

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun createGig(
        title: String, description: String, category: String,
        price: Double, deliveryDays: Int, sellerId: String, sellerName: String
    ) {
        _loading.value = true
        viewModelScope.launch {
            val gig = Gig(
                title = title,
                description = description,
                category = category,
                price = price,
                deliveryDays = deliveryDays,
                sellerId = sellerId,
                sellerName = sellerName
            )
            _createResult.value = repository.createGig(gig)
            _loading.value = false
        }
    }
}
