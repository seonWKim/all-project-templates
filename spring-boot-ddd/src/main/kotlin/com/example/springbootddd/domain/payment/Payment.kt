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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", columnDefinition = "SMALLINT UNSIGNED not null")
    open var id: Int? = null

    @Column(name = "customer_id", nullable = false)
    open var customerId: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false, insertable = false, updatable = false)
    open var customer: Customer? = null

    @Column(name = "staff_id", nullable = false)
    open var staffId: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id", nullable = false, insertable = false, updatable = false)
    open var staff: Staff? = null

    @Column(name = "rental_id")
    open var rentalId: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id", insertable = false, updatable = false)
    open var rental: Rental? = null

    @Column(name = "amount", nullable = false, precision = 5, scale = 2)
    open var amount: BigDecimal? = null

    @Column(name = "payment_date", nullable = false)
    open var paymentDate: Instant? = null

    @Column(name = "last_update")
    open var lastUpdate: Instant? = null
}