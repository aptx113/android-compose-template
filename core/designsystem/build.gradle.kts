import com.danteyu.android_compose_template.config.DefaultConfigs

plugins {
    id("app.android.library")
    id("app.android.library.compose")
    id("app.android.library.jacoco")
}

android {
    defaultConfig {
        testInstrumentationRunner = DefaultConfigs.TEST_INSTRUMENTATION_RUNNER
    }
    lint {
        checkDependencies = true
    }
    namespace = DefaultConfigs.DESIGN_SYSTEM_NAME_SPACE
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.kt.compose)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    debugApi(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.runtime)
    lintPublish(project(":lint"))
}
