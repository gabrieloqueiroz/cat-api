import org.gradle.api.JavaVersion.VERSION_17
import org.gradle.api.JavaVersion.current


plugins {
	base
	java
	application
	id ("org.springframework.boot") version "2.7.4" apply false
	id ("io.spring.dependency-management") version "1.0.14.RELEASE" apply false
}

group = "br.com.queiroz"
version = "0.0.1-SNAPSHOT"

if (current() != VERSION_17){
	error(
			"""
				=======================================
				RUM WITH JAVA 17
				=======================================
			""".trimIndent()
	)
}

subprojects{
if(name == "services" || name == "library"){
		return@subprojects
	}

	buildscript {
		repositories {
			mavenCentral()
		}
		dependencies {
			classpath("org.springframework.boot:spring-boot-gradle-plugin:2.4.2")
		}
	}

	repositories {
		mavenCentral()
	}

	if("${project.projectDir}".contains("services")) {
		apply(plugin = "java")
		apply(plugin = "application")
		apply(plugin = "org.springframework.boot")
		apply(plugin = "io.spring.dependency-management")

		dependencies {
			implementation(project(":cat-api-common"))
			implementation("org.modelmapper:modelmapper:3.1.0")

			//Spring
			implementation("org.springframework.boot:spring-boot-starter-web")
			implementation("org.springframework.boot:spring-boot-devtools")
			implementation("org.springframework.boot:spring-boot-starter-data-jpa")
			implementation("org.springframework.boot:spring-boot-starter-webflux")
			testImplementation("org.springframework.boot:spring-boot-starter-test")

			//Lombok
			compileOnly("org.projectlombok:lombok")
			annotationProcessor("org.projectlombok:lombok")

			//H2
			runtimeOnly("com.h2database:h2")
		}

		tasks.test{
			useJUnitPlatform()
		}
	}

	if("${project.projectDir}".contains("library")) {
		apply(plugin = "java-library")
		apply(plugin = "org.springframework.boot")
		apply(plugin = "io.spring.dependency-management")

		tasks.test{
			ignoreFailures= true
		}
	}
}