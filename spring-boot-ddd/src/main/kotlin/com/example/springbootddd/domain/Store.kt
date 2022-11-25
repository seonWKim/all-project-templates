package com.example.springbootddd.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "store")
open class Store {
    @Id
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED not null")
    open var id: Short? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    open var managerStaff: Staff? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    open var address: Address? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}