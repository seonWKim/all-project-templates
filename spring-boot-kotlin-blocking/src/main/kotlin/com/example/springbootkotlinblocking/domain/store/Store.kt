package com.example.springbootkotlinblocking.domain.store

import com.example.springbootkotlinblocking.domain.account.Account
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "store")
open class Store {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    open var account: Account? = null

    @Column(name = "deleted", nullable = false)
    open var deleted: Boolean? = false

    @Column(name = "name", nullable = false, length = 100)
    open var name: String? = null

    @Column(name = "operating_hours", length = 100)
    open var operatingHours: String? = null

    @Column(name = "description", length = 500)
    open var description: String? = null

    @Column(name = "img_url", length = 2083)
    open var imgUrl: String? = null

    @Column(name = "phone_number", length = 20)
    open var phoneNumber: String? = null

    @Column(name = "facebook_url", length = 2083)
    open var facebookUrl: String? = null

    @Column(name = "instagram_url", length = 2083)
    open var instagramUrl: String? = null

    @Column(name = "email", length = 50)
    open var email: String? = null

    @Column(name = "created_at", nullable = false)
    open var createdAt: Instant? = null

    @Column(name = "created_by", nullable = false, length = 10)
    open var createdBy: String? = null

    @Column(name = "modified_at", nullable = false)
    open var modifiedAt: Instant? = null

    @Column(name = "modified_by", nullable = false, length = 10)
    open var modifiedBy: String? = null

    @Column(name = "story_id")
    open var storyId: Long? = null
}