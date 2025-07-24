plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}



android {
    namespace = "com.asad.easybuy"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.asad.easybuy"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        correctErrorTypes = true
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(project(":Data"))
    implementation(project(":Domain"))

    implementation("androidx.core:core-ktx:1.16.0")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    //Support
    implementation ("androidx.recyclerview:recyclerview:1.4.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.2")
    implementation ("com.google.android.material:material:1.12.0")

    //okHttp
    implementation ("com.squareup.okhttp3:okhttp:5.1.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.1.0")

    //Extensions
    implementation ("androidx.core:core-ktx:1.16.0")
    implementation ("androidx.fragment:fragment-ktx:1.8.8")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.9.2")

    //GSON
    implementation ("com.google.code.gson:gson:2.13.1")

    //Navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.9.2")
    implementation ("androidx.navigation:navigation-ui-ktx:2.9.2")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:3.0.0")
    implementation ("com.squareup.retrofit2:converter-gson:3.0.0")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.squareup.retrofit2:adapter-rxjava2:3.0.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("com.squareup.retrofit2:converter-scalars:3.0.0")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    // hilt;
    implementation("com.google.dagger:hilt-android:2.57")
    kapt("com.google.dagger:hilt-android-compiler:2.57")

    //ssp
    implementation ("com.intuit.ssp:ssp-android:1.1.1")

    //Lottie
    implementation ("com.airbnb.android:lottie:6.6.7")

    // circle image
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")

    //data preference
    implementation("androidx.datastore:datastore-preferences:1.1.7")

    //firebase
    implementation(platform("com.google.firebase:firebase-bom:34.0.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-messaging-ktx")
    implementation ("com.google.firebase:firebase-auth-ktx")

    //shimmer Effect
    implementation ("com.facebook.shimmer:shimmer:0.5.0")
}