package com.example.springbatchkotlin.domain.payment

import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service

@Service
@Configuration
class PaymentService(
    val paymentRepository: PaymentRepository
) {


}