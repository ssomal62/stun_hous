plugins {
    java
    id("org.springframework.boot") version "3.5.4" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
}

allprojects {
    group = "com.stun_hous"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    extra["jjwtVersion"] = "0.12.3"
    extra["springdocVersion"] = "2.2.0"
    extra["awsSdkVersion"] = "2.25.0"
    extra["awsCrtVersion"] = "0.29.12"
    extra["awsIotDeviceSdkVersion"] = "1.0.3"
    extra["logstashVersion"] = "7.4"
    extra["commonsLangVersion"] = "3.14.0"
    extra["testcontainersVersion"] = "1.19.3"
}

subprojects {
    if (project.name == "backend") {
        apply(plugin = "java")
        apply(plugin = "org.springframework.boot")
        apply(plugin = "io.spring.dependency-management")

        java {
            toolchain {
                languageVersion = JavaLanguageVersion.of(21)
            }
        }

        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }
}
