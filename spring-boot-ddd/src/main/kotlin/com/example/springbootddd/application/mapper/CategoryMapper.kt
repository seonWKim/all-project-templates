package com.example.springbootddd.application.mapper

import com.example.springbootddd.application.dto.CategoryDto
import com.example.springbootddd.domain.film.Category
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class CategoryMapper {

    abstract fun categoryDtoToCategory(categoryDto: CategoryDto): Category

    abstract fun categoryToCategoryDto(category: Category): CategoryDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun updateCategoryFromCategoryDto(categoryDto: CategoryDto, @MappingTarget category: Category): Category
}