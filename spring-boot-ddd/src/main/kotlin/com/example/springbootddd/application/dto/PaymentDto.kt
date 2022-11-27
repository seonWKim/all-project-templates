package com.example.springbootddd.application.dto

import java.io.Serializable
import java.math.BigDecimal
import java.time.Instant

data class PaymentDto(
    var id: Int? = null,
    var customerId: Int? = null,
    var staffId: Int? = null,
    var rentalId: Int? = null,
    var amount: BigDecimal? = null,
    var paymentDate: Instant? = null,
    var lastUpdate: Instant? = null
) : Serializable
