plugins {
    java
    id("org.springframework.boot") version "3.1.3" apply(false)
    id("io.spring.dependency-management") version "1.1.3"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    group = "org.asankasi.javaguide"
    version = "1.0.0-SNAPSHOT"

    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    java {
        sourceCompatibility = JavaVersion.VERSION_17
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.mapstruct:mapstruct:1.5.5.Final")
        compileOnly("org.projectlombok:lombok")
        runtimeOnly("org.postgresql:postgresql")
        annotationProcessor("org.projectlombok:lombok")
        annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

//    tasks.register("prepareKotlinBuildScriptModel"){}
}

tasks.withType<Jar> {
    enabled = false
}
