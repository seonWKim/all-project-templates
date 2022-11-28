package com.example.springbootddd.application.dto

import java.io.Serializable
import java.time.Instant

data class CityDto(var id: Int? = null,
                   var city: String? = null,
                   var country: CountryDto? = null,
                   var lastUpdate: Instant? = null) : Serializable
