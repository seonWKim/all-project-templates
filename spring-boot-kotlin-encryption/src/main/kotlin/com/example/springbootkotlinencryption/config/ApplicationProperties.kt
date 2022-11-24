package com.example.springbootkotlinencryption.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "application")
data class ApplicationProperties(
    val profile: Profile,
    val credential: Credential,
    val jasyptPassword: String
) {
    data class Profile(
        val name: String,
        val email: String
    )

    data class Credential(
        val password: String
    )
}