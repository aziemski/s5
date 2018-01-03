import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        maven("https://repo.spring.io/milestone")
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.M7")
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.2")
    }
}

apply {
    plugin("org.springframework.boot")
    plugin("org.junit.platform.gradle.plugin")
}

plugins {
    val kotlinVersion = "1.2.10"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.4.RELEASE"
}

group="s5"
version="1.0.0-SNAPSHOT"


java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}

repositories {
    mavenCentral()
    maven("http://repo.spring.io/milestone")
}

dependencyManagement {
    dependencies {
        val kotlinVersion = "1.2.10"
        dependency("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
        dependency("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
        dependency("org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlinVersion")
        dependency("org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlinVersion")
    }
}

dependencies {
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")
    compile("org.jetbrains.kotlin:kotlin-reflect")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8")
    compile("org.springframework.boot:spring-boot-starter-webflux")
    runtime("org.springframework.boot:spring-boot-devtools")
    testCompile("io.projectreactor:reactor-test")
    testCompile("org.junit.jupiter:junit-jupiter-api")
    testCompile("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    testRuntime("org.junit.jupiter:junit-jupiter-engine")
}

