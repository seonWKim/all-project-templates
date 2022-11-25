package com.example.springbootddd.domain

import org.locationtech.jts.geom.Point
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "address")
open class Address {
    @Id
    @Column(name = "address_id", columnDefinition = "SMALLINT UNSIGNED not null")
    open var id: Int? = null

    @Column(name = "address", nullable = false, length = 50)
    open var address: String? = null

    @Column(name = "address2", length = 50)
    open var address2: String? = null

    @Column(name = "district", nullable = false, length = 20)
    open var district: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    open var city: City? = null

    @Column(name = "postal_code", length = 10)
    open var postalCode: String? = null

    @Column(name = "phone", nullable = false, length = 20)
    open var phone: String? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null

    @Column(name = "location", columnDefinition = "GEOMETRY(65535) not null")
    open var location: Point? = null
}