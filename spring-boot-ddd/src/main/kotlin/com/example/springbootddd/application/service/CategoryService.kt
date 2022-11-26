package com.example.springbootddd.application.service

import com.example.springbootddd.application.dto.CategoryDto
import com.example.springbootddd.application.dto.FilmCategoryDto
import com.example.springbootddd.application.mapper.CategoryMapper
import com.example.springbootddd.application.mapper.FilmCategoryMapper
import com.example.springbootddd.domain.film.CategoryRepository
import com.example.springbootddd.domain.film.FilmCategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    val categoryRepository: CategoryRepository,
    val filmCategoryRepository: FilmCategoryRepository,
    val categoryMapper: CategoryMapper,
    val filmCategoryMapper: FilmCategoryMapper
) {

    fun findByName(name: String): List<FilmCategoryDto> {
        return filmCategoryRepository.findByCategoryName(name)
            .map { filmCategoryMapper.filmCategoryToFilmCategoryDto(it) }
    }
}