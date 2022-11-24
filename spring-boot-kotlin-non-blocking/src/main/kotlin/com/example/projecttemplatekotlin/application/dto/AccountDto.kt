package com.example.projecttemplatekotlin.application.dto

import java.io.Serializable
import java.time.Instant

data class AccountDto(
    var id: Long? = null,
    var username: String? = null,
    var password: String? = null,
    var authProvider: String? = null,
    var accountExpired: Boolean? = false,
    var accountLocked: Boolean? = false,
    var accountLockedAt: Instant? = null,
    var credentialExpired: Boolean? = false,
    var enabled: Boolean? = false,
    var name: String? = null,
    var description: String? = null,
    var telEnc: String? = null,
    var pictureUrl: String? = null,
    var email: String? = null,
    var authority: String? = null,
    var createdAt: Instant? = null,
    var createdBy: String? = null,
    var modifiedAt: Instant? = null,
    var modifiedBy: String? = null
) : Serializable
