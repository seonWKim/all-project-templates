package com.example.springbootddd.domain.film;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FilmCategoryRepository : JpaRepository<FilmCategory, FilmCategoryId> {
    // Use "as" keyword to use for example f.language and f.originalLanguage
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
    fun findByCategoryName(name: String): List<FilmCategory>
}