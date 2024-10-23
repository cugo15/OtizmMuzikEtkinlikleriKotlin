plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.aecg.oyunvemuzikae"
    compileSdk = 34

    defaultConfig {
        vectorDrawables {
            useSupportLibrary = true
        }
        applicationId = "com.aecg.oyunvemuzikae"
        minSdk = 23
        targetSdk = 34
        versionCode = 2
        versionName = "2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity:1.9.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Fragment KTX: Kotlin ile daha kolay fragment kullanımı
    implementation("androidx.fragment:fragment-ktx:1.8.4")

    // Fragment Testing: Fragment testleri için destek
    debugImplementation("androidx.fragment:fragment-testing:1.8.4")

    // Navigation Fragment: Navigasyon için fragment desteği
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.3")

    // Navigation UI: Navigasyon arayüzü bileşenleri
    implementation("androidx.navigation:navigation-ui-ktx:2.8.3")

    // Dynamic Features: Dinamik özellik desteği
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.8.3")

    // Navigation Testing: Navigasyon testleri için
    androidTestImplementation("androidx.navigation:navigation-testing:2.8.3")

    //Görsel Yükleme: Glide kütüphanesi
    implementation("com.github.bumptech.glide:glide:4.16.0")

}
