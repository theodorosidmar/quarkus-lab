import org.gradle.api.JavaVersion

plugins {
    kotlin(module = "jvm") version "1.6.10"
    kotlin(module = "plugin.allopen") version "1.6.10"

    id("io.quarkus")
}

group = "com.github.theodorosidmar.quarkuslab"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    // Kotlin
    implementation(platform(notation = "org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin(module = "stdlib"))
    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin")

    // Quarkus
    implementation(enforcedPlatform(notation = "${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation(group = "io.quarkus", name = "quarkus-resteasy-jackson")
    implementation(group = "io.quarkus", name = "quarkus-rest-client")
    implementation(group = "io.quarkus", name = "quarkus-kotlin")
    implementation(group = "io.quarkus", name = "quarkus-config-yaml")
    implementation(group = "io.quarkus", name = "quarkus-smallrye-health")

    // Tests
    testImplementation(group = "io.quarkus", name = "quarkus-junit5")
    testImplementation(group = "io.rest-assured", name = "rest-assured")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    test {
        useJUnitPlatform()
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

allOpen {
    annotation("javax.enterprise.context.ApplicationScoped")
}
