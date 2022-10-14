plugins {
    base
    java
    application
    id ("org.springframework.boot") version "2.7.4" apply false
    id ("io.spring.dependency-management") version "1.0.14.RELEASE" apply false
}

group = "br.com.queiroz"
version = "0.0.1-SNAPSHOT"

if (org.gradle.api.JavaVersion.current() != org.gradle.api.JavaVersion.VERSION_17){
    error(
        """
				=======================================
				RUM WITH JAVA 17
				=======================================
			""".trimIndent()
    )
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":cat-api-common"))
    implementation("org.modelmapper:modelmapper:3.1.0")
    testImplementation("com.squareup.okhttp3:mockwebserver")
    testImplementation("com.squareup.okhttp3:okhttp")

    //mysql
    implementation("mysql:mysql-connector-java")

    //Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    //actuator
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.7.4")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}