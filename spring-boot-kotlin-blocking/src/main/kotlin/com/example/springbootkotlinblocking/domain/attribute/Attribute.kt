package com.example.springbootkotlinblocking.domain.attribute

import com.example.springbootkotlinblocking.domain.menu.Menu
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "attribute")
open class Attribute {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    open var menu: Menu? = null

    @Column(name = "account_id", nullable = false)
    open var accountId: Long? = null

    @Column(name = "name", nullable = false, length = 100)
    open var name: String? = null

    @Column(name = "rating", nullable = false)
    open var rating: Int? = null

    @Column(name = "created_at", nullable = false)
    open var createdAt: Instant? = null

    @Column(name = "created_by", nullable = false, length = 10)
    open var createdBy: String? = null

    @Column(name = "modified_at", nullable = false)
    open var modifiedAt: Instant? = null

    @Column(name = "modified_by", nullable = false, length = 10)
    open var modifiedBy: String? = null
}