package com.example.springbootddd.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "city")
open class City {
    @Id
    @Column(name = "city_id", columnDefinition = "SMALLINT UNSIGNED not null")
    open var id: Int? = null

    @Column(name = "city", nullable = false, length = 50)
    open var city: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    open var country: Country? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}