import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


    // JDBC Connections

    // https://mvnrepository.com/artifact/com.oracle.database.jdbc/ucp
    implementation("com.oracle.database.jdbc:ucp:19.10.0.0")
    // https://mvnrepository.com/artifact/com.oracle.database.security/osdt_cert
    implementation("com.oracle.database.security:osdt_cert:19.10.0.0")
    // https://mvnrepository.com/artifact/com.oracle.database.security/osdt_core
    implementation("com.oracle.database.security:osdt_core:19.10.0.0")
    // https://mvnrepository.com/artifact/com.oracle.database.security/oraclepki
    implementation("com.oracle.database.security:oraclepki:19.10.0.0")
    // https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc10
    runtimeOnly("com.oracle.database.jdbc", "ojdbc10", "19.10.0.0")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")



    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
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
