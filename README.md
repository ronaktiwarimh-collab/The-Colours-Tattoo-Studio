# The Colours Tattoo Studio — Android App

Official Android mobile application for **The Colours Tattoo Studio**, led by **Shekhar Nayak** (9+ Years of Professional Tattooing) in Nashik, Maharashtra.

Designed with an editorial luxury aesthetic (Deep Charcoal, Warm Ivory, and Antique Gold) powered by **Jetpack Compose** and **Material 3**.

---

## 🌟 Features

* **Brand & Visual Identity:** Luxury dark palette (`#151515`, `#202020`, `#242424`, `#F4F0E8`, `#B89B5E`, `#3A3328`) with editorial serif typography and responsive layouts.
* **Sticky Navigation & Sliding Drawer:** Instant access to all 11 sections:
  1. *Home (Hero)*
  2. *About Studio*
  3. *The Artist (Shekhar Nayak)*
  4. *Specialities (Cover-Up, Custom, Portrait)*
  5. *Tattoo Styles (12 visual styles)*
  6. *Studio Gallery (8 curated slots with filter categories)*
  7. *Tattoo Concepts (AI-assisted visual inspiration)*
  8. *Tattoo Academy (Mentorship & craft)*
  9. *Tattoo Process (5-step timeline)*
  10. *Client Reviews (15 authentic testimonials)*
  11. *Contact & Studio Location*
* **Interactive Lightbox:** Full-screen modal with multi-touch pinch-to-zoom, pan, previous/next image navigation, and direct WhatsApp style enquiry.
* **Client Reviews & Google Map Review:**
  * 15 client testimonials in an interactive carousel with star ratings and client avatars.
  * Direct **⭐ REVIEW US ON GOOGLE** button linking straight to the studio's Google Maps listing (`https://maps.app.goo.gl/jvi92n73G8gtYf1v9`).
* **Instant Communication:**
  * One-tap WhatsApp chat with pre-filled consultation messages.
  * Contact selector dialog for primary (`7976234747`) and alternate (`9860158785`) numbers.
  * Fixed subtle bottom action bar (`WHATSAPP | CALL`).
  * Direct Google Maps navigation and official Instagram profile links.

---

## 🛠 Tech Stack

* **Language:** 100% Kotlin
* **UI Framework:** Jetpack Compose with Material 3 (M3)
* **Build System:** Gradle (Kotlin DSL — `.gradle.kts`) with Version Catalog (`libs.versions.toml`)
* **Architecture:** Component-driven MVVM with Compose State & Coroutines
* **Compatibility:** Android minSdk 24 (Android 7.0) to targetSdk 36

---

## 🚀 Building & Running Locally

1. **Clone the repository:**
   ```bash
   git clone https://github.com/<your-username>/the-colours-tattoo-android.git
   cd the-colours-tattoo-android
   ```

2. **Open in Android Studio:**
   * Open Android Studio (Ladybug / Koala or newer recommended).
   * Select **Open** and select the cloned project directory.
   * Allow Gradle to sync dependencies.

3. **Run on Device or Emulator:**
   * Connect an Android device (USB Debugging enabled) or start an Android Virtual Device (AVD).
   * Click the green **Run** button (`Shift + F10`) or run from terminal:
     ```bash
     ./gradlew assembleDebug
     ```

---

## 📍 Studio Details

* **Studio Name:** The Colours Tattoo Studio
* **Founder & Artist:** Shekhar Nayak (9+ Years of Professional Tattooing)
* **Address:** Shubham Complex, Multi Dham / Near Mukti Dham Mandir, Rajwada Nagar, Bitco Point, Nashik Road, Nashik, Maharashtra 422101
* **Contact Numbers:** 7976234747 / 9860158785
* **WhatsApp:** [+91 7976234747](https://wa.me/917976234747)
* **Instagram:** [@the_colours_tattooz](https://www.instagram.com/the_colours_tattooz?stkn=a3IzcXp6ZTY2aThn)
* **Google Maps:** [Location Link](https://maps.app.goo.gl/jvi92n73G8gtYf1v9)
