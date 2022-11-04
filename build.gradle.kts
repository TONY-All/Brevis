plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("io.izzel.taboolib") version "1.50"
}

taboolib {
    install("common", "common-5")
    install("platform-bukkit")
    install("module-nms", "module-configuration", "module-lang", "module-chat", "module-kether", "module-metrics")

    version = "6.0.10-17"
    classifier = null

    description {
        description = "Advanced shortcuts"

        dependencies {
            name("PlaceholderAPI").optional(true)
        }

        contributors {
            name("Arasple")
            name("Bkm016").description("TabooLib Devoloper")
        }
    }
}

group = "me.arasple.mc.brevis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.codemc.org/repository/maven-public")
}

dependencies {
    implementation("ink.ptms.core:v11600:11600")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}