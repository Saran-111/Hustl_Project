package com.hustl.app.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0016R#\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u000b\u00f8\u0001\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/hustl/app/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_gigs", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "", "Lcom/hustl/app/data/model/Gig;", "_loading", "", "gigs", "Landroidx/lifecycle/LiveData;", "getGigs", "()Landroidx/lifecycle/LiveData;", "loading", "getLoading", "repository", "Lcom/hustl/app/data/repository/GigRepository;", "loadGigs", "", "loadGigsByCategory", "category", "", "searchGigs", "query", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.hustl.app.data.repository.GigRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Result<java.util.List<com.hustl.app.data.model.Gig>>> _gigs = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<kotlin.Result<java.util.List<com.hustl.app.data.model.Gig>>> gigs = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _loading = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Boolean> loading = null;
    
    public HomeViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<kotlin.Result<java.util.List<com.hustl.app.data.model.Gig>>> getGigs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getLoading() {
        return null;
    }
    
    public final void loadGigs() {
    }
    
    public final void loadGigsByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
    }
    
    public final void searchGigs(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
}