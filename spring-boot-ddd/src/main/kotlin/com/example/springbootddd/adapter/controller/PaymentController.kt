package com.example.springbootddd.adapter.controller

import com.example.springbootddd.application.dto.PaymentDto
import com.example.springbootddd.application.mapper.PaymentMapper
import com.example.springbootddd.application.service.PaymentService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payment")
class PaymentController(
    val paymentService: PaymentService
) {

    @PostMapping
    fun save(@RequestBody paymentDto: PaymentDto): PaymentDto {
        return paymentService.save(paymentDto)
    }
}