package com.example.springbootddd.domain

import com.example.springbootddd.domain.address.Address
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "staff")
open class Staff {
    @Id
    @Column(name = "staff_id", columnDefinition = "TINYINT UNSIGNED not null")
    open var id: Short? = null

    @Column(name = "first_name", nullable = false, length = 45)
    open var firstName: String? = null

    @Column(name = "last_name", nullable = false, length = 45)
    open var lastName: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    open var address: Address? = null

    @Column(name = "picture")
    open var picture: ByteArray? = null

    @Column(name = "email", length = 50)
    open var email: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    open var store: Store? = null

    @Column(name = "active", nullable = false)
    open var active: Boolean? = false

    @Column(name = "username", nullable = false, length = 16)
    open var username: String? = null

    @Column(name = "password", length = 40)
    open var password: String? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}