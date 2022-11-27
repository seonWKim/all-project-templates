package com.example.springbootddd.adapter.controller

import com.example.springbootddd.application.dto.AddressDto
import com.example.springbootddd.application.service.AddressService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/address")
class AddressController(
    private val addressService: AddressService
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): AddressDto {
        return addressService.findById(id)
    }
}