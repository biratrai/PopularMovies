plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = rootProject.extra["sdkVersion"] as Int?

    defaultConfig {
        applicationId = "com.gooner10.popularmoviesapp"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level
        minSdk = 24

        // Custom test runner to set up Hilt dependency graph
//        testInstrumentationRunner = "com.google.samples.apps.nowinandroid.core.testing.NiaTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
//        compose true
        viewBinding = true
        dataBinding = false
    }
}
//android {
//    namespace 'com.gooner10.popularmoviesapp'
//    compileSdk 33
//
//    defaultConfig {
//        applicationId "com.gooner10.popularmoviesapp"
//        minSdkVersion 24
//        targetSdkVersion 33
//        versionCode 1
//        versionName "1.0"
//
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//        vectorDrawables.useSupportLibrary = true
//
//        javaCompileOptions {
//            annotationProcessorOptions {
//                arguments = ["room.schemaLocation": "$projectDir/schemas".toString()]
//            }
//        }
//    }
//
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
//        }
//    }
//
////    androidExtensions {
////        experimental = true
////    }
//
//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
//
//    kotlinOptions {
//        jvmTarget = '1.8'
//    }
//    buildFeatures {
//        compose true
//        viewBinding true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion compose_version
//        kotlinCompilerVersion kotlin_version
//    }
//    packagingOptions {
//        resources {
//            excludes += '/META-INF/{AL2.0,LGPL2.1}'
//        }
//    }
//}

dependencies {
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
    // module
    implementation (project(":feature:moviehome"))
    implementation (project(":feature:moviedetail"))
    implementation (project(":feature:settings"))
    implementation (project(":feature:trivia"))
    implementation (project(":feature:favoritemovie"))
    implementation (project("::core:data"))

    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.8.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Stetho
    implementation ("com.facebook.stetho:stetho:1.5.0")
    // Navigation
    implementation ("android.arch.navigation:navigation-fragment-ktx:1.0.0")
    implementation ("android.arch.navigation:navigation-ui-ktx:1.0.0")

    // Test dependencies
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}


//task hello {
//        println 'Hello, My World!'
//}