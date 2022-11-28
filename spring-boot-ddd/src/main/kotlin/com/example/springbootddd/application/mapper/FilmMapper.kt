package com.example.springbootddd.application.mapper

import com.example.springbootddd.application.dto.FilmDto
import com.example.springbootddd.domain.film.Film
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class FilmMapper {

    abstract fun filmDtoToFilm(filmDto: FilmDto): Film

    abstract fun filmToFilmDto(film: Film): FilmDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun updateFilmFromFilmDto(filmDto: FilmDto, @MappingTarget film: Film): Film
}