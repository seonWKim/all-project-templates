package com.example.springbootddd.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "film_actor")
open class FilmActor {
    @EmbeddedId
    open var id: FilmActorId? = null

    @MapsId("actorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actor_id", nullable = false)
    open var actor: Actor? = null

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    open var film: Film? = null

    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}