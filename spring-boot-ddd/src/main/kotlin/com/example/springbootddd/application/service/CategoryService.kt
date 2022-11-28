package com.example.springbootddd.application.service

import com.example.springbootddd.application.dto.CategoryDto
import com.example.springbootddd.application.mapper.CategoryMapper
import com.example.springbootddd.application.mapper.FilmMapper
import com.example.springbootddd.domain.film.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    val categoryRepository: CategoryRepository,
    val categoryMapper: CategoryMapper,
    val filmMapper: FilmMapper
) {

    fun findByName(name: String): CategoryDto? {
        val filmCategories = categoryRepository.findByName(name)
        if (filmCategories.isEmpty()) return null

        val category = categoryMapper.categoryToCategoryDto(filmCategories.first().category!!)
        category.films = filmCategories
            .filter { it.film != null }
            .map { filmMapper.filmToFilmDto(it.film!!) }
        return category
    }
}