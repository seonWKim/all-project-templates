package com.example.springbootddd.domain.inventory

import com.example.springbootddd.domain.film.Film
import com.example.springbootddd.domain.store.Store
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "inventory")
open class Inventory {
    @Id
    @Column(name = "inventory_id", nullable = false)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    open var film: Film? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    open var store: Store? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}