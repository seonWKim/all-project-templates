package com.example.springbootddd.adapter.controller

import com.example.springbootddd.application.dto.PaymentDto
import com.example.springbootddd.application.mapper.PaymentMapper
import com.example.springbootddd.application.service.PaymentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payment")
class PaymentController(
    val paymentService: PaymentService
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): PaymentDto {
        return paymentService.findById(id)
    }

    @PostMapping
    fun save(@RequestBody paymentDto: PaymentDto): PaymentDto {
        return paymentService.save(paymentDto)
    }
}