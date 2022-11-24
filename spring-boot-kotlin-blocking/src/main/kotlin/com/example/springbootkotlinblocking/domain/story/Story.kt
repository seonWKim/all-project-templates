package com.example.springbootkotlinblocking.domain.story

import com.example.springbootkotlinblocking.domain.store.Store
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "story")
open class Story {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    open var store: Store? = null

    @Column(name = "account_id", nullable = false)
    open var accountId: Long? = null

    @Column(name = "title", nullable = false, length = 100)
    open var title: String? = null

    @Column(name = "subtitle", length = 100)
    open var subtitle: String? = null

    @Column(name = "description", length = 1002)
    open var description: String? = null

    @Column(name = "img_url", length = 2083)
    open var imgUrl: String? = null

    @Column(name = "active", nullable = false)
    open var active: Boolean? = false

    @Column(name = "created_at", nullable = false)
    open var createdAt: Instant? = null

    @Column(name = "created_by", nullable = false, length = 10)
    open var createdBy: String? = null

    @Column(name = "modified_at", nullable = false)
    open var modifiedAt: Instant? = null

    @Column(name = "modified_by", nullable = false, length = 10)
    open var modifiedBy: String? = null
}