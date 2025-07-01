plugins {
    id("fabric-loom") version "1.2-SNAPSHOT"
}

group = "com.chatgpt"
version = "1.0.0"
base {
    archivesName.set("inventory-full-alert")
}

minecraft {
    version("1.20.1")
    mappings("intermediary", "1.20.1")
    loader("0.14.21")
}

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:1.20.1")
    modImplementation("net.fabricmc:fabric-loader:0.14.21")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.87.0+1.20.1")
}
