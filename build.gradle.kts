plugins {
	java
	id("org.springframework.boot") version "3.1.3"
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
		implementation("org.springframework.boot:spring-boot-starter-amqp")
		implementation("org.springframework.boot:spring-boot-starter-web")
		compileOnly("org.projectlombok:lombok")
		annotationProcessor("org.projectlombok:lombok")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.register("prepareKotlinBuildScriptModel"){}
}

tasks.withType<Jar> {
	enabled = false
}


