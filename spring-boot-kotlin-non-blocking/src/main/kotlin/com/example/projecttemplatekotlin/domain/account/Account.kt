package com.example.projecttemplatekotlin.domain.account

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table(name = "account")
open class Account {
    @Id
    open var id: Long? = null

    @Column(value = "username")
    open var username: String? = null

    @Column(value = "password")
    open var password: String? = null

    @Column(value = "auth_provider")
    open var authProvider: String? = null

    @Column(value = "account_expired")
    open var accountExpired: Boolean? = false

    @Column(value = "account_locked")
    open var accountLocked: Boolean? = false

    @Column(value = "account_locked_at")
    open var accountLockedAt: Instant? = null

    @Column(value = "credential_expired")
    open var credentialExpired: Boolean? = false

    @Column(value = "enabled")
    open var enabled: Boolean? = false

    @Column(value = "value")
    open var value: String? = null

    @Column(value = "description")
    open var description: String? = null

    @Column(value = "tel_enc")
    open var telEnc: String? = null

    @Column(value = "picture_url")
    open var pictureUrl: String? = null

    @Column(value = "email")
    open var email: String? = null

    @Column(value = "authority")
    open var authority: String? = null

    @Column(value = "created_at")
    open var createdAt: Instant? = null

    @Column(value = "created_by")
    open var createdBy: String? = null

    @Column(value = "modified_at")
    open var modifiedAt: Instant? = null

    @Column(value = "modified_by")
    open var modifiedBy: String? = null
}