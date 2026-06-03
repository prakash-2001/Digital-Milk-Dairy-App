# Digital Dairy App

Digital Dairy App is an Android application for managing dairy milk collection records. It provides separate admin and user flows for login, profile/navigation screens, user registration, and daily milk entry tracking.

The project is built as a Java-based Android app using Gradle, AndroidX, Material Components, Navigation Drawer layouts, ViewBinding, SQLite, and configured Firebase dependencies.

## Project Overview

- App name: Digital Dairy App
- Package name: `mad.mini.digitaldairyapp`
- Platform: Android
- Language: Java
- Build system: Gradle
- Minimum SDK: 24
- Target SDK: 33
- Compile SDK: 33
- Version: `1.0`

## Features

### Admin Module

- Admin login using locally stored credentials.
- Admin dashboard with navigation drawer.
- Add daily milk collection entries.
- Edit entry screen for milk collection details.
- Add new admins.
- Add new users.
- Trace users screen.

### User Module

- User login using locally stored credentials.
- User dashboard with navigation drawer.
- User profile screen.
- Track details screen.

### Data Captured

Daily milk entries contain:

- Entry ID
- Date
- Time
- Quantity in liters
- Fat value
- Degree value
- Market price

## Tech Stack

| Area | Technology |
| --- | --- |
| Language | Java |
| UI | XML layouts, Material Components, AppCompat |
| Navigation | AndroidX Navigation Component, DrawerLayout |
| Local database | SQLite through `SQLiteOpenHelper` |
| Architecture support | AndroidX Lifecycle ViewModel and LiveData |
| Build | Android Gradle Plugin 8.0.2, Gradle wrapper |
| Firebase | Realtime Database, Firestore, Authentication dependencies |
| Testing | JUnit, AndroidX Test, Espresso |

Note: Firebase dependencies and `google-services.json` are present, but the main authentication and entry persistence currently use the local SQLite helper in `Database.java`.

## Project Structure

```text
Digital-Milk-Dairy-App/
|-- app/
|   |-- build.gradle
|   |-- google-services.json
|   |-- proguard-rules.pro
|   `-- src/
|       |-- androidTest/
|       |-- main/
|       |   |-- AndroidManifest.xml
|       |   |-- java/mad/mini/digitaldairyapp/
|       |   |   |-- Database.java
|       |   |   |-- JsonParser.java
|       |   |   |-- MainActivity.java
|       |   |   |-- admin/
|       |   |   |   |-- admin.java
|       |   |   |   `-- ui/
|       |   |   |       |-- ad_signup/
|       |   |   |       |-- admin_home/
|       |   |   |       |-- admin_login/
|       |   |   |       |-- admin_trace/
|       |   |   |       |-- edit_entry/
|       |   |   |       |-- entry/
|       |   |   |       `-- user_signup/
|       |   |   `-- user/
|       |   |       |-- user.java
|       |   |       `-- ui/
|       |   |           |-- trace_ur_details/
|       |   |           |-- user_home/
|       |   |           |-- user_login/
|       |   |           `-- user_profile/
|       |   `-- res/
|       |       |-- drawable/
|       |       |-- layout/
|       |       |-- menu/
|       |       |-- navigation/
|       |       |-- values/
|       |       `-- xml/
|       `-- test/
|-- build.gradle
|-- gradle.properties
|-- gradlew
|-- gradlew.bat
|-- settings.gradle
`-- README.md
```

## Main Screens

| Screen | Source |
| --- | --- |
| App entry screen | `MainActivity.java`, `activity_main.xml` |
| Admin login | `admin_login.java`, `admin_login.xml` |
| Admin dashboard | `admin.java`, `admin.xml`, `mobile_navigation.xml` |
| Daily entry | `ad_entry.java`, `ad_entry.xml` |
| Edit entry | `edit_entry.java`, `edit_entry.xml` |
| Admin signup | `admin_signup.java`, `admin_signup.xml` |
| User signup | `user_signup.java`, `user_signup.xml` |
| User login | `user_login.java`, `user_login.xml` |
| User dashboard | `user.java`, `user.xml`, `mobile_navigation2.xml` |
| User profile | `user_profile.java`, `user_profile.xml` |
| Track details | `trace_ur_details.java`, `trace_ur_details.xml` |

## Database

The app creates a local SQLite database named `digital_dairy_app` through `Database.java`.

### `admin_signup`

| Column | Type | Description |
| --- | --- | --- |
| `admin_id` | TEXT | Admin login ID |
| `admin_name` | TEXT | Admin name |
| `admin_email` | TEXT | Admin email |
| `admin_phoneno` | TEXT | Admin phone number |
| `admin_password` | TEXT | Admin password |

### `user_signup`

| Column | Type | Description |
| --- | --- | --- |
| `user_id` | TEXT | User login ID |
| `user_name` | TEXT | User name |
| `user_email` | TEXT | User email |
| `user_phoneno` | TEXT | User phone number |
| `user_password` | TEXT | User password |

### `data_entry`

| Column | Type | Description |
| --- | --- | --- |
| `entry_d_id` | TEXT | Entry ID |
| `entry_d_date` | TEXT | Entry date |
| `entry_d_time` | TEXT | Entry time |
| `entry_d_ltr` | TEXT | Milk quantity in liters |
| `entry_d_fat` | TEXT | Milk fat value |
| `entry_d_deg` | TEXT | Milk degree value |
| `entry_d_price` | TEXT | Market price |

## Getting Started

### Prerequisites

- Android Studio
- JDK 17 or compatible Java runtime for Android Gradle Plugin 8.x
- Android SDK Platform 33
- Android device or emulator with Android 7.0 or newer

### Setup

1. Clone or download the project.
2. Open the project folder in Android Studio.
3. Let Android Studio sync Gradle.
4. Confirm `app/google-services.json` exists if Firebase services are required.
5. Run the app on an emulator or Android device.

## Build Commands

From the project root on Windows:

```powershell
.\gradlew.bat assembleDebug
```

Run local unit tests:

```powershell
.\gradlew.bat test
```

Run instrumented tests on a connected device or emulator:

```powershell
.\gradlew.bat connectedAndroidTest
```

## Firebase Configuration

The project applies the Google Services Gradle plugin and includes Firebase dependencies:

- Firebase Realtime Database
- Firebase Firestore
- Firebase Authentication

If you use a different Firebase project:

1. Create or open a Firebase project.
2. Add an Android app with package name `mad.mini.digitaldairyapp`.
3. Download the new `google-services.json`.
4. Replace `app/google-services.json`.
5. Sync and rebuild the project.

## Security Notes

This is an academic/demo-style project and should be improved before production use.

- Passwords are stored as plain text in SQLite.
- There is no password hashing or salting.
- Input validation is minimal.
- User and admin sessions are stored with basic `SharedPreferences`.
- Database rows do not define primary keys or uniqueness constraints.

Recommended improvements:

- Use Firebase Authentication or a secure backend authentication system.
- Hash passwords if local authentication is retained.
- Add validation for email, phone, numeric milk values, and date/time fields.
- Add database constraints and migration logic.
- Avoid committing production Firebase configuration files.

## Current Implementation Notes

- The app uses Java Activities and Fragments with XML layouts.
- Admin and user areas have separate navigation graphs.
- `Database.java` handles local admin signup, user signup, login checks, and entry insertion.
- The edit entry method currently inserts a new row with edited values instead of updating an existing row.
- The user login success flow currently starts `user_login` again instead of opening the user dashboard activity.

## License

This project appears to be created as an academic mini project for GECM, Department of Computer Science and Engineering. Add a formal license file if the project will be distributed publicly.
