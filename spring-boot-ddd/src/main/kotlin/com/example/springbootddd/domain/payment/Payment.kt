package com.example.springbootddd.domain.payment

import com.example.springbootddd.domain.customer.Customer
import com.example.springbootddd.domain.rental.Rental
import com.example.springbootddd.domain.staff.Staff
import java.math.BigDecimal
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "payment")
open class Payment {
    @Id
    @Column(name = "payment_id", columnDefinition = "SMALLINT UNSIGNED not null")
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    open var customer: Customer? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    open var staff: Staff? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    open var rental: Rental? = null

    @Column(name = "amount", nullable = false, precision = 5, scale = 2)
    open var amount: BigDecimal? = null

    @Column(name = "payment_date", nullable = false)
    open var paymentDate: Instant? = null

    @Column(name = "last_update")
    open var lastUpdate: Instant? = null
}