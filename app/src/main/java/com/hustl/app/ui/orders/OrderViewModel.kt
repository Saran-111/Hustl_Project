package com.hustl.app.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hustl.app.data.model.Gig
import com.hustl.app.data.model.Order
import com.hustl.app.data.repository.GigRepository
import com.hustl.app.data.repository.OrderRepository
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {
    private val orderRepository = OrderRepository()
    private val gigRepository = GigRepository()

    private val _gig = MutableLiveData<Gig>()
    val gig: LiveData<Gig> = _gig

    private val _order = MutableLiveData<Order>()
    val order: LiveData<Order> = _order

    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> = _orders

    private val _orderResult = MutableLiveData<Result<String>>()
    val orderResult: LiveData<Result<String>> = _orderResult

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun loadGig(gigId: String) {
        viewModelScope.launch {
            gigRepository.getGigById(gigId).onSuccess { _gig.value = it }
        }
    }

    fun loadOrder(orderId: String) {
        _loading.value = true
        viewModelScope.launch {
            orderRepository.getOrderById(orderId).onSuccess { _order.value = it }
            _loading.value = false
        }
    }

    fun placeOrder(gigId: String, buyerId: String, buyerName: String, requirements: String) {
        _loading.value = true
        viewModelScope.launch {
            val gigResult = gigRepository.getGigById(gigId)
            gigResult.onSuccess { gig ->
                val order = Order(
                    gigId = gigId,
                    gigTitle = gig.title,
                    gigImage = gig.images.firstOrNull() ?: "",
                    buyerId = buyerId,
                    buyerName = buyerName,
                    sellerId = gig.sellerId,
                    sellerName = gig.sellerName,
                    price = gig.price,
                    deliveryDays = gig.deliveryDays,
                    requirements = requirements,
                    status = "pending"
                )
                _orderResult.value = orderRepository.createOrder(order)
            }.onFailure {
                _orderResult.value = Result.failure(it)
            }
            _loading.value = false
        }
    }

    fun loadBuyerOrders(buyerId: String) {
        _loading.value = true
        viewModelScope.launch {
            orderRepository.getOrdersForBuyer(buyerId).onSuccess { _orders.value = it }
            _loading.value = false
        }
    }

    fun loadSellerOrders(sellerId: String) {
        _loading.value = true
        viewModelScope.launch {
            orderRepository.getOrdersForSeller(sellerId).onSuccess { _orders.value = it }
            _loading.value = false
        }
    }

    fun updateOrderStatus(orderId: String, status: String) {
        viewModelScope.launch {
            orderRepository.updateOrderStatus(orderId, status)
        }
    }
}
