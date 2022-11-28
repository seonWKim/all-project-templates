package com.example.springbootddd.adapter.controller;

import com.example.springbootddd.application.dto.CategoryDto;
import com.example.springbootddd.application.dto.FilmCategoryDto;
import com.example.springbootddd.application.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/springbootddd/adapter/controller/CategoryController;", "", "categoryService", "Lcom/example/springbootddd/application/service/CategoryService;", "(Lcom/example/springbootddd/application/service/CategoryService;)V", "getCategoryService", "()Lcom/example/springbootddd/application/service/CategoryService;", "findByName", "Lcom/example/springbootddd/application/dto/CategoryDto;", "name", "", "spring-boot-ddd"})
@org.springframework.web.bind.annotation.RequestMapping(value = {"/category"})
@org.springframework.web.bind.annotation.RestController()
public class CategoryController {
    @org.jetbrains.annotations.NotNull()
    private final com.example.springbootddd.application.service.CategoryService categoryService = null;
    
    public CategoryController(@org.jetbrains.annotations.NotNull()
    com.example.springbootddd.application.service.CategoryService categoryService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.springbootddd.application.service.CategoryService getCategoryService() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{name}"})
    public com.example.springbootddd.application.dto.CategoryDto findByName(@org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.PathVariable()
    java.lang.String name) {
        return null;
    }
}