package com.example.springbootddd.domain.film

import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class FilmActorId : Serializable {
    @Column(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED not null")
    open var actorId: Int? = null

    @Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED not null")
    open var filmId: Int? = null

    override fun hashCode(): Int = Objects.hash(actorId, filmId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as FilmActorId

        return actorId == other.actorId &&
                filmId == other.filmId
    }

    companion object {
        private const val serialVersionUID = -5979223520575968494L
    }
}