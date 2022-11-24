package com.example.springbootkotlinblocking.domain.qr

import com.example.springbootkotlinblocking.domain.store.Store
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "qr")
open class Qr {
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

    @Column(name = "description", length = 1000)
    open var description: String? = null

    @Column(name = "created_at", nullable = false)
    open var createdAt: Instant? = null

    @Column(name = "created_by", nullable = false, length = 10)
    open var createdBy: String? = null

    @Column(name = "modified_at", nullable = false)
    open var modifiedAt: Instant? = null

    @Column(name = "modified_by", nullable = false, length = 10)
    open var modifiedBy: String? = null
}