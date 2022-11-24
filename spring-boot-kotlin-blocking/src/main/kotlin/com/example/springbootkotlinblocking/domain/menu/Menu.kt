package com.example.springbootkotlinblocking.domain.menu

import com.example.springbootkotlinblocking.domain.store.Store
import java.math.BigDecimal
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "menu")
open class Menu {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    open var store: Store? = null

    @Column(name = "account_id", nullable = false)
    open var accountId: Long? = null

    @Column(name = "name", nullable = false, length = 50)
    open var name: String? = null

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    open var price: BigDecimal? = null

    @Column(name = "category_id", nullable = false)
    open var categoryId: Long? = null

    @Column(name = "description", length = 1000)
    open var description: String? = null

    @Column(name = "img_url", length = 2083)
    open var imgUrl: String? = null

    @Column(name = "created_at", nullable = false)
    open var createdAt: Instant? = null

    @Column(name = "created_by", nullable = false, length = 10)
    open var createdBy: String? = null

    @Column(name = "modified_at", nullable = false)
    open var modifiedAt: Instant? = null

    @Column(name = "modified_by", nullable = false, length = 10)
    open var modifiedBy: String? = null
}