package com.example.springbootddd.application.dto

import java.io.Serializable
import java.time.Instant

data class CountryDto(var id: Int? = null,
                      var country: String? = null,
                      var lastUpdate: Instant? = null) : Serializable
