import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm")
}

val versionNumber = "1.3.5"

group = "com.meamoria"
version = versionNumber

repositories {
    mavenCentral()
}

tasks.compileJava {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

tasks.compileKotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_1_8)
    }
}

tasks.test {
    useJUnitPlatform()
    outputs.upToDateWhen { false }
}

tasks.jar {
    manifest {
        attributes("Implementation-Version" to versionNumber)
    }
}

dependencies {
    implementation("org.antlr:antlr4-runtime:4.7.2")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.6.0")
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.6.0")
}
