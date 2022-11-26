package com.example.springbootddd.domain.film

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface FilmRepository : JpaRepository<Film, Long> {
    fun findByTitle(title: String): List<Film>
}