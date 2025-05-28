plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.serialization)

}

android {
    namespace = "com.sipsplit"//sipsplit
    compileSdk = 35

    defaultConfig {
        applicationId = "com.sipsplit"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.firebase.common.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.androidx.foundation)
    implementation (libs.androidx.navigation.compose)
    // Firebase Auth
    implementation(libs.firebase.auth.ktx)
// Firebase BOM (Bill of Materials to manage versions)
    implementation(libs.firebase.bom)

    testImplementation ("com.google.truth:truth:1.4.4")

    //
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)
    implementation (libs.glide)
    implementation (libs.gson)
    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.foundation)
    debugImplementation(libs.ui.tooling)
    implementation(libs.material)
    implementation(libs.ui.tooling)

    // Network
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
    implementation(libs.retrofit.core)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor.v4120)
    implementation(libs.kotlinx.serialization.json)

    // dagger Hilt
    // Hilt for Dependency Injection
    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)
    implementation (libs.androidx.hilt.navigation.compose)
    testImplementation(kotlin("test"))


}
// ✅ Apply Google Services Plugin (IMPORTANT)
apply(plugin = "com.google.gms.google-services")