package com.example.springbootddd.domain

import javax.persistence.*

@Entity
@Table(name = "film_text")
open class FilmText {
    @Id
    @Column(name = "film_id", nullable = false)
    open var id: Short? = null

    @Column(name = "title", nullable = false)
    open var title: String? = null

    @Lob
    @Column(name = "description")
    open var description: String? = null
}