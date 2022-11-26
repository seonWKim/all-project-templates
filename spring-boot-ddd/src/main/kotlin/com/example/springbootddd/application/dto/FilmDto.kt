package com.example.springbootddd.application.dto

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
    var categories: MutableSet<CategoryDto> = mutableSetOf()
) : Serializable {
    data class CategoryDto(
        var id: Short? = null,
        var name: String? = null,
        var lastUpdate: Instant? = null,
    ) : Serializable
}
