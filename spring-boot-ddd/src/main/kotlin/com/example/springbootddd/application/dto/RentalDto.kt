package com.example.springbootddd.application.dto

import java.io.Serializable
import java.time.Instant

data class RentalDto(var id: Int? = null, var rentalDate: Instant? = null, var returnDate: Instant? = null, var lastUpdate: Instant? = null) : Serializable
