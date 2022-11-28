package com.example.springbatchkotlin.domain.paymentMonthly

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "payment_monthly")
open class PaymentMonthly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "amount", nullable = false, precision = 9, scale = 2)
    open var amount: BigDecimal? = null

    @Column(name = "target_month", nullable = false, length = 10)
    open var targetMonth: String? = null
}