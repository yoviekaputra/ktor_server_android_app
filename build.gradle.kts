// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_version = "1.1.1"
    val ktor_version = "2.0.0"
    val hilt_core = "2.41"

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hilt_core")
    }
}

plugins {
    id("com.android.application") version "7.1.0" apply false
    id("com.android.library") version "7.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}