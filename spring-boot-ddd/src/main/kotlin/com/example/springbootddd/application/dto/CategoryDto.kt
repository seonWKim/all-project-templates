package com.example.springbootddd.application.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.time.Instant

data class CategoryDto(
    var id: Short? = null,
    var name: String? = null,
    var lastUpdate: Instant? = null,
    @JsonIgnoreProperties("categories")
    var films: List<FilmDto> = listOf()
) : Serializable
