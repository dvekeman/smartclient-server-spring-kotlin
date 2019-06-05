import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("plugin.jpa") version "1.3.31"
	id("org.springframework.boot") version "2.1.5.RELEASE"
	id("io.spring.dependency-management") version "1.0.7.RELEASE"
	kotlin("jvm") version "1.3.31"
	kotlin("plugin.spring") version "1.3.31"
    war
}

group = "community.isomorphic"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly = configurations.create("developmentOnly")
configurations {
	developmentOnly
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}

    all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
        exclude(group = "ch.qos.logback")
    }
}

repositories {
	mavenCentral()
    jcenter()
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
    // Isomorphic SmartClient libs copied from
    // [smartclientRuntime/WEB-INF/lib/](https://www.smartclient.com/product/download.jsp)
    implementation(fileTree("src/main/webapp/WEB-INF/lib/") { include("*.jar") } )

    // Spring Boot + Kotlin >>
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.liquibase:liquibase-core")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    // <<

    // javax.servlet-api and jsp-api required by Isomorphic >>
    providedCompile("javax.servlet:javax.servlet-api")
    implementation("javax.servlet.jsp:jsp-api:2.2")
    // <<

    // MariaDB driver >>
    implementation("org.mariadb.jdbc:mariadb-java-client:1.1.8"){
        exclude("net.java.dev.jna")
    }
    implementation("net.java.dev.jna:jna:4.1.0")
    implementation("net.java.dev.jna:jna-platform:4.1.0")
    // <<

    // Test dependencies >>
    // Spring Boot test without junit4
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        exclude(group = "junit", module = "junit")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.3.2")
    // <<
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
