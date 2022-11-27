package com.example.springbootddd.adapter.controller

import com.example.springbootddd.application.dto.PaymentDto
import com.example.springbootddd.application.service.PaymentService
import com.example.springbootddd.domain.payment.Payment
import com.example.springbootddd.domain.payment.PaymentInfo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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

    @GetMapping
    fun selectPage(pageable: Pageable): List<PaymentInfo> {
        return paymentService.findAll(pageable)
    }

    @PostMapping
    fun save(@RequestBody paymentDto: PaymentDto): PaymentDto {
        return paymentService.save(paymentDto)
    }
}