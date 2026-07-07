// Top-level build file. Configuration common to all sub-projects lives here;
// module-specific setup is in each module's own build.gradle.kts.
plugins {
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.maven.publish) apply false
    alias(libs.plugins.dokka) apply false
}