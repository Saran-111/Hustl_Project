package com.hustl.app.ui.orders;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\fJ\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\fJ\u000e\u0010&\u001a\u00020 2\u0006\u0010\'\u001a\u00020\fJ&\u0010(\u001a\u00020 2\u0006\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\fJ\u0016\u0010+\u001a\u00020 2\u0006\u0010%\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0010\u00f8\u0001\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/hustl/app/ui/orders/OrderViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_gig", "Landroidx/lifecycle/MutableLiveData;", "Lcom/hustl/app/data/model/Gig;", "_loading", "", "_order", "Lcom/hustl/app/data/model/Order;", "_orderResult", "Lkotlin/Result;", "", "_orders", "", "gig", "Landroidx/lifecycle/LiveData;", "getGig", "()Landroidx/lifecycle/LiveData;", "gigRepository", "Lcom/hustl/app/data/repository/GigRepository;", "loading", "getLoading", "order", "getOrder", "orderRepository", "Lcom/hustl/app/data/repository/OrderRepository;", "orderResult", "getOrderResult", "orders", "getOrders", "loadBuyerOrders", "", "buyerId", "loadGig", "gigId", "loadOrder", "orderId", "loadSellerOrders", "sellerId", "placeOrder", "buyerName", "requirements", "updateOrderStatus", "status", "app_debug"})
public final class OrderViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.hustl.app.data.repository.OrderRepository orderRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.hustl.app.data.repository.GigRepository gigRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.hustl.app.data.model.Gig> _gig = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.hustl.app.data.model.Gig> gig = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.hustl.app.data.model.Order> _order = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.hustl.app.data.model.Order> order = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.hustl.app.data.model.Order>> _orders = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.hustl.app.data.model.Order>> orders = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Result<java.lang.String>> _orderResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<kotlin.Result<java.lang.String>> orderResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _loading = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Boolean> loading = null;
    
    public OrderViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.hustl.app.data.model.Gig> getGig() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.hustl.app.data.model.Order> getOrder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.hustl.app.data.model.Order>> getOrders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<kotlin.Result<java.lang.String>> getOrderResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getLoading() {
        return null;
    }
    
    public final void loadGig(@org.jetbrains.annotations.NotNull
    java.lang.String gigId) {
    }
    
    public final void loadOrder(@org.jetbrains.annotations.NotNull
    java.lang.String orderId) {
    }
    
    public final void placeOrder(@org.jetbrains.annotations.NotNull
    java.lang.String gigId, @org.jetbrains.annotations.NotNull
    java.lang.String buyerId, @org.jetbrains.annotations.NotNull
    java.lang.String buyerName, @org.jetbrains.annotations.NotNull
    java.lang.String requirements) {
    }
    
    public final void loadBuyerOrders(@org.jetbrains.annotations.NotNull
    java.lang.String buyerId) {
    }
    
    public final void loadSellerOrders(@org.jetbrains.annotations.NotNull
    java.lang.String sellerId) {
    }
    
    public final void updateOrderStatus(@org.jetbrains.annotations.NotNull
    java.lang.String orderId, @org.jetbrains.annotations.NotNull
    java.lang.String status) {
    }
}