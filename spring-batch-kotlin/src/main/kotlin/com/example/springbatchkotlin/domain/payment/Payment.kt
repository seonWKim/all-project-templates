package com.example.springbatchkotlin.domain.payment

import java.math.BigDecimal
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "payment")
open class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", columnDefinition = "SMALLINT UNSIGNED not null")
    open var id: Int? = null

    @Column(name = "customer_id")
    open var customerId: Int? = null

    @Column(name = "staff_id")
    open var staffId: Int? = null

    @Column(name = "rental_id")
    open var rentalId: Int? = null

    @Column(name = "amount", nullable = false, precision = 5, scale = 2)
    open var amount: BigDecimal? = null

    @Column(name = "payment_date", nullable = false)
    open var paymentDate: Instant? = null

    @Column(name = "last_update")
    open var lastUpdate: Instant? = null
}