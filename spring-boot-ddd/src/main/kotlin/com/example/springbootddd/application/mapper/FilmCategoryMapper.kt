package com.example.springbootddd.application.mapper

import com.example.springbootddd.application.dto.FilmCategoryDto
import com.example.springbootddd.domain.film.FilmCategory
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class FilmCategoryMapper {

    abstract fun filmCategoryDtoToFilmCategory(filmCategoryDto: FilmCategoryDto): FilmCategory

    abstract fun filmCategoryToFilmCategoryDto(filmCategory: FilmCategory): FilmCategoryDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun updateFilmCategoryFromFilmCategoryDto(
        filmCategoryDto: FilmCategoryDto,
        @MappingTarget filmCategory: FilmCategory
    ): FilmCategory
}