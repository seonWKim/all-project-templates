package com.example.springbootddd.application.mapper;

import com.example.springbootddd.application.dto.CategoryDto;
import com.example.springbootddd.domain.film.Category;
import org.mapstruct.*;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0004H\'\u00a8\u0006\n"}, d2 = {"Lcom/example/springbootddd/application/mapper/CategoryMapper;", "", "()V", "categoryDtoToCategory", "Lcom/example/springbootddd/domain/film/Category;", "categoryDto", "Lcom/example/springbootddd/application/dto/CategoryDto;", "categoryToCategoryDto", "category", "updateCategoryFromCategoryDto", "spring-boot-ddd"})
public abstract class CategoryMapper {
    
    public CategoryMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.springbootddd.domain.film.Category categoryDtoToCategory(@org.jetbrains.annotations.NotNull()
    com.example.springbootddd.application.dto.CategoryDto categoryDto);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.springbootddd.application.dto.CategoryDto categoryToCategoryDto(@org.jetbrains.annotations.NotNull()
    com.example.springbootddd.domain.film.Category category);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    public abstract com.example.springbootddd.domain.film.Category updateCategoryFromCategoryDto(@org.jetbrains.annotations.NotNull()
    com.example.springbootddd.application.dto.CategoryDto categoryDto, @org.jetbrains.annotations.NotNull()
    @org.mapstruct.MappingTarget()
    com.example.springbootddd.domain.film.Category category);
}