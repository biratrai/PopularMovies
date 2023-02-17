plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
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

    implementation ("com.google.code.gson:gson:2.9.0")

    // Room persistence library
    // Room (use 1.1.0-alpha1 for latest alpha)
    implementation ("androidx.room:room-runtime:2.5.0")
    annotationProcessor ("androidx.room:room-compiler:2.5.0")
    androidTestImplementation ("androidx.room:room-testing:2.5.0")

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}