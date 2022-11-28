package com.example.springbootddd.domain.payment

import java.math.BigDecimal
import java.time.Instant

interface PaymentInfo {
    val customerId: Int?
    val staffId: Int?
    val rentalId: Int?
    val amount: BigDecimal?
    val paymentDate: Instant?
    val lastUpdate: Instant?
}