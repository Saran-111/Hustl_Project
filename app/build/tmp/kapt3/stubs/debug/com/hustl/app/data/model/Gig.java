package com.hustl.app.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B\u00a7\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0002\u0010\u0018J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u00c6\u0003J\t\u00100\u001a\u00020\u0011H\u00c6\u0003J\t\u00101\u001a\u00020\rH\u00c6\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u00c6\u0003J\t\u00103\u001a\u00020\u0015H\u00c6\u0003J\t\u00104\u001a\u00020\u0017H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u000bH\u00c6\u0003J\t\u0010<\u001a\u00020\rH\u00c6\u0003J\u00ab\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u00c6\u0001J\u0013\u0010>\u001a\u00020\u00152\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010@\u001a\u00020\rH\u00d6\u0001J\t\u0010A\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010#R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001e\u00a8\u0006B"}, d2 = {"Lcom/hustl/app/data/model/Gig;", "", "gigId", "", "sellerId", "sellerName", "sellerImage", "title", "description", "category", "price", "", "deliveryDays", "", "images", "", "rating", "", "totalReviews", "tags", "isActive", "", "createdAt", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DILjava/util/List;FILjava/util/List;ZJ)V", "getCategory", "()Ljava/lang/String;", "getCreatedAt", "()J", "getDeliveryDays", "()I", "getDescription", "getGigId", "getImages", "()Ljava/util/List;", "()Z", "getPrice", "()D", "getRating", "()F", "getSellerId", "getSellerImage", "getSellerName", "getTags", "getTitle", "getTotalReviews", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Gig {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String gigId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String sellerId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String sellerName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String sellerImage = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String category = null;
    private final double price = 0.0;
    private final int deliveryDays = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> images = null;
    private final float rating = 0.0F;
    private final int totalReviews = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> tags = null;
    private final boolean isActive = false;
    private final long createdAt = 0L;
    
    public Gig(@org.jetbrains.annotations.NotNull
    java.lang.String gigId, @org.jetbrains.annotations.NotNull
    java.lang.String sellerId, @org.jetbrains.annotations.NotNull
    java.lang.String sellerName, @org.jetbrains.annotations.NotNull
    java.lang.String sellerImage, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String category, double price, int deliveryDays, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> images, float rating, int totalReviews, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> tags, boolean isActive, long createdAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGigId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSellerId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSellerName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSellerImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final double getPrice() {
        return 0.0;
    }
    
    public final int getDeliveryDays() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getImages() {
        return null;
    }
    
    public final float getRating() {
        return 0.0F;
    }
    
    public final int getTotalReviews() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getTags() {
        return null;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public Gig() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component10() {
        return null;
    }
    
    public final float component11() {
        return 0.0F;
    }
    
    public final int component12() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component13() {
        return null;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final long component15() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.hustl.app.data.model.Gig copy(@org.jetbrains.annotations.NotNull
    java.lang.String gigId, @org.jetbrains.annotations.NotNull
    java.lang.String sellerId, @org.jetbrains.annotations.NotNull
    java.lang.String sellerName, @org.jetbrains.annotations.NotNull
    java.lang.String sellerImage, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String category, double price, int deliveryDays, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> images, float rating, int totalReviews, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> tags, boolean isActive, long createdAt) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}