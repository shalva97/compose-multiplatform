pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        if (extra["compose.useMavenLocal"] == "true") {
            mavenLocal()
        }
    }

    plugins {
        kotlin("jvm").version(extra["kotlin.version"] as String)
        kotlin("multiplatform").version(extra["kotlin.version"] as String)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
        id("com.android.library").version(extra["agp.version"] as String)
    }
}

dependencyResolutionManagement {
    repositories {
        if (extra["compose.useMavenLocal"] == "true") {
            mavenLocal() // mavenLocal should be the first to get the correct version of skiko during a local build.
        }
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":SplitPane:library")
include(":SplitPane:demo")
include(":AnimatedImage:library")
include(":AnimatedImage:demo")
include(":resources:library")
include(":resources:demo:androidApp")
include(":resources:demo:desktopApp")
include(":resources:demo:shared")
