package com.example.springbootddd.application.service

import com.example.springbootddd.application.dto.CategoryDto
import com.example.springbootddd.application.mapper.CategoryMapper
import com.example.springbootddd.domain.film.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    val categoryRepository: CategoryRepository,
    val mapper: CategoryMapper
) {

    fun findByName(name: String): CategoryDto {
        return mapper.categoryToCategoryDto(categoryRepository.findByName(name))
    }
}