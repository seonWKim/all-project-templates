package com.example.springbootddd.application.service;

import com.example.springbootddd.application.dto.CategoryDto;
import com.example.springbootddd.application.mapper.CategoryMapper;
import com.example.springbootddd.application.mapper.FilmMapper;
import com.example.springbootddd.domain.film.CategoryRepository;
import org.springframework.stereotype.Service;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/example/springbootddd/application/service/CategoryService;", "", "categoryRepository", "Lcom/example/springbootddd/domain/film/CategoryRepository;", "categoryMapper", "Lcom/example/springbootddd/application/mapper/CategoryMapper;", "filmMapper", "Lcom/example/springbootddd/application/mapper/FilmMapper;", "(Lcom/example/springbootddd/domain/film/CategoryRepository;Lcom/example/springbootddd/application/mapper/CategoryMapper;Lcom/example/springbootddd/application/mapper/FilmMapper;)V", "getCategoryMapper", "()Lcom/example/springbootddd/application/mapper/CategoryMapper;", "getCategoryRepository", "()Lcom/example/springbootddd/domain/film/CategoryRepository;", "getFilmMapper", "()Lcom/example/springbootddd/application/mapper/FilmMapper;", "findByName", "Lcom/example/springbootddd/application/dto/CategoryDto;", "name", "", "spring-boot-ddd"})
@org.springframework.stereotype.Service()
public class CategoryService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.springbootddd.domain.film.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.springbootddd.application.mapper.CategoryMapper categoryMapper = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.springbootddd.application.mapper.FilmMapper filmMapper = null;
    
    public CategoryService(@org.jetbrains.annotations.NotNull()
    com.example.springbootddd.domain.film.CategoryRepository categoryRepository, @org.jetbrains.annotations.NotNull()
    com.example.springbootddd.application.mapper.CategoryMapper categoryMapper, @org.jetbrains.annotations.NotNull()
    com.example.springbootddd.application.mapper.FilmMapper filmMapper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.springbootddd.domain.film.CategoryRepository getCategoryRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.springbootddd.application.mapper.CategoryMapper getCategoryMapper() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.springbootddd.application.mapper.FilmMapper getFilmMapper() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.springbootddd.application.dto.CategoryDto findByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
}