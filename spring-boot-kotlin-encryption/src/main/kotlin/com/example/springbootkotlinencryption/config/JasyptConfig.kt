package com.example.springbootkotlinencryption

import com.example.springbootkotlinencryption.config.ApplicationProperties
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor

@Configuration
@EnableEncryptableProperties
class JasyptConfigAES(val applicationProperties: ApplicationProperties) {
    @Bean("jasyptEncryptor")
    fun stringEncryptor(): StringEncryptor {
        val encryptor = PooledPBEStringEncryptor()
        encryptor.setProvider(BouncyCastleProvider())
        encryptor.setPoolSize(2)
        encryptor.setPassword(applicationProperties.jasyptPassword)
        encryptor.setAlgorithm("PBEWithSHA256And128BitAES-CBC-BC")
        return encryptor
    }
}