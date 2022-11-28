package com.example.springbootddd.domain.film

import org.hibernate.Hibernate
import java.io.Serializable
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "film_actor")
open class FilmActor {
    @EmbeddedId
    open var id: FilmActorId? = null

    @MapsId("actorId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "actor_id", nullable = false)
    open var actor: Actor? = null

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    open var film: Film? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null

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
}