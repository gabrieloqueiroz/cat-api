plugins {
    base
    java
    application
    id ("org.springframework.boot") version "2.7.4" apply false
    id ("io.spring.dependency-management") version "1.0.14.RELEASE" apply false
}

if (org.gradle.api.JavaVersion.current() != org.gradle.api.JavaVersion.VERSION_17){
    error(
        """
				=======================================
				RUM WITH JAVA 17
				=======================================
			""".trimIndent()
    )
}

group = "br.com.queiroz"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}