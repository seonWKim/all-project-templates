package com.example.springbootddd.application.dto

import org.locationtech.jts.geom.Point
import java.io.Serializable
import java.time.Instant

data class AddressDto(
    var id: Int? = null,
    var address: String? = null,
    var address2: String? = null,
    var district: String? = null,
    var city: CityDto? = null,
    var postalCode: String? = null,
    var phone: String? = null,
    var lastUpdate: Instant? = null,
    var location: Point? = null
) : Serializable
