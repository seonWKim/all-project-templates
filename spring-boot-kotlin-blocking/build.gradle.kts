import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.5.10"
    id("org.liquibase.gradle") version "2.0.3"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-configuration-processor:2.7.5")
    liquibaseRuntime("mysql:mysql-connector-java:8.0.26")
    liquibaseRuntime("org.liquibase:liquibase-core:4.4.3")
    liquibaseRuntime("org.yaml:snakeyaml:1.29")
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.7.5")
    implementation("org.mapstruct:mapstruct:1.5.3.Final")

    kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.testcontainers:mysql:1.17.6")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

liquibase {
    activities.register("main") {
        val db_url by project.extra.properties
        val db_user by project.extra.properties
        val db_password by project.extra.properties
        val timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"))

        this.arguments = mapOf(
            "logLevel" to "info",
            "changeLogFile" to "src/main/resources/database/changelog/changelog-${timestamp}.xml",
            "url" to db_url,
            "username" to db_user,
            "password" to db_password,
            "driver" to "com.mysql.cj.jdbc.Driver"
        )
    }
    runList = "main"
}


kapt {
    arguments {
        // Set Mapstruct Configuration options here
        // https://kotlinlang.org/docs/reference/kapt.html#annotation-processor-arguments
        // https://mapstruct.org/documentation/stable/reference/html/#configuration-options
        // arg("mapstruct.defaultComponentModel", "spring")
    }
    correctErrorTypes = true
}
