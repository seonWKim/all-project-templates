package com.example.springbootddd.application.dto

import java.io.Serializable
import java.time.Instant

data class CustomerDto(
    var id: Int? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var active: Boolean? = false,
    var createDate: Instant? = null,
    var lastUpdate: Instant? = null
) : Serializable
