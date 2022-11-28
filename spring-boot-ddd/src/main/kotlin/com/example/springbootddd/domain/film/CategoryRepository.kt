package com.example.springbootddd.domain.film

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {
    @Query(
        """
            select fc
            from FilmCategory fc
            join fetch fc.category
            join fetch fc.film as f
            join fetch f.language 
            left join fetch f.originalLanguage
            where fc.category.name = :name
        """
    )
    fun findByName(name: String): List<FilmCategory>
}