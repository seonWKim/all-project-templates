package com.example.springbatchkotlin.domain.paymentMonthly;

import com.example.springbatchkotlin.domain.paymentMonthly.PaymentMonthly
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentMonthlyRepository : JpaRepository<PaymentMonthly, Int> {
}