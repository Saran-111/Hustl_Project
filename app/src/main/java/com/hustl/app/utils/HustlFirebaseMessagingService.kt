package com.hustl.app.utils

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class HustlFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        // Handle incoming FCM messages here
        // You can show a local notification
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Save the new FCM token to Firestore for the current user
    }
}
