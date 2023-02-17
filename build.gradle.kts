// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    extra.apply {
        set("compose_version", "1.4.2")
        set("kotlin_version"," 1.4.0")
        set("sdkVersion", 33)
//        kotlin_version = "1.4.0"
//        sdkVersion = 33
        // You can also create properties to specify versions for dependencies.
        // Having consistent versions between modules can avoid conflicts with behavior.
//        appcompatVersion = "1.6.1"
    }
}

plugins {
    id("com.android.application") version "7.2.2" apply false
    id("com.android.library") version "7.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.21" apply false
//    id 'androidx.navigation.safeargs' version '2.4.2' apply false
}

println("This is executed during the configuration phase.")

//task clean (type: Delete) {
//    delete rootProject . buildDir
//}

//https://docs.gradle.org/current/userguide/build_lifecycle.html
tasks.register("configured") {
    println("This is also executed during the configuration phase, because :configured is used in the build.")
}

tasks.register("test") {
    doLast {
        println("This is executed during the execution phase.")
    }
}

tasks.register("testBoth") {
    doFirst {
        println("This is executed first during the execution phase.")
    }
    doLast {
        println("This is executed last during the execution phase.")
    }
    println("This is executed during the configuration phase as well, because :testBoth is used in the build.")
}