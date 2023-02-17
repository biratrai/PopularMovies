plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    val sdkVersion: Int by rootProject.extra
    compileSdk = sdkVersion

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation ("androidx.core:core-ktx:1.9.0")

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}