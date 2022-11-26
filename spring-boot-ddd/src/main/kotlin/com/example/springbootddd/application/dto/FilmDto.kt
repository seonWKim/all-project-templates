package com.example.springbootddd.application.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.math.BigDecimal
import java.time.Instant

data class FilmDto(
    var id: Int? = null,
    var title: String? = null,
    var description: String? = null,
    var releaseYear: Int? = null,
    var language: LanguageDto? = null,
    var originalLanguage: LanguageDto? = null,
    var rentalDuration: Short? = null,
    var rentalRate: BigDecimal? = null,
    var length: Int? = null,
    var replacementCost: BigDecimal? = null,
    var rating: String? = null,
    var specialFeatures: String? = null,
    var lastUpdate: Instant? = null,
    @JsonIgnoreProperties("films")
    var categories: MutableSet<CategoryDto> = mutableSetOf()
) : Serializable
