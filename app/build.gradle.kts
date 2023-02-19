import com.danteyu.android_compose_template.AppBuildType
import com.danteyu.android_compose_template.config.DefaultConfig

plugins {
    id("app.android.application")
    id("app.android.application.compose")
    id("app.android.application.flavors")
    id("app.android.application.jacoco")
    id("app.android.hilt")
    id("jacoco")
    id("app.android.application.firebase")
}

val keystorePropertiesFile = rootProject.file("keystore.properties")

android {
    defaultConfig {
        applicationId = DefaultConfig.APPLICATION_ID
        versionCode = DefaultConfig.VERSION_CODE
        versionName = DefaultConfig.VERSION_NAME

        testInstrumentationRunner = DefaultConfig.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = AppBuildType.DEBUG.applicationIdSuffix
            signingConfig = signingConfigs.getByName("debug")
        }

        val release by getting {
            isMinifyEnabled = true
            isShrinkResources = true
            applicationIdSuffix = AppBuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            if (keystorePropertiesFile.exists()) {
                signingConfig = signingConfigs.getByName("release")
            }
        }
        val benchmark by creating {
            initWith(release)
            matchingFallbacks.add("release")
            signingConfig = signingConfigs.getByName("debug")

            isMinifyEnabled = true
            applicationIdSuffix = AppBuildType.BENCHMARK.applicationIdSuffix
        }
    }
    namespace = DefaultConfig.NAME_SPACE
}

dependencies {

}

//android {
//    namespace 'com.danteyu.android_template_compose'
//    compileSdk 33
//
//    defaultConfig {
//        applicationId "com.danteyu.android_template_compose"
//        minSdk 28
//        targetSdk 33
//        versionCode 1
//        versionName "1.0"
//
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//        vectorDrawables {
//            useSupportLibrary true
//        }
//    }
//
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = '1.8'
//    }
//    buildFeatures {
//        compose true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion '1.2.0'
//    }
//    packagingOptions {
//        resources {
//            excludes += '/META-INF/{AL2.0,LGPL2.1}'
//        }
//    }
//}
//
//dependencies {
//
//    implementation 'androidx.core:core-ktx:1.7.0'
//    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
//    implementation 'androidx.activity:activity-compose:1.3.1'
//    implementation "androidx.compose.ui:ui:$compose_version"
//    implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
//    implementation 'androidx.compose.material3:material3:1.0.0-alpha11'
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
//    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
//    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
//    debugImplementation "androidx.compose.ui:ui-test-manifest:$compose_version"
//}