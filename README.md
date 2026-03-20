# 🚀 Hustl - Freelancing Marketplace App

A Fiverr-like Android freelancing app built with Kotlin + Firebase.

---

## 📁 Project Structure

```
Hustl/
├── app/
│   ├── build.gradle                    ← App dependencies
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/hustl/app/
│       │   ├── data/
│       │   │   ├── model/              ← Data classes (User, Gig, Order, Message...)
│       │   │   └── repository/         ← Firebase data access (Auth, Gig, Order, Chat)
│       │   ├── ui/
│       │   │   ├── auth/               ← Splash, Onboarding, Login, Register
│       │   │   ├── home/               ← MainActivity + HomeFragment
│       │   │   ├── gigs/               ← GigDetail, CreateGig
│       │   │   ├── orders/             ← Orders list, PlaceOrder
│       │   │   ├── chat/               ← Chat, Inbox
│       │   │   └── profile/            ← Profile
│       │   ├── adapters/               ← RecyclerView adapters
│       │   └── utils/                  ← Firebase messaging
│       └── res/
│           ├── layout/                 ← All XML layouts
│           ├── drawable/               ← Icons, backgrounds
│           ├── values/                 ← Colors, strings, themes
│           ├── navigation/             ← Nav graph
│           └── menu/                   ← Bottom nav menu
└── build.gradle
```

---

## ⚙️ Setup Instructions

### Step 1: Open in Android Studio
1. Open Android Studio
2. Click **File → Open**
3. Select the `Hustl` folder
4. Wait for Gradle sync

### Step 2: Set up Firebase
1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Click **Add project** → Name it "Hustl"
3. Click **Add app** → Select Android
4. Enter package name: `com.hustl.app`
5. Download `google-services.json`
6. Place it in `Hustl/app/google-services.json`

### Step 3: Enable Firebase Services
In Firebase Console:
- **Authentication** → Sign-in Methods → Enable Email/Password
- **Firestore Database** → Create database (Start in test mode)
- **Storage** → Get started (Start in test mode)

### Step 4: Add Firestore Security Rules (later for production)
```
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if request.auth != null;
    }
  }
}
```

### Step 5: Run the App
- Connect an Android device or start an emulator
- Click the **Run** button (▶)

---

## 📱 App Features

| Feature | Status |
|---|---|
| Splash Screen | ✅ |
| Onboarding | ✅ |
| Register (Buyer/Seller) | ✅ |
| Login | ✅ |
| Browse Gigs | ✅ |
| Search & Filter by Category | ✅ |
| Gig Detail | ✅ |
| Create Gig (Sellers) | ✅ |
| Place Order | ✅ |
| View Orders | ✅ |
| Real-time Chat | ✅ |
| User Profile | ✅ |
| Reviews | ✅ |
| Push Notifications | ✅ (FCM ready) |

---

## 🗄️ Database Structure

```
users/{userId}
  - userId, name, email, role, bio, rating, ...

gigs/{gigId}
  - gigId, sellerId, title, description, category, price, ...

orders/{orderId}
  - orderId, gigId, buyerId, sellerId, status, price, ...

chats/{chatId}
  - chatId, participants[], gigId, lastMessage
  - messages/{messageId}
    - text, senderId, timestamp

reviews/{reviewId}
  - gigId, buyerId, rating, comment
```

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **Architecture:** MVVM
- **Backend:** Firebase (Auth + Firestore + Storage + FCM)
- **UI:** Material Design 3 + XML Layouts
- **Image Loading:** Glide
- **Navigation:** Jetpack Navigation Component

---

## 📌 Next Steps to Enhance

1. **Image Upload** - Let sellers upload gig images to Firebase Storage
2. **Payment Integration** - Add Stripe or Razorpay
3. **Search** - Improve with Algolia or Firestore full-text
4. **Notifications** - Complete FCM push notifications
5. **Seller Dashboard** - Dedicated earnings & stats screen
6. **Dark Mode** - Add night theme
