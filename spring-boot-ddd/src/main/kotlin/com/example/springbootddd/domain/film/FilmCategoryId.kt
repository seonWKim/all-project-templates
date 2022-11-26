package com.example.springbootddd.domain.film

import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

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