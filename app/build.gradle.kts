plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.github.yoviep.ktorserverexample"
        minSdk = 21
        targetSdk = 31
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/INDEX.LIST")
            add("META-INF/io.netty.versions.properties")
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.6.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // ktor server
    implementation("io.ktor:ktor-server-core-jvm:2.0.0")
    implementation("io.ktor:ktor-server-netty-jvm:2.0.0")
    // ktor Logger
    implementation("ch.qos.logback:logback-classic:1.2.7")
    // ktor content type & accept + serialization converter
    implementation("io.ktor:ktor-server-content-negotiation:2.0.0")
    // ktor json converter
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.0")

    // Compose
    implementation("androidx.compose.ui:ui:1.1.1")
    implementation("androidx.compose.material:material:1.1.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.1.1")
    implementation("androidx.activity:activity-compose:1.4.0")

    // work manager
    implementation("androidx.work:work-runtime-ktx:2.7.1")
    implementation("androidx.work:work-testing:2.7.1")

    // android hilt
    implementation("com.google.dagger:hilt-android:2.41")
    implementation("com.google.dagger:hilt-compiler:2.41")
    implementation("androidx.hilt:hilt-compiler:1.0.0")
    // Hilt Worker
    implementation("androidx.hilt:hilt-work:1.0.0")

}