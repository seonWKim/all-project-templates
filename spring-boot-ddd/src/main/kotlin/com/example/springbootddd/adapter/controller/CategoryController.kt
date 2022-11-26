package com.example.springbootddd.adapter.controller

import com.example.springbootddd.application.dto.CategoryDto
import com.example.springbootddd.application.dto.FilmCategoryDto
import com.example.springbootddd.application.service.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/category")
class CategoryController(val categoryService: CategoryService) {

    @GetMapping("/{name}")
    fun findByName(@PathVariable name: String): CategoryDto? {
        return categoryService.findByName(name)
    }
}