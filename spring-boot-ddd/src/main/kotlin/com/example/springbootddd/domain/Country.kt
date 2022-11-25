package com.example.springbootddd.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "country")
open class Country {
    @Id
    @Column(name = "country_id", columnDefinition = "SMALLINT UNSIGNED not null")
    open var id: Int? = null

    @Column(name = "country", nullable = false, length = 50)
    open var country: String? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}