package com.example.springbootssl.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/example")
class ExampleController {

    @GetMapping
    fun example(): String {
        return "hello"
    }
}