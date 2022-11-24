package com.example.springbootkotlinblocking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinBlockingApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinBlockingApplication>(*args)
}
