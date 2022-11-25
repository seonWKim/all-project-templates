package com.example.springbootddd.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "film_category")
open class FilmCategory {
    @EmbeddedId
    open var id: FilmCategoryId? = null

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    open var film: Film? = null

    @MapsId("categoryId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    open var category: Category? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}