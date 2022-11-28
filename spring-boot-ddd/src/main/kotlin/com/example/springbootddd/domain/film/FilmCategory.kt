package com.example.springbootddd.domain.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.Hibernate
import java.io.Serializable
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "film_category")
open class FilmCategory {
    @EmbeddedId
    open var id: FilmCategoryId? = null

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    @JsonIgnoreProperties("categories")
    open var film: Film? = null

    @MapsId("categoryId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties("films")
    open var category: Category? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null

    @Embeddable
    open class FilmCategoryId : Serializable {
        @Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED not null")
        open var filmId: Int? = null

        @Column(name = "category_id", columnDefinition = "TINYINT UNSIGNED not null")
        open var categoryId: Short? = null

        override fun hashCode(): Int = Objects.hash(filmId, categoryId)
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

            other as FilmCategoryId

            return filmId == other.filmId &&
                    categoryId == other.categoryId
        }

        companion object {
            private const val serialVersionUID = 2189030900042729598L
        }
    }
}