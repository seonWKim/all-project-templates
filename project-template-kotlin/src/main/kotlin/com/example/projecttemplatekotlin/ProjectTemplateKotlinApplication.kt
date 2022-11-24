package com.example.projecttemplatekotlin

import org.springframework.boot.actuate.trace.http.HttpTraceRepository
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@SpringBootApplication
class ProjectTemplateKotlinApplication

fun main(args: Array<String>) {
    runApplication<ProjectTemplateKotlinApplication>(*args)
}

@Configuration // @Profile("actuator-endpoints")
// if you want: register bean only if profile is set
class HttpTraceActuatorConfiguration {
    @Bean
    fun httpTraceRepository(): HttpTraceRepository {
        return InMemoryHttpTraceRepository()
    }
}