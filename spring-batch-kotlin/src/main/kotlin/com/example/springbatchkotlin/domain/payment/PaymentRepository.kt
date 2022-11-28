package com.example.springbatchkotlin.domain.payment;

import com.example.springbatchkotlin.domain.payment.Payment
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository : JpaRepository<Payment, Int> {
}