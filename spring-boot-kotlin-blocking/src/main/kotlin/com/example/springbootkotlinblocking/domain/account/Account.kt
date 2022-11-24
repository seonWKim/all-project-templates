package com.example.springbootkotlinblocking.domain.account

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "account")
open class Account {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "username", nullable = false, length = 100)
    open var username: String? = null

    @Column(name = "password", length = 200)
    open var password: String? = null

    @Column(name = "auth_provider", nullable = false, length = 20)
    open var authProvider: String? = null

    @Column(name = "account_expired", nullable = false)
    open var accountExpired: Boolean? = false

    @Column(name = "account_locked", nullable = false)
    open var accountLocked: Boolean? = false

    @Column(name = "account_locked_at")
    open var accountLockedAt: Instant? = null

    @Column(name = "credential_expired", nullable = false)
    open var credentialExpired: Boolean? = false

    @Column(name = "enabled", nullable = false)
    open var enabled: Boolean? = false

    @Column(name = "name", length = 50)
    open var name: String? = null

    @Column(name = "description", length = 100)
    open var description: String? = null

    @Column(name = "tel_enc", length = 30)
    open var telEnc: String? = null

    @Column(name = "picture_url", length = 300)
    open var pictureUrl: String? = null

    @Column(name = "email", length = 30)
    open var email: String? = null

    @Column(name = "authority", length = 10)
    open var authority: String? = null

    @Column(name = "created_at", nullable = false)
    open var createdAt: Instant? = null

    @Column(name = "created_by", nullable = false, length = 10)
    open var createdBy: String? = null

    @Column(name = "modified_at", nullable = false)
    open var modifiedAt: Instant? = null

    @Column(name = "modified_by", nullable = false, length = 10)
    open var modifiedBy: String? = null
}