package com.hustl.app.ui.gigs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000b\u00f8\u0001\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/hustl/app/ui/gigs/GigDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_gig", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/hustl/app/data/model/Gig;", "_reviews", "", "Lcom/hustl/app/data/model/Review;", "gig", "Landroidx/lifecycle/LiveData;", "getGig", "()Landroidx/lifecycle/LiveData;", "repository", "Lcom/hustl/app/data/repository/GigRepository;", "reviews", "getReviews", "loadGig", "", "gigId", "", "app_debug"})
public final class GigDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.hustl.app.data.repository.GigRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Result<com.hustl.app.data.model.Gig>> _gig = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<kotlin.Result<com.hustl.app.data.model.Gig>> gig = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.hustl.app.data.model.Review>> _reviews = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.hustl.app.data.model.Review>> reviews = null;
    
    public GigDetailViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<kotlin.Result<com.hustl.app.data.model.Gig>> getGig() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.hustl.app.data.model.Review>> getReviews() {
        return null;
    }
    
    public final void loadGig(@org.jetbrains.annotations.NotNull
    java.lang.String gigId) {
    }
}