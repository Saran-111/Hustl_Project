package com.hustl.app.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/hustl/app/adapters/MessageAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/hustl/app/data/model/Message;", "Lcom/hustl/app/adapters/MessageAdapter$ViewHolder;", "currentUserId", "", "(Ljava/lang/String;)V", "VIEW_TYPE_RECEIVED", "", "VIEW_TYPE_SENT", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MsgDiff", "ViewHolder", "app_debug"})
public final class MessageAdapter extends androidx.recyclerview.widget.ListAdapter<com.hustl.app.data.model.Message, com.hustl.app.adapters.MessageAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String currentUserId = null;
    private final int VIEW_TYPE_SENT = 1;
    private final int VIEW_TYPE_RECEIVED = 2;
    
    public MessageAdapter(@org.jetbrains.annotations.NotNull
    java.lang.String currentUserId) {
        super(null);
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.hustl.app.adapters.MessageAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.hustl.app.adapters.MessageAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/hustl/app/adapters/MessageAdapter$MsgDiff;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/hustl/app/data/model/Message;", "()V", "areContentsTheSame", "", "o", "n", "areItemsTheSame", "app_debug"})
    public static final class MsgDiff extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.hustl.app.data.model.Message> {
        
        public MsgDiff() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.hustl.app.data.model.Message o, @org.jetbrains.annotations.NotNull
        com.hustl.app.data.model.Message n) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.hustl.app.data.model.Message o, @org.jetbrains.annotations.NotNull
        com.hustl.app.data.model.Message n) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/hustl/app/adapters/MessageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "isSent", "", "(Lcom/hustl/app/adapters/MessageAdapter;Landroid/view/View;Z)V", "bind", "", "message", "Lcom/hustl/app/data/model/Message;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.view.View view = null;
        private final boolean isSent = false;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view, boolean isSent) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.hustl.app.data.model.Message message) {
        }
    }
}