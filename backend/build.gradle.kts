dependencies {
    // ===== implementation / developmentOnly =====
    // Web & Validation
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Dev tools
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Database
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql")
    implementation("org.flywaydb:flyway-core")

    // Redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // Security & Auth
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt-api:${rootProject.extra["jjwtVersion"]}")

    // API Docs
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${rootProject.extra["springdocVersion"]}")

    // AWS IoT
    implementation(platform("software.amazon.awssdk:bom:${rootProject.extra["awsSdkVersion"]}"))
    implementation("software.amazon.awssdk.iotdevicesdk:aws-iot-device-sdk:${rootProject.extra["awsIotDeviceSdkVersion"]}")
    implementation("software.amazon.awssdk.crt:aws-crt:${rootProject.extra["awsCrtVersion"]}")

    // Monitoring & Logging
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("net.logstash.logback:logstash-logback-encoder:${rootProject.extra["logstashVersion"]}")

    // Utilities
    implementation("org.apache.commons:commons-lang3:${rootProject.extra["commonsLangVersion"]}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    // ===== runtimeOnly =====
    runtimeOnly("com.h2database:h2")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:${rootProject.extra["jjwtVersion"]}")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:${rootProject.extra["jjwtVersion"]}")

    // ===== compileOnly =====
    compileOnly("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")

    // ===== annotationProcessor =====
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    // ===== testImplementation =====
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.testcontainers:junit-jupiter:${rootProject.extra["testcontainersVersion"]}")
    testImplementation("org.testcontainers:postgresql:${rootProject.extra["testcontainersVersion"]}")
    testImplementation("org.testcontainers:testcontainers:${rootProject.extra["testcontainersVersion"]}")
}
