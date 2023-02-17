plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    val sdkVersion: Int by rootProject.extra
    compileSdk = sdkVersion

    buildFeatures {
//        compose true
        viewBinding = true
        dataBinding = false
    }
}

dependencies {
    implementation (project(":core:data"))

    // Android Dependencies
    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.8.0")

    // External Dependencies
    implementation ("com.github.bumptech.glide:glide:4.11.0")

    // Test dependencies
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}