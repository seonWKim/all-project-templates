package com.example.springbootddd.application.dto

import java.io.Serializable
import java.time.Instant

data class LanguageDto(
    var id: Short? = null,
    var name: String? = null,
    var lastUpdate: Instant? = null
) : Serializable
