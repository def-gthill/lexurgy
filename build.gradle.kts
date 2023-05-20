plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.8.21"
    id("application")
}

group = "com.meamoria"
version = "1.3.0"

repositories {
    mavenCentral()
}

tasks.compileJava {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

tasks.test {
    useJUnitPlatform()
    outputs.upToDateWhen { false }
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("com.meamoria.lexurgy.MainJvmKt")
}

dependencies {
    implementation("org.antlr:antlr4-runtime:4.7.2")
    implementation("com.github.ajalt:clikt:2.7.0")
    implementation("net.java.dev.jna:jna:5.5.0")
    implementation("net.java.dev.jna:jna-platform:5.5.0")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.6.0")
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.6.0")
}
