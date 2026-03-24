package com.hustl.app.ui.chat;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0005J&\u0010\u0018\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/hustl/app/ui/chat/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_chatId", "Landroidx/lifecycle/MutableLiveData;", "", "_messages", "", "Lcom/hustl/app/data/model/Message;", "chatId", "Landroidx/lifecycle/LiveData;", "getChatId", "()Landroidx/lifecycle/LiveData;", "messages", "getMessages", "repository", "Lcom/hustl/app/data/repository/ChatRepository;", "initChat", "", "buyerId", "sellerId", "gigId", "gigTitle", "loadMessages", "sendMessage", "senderId", "senderName", "text", "app_debug"})
public final class ChatViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.hustl.app.data.repository.ChatRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _chatId = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.String> chatId = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.hustl.app.data.model.Message>> _messages = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.hustl.app.data.model.Message>> messages = null;
    
    public ChatViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getChatId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.hustl.app.data.model.Message>> getMessages() {
        return null;
    }
    
    public final void initChat(@org.jetbrains.annotations.NotNull
    java.lang.String buyerId, @org.jetbrains.annotations.NotNull
    java.lang.String sellerId, @org.jetbrains.annotations.NotNull
    java.lang.String gigId, @org.jetbrains.annotations.NotNull
    java.lang.String gigTitle) {
    }
    
    public final void loadMessages(@org.jetbrains.annotations.NotNull
    java.lang.String chatId) {
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull
    java.lang.String chatId, @org.jetbrains.annotations.NotNull
    java.lang.String senderId, @org.jetbrains.annotations.NotNull
    java.lang.String senderName, @org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
}