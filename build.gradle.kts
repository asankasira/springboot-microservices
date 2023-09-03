plugins {
    java
    id("org.springframework.boot") version "3.1.3" apply(false)
    id("io.spring.dependency-management") version "1.1.3"
}

extra["springCloudVersion"] = "2022.0.4"
extra["mapStructVersion"] = "1.5.5.Final"
extra["springDocVersion"] = "2.2.0"

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
        val mapStructVersion: String by project
        implementation(enforcedPlatform("org.mapstruct:mapstruct:$mapStructVersion"))
        implementation(platform("org.springdoc:springdoc-openapi-starter-webmvc-ui:${property("springDocVersion")}"))
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.register("prepareKotlinBuildScriptModel"){}
}

tasks.withType<Jar> {
    enabled = false
}
