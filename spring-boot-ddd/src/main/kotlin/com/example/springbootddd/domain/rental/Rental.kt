package com.example.springbootddd.domain.rental

import com.example.springbootddd.domain.inventory.Inventory
import com.example.springbootddd.domain.staff.Staff
import com.example.springbootddd.domain.customer.Customer
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "rental")
open class Rental {
    @Id
    @Column(name = "rental_id", nullable = false)
    open var id: Int? = null

    @Column(name = "rental_date", nullable = false)
    open var rentalDate: Instant? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventory_id", nullable = false)
    open var inventory: Inventory? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    open var customer: Customer? = null

    @Column(name = "return_date")
    open var returnDate: Instant? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    open var staff: Staff? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}