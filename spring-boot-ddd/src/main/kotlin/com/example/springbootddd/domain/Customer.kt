package com.example.springbootddd.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "customer")
open class Customer {
    @Id
    @Column(name = "customer_id", columnDefinition = "SMALLINT UNSIGNED not null")
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    open var store: Store? = null

    @Column(name = "first_name", nullable = false, length = 45)
    open var firstName: String? = null

    @Column(name = "last_name", nullable = false, length = 45)
    open var lastName: String? = null

    @Column(name = "email", length = 50)
    open var email: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    open var address: Address? = null

    @Column(name = "active", nullable = false)
    open var active: Boolean? = false

    @Column(name = "create_date", nullable = false)
    open var createDate: Instant? = null

    @Column(name = "last_update")
    open var lastUpdate: Instant? = null
}