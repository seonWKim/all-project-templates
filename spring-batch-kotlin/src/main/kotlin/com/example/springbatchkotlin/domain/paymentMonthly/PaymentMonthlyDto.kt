package com.example.springbatchkotlin.domain.paymentMonthly

import java.io.Serializable
import java.math.BigDecimal

data class PaymentMonthlyDto(var id: Int? = null, var amount: BigDecimal? = null, var targetMonth: String? = null) : Serializable
