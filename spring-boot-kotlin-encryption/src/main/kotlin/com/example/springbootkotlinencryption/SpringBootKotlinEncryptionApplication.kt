package com.example.springbootkotlinencryption

import com.example.springbootkotlinencryption.config.ApplicationProperties
import org.jasypt.encryption.StringEncryptor
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
@ConfigurationPropertiesScan
class SpringBootKotlinEncryptionApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinEncryptionApplication>(*args)
}

@Component
class CustomCommandLineRunner(
    val applicationProperties: ApplicationProperties,
    val encryptor: StringEncryptor
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println(applicationProperties)

        val str = "hello world"
        val encrypted = encryptor.encrypt(str)
        println(encrypted)
        val decrypted = encryptor.decrypt(encrypted)
        println(decrypted)
    }
}