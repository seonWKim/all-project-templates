package com.example.springbootddd.application.dto

import java.io.Serializable
import java.time.Instant

data class StaffDto(
    var id: Short? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var picture: ByteArray? = null,
    var email: String? = null,
    var active: Boolean? = false,
    var username: String? = null,
    var password: String? = null,
    var lastUpdate: Instant? = null
) : Serializable
