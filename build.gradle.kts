plugins {
    kotlin("multiplatform") version "2.4.21"
    jacoco
    id("com.diffplug.spotless") version "8.10.4"
}

version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

spotless {
    kotlin {
        target("src/**/*.kt")
        ktlint("1.8.0")
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint("1.8.0")
    }
}

kotlin {
    jvmToolchain(26)
    jvm {
        compilerOptions.jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        testRuns["test"].executionTask.configure { useJUnitPlatform() }
    }
    iosArm64()
    iosSimulatorArm64()
    sourceSets {
        commonMain.dependencies {
            implementation("com.ionspin.kotlin:bignum:0.3.10")
        }
        commonTest.dependencies { implementation(kotlin("test")) }
        jvmTest.dependencies {
            implementation(kotlin("test-junit5"))
            implementation(project.dependencies.platform("org.junit:junit-bom:5.14.0"))
            implementation("org.junit.jupiter:junit-jupiter-engine")
            runtimeOnly("org.junit.platform:junit-platform-launcher")
        }
    }
}

tasks.register("test") { dependsOn("jvmTest") }

jacoco {
    toolVersion = "0.8.15"
}

tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("jvmTest")
    executionData(layout.buildDirectory.file("jacoco/jvmTest.exec"))
    classDirectories.setFrom(layout.buildDirectory.dir("classes/kotlin/jvm/main"))
    sourceDirectories.setFrom(files("src/commonMain/kotlin"))
    reports {
        xml.required = true
        html.required = true
    }
}

tasks.register<JacocoCoverageVerification>("jacocoTestCoverageVerification") {
    dependsOn("jacocoTestReport")
    executionData(layout.buildDirectory.file("jacoco/jvmTest.exec"))
    classDirectories.setFrom(layout.buildDirectory.dir("classes/kotlin/jvm/main"))
    sourceDirectories.setFrom(files("src/commonMain/kotlin"))
    violationRules {
        rule {
            limit {
                counter = "INSTRUCTION"
                minimum = "1.0".toBigDecimal()
            }
            limit {
                counter = "LINE"
                minimum = "1.0".toBigDecimal()
            }
            limit {
                counter = "BRANCH"
                minimum = "1.0".toBigDecimal()
            }
        }
    }
}

tasks.check {
    dependsOn("jacocoTestCoverageVerification")
}
