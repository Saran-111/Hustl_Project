package com.hustl.app.ui.chat;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/hustl/app/ui/chat/InboxViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_chats", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/hustl/app/data/model/Chat;", "chats", "Landroidx/lifecycle/LiveData;", "getChats", "()Landroidx/lifecycle/LiveData;", "repository", "Lcom/hustl/app/data/repository/ChatRepository;", "loadChats", "", "userId", "", "app_debug"})
public final class InboxViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.hustl.app.data.repository.ChatRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.hustl.app.data.model.Chat>> _chats = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.hustl.app.data.model.Chat>> chats = null;
    
    public InboxViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.hustl.app.data.model.Chat>> getChats() {
        return null;
    }
    
    public final void loadChats(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
    }
}