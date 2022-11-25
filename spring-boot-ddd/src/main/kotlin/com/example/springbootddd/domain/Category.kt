package com.example.springbootddd.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "category")
open class Category {
    @Id
    @Column(name = "category_id", columnDefinition = "TINYINT UNSIGNED not null")
    open var id: Short? = null

    @Column(name = "name", nullable = false, length = 25)
    open var name: String? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}