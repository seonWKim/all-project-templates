package com.example.springbootddd.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "actor")
open class Actor {
    @Id
    @Column(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED not null")
    open var id: Int? = null

    @Column(name = "first_name", nullable = false, length = 45)
    open var firstName: String? = null

    @Column(name = "last_name", nullable = false, length = 45)
    open var lastName: String? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}