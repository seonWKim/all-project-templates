package com.example.springbootddd.domain.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "film_category")
open class FilmCategory {
    @EmbeddedId
    open var id: FilmCategoryId? = null

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    open var film: Film? = null

    @MapsId("categoryId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties("films")
    open var category: Category? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}