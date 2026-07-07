plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlin.compose)

}

android {
    namespace = "com.mehdisekoba.animatedbottombar"
    compileSdk = 37

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

kotlin {
    jvmToolchain(17)
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)

    // Foundation + Material 3 are the only runtime surface the library needs.
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)

    // Tooling for @Preview support in consuming apps' previews; compileOnly keeps it
    // out of the consumer runtime classpath.
    compileOnly(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)

    testImplementation(libs.junit)
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.test.manifest)
}
mavenPublishing {
    coordinates(
        groupId = "io.github.mehdisekoba",
        artifactId = "animatedbottombar",
        version = "1.0.0"
    )

    pom {
        name.set("AnimatedBottomBar")
        description.set("A beautiful Jetpack Compose bottom navigation bar with floating curved indicator")
        url.set("https://github.com/MehdiSekoba")
        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
            }
        }
        developers {
            developer {
                id.set("mehdisekoba")
                name.set("Mehdi Sekoba")
                email.set("sekobamahdi@gmail.com")
            }
        }
        scm {
            url.set("https://github.com/MehdiSekoba/AnimatedBottomBar")
            connection.set("scm:git:git://github.com/MehdiSekoba/AnimatedBottomBar.git")
            developerConnection.set("scm:git:ssh://git@github.com/MehdiSekoba/AnimatedBottomBar.git")
        }
    }
    publishToMavenCentral()
    signAllPublications()
}
