package com.example.springbootkotlinencryption

import com.example.springbootkotlinencryption.config.ApplicationProperties
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
@ConfigurationPropertiesScan
class SpringBootKotlinEncryptionApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinEncryptionApplication>(*args)
}

@Component
class CustomCommandLineRunner(val applicationProperties: ApplicationProperties): CommandLineRunner {
    override fun run(vararg args: String?) {
        println(applicationProperties)
    }
}