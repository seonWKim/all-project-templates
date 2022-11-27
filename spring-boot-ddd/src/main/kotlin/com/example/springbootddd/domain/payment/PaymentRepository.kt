package com.example.springbootddd.domain.payment;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PaymentRepository : JpaRepository<Payment, Int> {
    @Query(
        """
        select p 
        from Payment p
        join fetch p.customer
        join fetch p.staff
        left join fetch p.rental
        where p.id = :id
        """
    )
    fun findByIdFetchJoin(id: Int): Payment
}