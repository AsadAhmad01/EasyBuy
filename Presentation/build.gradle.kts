plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}



android {
    namespace = "com.asad.easybuy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.asad.easybuy"
        minSdk = 24
        targetSdk = 34
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

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    //Support
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.5")
    implementation ("com.google.android.material:material:1.12.0")

    //okHttp
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")

    //Extensions
    implementation ("androidx.core:core-ktx:1.13.1")
    implementation ("androidx.fragment:fragment-ktx:1.8.3")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.5")

    //GSON
    implementation ("com.google.code.gson:gson:2.10.1")

    //Navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.8.0")
    implementation ("androidx.navigation:navigation-ui-ktx:2.8.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    // hilt;
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

    //ssp
    implementation ("com.intuit.ssp:ssp-android:1.1.0")

    //Lottie
    implementation ("com.airbnb.android:lottie:5.2.0")

    // circle image
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    //data preference
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    //firebase
    implementation(platform("com.google.firebase:firebase-bom:33.3.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-messaging-ktx")
    implementation ("com.google.firebase:firebase-auth-ktx")

    //shimmer Effect
    implementation ("com.facebook.shimmer:shimmer:0.5.0")
}