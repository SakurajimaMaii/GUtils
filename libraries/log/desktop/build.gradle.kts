/*
 * Copyright 2021-2024 VastGui
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jetbrains.dokka.gradle.DokkaTaskPartial
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import java.net.URL

plugins {
    kotlin("jvm")
    id("convention.publication")
    id("java-library")
}

group = "io.github.sakurajimamaii"
version = "1.3.7"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

tasks.named<KotlinJvmCompile>("compileKotlin") {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

sourceSets["main"].java.srcDir("src/main/kotlin")

kotlin.sourceSets.all {
    languageSettings.optIn("com.log.vastgui.core.annotation.LogApi")
}

dependencies {
    compileOnly(projects.libraries.kernel)
    compileOnly(projects.libraries.log.core)
    testImplementation(libs.fastjson2)
    testImplementation(libs.fastjson2.kotlin)
    testImplementation(libs.gson)
    testImplementation(libs.jackson.databind)
    testImplementation(libs.junit)
    testImplementation(projects.libraries.kernel)
    testImplementation(projects.libraries.log.core)
}

extra["PUBLISH_ARTIFACT_ID"] = "log-desktop"
extra["PUBLISH_DESCRIPTION"] = "Desktop for log"
extra["PUBLISH_URL"] = "https://github.com/SakurajimaMaii/Android-Vast-Extension/tree/develop/libraries/log/desktop"

val mavenPropertiesFile = File(rootDir, "maven.properties")
if (mavenPropertiesFile.exists()) {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = "io.github.sakurajimamaii"
                artifactId = "log-desktop"
                version = "1.3.7"

                afterEvaluate {
                    from(components["java"])
                }
            }
        }
    }
}

tasks.withType<DokkaTaskPartial> {
    moduleName.set("log-desktop")
    dokkaSourceSets.configureEach {
        sourceLink {
            localDirectory.set(projectDir.resolve("src"))
            remoteUrl.set(URL("https://github.com/SakurajimaMaii/Android-Vast-Extension/blob/develop/libraries/log/desktop/src"))
            remoteLineSuffix.set("#L")
        }
    }
}