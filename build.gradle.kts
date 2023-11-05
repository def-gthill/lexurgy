plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.8.21"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}
